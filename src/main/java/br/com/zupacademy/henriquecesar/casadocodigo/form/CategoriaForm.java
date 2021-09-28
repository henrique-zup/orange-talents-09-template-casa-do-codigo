package br.com.zupacademy.henriquecesar.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henriquecesar.casadocodigo.form.validator.ValorUnico;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Categoria;

public class CategoriaForm {
    
    @NotBlank
    @ValorUnico(entityClass = Categoria.class, field = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
