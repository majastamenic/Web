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
<meta charset="ISO-8859-1">
<title>Pogodnosti</title>
</head>
<body>

 <form method="POST" action="/OdrzavanjeSadrzajaServlet">
 <div class = "container">
 <div class="col-md-6 col-xl-5 mb-4">
 <p><br/></p>
 <h3 style="color: black"><b>Pogodnosti</b></h3>
 <p><br/></p>
      <table class="table table-light">      
         <tr>
         <td><b>Pogodnosti</b></td>   
         </tr>  
         <c:forEach items="${listaPogodnosti}" var="pogodnost">    
         <tr>
         <td>${pogodnost.getNaziv()}</td>
          <td><a href="/IzmeniPogodnostServlet?id=${pogodnost.id}">Izmeni</a></td>
           
         </tr>
         </c:forEach>
         
      </table>
      
     
      <table class = "table table-light">
         <tr>
            <td>Unesite pogodnost:</td>
            <td><input type="text" class="form-control form-control-sm" name="pogodnost" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Samo slova moraju!" required/></td>
         </tr> 
         <tr></tr>
          <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Potvrda pogodnosti"></td>
        </tr>
         </table>
         </div>
         </div>
   </form>

</body>
</html>