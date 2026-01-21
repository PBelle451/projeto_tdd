package com.example.projeto_tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetoTddApplicationTests {

	@Test
	void contextLoads() {
	}

}

/**
 * Criar uma API de vendas
 * Venda igual ou acima de 1000 reais = 15% de desconto
 * Vendas abaixo de 1000 reais = 10% de desconto
 * 
 * Classe Comissão que tenha um método calcular que sabe calcular o valor da comissão
 * A comissão é 5% do valor da venda com desconto
 */