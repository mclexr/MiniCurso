package br.unip.minicurso.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unip.minicurso.model.entity.Usuario;

public class UsuarioDAO extends AbstractDAO<Usuario, Long> {

	public UsuarioDAO(EntityManager manager) {
		super(manager);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		Query query = manager.createNamedQuery(Usuario.LISTAR_TODOS_USUARIOS);
		return new ArrayList<Usuario>(query.getResultList());
	}
}
