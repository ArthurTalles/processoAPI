package com.arthurtalles.processoapi.tarefas.repository;

import com.arthurtalles.processoapi.pessoas.model.Pessoas;
import com.arthurtalles.processoapi.tarefas.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefasRepository extends JpaRepository<Tarefas, Integer>{
    List<Tarefas> findAllByDepartamentoId(Integer departamentoId);

    List<Tarefas> findAllByPessoasId(Integer departamentoId);

}
