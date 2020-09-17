<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
	<p><br/></p>
	<h3 style="color: black"><b>LogIn</b></h3>
   <form method="POST" action="/LogInServlet">
            <div class="col-sm-3 my-1">
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
				<input type="submit" class="btn btn-primary" value="Prijavi se"><br/>
				<a href="/JSP/neulogovaniKorisnik.jsp">Niste ulogovani?</a><br/>
        </div>
   </form>
   <% if (request.getAttribute("err") != null) { %>
		<p style="color: red"><%=request.getAttribute("err")%></p>
	<% } %>
</body>
</html>