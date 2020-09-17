<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Pretraga korisnika</title>
</head>
<body>
	<p><br/></p>
	<h3 style="color: black"><b>Pretraga korisnika</b></h3>
   <form method="GET" action="/VisestrukaPretragaKorisnikaServlet">
      <table>
         <tr>
            <td>Korisnicko ime:</td>
            <td><input type="text" class="form-control form-control-sm" placeholder="Unesite korisnicko ime.." name="korisnickoIme"/></td>
         </tr>  
         <tr>
            <td>Ime:</td>
            <td><input type="text" class="form-control form-control-sm" placeholder="Unesite ime.." name="ime"/></td>
         </tr>  
         <tr>
            <td>Prezime:</td>
            <td><input type="text" class="form-control form-control-sm" placeholder="Unesite prezime.." name="prezime"/></td>
         </tr> 
                
         <tr>
            <td>Pol:</td>
            <td><select name="pol" id="pol" class="form-control form-control-sm">
            <option value=""></option>
            <option value="muski">Muski</option>
            <option value="zenski">Zenski</option>  
            </select></td>
         </tr> 
         <c:if test="${LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Administrator)}">
          	<tr>
            	<td>Uloga:</td>
            	<td><select name="uloga" id="uloga" class="form-control form-control-sm">
            		<option value=""></option>
  					<option value="domacin">Domacin</option>
  					<option value="gost">Gost</option>
  					<option value="administrator">Administrator</option>
            	</select></td>
         	</tr> 
         </c:if>

         <tr>
            <td></td>
            <td><input type="submit" value="Pretrazi" class="form-control form-control-sm btn btn-primary"></td>
        </tr>
      </table>
      <p><br/></p>
      <table class="table table-boardered table-striped table-hover">
      <thead>
         <tr>
         
            <td>Korisnicko ime: </td>
            <td>Ime: </td>
            <td>Prezime: </td>
            <td>Pol: </td>
            <td>Uloga: </td>
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
      
</form>

</body>
</html>