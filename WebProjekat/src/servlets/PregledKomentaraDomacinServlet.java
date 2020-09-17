package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Domacin;
import dao.KomentarDAO;

/**
 * Servlet implementation class PregledKomentaraDomacinServlet
 */
@WebServlet("/PregledKomentaraDomacinServlet")
public class PregledKomentaraDomacinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledKomentaraDomacinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KomentarDAO.ucitajKomentare();
		request.setAttribute("listaKomentara", KomentarDAO.ucitajKomentareNaApartmaneOdDomacina((Domacin) LogInServlet.ulogovaniKorisnik).values());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledKomentaraDomacin.jsp");
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
