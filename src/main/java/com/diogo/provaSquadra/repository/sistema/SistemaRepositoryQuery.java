package com.diogo.provaSquadra.repository.sistema;

import java.util.List;

import com.diogo.provaSquadra.model.Sistema;
import com.diogo.provaSquadra.repository.filter.SistemaFilter;

public interface SistemaRepositoryQuery {
	
	public List<Sistema> filtrar(SistemaFilter sistemaFilter);

}
