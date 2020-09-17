package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Apartman;
import beans.Domacin;
import beans.Lokacija;
import beans.StatusApartman;
import beans.TipApartmana;
import dao.AmenitiesDAO;
import dao.ApartmanDAO;
import dao.LokacijaDAO;

/**
 * Servlet implementation class DodajApartmanServlet
 */
@WebServlet("/DodajApartmanServlet")
public class DodajApartmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajApartmanServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LokacijaDAO.ucitajLokaciju();
		request.setAttribute("listaLokacija", LokacijaDAO.findAll());
		AmenitiesDAO.ucitajPogodnosti();
		request.setAttribute("listaPogodnosti", AmenitiesDAO.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/dodajApartman.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int id = ApartmanDAO.vratiNajveciID();
		TipApartmana tip= null;
		String tipString = request.getParameter("tip");
		if(tipString.equals("Apartman"))
			tip=TipApartmana.Apartman;
		else
			tip=TipApartmana.Soba;
	
		
		int brojSoba = Integer.parseInt(request.getParameter("brojSoba"));
		int brojGostiju = Integer.parseInt(request.getParameter("brojGostiju"));
		String idlokacija = request.getParameter("lokacija");
		
		Lokacija lokacija = new Lokacija();
		LokacijaDAO.ucitajLokaciju();
		lokacija= LokacijaDAO.findLocationById(Integer.parseInt(idlokacija));		
		Date datumZaIzdavanje = new Date();
		HttpSession session = request.getSession();
		Domacin domacin= (Domacin) session.getAttribute("ulogovaniKorisnik");
		float cenaPoNoci = Float.parseFloat(request.getParameter("cenaPoNoci"));
		String vremeZaPrijavu = "14:00";
		String vremeZaOdjavu = "10:00";
		StatusApartman status = StatusApartman.Neaktivno;
		Apartman a= new Apartman();
		a.setId(id);
		a.setBrojGostiju(brojGostiju);
		a.setBrojSoba(brojSoba);
		a.setCenaPoNoci(cenaPoNoci);
		a.setDatumZaIzdavanje(datumZaIzdavanje);
		a.setDomacin(domacin);
		a.setStatus(status);
		a.setLokacija(lokacija);
		a.setTip(tip);
		a.setVremeZaOdjavu(vremeZaOdjavu);
		a.setVremeZaPrijavu(vremeZaPrijavu);
		
		
		ApartmanDAO.ucitajApartmane();
		ApartmanDAO.sacuvajSveApartmaneIzMape();
		ApartmanDAO.dodajApartmanUMapu(a);
		ApartmanDAO.sacuvajSveApartmaneIzMape();
	}

}
