<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/JS/bootstrap.min.js"></script>
</head>
<body>
	<p>
		Dobrodosli, ${ulogovaniKorisnik.korisnickoIme}  
	 <a href="LogOutServlet">Logout</a>
	</p>
	<br />
	
	<table class="table table-hover">
	<tbody>
	<tr>
		<td></td>
		<td><a href="IzmenaPodatakaServlet" class="btn btn-info"> Izmeni podatke</a></td>
		<td><a href="/PregledSvihKorisnikaServlet" class="btn btn-info"> Pregled svih korisnika</a></td>
		<td><a href="/DodajApartmanServlet" class="btn btn-info"> Dodaj apartman</a></td>
	</tr>
	<tr></tr>
	</tbody>
	</table>
	<table class="table table-hover">
	<tbody>
	<tr>	
		<td></td>
		<td><a href="/PrikaziApartmanServlet" class="btn btn-info"> Pregled apartmana</a></td>
		<td><a href="/OdrzavanjeSadrzajaServlet" class="btn btn-info"> Odrzavanje sadrzaja</a></td>
		<td><a href="/pregledSvihRezervacijaServlet" class="btn btn-info"> Pregled rezervacija</a></td>
		<td><a href="/PregledKomentaraServlet" class="btn btn-info"> Pregled svih komentara</a></td>
	</tr>
	</tbody>
	</table>

</body>
</html>