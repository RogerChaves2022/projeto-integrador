package com.projeto.integrador.service;

import java.util.List;

import com.projeto.integrador.domain.dto.ConsultaLancamentoDTO;
import com.projeto.integrador.domain.dto.ConsultaProdutoDTO;
import com.projeto.integrador.domain.dto.LancamentoDTO;
import com.projeto.integrador.domain.dto.ProdutoDTO;

public interface EstoqueService {

	ConsultaLancamentoDTO cadastrarLancamento(LancamentoDTO dto);

	ConsultaProdutoDTO findById(Long id);

	List<ConsultaProdutoDTO> findAll();

	void deleteById(Long id);

	ConsultaProdutoDTO alterarProduto(Long id, ProdutoDTO dto);

	List<String> findAllClassificacoesOrderByQuantidade();

}