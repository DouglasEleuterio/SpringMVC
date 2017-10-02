package br.com.devmedia.curso.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.devmedia.curso.domain.Usuario;

//Armazanamento e Persistencia, usamos Anotação Repositorie ou Component
@Repository //Quando trabalhamos com repositorios usamos a anotação para fazer da classe um Bean gerenciado pelo Spring
public class UsuarioDaoImpl implements UsuarioDao{

	private static List<Usuario> us;
	
	public UsuarioDaoImpl() {
		createUserList();
	}
	
	private List<Usuario> createUserList(){
		if (us == null) {
			us = new LinkedList<>();
			us.add(new Usuario(System.currentTimeMillis()+1l,"Ana", "da Silva"));
			us.add(new Usuario(System.currentTimeMillis()+2l,"Luiz", "Almeida"));
			us.add(new Usuario(System.currentTimeMillis()+3l,"Roberto", "Ramos"));
			us.add(new Usuario(System.currentTimeMillis()+3l,"Rosa", "Carvalho"));
			us.add(new Usuario(System.currentTimeMillis()+4l,"Meire", "da Silva Eleutério"));
			us.add(new Usuario(System.currentTimeMillis()+5l,"Samuel", "da Silva Eleuterio Ferreira"));
			us.add(new Usuario(System.currentTimeMillis()+6l,"Douglas", "Eleutério"));
			us.add(new Usuario(System.currentTimeMillis()+7l,"Maria", "de Fatima Eleutério"));
			us.add(new Usuario(System.currentTimeMillis()+8l,"Divino ", "França Ferreira "));
			us.add(new Usuario(System.currentTimeMillis()+9l,"Diogo", "Eleutério Ferreira"));
			us.add(new Usuario(System.currentTimeMillis()+10l,"Diogénes", "Eleutério Ferreira"));
		}
		return us;
	}
	
	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		us.add(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
			us.stream()
			.filter((u)-> u.getId().equals(usuario.getId()))
			.forEach((u) -> {
				u.setNome(usuario.getNome());
				u.setSobrenome(usuario.getSobrenome());
			});
	}

	@Override
	public void excluir(Long id) {
		us.removeIf((u) -> u.getId().equals(id));
	}

	@Override
	public Usuario getId(Long id) {
		return us.stream()
				.filter((u) -> u.getId().equals(id))//Filtro para localizar dentro da lista o Usuario
				.collect(Collectors.toList())// No colector recupero esse usuario
				.get(0);
	}

	@Override
	public List<Usuario> getTodos() {
		
		return us;
	}
	
	
}
