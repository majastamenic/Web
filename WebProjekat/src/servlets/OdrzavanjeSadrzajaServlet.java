package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Amenities;
import dao.AmenitiesDAO;

/**
 * Servlet implementation class OdrzavanjeSadrzajaServlet
 */
@WebServlet("/OdrzavanjeSadrzajaServlet")
public class OdrzavanjeSadrzajaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OdrzavanjeSadrzajaServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AmenitiesDAO.ucitajPogodnosti();
		request.setAttribute("listaPogodnosti", AmenitiesDAO.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/upravljanjePogodnostima.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vrednost= request.getParameter("pogodnost");
		AmenitiesDAO.dodajPogodnostUMapu(new Amenities(AmenitiesDAO.vratiNajveciID(), vrednost));
		AmenitiesDAO.sacuvajSvePogodnostiIzMape();
		doGet(request, response);
	}

}
