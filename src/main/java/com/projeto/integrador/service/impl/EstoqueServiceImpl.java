package com.projeto.integrador.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projeto.integrador.domain.dto.ConsultaLancamentoDTO;
import com.projeto.integrador.domain.dto.ConsultaProdutoDTO;
import com.projeto.integrador.domain.dto.LancamentoDTO;
import com.projeto.integrador.domain.dto.ProdutoDTO;
import com.projeto.integrador.domain.entity.Lancamento;
import com.projeto.integrador.domain.entity.Produto;
import com.projeto.integrador.domain.enumarations.TipoLancamento;
import com.projeto.integrador.mapper.EstoqueMapper;
import com.projeto.integrador.service.EstoqueService;
import com.projeto.integrador.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstoqueServiceImpl implements EstoqueService {
	
	private final LancamentoServiceImpl lancamentoService;
	private final ProdutoService produtoService;
	private final EstoqueMapper mapper;
	
	@Override
	public ConsultaLancamentoDTO cadastrarLancamento(LancamentoDTO dto) {
		Lancamento lancamento = mapper.lancamentoDTOparaLancamentoEntidade(dto);
		Produto produto = produtoService.findProdutoById(lancamento.getProduto().getId());
		lancamento.setProduto(produto);
		lancamentoService.save(lancamento);
		return mapper.lancamentoEntidadeParaLancamentoDTO(lancamento);
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
		return quantidade;
	}
	
	@Override
	public ConsultaProdutoDTO findById(Long id) {
		Produto produto = produtoService.findProdutoById(id);
		Double quantidade = quantidadeProduto(id);
		return mapper.produtoEntidadeParaProdutoDTO(produto, quantidade);
	}
	
	@Override
	public List<ConsultaProdutoDTO> findAll(){
		List<Produto> lista = produtoService.findAll();
		return lista.stream().map((produto) -> {
			Double quantidade = quantidadeProduto(produto.getId());
			return mapper.produtoEntidadeParaProdutoDTO(produto, quantidade);
		}).collect(Collectors.toList());
	}
	
	@Override
	public void deleteById(Long id) {
		produtoService.findProdutoById(id);
		lancamentoService.findByProduto(id).stream().forEach(l -> lancamentoService.deleteById(l.getId()));
		produtoService.deleteById(id);
	}
	
	@Override
	public ConsultaProdutoDTO alterarProduto(Long id,ProdutoDTO dto) {
		Produto produto = produtoService.findProdutoById(id);
		produto.setClassificacao(dto.getClassificacao());
		produto.setNome(dto.getNome());
		produto.setUnidadeMedida(dto.getUnidadeMedida());
		produtoService.save(produto);
		Double quantidade = quantidadeProduto(id);
		return mapper.produtoEntidadeParaProdutoDTO(produto, quantidade);
	}
}
