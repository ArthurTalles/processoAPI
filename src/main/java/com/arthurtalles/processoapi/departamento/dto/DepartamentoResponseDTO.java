package com.arthurtalles.processoapi.departamento.dto;

import com.arthurtalles.processoapi.departamento.model.Departamento;
import com.arthurtalles.processoapi.pessoas.model.Pessoas;

public record DepartamentoResponseDTO(Integer id, String titulo) {

    public DepartamentoResponseDTO(Departamento departamento){
        this(departamento.getId(), departamento.getTitulo());
    }
}
