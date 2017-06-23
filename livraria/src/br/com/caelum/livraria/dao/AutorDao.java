package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	private Banco banco = new Banco();
	
	@PostConstruct
	void aposCriacao(){
		System.out.println("Autor Criado");
	}
	
	public void salva(Autor autor) throws Exception {	
		try {
			System.out.println("Iniciou metodo sava");
			Thread.sleep(20000);
			banco.save(autor);
			
			System.out.println("Terminou metodo salva");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
