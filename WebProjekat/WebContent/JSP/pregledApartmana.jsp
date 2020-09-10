<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
 <form method="POST" action="/pregledApartmanaServlet">
      <table>
      
         <tr>
         <td>Id apartmana:</td>
            <td>Tip apartmana:</td>
            <td>Broj soba:</td>
            <td>Broj gostiju:</td>
            <td>Lokacija:</td>
            <td>Domacin:</td>
            
         </tr>  
         <c:forEach items="${listaApartmana}" var="apartman">    
         <tr>
         <td>${apartman.getId()}</td>
           <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
         </tr>
         </c:forEach>
         
      </table>
   </form>

</body>
</html>