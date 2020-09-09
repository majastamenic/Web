<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<body>
	<p>  Dobrodosli, <%=request.getSession().getAttribute("korisnickoIme")%> <a href="LogOutServlet">Logout</a></p><br/>
	<p>  <a href= "PregledSvihKorisnikaServlet"> Pregled svih korisnika</a></p><br/>
	<p>  <a href= "IzmenaPodatakaServlet"> Izmeni podatke</a></p><br/>
	<p>  <a href= "/PrikaziApartmanServlet" > Pregled apartmana</a></p><br/>
	<p>  <a href= "OdrzavanjeSadrzajaServlet"> Odrzavanje sadrzaja</a></p><br/>
	<p>  <a href= "PregledRezervacijaServlet"> Pregled rezervacija</a></p><br/>
	<p>  <a href= "PregledKomentaraServlet"> Pregled svih komentara</a></p><br/>
	<p>  <a href= "PretragaRezervacijaPoKorisnickomImenuServlet"> Pretraga rezervacija po korisnickom imenu gosta</a></p><br/>
	<p>  <a href= "PretragaKorisnikaServlet"> Pretraga korinika</a></p><br/>
</body>
</html>