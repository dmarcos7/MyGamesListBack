package com.mygameslist.repositorios;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mygameslist.entidades.Usuario;

@Repository
@Qualifier("usuariosRepo")
public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
	
	public Usuario findByEmail(String email);
	public Usuario findByUsername(String username);

	
}
