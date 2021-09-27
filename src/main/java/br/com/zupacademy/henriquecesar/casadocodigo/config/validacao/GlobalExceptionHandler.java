package br.com.zupacademy.henriquecesar.casadocodigo.config.validacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    
    @Autowired
    private MessageSource messageSource;
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageDTO handleArgumentNotValidError(MethodArgumentNotValidException ex) {
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        return buildValidationErrors(globalErrors, fieldErrors);
    }

    private ErrorMessageDTO buildValidationErrors(List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO();
        globalErrors.forEach(err -> errorMessageDTO.addError(getErrorMessage(err)));
        
        fieldErrors.forEach(err -> {
            String errorMsg = getErrorMessage(err);
            errorMessageDTO.addFieldError(err.getField(), errorMsg);
        });

        return errorMessageDTO;
    }

    private String getErrorMessage(ObjectError err) {
        return messageSource.getMessage(err, LocaleContextHolder.getLocale());
    }

}
