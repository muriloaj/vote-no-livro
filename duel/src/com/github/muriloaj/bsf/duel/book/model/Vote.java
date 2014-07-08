package com.github.muriloaj.bsf.duel.book.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vote {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Book book;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfVote = Calendar.getInstance();

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Calendar getDateOfVote() {
		return dateOfVote;
	}

	public void setDateOfVote(Calendar dateOfVote) {
		this.dateOfVote = dateOfVote;
	}

}
