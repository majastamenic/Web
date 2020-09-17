<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
			<a href="/DodajRezervacijuServlet" class="btn btn-success">Dodaj rezervaciju</a>
			<a href="/VisestrukaPretragaRezervacijaServlet">Visestruka pretraga</a>
			<a href="/SortiraneRezervacijeRastuceServlet">Sortiraj rezervacije po ceni rastuce</a>
			<a href="/SortiraneRezervacijeOpadajuceServlet">Sortiraj rezervacije po ceni opadajuce</a>
		</form>
	</div>
</div>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Pregled rezervacija</title>
</head>
<body>
 <form method="POST" action="/pregledSvihRezervacijaServlet">
      <table class="table table-boardered table-striped table-hover">
      	
      
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