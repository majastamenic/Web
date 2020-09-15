<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<body>
	<p>  Dobrodosli, ${ulogovaniKorisnik.korisnickoIme} id ${ulogovaniKorisnik.getId()} <a href="LogOutServlet">Logout</a></p><br/>

	<p>  <a href= "/IzmenaPodatakaServlet"> Izmena podataka.</a></p><br/>
	<p>  <a href= "/pregledKomentaraServlet"> Pregled komentara.</a></p><br/>
	<p>  <a href= "/pregledRezervacijaServlet"> Pregled rezervacija.</a></p><br/>
	<p>  <a href= "/kreiranjeRezervacijeServlet"> Kreiranje rezervacija.</a></p><br/>
	<p>  <a href= "/dodavanjeKomentaraServlet"> Komentar .</a></p><br/>
	<p>  <a href= "/SortiranjeApartmanaServlet"> Sortiranje</a></p><br/>
	<p>  <a href="/PrikaziApartmanGostNeulogovaniServlet">Prikazi apartmane</a></p><br/>
	
</body>
</html>