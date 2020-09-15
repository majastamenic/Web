<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled neaktivni apartmani</title>
</head>
<body>
	<h1 style="color: black">Pregled neaktivnih apartmana</h1>
    <form action="/NeaktivniApartmaniServlet" method="get">
   		<input type="text" name="pretraga">
		<input type="submit" value="Pretraga">
		<a href="/DodajApartmanServlet" class="btn btn-primary">Dodaj apartman</a>
   </form>
      <table border="1">
      
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