package com.projeto.integrador.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
	private String nome;
	private String classificacao;
	private String unidadeMedida;
}
