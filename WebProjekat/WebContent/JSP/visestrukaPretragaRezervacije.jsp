<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Pretraga rezervacija</title>
</head>
<body>
	<h3 style="color: black"><b>Pretraga rezervacija</b></h3>
   <form method="GET" action="/VisestrukaPretragaRezervacijaServlet">
      <table>
         <tr>
            <td>Korisnicko ime gosta:</td>
            <td><input type="text" name="korisnickoIme" placeholder="Unesite korisnicko ime gosta"/></td>
         </tr>  
         <tr>
            <td>Status:</td>
            <td><select name="status" id="status">
            <option value=""></option>
            <option value="kreirana">Kreirana</option>
            <option value="odbijena">Odbijena</option>  
            <option value="odustanak">Odustanak</option>
            <option value="prihvacena">Prihvacena</option>
            <option value="zavrsena">Zavrsena</option>
            </select></td>
         </tr>  

         <tr>
            <td></td>
            <td><input type="submit" value="Pretrazi"></td>
        </tr>
      </table>
      <table class="table table-boardered table-striped table-hover">
      <thead>
         <tr>
         
            <td>Rezervisan apartman: </td>
            <td>Broj nocenja: </td>
            <td>Cena: </td>
            <td>Status: </td>
            <td>Gost: </td>
         </tr>  
         </thead>
         <tbody>
         <c:forEach items="${rezervacije}" var="rezervacija">    
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