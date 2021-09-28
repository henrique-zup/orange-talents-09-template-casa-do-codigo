package br.com.zupacademy.henriquecesar.casadocodigo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    @Deprecated
    public Categoria() {
    }
    
    public Categoria(String nome) {
        this.nome = nome;
    }
}
