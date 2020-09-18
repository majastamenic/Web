<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
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
<meta charset="ISO-8859-1">
<title>Pregled rezervacija</title>
</head>
<form method="POST" action="/pregledRezervacijaDomacinServlet">
	<p><br/></p>
	<div class = "container">
  <div class="col-md-4">
    <h3 style="color: black"><b>Rezervacije</b></h3>
  </div>
  <p><br/></p>
  <a href="SortiraneRezervacijeRastuceGostServlet" class="btn btn-secondary">Sortiraj rezervacije po ceni rastuce</a>
  <a href="SortiraneRezervacijeOpadajuceGostServlet" class="btn btn-secondary">Sortiraj rezervacije po ceni opadajuce</a>
	
		
      <table class="table table-boardered table-striped table-hover table-light">
      <thead class="thead-dark">
         <tr>
         	<th>Rezervisan apartman:</th>
            <th>Broj nocenja:</th>
            <th>Cena:</th>
            <th>Status:</th>
            
           
         </tr>  
         </thead>
         <c:forEach items="${rezervacije}" var="rezervacija"> 
            
         <tr>
            <td> ${rezervacija.getRezervisanApartman().getId()} </td>
            <td> ${rezervacija.getBrojNocenja()}</td>
            <td> ${rezervacija.getUkupnaCena()}</td>
            <td> ${rezervacija.getStatus()}</td>

           
         </tr>
         </c:forEach>
         
      </table>
      </div>
   </form>

</body>
</html>