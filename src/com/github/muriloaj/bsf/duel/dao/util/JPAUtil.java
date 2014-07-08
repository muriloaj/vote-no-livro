package com.github.muriloaj.bsf.duel.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	// private static EntityManagerFactory emf =
	// Persistence.createEntityManagerFactory("duelBook-mysql");
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("duelBook-hsqldb");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(EntityManager em) {
		em.close();
	}
}
