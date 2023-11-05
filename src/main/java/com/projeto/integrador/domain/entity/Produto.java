package com.projeto.integrador.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "ID_PRODUTO")
	private Long id;
	
	@Column(name = "NOME_PRODUTO")
	private String nome;
	
	@Column(name = "CLASSE_PRODUTO")
	private String classificacao;
	
	@Column(name = "UNIDADE_MEDIDA_PRODUTO")
	private String unidadeMedida;
	
	@Column(name = "DATA_CRIACAO_PRODUTO")
	private LocalDateTime dtCriacao;
}
