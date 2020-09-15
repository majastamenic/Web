package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministratorDAO;
import dao.DomacinDAO;
import dao.GostDAO;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		doGet(request, response);
	}

}
