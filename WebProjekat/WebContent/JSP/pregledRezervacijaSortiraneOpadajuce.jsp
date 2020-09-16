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
<form method="POST" action="SortiraneRezervacijeOpadajuceServlet">
      <table class="table table-boardered table-striped table-hover">
      <thead>
         
         
           <tr>
         <td>Rezervisan apartman:</td>
            <td>Broj nocenja:</td>
            <td>Cena:</td>
            <td>Status:</td>
            <td>Gost:</td>
            
         </tr>  
            
           
         </thead>
         <tbody>
         <c:forEach items="${listaRezervacija}" var="rezervacija">   
         <tr>
         
            <td> ${rezervacija.getRezervisanApartman().getId()} </td>
            <td> ${rezervacija.getBrojNocenja()}</td>
            <td> ${rezervacija.getUkupnaCena()}</td>
            <td> ${rezervacija.getStatus()}</td>
            <td> ${rezervacija.getGost().getId()}</td>
            
         </tr>
         </c:forEach>
         </tbody>
      </table>
      
</form>

</body>
</html>