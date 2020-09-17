<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Dodavanje komentara</title>
</head>
<body>
<p><br/></p>
<h3 style="color: black"><b>Dodavanje komentara</b></h3>
   <form method="POST" action="dodavanjeKomentaraServlet">
   <div class = "container">
      <table>
                 
         
         <tr>
            <td>Izaberite apartman:</td>
            <td><select name="apartman" id="apartman">
            <c:forEach items="${ulogovaniKorisnik.rezervacije}" var="rezervacija"> 
            <option> ${rezervacija.getRezervisanApartman().getId()} </option>
            </c:forEach>  
            </select>
  </td>     
         </tr>
         
         <tr>
            <td>Komentar:</td>
            <td><input type="text" placeholder="Unesite komentar.." name="komentar" id="komentar" pattern="^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
         <tr>
            <td>Ocenu:</td>
            <td><input type="text" placeholder="Unesite ocenu.." name="ocena" id="ocena" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>
         </tr>
         <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Potvrda"></td>
        </tr>
      </table>
      </div>
   </form>



</body>
</html>