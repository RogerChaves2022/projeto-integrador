package com.projeto.integrador.service;

import java.util.List;

import com.projeto.integrador.domain.dto.ConsultaLancamentoDTO;

public interface LancamentoService {

	ConsultaLancamentoDTO findById(Long id);

	List<ConsultaLancamentoDTO> findAll();
	
	void deleteById(Long id);

}