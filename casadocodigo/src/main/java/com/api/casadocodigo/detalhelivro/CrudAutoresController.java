package com.api.casadocodigo.detalhelivro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudAutoresController {

	@Autowired
	private AutorRepository autorRepository;

	@Transactional
	@PostMapping(value = "/api/autor")
	public void novo(@Valid @RequestBody NovoAutorForm form) {
		Autor novoAutor = form.novoAutor();
		System.out.println(novoAutor);
		autorRepository.save(novoAutor);
	}
	
	@GetMapping("/api/autores")
	public ResponseEntity<java.util.List<Autor>> buscarAutores(){
		return ResponseEntity.ok(autorRepository.findAll());
	}
}
