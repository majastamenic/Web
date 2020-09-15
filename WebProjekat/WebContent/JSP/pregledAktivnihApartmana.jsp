<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/AktivniApartmaniServlet">
<p><br/></p>
	<div class="col-md-4">
		<h1>Pregled aktivnih apartmana</h1>
	</div>
	<div class="col-md-4">
		<form action="" method="get">
			<input type = "text" class = "form-control" name = "pretraga" placeholder="Pretraga.."/>
			<a href="DodajApartmanServlet" class="btn btn-primary">Dodaj apartman</a>
		</form>
	</div>

<p></p>
      <table class="table table-bordered table-striped table-hover">
      	<thead>
         <tr>
         <td>Id apartmana:</td>
            <td>Tip apartmana:</td>
            <td>Broj soba:</td>
            <td>Broj gostiju:</td>
            <td>Lokacija:</td>
            <td>Domacin:</td>
            
         </tr> 
         </thead>
         <tbody> 
         <c:forEach items="${mapaAktivnihApartmana.values()}" var="apartman">    
         <tr>
         <td>${apartman.getId()}</td>
           <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
            
            <td class="text-center">
            <a href='PregledKomentaraGostijuNaApartmaneServlet?ID = ${apartman.id}'> Komentari</a>
            <!--  a href="IzmenaApartmanaServlet" class = "btn btn-warning">Izmeni</a>-->
            <!--  <a href="BrisanjeApartmanaServlet" class = "btn btn-danger">Izbrisi</a>-->
            </td>
         </tr>
         </c:forEach>
         
      </table>
   </form>


</body>
</html>