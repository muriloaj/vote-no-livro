package com.github.muriloaj.bsf.duel.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.muriloaj.bsf.duel.book.dao.BookDAO;
import com.github.muriloaj.bsf.duel.book.dao.VoteDAO;
import com.github.muriloaj.bsf.duel.book.model.Book;
import com.github.muriloaj.bsf.duel.book.model.Vote;

@Controller
public class DoDuelController {

	@RequestMapping("/")
	public String goToIndex() {

		BookDAO dao = new BookDAO();
		if (dao.count() == 0) {
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
		return "redirect:/duelBook";
	}

	@RequestMapping("/duelBook")
	public String index(Model m) {

		List<Book> shelf = new BookDAO().randomList(2);
		m.addAttribute("bookshelf", shelf);
		List<Book> ranking = new BookDAO().listAll_ranking();
		m.addAttribute("ranking", ranking);

		return "duelBook/doDuel";
	}

	/*
	 * @RequestMapping("/voteBook") public String voteBook(int b) { Book book =
	 * new BookDAO().lookForId(b); if (book != null) { Vote vote = new Vote();
	 * vote.setBook(book); new VoteDAO().create(vote); }
	 * 
	 * return "redirect:/duelBook"; }
	 */
	@RequestMapping("/voteBook")
	public void voteBook(HttpServletResponse response, int b) {
		Book book = new BookDAO().lookForId(b);
		if (book != null) {
			Vote vote = new Vote();
			vote.setBook(book);
			new VoteDAO().create(vote);

		}

		response.setStatus(200);
		// return "redirect:/duelBook";
	}

	@RequestMapping(value = "/ajax_rankingBook", headers = "Accept=*/*", method = RequestMethod.GET)
	@ResponseBody
	public void getJSONRankingBook(HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Book> shelf = new BookDAO().listAll_ranking();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		out.write(convertToJSON(shelf));
	}

	@RequestMapping(value = "/ajax_random/{q}", headers = "Accept=*/*", method = RequestMethod.GET)
	@ResponseBody
	public void getJSONRandomBook(HttpServletResponse response,
			@PathVariable int q) {

		if (new BookDAO().count() < q) {
			response.setStatus(503);
			return;
		}

		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Book> shelf = new BookDAO().randomList(q);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		out.write(convertToJSON(shelf));
	}

	private static String convertToJSON(List<Book> shelf) {
		String json = "{\"book\": [";

		for (int i = 0; i < shelf.size(); i++) {
			json += "";
			json += "{";
			json += "\"id\": \"" + shelf.get(i).getId() + "\", ";
			json += "\"title\": \"" + shelf.get(i).getTitle() + "\", ";
			json += "\"isbn\": \"" + shelf.get(i).getIsbn() + "\", ";
			json += "\"author\": \"" + shelf.get(i).getAuthor() + "\", ";
			json += "\"edition\": \"" + shelf.get(i).getEdition() + "\", ";
			json += "\"description\": \"" + shelf.get(i).getDescription()
					+ "\"";
			json += "}";
			if (i < (shelf.size() - 1))
				json += ",";
		}
		json += "]}";

		return json;
	}

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
