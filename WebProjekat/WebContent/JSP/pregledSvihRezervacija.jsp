<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p><br/></p>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Rezervacije</title>
</head>
<body>
 <form method="POST" action="/pregledSvihRezervacijaServlet">
 <div class="conatiner">
		<h3 style="color: black"><b>Rezervacije</b></h3>
		<p><br/></p>
			<a href="/SortiraneRezervacijeRastuceServlet">Sortiraj rezervacije po ceni rastuce</a>
			<a href="/SortiraneRezervacijeOpadajuceServlet">Sortiraj rezervacije po ceni opadajuce</a>
			<div class=" text-right">
			<a href="/VisestrukaPretragaRezervacijaServlet" class="btn btn-info">Visestruka pretraga</a>
			<a href="/DodajRezervacijuServlet" class="btn btn-success">Dodaj rezervaciju</a>
		</div>
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