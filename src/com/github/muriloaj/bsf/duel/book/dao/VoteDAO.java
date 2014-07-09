package com.github.muriloaj.bsf.duel.book.dao;

import java.util.List;

import com.github.muriloaj.bsf.duel.book.model.Vote;
import com.github.muriloaj.bsf.duel.dao.util.DAO;

public class VoteDAO {

	public void create(Vote vote) {
		new DAO<Vote>(Vote.class).add(vote);
	}

	public int count() {
		return new DAO<Vote>(Vote.class).count(Vote.class);
	}
	
	public List<Vote> listAll() {
		return new DAO<Vote>(Vote.class).listAll();
	}
	
}
