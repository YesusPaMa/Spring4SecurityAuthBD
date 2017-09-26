package com.websimple.springmvc.modelo;

public enum Estatus {

	ACTIVE("Activo"),
	INACTIVE("Inactivo"),
	DELETED("Eliminado"),
	LOCKED("Bloqueado");
	
	private String estatus;
	
	private Estatus(final String estatus){
		this.estatus = estatus;
	}
	
	public String getEstatus(){
		return this.estatus;
	}

	@Override
	public String toString(){
		return this.estatus;
	}

	public String getName(){
		return this.name();
	}


}
