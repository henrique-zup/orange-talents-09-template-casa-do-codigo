package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExisteIdValidator implements ConstraintValidator<ExisteId, Object> {
    
    Class<?> entityClass;
    String columnId;
    
    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public void initialize(ExisteId constraintAnnotation) {
        entityClass = constraintAnnotation.entityClass();
        columnId = constraintAnnotation.columnId();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String sql = "SELECT 1 FROM class WHERE columnId = :value"
                .replace("class", entityClass.getName())
                .replace("columnId", columnId);
        
        Query query = manager.createQuery(sql);
        query.setParameter("value", value);
        
        List<?> result = query.getResultList();
        return !result.isEmpty();
    }

}
