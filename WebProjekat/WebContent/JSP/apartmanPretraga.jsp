<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Pretraga apartmana</title>
</head>
<body>
<p><br/></p>
	<h3 style="color: black">Pretraga apartmana</h3>
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