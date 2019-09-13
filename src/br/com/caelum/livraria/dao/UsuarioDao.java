package br.com.caelum.livraria.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager em;
	
	private DAO<Usuario> usuarioDao;
	
	@PostConstruct
	void init() {
		this.usuarioDao = new DAO<Usuario>(this.em, Usuario.class);
	}
	
	public Usuario buscaPeloLogin(String login) {		
		return this.usuarioDao.buscaPeloLogin(login);
	}
	
}
