package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = EstadoUnicoPaisValidator.class)
public @interface EstadoUnicoPais {
    
    String message() default "{estadoValido.validation.notValid}";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };

}
