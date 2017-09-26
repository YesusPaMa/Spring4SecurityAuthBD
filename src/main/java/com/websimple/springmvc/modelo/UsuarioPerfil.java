package com.websimple.springmvc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO_PERFIL")
public class UsuarioPerfil {

	@Id
	@Column(name="id_perfil")
	private int id;	

	@Column(name="tipo", length=15, unique=true, nullable=false)
	private String tipo = UsuarioPerfilTipo.USER.getUsuarioPerfilTipo();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UsuarioPerfil))
			return false;
		UsuarioPerfil other = (UsuarioPerfil) obj;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ",  tipo=" + tipo	+ "]";
	}
	

}
