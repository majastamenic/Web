<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<div class ="row">
	<div class="col-md-4">
		<h3>Pregled korisnika</h3>
	</div>
	<div class="col-md-4">
		<a href="/VisestrukaPretragaKorisnikaServlet" class="btn btn-primary">Visestruka pretraga</a>
	</div>
</div>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="POST" action="/PregledSvihKorisnikaServlet">
      <table>
      
         <tr>
         	<td>Korisnicko ime:</td>
            <td>Ime:</td>
            <td>prezime:</td>
            <td>Pol:</td>
            <td>Uloga:</td>
            
         </tr>  
         <c:forEach items="${listaGostiju}" var="gost">    
         <tr>
         	<td>${gost.getKorisnickoIme()}</td>
            <td>${gost.getIme()}</td>
            <td>${gost.getPrezime()}</td>
            <td>${gost.getPol()}</td>
            <td>${gost.getUloga()}</td>
         </tr>
         </c:forEach>
         <c:forEach items="${listaAdmina}" var="admin">    
         <tr>
         <td>${admin.getKorisnickoIme()}</td>
            <td>${admin.getIme()}</td>
            <td>${admin.getPrezime()}</td>
            <td>${admin.getPol()}</td>
            <td>${admin.getUloga()}</td>
         </tr>
         </c:forEach>
         <c:forEach items="${listaDomacina}" var="domacin">    
         <tr>
         <td>${domacin.getKorisnickoIme()}</td>
            <td>${domacin.getIme()}</td>
            <td>${domacin.getPrezime()}</td>
            <td>${domacin.getPol()}</td>
            <td>${domacin.getUloga()}</td>
         </tr>
         </c:forEach>
         
      </table>
   </form>

</body>
</html>