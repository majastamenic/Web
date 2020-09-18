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
<title>Pregled gostiju</title>
</head>
<body>

<form method="POST" action="/PregledKorisnikaKojiImajuRezervacijuServlet">
 <div class="conatiner">
 <div class = "col-md-4">
 <p><br/></p>
 <h3 style="color: black"><b>Pregled gostiju</b></h3>
  </div>
 <p><br/><p>

      <table class="table table-boardered table-striped table-hover table-light">
     
      <thead class="thead-dark">
         <tr>
         <th>Korisnicko ime:</th>
            <th>Ime:</th>
            <th>Prezime:</th>
            <th>Pol:</th>
            <th>Uloga:</th>
           
         </tr>
         </thead>
         <c:forEach items="${listaGostiju}" var="gost">    
         <tr>
          <td>${gost.getKorisnickoIme()}</td>
            <td>${gost.getIme()}</td>
            <td>${gost.getPrezime()}</td>
            <td>${gost.getPol()}</td>
            <td>${gost.getUloga()}</td>
         </tr>
         </c:forEach>
         
      </table>
      </div>
   </form>

</body>
</html>