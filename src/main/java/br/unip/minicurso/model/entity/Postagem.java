package br.unip.minicurso.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Calendar;

@Entity(name="Postagem")
@NamedQuery(name = Postagem.LISTAR_POR_USUARIO, query = "SELECT p FROM Postagem p WHERE p.usuario.id = :usuarioId")
public class Postagem {

	public static final String LISTAR_POR_USUARIO = "Postagem.listarPorUsuario";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="postagem_seq")
	@SequenceGenerator(name="postagem_seq", sequenceName="postagem_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	private String conteudo;

	@Temporal(TemporalType.DATE)
	private Calendar dataPostagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Calendar getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Calendar dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result
				+ ((dataPostagem == null) ? 0 : dataPostagem.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Postagem other = (Postagem) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (dataPostagem == null) {
			if (other.dataPostagem != null)
				return false;
		} else if (!dataPostagem.equals(other.dataPostagem))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
