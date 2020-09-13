<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<body>
	<p>  Dobrodosli, ${ulogovaniKorisnik.korisnickoIme} id ${ulogovaniKorisnik.getId()} <a href="LogOutServlet">Logout</a></p><br/>

	<p>  <a href= "IzmenaPodatakaServlet"> Izmeni podatke.</a></p><br/>
	<p>  <a href= "/PregledSvihKorisnikaServlet"> Pregled korisnika koji imaju rezervaciju.</a></p><br/>
	<p>  <a href= "PretragaKorisnikaServlet"> Pretraga korinika</a></p><br/>
	<p>  <a href= "AktivniApartmaniServlet"> Pregled aktivnih apartmana.</a></p><br/>
	<p>  <a href= "NeaktivniApartmaniServlet"> Pregled neaktivnih apartmana.</a></p><br/>
	<p>  <a href= "IzmenaApartmanaServlet"> Izmeni apartman.</a></p><br/>
	<p>  <a href= "DodajApartmanServlet"> Dodaj apartman.</a></p><br/>
	<p>  <a href= "pregledRezervacijaServlet"> Pregled rezervacija.</a></p><br/>
	<p>  <a href= "PregledKomentaraServlet"> Pregled komentara.</a></p><br/>
	
</body>
</html>