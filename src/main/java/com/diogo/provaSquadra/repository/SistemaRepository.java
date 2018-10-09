package com.diogo.provaSquadra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogo.provaSquadra.model.Sistema;
import com.diogo.provaSquadra.repository.sistema.SistemaRepositoryQuery;

public interface SistemaRepository extends JpaRepository<Sistema, Long>, SistemaRepositoryQuery {

}
