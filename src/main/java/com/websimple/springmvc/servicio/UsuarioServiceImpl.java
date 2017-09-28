package com.websimple.springmvc.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websimple.springmvc.dao.UsuarioDao;
import com.websimple.springmvc.modelo.Usuario;


@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao dao;

	public Usuario buscarId(int id) {
		return dao.buscarId(id);
	}

	public Usuario buscarSso(String sso) {
		return dao.buscarSSO(sso);
	}

}
