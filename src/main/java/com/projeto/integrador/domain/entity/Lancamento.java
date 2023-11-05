package com.projeto.integrador.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projeto.integrador.domain.enumarations.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LANCAMENTO")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PRODUTO")
	private Produto produto;
	
	@Column(name = "QUANTIDADE_PRODUTO")
	private Double quantidade;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TIPO_LANCAMENTO")
	private TipoLancamento tipoLancamento;
	
	@Column(name = "DATA_CRIACAO_LANCAMENTO")
	private LocalDateTime dtHrCriacao;

}
