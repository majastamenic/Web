package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Domacin;
import beans.Gost;
import dao.GostDAO;

/**
 * Servlet implementation class PregledKorisnikaKojiImajuRezervacijuServlet
 */
@WebServlet("/PregledKorisnikaKojiImajuRezervacijuServlet")
public class PregledKorisnikaKojiImajuRezervacijuServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledKorisnikaKojiImajuRezervacijuServlet() {
        super();
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


GostDAO.ucitajGoste();
List<Gost> gosti= GostDAO.ucitajGosteZaDomacina((Domacin) LogInServlet.ulogovaniKorisnik);
request.setAttribute("listaGostiju", gosti);
RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledGostijuSaRezervacijom.jsp");
disp.forward(request, response);
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
}

}