package br.com.zupacademy.henriquecesar.casadocodigo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henriquecesar.casadocodigo.dto.LivroDTO;
import br.com.zupacademy.henriquecesar.casadocodigo.dto.LivroDetalhesDTO;
import br.com.zupacademy.henriquecesar.casadocodigo.form.LivroForm;
import br.com.zupacademy.henriquecesar.casadocodigo.modelo.Livro;
import br.com.zupacademy.henriquecesar.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    public void cadastraLivro(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toModel(entityManager);
        livroRepository.save(livro);
    }

    @GetMapping
    public List<LivroDTO> listaLivros() {
        List<Livro> livros = livroRepository.findAll();
        List<LivroDTO> resultado = livros.stream().map(LivroDTO::new).collect(Collectors.toList());
        return resultado;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> detalhaLivro(@PathVariable Long id) {
        Optional<Livro> buscaLivro = livroRepository.findById(id);
        
        if (buscaLivro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(new LivroDetalhesDTO(buscaLivro.get()));
    }

}
