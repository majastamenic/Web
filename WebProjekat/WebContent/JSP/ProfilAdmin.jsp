<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/JS/bootstrap.min.js"></script>
</head>
<body>
	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link active" href="#">Active</a>
		</li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
			aria-expanded="false">Dropdown</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">Action</a> <a
					class="dropdown-item" href="#">Another action</a> <a
					class="dropdown-item" href="#">Something else here</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Separated link</a>
			</div></li>
		<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
		<li class="nav-item"><a class="nav-link disabled" href="#"
			tabindex="-1" aria-disabled="true">Disabled</a></li>
	</ul>
	<p>
		Dobrodosli, ${ulogovaniKorisnik.korisnickoIme} id
		${ulogovaniKorisnik.getId()} <a href="LogOutServlet">Logout</a>
	</p>
	<br />
	<p>
		<a href="/PregledSvihKorisnikaServlet"> Pregled svih korisnika</a>
	</p>
	<br />
	<p>
		<a href="IzmenaPodatakaServlet"> Izmeni podatke</a>
	</p>
	<br />
	<p>
		<a href="/DodajApartmanServlet"> Dodaj apartman</a>
	</p>
	<br />
	<p>
		<a href="/PrikaziApartmanServlet"> Pregled apartmana</a>
	</p>
	<br />
	<p>
		<a href="/OdrzavanjeSadrzajaServlet"> Odrzavanje sadrzaja</a>
	</p>
	<br />
	<p>
		<a href="/pregledSvihRezervacijaServlet"> Pregled rezervacija</a>
	</p>
	<br />
	<p>
		<a href="/PregledKomentaraServlet"> Pregled svih komentara</a>
	</p>
	<br />
	<p>
		<a href="PretragaRezervacijaPoKorisnickomImenuServlet"> Pretraga
			rezervacija po korisnickom imenu gosta</a>
	</p>
	<br />
	<p>
		<a href="PretragaKorisnikaServlet"> Pretraga korinika</a>
	</p>
	<br />
</body>
</html>