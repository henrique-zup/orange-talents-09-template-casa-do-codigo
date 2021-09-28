package br.com.zupacademy.henriquecesar.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Categoria;

public class CategoriaForm {
    
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
