package com.github.muriloaj.bsf.duel.book.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.muriloaj.bsf.duel.book.model.User;
import com.github.muriloaj.bsf.duel.dao.util.DAO;
import com.github.muriloaj.bsf.duel.dao.util.JPAUtil;

public class UserDAO {

	public void create(User user) {
		new DAO<User>(User.class).add(user);
	}

	public User LookForEmail(String email){
		
		EntityManager em = new JPAUtil().getEntityManager();
		User instance = em.find(User.class, email);
		em.close();
		return instance;
	}
	
	public void update(User user){
		new DAO<User>(User.class).update(user);
	}
	
	public List<User> listAll() {
		return new DAO<User>(User.class).listAll();
	}
}
