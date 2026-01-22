package com.example.projeto_tdd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.projeto_tdd.model.Produto;
import com.example.projeto_tdd.service.ProdutoService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest
public class ProdutoControllerTest {
    // -MockMvc;
    // -Mockito;
    // -Mock; 
    
    @Autowired
    private ProdutoController produtoController;

    @MockitoBean
    private ProdutoService produtoService;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void setup() {
        // Aqui será executado antes de qualquer caso de teste.
        this.mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
    }

    @Test
    public void deve_retornar_status_200_OK_ao_chamar_o_metodo_obter_todos() throws Exception {
        // Arrange / Preparação
        List<Produto> produtos = new ArrayList<>();
        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos");
        when(this.produtoService.obterTodos()).thenReturn(produtos);

        // Act / Ação
        this.mockMvc.perform(requestBuilder)
        
        // Assert / Confirmação
        .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void deve_retornar_o_produto_por_id() throws Exception {
        // Arrange / Preparação
        Produto produto = new Produto();
        produto.setId(2l);
        produto.setNome("Martelo");
        produto.setQuantidade(10);
        produto.setValor(50.0);
        Optional<Produto> produtoOpt = Optional.of(produto);
        when(this.produtoService.obterPorId(2l)).thenReturn(produtoOpt);
        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos/2");
        when(this.produtoService.obterPorId(2l)).thenReturn(produtoOpt);

        // Act / Ação
        this.mockMvc.perform(requestBuilder)
        
        // Assert / Confirmação
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2l))
        .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Martelo"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.quantidade").value(10))
        .andExpect(MockMvcResultMatchers.jsonPath("$.valor").value(50.0));

    }

    @Test
    public void deve_adicionar_um_novo_produto() throws Exception {
        // Arrange / Preparação
        Produto produto = new Produto();
        produto.setId(3l);
        produto.setNome("Serrote");
        produto.setQuantidade(5);
        produto.setValor(80.0);

        when(this.produtoService.adicionar(produto)).thenReturn(produto);

        var requestBuilder = MockMvcRequestBuilders.post("/api/produtos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(produto));

        // Act / Ação
        this.mockMvc.perform(requestBuilder)
        
        // Assert / Confirmação
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(3l))
        .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Serrote"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.quantidade").value(5))
        .andExpect(MockMvcResultMatchers.jsonPath("$.valor").value(80.0));
    }

    @Test
    public void deve_deletar_um_produto() throws Exception {
        // Arrange / Preparação
        Produto produto = new Produto();
        produto.setId(4l);
        produto.setNome("Alicate");
        produto.setQuantidade(15);
        produto.setValor(30.0);

        when(this.produtoService.deletar(4l)).thenReturn(produto);

        var requestBuilder = MockMvcRequestBuilders.delete("/api/produtos/4");

        // Act / Ação
        this.mockMvc.perform(requestBuilder)
        
        // Assert / Confirmação
        .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
