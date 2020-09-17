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
<meta charset="ISO-8859-1">
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<title>Izmena pogodnosti</title>
</head>
<body>

<div class ="container">
<div class="col-md-6 col-xl-5 mb-4">
<p><br/></p>
	<h3 style="color: black"><b>Izmena pogodnosti</b></h3>
<p><br/></p>
 <table class="table table-light">
         <tr>
            <td>Naziv pogodnosti:</td>
            <td><input type="text" name="naziv" placeholder="Unesite novi naziv.." class="form-control form-control-sm" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Samo slova moraju!" required/></td>
         </tr>   
         <tr></tr> 
          <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Potvrda pogodnosti"></td>
        </tr>
         </table>
         </div>
         </div>
</body>
</html>