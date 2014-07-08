package com.github.muriloaj.bsf.duel.test.junit;

import junit.framework.TestCase;

import org.junit.Test;

import com.github.muriloaj.bsf.duel.book.dao.BookDAO;
import com.github.muriloaj.bsf.duel.book.dao.VoteDAO;
import com.github.muriloaj.bsf.duel.test.TST_General;
import com.github.muriloaj.bsf.duel.test.TST_Vote;

/**
 * Test Setup - set Book table with generic content, reset votes consequently.
 * 
 * @author Murilo
 * 
 */
public class TestVote_TestSetup extends TestCase {

	@Test
	public void testPopulateWithGenericVote() {
		System.out
				.println("::Execute TestVote_TestSetup -- testPopulateWithGenericVote");
		TST_General.reset_tableVote();

		if (new BookDAO().count() < TST_General.QUANTITY_SAMPLE_BOOK) {
			fail("FAIL: Missing books on book table");
		}

		int init = new VoteDAO().count();
		TST_Vote.randomVotation(TST_General.QUANTITY_SAMPLE_VOTE);
		assertEquals(init + TST_General.QUANTITY_SAMPLE_VOTE,
				new VoteDAO().count());
		System.out
				.println("::Done TestVote_TestSetup --  testPopulateWithGenericVote");
	}
}
