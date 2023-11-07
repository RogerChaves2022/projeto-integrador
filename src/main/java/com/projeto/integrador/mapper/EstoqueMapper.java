package com.projeto.integrador.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.projeto.integrador.domain.dto.ConsultaLancamentoDTO;
import com.projeto.integrador.domain.dto.ConsultaProdutoDTO;
import com.projeto.integrador.domain.dto.LancamentoDTO;
import com.projeto.integrador.domain.dto.ProdutoDTO;
import com.projeto.integrador.domain.entity.Lancamento;
import com.projeto.integrador.domain.entity.Produto;


@Mapper
public interface EstoqueMapper {
	
	EstoqueMapper INSTANCE = Mappers.getMapper(EstoqueMapper.class);
	
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "dtCriacao", expression = "java(java.time.LocalDateTime.now())")
	Produto produtoDTOparaProdutoEntidade(ProdutoDTO dto);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "produto.id", source = "produtoId")
	@Mapping(target = "dtHrCriacao", expression = "java(java.time.LocalDateTime.now())")
	Lancamento lancamentoDTOparaLancamentoEntidade(LancamentoDTO dto);
	
	ConsultaProdutoDTO produtoEntidadeParaProdutoDTO(Produto produto, Double quantidade);
	
	@Mapping(target = "id", source = "dto.id")
	@Mapping(target = "nomeProduto", source = "produto.nome")
	@Mapping(target = "unidadeMedida", source = "produto.unidadeMedida")
	ConsultaLancamentoDTO lancamentoEntidadeParaLancamentoDTO(Lancamento dto);
	
	@Mapping(target = "id", source = "dto.id")
	@Mapping(target = "nomeProduto", source = "produto.nome")
	List<ConsultaLancamentoDTO> listLancamentoEntidadeParaLancamentoDTO(List<Lancamento> dto);
	
}
