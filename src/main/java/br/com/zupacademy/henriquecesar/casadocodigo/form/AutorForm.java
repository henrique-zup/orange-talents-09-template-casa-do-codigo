package br.com.zupacademy.henriquecesar.casadocodigo.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Autor;

public class AutorForm {
	
	@NotBlank
	private String nome;
	
	@NotBlank @Email
	private String email;
	
	@Size(max = 400)
	private String descricao;

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao, LocalDateTime.now());
	}
}
