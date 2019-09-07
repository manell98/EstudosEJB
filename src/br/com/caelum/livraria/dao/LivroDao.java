package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager em;
	
	private DAO<Livro> livroDao;
	
	@PostConstruct
	void init() {
		this.livroDao = new DAO<Livro>(this.em, Livro.class);
	}
	
	public void salva(Livro livro) {
		this.livroDao.adiciona(livro);
	}
	
	public List<Livro> todosLivros() {
		return this.livroDao.listaTodos();
	}
	
}
