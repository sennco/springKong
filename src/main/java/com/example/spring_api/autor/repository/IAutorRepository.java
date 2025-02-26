package com.example.spring_api.autor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

import com.example.spring_api.autor.model.AutorModel;

public interface IAutorRepository extends JpaRepository<AutorModel, UUID> {
    Optional<AutorModel> findByNumero(String numero);
}

