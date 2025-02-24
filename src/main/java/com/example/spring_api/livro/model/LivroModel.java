package com.example.spring_api.livro.model;

import lombok.Data;

@Data
public class LivroModel {

    private String titulo;
    private String edicao;
    private String ISBN;
    private String Categoria;
}
