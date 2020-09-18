<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
	<p><br/></p>
	<p><br/></p>
	<p><br/></p>
   <form method="POST" action="/LogInServlet">
   <div class="container">
            <div class="col-sm-4 my-1">
            
            <h3 style="color: black"><b>Prijava</b></h3>
            <p><br/></p>
      			<label class="sr-only" for="inlineFormInputGroupUsername">KorisnickoIme</label>
      			<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text">@</div>
        			</div>
        			<input type="text" name="korisnickoIme" class="form-control" id="inlineFormInputGroupUsername" placeholder="KorisnickoIme" pattern="^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" title="Prvo slova moraju!" required/>
      			</div><br/>
      			
      			<label class="sr-only" for="inlineFormInputGroupUsername">KorisnickoIme</label>
      			<div class="input-group">
        			<input type="password" name="lozinka" class="form-control" id="inlineFormInputGroupUsername" placeholder="Lozinka"/>
      			</div>
  				<a href="/JSP/registracija.jsp">Registracija</a><br/>
  				
				<input type="submit" class="form-control btn btn-primary" value="Prijavi se"><br/>
				<p><br/></p>
				<p><br/></p>
			     
    <a href= "/PrikaziApartmanGostNeulogovaniServlet" class="form-control btn btn-info"> Apartmani </a>
    <p><br/></p>
    <a href= "/PregledKomentaraNeulogovaniServlet" class="form-control btn btn-info"> Pregled komentara gostiju.</a>	
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