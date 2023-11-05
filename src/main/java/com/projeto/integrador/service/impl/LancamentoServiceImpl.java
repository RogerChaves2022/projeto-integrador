package com.projeto.integrador.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.integrador.domain.dto.ConsultaLancamentoDTO;
import com.projeto.integrador.domain.dto.LancamentoDTO;
import com.projeto.integrador.domain.entity.Lancamento;
import com.projeto.integrador.exceptions.LancamentoNaoEncontrado;
import com.projeto.integrador.mapper.EstoqueMapper;
import com.projeto.integrador.repository.LancamentoRepository;
import com.projeto.integrador.service.LancamentoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class LancamentoServiceImpl implements LancamentoService {

	private final LancamentoRepository repository;
	private final EstoqueMapper mapper;
	
	public List<Lancamento> findByProduto(Long produtoId) {
		return repository.findByProduto(produtoId);
	}
	
	@Override
	public ConsultaLancamentoDTO findById(Long id) {
		Lancamento lancamento = repository.findById(id).orElseThrow(()-> new LancamentoNaoEncontrado(id));
		return mapper.lancamentoEntidadeParaLancamentoDTO(lancamento);
	}
	
	@Override
	public List<ConsultaLancamentoDTO> findAll(){
		List<Lancamento> lancamentos = repository.findAll();
		return mapper.listLancamentoEntidadeParaLancamentoDTO(lancamentos);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public ConsultaLancamentoDTO cadastrarLancamento(LancamentoDTO dto) {
		Lancamento lancamento = mapper.lancamentoDTOparaLancamentoEntidade(dto);
		return null;
		
	}
}
