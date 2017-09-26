package com.websimple.springmvc.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websimple.springmvc.modelo.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	public Usuario buscarId(int id) {
		return getByKey(id);
	}

	public Usuario buscarSSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (Usuario) crit.uniqueResult();
	}

	
}
