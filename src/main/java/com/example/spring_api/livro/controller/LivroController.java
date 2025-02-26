package com.example.spring_api.livro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring_api.autor.model.AutorModel;
import com.example.spring_api.autor.repository.IAutorRepository;
import com.example.spring_api.livro.model.LivroModel;
import com.example.spring_api.livro.repository.ILivroRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/autor/{numero}/livro/")
public class LivroController {

    @Autowired
    private ILivroRepository livroRepository;

    @Autowired
    private IAutorRepository autorRepository;

  
    @PostMapping("/")
    public ResponseEntity<?> createLivro(@PathVariable String numero, @RequestBody LivroModel livroModel) {
       
        Optional<AutorModel> autorOptional = autorRepository.findByNumero(numero);

       
        if (autorOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Autor não encontrado.");
        }

      
        livroModel.setAutor(autorOptional.get());

    
        LivroModel livroCreated = livroRepository.save(livroModel);

  
        return ResponseEntity.status(201).body(livroCreated);
    }


    @GetMapping("/")
    public ResponseEntity<?> getLivrosByAutor(@PathVariable String numero) {
     
        Optional<AutorModel> autorOptional = autorRepository.findByNumero(numero);

     
        if (autorOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Autor não encontrado.");
        }

   
        List<LivroModel> livros = livroRepository.findByAutor(autorOptional.get());

      
        if (livros.isEmpty()) {
            return ResponseEntity.status(404).body("Autor não possui livros cadastrados.");
        }

        return ResponseEntity.ok(livros);  
    }
}
