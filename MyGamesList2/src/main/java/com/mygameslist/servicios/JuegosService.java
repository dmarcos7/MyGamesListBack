package com.mygameslist.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mygameslist.entidades.Juego;
import com.mygameslist.exception.JuegosException;
import com.mygameslist.repositorios.JuegosRepository;

@Service
@Scope(value="singleton")
@Transactional(propagation = Propagation.REQUIRED)
public class JuegosService {

	private static Logger log = LoggerFactory.getLogger(JuegosService.class);
	
	@Autowired
	@Qualifier("juegosRepo")
	private JuegosRepository repo;

	public JuegosService() {
		log.info("................ Instanciando JuegosService");
	}
	
	public Juego generarJuego(Juego j) throws JuegosException {
		log.info("Generando el Juego");
		if(j.getTitulo().equals("") || j.getDescripcion().equals("")) {
			throw new JuegosException("Error No se ha podido añadir el juego");
		}
		return repo.saveAndFlush(j);
	}
	
	@Transactional(readOnly=true)
	public List<Juego> getJuegos(){
		return repo.findAll();
	}
	
	public Optional<Juego> getJuego(Integer id){
		return repo.findById(id);
	}
	
	public void borrarPedido(Integer id) {
		repo.deleteById(id);
	}
	
	public Juego modificarJuego(Juego j) {
		return repo.save(j);
	}
	
	public List<Juego> getJuegoByName(String nombre){
		return repo.findByTituloContaining(nombre.toUpperCase());
	}
	
	
}
