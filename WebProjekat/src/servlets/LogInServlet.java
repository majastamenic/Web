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
			if(korisnik!= null) {
				if (korisnik instanceof Gost) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilGostServlet");
					HttpSession session = request.getSession();
					request.setAttribute("ulogovaniKorisnik", korisnik);				
					session.setAttribute("ulogovaniKorisnik", korisnik);
					
					requestDispatcher.forward(request, response);
				}
				if (korisnik instanceof Domacin) {
					System.out.println("Logovao se domacin");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilDomacinServlet");
					HttpSession session = request.getSession();
					request.setAttribute("ulogovaniKorisnik", korisnik);				
					session.setAttribute("ulogovaniKorisnik", korisnik);
					
					requestDispatcher.forward(request, response);
				}
				if (korisnik instanceof Administrator) {
					System.out.println("Logovao se admin");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilAdminServlet");
					HttpSession session = request.getSession();
					request.setAttribute("ulogovaniKorisnik", korisnik);				
					session.setAttribute("ulogovaniKorisnik", korisnik);
					
					requestDispatcher.forward(request, response);
				}
			
			}
			else {
				request.setAttribute("err", "Ne postoji korisnik sa datim username/password");
				doGet(request, response);
				return;
				
			}
			
			
			
			
		}
		
	}

}
