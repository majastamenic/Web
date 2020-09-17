package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApartmanDAO;

/**
 * Servlet implementation class SortiranjeApartmanaOpadajuceGostNeulogovaniServlet
 */
@WebServlet("/SortiranjeApartmanaOpadajuceGostNeulogovaniServlet")
public class SortiranjeApartmanaOpadajuceGostNeulogovaniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortiranjeApartmanaOpadajuceGostNeulogovaniServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApartmanDAO.ucitajApartmane();
		request.setAttribute("listaApartmana", ApartmanDAO.sortiranjePoCeniOpadajuceAktivniGost());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledApartmanaSortiraniOpadajuceGost.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
