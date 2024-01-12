package com.arthurtalles.processoapi.departamento.controller;


import com.arthurtalles.processoapi.departamento.dto.DepartamentoResponseDTO;
import com.arthurtalles.processoapi.departamento.repository.DepartamentoRepository;
import com.arthurtalles.processoapi.pessoas.repository.PessoasRepository;
import com.arthurtalles.processoapi.tarefas.repository.TarefasRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {


    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private TarefasRepository tarefasRepository;

    @Autowired
    private PessoasRepository pessoasRepository;

    @GetMapping
    public JsonObject departamento(){

        JsonObject response = new JsonObject();
        JsonArray departamentos = new JsonArray();
        List<DepartamentoResponseDTO> listaDepartamento = departamentoRepository.findAll().stream().map(DepartamentoResponseDTO::new).toList();
        for (DepartamentoResponseDTO departamentoResponseDTO : listaDepartamento) {
            Integer pessoas = pessoasRepository.findAllByDepartamentoId(departamentoResponseDTO.id()).size();
            Integer tarefas = tarefasRepository.findAllByDepartamentoId(departamentoResponseDTO.id()).size();

            JsonObject departamento = new JsonObject();

            departamento.addProperty("id", departamentoResponseDTO.id());
            departamento.addProperty("departamento", departamentoResponseDTO.titulo());
            departamento.addProperty("pessoas", pessoas);
            departamento.addProperty("tarefas", tarefas);

            departamentos.add(departamento);
        }

        response.add("departamentos", departamentos);
        return response;


    }

}
