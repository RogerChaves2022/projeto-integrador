package com.projeto.integrador.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
	@NonNull
	@Positive
	private Double quantidadeMaxima;
}
