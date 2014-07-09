package com.github.muriloaj.bsf.duel.book.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	@Type(type = "text")
	private String description;
	private String isbn;
	private String author;
	private String edition;
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
	private List<Vote> votation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public List<Vote> getVotation() {
		return votation;
	}

	public void setVotation(List<Vote> votation) {
		this.votation = votation;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str = str.append(getTitle());
		str = str.append(" ; " + getDescription());
		str = str.append(" ; " + getAuthor());
		str = str.append(" ; " + getEdition());
		return null;
	}

}
