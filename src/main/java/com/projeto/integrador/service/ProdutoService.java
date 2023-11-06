package com.projeto.integrador.service;

import java.util.List;

import com.projeto.integrador.domain.dto.ConsultaProdutoDTO;
import com.projeto.integrador.domain.dto.ProdutoDTO;
import com.projeto.integrador.domain.entity.Produto;

public interface ProdutoService {


	ConsultaProdutoDTO cadastrarProduto(ProdutoDTO dto);

	void deleteById(Long id);

	Produto findProdutoById(Long id);

	List<Produto> findAll();
	
	Produto save(Produto produto);

}