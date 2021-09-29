package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.form.LivroForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Livro;
import br.com.zupacademy.henriquecesar.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
    
    @Autowired
    private LivroRepository livroRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @PostMapping
    public void cadastraLivro(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toModel(entityManager);
        livroRepository.save(livro);
    }

}
