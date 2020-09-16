<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/pregledRezervacijaServlet">
		<a href="SortiraneRezervacijeRastuceServlet">Sortiraj rezervacije po ceni rastuce</a>
		<a href="SortiraneRezervacijeOpadajuceServlet">Sortiraj rezervacije po ceni opadajuce</a>
      <table>
      
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
   </form>

</body>
</html>