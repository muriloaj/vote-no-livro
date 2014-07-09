package com.github.muriloaj.bsf.duel.test;

import javax.persistence.EntityManager;

import com.github.muriloaj.bsf.duel.dao.util.JPAUtil;

public class TST_General {

	/**
	 * Quantity of books to be considered in tests
	 */
	public static final int QUANTITY_SAMPLE_BOOK = 5;
	public static final int QUANTITY_SAMPLE_VOTE = 10;

	public static void reset_tables() {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.createNativeQuery("delete from vote").executeUpdate();
		em.createNativeQuery("delete from book").executeUpdate();
		em.createNativeQuery("delete from user").executeUpdate();
		em.getTransaction().commit();
		em.close();

	}

	public static void reset_tableBook() {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.createNativeQuery("delete from book").executeUpdate();
		em.getTransaction().commit();
		em.close();

	}

	public static void reset_tableVote() {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.createNativeQuery("delete from vote").executeUpdate();
		em.getTransaction().commit();
		em.close();

	}

	public static void reset_tableUser() {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.createNativeQuery("delete from user").executeUpdate();
		em.getTransaction().commit();
		em.close();

	}

}
