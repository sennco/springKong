package com.example.spring_api.livro.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.example.spring_api.autor.model.AutorModel;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "livro")
public class LivroModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String titulo;
    private String edicao;
    private String ISBN;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "numero", referencedColumnName = "numero", nullable = false)
    private AutorModel autor;

    @CreationTimestamp
    private LocalDateTime dataCriacao;
}
