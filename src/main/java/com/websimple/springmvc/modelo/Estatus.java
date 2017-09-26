package com.websimple.springmvc.modelo;

public enum Estatus {

	ACTIVE("Active"),
	INACTIVE("Inactive"),
	DELETED("Deleted"),
	LOCKED("Locked");
	
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
