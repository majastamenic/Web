<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url('https://cdn.cnn.com/cnnnext/dam/assets/190423135710-girls-in-car-coupons-travel-widget.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
<meta charset="UTF-8">
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<title>Izmena podataka</title>
</head>
<body>
<p><br/></p>
	
   <form method="POST" action="/IzmenaPodatakaServlet">
   <div class="container">
   <div class="col-md-6 col-xl-5 mb-4">
   	<h3 style="color: black"><b>Izmena podataka</b></h3>
   	<p><br/></p>
      <table class="table table-light">
             
         <tr>
            <td>Ime:</td>
            <td><input type="text" name="ime" value=${ime} class="form-control form-control-sm" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Ne smete unositi brojeve!" required/></td>
         </tr>
         <tr>
            <td>Prezime:</td>
            <td><input type="text" name="prezime" value=${prezime} class="form-control form-control-sm" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Ne smete unositi brojeve!" required/></td>
         </tr>
         <tr>
            <td>Pol:</td>
            <td>
            	<select id="pol" name="pol" class="form-control form-control-sm">
            		<option value=""></option>
            		<option value="Zenski">Zenski</option>
            		<option value="Muski">Muski</option>
            	</select>
            </td>
         </tr>
         <tr>
            <td>Lozinka:</td>
            <td><input type="password" value=${lozinka} class="form-control form-control-sm" name="lozinka" pattern="[1-9]*^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
         <tr>
            <td>Unesite ponovo lozinku:</td>
            <td><input type="password" value=${lozinka} class="form-control form-control-sm" name="ponovljenaLozinka" pattern="[1-9]*^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
        <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Izmeni"></td>
        </tr>
      </table>
      </div>
      </div>
   </form>
</body>
</html>