package br.com.zupacademy.henriquecesar.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henriquecesar.casadocodigo.form.validator.ValorUnico;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Pais;

public class PaisForm {

    @NotBlank
    @ValorUnico(entityClass = Pais.class, field = "nome")
    String nome;

    public String getNome() {
        return nome;
    }
    
    public Pais toModel() {
        return new Pais(this.nome);
    }
    
}
