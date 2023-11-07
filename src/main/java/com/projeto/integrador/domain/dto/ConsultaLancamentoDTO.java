package com.projeto.integrador.domain.dto;

import java.time.LocalDateTime;

import com.projeto.integrador.domain.enumarations.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaLancamentoDTO {
	private Long id;
	private String nomeProduto;
	private String unidadeMedida;
	private Double quantidade;
	private LocalDateTime dtHrCriacao;
	private TipoLancamento tipoLancamento;
}
