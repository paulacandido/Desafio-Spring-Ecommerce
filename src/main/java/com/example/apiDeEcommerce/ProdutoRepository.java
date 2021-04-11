package com.example.apiDeEcommerce;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {

    public List<ProdutoModel> findAllByValorLessThanEqual (float valor);
	
	public List<ProdutoModel> findAllByValorGreaterThanEqual (float valor);
	
	@Query(value = "SELECT * tb_Produto WHERE nome  LIKE \"% busca = :busca%\"", nativeQuery = true)
	public List<ProdutoModel> findAllByBusca(@Param("busca") String busca);
	
}
