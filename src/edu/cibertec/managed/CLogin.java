package edu.cibertec.managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import edu.cibertec.beans.Usuario;
import edu.cibertec.util.JPAUtil;

@SessionScoped
@ManagedBean
public class CLogin {

	private Usuario usuario = new Usuario();
	private String mensaje;

	@PostConstruct
	public void init(){
		JPAUtil.getEntityManager();
	}
	
	public String validar(){
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Usuario> u = entityManager.createNamedQuery("usuario.obtenerporcredenciales", Usuario.class).setParameter("u", usuario.getUsuario()).setParameter("c", usuario.getClave())
				.getResultList();
		if(u.isEmpty()){
			mensaje = "Usuario o clave incorrecto";
			return null;
		}
		usuario = u.get(0);
		return "bienvenido";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
