package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Pol;
import beans.Uloga;

/**
 * Servlet implementation class IzmenaPodatakaServlet
 */
@WebServlet("/IzmenaPodatakaServlet")
public class IzmenaPodatakaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmenaPodatakaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/izmenaPodataka.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String lozinka = request.getParameter("lozinka");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		Pol pol = Pol.valueOf(request.getParameter("pol"));
		Uloga uloga = Uloga.valueOf(request.getParameter("uloga"));
	}

}
