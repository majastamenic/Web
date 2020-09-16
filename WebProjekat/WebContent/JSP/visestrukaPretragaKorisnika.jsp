<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visestruka pretraga korisnika</title>
</head>
<body>
	<h1 style="color: black"><b>Visestruka pretraga</b></h1>
   <form method="GET" action="/VisestrukaPretragaKorisnikaServlet">
      <table>
         <tr>
            <td>Korisnicko ime:</td>
            <td><input type="text" name="korisnickoIme"/></td>
         </tr>  
         <tr>
            <td>Ime:</td>
            <td><input type="text" name="ime"/></td>
         </tr>  
         <tr>
            <td>Prezime:</td>
            <td><input type="text" name="prezime"/></td>
         </tr> 
                
         <tr>
            <td>Pol:</td>
            <td><select name="pol" id="pol">
            <option value=""></option>
            <option value="muski">Muski</option>
            <option value="zenski">Zenski</option>  
            </select></td>
         </tr> 
         <c:if test="${LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Administrator)}">
          	<tr>
            	<td>Uloga:</td>
            	<td><select name="uloga" id="uloga">
            		<option value=""></option>
  					<option value="domacin">Domacin</option>
  					<option value="gost">Gost</option>
  					<option value="administrator">Administrator</option>
            	</select></td>
         	</tr> 
         </c:if>

         <tr>
            <td></td>
            <td><input type="submit" value="Pretrazi"></td>
        </tr>
      </table>
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