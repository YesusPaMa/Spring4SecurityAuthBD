package com.websimple.springmvc.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websimple.springmvc.modelo.Usuario;
import com.websimple.springmvc.modelo.UsuarioPerfil;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioService usuarioService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String ssoId)
			throws UsernameNotFoundException {
		Usuario usuario = usuarioService.buscarSso(ssoId);
		System.out.println("Usuario : "+usuario);
		if(usuario==null){
			System.out.println("Usuario no encontrado.");
			throw new UsernameNotFoundException("Nombre de usuario no encontrado.");
		}
			return new org.springframework.security.core.userdetails.User(usuario.getSsoId(), usuario.getContrasena(), 
					usuario.getEstatus().equals("Activo"), true, true, true, getGrantedAuthorities(usuario));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(Usuario user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(UsuarioPerfil usuarioPerfil : user.getUsuarioPerfiles()){
			System.out.println("UsuarioPerfil : "+usuarioPerfil);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+usuarioPerfil.getTipo()));
		}
		System.out.print("permisos :"+authorities);
		return authorities;
	}
	
}
