package br.com.zupacademy.henriquecesar.casadocodigo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String titulo;
    
    @Column(nullable = false)
    private String resumo;

    @Column(columnDefinition = "TEXT")
    private String sumario;

    @Column(nullable = false)
    private Double preco;
    
    @Column(nullable = false)
    private Integer numeroPaginas;
    
    @Column(nullable = false, unique = true)
    private String isbn;
    
    @Column(nullable = false)
    private LocalDateTime dataLancamento;
    
    @ManyToOne
    private Categoria categoria;
    
    @ManyToOne
    private Autor autor;

    public Livro(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, String isbn,
            LocalDateTime dataLancamento, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

}
