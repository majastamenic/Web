<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<div class ="row">
	<div class="col-md-4">
		<h3>Pregled apartmana</h3>
	</div>
	<div class="col-md-4">
		<form action="PrikazApartmanServlet" method="get">
			<input type="text" name="pretraga" class = "form-control" placeholder="Pretraga...">
			<input type="submit" value="Pretraga">
			<a href="VisestrukaPretragaServlet" class="btn btn-primary">Visestruka pretraga</a>
		</form>
	</div>
</div>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<form method="POST" action="/PrikaziApartmanGostNeulogovaniServlet">
      <table border="1">
      <thead>
         <tr>
         
            <td>Tip apartmana: </td>
            <td>Broj soba: </td>
            <td>Broj gostiju: </td>
            <td>Lokacija: </td>
            <td>Domacin: </td>
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
            <td>
            	<a href="/PregledKomentaraGostijuNaApartmaneServlet?id=${apartman.id}"> komentari</a>
            </td>
           
         </tr>
         </c:forEach>
         </tbody>
      </table>
      
</form>
</body>
</html>