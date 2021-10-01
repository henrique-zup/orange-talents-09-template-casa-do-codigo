package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.form.validator.ClienteForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @PostMapping
    @Transactional
    public void cadastraCliente(@RequestBody @Valid ClienteForm form) {
        Cliente cliente = form.toModel(entityManager);
        entityManager.persist(cliente);
    }

}
