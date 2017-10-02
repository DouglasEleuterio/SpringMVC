package br.com.devmedia.curso.config;
/*
 * Informa ao spring a maneira que queremos usar o spring mvc
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class SpringMvcConfig {
	//Anotamos com Bean para que o metodo seja gerenciado pelo spring
	@Bean
	//Como o spring vai resolver nossas páginas
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		//Foi criada a página Views dentro de WEB-INF, onde todas as nossas páginas JSP será criada.
		resolver.setPrefix("/WEB-INF/views/");//Prefixo onde o Resolver vai procurar nossas páginas
		resolver.setSuffix(".jsp");//Tipo de arquivo ou páginas que usaremos.
		resolver.setViewClass(JstlView.class);// Quais recursos será utilizados em nossas páginas
		return resolver;
	}
	//Toda classe que recebe uma anotation no cabeçalho torna um Bean e passa a ser gerenciado pelo injetor de dependencias do Spring
}
