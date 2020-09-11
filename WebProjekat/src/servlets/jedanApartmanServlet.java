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
 * Servlet implementation class jedanApartmanServlet
 */
@WebServlet("/jedanApartmanServlet")
public class jedanApartmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApartmanDAO apartmanDAO = new ApartmanDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jedanApartmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		apartmanDAO.ucitajApartmane();
		request.setAttribute("listaApartmana", apartmanDAO.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledApartmana.jsp");
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
