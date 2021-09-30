package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.form.EstadoForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Estado;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @PostMapping
    @Transactional
    public void cadastraEstado(@RequestBody @Valid EstadoForm form) {
        Estado estado = form.toModel(entityManager);
        entityManager.persist(estado);        
    }

}
