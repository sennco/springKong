package com.example.spring_api.autor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_api.autor.model.AutorModel;
import com.example.spring_api.autor.repository.IAutorRepository;



@RestController
@RequestMapping("/api/v1/autor/")
public class AutorController {

@Autowired
private IAutorRepository autorRepository;

@GetMapping("/")
public String getLivro() {
    return "Olaaaa";
}

@PostMapping("/")
public AutorModel createLivro(@RequestBody AutorModel autorModel) {
     var autorCreated = this.autorRepository.save(autorModel);
     return autorCreated;
    }
}
