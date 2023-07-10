package com.mygameslist.restcontrolers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mygameslist.entidades.Juego;
import com.mygameslist.exception.JuegosException;
import com.mygameslist.servicios.JuegosService;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
public class JuegosRestfulController {
	
	private static Logger log = LoggerFactory.getLogger(JuegosRestfulController.class);
	
	@Autowired
	private JuegosService juegosService;
	
	//FIND ALL
	@GetMapping("/juegos")
	public List<Juego> getAll(){
		return juegosService.getJuegos();
	}
	
	@GetMapping("/juego/{id}")
	public Juego getById(@PathVariable("id") Integer id) {
		
		return juegosService.getJuego(id).get();
	}
	
	@GetMapping("/juegos/{nombre}")
	public List<Juego>getByName(@PathVariable("nombre") String nombre){
		return this.juegosService.getJuegoByName(nombre);
		
	}
	
	@PostMapping("/juegos/alta")
	public Juego insertar(@RequestBody Juego j) {
		Juego j2 = new Juego();
		try {
			j2 = juegosService.generarJuego(j);
			return j2;
		} catch (JuegosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return j2;
		}
		
		
	}
	
	@DeleteMapping("/juegos/borrar/{id}")
	public void borrar(@PathVariable("id")Integer id) {
		juegosService.borrarPedido(id);
	}
	
	@PutMapping("/juegos/modificar/{id}")
	public Juego modificar(@PathVariable("id") Integer id, @RequestBody Juego j) {
		j.setId(id);
		return juegosService.modificarJuego(j);
	}
	

}
