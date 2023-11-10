package com.projeto.integrador.service.impl;

import static com.projeto.integrador.domain.entity.Lancamento.SORT_BY_CREATED_AT_DESC;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.integrador.domain.dto.ConsultaLancamentoDTO;
import com.projeto.integrador.domain.entity.Lancamento;
import com.projeto.integrador.exceptions.LancamentoNaoEncontrado;
import com.projeto.integrador.mapper.EstoqueMapper;
import com.projeto.integrador.repository.LancamentoRepository;
import com.projeto.integrador.service.LancamentoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LancamentoServiceImpl implements LancamentoService {

	private final LancamentoRepository repository;
	private final EstoqueMapper mapper;
	
	public List<Lancamento> findByProduto(Long produtoId) {
		return repository.findByProduto(produtoId);
	}
	
	@Override
	public List<ConsultaLancamentoDTO> findLancamentosByProduto(Long produtoId) {
		List<Lancamento> lancamentos = repository.findByProduto(produtoId);
		return mapper.listLancamentoEntidadeParaLancamentoDTO(lancamentos);
	}
	
	@Override
	public ConsultaLancamentoDTO findById(Long id) {
		Lancamento lancamento = repository.findById(id).orElseThrow(()-> new LancamentoNaoEncontrado(id));
		return mapper.lancamentoEntidadeParaLancamentoDTO(lancamento);
	}
	
	@Override
	public List<ConsultaLancamentoDTO> findAll(){
		List<Lancamento> lancamentos = repository.findAll(SORT_BY_CREATED_AT_DESC);
		return mapper.listLancamentoEntidadeParaLancamentoDTO(lancamentos);
	}

	@Override
	public void deleteById(Long id) {
		repository.findById(id).orElseThrow(()-> new LancamentoNaoEncontrado(id));
		repository.deleteById(id);
	}

	public Lancamento save(Lancamento lancamento) {
		return repository.save(lancamento);
	}
	
	
}
