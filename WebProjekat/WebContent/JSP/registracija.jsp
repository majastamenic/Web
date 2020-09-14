<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registracija</title>
</head>
<body>
	<h1 style="color: black"><b>Registracija</b></h1>
   <form method="POST" action="/RegistracijaServlet">
      <table>
         <tr>
            <td>Korisnicko ime:</td>
            <td><input type="text" name="korisnickoIme" pattern="^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" title="Prvo slova moraju!" required/></td>
         </tr>      
         <tr>
            <td>Ime:</td>
            <td><input type="text" name="ime" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Ne smete unositi brojeve!" required/></td>
         </tr>
         <tr>
            <td>Prezime:</td>
            <td><input type="text" name="prezime" pattern="[a-zA-ZćĆžŽĐđšŠčČ]*" title="Ne smete unositi brojeve!" required/></td>
         </tr>
         <tr>
            <td>Pol:</td>
            <td>
            	<select id="pol" name="pol">
            		<option value="Muski">Muski</option>
            		<option value="Zenski">Zenski</option>
            	</select>
            </td>
         </tr>
         <tr>
            <td>Lozinka:</td>
            <td><input type="password" name="lozinka" pattern="[1-9]*^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
         <tr>
            <td>Unesite ponovo lozinku:</td>
            <td><input type="password" name="lozinkaPonovljena" pattern="[1-9]*^([a-zA-ZćĆžŽĐđšŠčČ]+)[1-9]*" required/></td>
         </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Registruj se"></td>
        </tr>
      </table>
   </form>
</body>
</html>