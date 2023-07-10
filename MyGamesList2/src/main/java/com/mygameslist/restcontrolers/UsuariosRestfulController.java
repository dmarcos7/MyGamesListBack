package com.mygameslist.restcontrolers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mygameslist.entidades.Juego;
import com.mygameslist.entidades.Usuario;
import com.mygameslist.servicios.UsuariosService;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
public class UsuariosRestfulController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	//find USER
	@GetMapping("/usuario/{email}")
	public Usuario getByEmail(@PathVariable("email") String email) {
		return usuariosService.getUsuarioByEmail(email);
	}
	
	@GetMapping("/usuario/nombre/{username}")
	public Usuario getByUsername(@PathVariable("username")String username) {
		return usuariosService.obtenerUsuarioPorNombre(username);
	}
	
	@PostMapping("/usuario")
	public Usuario insertarUsuario(@RequestBody Usuario u) {
		return usuariosService.generarUsuario(u);
	}
	
	

}
