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
@RequestMapping("/Usuario")
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuariorepository;
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> GetAllUsuario(){
		return ResponseEntity.ok(usuariorepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> GetByIdUsuario(@PathVariable Long id){
		return usuariorepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioModel> postUsuario (@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuariorepository.save(usuario));
	}
	@PutMapping
	public ResponseEntity<UsuarioModel> putUsuario (@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.OK).body(usuariorepository.save(usuario));
	}
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		usuariorepository.deleteById(id);
	}
}
