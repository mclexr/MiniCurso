package br.unip.minicurso.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unip.minicurso.model.entity.Postagem;

public class PostagemDAO extends AbstractDAO<Postagem, Long> {

	public PostagemDAO(EntityManager manager) {
		super(manager);
	}

	@SuppressWarnings("unchecked")
	public List<Postagem> listarPorUsuario(Long usuarioId) {
		Query query = manager.createNamedQuery(Postagem.LISTAR_POR_USUARIO);
		return new ArrayList<Postagem>(query.getResultList());
	}
}
