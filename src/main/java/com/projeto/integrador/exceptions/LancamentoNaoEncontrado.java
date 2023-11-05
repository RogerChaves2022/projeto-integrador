package com.projeto.integrador.exceptions;

public class LancamentoNaoEncontrado extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LancamentoNaoEncontrado(Long id) {
		super("Lancamento não Encontrado para o id -> ".concat(id.toString()));
	}
}
