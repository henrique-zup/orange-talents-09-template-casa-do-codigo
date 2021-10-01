package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerificaEstadoObrigatorioValidator implements ConstraintValidator<VerificaEstadoObrigatorio, ClienteForm>{
    
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(ClienteForm value, ConstraintValidatorContext context) {
        Query query;
        Long idEstado = value.getEstadoId();
        
        // se o estado for nulo, verifica se o país tem estados cadastrados.
        if (Objects.isNull(idEstado)) {
            query = manager.createQuery("SELECT 1 FROM Estado WHERE pais_id = :paisId");
            query.setParameter("paisId", value.getPaisId());
            return query.getResultList().isEmpty();            
        }
        
        // caso contrário, verifica se o estado está associado ao país.
        query = manager.createQuery("SELECT 1 FROM Estado WHERE id = :estadoId AND pais_id = :paisId");
        query.setParameter("estadoId", idEstado);
        query.setParameter("paisId", value.getPaisId());
        return !query.getResultList().isEmpty();
    }

}
