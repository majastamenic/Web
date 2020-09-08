package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Administrator;
import beans.Adresa;
import beans.Amenities;
import beans.Apartman;
import beans.Domacin;
import beans.KomentarZaApartman;
import beans.Korisnik;
import beans.Lokacija;
import beans.Rezervacija;
import dao.AdministratorDAO;
import dao.AdresaDAO;
import dao.AmenitiesDAO;
import dao.ApartmanDAO;
import dao.DomacinDAO;
import dao.KomentarDAO;
import dao.RezervacijaDAO;
import dao.UserDAO;
import dao.lokacijaDAO;

/**
 * Servlet implementation class LogInServlet
 */

public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/logovanje.jsp");
		disp.forward(request, response);
		/*Adresa adresa= AdresaDAO.findAdressById(1);
		System.out.println(adresa.getId()+" "+adresa.getNaseljenoMesto()+" "+adresa.getPostanskiBroj()+" "+adresa.getUlicaBroj());
		Amenities pogodnost = AmenitiesDAO.findAmenitiesById(1);
		System.out.println(pogodnost.getId()+" "+pogodnost.getNaziv());
		
		Apartman apartman = ApartmanDAO.findApartmentById(1);
		System.out.println(apartman.getId()+ " "+apartman.getBrojGostiju()+" "+ apartman.getBrojSoba()+" "+apartman.getCenaPoNoci()+" "+apartman.getVremeZaOdjavu()+" "+ apartman.getDatumZaIzdavanje()+ apartman.getDomacin());
		KomentarZaApartman komentar = KomentarDAO.findCommentById(1);
		System.out.println(komentar.getId());
		Lokacija lokacija = lokacijaDAO.findLocationById(1);
		System.out.println(lokacija.getId());
		Rezervacija rezervacija = RezervacijaDAO.findReservationById(1);
		System.out.println(rezervacija.getId());
		Domacin domacin= DomacinDAO.findHostById(1);
		System.out.println(domacin.getId());
		Administrator admin = AdministratorDAO.findAdminById(1);
		System.out.println(admin.getId());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String korisnickoIme = request.getParameter("korisnickoIme");
		String lozinka = request.getParameter("lozinka");
		
		
		if(korisnickoIme.isEmpty() || lozinka.isEmpty()) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/neuspesnaRegistracija.jsp");
			requestDispatcher.forward(request, response);
		}else {
			Korisnik korisnik = UserDAO.findUserByCredentials(korisnickoIme, lozinka);
			
			/*if(korisnik!=null) {
				request.setAttribute("user", korisnik);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/ProfilAdmin.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/neuspesnaRegistracija.jsp");
				requestDispatcher.forward(request, response);
				
			}*/
			HttpSession session=request.getSession();
			session.setAttribute("korisnickoIme", korisnickoIme);
			response.sendRedirect("/JSP/ProfilAdmin.jsp");
			
		}
		
	}

}
