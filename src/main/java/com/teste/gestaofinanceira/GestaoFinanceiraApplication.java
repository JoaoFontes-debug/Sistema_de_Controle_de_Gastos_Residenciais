package com.teste.gestaofinanceira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoFinanceiraApplication {
	/**
	 * OBS: utilize o link no seu navegador para testa a API
	 *
	 * http://localhost:8080/swagger-ui/index.html#/
	 *Para testar a API é simples basta executar o programa
	 * e abrir o link(http://localhost:8080/swagger-ui/index.html#/) do swagger
	 * no seu navegador, depois é só clicar em "try out" e depois em "execute"
	 */
	public static void main(String[] args) {
		SpringApplication.run(GestaoFinanceiraApplication.class, args);

	}

}
