package com.github.muriloaj.bsf.duel.test;

import java.util.List;
import java.util.Random;

import com.github.muriloaj.bsf.duel.book.dao.BookDAO;
import com.github.muriloaj.bsf.duel.book.dao.VoteDAO;
import com.github.muriloaj.bsf.duel.book.model.Book;
import com.github.muriloaj.bsf.duel.book.model.Vote;

public class TST_Vote {

	public static void randomVotation(int numOfVotes) {
		List<Book> shelf = new BookDAO().listAll();
		Random rand = new Random();
		for (int i = 0; i < numOfVotes; i++) {
			int bookId = rand.nextInt(shelf.size());
			System.out.println("\t Vote in " + shelf.get(bookId).getId() + "\t"
					+ shelf.get(bookId).getTitle());
			Vote vote = new Vote();
			vote.setBook(shelf.get(bookId));
			new VoteDAO().create(vote);
		}
	}

	public static void printCounter() {
		System.out.println("Print counter");
		System.out.println("\t- Votes: " + new VoteDAO().count());
	}

	public static void printVotationRanking() {
		System.out.println("Ranking of Books:");
		List<Book> shelf = new BookDAO().listAll_ranking();

		int x = 0;
		System.out
				.println("\t | ID \t | Title \t | Votes \t || Somatory votation");
		for (Book book : shelf) {
			System.out.println("\t |" + (book.getId()) + "\t |"
					+ book.getTitle() + "\t |" + book.getVotation().size()
					+ "\t |" + "||" + (x += book.getVotation().size()));

		}

	}

}
