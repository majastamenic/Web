<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Pocetna strana</title>
</head>
<body>

	<h3>  Dobrodosli <br/></h3>
	<p><br/></p>
	<table class="table table-hover">
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