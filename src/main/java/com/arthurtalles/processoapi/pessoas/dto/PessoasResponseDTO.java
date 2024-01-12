package com.arthurtalles.processoapi.pessoas.dto;

import com.arthurtalles.processoapi.departamento.model.Departamento;
import com.arthurtalles.processoapi.pessoas.model.Pessoas;


public record PessoasResponseDTO(Integer id, String nome, Integer departamentoId, String listaTarefas) {

    public PessoasResponseDTO(Pessoas pessoa){
        this(pessoa.getId(),pessoa.getNome(),pessoa.getDepartamentoId(),pessoa.getListaTarefas());
    }
}
