package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApartmanDAO;

/**
 * Servlet implementation class BrisanjeApartmanaServlet
 */
@WebServlet("/BrisanjeApartmanaServlet")
public class BrisanjeApartmanaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrisanjeApartmanaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idApartmana = request.getParameter("id");
		
		Integer id= Integer.parseInt(idApartmana);
		ApartmanDAO.findApartmentById(id);
		ApartmanDAO.ucitajApartmane();
		ApartmanDAO.sacuvajSveApartmaneIzMape();
		ApartmanDAO.izbrisiApartman(id);
		ApartmanDAO.sacuvajSveApartmaneIzMape();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
