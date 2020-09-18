package servlets;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Domacin;
import beans.Uloga;
import dao.ApartmanDAO;

/**
 * Servlet implementation class PrikaziApartmanServlet
 */
@WebServlet("/PrikaziApartmanServlet")
public class PrikaziApartmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApartmanDAO apartmandao= new ApartmanDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikaziApartmanServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("id", request.getParameter("id"));
		if(LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Domacin))
			request.setAttribute("mapaApartmana", ApartmanDAO.ucitajApartmaneOdDomacina((Domacin) LogInServlet.ulogovaniKorisnik));
		else
			request.setAttribute("mapaApartmana", ApartmanDAO.ucitajApartmane());
				
		
			RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledApartmana.jsp");
			disp.forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
