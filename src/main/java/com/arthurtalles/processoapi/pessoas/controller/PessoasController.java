package com.arthurtalles.processoapi.pessoas.controller;


import com.arthurtalles.processoapi.departamento.repository.DepartamentoRepository;
import com.arthurtalles.processoapi.pessoas.dto.PessoasDTO;
import com.arthurtalles.processoapi.pessoas.dto.PessoasResponseDTO;
import com.arthurtalles.processoapi.pessoas.model.Pessoas;
import com.arthurtalles.processoapi.pessoas.repository.PessoasRepository;
import com.arthurtalles.processoapi.tarefas.model.Tarefas;
import com.arthurtalles.processoapi.tarefas.repository.TarefasRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoasRepository pessoasRepository;

    @Autowired
    private TarefasRepository tarefasRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @PostMapping
    public void addPessoa(@RequestBody @Valid PessoasDTO data){

        Pessoas pessoasData = new Pessoas(data);
        pessoasRepository.save(pessoasData);
    }

    @GetMapping
    public JsonObject listarPessoasComDetalhes() {

        List<Pessoas> pessoas = pessoasRepository.findAll();

        JsonObject response = new JsonObject();
        JsonArray pessoasAll = new JsonArray();

        for(int x = 0; x < pessoas.size(); x++){
            String departamento = departamentoRepository.findById(pessoas.get(x).getDepartamentoId()).get().getTitulo();
            List<Tarefas> tarefas = tarefasRepository.findAllByDepartamentoId(pessoas.get(x).getId());

            Integer tempo = 0;
            for (int a = 0; a < tarefas.size(); a++){
                if (tarefas.get(x).getFinalizado()) {

                    tempo += tarefas.get(x).getDuracao();

                }

            }

            JsonObject pessoa = new JsonObject();
            pessoa.addProperty("nome", pessoas.get(x).getNome());
            pessoa.addProperty("departamento", departamento);
            pessoa.addProperty("tempo_gasto", tempo);

            pessoasAll.add(pessoa);


        }

        response.add("pessoas", pessoasAll);

        return response;
    }


    @DeleteMapping
    public void deletaPessoa(@RequestBody @Valid PessoasDTO data){

        Pessoas pessoasData = new Pessoas(data);
        pessoasRepository.delete(pessoasData);
    }

    @PutMapping
    public void alteraPessoa(@RequestBody @Valid PessoasDTO data){

        Pessoas pessoasData = new Pessoas(data);
        pessoasRepository.save(pessoasData);
    }

}
