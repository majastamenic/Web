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
	 
	<div class="text-right">
		<a href="LogOutServlet" class="btn btn-dark">Logout</a><br/>
	</div>
	<h3>  Dobrodosli, ${ulogovaniKorisnik.korisnickoIme} <br/></h3>
	<p><br/></p>
	<table class="table table-hover">
	<tbody>
	<tr>
		<td></td>
		<td><a href= "/IzmenaPodatakaServlet" class="btn btn-info"> Izmeni podatke.</a></td>
		<td><a href= "/PregledSvihKorisnikaServlet" class="btn btn-info"> Pregled korisnika koji imaju rezervaciju.</a></td>
		<td><a href= "/PrikaziApartmanServlet" class="btn btn-info"> Pregled apartmana.</a></td>
	</tr>
	</tbody>
	</table>
	<table class="table table-hover">
	<tbody>
	<tr>	
		<td></td>
		<td></td>
		<td><a href= "/pregledRezervacijaServlet" class="btn btn-info"> Pregled rezervacija.</a></td>
		<td><a href= "/PregledKomentaraServlet" class="btn btn-info"> Pregled komentara.</a></td>
	</tr>
	</tbody>
	</table>
</body>
</html>