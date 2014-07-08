<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@muriloaj - Duel Book</title>
<script src="resources/js/jquery.js"></script>

<link rel="stylesheet" href="resources/css/estilos.css">

</head>
<body>

	<div id="header" align="center">
		<h1>Duelo de Livros</h1>
	</div>

	<div id="duel">
		<table id="table_duel" align="center" class="shiftcontainer">
			<tbody>
				<tr id="duelHere" class="shadowcontainer" />
			</tbody>
		</table>
	</div>
	<div id="susbscribe">
		<button onclick="javascript:subscribe()" class="rightarrowdiv"
			align="right">Mantenha-se informado: Clique e cadastre-se
			aqui!</button>
	</div>
	<div id="ranking" class="shiftcontainer">
		<table align="center" class="shadowcontainer">
			<thead>
				<tr>
					<th>#</th>
					<th>Título</th>
					<th>Autor</th>
					<th>Edição</th>
				</tr>
			</thead>

			<tbody class="shadowcontainer">
			</tbody>
		</table>
	</div>

	<div align="right" style="margin-right: 50px;">
		<hr/> 
		<sub> Developed by: @muriloaj - https://github.com/muriloaj/vote-no-livro </sub>
	</div>

	<script>
		var counter = 1;
		function vote(id) {
			//alert('vote in ' + id);
			$.get('voteBook?', {
				'b' : id
			}, function() {

				updateDuel();
				updateRanking();
			});

			if (counter++ % 10 == 0) {
				subscribe();
			}
		}

		function subscribe() {
			window
					.open(
							'subscription',
							'_subscription_',
							'height=300, width=500, location=no, menubar=no, resizable=no, status=no, titlebar=no, top=100,left=400');
		}

		function updateRanking() {
			$.getJSON('ajax_rankingBook', 'ajax/json', function(retorno) {
				$('#ranking tbody tr').remove();

				var rank = 0;
				$.each(retorno.book, function() {
					var book = this;
					rank++;
					$("#ranking tbody").append("<tr>");
					//ranking pos
					$("#ranking tbody").append(
							"<tr class=\"innerdiv\">" + "<td>" + rank + "</td>"
									+ "<td>" + book.title + "</td>" + "<td>"
									+ book.author + "</td>" + "<td>"
									+ book.edition + "</td>" + "</tr>");

				});
			});

		};

		function updateDuel() {
			$
					.getJSON(
							'ajax_random/2',
							'ajax/json',
							function(retorno) {

								$('#duelHere td').remove();

								$
										.each(
												retorno.book,
												function() {
													var book = this;
													$("#duelHere")
															.append(
																	"<td class=\"innerdiv\" align='center'>"
																			+ book.title
																			+ "<br/> "
																			+ "<div class=\"imagepluscontainer\">"
																			+ "<img src=\"./media/books/" + book.isbn + ".png\"/> <br/> "
																			+ "<div class=\"desc\">"
																			+ book.title
																			+ " - "
																			+ book.description
																			+ "</div>"
																			+ "</div>"
																			//+ "<img src=\"http://www.freegreatdesign.com/files/images/6/2921-large-apple-icon-png-3.jpg\"/> <br/> "
																			+ "<a class=\"cssbutton\"href=\"javascript:vote("
																			+ book.id
																			+ ")\" > Votar <\a><br/> "
																			+ "</td>");
												});
							});

		};

		//////////////////////////// on load function
		counter = 1;
		updateDuel();
		updateRanking();
	</script>

</body>
</html>