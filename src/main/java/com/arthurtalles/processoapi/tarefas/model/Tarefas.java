package com.arthurtalles.processoapi.tarefas.model;

import com.arthurtalles.processoapi.pessoas.model.Pessoas;
import com.arthurtalles.processoapi.tarefas.dto.TarefasDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "tarefas")
@Entity(name = "tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefas {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private String descricao;
    private Integer departamentoId;
    //private java.sql.Date  prazo;
    private LocalDate prazo;
    private Integer duracao;
    private Integer pessoasId;
    private Boolean finalizado;


    public Tarefas(TarefasDTO data) {


        this.id = data.id();
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.departamentoId = data.departamentoId();
        this.prazo = data.prazo();
        this.duracao = data.duracao();
        this.pessoasId = data.pessoasId();
        this.finalizado = data.finalizado();

    }
}
