package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import beans.Apartman;
import beans.Gost;
import beans.KomentarZaApartman;
import dao.ApartmanDAO;
import dao.KomentarDAO;

/**
 * Servlet implementation class dodavanjeKomentaraServlet
 */
@WebServlet("/dodavanjeKomentaraServlet")
public class dodavanjeKomentaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dodavanjeKomentaraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.getAttribute("ulogovaniKorisnik");
	
		request.setAttribute("ulogovaniKorisnik", session.getAttribute("ulogovaniKorisnik"));
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/dodajKomentar.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idApartmana = request.getParameter("apartman");
		
		Apartman apartman = new Apartman();
		ApartmanDAO.ucitajApartmane();
		apartman= ApartmanDAO.findApartmentById(Integer.parseInt(idApartmana));
		HttpSession session = request.getSession();
		Gost gost= (Gost) session.getAttribute("ulogovaniKorisnik");
		String tekst= request.getParameter("komentar");
		String ocena =request.getParameter("ocena");
		Integer ocena1= Integer.parseInt(ocena);
		KomentarZaApartman komentar = new KomentarZaApartman();
		komentar.setApartman(apartman);
		komentar.setGost(gost);
		komentar.setOcena(ocena1);
		komentar.setTekst(tekst);
		KomentarDAO.ucitajKomentare();
		KomentarDAO.sacuvajSveKomentareIzMape();
		KomentarDAO.dodajKomentarUMapu(komentar);
		KomentarDAO.sacuvajSveKomentareIzMape();
		
	}

}
