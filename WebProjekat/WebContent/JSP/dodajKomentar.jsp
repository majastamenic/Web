<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: black"><b>Dodajte komentar</b></h1>
   <form method="POST" action="dodavanjeKomentaraServlet">
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
            <td>Unesite komentar:</td>
            <td><input type="text" name="komentar" id="komentar" pattern="^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
         <tr>
            <td>Unesite ocenu:</td>
            <td><input type="text" name="ocena" id="ocena" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>
         </tr>
         <tr>
            <td></td>
            <td><input type="submit" value="Potvrda"></td>
        </tr>
      </table>
   </form>



</body>
</html>