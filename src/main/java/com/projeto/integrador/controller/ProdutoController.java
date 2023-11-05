package com.projeto.integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/api/produto")
@Api(tags = "Controle de Produtos")
public class ProdutoController {
	
	@GetMapping("")
	@ApiModelProperty(position = 1)
	@ApiOperation(value = "Endpoint para obter todos os produtos")
	public ResponseEntity<?> listarProdutos(){
		return ResponseEntity.ok("Lista de produtos");
	}
	
	@GetMapping("/{idProduto}")
	@ApiModelProperty(position = 2)
	@ApiOperation(value = "Endpoint para obter produto por ID")
	public ResponseEntity<?> procurarProdutoPorId(@PathVariable("idProduto")Long id){
		return ResponseEntity.ok("Retorna produto de id ->".concat(id.toString()));
	}
	
	
	@PostMapping("")
	@ApiModelProperty(position = 3)
	@ApiOperation(value = "Endpoint para Cadastrar produto")
	public ResponseEntity<?> cadastrarProduto(){
		return ResponseEntity.ok("Cadastro de produto");
	}
	
	@PutMapping("/{idProduto}")
	@ApiModelProperty(position = 4)
	@ApiOperation(value = "Endpoint para Alterar produto por ID")
	public ResponseEntity<?> alterarProduto(@PathVariable("idProduto")Long id){
		return ResponseEntity.ok("Altarar produto de id ->".concat(id.toString()));
	}
	
	@DeleteMapping("/{idProduto}")
	@ApiModelProperty(position = 5)
	@ApiOperation(value = "Endpoint para Deletar produto por ID")
	public ResponseEntity<?> deletarProduto(@PathVariable("idProduto")Long id){
		return ResponseEntity.noContent().build();
	}

}
