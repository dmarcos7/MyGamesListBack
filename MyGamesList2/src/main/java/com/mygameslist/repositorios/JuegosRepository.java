package com.mygameslist.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mygameslist.entidades.Juego;

@Repository
@Qualifier("juegosRepo")
public interface JuegosRepository extends JpaRepository<Juego, Integer>{
	static final String SQL_BUSCAR_TITULO="SELECT j FROM Juego j WHERE UPPER(j.titulo) LIKE "+"%?1%";
	
	@Query("SELECT j FROM Juego j WHERE j.id=?1")
	public Juego getById(Integer id);
	
	@Query(SQL_BUSCAR_TITULO)
	public List<Juego> findByTituloContaining(String nombre);

}
