package com.arthurtalles.processoapi.pessoas.repository;

import com.arthurtalles.processoapi.pessoas.model.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoasRepository extends JpaRepository<Pessoas, Integer>{

    List<Pessoas> findAllByDepartamentoId(Integer departamentoId);

}
