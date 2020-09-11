package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AmenitiesDAO;

/**
 * Servlet implementation class OdrzavanjeSadrzajaServlet
 */
@WebServlet("/OdrzavanjeSadrzajaServlet")
public class OdrzavanjeSadrzajaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AmenitiesDAO ad = new AmenitiesDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OdrzavanjeSadrzajaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ad.ucitajPogodnosti();
		request.setAttribute("listaPogodnosti", ad.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/upravljanjePogodnostima.jsp");
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
