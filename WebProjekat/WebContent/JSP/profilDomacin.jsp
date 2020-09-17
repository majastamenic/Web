<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<p>  Dobrodosli, ${ulogovaniKorisnik.korisnickoIme}  <a href="LogOutServlet">Logout</a></p><br/>

	<table class="table table-hover">
	<tbody>
	<tr>
		<td></td>
		<td><a href= "/IzmenaPodatakaServlet" class="btn btn-info"> Izmeni podatke.</a></td>
		<td><a href= "/PregledKorisnikaKojiImajuRezervacijuServlet" class="btn btn-info"> Pregled korisnika koji imaju rezervaciju.</a></td>
		<td><a href= "/PrikaziApartmanServlet" class="btn btn-info"> Pregled apartmana.</a></td>
	</tr>
	</tbody>
	</table>
	<table class="table table-hover">
	<tbody>
	<tr>	
		<td></td>
		<td></td>
		<td><a href= "/pregledRezervacijaDomacinServlet" class="btn btn-info"> Pregled rezervacija.</a></td>
		<td><a href= "/PregledKomentaraDomacinServlet" class="btn btn-info"> Pregled komentara.</a></td>
	</tr>
	</tbody>
	</table>
</body>
</html>