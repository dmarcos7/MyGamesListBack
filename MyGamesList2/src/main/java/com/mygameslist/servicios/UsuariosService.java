package com.mygameslist.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mygameslist.entidades.Usuario;
import com.mygameslist.repositorios.UsuariosRepository;

@Service
@Scope(value = "singleton")
@Transactional(propagation = Propagation.REQUIRED)
public class UsuariosService {

	private static Logger log = LoggerFactory.getLogger(UsuariosService.class);

	@Autowired
	@Qualifier("usuariosRepo")
	private UsuariosRepository repo;

	public UsuariosService() {
		log.info(".................. Instanciando UsuariosService");
	}

	public Usuario getUsuarioByEmail(String email) {
		return repo.findByEmail(email);
	}

	public Usuario generarUsuario(Usuario u) {

		return repo.saveAndFlush(u);

	}
	
	public Usuario obtenerUsuarioPorNombre(String username) {
		
		return repo.findByUsername(username);
	}
	
	
}
