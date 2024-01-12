package com.arthurtalles.processoapi.pessoas.model;

import com.arthurtalles.processoapi.departamento.model.Departamento;
import com.arthurtalles.processoapi.pessoas.dto.PessoasDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pessoas")
@Entity(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoas {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String nome;
    //@ManyToOne
    @NotNull
    private Integer departamentoId;
    private String listaTarefas;

    public Pessoas(PessoasDTO data) {
        this.id = data.id();
        this.nome = data.nome();
        this.departamentoId = data.departamentoId();
        this.listaTarefas = data.listaTarefas();

    }
}
