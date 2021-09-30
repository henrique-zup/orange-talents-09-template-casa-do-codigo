package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.henriquecesar.casadocodigo.form.EstadoForm;

public class EstadoUnicoPaisValidator implements ConstraintValidator<EstadoUnicoPais, EstadoForm> {
    
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(EstadoForm value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("SELECT 1 FROM Estado WHERE nome = :nome AND pais_id = :paisId");
        query.setParameter("nome", value.getNome());
        query.setParameter("paisId", value.getPaisId());
        List<?> result = query.getResultList();
        return result.isEmpty();
    }

}
