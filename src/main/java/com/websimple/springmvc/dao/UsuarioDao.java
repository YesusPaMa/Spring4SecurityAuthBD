package com.websimple.springmvc.dao;

import com.websimple.springmvc.modelo.Usuario;

public interface UsuarioDao {

	Usuario buscarId(int id);
	
	Usuario buscarSSO(String sso);
	
}

