package com.arthurtalles.processoapi.tarefas.dto;

import com.arthurtalles.processoapi.pessoas.model.Pessoas;

import java.time.LocalDate;

public record TarefasDTO(Integer id, String titulo , String descricao, Integer departamentoId, LocalDate prazo, Integer duracao, Integer pessoasId, Boolean finalizado) {
}
