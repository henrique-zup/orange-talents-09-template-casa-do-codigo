package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DataFuturaValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DataFutura {
    
    String message() default "{datafutura.validation.notvalid}";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };

}
