package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Domacin;
import beans.Gost;
import dao.RezervacijaDAO;

/**
 * Servlet implementation class SortiraneRezervacijeOpadajuceDomacinServlet
 */
@WebServlet("/SortiraneRezervacijeOpadajuceDomacinServlet")
public class SortiraneRezervacijeOpadajuceDomacinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortiraneRezervacijeOpadajuceDomacinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaRezervacija", RezervacijaDAO.sortiranjePoCeniDomacinOpadajuce((Domacin) LogInServlet.ulogovaniKorisnik));
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledRezervacijaSortiraneDomacinOpadajuce.jsp");
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
