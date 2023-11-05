package com.projeto.integrador.domain.enumarations;

import lombok.Getter;

@Getter
public enum TipoLancamento {

	ENTRADA(1,"ENTRADA"),SAIDA(2,"SAIDA");
	
	private String nome;
	private int codigo;
	
	TipoLancamento(int codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}
	
	
}
