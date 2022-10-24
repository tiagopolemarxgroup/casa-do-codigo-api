package com.api.casadocodigo.detalhelivro;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovaCategoriaForm {
	@NotBlank
	private String nome;
	
	

}
