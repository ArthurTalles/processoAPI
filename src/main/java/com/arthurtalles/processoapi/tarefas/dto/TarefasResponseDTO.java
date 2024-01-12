package com.arthurtalles.processoapi.tarefas.dto;

import com.arthurtalles.processoapi.pessoas.model.Pessoas;
import com.arthurtalles.processoapi.tarefas.model.Tarefas;

import java.time.LocalDate;

public record TarefasResponseDTO(Integer id, String titulo, String descricao, Integer departamentoId, LocalDate prazo, Integer duracao, Integer pessoasId, Boolean finalizado) {

    public TarefasResponseDTO(Tarefas tarefas){
        this(tarefas.getId(),tarefas.getTitulo(),tarefas.getDescricao(),tarefas.getDepartamentoId(),tarefas.getPrazo(), tarefas.getDuracao(),tarefas.getPessoasId(), tarefas.getFinalizado());
    }
}
