package com.projeto.integrador.domain.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
	@NotBlank
	private String nome;
	@NotBlank
	private String classificacao;
	@NotBlank
	private String unidadeMedida;
}
