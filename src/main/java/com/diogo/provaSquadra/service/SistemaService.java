package com.diogo.provaSquadra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogo.provaSquadra.model.Sistema;
import com.diogo.provaSquadra.repository.SistemaRepository;
import com.diogo.provaSquadra.repository.filter.SistemaFilter;

@Service
public class SistemaService {
	
	@Autowired
	private SistemaRepository sistemaRepository;
	
	public List<Sistema> listar(SistemaFilter sistemaFilter) {
		return sistemaRepository.filtrar(sistemaFilter);
	}
	
	public Sistema salvar(Sistema sistema) {
		return sistemaRepository.save(sistema);
	}

}
