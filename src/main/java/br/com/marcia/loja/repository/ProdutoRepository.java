package br.com.marcia.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcia.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
