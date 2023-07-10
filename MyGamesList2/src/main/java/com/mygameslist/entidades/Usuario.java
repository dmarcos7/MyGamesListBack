package com.mygameslist.entidades;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USUARIOS")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIOS_SEQ")
	@SequenceGenerator(sequenceName = "USUARIOS_SEQ", name = "USUARIOS_SEQ", allocationSize = 1)
	private Integer id;
	@Column(name="EMAIL")
	@NotNull
	private String email;
	@Column(name="USERNAME")
	@NotNull
	private String username;
	@Column(name="PASSWORD")
	@NotNull
	private String password;
	@Column(name="rol")
	@NotNull
	private String rol;
	
	@Column(name="IMAGE", columnDefinition = "varchar(255) default 'https://d500.epimg.net/cincodias/imagenes/2016/03/16/lifestyle/1458143779_942162_1458143814_noticia_normal.jpg'")
	private String imagen;
	
	
	
	public Usuario() {
		
	}

	public Usuario(Integer id, @NotNull String email, @NotNull String username, @NotNull String password, @NotNull String rol) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", userName=" + username + ", password=" + password + "]";
	}
	
	

}
