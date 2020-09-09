<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
	<h1 style="color: black"><b>LogIn</b></h1>
   <form method="POST" action="/LogInServlet">
      <table>
         <tr>
            <td>Korisnicko ime:</td>
            <td><input type="text"  name="korisnickoIme"/></td>
         </tr>      
         <tr>
            <td>Lozinka:</td>
            <td><input type="password" id="lozinka" name="lozinka"/></td>
         </tr>
         <tr>
            <td></td>
            <td><a href="/JSP/registracija.jsp">Registracija</a></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"></td>
        </tr>
      </table>
   </form>
</body>
</html>