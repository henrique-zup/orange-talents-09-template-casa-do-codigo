package br.com.zupacademy.henriquecesar.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    
    Optional<Categoria> findByNome(String nome);

}
