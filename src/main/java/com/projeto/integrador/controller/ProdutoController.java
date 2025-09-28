package com.projeto.integrador.controller;

import java.util.List;

import javax.validation.Valid;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.integrador.domain.dto.ConsultaProdutoDTO;
import com.projeto.integrador.domain.dto.ProdutoDTO;
import com.projeto.integrador.exceptions.ProdutoNaoEncontrado;
import com.projeto.integrador.service.EstoqueService;
import com.projeto.integrador.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Log4j2
@RestController
@RequestMapping(path = "/v1/api/produto")
@Api(tags = "Controle de Produtos")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	private final ProdutoService service;
	private final EstoqueService estoqueService;
	
	@GetMapping("")
	@ApiModelProperty(position = 1)
	@ApiOperation(value = "Endpoint para obter todos os produtos")
	public ResponseEntity<?> listarProdutos(){
		List<ConsultaProdutoDTO> findAll = estoqueService.findAll();
		if(findAll.isEmpty()){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(findAll);
	}
	
	@GetMapping("/{idProduto}")
	@ApiModelProperty(position = 2)
	@ApiOperation(value = "Endpoint para obter produto por ID")
	public ResponseEntity<?> procurarProdutoPorId(@PathVariable("idProduto")Long id){
		try {
			ConsultaProdutoDTO findById = estoqueService.findById(id);
			return ResponseEntity.ok(findById);
		} catch (ProdutoNaoEncontrado e) {
			e.printStackTrace();
			return ResponseEntity.notFound().eTag(e.getMessage()).build();
		}
	}
	
	
	@PostMapping("")
	@ApiModelProperty(position = 3)
	@ApiOperation(value = "Endpoint para Cadastrar produto")
	public ResponseEntity<?> cadastrarProduto(@Valid @RequestBody ProdutoDTO dto){
		ConsultaProdutoDTO cadastrarProduto = service.cadastrarProduto(dto);
		log.info(cadastrarProduto.toString());
		return ResponseEntity.status(201).body(cadastrarProduto);
	}
	
	@PutMapping("/{idProduto}")
	@ApiModelProperty(position = 4)
	@ApiOperation(value = "Endpoint para Alterar produto por ID")
	public ResponseEntity<?> alterarProduto(@PathVariable("idProduto")Long id, @Valid @RequestBody ProdutoDTO dto){
		ConsultaProdutoDTO alterarProduto;
		try {
			alterarProduto = estoqueService.alterarProduto(id,dto);
			return ResponseEntity.ok(alterarProduto);
		} catch (ProdutoNaoEncontrado e) {
			e.printStackTrace();
			return ResponseEntity.notFound().eTag(e.getMessage()).build();
		}
	}
	
	@DeleteMapping("/{idProduto}")
	@ApiModelProperty(position = 5)
	@ApiOperation(value = "Endpoint para Deletar produto por ID")
	public ResponseEntity<?> deletarProduto(@PathVariable("idProduto")Long id){
		try {
			estoqueService.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (ProdutoNaoEncontrado e) {
			e.printStackTrace();
			return ResponseEntity.notFound().eTag(e.getMessage()).build();
		}
	}
	
	@GetMapping("/classificacao")
	@ApiModelProperty(position = 6)
	@ApiOperation(value = "Endpoint para obter todos as classificações")
	public ResponseEntity<?> listarClassificacoes(){
		List<String> findAll = estoqueService.findAllClassificacoesOrderByQuantidade();
		return ResponseEntity.ok(findAll);
	}
}
