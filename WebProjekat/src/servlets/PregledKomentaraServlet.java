package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KomentarDAO;

/**
 * Servlet implementation class PregledKomentaraServlet
 */
@WebServlet("/PregledKomentaraServlet")
public class PregledKomentaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	KomentarDAO kd= new KomentarDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledKomentaraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		kd.ucitajKomentare();
		request.setAttribute("listaKomentara", kd.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledKomentara.jsp");
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
