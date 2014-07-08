package com.github.muriloaj.bsf.duel.test.junit;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.github.muriloaj.bsf.duel.book.dao.BookDAO;
import com.github.muriloaj.bsf.duel.book.dao.VoteDAO;
import com.github.muriloaj.bsf.duel.book.model.Book;
import com.github.muriloaj.bsf.duel.book.model.Vote;
import com.github.muriloaj.bsf.duel.test.TST_General;

/**
 * Test Sequence to store and get the books: - one book aleatory - random list
 * of books - if book doesn't exists, check if return null
 * 
 * @author Murilo
 * 
 */
public class TestVote_TestSuite extends TestCase {

	/***
	 * - check ranking
	 */
	@Test
	public static void printVotationRanking() {
		System.out
				.println("::Execute TestVote_TestSuite - printVotationRanking");

		System.out.println("Ranking of Books:");
		List<Book> shelf = new BookDAO().listAll_ranking();

		int sum = 0;
		System.out
				.println("\t | ID \t | Title \t | Votes \t || Somatory votation");
		for (Book book : shelf) {
			System.out.println("\t |" + (book.getId()) + "\t |"
					+ book.getTitle() + "\t |" + book.getVotation().size()
					+ "\t |" + "||" + (sum += book.getVotation().size()));

		}
		assertEquals(new VoteDAO().count(), sum);
		System.out.println("::Done TestVote_TestSuite - printVotationRanking");

	}

	/**
	 * - one book aleatory
	 */
	@Test
	public void testUpdateRanking() {
		System.out
				.println("::Execute TestVote_TestSuite - printVotationRanking");
		List<Book> shelf = new BookDAO().listAll_ranking();

		int id_1st_before = shelf.get(0).getId();
		Book book = shelf.get(1);

		// total of votes + 1 for 2nd place
		for (int i = 0; i <= TST_General.QUANTITY_SAMPLE_VOTE; i++) {
			Vote vote = new Vote();
			vote.setBook(book);
			new VoteDAO().create(vote);
		}

		assertNotSame(id_1st_before, new BookDAO().listAll_ranking().get(0)
				.getId());

		System.out.println("::Done TestVote_TestSuite - printVotationRanking");
	}

	/**
	 * - one book aleatory - if book doesn't exists, check if return null
	 */
	@Test
	public void testNullBook() {
		System.out.println("::Execute TestBook_TestSuite -- testNullBook");
		Book book = new BookDAO().lookForId(-1);
		assertNull(book);
		System.out.println("::Done TestBook_TestSuite -- testNullBook");
	}

}
