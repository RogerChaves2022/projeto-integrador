package com.projeto.integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projeto.integrador.domain.entity.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	@Query("Select l from Lancamento l join l.produto p where p.id = :produto")
	List<Lancamento> findByProduto(@Param("produto") Long produtoId);

}
