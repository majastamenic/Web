package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Apartman;
import beans.Korisnik;
import dao.AdministratorDAO;
import dao.DomacinDAO;
import dao.GostDAO;
import dao.UserDAO;

/**
 * Servlet implementation class PregledSvihKorisnikaServlet
 */
@WebServlet("/PregledSvihKorisnikaServlet")
public class PregledSvihKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledSvihKorisnikaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GostDAO.ucitajGoste();
		request.setAttribute("listaGostiju", GostDAO.findAll());
		AdministratorDAO.ucitajAdmine();
		request.setAttribute("listaAdmina", AdministratorDAO.findAll());
		DomacinDAO.ucitajDomacine();
		request.setAttribute("listaDomacina", DomacinDAO.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledKorisnika.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
