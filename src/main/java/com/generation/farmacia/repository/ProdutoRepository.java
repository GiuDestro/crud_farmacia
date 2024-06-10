package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
	
	@Query(value = "select * from tb_produto where preco between :inicio and :fim", nativeQuery = true)
    public List <Produto> buscarProdutosEntre(@Param("inicio") float inicio, @Param("fim") float fim);
	

}
