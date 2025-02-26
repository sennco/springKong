package com.example.spring_api.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

import com.example.spring_api.autor.model.AutorModel;
import com.example.spring_api.livro.model.LivroModel;

public interface ILivroRepository extends JpaRepository<LivroModel, UUID> {
    List<LivroModel> findByAutor(AutorModel autor);

}

