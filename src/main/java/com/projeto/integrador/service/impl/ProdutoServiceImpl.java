package com.projeto.integrador.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.integrador.domain.dto.ConsultaProdutoDTO;
import com.projeto.integrador.domain.dto.ProdutoDTO;
import com.projeto.integrador.domain.entity.Produto;
import com.projeto.integrador.exceptions.ProdutoNaoEncontrado;
import com.projeto.integrador.mapper.EstoqueMapper;
import com.projeto.integrador.repository.ProdutoRepository;
import com.projeto.integrador.service.ProdutoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

	private final ProdutoRepository repository;
	private final EstoqueMapper mapper;

	@Override
	public Produto findProdutoById(Long id) {
		Produto produto = repository.findById(id).orElseThrow(() -> new ProdutoNaoEncontrado(id));
		return produto;
	}

	@Override
	public ConsultaProdutoDTO cadastrarProduto(ProdutoDTO dto) {
		Produto produto = mapper.produtoDTOparaProdutoEntidade(dto);
		produto = repository.save(produto);
		return mapper.produtoEntidadeParaProdutoDTO(produto, 0.0);
	}

	@Override
	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	@Override
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
}
