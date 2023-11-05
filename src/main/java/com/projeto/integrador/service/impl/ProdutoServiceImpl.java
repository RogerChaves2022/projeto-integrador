package com.projeto.integrador.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projeto.integrador.domain.dto.ConsultaProdutoDTO;
import com.projeto.integrador.domain.dto.ProdutoDTO;
import com.projeto.integrador.domain.entity.Produto;
import com.projeto.integrador.domain.enumarations.TipoLancamento;
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

	private final LancamentoServiceImpl lancamentoService;
	private final ProdutoRepository repository;
	private final EstoqueMapper mapper;

	@Override
	public ConsultaProdutoDTO findById(Long id) {
		Produto produto = repository.findById(id).orElseThrow(() -> new ProdutoNaoEncontrado(id));
		Double quantidade = quantidadeProduto(id);
		return mapper.produtoEntidadeParaProdutoDTO(produto, quantidade);
	}

	private double quantidadeProduto(Long id) {
		double quantidade;
		try {
			quantidade = lancamentoService.findByProduto(id).stream()
					.mapToDouble(lancamento -> lancamento.getTipoLancamento() == TipoLancamento.ENTRADA
							? lancamento.getQuantidade()
							: -lancamento.getQuantidade())
					.sum();
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
		
		log.info(quantidade);
		return quantidade;
	}
	
	@Override
	public ConsultaProdutoDTO cadastrarProduto(ProdutoDTO dto) {
		Produto produto = mapper.produtoDTOparaProdutoEntidade(dto);
		log.info(produto.toString());
		produto = repository.save(produto);
		return mapper.produtoEntidadeParaProdutoDTO(produto, 0.0);
	}
	
	@Override
	public List<ConsultaProdutoDTO> findAll(){
		List<Produto> lista = repository.findAll();
		return lista.stream().map((produto) -> {
			Double quantidade = quantidadeProduto(produto.getId());
			return mapper.produtoEntidadeParaProdutoDTO(produto, quantidade);
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		lancamentoService.findByProduto(id).stream().forEach(l -> lancamentoService.deleteById(l.getId()));
		repository.deleteById(id);
	}
	
}
