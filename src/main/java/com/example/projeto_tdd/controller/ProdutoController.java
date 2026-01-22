package com.example.projeto_tdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_tdd.model.Produto;
import com.example.projeto_tdd.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodos() throws Exception {
        // Lógica para listar produtos
        List<Produto> produtos = produtoService.obterTodos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable Long id) {
        // Lógica para obter produto por ID
        Optional<Produto> produto = produtoService.obterPorId(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        // Lógica para adicionar produto
        Produto cadastrado = produtoService.adicionar(produto);
        return new ResponseEntity<>(cadastrado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletar(@PathVariable Long id) {
        // Lógica para deletar produto]
        Produto produto = produtoService.deletar(id);
        return new ResponseEntity<>(produto, HttpStatus.NO_CONTENT);
    }
}
