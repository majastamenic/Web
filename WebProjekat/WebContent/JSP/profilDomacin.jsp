<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<body>
	<p>  Dobrodosli, <%=request.getSession().getAttribute("korisnickoIme")%> <a href="LogOutServlet">Logout</a></p><br/>

	<p>  <a href= "IzmenaPodatakaServlet"> Izmeni podatke.</a></p><br/>
	<p>  <a href= "/PregledSvihKorisnikaServlet"> Pregled korisnika koji imaju rezervaciju.</a></p><br/>
	<p>  <a href= "PretragaKorisnikaServlet"> Pretraga korinika</a></p><br/>
	
</body>
</html>