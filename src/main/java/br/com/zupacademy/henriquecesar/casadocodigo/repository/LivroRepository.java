package br.com.zupacademy.henriquecesar.casadocodigo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
    
    List<Livro> findAll();

}
