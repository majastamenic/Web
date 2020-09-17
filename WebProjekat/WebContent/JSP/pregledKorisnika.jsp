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
<title>Pregled korisnika</title>
</head>
<body>
<p><br/></p>
 <form method="POST" action="/PregledSvihKorisnikaServlet">
 <div class="container">
	<div class="col-md-4">
		<h3 style="color: black"><b>Korisnici</b></h3>
	</div>
	<p><br/></p>
	<div class="text-right">
		<a href="/VisestrukaPretragaKorisnikaServlet" class="btn btn-primary">Pretraga</a>
	</div>
      <table class="table table-boardered table-striped table-hover table-light">
      <thead class="thead-dark">
         <tr>
         	<th>Korisnicko ime:</th>
            <th>Ime:</th>
            <th>prezime:</th>
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
         <c:forEach items="${listaAdmina}" var="admin">    
         <tr>
         <td>${admin.getKorisnickoIme()}</td>
            <td>${admin.getIme()}</td>
            <td>${admin.getPrezime()}</td>
            <td>${admin.getPol()}</td>
            <td>${admin.getUloga()}</td>
         </tr>
         </c:forEach>
         <c:forEach items="${listaDomacina}" var="domacin">    
         <tr>
         <td>${domacin.getKorisnickoIme()}</td>
            <td>${domacin.getIme()}</td>
            <td>${domacin.getPrezime()}</td>
            <td>${domacin.getPol()}</td>
            <td>${domacin.getUloga()}</td>
         </tr>
         </c:forEach>
         
      </table>
      </div>
   </form>

</body>
</html>