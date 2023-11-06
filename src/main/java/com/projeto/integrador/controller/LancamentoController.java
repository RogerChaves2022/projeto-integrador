package com.projeto.integrador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.integrador.domain.dto.ConsultaLancamentoDTO;
import com.projeto.integrador.domain.dto.LancamentoDTO;
import com.projeto.integrador.domain.enumarations.TipoLancamento;
import com.projeto.integrador.exceptions.LancamentoNaoEncontrado;
import com.projeto.integrador.exceptions.ProdutoNaoEncontrado;
import com.projeto.integrador.service.EstoqueService;
import com.projeto.integrador.service.LancamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/v1/api/lancamento")
@Api(tags = "Controle de Lançamentos")
@RequiredArgsConstructor
public class LancamentoController {
	
	private final LancamentoService service;
	private final EstoqueService estoqueService;
	
	@GetMapping("")
	@ApiModelProperty(position = 1)
	@ApiOperation(value = "Endpoint para obter todos os lançamentos")
	public ResponseEntity<?> listarLancamentos(){
		List<ConsultaLancamentoDTO> lancamentos = service.findAll();
		return ResponseEntity.ok(lancamentos);
	}
	@GetMapping("/{idProduto}")
	@ApiModelProperty(position = 1)
	@ApiOperation(value = "Endpoint para obter todos os lançamentos por produto")
	public ResponseEntity<?> listarLancamentosPorProduto(@PathVariable("idProduto") Long id){
		List<ConsultaLancamentoDTO> lancamentos = service.findLancamentosByProduto(id);
		return ResponseEntity.ok(lancamentos);
	}
	
	@PostMapping("/entrada")
	@ApiModelProperty(position = 2)
	@ApiOperation(value = "Endpoint para Cadastrar lançamento de entrada")
	public ResponseEntity<?> cadastrarEntrada(@RequestParam("quantidade")Double quantidade, @RequestParam("produtoId")Long produtoId){
		LancamentoDTO build = LancamentoDTO.builder().produtoId(produtoId).quantidade(quantidade).tipoLancamento(TipoLancamento.ENTRADA).build();
		try {
			estoqueService.cadastrarLancamento(build);
			return ResponseEntity.ok(build);
		} catch (ProdutoNaoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/saida")
	@ApiModelProperty(position = 3)
	@ApiOperation(value = "Endpoint para Cadastrar lançamento de saída")
	public ResponseEntity<?> cadastrarSaida(@RequestParam("quantidade")Double quantidade, @RequestParam("produtoId")Long produtoId){
		LancamentoDTO build = LancamentoDTO.builder().produtoId(produtoId).quantidade(quantidade).tipoLancamento(TipoLancamento.SAIDA).build();
		try {
			estoqueService.cadastrarLancamento(build);
			return ResponseEntity.ok(build);
		} catch (ProdutoNaoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{idLancamento}")
	@ApiModelProperty(position = 4)
	@ApiOperation(value = "Endpoint para Deletar lançamento por ID")
	public ResponseEntity<?> deletarLancamento(@PathVariable("idLancamento")Long id){
		try {
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (LancamentoNaoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
}
