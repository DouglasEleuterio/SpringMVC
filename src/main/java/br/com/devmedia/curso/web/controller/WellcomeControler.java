package br.com.devmedia.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/*
 * INformamos ao Spring que está é uma classe de Controler
 */
@Controller
public class WellcomeControler {
	
	/*
	 * Criando o metodo que abre a página wellcome.
	 */
	//Informamos que é este o metodo que página deve acessar.
	@RequestMapping(value = "/", method = RequestMethod.GET)//Qual Path representa esse metodo. Acessou a / Cai neste metodo
	// Method Get com verbo Http, como é consulta usamos o GET. GET é o atributo padrão do Method, caso não informemos o metodo.
	// Por padrão ele define sendo como Get
	
	public String wellcome(){
		// String com o nome da página. 
		//Não precisamos informar a extensão da página por que já o informamos nas Configurações 
		//o metodo responsável é o Resolver
		
		//O caminho WEB-INF/views/ Já está configurado no prefixo da Classe SpringMvcConfig
		//return "welcome";
		return "redirect:/usuario/todos";// Redirecionando a página para o controler.
		//Desta forma o List.jsp será carregado como primeira página da aplicação
	}
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ModelAndView teste (){
		ModelAndView view = new ModelAndView("welcome");//Página que quero enviar o objeto
		view.addObject("teste", "Olá fui enviado pelo Metodo ModelAndView do Wellcome Controler");
		return view;
	}
}
