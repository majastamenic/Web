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
<title>Pocetna strana</title>
</head>
<body>

	<h3>  Dobrodosli <br/></h3>
	<p><br/></p>
	<table class="table table-hover table-light">
  <tbody>
  <tr>
    <td></td>
    <td><a href= "/PrikaziApartmanGostNeulogovaniServlet" class="btn btn-info"> Apartmani </a></td>
    <td><a href= "/PregledKomentaraGostijuNaApartmaneServlet" class="btn btn-info"> Pregled komentara gostiju.</a></td>
  </tr>
  <tr></tr>
  </tbody>
  </table>
</body>
</html>