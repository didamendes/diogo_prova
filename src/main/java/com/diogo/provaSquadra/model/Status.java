package com.diogo.provaSquadra.model;

public enum Status {

	ATIVO("Ativo"), CANCELADO("Cancelado");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
