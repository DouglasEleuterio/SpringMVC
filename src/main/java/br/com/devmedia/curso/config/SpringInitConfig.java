package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * Esta classe visa substituir o arquivo web.xml para fazer as configurações da aplicação. 
 */
public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	/*
	 * Adicionando nossa classe raiz do projeto
	 */
	protected Class<?>[] getRootConfigClasses() {
		//Informa para o Spring que ao subir a aplicação essa será a primeira classe de configuração a carregar.
		return new Class[] {RootConfig.class};
	}
	
	/*
	 * Qual classe contém as configurações de servlet
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {SpringMvcConfig.class}; //Quando for trabalhar com Servlet vai usar as configurações da classe citada 
	}

	@Override
	protected String[] getServletMappings() {
		
		
		
		/*
		 * Encontrando a / Saberá que esta trabalhando com Servlet
		 */
		return new String[] {"/"};//Mapeamento dos Servlets
	} 

}
