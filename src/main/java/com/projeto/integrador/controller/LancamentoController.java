package com.projeto.integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/api/lancamento")
@Api(tags = "Controle de Lançamentos")
public class LancamentoController {
	
	@GetMapping("")
	@ApiModelProperty(position = 1)
	@ApiOperation(value = "Endpoint para obter todos os lançamenttos")
	public ResponseEntity<?> listarLancamentos(){
		return ResponseEntity.ok("Lista de lançamentos");
	}
	
	@PostMapping("/entrada")
	@ApiModelProperty(position = 2)
	@ApiOperation(value = "Endpoint para Cadastrar lançamento de entrada")
	public ResponseEntity<?> cadastrarEntrada(){
		return ResponseEntity.ok("Cadastro de entrada");
	}
	
	@PostMapping("/saida")
	@ApiModelProperty(position = 3)
	@ApiOperation(value = "Endpoint para Cadastrar lançamento de saída")
	public ResponseEntity<?> cadastrarSaida(){
		return ResponseEntity.ok("Cadastro de saida");
	}
	
	@DeleteMapping("/{idLancamento}")
	@ApiModelProperty(position = 4)
	@ApiOperation(value = "Endpoint para Deletar lançamento por ID")
	public ResponseEntity<?> deletarLancamento(@PathVariable("idLancamento")Long id){
		return ResponseEntity.noContent().build();
	}
}
