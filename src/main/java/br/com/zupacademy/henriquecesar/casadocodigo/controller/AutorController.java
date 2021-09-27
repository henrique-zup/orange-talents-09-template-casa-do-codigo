package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.form.AutorForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Autor;
import br.com.zupacademy.henriquecesar.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public void cadastraAutor(@RequestBody @Valid AutorForm autorForm) {
		Autor autor = autorForm.toModel();
		autorRepository.save(autor);
	}

}
