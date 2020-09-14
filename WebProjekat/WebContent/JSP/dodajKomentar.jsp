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
            <td><input type="text" name="komentar" id="komentar"/></td>
         </tr>
         <tr>
            <td>Unesite ocenu:</td>
            <td><input type="text" name="ocena" id="ocena"/></td>
         </tr>
         <tr>
            <td></td>
            <td><input type="submit" value="Potvrda"></td>
        </tr>
      </table>
   </form>



</body>
</html>