package com.mygameslist.repositorios;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mygameslist.entidades.JuegosUsuario;
import com.mygameslist.entidades.Usuario;

@Repository
@Qualifier("juegosUsuarioRepo")
public interface JuegosUsuarioRepository extends JpaRepository<JuegosUsuario, Integer> {

	public List<JuegosUsuario> findAllByUsuario(Usuario u);
}
