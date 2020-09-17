<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p></br></p>

<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Pregled rezervacija</title>
</head>
<body>

<form method="POST" action="/pregledRezervacijaServlet">
<div class = "container">
	<div class="col-md-4">
		<h3 style="color: black"><b>Rezervacije</b></h3>
	</div>
	<p><br/></p>
	<a href="SortiraneRezervacijeRastuceServlet">Sortiraj rezervacije po ceni rastuce</a>
	<a href="SortiraneRezervacijeOpadajuceServlet">Sortiraj rezervacije po ceni opadajuce</a>
	
		
      <table class="table table-boardered table-striped table-hover">
      
         <tr>
         	<td>Rezervisan apartman:</td>
            <td>Broj nocenja:</td>
            <td>Cena:</td>
            <td>Status:</td>
            
           
         </tr>  
         <c:forEach items="${ulogovaniKorisnik.rezervacije}" var="rezervacija"> 
            
         <tr>
            <td> ${rezervacija.getRezervisanApartman().getId()} </td>
            <td> ${rezervacija.getBrojNocenja()}</td>
            <td> ${rezervacija.getUkupnaCena()}</td>
            <td> ${rezervacija.getStatus()}</td>

    <c:if test="${rezervacija.getStatus().equals('Kreirana')}" var="condition">
        <td><a href="OdustanakRezervacijeServlet">Odustanak</a></td>
    </c:if>

           
         </tr>
         </c:forEach>
         
      </table>
     </div> 
   </form>

</body>
</html>