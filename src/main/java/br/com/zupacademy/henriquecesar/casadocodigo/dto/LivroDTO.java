package br.com.zupacademy.henriquecesar.casadocodigo.dto;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Livro;

public class LivroDTO {

    private Long id;
    private String titulo;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
