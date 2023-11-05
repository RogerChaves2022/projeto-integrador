package com.projeto.integrador.exceptions;

public class ProdutoNaoEncontrado extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontrado(Long id) {
		super("Produto não Encontrado para o id -> ".concat(id.toString()));
	}
}
