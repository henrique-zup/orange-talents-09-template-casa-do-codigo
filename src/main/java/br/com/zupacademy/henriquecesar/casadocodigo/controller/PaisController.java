package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.form.PaisForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Pais;

@RestController
@RequestMapping("/paises")
public class PaisController {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @PostMapping
    @Transactional
    public void cadastraPais(@RequestBody @Valid PaisForm form) {
        Pais pais = form.toModel();
        entityManager.persist(pais);        
    }

}
