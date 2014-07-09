package com.github.muriloaj.bsf.duel.test.junit;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.github.muriloaj.bsf.duel.book.dao.BookDAO;
import com.github.muriloaj.bsf.duel.book.model.Book;
import com.github.muriloaj.bsf.duel.test.TST_General;

/**
 * Test Sequence to store and get the books:
 * - one book aleatory
 * - random list of books
 * - if book doesn't exists, check if return null
 * @author Murilo
 *
 */
public class TestBook_TestSuite extends TestCase{

	/***
	 * - random list of books
	 */
	@Test
	public void testGetAleatoryList(){
		System.out.println("::Execute TestBook_TestSuite -- testGetAleatoryList");
		List<Book> list1 = new BookDAO().randomList(TST_General.QUANTITY_SAMPLE_BOOK);
		List<Book> list2 = new BookDAO().randomList(TST_General.QUANTITY_SAMPLE_BOOK);
		assertNotSame(list1, list2);
		System.out.println("::Done TestBook_TestSuite -- testGetAleatoryList");
	}
	
	/**
	 * - one book aleatory
	 */
	@Test
	public void testCheckRandomBook(){
		System.out.println("::Execute TestBook_TestSuite -- testCheckRandomBook");
		List<Book> shelf = new BookDAO().randomList(TST_General.QUANTITY_SAMPLE_BOOK);
		int id = shelf.get(0).getId();
		Book book = new BookDAO().lookForId(id);
		assertNotNull(book);
		System.out.println("::Done TestBook_TestSuite -- testCheckRandomBook");
	}
	/**
	 * - one book aleatory
	 * - if book doesn't exists, check if return null
	 */
	@Test
	public void testNullBook(){
		System.out.println("::Execute TestBook_TestSuite -- testNullBook");
		Book book = new BookDAO().lookForId(-1);
		assertNull(book);
		System.out.println("::Done TestBook_TestSuite -- testNullBook");
	}

}
