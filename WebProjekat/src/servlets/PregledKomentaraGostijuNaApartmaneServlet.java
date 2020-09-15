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
	KomentarDAO kd= new KomentarDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledKomentaraGostijuNaApartmaneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idApartmana= request.getParameter("ID");
		Apartman apartman = new Apartman();
		ApartmanDAO.ucitajApartmane();
		apartman = ApartmanDAO.findApartmentById(Integer.parseInt(idApartmana));
		kd.ucitajKomentare();
		request.setAttribute("listaKomentara", kd.komentarNaApartman(apartman));
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledKomentaraAktivnihApartmana.jsp");
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
