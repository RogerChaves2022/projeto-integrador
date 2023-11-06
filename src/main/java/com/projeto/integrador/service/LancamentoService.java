package com.projeto.integrador.service;

import java.util.List;

import com.projeto.integrador.domain.dto.ConsultaLancamentoDTO;
import com.projeto.integrador.domain.dto.LancamentoDTO;
import com.projeto.integrador.domain.entity.Lancamento;

public interface LancamentoService {

	ConsultaLancamentoDTO findById(Long id);

	List<ConsultaLancamentoDTO> findAll();
	
	void deleteById(Long id);

	List<ConsultaLancamentoDTO> findLancamentosByProduto(Long produtoId);

}