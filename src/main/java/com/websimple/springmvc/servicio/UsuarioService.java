package com.websimple.springmvc.servicio;

import com.websimple.springmvc.modelo.Usuario;

public interface UsuarioService {

	Usuario buscarId(int id);
	
	Usuario buscarSso(String sso);
	
}