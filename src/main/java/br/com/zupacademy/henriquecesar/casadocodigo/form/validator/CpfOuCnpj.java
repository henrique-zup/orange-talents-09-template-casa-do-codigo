package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CpfOuCnpjValidator.class)
public @interface CpfOuCnpj {
    
    String message() default "{cpfOuCnpj.validation.notValid}";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };

}
