package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.form.validator.ProibeCategoriaDuplicadaValidator;
import br.com.zupacademy.henriquecesar.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProibeCategoriaDuplicadaValidator proibeCategoriaDuplicadaValidator;
    
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeCategoriaDuplicadaValidator);
    }

}
