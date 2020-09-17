<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Upravljenje pogodnostima</title>
</head>
<body>
<h3 style="color: black"><b>Pogodnosti</b></h3>
 <form method="POST" action="/OdrzavanjeSadrzajaServlet">
      <table>
      
         <tr>
         <td><b>Pogodnosti</b></td>
            
            
         </tr>  
         <c:forEach items="${listaPogodnosti}" var="pogodnost">    
         <tr>
         <td>${pogodnost.getNaziv()}</td>
           
         </tr>
         </c:forEach>
         
      </table>
      
     
      <table>
         <tr>
            <td>Unesite pogodnost:</td>
            <td><input type="text" name="pogodnost" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Samo slova moraju!" required/></td>
         </tr>    
          <tr>
            <td></td>
            <td><input type="submit" value="Potvrda pogodnosti"></td>
        </tr>
         </table>
   </form>

</body>
</html>