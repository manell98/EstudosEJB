package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@PersistenceContext
	private EntityManager em;
	
	private DAO<Autor> autorDao;
	
	@PostConstruct
	void init() {
		this.autorDao = new DAO<Autor>(this.em, Autor.class);
	}

	public void salva(Autor autor) {
		this.autorDao.adiciona(autor);
	}
	
	public List<Autor> todosAutores() {
		return this.autorDao.listaTodos();
	}

	public Autor buscaPelaId(Integer autorId) {
		return this.autorDao.buscaPorId(autorId);
	}
	
}
