package br.com.devmedia.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Informa para o Spring que esta é uma classe de configuração.
@Configuration
//Onde o Spring busca as classes que ele deve gerenciar
@ComponentScan ("br.com.devmedia.curso")  //Adicionamos o pacote base da aplicação que o Spring faz o scanner das classes que vai gerenciar
//Informar o Spring que queremos usar o Spring MVC
@EnableWebMvc
public class RootConfig {
	
}
