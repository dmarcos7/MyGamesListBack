package com.mygameslist.restcontrolers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mygameslist.entidades.Juego;
import com.mygameslist.entidades.JuegosUsuario;
import com.mygameslist.servicios.JuegosUsuarioService;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
public class JuegosUsuarioRestfulController {

private static Logger log = LoggerFactory.getLogger(JuegosRestfulController.class);
	
	@Autowired
	private JuegosUsuarioService juegosUsuarioService;
	
	//FIND ALL
	@GetMapping("/usuario/juegos/{username}")
	public List<Juego> getAll(@PathVariable("username") String username){
		return juegosUsuarioService.obtenerJuegosUsuario(username);
	}
	
	@PostMapping("/usuario/juegos/insertar")
	public JuegosUsuario insertar(@RequestBody JuegosUsuario juego) {
		return juegosUsuarioService.insertar(juego);
	}
	

}
