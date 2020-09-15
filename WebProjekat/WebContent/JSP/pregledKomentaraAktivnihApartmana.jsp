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
 <form method="POST" action="/PregledKomentaraGostijuNaApartmaneServlet">
      <table>
      
         <tr>
         <td>Gost:</td>
            <td>Apartman:</td>
            <td>Tekst:</td>
            <td>Ocena:</td>
            
            
         </tr>  
         <c:forEach items="${listaKomentara}" var="komentar">    
         <tr>
         	<td>${komentar.getGost().getId()}</td>
            <td>${komentar.getApartman().getId()}</td>
            <td>${komentar.getTekst()}</td>
            <td>${komentar.getOcena()}</td>
            
         </tr>
         </c:forEach>
         
      </table>
   </form>
</body>
</html>