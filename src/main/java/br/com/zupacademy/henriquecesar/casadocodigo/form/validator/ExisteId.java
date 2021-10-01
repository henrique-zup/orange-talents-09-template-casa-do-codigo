package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ExisteIdValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExisteId {
   
    String message() default "{existeid.validation.notexists}";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
    
    Class<?> entityClass();
    
    String columnId() default "id";
    
    boolean required() default true;

}
