package br.unip.minicurso.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JPAUtil {

	private static EntityManagerFactory factory;

	public static EntityManager createEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("minicurso");
		}

		return factory.createEntityManager();
	}

}