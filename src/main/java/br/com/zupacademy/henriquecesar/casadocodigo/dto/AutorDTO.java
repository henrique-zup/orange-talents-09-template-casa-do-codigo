package br.com.zupacademy.henriquecesar.casadocodigo.dto;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Autor;

public class AutorDTO {

    private String nome;
    private String descricao;

    public AutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
