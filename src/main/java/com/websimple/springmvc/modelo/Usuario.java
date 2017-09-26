package com.websimple.springmvc.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="APP_USUARIO")
public class Usuario {

	@Id
	@Column(name="id_usuario")
	private int id;

	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;
	
	@Column(name="contrasena", nullable=false)
	private String contrasena;
		
	@Column(name="nombre", nullable=false)
	private String nombre;

	@Column(name="apellido", nullable=false)
	private String apellido;

	@Column(name="email", nullable=false)
	private String email;

	@Column(name="estatus", nullable=false)
	private String estatus=Estatus.ACTIVE.getEstatus();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "APP_USUARIO_USUARIO_PERFIL", 
             joinColumns = { @JoinColumn(name = "usuario_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "usuario_perfil_id") })
	private Set<UsuarioPerfil> usuarioPerfiles = new HashSet<UsuarioPerfil>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Set<UsuarioPerfil> getUsuarioPerfiles() {
		return usuarioPerfiles;
	}

	public void setUsuarioPerfiles(Set<UsuarioPerfil> usuarioPerfiles) {
		this.usuarioPerfiles = usuarioPerfiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		if (ssoId == null) {
			if (other.ssoId != null)
				return false;
		} else if (!ssoId.equals(other.ssoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", ssoId=" + ssoId + ", contraseña=" + contrasena
				+ ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", estatus=" + estatus + ", usuarioPerfiles=" + usuarioPerfiles +"]";
	}

	
}
