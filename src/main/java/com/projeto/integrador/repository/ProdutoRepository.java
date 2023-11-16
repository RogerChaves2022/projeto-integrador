package com.projeto.integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.integrador.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query("SELECT DISTINCT p.classificacao FROM Produto p")
	List<String> findAllClassificacoesOrderByQuantidade();

}
