package br.unip.minicurso.service;
import java.util.List;

import br.unip.minicurso.model.dao.UsuarioDAO;
import br.unip.minicurso.model.entity.Usuario;
import br.unip.minicurso.util.JPAUtil;


public class UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	public UsuarioService() {
		usuarioDAO = new UsuarioDAO(JPAUtil.createEntityManager());
	}
	
	public Usuario getUsuario(Long usuarioId) {
		return usuarioDAO.find(Usuario.class, usuarioId);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioDAO.listar();
	}
	
	public Usuario addUsuario(Usuario usuario) throws Exception{
			usuario.setId(null);
			return usuarioDAO.add(usuario);
	}
	
	public Usuario updateUsuario(Long usuarioId, Usuario usuario) throws Exception {
		if(null == usuarioDAO.find(Usuario.class, usuarioId)) {
			throw new Exception("Usuario não encontrado!");
		}
		
		usuario.setId(usuarioId);
		usuarioDAO.update(usuario);
		return usuario;
	}
	
	public void removeUsuario(Long usuarioId) throws Exception {
		Usuario usuario = usuarioDAO.find(Usuario.class, usuarioId);
		usuarioDAO.remove(usuario);
	}
}
