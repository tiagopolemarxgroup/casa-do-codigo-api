package com.api.casadocodigo.detalhelivro;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.Data;

@Data
public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	@URL
	private String linkGithub;

	public Autor novoAutor() {
		return new Autor(nome, linkGithub);
	}
}
