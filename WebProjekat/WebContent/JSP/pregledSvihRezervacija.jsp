<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p><br/></p>
<head>
<style>
body {
  background-image: url('https://cdn.cnn.com/cnnnext/dam/assets/190423135710-girls-in-car-coupons-travel-widget.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Rezervacije</title>
</head>
<body>
 <form method="POST" action="/pregledSvihRezervacijaServlet">
 <div class="conatiner">
		<h3 style="color: black"><b>Rezervacije</b></h3>
		<p><br/></p>
			<a href="/SortiraneRezervacijeRastuceServlet" class="btn btn-secondary">Sortiraj rezervacije po ceni rastuce</a>
			<a href="/SortiraneRezervacijeOpadajuceServlet" class="btn btn-secondary">Sortiraj rezervacije po ceni opadajuce</a>
			<div class=" text-right">
			<a href="/VisestrukaPretragaRezervacijaServlet" class="btn btn-info">Visestruka pretraga</a>
			<a href="/DodajRezervacijuServlet" class="btn btn-success">Dodaj rezervaciju</a>
		</div>
      <table class="table table-boardered table-striped table-hover table-light">
      	
      <thead class="thead-dark">
         <tr>
         <th>Rezervisan apartman:</th>
            <th>Broj nocenja:</th>
            <th>Cena:</th>
            <th>Status:</th>
            <th>Gost:</th>
            
         </tr>  
         </thead>
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