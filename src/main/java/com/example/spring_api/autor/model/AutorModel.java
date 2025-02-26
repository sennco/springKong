package com.example.spring_api.autor.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "autor")
public class AutorModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;

    @Column(unique = true, nullable = false)
    private String numero;

    @CreationTimestamp
    private LocalDateTime dataCriacao;
}
