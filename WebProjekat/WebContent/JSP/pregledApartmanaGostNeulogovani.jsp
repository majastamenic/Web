<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p><br/></p>
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

</head>
<body>
<form method="POST" action="/PrikaziApartmanGostNeulogovaniServlet">
	<div class= "container">
	<div class="col-md-4">
	<h3 style="color: black"><b>Apartmani</b></h3>
    </div>
    <p><br/></p>
    <a href="SortiranjeApartmanaRastuceGostNeulogovaniServlet" class="btn btn-secondary">Sortiraj apartmane po ceni rastuce</a>
    <a href="SortiranjeApartmanaOpadajuceGostNeulogovaniServlet" class="btn btn-secondary">Sortiraj apartmane po ceni opadajuce</a>
    <div class="text-right">
    <a href="VisestrukaPretragaServlet" class="btn btn-primary">Pretraga</a>
    </div>
      <table class="table table-boardered table-striped table-hover table-light">
      <thead class="thead-dark">
         <tr>
         
            <th>Tip apartmana: </th>
            <th>Broj soba: </th>
            <th>Broj gostiju: </th>
            <th>Lokacija: </th>
            <th>Domacin: </th>
            <th>Cena po noci: </th>
         </tr>  
         </thead>
         <tbody>
         <c:forEach items="${mapaApartmana}" var="apartman">   
         <tr>
         
            <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
            <td>${apartman.getCenaPoNoci()}</td>
            <td>
            	<a href="/PregledKomentaraGostijuNaApartmaneServlet?id=${apartman.id}"> komentari</a>
            </td>
           
         </tr>
         </c:forEach>
         </tbody>
      </table>
      </div>
</form>
</body>
</html>