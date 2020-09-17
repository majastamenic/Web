<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<meta charset="ISO-8859-1">
<title>Komentari</title>
</head>
<body>

 <form method="POST" action="/PregledKomentaraServlet">
 <div class="container">
 	<div class = "col-md-4">
    <h3 style="color: black"><b>Komentari</b></h3>
  </div>
  <p><br/></p>
      <table class="table table-boardered table-striped table-hover table-light">
      <thead class="thead-dark">
         <tr>
         <th>Gost:</th>
            <th>Apartman:</th>
            <th>Tekst:</th>
            <th>Ocena:</th>
            
            
         </tr>  
         </thead>
         <c:forEach items="${listaKomentara}" var="komentar">    
         <tr>
         	<td>${komentar.getGost().getId()}</td>
            <td>${komentar.getApartman().getId()}</td>
            <td>${komentar.getTekst()}</td>
            <td>${komentar.getOcena()}</td>
            
         </tr>
         </c:forEach>
         
      </table>
      </div>
   </form>

</body>
</html>