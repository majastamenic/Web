<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p><br/></p>

	<div class="col-md-4">
		<h3 style="color: black"><b>Rezervacije</b></h3>
	</div>
	<div class="col-md-4 text-right">
		<form action="/pregledSvihRezervacijaServlet" method="get">	
		<div class = "container-fluid text-right">	
		<table>	
			<td><a href="/SortiraneRezervacijeRastuceServlet">Sortiraj rezervacije po ceni rastuce</a></td>
			<td><a href="/SortiraneRezervacijeOpadajuceServlet">Sortiraj rezervacije po ceni opadajuce</a></td>
			<td><a href="/VisestrukaPretragaRezervacijaServlet" class="btn btn-info">Visestruka pretraga</a></td>
			<td><a href="/DodajRezervacijuServlet" class="btn btn-success">Dodaj rezervaciju</a></td>
			</table>
			</div>
		</form>
	</div>

<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Pregled rezervacija</title>
</head>
<body>
 <form method="POST" action="/pregledSvihRezervacijaServlet">
 <div class="conatiner">
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
      </div>
   </form>

</body>
</html>