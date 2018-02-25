package com.corporacaocapsula.cobr.model;

public enum StatusTitulo {
	
	PENDENTE("Pendente"),
	RECEBIDO("Recebido");
	
	
	
	private String descricao;
	
	
	private StatusTitulo(String descricao) {
		this.descricao = descricao;
	}


	public String getDescricao() {
		return descricao;
	}

	
	

}
