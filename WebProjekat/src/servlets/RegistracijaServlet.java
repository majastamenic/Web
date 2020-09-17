package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Administrator;
import beans.Domacin;
import beans.Gost;
import dao.AdministratorDAO;
import dao.DomacinDAO;
import dao.GostDAO;
import dao.UserDAO;


/**
 * Servlet implementation class RegistracijaServlet
 */
@WebServlet("/RegistracijaServlet")
public class RegistracijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracijaServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/registracija.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String korisnickoIme = request.getParameter("korisnickoIme");
		String lozinka = request.getParameter("lozinka");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String pol = request.getParameter("pol");
		
		Gost gost= GostDAO.findGuestByUsername(korisnickoIme);
		Domacin domacin = DomacinDAO.findHostByUsername(korisnickoIme);
		Administrator admin = AdministratorDAO.findAdminByUsername(korisnickoIme);

		if (gost == null && domacin==null && admin==null) {
			System.out.println(korisnickoIme  + " " + lozinka);
			Gost noviGost = new Gost();
			noviGost.setKorisnickoIme(korisnickoIme);
			noviGost.setLozinka(lozinka);
			noviGost.setPol(pol);
			noviGost.setIme(ime);
			noviGost.setPrezime(prezime);
			GostDAO.dodajGostaUMapu(noviGost);
			GostDAO.sacuvajSveGosteIzMape();
			
			HttpSession session = request.getSession();
			request.setAttribute("ulogovaniKorisnik", gost);				
			session.setAttribute("ulogovaniKorisnik", gost);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilGostServlet");
			requestDispatcher.forward(request, response);
			
			LogInServlet.ulogovaniKorisnik = UserDAO.findUserByCredentials(korisnickoIme, lozinka);
		}
		
		else {
			request.setAttribute("err", "Vec postoji korisnik sa datim username, izaberite drugi username");
			doGet(request, response);
			return;
		}
		}
	}


