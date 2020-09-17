<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Izmena apartmana</title>
</head>
<body>
	<p><br/></p>
	<h3 style="color: black"><b>Izmena apartmana</b></h3>
   <form method="POST" action="/IzmenaApartmanaServlet">
   <div class="container">
      <table>
                  <tr>
            <td>Broj soba:</td>
            <td><input type="text" value=${brojSoba} name="brojSoba" class="form-control form-control-sm" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>
         </tr>    
         <tr>
            <td>Broj gostiju:</td>
            <td><input type="text" value=${brojGostiju} name="brojGostiju" class="form-control form-control-sm" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>
         </tr>  
         <tr>
            <td>Tip apartmana:</td>
            <td><select name="tip" id="tip" class="form-control form-control-sm">
  <option value="apartman">Apartman</option>
  <option value="soba">Soba</option>
  
  
</select></td>
         </tr> 
         
         
         <tr>
            <td>Lokacija:</td>
            <td><select name="lokacija" id="lokacija" class="form-control form-control-sm">
            <c:forEach items="${listaLokacija}" var="lokacija"> 
            <option value="lokacija">${lokacija.getId()}</option> 
            </c:forEach>  
            </select>
  </td>
         </tr> 
          <tr>
            <td>Pogodnosti:</td>
            <td><select name="Pogodnosti" id="Pogodnosti" class="form-control form-control-sm">
            <c:forEach items="${listaPogodnosti}" var="Pogodnosti"> 
            <option value="Pogodnosti">${Pogodnosti.getNaziv()}</option> 
            </c:forEach>  
            </select>
  </td>
         </tr> 
         
         <tr>
            <td>Cena po noci:</td>
            <td><input type="text" value="value=${cenaPoNoci}" class="form-control form-control-sm" name="cenaPoNoci" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>
         </tr>
         <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Izmeni"></td>
        </tr>
      </table>
      </div>
   </form>
</body>
</html>