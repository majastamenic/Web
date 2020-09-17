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
<h1 style="color: black"><b>Kreiranje rezervacije</b></h1>
   <form method="POST" action="/kreiranjeRezervacijeServlet">
      <table>
                 
         
         <tr>
            <td>Izaberite apartman:</td>
            <td><select name="apartman" id="apartman">
            <c:forEach items="${listaApartmana}" var="apartmani"> 
            <option>${apartmani.getId()}</option> 
            </c:forEach>  
            </select>
  </td>
         </tr> 
          <tr>
            <td>Datum pocetka rezervacije:</td>


            <td><input type="date" name="datum"  class="form-control form-control-sm">
  </td>

         </tr> 
         
         <tr>
            <td>Broj nocenja:</td>
            <td><input type="text" name="brojNocenja" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>

         </tr>
         <tr>
            <td>Poruka:</td>

            <td><input type="text" class="form-control form-control-sm" placeholder="Unesite poruku.." name="poruka"/></td>

         </tr>
         <tr>
            <td></td>
            <td><input type="submit" value="Kreiraj"></td>
        </tr>
      </table>
   </form>

</body>
</html>