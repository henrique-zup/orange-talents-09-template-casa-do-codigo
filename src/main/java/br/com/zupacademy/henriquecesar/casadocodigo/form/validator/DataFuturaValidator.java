package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataFuturaValidator implements ConstraintValidator<DataFutura, LocalDateTime> {

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        LocalDateTime now = LocalDateTime.now();
        return value.isAfter(now);
    }

}
