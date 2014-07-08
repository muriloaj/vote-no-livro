package com.github.muriloaj.bsf.duel.book.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.github.muriloaj.bsf.duel.book.model.Book;
import com.github.muriloaj.bsf.duel.dao.util.DAO;
import com.github.muriloaj.bsf.duel.dao.util.JPAUtil;

public class BookDAO {

	public void create(Book book) {
		new DAO<Book>(Book.class).add(book);
	}

	public void remove(Book book) {
		new DAO<Book>(Book.class).remove(book);
	}

	public Book lookForId(int id) {
		return new DAO<Book>(Book.class).lookForID(id);
	}

	public int count() {
		return new DAO<Book>(Book.class).count(Book.class);
	}

	public List<Book> randomList(int quantity) {
		return new DAO<Book>(Book.class).RandomList(Book.class, quantity);
	}

	public List<Book> listAll() {
		return new DAO<Book>(Book.class).listAll();
	}

	public List<Book> listAll_ranking() {
		EntityManager manager = new JPAUtil().getEntityManager();

		Query query = manager
				.createQuery("select distinct b from Book b join fetch b.votation order by b.votation.size desc");
		List<Book> shelf = query.getResultList();

		manager.close();
		return shelf;
	}

}
