<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<p><br/></p>
<div class ="row">
	<div class="col-md-4">
		<h3>Pregled apartmana</h3>
	</div>
	<div class="col-md-4">
		<form action="PrikazApartmanServlet" method="get">
			<input type="text" name="pretraga" class = "form-control" placeholder="Pretraga...">
			<input type="submit" value="Pretraga">
			<a href="DodajApartmanServlet" class="btn btn-primary">Dodaj apartman</a>
			<a href="VisestrukaPretragaServlet" class="btn btn-primary">Visestruka pretraga</a>
		</form>
	</div>
</div>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

      <table class="table table-boardered table-striped table-hover">
      <thead>
         <tr>
         
            <td>Tip apartmana: </td>
            <td>Broj soba: </td>
            <td>Broj gostiju: </td>
            <td>Lokacija: </td>
            <td>Domacin: </td>
            <th class="text-center">Akcije </th>
         </tr>  
         </thead>
         <tbody>
         <c:forEach var="apartman" items="${(pretraga != null) ? apartman.find(pretraga) : mapaApartmana.values()}">   
         <tr>
         
           <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
            <td class="text-center">
            	<a href='IzmenaApartmanaServlet' class="btn btn-warning">Izmeni</a>
            	<a href="BrisanjeApartmanaServlet" class="btn btn-danger">Obrisi</a>
            </td>
         </tr>
         </c:forEach>
         </tbody>
      </table>
      

</body>
</html>