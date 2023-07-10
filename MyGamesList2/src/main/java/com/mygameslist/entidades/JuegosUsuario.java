package com.mygameslist.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="JUEGOSUSUARIOS")
public class JuegosUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2122834987674875700L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JUEGOSUSUARIOS_SEQ")
	@SequenceGenerator(sequenceName = "JUEGOSUSUARIOS_SEQ", name = "JUEGOSUSUARIOS_SEQ", allocationSize = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="juego_id")
	private Juego juego;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")

	private Usuario usuario;
	
	@Column(name="estado")
	private String estado;

	@Transient
	private Integer juego_id;
	@Transient
	private Integer usuario_id;

	public JuegosUsuario() {
		super();
	}
	
	

	public JuegosUsuario(Integer id, Juego juegoId, Usuario usuarioId, String estado) {
		super();
		this.id = id;
		this.juego = juegoId;
		this.usuario = usuarioId;
		this.juego_id = juegoId.getId();
		this.usuario_id = usuarioId.getId();
		this.estado = estado;
	}
	
	



	public Juego getJuego() {
		return juego;
	}



	public void setJuego(Juego juego) {
		this.juego = juego;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	public Integer getJuego_id() {
		return juego_id;
	}



	public void setJuego_id(Integer juego_id) {
		this.juego_id = juego_id;
	}



	public Integer getUsuario_id() {
		return usuario_id;
	}



	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, juego, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JuegosUsuario other = (JuegosUsuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(juego, other.juego)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "JuegosUsuario [id=" + id + ", estado=" + estado + ", juego="+juego+", usuario="+usuario+"]";
	}
	
	
	

}
