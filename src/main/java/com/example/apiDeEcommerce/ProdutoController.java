package com.example.apiDeEcommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/Produto")
@CrossOrigin("*")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtorepository;
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAllProduto(){
		return ResponseEntity.ok(produtorepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetByIdProduto(@PathVariable Long id){
		return produtorepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/precoMaior/{preco}")
	public ResponseEntity<List<ProdutoModel>> GetAllByPrecoMaior(@PathVariable float preco){
		return ResponseEntity.ok(produtorepository.findAllByValorGreaterThanEqual(preco));
	}
	
	@GetMapping("/precoMenor/{preco}")
	public ResponseEntity<List<ProdutoModel>> GetAllByPrecoLess(@PathVariable float preco){
		return ResponseEntity.ok(produtorepository.findAllByValorLessThanEqual(preco));
	}
	
	@GetMapping("/busca/{busca}")
	public ResponseEntity<List<ProdutoModel>> GetAllByBusca(@PathVariable String busca){
		return ResponseEntity.ok(produtorepository.findAllByBusca(busca));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postUsuario (@RequestBody ProdutoModel usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtorepository.save(usuario));
	}
	@PutMapping
	public ResponseEntity<ProdutoModel> putUsuario (@RequestBody ProdutoModel usuario){
		return ResponseEntity.status(HttpStatus.OK).body(produtorepository.save(usuario));
	}
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		produtorepository.deleteById(id);
	}
}