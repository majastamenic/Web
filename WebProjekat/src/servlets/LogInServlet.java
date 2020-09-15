package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Administrator;
import beans.Domacin;
import beans.Gost;
import beans.Korisnik;
import dao.UserDAO;


/**
 * Servlet implementation class LogInServlet
 */

public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Korisnik ulogovaniKorisnik;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/logovanje.jsp");
		disp.forward(request, response);
		
		//GostDAO.izbrisiGosta(28);
		//DomacinDAO.izbrisiDomacina(11);
		//AdministratorDAO.izbrisiAdmina(31);
		//AmenitiesDAO.izbrisiPogodnost(1);
		//ApartmanDAO.izbrisiApartman(1);  
		
		
		
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
			ulogovaniKorisnik = korisnik;
			System.out.println(korisnik);
			if(korisnik!= null) {
				if (korisnik instanceof Gost) {
//					Gost noviGost = (Gost) korisnik;
					System.out.println("Logovao se korisnik");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilGostServlet");
					HttpSession session = request.getSession();
					request.setAttribute("ulogovaniKorisnik", korisnik);				
					session.setAttribute("ulogovaniKorisnik", korisnik);
					
					requestDispatcher.forward(request, response);
				}
				if (korisnik instanceof Domacin) {
//					Domacin noviDomacin = (Domacin) korisnik;
					System.out.println("Logovao se domacin");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilDomacinServlet");
					HttpSession session = request.getSession();
					request.setAttribute("ulogovaniKorisnik", korisnik);				
					session.setAttribute("ulogovaniKorisnik", korisnik);
					
					requestDispatcher.forward(request, response);
				}
				if (korisnik instanceof Administrator) {
//					Administrator noviAdin = (Administrator) korisnik;
					System.out.println("Logovao se admin");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilAdminServlet");
					HttpSession session = request.getSession();
					request.setAttribute("ulogovaniKorisnik", korisnik);				
					session.setAttribute("ulogovaniKorisnik", korisnik);
					
					requestDispatcher.forward(request, response);
				}
			
			}
			else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/neuspesnaRegistracija.jsp");
				requestDispatcher.forward(request, response);
				
			}
			
			
			
			
		}
		
	}

}
