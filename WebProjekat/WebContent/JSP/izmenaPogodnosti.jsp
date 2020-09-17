<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <table>
         <tr>
            <td>Unesite novi naziv pogodnosti:</td>
            <td><input type="text" name="naziv" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Samo slova moraju!" required/></td>
         </tr>    
          <tr>
            <td></td>
            <td><input type="submit" value="Potvrda pogodnosti"></td>
        </tr>
         </table>

</body>
</html>