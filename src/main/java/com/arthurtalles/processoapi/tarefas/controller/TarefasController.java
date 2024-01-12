package com.arthurtalles.processoapi.tarefas.controller;


import com.arthurtalles.processoapi.pessoas.dto.PessoasDTO;
import com.arthurtalles.processoapi.pessoas.dto.PessoasIdDTO;
import com.arthurtalles.processoapi.pessoas.model.Pessoas;
import com.arthurtalles.processoapi.pessoas.repository.PessoasRepository;
import com.arthurtalles.processoapi.tarefas.dto.TarefasDTO;
import com.arthurtalles.processoapi.tarefas.dto.TarefasResponseDTO;
import com.arthurtalles.processoapi.tarefas.model.Tarefas;
import com.arthurtalles.processoapi.tarefas.repository.TarefasRepository;
import com.google.gson.JsonObject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefasRepository tarefasRepository;

    @Autowired
    private PessoasRepository pessoasRepository;

    @PostMapping
    public void addTarefa(@RequestBody @Valid TarefasDTO data){

        Tarefas tarefasData = new Tarefas(data);
        tarefasRepository.save(tarefasData);
    }

    @GetMapping
    public List<TarefasResponseDTO> buscarTarefa(){

        List<TarefasResponseDTO> listaTarefas = tarefasRepository.findAll().stream().map(TarefasResponseDTO::new).toList();
        return listaTarefas;
    }

    @PutMapping("/alocar/{tarefaId}")
    public ResponseEntity<String> alocarPessoaNaTarefa(@PathVariable(value = "tarefaId") Integer tarefaId,@RequestBody PessoasIdDTO pessoaDTO) {

        Optional<Pessoas> pessoaOptional = pessoasRepository.findById(pessoaDTO.pessoa_id());

        Optional<Tarefas> tarefaOptional = tarefasRepository.findById(tarefaId);

        if (pessoaOptional.isPresent() && tarefaOptional.isPresent()) {
            Pessoas pessoa = pessoaOptional.get();
            Tarefas tarefa = tarefaOptional.get();

            if (pessoa.getDepartamentoId().equals(tarefa.getDepartamentoId())) {
                tarefa.setPessoasId(pessoa.getId());
                tarefasRepository.save(tarefa);

                return ResponseEntity.ok("Pessoa alocada com sucesso na tarefa!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Departamentos diferentes. Não é possível alocar.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa ou tarefa não encontrada.");
        }
    }

    @PutMapping("/finalizar/{tarefaId}")
    public ResponseEntity<String> finalizarTarefa(@PathVariable(value = "tarefaId") Integer tarefaId){

        // Obtém a tarefa do repositório pelo ID (assumindo que há um método findById no seu repositório)
        Optional<Tarefas> tarefaOptional = tarefasRepository.findById(tarefaId);

        // Verifica se a tarefa existe antes de tentar finalizá-la
        if (tarefaOptional.isPresent()) {
            Tarefas tarefa = tarefaOptional.get();

            if (tarefa.getFinalizado()) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tarefa já finalizada!");
            } else {

                // Atualiza o status 'finalizado' para true
                tarefa.setFinalizado(true);

                // Salva a tarefa atualizada de volta no repositório
                tarefasRepository.save(tarefa);
                return ResponseEntity.ok("Tarefa finalizada com sucesso!");
            }

            } else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
            }

    }

}
