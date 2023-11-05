package com.projeto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.integrador.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
