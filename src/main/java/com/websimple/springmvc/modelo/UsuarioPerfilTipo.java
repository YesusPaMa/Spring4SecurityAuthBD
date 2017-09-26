package com.websimple.springmvc.modelo;

public enum UsuarioPerfilTipo {
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN");
	
	String usuarioPerfilTipo;
	
	private UsuarioPerfilTipo(String usuarioPerfilTipo){
		this.usuarioPerfilTipo = usuarioPerfilTipo;
	}
	
	public String getUsuarioPerfilTipo(){
		return usuarioPerfilTipo;
	}
	
}
