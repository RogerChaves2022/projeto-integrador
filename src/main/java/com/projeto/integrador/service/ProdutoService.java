package com.projeto.integrador.service;

import java.util.List;

import com.projeto.integrador.domain.dto.ConsultaProdutoDTO;
import com.projeto.integrador.domain.dto.ProdutoDTO;

public interface ProdutoService {

	ConsultaProdutoDTO findById(Long id);

	ConsultaProdutoDTO cadastrarProduto(ProdutoDTO dto);

	List<ConsultaProdutoDTO> findAll();

	void deleteById(Long id);

}