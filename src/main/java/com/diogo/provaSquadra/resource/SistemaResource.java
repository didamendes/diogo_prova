package com.diogo.provaSquadra.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diogo.provaSquadra.model.Sistema;
import com.diogo.provaSquadra.repository.filter.SistemaFilter;
import com.diogo.provaSquadra.service.SistemaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sistemas")
public class SistemaResource {
	
	@Autowired
	private SistemaService sistemaService;
	
	@GetMapping
	public List<Sistema> listar(SistemaFilter sistemaFilter) {
		return sistemaService.listar(sistemaFilter);
	}
	
	@PostMapping
	public ResponseEntity<Sistema> criar(@Valid @RequestBody Sistema sistema) {
		Sistema sistemaSalvo = sistemaService.salvar(sistema);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/codigo}").buildAndExpand(sistemaSalvo.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(sistemaSalvo);
	}

}
