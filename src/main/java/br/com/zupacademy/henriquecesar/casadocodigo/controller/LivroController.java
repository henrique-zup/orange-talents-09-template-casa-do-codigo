package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
    
    @Autowired
    private LivroRepository livroRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

}
