package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Gost;
import beans.Rezervacija;
import beans.StatusRezervacija;
import dao.GostDAO;
import dao.RezervacijaDAO;

/**
 * Servlet implementation class VisestrukaPretragaRezervacijaServlet
 */
@WebServlet("/VisestrukaPretragaRezervacijaServlet")
public class VisestrukaPretragaRezervacijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisestrukaPretragaRezervacijaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String korisnickoIme = request.getParameter("korisnickoIme");
		String statusString = request.getParameter("status");
		List<Rezervacija> pronadjeneRezervacije = new ArrayList<Rezervacija>();
		
		for(Rezervacija rezervacija:RezervacijaDAO.ucitajRezervacije().values()) {
			pronadjeneRezervacije.add(rezervacija);
		}
		
		Gost gost = GostDAO.pretragaPoKorisnickomImenu(korisnickoIme);
		
		if(korisnickoIme!=null && !korisnickoIme.isEmpty()) {
			List<Rezervacija> rezervacijeZaBrisanje = new ArrayList<Rezervacija>();
			for(Rezervacija rezervacija:pronadjeneRezervacije) {
				if(!(rezervacija.getGost().getId()==gost.getId())) {
					rezervacijeZaBrisanje.add(rezervacija);
				}
			}
			pronadjeneRezervacije.removeAll(rezervacijeZaBrisanje);
		}
		
		if(statusString!=null && !statusString.isEmpty()) {
			StatusRezervacija status = null;
			if(statusString.equals("kreirana"))
				status = StatusRezervacija.Kreirana;
			else if(statusString.equals("odbijena"))
				status = StatusRezervacija.Odbijena;
			else if(statusString.equals("odustanak"))
				status = StatusRezervacija.Odustanak;
			else if(statusString.equals("prihvacena"))
				status = StatusRezervacija.Prihvacena;
			else
				status = StatusRezervacija.Zavrsena;
			
			List<Rezervacija> rezervacijeZaBrisanje = new ArrayList<Rezervacija>();
			for(Rezervacija rezervacija:pronadjeneRezervacije) {
				if(!rezervacija.getStatus().equals(status)) {
					rezervacijeZaBrisanje.add(rezervacija);
				}
			}
			pronadjeneRezervacije.removeAll(rezervacijeZaBrisanje);
		}
		
		getServletContext().setAttribute("rezervacije", pronadjeneRezervacije);
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/visestrukaPretragaRezervacije.jsp");
		disp.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
