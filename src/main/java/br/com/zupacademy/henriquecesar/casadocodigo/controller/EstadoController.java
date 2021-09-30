package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    
    @PersistenceContext
    private EntityManager entityManager;

}
