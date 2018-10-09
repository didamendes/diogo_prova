package com.diogo.provaSquadra.repository.filter;

import javax.validation.constraints.Email;

public class SistemaFilter {

	private String descricao;
	private String sigla;
	
	@Email
	private String email;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
