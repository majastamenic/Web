package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int brojGostiju = Integer.parseInt(request.getParameter("brojGostiju"));;
		Lokacija lokacija = new Lokacija();
		Date datumZaIzdavanje = new Date();
		Domacin domacin = (Domacin) LogInServlet.ulogovaniKorisnik;
		float cenaPoNoci = Float.parseFloat(request.getParameter("cenaPoNoci"));
		String vremeZaPrijavu = request.getParameter("vremeZaPrijavu");
		String vremeZaOdjavu = request.getParameter("vremeZaOdjavu");
		StatusApartman status = StatusApartman.Neaktivno;
		
		Apartman a = new Apartman(id, tip, brojSoba, brojGostiju, lokacija, datumZaIzdavanje, domacin, cenaPoNoci, vremeZaPrijavu, vremeZaOdjavu, status);
		
		ApartmanDAO.ucitajApartmane();
		ApartmanDAO.sacuvajSveApartmaneIzMape();
		ApartmanDAO.dodajApartmanUMapu(a);
		ApartmanDAO.sacuvajSveApartmaneIzMape();
	}

}
