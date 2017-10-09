package edu.cibertec.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity(name = "tb_usuario")
@NamedQuery(name="usuario.obtenerporcredenciales", query="select c from tb_usuario c where c.usuario = :u and c.clave = :c")
public class Usuario {

	@Id
	@GeneratedValue()
	@Column(name = "id_usuario")
	private int id;
	private String usuario;
	private String clave;
	private String nombre;

	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
