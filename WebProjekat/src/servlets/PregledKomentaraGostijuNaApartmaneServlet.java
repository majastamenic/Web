package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Apartman;
import dao.ApartmanDAO;
import dao.KomentarDAO;

/**
 * Servlet implementation class PregledKomentaraGostijuNaApartmaneServlet
 */
@WebServlet("/PregledKomentaraGostijuNaApartmaneServlet")
public class PregledKomentaraGostijuNaApartmaneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledKomentaraGostijuNaApartmaneServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idApartmana= request.getParameter("id");
		Apartman apartman = new Apartman();
		ApartmanDAO.ucitajApartmane();
		apartman = ApartmanDAO.findApartmentById(Integer.parseInt(idApartmana));
		KomentarDAO.ucitajKomentare();
		request.setAttribute("listaKomentara", KomentarDAO.komentarNaApartman(apartman));
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledKomentaraAktivnihApartmana.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
