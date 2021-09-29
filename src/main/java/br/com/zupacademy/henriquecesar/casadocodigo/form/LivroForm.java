package br.com.zupacademy.henriquecesar.casadocodigo.form;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.henriquecesar.casadocodigo.form.validator.DataFutura;
import br.com.zupacademy.henriquecesar.casadocodigo.form.validator.ExisteId;
import br.com.zupacademy.henriquecesar.casadocodigo.form.validator.ValorUnico;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Autor;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Categoria;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Livro;

public class LivroForm {

    @NotBlank
    @ValorUnico(entityClass = Livro.class, field = "titulo")
    private String titulo;

    @NotBlank
    private String resumo;

    private String sumario;

    @Min(20)
    private Double preco;

    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @ValorUnico(entityClass = Livro.class, field = "isbn")
    private String isbn;

    @NotNull
    @DataFutura
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataLancamento;

    @NotNull
    @ExisteId(entityClass = Categoria.class)
    private Long categoriaId;

    @NotNull
    @ExisteId(entityClass = Autor.class)
    private Long autorId;

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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro toModel(EntityManager manager) {
        Autor autor = manager.find(Autor.class, this.autorId);
        Categoria categoria = manager.find(Categoria.class, this.categoriaId);
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
                this.dataLancamento, categoria, autor);
    }

}
