package com.arthurtalles.processoapi.departamento.model;

import com.arthurtalles.processoapi.departamento.dto.DepartamentoDTO;
import com.arthurtalles.processoapi.tarefas.dto.TarefasDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "departamento")
@Entity(name = "departamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank
    private String titulo;

    public Departamento(DepartamentoDTO data) {

        this.id = data.id();
        this.titulo = data.titulo();

    }
}
