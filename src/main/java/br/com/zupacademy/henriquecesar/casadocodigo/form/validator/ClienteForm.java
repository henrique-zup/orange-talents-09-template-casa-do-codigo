package br.com.zupacademy.henriquecesar.casadocodigo.form.validator;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Cliente;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Estado;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Pais;

@VerificaEstadoObrigatorio
public class ClienteForm {

    @NotBlank
    @Email
    @ValorUnico(entityClass = Cliente.class, field = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOuCnpj
    @ValorUnico(entityClass = Cliente.class, field = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExisteId(entityClass = Pais.class)
    private Long paisId;

    @ExisteId(entityClass = Estado.class, required = false)
    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        Estado estado = (estadoId == null) ? null : manager.find(Estado.class, estadoId);
        
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento,
                cidade, pais, estado, telefone, cep);
    }

}
