package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.henriquecesar.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Categoria;
import br.com.zupacademy.henriquecesar.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        
        CategoriaForm form = (CategoriaForm) target;
        Optional<Categoria> categoria = categoriaRepository.findByNome(form.getNome());
        
        if (categoria.isPresent()) {
            errors.rejectValue("nome", "categoria.nome.already.exists");
        }
    }

}
