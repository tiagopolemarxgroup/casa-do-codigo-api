package com.api.casadocodigo.detalhelivro;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/api")
public class CrudCategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@InitBinder("NovaCategoriaForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new SemCategoriaComNomeDuplicado(categoriaRepository));
		
	}
	
	@PostMapping(value = "/categoria")
	public ResponseEntity<?> novaCategoria(@Valid @RequestBody NovaCategoriaForm form) {
		Categoria novaCategoria = new Categoria(form.getNome());
		  
		 if(categoriaRepository.findByNome(novaCategoria.getNome()).isPresent()) {
			 throw new IllegalArgumentException("Já existe um nome para essa categoria tratamento no controller" + HttpStatus.BAD_REQUEST);
		 }
		return  ResponseEntity.ok(categoriaRepository.save(novaCategoria));
	}
	
	@GetMapping(value = "/categorias")
	public ResponseEntity<List<Categoria>> buscarCategorias(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
}
