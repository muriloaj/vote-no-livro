package com.github.muriloaj.bsf.duel.dao.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {

	private final Class<T> classT;

	public DAO(Class<T> classT) {
		this.classT = classT;
	}

	public void add(T t) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(t);

		em.getTransaction().commit();

		em.close();
	}

	public void remove(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.remove(em.merge(t));

		em.getTransaction().commit();
		em.close();
	}

	public void update(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
		em.close();
	}

	public List<T> listAll() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classT);
		query.select(query.from(classT));

		List<T> list = em.createQuery(query).getResultList();

		em.close();
		return list;
	}

	public T lookForID(Integer integer) {
		EntityManager em = new JPAUtil().getEntityManager();
		T instance = em.find(classT, integer);
		em.close();
		return instance;
	}

	public int count(Class classT) {
		EntityManager em = new JPAUtil().getEntityManager();
		long result = (Long) em.createQuery(
				"select count(n) from " + classT.getSimpleName() + " n")
				.getSingleResult();
		em.close();

		return (int) result;
	}

	public List<T> RandomList(Class classT, int quantity) {
		EntityManager em = new JPAUtil().getEntityManager();

		List<T> list = em
				.createQuery(
						"select b from " + classT.getSimpleName()
								+ " b order by rand()").setMaxResults(quantity)
				.getResultList();

		em.close();
		return list;
	}

}
