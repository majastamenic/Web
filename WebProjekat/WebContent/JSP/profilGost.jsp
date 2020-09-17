<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<p><br/></p>
<head>
<style>
body {
  background-image: url('https://cdn.cnn.com/cnnnext/dam/assets/190423135710-girls-in-car-coupons-travel-widget.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="text-right">
		<a href="LogOutServlet" class="btn btn-dark">Logout</a><br/>
	</div>
	<h3>  Dobrodosli, ${ulogovaniKorisnik.korisnickoIme} <br/></h3>
	<p><br/></p>
	<table class="table table-hover table-light">
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
	<table class="table table-hover table-light">
	<tbody>
	<tr>	
		<td></td>
		<td><a href= "/kreiranjeRezervacijeServlet" class="btn btn-info"> Kreiranje rezervacija.</a></td>
		<td><a href= "/pregledKomentaraServlet" class="btn btn-info"> Pregled komentara.</a></td>
		<td><a href= "/dodavanjeKomentaraServlet" class="btn btn-info"> Komentar .</a></td>
	</tr>
	</tbody>
	</table>
</body>
</html>