package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@PersistenceContext
	private EntityManager em;

	public void salva(Autor autor) {
		this.em.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return this.em.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return this.em.find(Autor.class, autorId);
	}
	
}
