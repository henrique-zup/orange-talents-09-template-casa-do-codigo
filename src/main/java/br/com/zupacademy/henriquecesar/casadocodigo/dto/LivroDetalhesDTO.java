package br.com.zupacademy.henriquecesar.casadocodigo.dto;

import java.time.LocalDateTime;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Livro;

public class LivroDetalhesDTO {
    
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDateTime dataLancamento;
    private AutorDTO autor;
    
    public LivroDetalhesDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento();
        this.autor = new AutorDTO(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public AutorDTO getAutor() {
        return autor;
    }

}
