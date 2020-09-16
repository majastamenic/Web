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
 * Servlet implementation class SortiranjeApartmanaRastuceGostNeulogovaniServlet
 */
@WebServlet("/SortiranjeApartmanaRastuceGostNeulogovaniServlet")
public class SortiranjeApartmanaRastuceGostNeulogovaniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortiranjeApartmanaRastuceGostNeulogovaniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApartmanDAO.ucitajApartmane();
		request.setAttribute("listaApartmana", ApartmanDAO.sortiranjePoCeniRastuceAktivniGost());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledApartmanaSortiraniRastuceGost.jsp");
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
