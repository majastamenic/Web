<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Pogodnosti</title>
</head>
<body>

 <form method="POST" action="/OdrzavanjeSadrzajaServlet">
 <div class = "container">
 <h3 style="color: black"><b>Pogodnosti</b></h3>
      <table>      
         <tr>
         <td><b>Pogodnosti</b></td>   
         </tr>  
         <c:forEach items="${listaPogodnosti}" var="pogodnost">    
         <tr class="form-control form-control-sm">
         <td>${pogodnost.getNaziv()}</td>
          <td><a href="IzmeniPogodnostServlet?id=${apartman.id}">Izmeni</a></td>
           
         </tr>
         </c:forEach>
         
      </table>
      
     
      <table>
         <tr>
            <td>Unesite pogodnost:</td>
            <td><input type="text" class="form-control form-control-sm" name="pogodnost" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Samo slova moraju!" required/></td>
         </tr> 
         <tr><br/></tr> 
          <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Potvrda pogodnosti"></td>
        </tr>
         </table>
         </div>
   </form>

</body>
</html>