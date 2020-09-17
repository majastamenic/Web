package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Apartman;
import beans.Gost;
import beans.Rezervacija;
import beans.StatusRezervacija;
import dao.ApartmanDAO;
import dao.RezervacijaDAO;

/**
 * Servlet implementation class kreiranjeRezervacijeServlet
 */
@WebServlet("/kreiranjeRezervacijeServlet")
public class kreiranjeRezervacijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kreiranjeRezervacijeServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ApartmanDAO.ucitajApartmane();
		request.setAttribute("listaApartmana", ApartmanDAO.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/kreiranjeRezervacije.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idApartmana = request.getParameter("apartman");
		
		Apartman apartman = new Apartman();
		ApartmanDAO.ucitajApartmane();
		apartman= ApartmanDAO.findApartmentById(Integer.parseInt(idApartmana));
		String datumPocetkaString = request.getParameter("datum");
		String brojNocenjaString = request.getParameter("brojNocenja");
		String poruka = request.getParameter("poruka");
		
		Rezervacija rezervacija = new Rezervacija();
		
		
			rezervacija.setId(RezervacijaDAO.vratiNajveciID());
			rezervacija.setRezervisanApartman(apartman);
			
				try {SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        
					rezervacija.setPocetniDatum(formatter.parse(datumPocetkaString));
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
			rezervacija.setBrojNocenja(Integer.parseInt(brojNocenjaString));
			rezervacija.setPoruka(poruka);
			rezervacija.setGost((Gost) LogInServlet.ulogovaniKorisnik);
			rezervacija.setStatus(StatusRezervacija.Kreirana);
			rezervacija.setUkupnaCena(rezervacija.getRezervisanApartman().getCenaPoNoci() * rezervacija.getBrojNocenja());
			
			
			RezervacijaDAO.ucitajRezervacije();
			RezervacijaDAO.sacuvajSveRezervacijeIzMape();
			RezervacijaDAO.dodajRezervacijuUMapu(rezervacija);
			RezervacijaDAO.sacuvajSveRezervacijeIzMape();
			
			doGet(request, response);
	}

}
