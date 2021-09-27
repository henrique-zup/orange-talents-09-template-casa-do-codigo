package br.com.zupacademy.henriquecesar.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

}
