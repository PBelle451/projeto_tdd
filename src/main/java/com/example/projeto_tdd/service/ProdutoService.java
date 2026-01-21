package com.example.projeto_tdd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projeto_tdd.model.Produto;

@Service
public class ProdutoService {
    // Lógica de negócio relacionada a produtos
    public List<Produto> obterTodos() {
        // Implementação para obter todos os produtos
        List<Produto> produtos = new ArrayList<Produto>();
        return produtos;
    } 
    
    public Optional<Produto> obterPorId(Long id) {
        // Implementação para obter produto por ID
        Optional<Produto> produto = Optional.of(new Produto());
        return produto;
    }

    public Produto adicionar(Produto produto) {
        // Implementação para adicionar um novo produto
        return produto;
    }
}
