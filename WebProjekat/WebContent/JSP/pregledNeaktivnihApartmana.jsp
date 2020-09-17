<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Pregled neaktivni apartmani</title>
</head>
<body>
	<h1 style="color: black">Pregled neaktivnih apartmana</h1>
    <form action="/NeaktivniApartmaniServlet" method="get">
   		<input type="text" name="pretraga">
		<input type="submit" value="Pretraga">
		<a href="/DodajApartmanServlet" class="btn btn-success">Dodaj apartman</a>
   </form>
      <table class="table table-boardered table-striped table-hover">
      
         <thead>
            <th>Tip apartmana:</th>
            <th>Broj soba:</th>
            <th>Broj gostiju:</th>
            <th>Lokacija:</th>
            <th>Domacin:</th>
            
         </thead>  
         <tbody>
	         <c:forEach var="apartman" items="${(pretraga != null) ? ApartmanDAO.pretraga(pretraga) : mapaNeaktivnihApartmana.values()}">    
		         <tr>
		            <td>${apartman.getTip()}</td>
		            <td>${apartman.getBrojSoba()}</td>
		            <td>${apartman.getBrojGostiju()}</td>
		            <td>${apartman.getLokacija().getId()}</td>
		            <td>${apartman.getDomacin().getId()}</td>
		            <td>
            			<a href="/PregledKomentaraGostijuNaApartmaneServlet?id=${apartman.id}"> komentari</a>
            		</td>
            		<td>
            			<a href="/IzmenaApartmanaServlet?id=${apartman.id}">Izmeni</a>
            			<a href="/BrisanjeApartmanaServlet?id=${apartman.id}">Izbrisi</a>
            		</td>
		         </tr>
	         </c:forEach>
         </tbody>
      </table>
   


</body>
</html>