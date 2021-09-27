package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.henriquecesar.casadocodigo.form.AutorForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Autor;
import br.com.zupacademy.henriquecesar.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {
    
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        
        AutorForm form = (AutorForm) target;
        Optional<Autor> autor = autorRepository.findByEmail(form.getEmail());
        
        if (autor.isPresent()) {
            errors.rejectValue("email", "autorform.email.already.exists");
        }
        
    }

}
