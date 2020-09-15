package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Apartman;
import beans.Domacin;
import beans.KomentarZaApartman;
import beans.Lokacija;
import beans.StatusApartman;
import beans.TipApartmana;
import dao.ApartmanDAO;

/**
 * Servlet implementation class IzmenaApartmanaServlet
 */
@WebServlet("/IzmenaApartmanaServlet")
public class IzmenaApartmanaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmenaApartmanaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idApartmana = request.getParameter("ID");
		if(idApartmana!=null) {
			RequestDispatcher disp = request.getRequestDispatcher("/JSP/izmenaApartmana.jsp");
			disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int idApartmana = Integer.parseInt(request.getParameter("ID"));
		TipApartmana tip = TipApartmana.valueOf(request.getParameter("tip"));
		int brojSoba = Integer.parseInt(request.getParameter("brojSoba"));
		int brojGostiju = Integer.parseInt(request.getParameter("brojGostiju"));;
		Lokacija lokacija = new Lokacija();
		Date datumZaIzdavanje = new Date();
		Domacin domacin = new Domacin();
		KomentarZaApartman komentar = new KomentarZaApartman();
		float cenaPoNoci = Float.parseFloat(request.getParameter("cenaPoNoci"));
		String vremeZaPrijavu = request.getParameter("vremeZaPrijavu");
		String vremeZaOdjavu = request.getParameter("vremeZaOdjavu");
		StatusApartman status = StatusApartman.valueOf(request.getParameter("status"));

		
		Apartman a = new Apartman(idApartmana, tip, brojSoba, brojGostiju, lokacija, datumZaIzdavanje,
				  domacin, cenaPoNoci,
				 vremeZaPrijavu, vremeZaOdjavu, status);
		ApartmanDAO.izmeniApartman(a);
		
		
	}

}
