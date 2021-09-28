package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Categoria;
import br.com.zupacademy.henriquecesar.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @PostMapping
    public void cadastraCategoria(@RequestBody @Valid CategoriaForm form) {
        Categoria categoria = form.toModel();
        categoriaRepository.save(categoria);
    }

}
