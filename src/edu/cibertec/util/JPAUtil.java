package edu.cibertec.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("Login JPA - JSF");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
