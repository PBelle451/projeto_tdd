package com.example.projeto_tdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

//*Teste Unitário da classe de calcular comissão*/
@SpringBootTest
public class ComissaoTest {

    @TestConfiguration
    static class ComissaoConfiguracao {
        // Configurações adicionais de teste, se necessário
        @Bean
        public Comissao comissao() {
            return new Comissao();
        }
    }

    @Autowired
    Comissao comissao;

    @Test
    public void calcular_100reais(){
        // Arrange / Preparação
        Double valorVenda = 1000.00;
        Double valorComissao = 100.00;
    
        // Act / Ação
        Double valorCalculado = comissao.calcular(valorVenda);

        // Assert / Confirmação
        Assertions.assertEquals(valorComissao, valorCalculado);
    }

    @Test
    public void calcular_300reais(){
        // Arrange / Preparação
        Double valorVenda = 2000.00;
        Double valorComissao = 300.00;
    
        // Act / Ação
        Double valorCalculado = comissao.calcular(valorVenda);

        // Assert / Confirmação
        Assertions.assertEquals(valorComissao, valorCalculado);
    }
}
