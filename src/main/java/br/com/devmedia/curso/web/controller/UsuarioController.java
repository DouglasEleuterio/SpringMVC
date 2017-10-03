package br.com.devmedia.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devmedia.curso.dao.UsuarioDao;
import br.com.devmedia.curso.domain.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	//Injetando o UsuarioDao 
	@Autowired
	private UsuarioDao dao;
	
	//Parte de listagem de Usuarios
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("usuarios",dao.getTodos());
		return new ModelAndView("/user/list", model);
	}
	
	//Parte de cadastro de novos usuarios
	
	//Metodo para direcionar para página de cadastro
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("usuario")Usuario usuario, ModelMap model) {
		return "/user/add";
	}

	
	//Metodo para receber o formulario que sera enviado
	@PostMapping("/save")
	public String save(@ModelAttribute("usuario")Usuario usuario, ModelMap model) { //Se eu passar a mesagem via ModelMap ela não chegará até a página, por que este metodo não devolve objetos como resposta {
		dao.salvar(usuario);
		//attr.addFlashAttribute("message", "Usuário salvo com sucesso.");//Enviar no redirect qualquer tipo de váriavel
		return "redirect:/usuario/todos";
	}
	
	//Edição de Usuarios 
	//Primeira parte localiza o usuario que iremos alterar
	@GetMapping("/update/{id}")
	public ModelAndView preUpddate(@PathVariable("id")Long id, ModelMap model){ // PathVariable captura a informaçao que recebemos na URL e adiciona ao objeto
		Usuario usuario = dao.getId(id); //  Pego o id do PathVariable e passo como parametro para o dao.getId (id)
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/user/add", model);
	}
	
	//Segunda parte fará ação de Update
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute("usuario")Usuario usuario, RedirectAttributes attr){
		dao.editar(usuario);
		attr.addFlashAttribute("message", "Usuario alterado com sucesso.");
		return new ModelAndView("redirect:/usuario/todos");
		
	}
}
