<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<body>
	<p>  Dobrodosli, <%=request.getSession().getAttribute("korisnickoIme")%> <a href="LogOutServlet">Logout</a></p><br/>

	<p>  <a href= "IzmenaPodatakaServlet"> Izmeni podatke.</a></p><br/>
	<p>  <a href= "PrikaziApartmanServlet"> Pregled slobodnih apartmana.</a></p><br/>
	<p>  <a href= "pregledRezervacijaServlet"> Pregled rezervacija.</a></p><br/>
	
</body>
</html>