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
<meta charset="UTF-8">
<title>Pretraga korisnika</title>
</head>
<body>
	<p><br/></p>
   <form method="GET" action="/VisestrukaPretragaKorisnikaServlet">
     <div class="container"> 
     	<h3 style="color: black"><b>Pretraga korisnika</b></h3>
     	<p><br/></p>
      <table class = "table table-light">
         <tr>
            <td>Korisnicko ime:</td>
            <td><input type="text" class="form-control form-control-sm" placeholder="Unesite korisnicko ime.." name="korisnickoIme"/></td>
         	<td>Ime:</td>
            <td><input type="text" class="form-control form-control-sm" placeholder="Unesite ime.." name="ime"/></td>
         </tr>   
         <tr>
            <td>Prezime:</td>
            <td><input type="text" class="form-control form-control-sm" placeholder="Unesite prezime.." name="prezime"/></td>
        	            <td>Pol:</td>
            <td><select name="pol" id="pol" class="form-control form-control-sm">
            <option value=""></option>
            <option value="muski">Muski</option>
            <option value="zenski">Zenski</option>  
            </select></td>
         </tr> 
		 <tr>
         <c:if test="${LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Administrator)}">
            	<td>Uloga:</td>
            	<td><select name="uloga" id="uloga" class="form-control form-control-sm">
            		<option value=""></option>
  					<option value="domacin">Domacin</option>
  					<option value="gost">Gost</option>
  					<option value="administrator">Administrator</option>
            	</select></td>
         </c:if>
		</tr>
		<tr>
        	<td></td>
        	<td></td>
        	<td></td>
            <td><input type="submit" value="Pretrazi" class="form-control form-control-sm btn btn-primary"></td>
        </tr>
      </table>
      <p><br/></p>
      <table class="table table-boardered table-striped table-hover table-light">
      <thead class="thead-dark">
         <tr>
         
            <th>Korisnicko ime: </th>
            <th>Ime: </th>
            <th>Prezime: </th>
            <th>Pol: </th>
            <th>Uloga: </th>
         </tr>  
         </thead>
         <tbody>
         <c:forEach items="${korisnici}" var="korisnik">   
         <tr>
         
            <td>${korisnik.getKorisnickoIme()}</td>
            <td>${korisnik.getIme()}</td>
            <td>${korisnik.getPrezime()}</td>
            <td>${korisnik.getPol()}</td>
            <td>${korisnik.getUloga()}</td>
         </tr>
         </c:forEach>
         </tbody>
      </table>
     </div> 
</form>

</body>
</html>