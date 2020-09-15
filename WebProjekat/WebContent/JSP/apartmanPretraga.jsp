<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apartman table</title>
</head>
<body>
	<h1 style="color: black">Pregled apartmana</h1>
	<form action="/PrikazApartmanServlet" method="get">
   		<input type="text" name="pretraga">
		<input type="submit" value="Pretraga">
   </form>
	<table border="1">
		<thead>
			<th>Tip apartmana:</th>
			<th>Broj soba:</th>
			<th>Broj gostiju:</th>
			<th>Lokacija:</th>
			<td>Domacin: </td>
		</thead>
		<tbody>
			<c:forEach var="apartman" items="${(pretraga != null) ? ApartmanDAO.pretraga(pretraga) : mapaApartmana.values()}">
					<tr>
						<td>${apartman.tip}</td>
						<td>${apartman.brojSoba}</td>
						<td>${apartman.brojGostiju}</td>
						<td>${apartman.lokacija}</td>
						<td>${apartman.domacin}</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>