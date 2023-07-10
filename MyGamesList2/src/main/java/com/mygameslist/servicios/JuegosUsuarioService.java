package com.mygameslist.servicios;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mygameslist.entidades.Juego;
import com.mygameslist.entidades.JuegosUsuario;
import com.mygameslist.entidades.Usuario;
import com.mygameslist.repositorios.JuegosUsuarioRepository;

@Service
@Scope(value="singleton")
@Transactional(propagation = Propagation.REQUIRED)
public class JuegosUsuarioService {
	
	private static Logger log = LoggerFactory.getLogger(JuegosService.class);
	
	@Autowired
	@Qualifier("juegosUsuarioRepo")
	private JuegosUsuarioRepository repo;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private JuegosService juegosService;

	public JuegosUsuarioService() {
		log.info("................ Instanciando JuegosService");
	}
	
	public List<Juego> obtenerJuegosUsuario(String username){
		Usuario u = usuariosService.obtenerUsuarioPorNombre(username);
		List<JuegosUsuario> listaJuegoUsuario = repo.findAllByUsuario(u); 
		List<Juego> juegos= new ArrayList<Juego>();
		for(JuegosUsuario j:listaJuegoUsuario) {
			Juego j2 = juegosService.getJuego(j.getJuego().getId()).get();
			j2.setEstado(j.getEstado());
			juegos.add(j2);
		}
		
		return juegos;
	}
	
	public JuegosUsuario insertar(JuegosUsuario juego) {
		
		return this.repo.save(juego);
	}
	
	
}
