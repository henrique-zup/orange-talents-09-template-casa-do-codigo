package br.com.zupacademy.henriquecesar.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessageDTO {
    
    private List<String> globalErrorsMessages = new ArrayList<String>();
    private List<ErrorFieldMessageDTO> fieldErrors = new ArrayList<ErrorFieldMessageDTO>();
    
    public void addError(String error) {
        this.globalErrorsMessages.add(error);
    }
    
    public void addFieldError(String campo, String mensagem) {
        this.fieldErrors.add(new ErrorFieldMessageDTO(campo, mensagem));
    }

    public List<String> getGlobalErrorsMessages() {
        return globalErrorsMessages;
    }

    public List<ErrorFieldMessageDTO> getFieldErrors() {
        return fieldErrors;
    }
}
