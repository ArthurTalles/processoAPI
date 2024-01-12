package com.arthurtalles.processoapi.pessoas.dto;
import com.arthurtalles.processoapi.departamento.model.Departamento;


public record PessoasDTO(Integer id,String nome, Integer departamentoId, String listaTarefas) {


}
