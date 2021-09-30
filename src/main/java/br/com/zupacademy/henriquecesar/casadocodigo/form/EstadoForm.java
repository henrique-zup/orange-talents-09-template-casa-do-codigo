package br.com.zupacademy.henriquecesar.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.henriquecesar.casadocodigo.form.validator.ExisteId;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Estado;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Pais;

public class EstadoForm {

    @NotBlank
    private String nome;
    
    @NotNull
    @ExisteId(entityClass = Pais.class)
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
    
    public Estado toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        return new Estado(this.nome, pais);
    }

}
