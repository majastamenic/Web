<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<title>Izmena pogodnosti</title>
</head>
<body>
<p><br/></p>
	<h3 style="color: black"><b>Izmena pogodnosti</b></h3>
<div class ="container">
<p><br/></p>
 <table>
         <tr>
            <td>Naziv pogodnosti:</td>
            <td><input type="text" name="naziv" placeholder="Unesite novi naziv.." class="form-control form-control-sm" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Samo slova moraju!" required/></td>
         </tr>   
         <tr></tr> 
          <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary" value="Potvrda pogodnosti"></td>
        </tr>
         </table>
</div>
</body>
</html>