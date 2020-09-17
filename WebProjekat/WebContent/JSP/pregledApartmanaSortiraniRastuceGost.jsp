<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p><br/></p>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Soritrani apartmani</title>
</head>
<body>
<form method="POST" action="/SortiranjeApartmanaRastuceGostNeulogovaniServlet">
      <div class = "container">
      <div class = "col-md-4">
    <h3 style="color: black"><b>Sortirani apartmani</b></h3>
  </div>
  <p><br/></p>
   <div class="text-right">
    <a href="VisestrukaPretragaServlet" class="btn btn-primary">Pretraga</a>
    </div>
      <table class="table table-boardered table-striped table-hover">
      <thead>
         <tr>
         
            <td>Tip apartmana: </td>
            <td>Broj soba: </td>
            <td>Broj gostiju: </td>
            <td>Lokacija: </td>
            <td>Domacin: </td>
            <td>Cena po noci: </td>
            
         </tr>  
         </thead>
         <tbody>
         <c:forEach items="${listaApartmana}" var="apartman">   
         <tr>
         
            <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
            <td>${apartman.getCenaPoNoci()}</td>
            
         </tr>
         </c:forEach>
         </tbody>
      </table>
     </div>> 
</form>
</body>
</html>