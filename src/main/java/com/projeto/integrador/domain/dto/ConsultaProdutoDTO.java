package com.projeto.integrador.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaProdutoDTO extends ProdutoDTO {
	
	private Long id;
	private Double quantidade;
}
