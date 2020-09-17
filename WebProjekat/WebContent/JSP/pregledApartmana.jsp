<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p><br/></p>
<div class ="row">
	<div class="col-md-4">
		<h3 style="color: black"><b>Apartmani</b></h3>
	</div>
	<div class="col-md-4">
		<form action="PrikaziApartmanServlet" method="get">
			<a href="SortiraniApartmaniRastuceServlet" class = "fore-control">Sortiraj apartmane po ceni rastuce</a>
			<a href="SortiraniApartmaniOpadajuceServlet" class = "fore-control">Sortiraj apartmane po ceni opadajuce</a>
			<a href="VisestrukaPretragaServlet" class="btn btn-primary">Pretraga</a>
			<div class="col-md-4 text-right">
			<a href="DodajApartmanServlet" class="btn btn-success">Dodaj apartman</a>
			</div>
		</form>
	</div>
</div>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">

</head>
<body>
<form method="POST" action="PrikaziApartmanServlet">
	<div class = "container">
      <table class="table table-boardered table-striped table-hover">
      <thead>
         <tr>
         
            <td>Tip apartmana: </td>
            <td>Broj soba: </td>
            <td>Broj gostiju: </td>
            <td>Lokacija: </td>
            <td>Domacin: </td>
            <td>Status: </td>
            <td>Cena po noci: </td>
            <th class="text-center">Akcije </th>
         </tr>  
         </thead>
         <tbody>
         <c:forEach items="${mapaApartmana.values()}" var="apartman">   
         <tr>
         
            <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
            <td>${apartman.getStatus()}</td>
            <td>${apartman.getCenaPoNoci()}</td>
            <td class="text-center">

            	<a href='/IzmenaApartmanaServlet?id=${apartman.id} ' class="btn btn-warning">Izmeni</a>
            	<a href="BrisanjeApartmanaServlet?id=${apartman.id} " class="btn btn-danger">Obrisi</a>

            </td>
         </tr>
         </c:forEach>
         </tbody>
      </table>
      </div>
</form>
</body>
</html>