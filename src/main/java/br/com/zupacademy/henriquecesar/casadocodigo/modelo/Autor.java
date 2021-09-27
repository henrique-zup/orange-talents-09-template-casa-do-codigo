package br.com.zupacademy.henriquecesar.casadocodigo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(length = 400)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

	@Deprecated
	public Autor() {
	}

	public Autor(String nome, String email, String descricao, LocalDateTime dataCadastro) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
	}

}
