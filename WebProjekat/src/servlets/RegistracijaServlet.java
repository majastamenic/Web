package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Gost;
import beans.Pol;
import dao.GostDAO;


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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
//		Uloga uloga = Uloga.valueOf(request.getParameter("uloga"));
		
		System.out.println(korisnickoIme  + " " + lozinka);
		Gost noviGost = new Gost();
		noviGost.setKorisnickoIme(korisnickoIme);
		noviGost.setLozinka(lozinka);
		noviGost.setPol(pol);
		noviGost.setIme(ime);
		noviGost.setPrezime(prezime);
		GostDAO.dodajGostaUMapu(noviGost);
		GostDAO.sacuvajSveGosteIzMape();
		
		if(korisnickoIme.isEmpty() || lozinka.isEmpty()) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/neuspesnaRegistracija.jsp");
			requestDispatcher.forward(request, response);
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/uspesnaRegistracija.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
