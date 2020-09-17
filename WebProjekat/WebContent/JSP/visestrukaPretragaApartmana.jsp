<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Pretraga apartmana</title>
</head>
<body>
   <form method="GET" action="/VisestrukaPretragaServlet">
   
   <div class="container">
   	<h3 style="color: black"><b>Pretraga apartmana</b></h3>
   	<p><br/></p>
      <table class="table table-light">
         <tr>
            <td>Pocetni broj soba:</td>
            <td><input type="text" class="form-control form-control-sm" name="pocetniBrojSoba" placeholder="Pocetni broj soba.." pattern="[0-9]+" title="Samo brojevi mogu!"/></td>
            <td>Krajnji broj soba:</td>
            <td><input type="text" class="form-control form-control-sm" name="krajnjiBrojSoba" placeholder="Krajnji broj soba.." pattern="[0-9]+" title="Samo brojevi mogu!"/></td>
         </tr>  
         <tr>
            <td>Pocetni broj gostiju:</td>
            <td><input type="text" class="form-control form-control-sm" name="pocetniBrojGostiju" placeholder="Pocetni broj gostiju.." pattern="[0-9]+" title="Samo brojevi mogu!"/></td>
            <td>Krajnji broj gostiju:</td>
            <td><input type="text" class="form-control form-control-sm" name="krajnjiBrojGostiju" placeholder="Krajnji broj gostiju.." pattern="[0-9]+" title="Samo brojevi mogu!"/></td>
         </tr>  
         <tr>
            <td>Pocetna cena po noci:</td>
            <td><input type="text" class="form-control form-control-sm" name="pocetnaCena" placeholder="Pocetni cena po noci.." pattern="[0-9]+" title="Samo brojevi mogu!"/></td>
            <td>Krajnja cena po noci:</td>
            <td><input type="text" class="form-control form-control-sm" name="krajnjaCena" placeholder="Krajnja cena po noci.." pattern="[0-9]+" title="Samo brojevi mogu!"/></td>
         </tr>
         <tr>
            <td>Tip apartmana:</td>
            <td><select name="tip" id="tip" class="form-control form-control-sm">
            	<option value=""></option>
  				<option value="apartman">Apartman</option>
  				<option value="soba">Soba</option>  
			</select></td>
            <td>Naziv mesta:</td>
            <td><select name="lokacija" id="lokacija" class="form-control form-control-sm">
            <option value=""></option>
            <c:forEach items="${listaLokacija}" var="lokacija"> 
            <option value="lokacija">${lokacija.getId()}</option> 
            </c:forEach>  
            </select>
 			 </td>
         </tr> 
         
          <tr>
            <td>Pogodnosti:</td>
            <td><select name="Pogodnosti" id="Pogodnosti" class="form-control form-control-sm">
            <option value=""></option>
            <c:forEach items="${listaPogodnosti}" var="Pogodnosti"> 
            <option value="Pogodnosti">${Pogodnosti.getNaziv()}</option> 
            </c:forEach>  
            </select>
 			 <td><td><input type="submit" value="Pretrazi" class="btn btn-primary form-control form-control-sm"></td></td>
         </tr> 
      </table>
      <p><br/></p>
      <table class="table table-boardered table-striped table-hover table-light">
      <thead class="thead-dark">
         <tr>
         
            <th>Tip apartmana: </th>
            <th>Broj soba: </th>
            <th>Broj gostiju: </th>
            <th>Lokacija: </th>
            <th>Domacin: </th>
            <th>Cena po noci:</th>
         </tr>  
         </thead>
         <tbody>
         <c:forEach items="${apartmani}" var="apartman">   
         <tr>
         
            <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
            <td>${apartman.getCenaPoNoci()}</td>
         </tr>
         </c:forEach>
         </tbody>
      </table>
      </div>
</form>
</body>
</html>