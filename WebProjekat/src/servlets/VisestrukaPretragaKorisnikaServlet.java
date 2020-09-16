package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Korisnik;
import beans.Pol;
import beans.Uloga;
import dao.UserDAO;

/**
 * Servlet implementation class VisestrukaPretragaKorisnikaServlet
 */
@WebServlet("/VisestrukaPretragaKorisnikaServlet")
public class VisestrukaPretragaKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisestrukaPretragaKorisnikaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String korisnickoIme = request.getParameter("korisnickoIme");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String polString = request.getParameter("pol");
		String ulogaString = request.getParameter("uloga");
		List<Korisnik> pronadjeniKorisnici = UserDAO.ucitajKorisnikeSpramUloge();

		if (korisnickoIme != null && !korisnickoIme.isEmpty()) {
			List<Korisnik> korisniciZaBrisanje = new ArrayList<Korisnik>();
			for (Korisnik korisnik : pronadjeniKorisnici) {
				if (!korisnik.getKorisnickoIme().toLowerCase().contains(korisnickoIme.toLowerCase())) {
					korisniciZaBrisanje.add(korisnik);
				}
			}
			pronadjeniKorisnici.removeAll(korisniciZaBrisanje);
		}

		if (ime != null && !ime.isEmpty()) {
			List<Korisnik> korisniciZaBrisanje = new ArrayList<Korisnik>();
			for (Korisnik korisnik : pronadjeniKorisnici) {
				if (!korisnik.getIme().toLowerCase().contains(ime.toLowerCase())) {
					korisniciZaBrisanje.add(korisnik);
				}
			}
			pronadjeniKorisnici.removeAll(korisniciZaBrisanje);
		}

		if (prezime != null && !prezime.isEmpty()) {
			List<Korisnik> korisniciZaBrisanje = new ArrayList<Korisnik>();

			for (Korisnik korisnik : pronadjeniKorisnici) {

				if (!korisnik.getPrezime().toLowerCase().contains(prezime.toLowerCase())) {
					korisniciZaBrisanje.add(korisnik);
				}
			}
			pronadjeniKorisnici.removeAll(korisniciZaBrisanje);
		}

		if (polString != null && !polString.isEmpty()) {
			Pol pol = null;
			if (polString.equals("muski"))
				pol = Pol.Muski;
			else
				pol = Pol.Zenski;
			List<Korisnik> korisniciZaBrisanje = new ArrayList<Korisnik>();
			for (Korisnik korisnik : pronadjeniKorisnici) {
				if (!korisnik.getPol().equals(pol)) {
					korisniciZaBrisanje.add(korisnik);
				}
			}
			pronadjeniKorisnici.removeAll(korisniciZaBrisanje);
		}

		if (ulogaString != null && !ulogaString.isEmpty()) {
			Uloga uloga = pretvoriUlogu(ulogaString);
			List<Korisnik> korisniciZaBrisanje = new ArrayList<Korisnik>();
			for (Korisnik korisnik : pronadjeniKorisnici) {
				if (!korisnik.getUloga().equals(uloga)) {
					korisniciZaBrisanje.add(korisnik);
				}
			}
			pronadjeniKorisnici.removeAll(korisniciZaBrisanje);
		}

		getServletContext().setAttribute("korisnici", pronadjeniKorisnici);
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/visestrukaPretragaKorisnika.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private Uloga pretvoriUlogu(String uloga) {
		switch (uloga) {
		case "administrator":
			return Uloga.Administrator;
		case "domacin":
			return Uloga.Domacin;
		case "gost":
			return Uloga.Gost;
		default:
			return null;
		}
	}

}
