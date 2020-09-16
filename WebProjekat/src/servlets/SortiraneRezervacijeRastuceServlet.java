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
 * Servlet implementation class SortiraneRezervacijeRastuceServlet
 */
@WebServlet("/SortiraneRezervacijeRastuceServlet")
public class SortiraneRezervacijeRastuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortiraneRezervacijeRastuceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RezervacijaDAO.ucitajRezervacije();
		request.setAttribute("listaRezervacija", RezervacijaDAO.sortiranjePoCeniRastuce());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledRezervacijaSortiraneRastuce.jsp");
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
