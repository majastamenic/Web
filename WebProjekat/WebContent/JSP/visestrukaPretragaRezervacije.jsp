<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>Pretraga rezervacija</title>
</head>
<body>
   <form method="GET" action="/VisestrukaPretragaRezervacijaServlet">
      <div class = "container">
      <p><br/></p>
      <h3 style="color: black"><b>Pretraga rezervacija</b></h3>
      <p><br/></p>
      <table class="table table-light">
         <tr>
            <td>Korisnicko ime gosta:</td>
            <td><input type="text" name="korisnickoIme" class="form-control form-control-sm" placeholder="Unesite korisnicko ime.."/></td>
            <td>Status:</td>
            <td><select name="status" id="status" class="form-control form-control-sm">
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
            <td></td>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Pretrazi"></td>
        </tr>
      </table>
      <p><br/></p>
      <table class="table table-boardered table-striped table-hover table-light">
      <thead class="thead-dark">
         <tr>
         
            <th>Rezervisan apartman: </th>
            <th>Broj nocenja: </th>
            <th>Cena: </th>
            <th>Status: </th>
            <th>Gost: </th>
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
      </div>
</form>

</body>
</html>