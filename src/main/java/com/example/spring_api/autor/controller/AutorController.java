package com.example.spring_api.autor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring_api.autor.model.AutorModel;
import com.example.spring_api.autor.repository.IAutorRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/autor/")
public class AutorController {

    @Autowired
    private IAutorRepository autorRepository;

    
    @GetMapping("/{numero}")
    public ResponseEntity<?> getAutor(@PathVariable String numero) {
        Optional<AutorModel> autor = autorRepository.findByNumero(numero);  

        if (autor.isEmpty()) {
            return ResponseEntity.status(404).body("Autor com número " + numero + " não encontrado.");  // Retorna 404 com mensagem personalizada
        }

        return ResponseEntity.ok(autor.get());  
    }

    
    @GetMapping("/")
    public List<AutorModel> getAllAutores() {
        return autorRepository.findAll();  
    }

    
    @PostMapping("/")
    public AutorModel createAutor(@RequestBody AutorModel autorModel) {
        var autorCreated = this.autorRepository.save(autorModel);
        return autorCreated;
    }
}
