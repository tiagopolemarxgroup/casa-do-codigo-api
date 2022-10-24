package com.api.casadocodigo.detalhelivro;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.PastOrPresent;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String linkGithub;
	@PastOrPresent
	private LocalDateTime createAt = LocalDateTime.now();
	
	
	
	public Autor(String nome, String linkGithub) {
		this.nome = nome;
		this.linkGithub = linkGithub;
	}
	
	
	
}
