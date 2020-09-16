<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<p><br/></p>
<div class ="row">
	<div class="col-md-4">
		<h3>Pregled rezervacija</h3>
	</div>
	<div class="col-md-4">
		<form action="/pregledSvihRezervacijaServlet" method="get">
			<input type="text" name="pretraga" class = "form-control" placeholder="Pretraga...">
			<input type="submit" value="Pretraga">
			<a href="/DodajRezervacijuServlet" class="btn btn-primary">Dodaj rezervaciju</a>
			<a href="/VisestrukaPretragaRezervacijaServlet">Visestruka pretraga</a>
		</form>
	</div>
</div>
<head>
<meta charset="UTF-8">
<title>Pregled rezervacija</title>
</head>
<body>
 <form method="POST" action="/pregledSvihRezervacijaServlet">
      <table>
      
         <tr>
         <td>Rezervisan apartman:</td>
            <td>Broj nocenja:</td>
            <td>Cena:</td>
            <td>Status:</td>
            <td>Gost:</td>
            
         </tr>  
         <c:forEach items="${rezervacije}" var="rezervacija">    
         <tr>
            <td> ${rezervacija.getRezervisanApartman().getId()} </td>
            <td> ${rezervacija.getBrojNocenja()}</td>
            <td> ${rezervacija.getUkupnaCena()}</td>
            <td> ${rezervacija.getStatus()}</td>
            <td> ${rezervacija.getGost().getId()}</td>
            
         </tr>
         </c:forEach>
         
      </table>
   </form>

</body>
</html>