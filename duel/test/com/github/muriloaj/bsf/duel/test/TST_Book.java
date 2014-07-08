package com.github.muriloaj.bsf.duel.test;

import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import com.github.muriloaj.bsf.duel.book.dao.BookDAO;
import com.github.muriloaj.bsf.duel.book.model.Book;

public class TST_Book  extends TestCase {

	
	public static void populateUsingRealBook() {
		BookDAO dao = new BookDAO();
		/*
		 * Baseado em:
		 * http://www.sitedecuriosidades.com/curiosidade/top-10-livros-mais-vendidos-em-2014.html 24/06/2014
		 * */
		dao.create(createBook("A culpa � das estrelas","9789892320946","1.a","John Green","A hist�ria � narrada por uma paciente com c�ncer de 16 anos de idade, chamada Hazel Grace, que � for�ada por seus pais a participar de um grupo de apoio, onde posteriormente se encontra e se apaixona por Augustus Waters, de 17 anos, ex-basquetebolista amputado."));
		dao.create(createBook("Destrua esse di�rio"   ,"9788580574166" ,"1.a","Keri Smith","Um di�rio costuma servir para anotar ideias, mem�rias ou registros do cotidiano. Keri Smith, ilustradora e artista canadense, inventou um tipo diferente de di�rio, que exige do usu�rio uma intera��o mais l�dica e inusitada."));
		dao.create(createBook("A menina que roubava livros","9788598078175","1.a","Markus Zusak","� um drama do escritor australiano Markus Zusak, publicado em 2005 pela editora Picador.3 No Brasil e em Portugal, foi lan�ado pela Intr�nseca e a Presen�a, respectivamente. O livro � sobre Liesel Meminger, uma garota que encontra a Morte tr�s vezes durante 1939�43 na Alemanha nazista."));
		dao.create(createBook("Ansiedade: Como enfrentar o mal do s�culo","9788502218482","1.a","Augusto Cury"," Considerada pelo psiquiatra Augusto Cury como o novo mal do s�culo, suplantando a depress�o, ela acomete grande parte da popula��o mundial. Neste livro, voc� entender� como funciona a mente humana para ser capaz de desacelerar seu pensamento, gerir sua emo��o de maneira eficaz e resgatar sua qualidade de vida."));
		dao.create(createBook("Assassinato de reputa��es","9788574752280","1.a","Romeu Tuma Junior","Tuma Jr denuncia o que ele considera como aparelhamento do governo pelo Partido dos Trabalhadores para cometer crimes, em especial pedidos heterodoxos feitos a ele quando Secret�rio no Minist�rio da Justi�a, e que Lu�s In�cio Lula da Silva teria sido informante do governo militar."));
	}

	public static void populateGenericBook(int quantity, String prefix) {

		for (int i = 1; i <= quantity; i++) {
			String title = "Title " + prefix + i;
			String description = "Description about book " + prefix + i;
			String isbn = "11-" + i;
			String author = "Generic Author " + prefix + i;
			String edition = (new Random().nextInt(10) + 1) + "th Edition";
			Book b = createBook(title, description, isbn, author, edition);
			new BookDAO().create(b);
		}
	}

	public static void printCounter() {
		System.out.println("Print counter");
		System.out.println("\t- Book: " + new BookDAO().count());
	}

	public static void printListOfBooks() {
		System.out.println("List of Books:");
		List<Book> shelf = new BookDAO().listAll();
		for (Book book : shelf) {
			System.out.println("\t " + (book.getId()) + ": \t"
					+ book.getTitle());
		}
		System.out.println("\t Total: " + shelf.size());

	}

	public static void printRandom(int quantity) {
		List<Book> shelf = new BookDAO().randomList(quantity);
		System.out.println("Random list with " + quantity + " books");
		for (int i = 0; i < quantity; i++) {
			System.out.println("\t " + shelf.get(i).getId() + ": \t"
					+ shelf.get(i).getTitle());
		}

	}

	public static void printRandomUsingLookForId() {
		List<Book> shelf = new BookDAO().randomList(2);
		int id = shelf.get(0).getId();
		Book book = new BookDAO().lookForId(id);
		System.out.println("\t" + book.getId() + "\t" + book.getTitle());

	}

	// //////////////////////////////////////////////////
	// /////AUXILIAR METHODS/////////////////////////////
	// //////////////////////////////////////////////////

	public static Book createBook(String title, String isbn, String edition,
			String author, String description) {

		Book book = new Book();
		book.setTitle(title);
		book.setDescription(description);
		book.setIsbn(isbn);
		book.setAuthor(author);
		book.setEdition(edition);

		return book;
	}

}
