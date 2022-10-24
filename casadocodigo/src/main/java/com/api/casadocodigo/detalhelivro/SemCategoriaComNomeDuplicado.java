package com.api.casadocodigo.detalhelivro;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SemCategoriaComNomeDuplicado implements Validator {

	private CategoriaRepository categoriaRepository;
	
	public SemCategoriaComNomeDuplicado(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovaCategoriaForm form = (NovaCategoriaForm) target;
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(form.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com esse nome");
		}
	}

}
