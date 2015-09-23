package br.unip.minicurso.resource;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unip.minicurso.model.dao.UsuarioDAO;
import br.unip.minicurso.model.entity.Usuario;
import br.unip.minicurso.service.UsuarioService;
import br.unip.minicurso.util.JPAUtil;

@Path("/usuarios")
public class UsuarioResource {

	private UsuarioService usuarioService;

	public UsuarioResource() {
		usuarioService = new UsuarioService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {
		return Response.ok(usuarioService.getUsuarios()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@PathParam("id") Long idUsuario) {
		return Response.ok(usuarioService.getUsuario(idUsuario)).build();

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUsuario(Usuario usuario) {
		try {
			usuarioService.addUsuario(usuario);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).build();
		}
		return Response.ok(usuario).build();
	}

	@DELETE
	@Path("/{id}")
	public Response removeUsuario(@PathParam("id") Long usuarioId) {
		try {
			usuarioService.removeUsuario(usuarioId);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).build();
		}
		return Response.noContent().build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUsuario(@PathParam("id") Long usuarioId, Usuario usuario) {
		try {
			usuarioService.updateUsuario(usuarioId, usuario);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).build();
		}
		return Response.status(Status.OK).entity(usuario).build();
	}
		
}
