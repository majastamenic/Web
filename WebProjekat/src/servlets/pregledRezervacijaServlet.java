package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RezervacijaDAO;

/**
 * Servlet implementation class pregledRezervacijaServlet
 */
@WebServlet("/pregledRezervacijaServlet")
public class pregledRezervacijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RezervacijaDAO rd= new RezervacijaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pregledRezervacijaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		rd.ucitajRezervacije();
		request.setAttribute("listaRezervacija", rd.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledRezervacija.jsp");
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
