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
 <form method="POST" action="/PregledSvihKorisnikaServlet">
      <table>
      
         <tr>
         <td>Korisnicko ime:</td>
            <td>Lozinka:</td>
            <td>Ime:</td>
            <td>prezime:</td>
            <td>Pol:</td>
            <td>Uloga:</td>
            
         </tr>  
         <c:forEach items="${listaKorisnika}" var="korisnik">    
         <tr>
         <td>${korisnik.getKorisnickoIme()}</td>
           <td>${korisnik.getLozinka()}</td>
            <td>${korisnik.getIme()}</td>
            <td>${korisnik.getPrezime()}</td>
            <td>${korisnik.getPol()}</td>
            <td>${korisnik.getUloga()}</td>
         </tr>
         </c:forEach>
         
      </table>
   </form>

</body>
</html>