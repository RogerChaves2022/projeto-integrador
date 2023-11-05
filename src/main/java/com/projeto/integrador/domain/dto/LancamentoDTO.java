package com.projeto.integrador.domain.dto;

import com.projeto.integrador.domain.enumarations.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDTO {
	
	private TipoLancamento tipoLancamento;
	private Double quantidade;
	private Long produtoId;
}
