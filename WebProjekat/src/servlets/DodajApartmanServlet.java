package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AmenitiesDAO;
import dao.LokacijaDAO;

/**
 * Servlet implementation class DodajApartmanServlet
 */
@WebServlet("/DodajApartmanServlet")
public class DodajApartmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LokacijaDAO ld= new LokacijaDAO();
       AmenitiesDAO ad= new AmenitiesDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajApartmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ld.ucitajLokaciju();
		request.setAttribute("listaLokacija", ld.findAll());
		ad.ucitajPogodnosti();
		request.setAttribute("listaPogodnosti", ad.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/dodajApartman.jsp");
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
