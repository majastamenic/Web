<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<p>  Dobrodosli, ${ulogovaniKorisnik.korisnickoIme} id ${ulogovaniKorisnik.getId()} <a href="LogOutServlet">Logout</a></p><br/>
	
	<table class="table table-hover">
	<tbody>
	<tr>
		<td></td>
		<td><a href= "/IzmenaPodatakaServlet" class="btn btn-info"> Izmena podataka.</a></td>
		<td></td>
		<td></td>
		<td><a href="/PrikaziApartmanGostNeulogovaniServlet" class="btn btn-info">Prikazi apartmane</a></td>
		<td><a href= "/pregledRezervacijaServlet" class="btn btn-info"> Pregled rezervacija.</a></td>
	</tr>
	</tbody>
	</table>
	<table class="table table-hover">
	<tbody>
	<tr>	
		<td></td>
		<td><a href= "/kreiranjeRezervacijeServlet" class="btn btn-info"> Kreiranje rezervacija.</a></td>
		<td><a href= "/dodavanjeKomentaraServlet" class="btn btn-info"> Komentar .</a></td>
	</tr>
	</tbody>
	</table>
</body>
</html>