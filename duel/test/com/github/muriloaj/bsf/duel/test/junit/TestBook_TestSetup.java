package com.github.muriloaj.bsf.duel.test.junit;

import junit.framework.TestCase;

import org.junit.Test;

import com.github.muriloaj.bsf.duel.book.dao.BookDAO;
import com.github.muriloaj.bsf.duel.test.TST_Book;
import com.github.muriloaj.bsf.duel.test.TST_General;

/**
 * Test Setup
 *  - set Book table with generic content, reset votes consequently.
 * @author Murilo
 *
 */
public class TestBook_TestSetup extends TestCase{

	@Test
	public void testPopulateWithGenericBook(){
		System.out.println("::Execute TestBook_TestSetup -- testPopulateWithGenericBook");
		TST_General.reset_tableVote();
		TST_General.reset_tableBook();
		int init = new BookDAO().count();
		TST_Book.populateGenericBook(TST_General.QUANTITY_SAMPLE_BOOK, "TEST");
		assertEquals(init + TST_General.QUANTITY_SAMPLE_BOOK,  new BookDAO().count());
		System.out.println("::Done TestBook_TestSetup --  testPopulateWithGenericBook");
	}
	

}
