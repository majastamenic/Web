<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p><br/></p>
<head>
<style>
body {
  background-image: url('https://cdn.cnn.com/cnnnext/dam/assets/190423135710-girls-in-car-coupons-travel-widget.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Registracija</title>
</head>
<body>
	
   <form method="POST" action="/RegistracijaServlet">
   <div class = "container">
   <div class="col-md-6 col-xl-5 mb-4">
   	<h3 style="color: black"><b>Registracija</b></h3>
   	<p><br/></p>
      <table class ="table table-light">
         <tr>
            <td>Korisnicko ime:</td>
            <td><input type="text" name="korisnickoIme" class="form-control form-control-sm" pattern="^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" title="Prvo slova moraju!" required/></td>
         </tr>      
         <tr>
            <td>Ime:</td>
            <td><input type="text" name="ime" class="form-control form-control-sm" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Ne smete unositi brojeve!" required/></td>
         </tr>
         <tr>
            <td>Prezime:</td>
            <td><input type="text" name="prezime" class="form-control form-control-sm" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Ne smete unositi brojeve!" required/></td>
         </tr>
         <tr>
            <td>Pol:</td>
            <td>
            	<select id="pol" name="pol" class="form-control form-control-sm">
            		<option value="Muski">Muski</option>
            		<option value="Zenski">Zenski</option>
            	</select>
            </td>
         </tr>
         <tr>
            <td>Lozinka:</td>
            <td><input type="password" name="lozinka" class="form-control form-control-sm" pattern="[1-9]*^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
         <tr>
            <td>Unesite ponovo lozinku:</td>
            <td><input type="password" name="lozinkaPonovljena" class="form-control form-control-sm" pattern="[1-9]*^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
        <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Registruj se"></td>
        </tr>
      </table>
      </div>
      </div>
   </form>
   <% if (request.getAttribute("err") != null) { %>
   	<div class="alert alert-danger" role="alert">
	<p style="color: red"><%=request.getAttribute("err")%></p>
	</div>
	<% } %>
</body>
</html>