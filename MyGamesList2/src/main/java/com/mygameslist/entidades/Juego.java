package com.mygameslist.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="JUEGOS")
public class Juego implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//cambiar la secuencia a una secuencia de juegos cuando se cree la nueva base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JUEGOS_SEQ")
	@SequenceGenerator(sequenceName = "JUEGOS_SEQ", name = "JUEGOS_SEQ", allocationSize = 1)
	private Integer id;
	
	@Column(name = "TITULO")
	@NotNull
	private String titulo;
	@NotNull
	@Column(name ="DESCRIPCION")
	private String descripcion;
	
	@Column(name="IMAGEN")
	private String imageUrl;
	
	
	@Transient
	private String estado;
	
	public Juego() {
		
	}
	
	public Juego(String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(descripcion, other.descripcion) && id == other.id && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}
