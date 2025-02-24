package com.example.spring_api.livro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_api.livro.model.LivroModel;

@RestController
@RequestMapping("/api/v1/autor/numero/livro/")
public class LivroController {

@GetMapping("/")
public String getLivro() {
    return "Get Livro";
}

@PostMapping("/")
public void createLivro(@RequestBody LivroModel livroModel) {
     System.out.println(livroModel.titulo);
    }
}
