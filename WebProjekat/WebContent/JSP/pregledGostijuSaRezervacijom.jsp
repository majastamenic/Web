<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="POST" action="/PregledKorisnikaKojiImajuRezervacijuServlet">
 <div class="conatiner">
      <table class="table table-boardered table-striped table-hover">
      	
      
         <tr>
         <td>Korisnicko ime:</td>
            <td>Ime:</td>
            <td>prezime:</td>
            <td>Pol:</td>
            <td>Uloga:</td>
            
         </tr>  
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