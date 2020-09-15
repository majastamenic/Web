package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RezervacijaDAO;

/**
 * Servlet implementation class pregledSvihRezervacijaServlet
 */
@WebServlet("/pregledSvihRezervacijaServlet")
public class pregledSvihRezervacijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pregledSvihRezervacijaServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RezervacijaDAO.ucitajRezervacije();
		request.setAttribute("listaRezervacija", RezervacijaDAO.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledSvihRezervacija.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
