<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<title>Izmena podataka</title>
</head>
<body>
<p><br/></p>
	<h3 style="color: black"><b>Izmena podataka</b></h3>
   <form method="POST" action="/IzmenaPodatakaServlet">
      <table>
      <p>  Dobrodosli, <%=request.getSession().getAttribute("LogInServlet.ulogovaniKorisnik.korisnickoIme()")%></p>
             
         <tr>
            <td>Ime:</td>
            <td><input type="text" name="ime" value=${ime} pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Ne smete unositi brojeve!" required/></td>
         </tr>
         <tr>
            <td>Prezime:</td>
            <td><input type="text" name="prezime" value=${prezime} pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Ne smete unositi brojeve!" required/></td>
         </tr>
         <tr>
            <td>Pol:</td>
            <td>
            	<select id="pol" name="pol">
            		<option value="Zenski">Zenski</option>
            		<option value="Muski">Muski</option>
            	</select>
            </td>
         </tr>
         <tr>
            <td>Lozinka:</td>
            <td><input type="password" value=${lozinka} name="lozinka" pattern="[1-9]*^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
         <tr>
            <td>Unesite ponovo lozinku:</td>
            <td><input type="password" value=${lozinka} name="ponovljenaLozinka" pattern="[1-9]*^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Izmeni"></td>
        </tr>
      </table>
   </form>
</body>
</html>