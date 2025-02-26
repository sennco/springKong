package com.example.spring_api.livro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring_api.autor.model.AutorModel;
import com.example.spring_api.autor.repository.IAutorRepository;
import com.example.spring_api.livro.model.LivroModel;
import com.example.spring_api.livro.repository.ILivroRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/autor/{numero}/livro/")
public class LivroController {

    @Autowired
    private ILivroRepository livroRepository;

    @Autowired
    private IAutorRepository autorRepository;

    @GetMapping("/")
    public String getLivro() {
        return "Get Livro";
    }

    @PostMapping("/")
    public ResponseEntity<?> createLivro(@PathVariable String numero, @RequestBody LivroModel livroModel) {
        // Buscar o autor pelo número
        Optional<AutorModel> autorOptional = autorRepository.findByNumero(numero);

        // Verificar se o autor existe
        if (autorOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Autor não encontrado.");
        }

        // Associar o autor ao livro
        livroModel.setAutor(autorOptional.get());

        // Salvar o livro
        LivroModel livroCreated = livroRepository.save(livroModel);

        // Retornar a resposta com o livro criado
        return ResponseEntity.status(201).body(livroCreated);
    }
}
