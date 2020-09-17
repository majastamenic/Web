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

import beans.Amenities;
import beans.Apartman;
import beans.Lokacija;
import beans.TipApartmana;
import dao.AmenitiesDAO;
import dao.ApartmanDAO;
import dao.LokacijaDAO;

/**
 * Servlet implementation class VisestrukaPretragaServlet
 */
@WebServlet("/VisestrukaPretragaServlet")
public class VisestrukaPretragaApartmanaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisestrukaPretragaApartmanaServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaLokacija", LokacijaDAO.findAll());
		request.setAttribute("listaPogodnosti", AmenitiesDAO.findAll());
		
		String pocetniBrojSobaString  = request.getParameter("pocetniBrojSoba");
		String krajnjiBrojSobaString = request.getParameter("krajnjiBrojSoba");
		String pocetniBrojGostijuString  = request.getParameter("pocetniBrojGostiju");
		String krajnjiBrojGostijuString = request.getParameter("krajnjiBrojGostiju");
		String tipString = request.getParameter("tip");
		String lokacijaString = request.getParameter("lokacija");
		String pogodnostiString = request.getParameter("Pogodnosti");
		String pocetnaCenaString = request.getParameter("pocetnaCena");
		String krajnjaCenaString = request.getParameter("krajnjaCena");
		ArrayList<Apartman> pronadjeniApartmani = new ArrayList<Apartman>();
		
		for(Apartman apartman:ApartmanDAO.ucitajApartmaneSpramUloge().values()) {
			pronadjeniApartmani.add(apartman);
		}
		
		if(pocetniBrojSobaString!=null && krajnjiBrojSobaString!=null && pocetniBrojSobaString!="" && krajnjiBrojSobaString!="") {
			try {
				List<Apartman> apartmaniZaBrisanje = new ArrayList<Apartman>();
				int pocetniBrojSoba = Integer.parseInt(pocetniBrojSobaString);
				int krajnjiBrojSoba = Integer.parseInt(krajnjiBrojSobaString);
				
				for(Apartman apartman:pronadjeniApartmani) {
					if(!(apartman.getBrojSoba()>=pocetniBrojSoba && apartman.getBrojSoba()<=krajnjiBrojSoba)) {
						apartmaniZaBrisanje.add(apartman);
					}
				}
				pronadjeniApartmani.removeAll(apartmaniZaBrisanje);
				
			} catch (Exception e) {}
		}
		
		if(pocetniBrojGostijuString!=null && krajnjiBrojGostijuString!=null && pocetniBrojGostijuString!="" && krajnjiBrojGostijuString!="") {
			try {
				List<Apartman> apartmaniZaBrisanje = new ArrayList<Apartman>();
				int pocetniBrojGostiju = Integer.parseInt(pocetniBrojGostijuString);
				int krajnjiBrojGostiju = Integer.parseInt(krajnjiBrojGostijuString);
				
				for(Apartman apartman:pronadjeniApartmani) {
					if(!(apartman.getBrojGostiju()>=pocetniBrojGostiju && apartman.getBrojGostiju()<=krajnjiBrojGostiju)) {
						apartmaniZaBrisanje.add(apartman);
					}
				}
				pronadjeniApartmani.removeAll(apartmaniZaBrisanje);
			}catch (Exception e) {}
		}
		
		if(tipString!=null && tipString!="") {
			TipApartmana tip = null;
			if(tipString.equals("apartman")) 
				tip = TipApartmana.Apartman;
			else
				tip = TipApartmana.Soba;
			List<Apartman> apartmaniZaBrisanje = new ArrayList<Apartman>();
			
			for(Apartman apartman:pronadjeniApartmani) {
				if(!apartman.getTip().equals(tip)) {
					apartmaniZaBrisanje.add(apartman);
				}
			}
			pronadjeniApartmani.removeAll(apartmaniZaBrisanje);
		}
		
		if(lokacijaString!=null && lokacijaString!="") {
			try {
				Lokacija lokacija = LokacijaDAO.findLocationById(Integer.parseInt(lokacijaString));
				List<Apartman> apartmaniZaBrisanje = new ArrayList<Apartman>();
				
				for(Apartman apartman:pronadjeniApartmani) {
					if(!(apartman.getLokacija().equals(lokacija))) {
						apartmaniZaBrisanje.add(apartman);
					}
				}
				pronadjeniApartmani.removeAll(apartmaniZaBrisanje);
			}catch (Exception e) {}
		}
		
		if(pogodnostiString!=null && pogodnostiString!="") {
			try {
				Amenities pogodnost = AmenitiesDAO.pronadjiPoNazivu(pogodnostiString);
				List<Apartman> apartmaniZaBrisanje = new ArrayList<Apartman>();
				
				for(Apartman apartman:pronadjeniApartmani) {
					if(!(apartman.getSadrzajApartmana().contains(pogodnost))) {
						apartmaniZaBrisanje.add(apartman);
					}
				}
				pronadjeniApartmani.removeAll(apartmaniZaBrisanje);
				
			} catch (Exception e) {}
		}
		
		if(pocetnaCenaString!=null && krajnjaCenaString!=null && pocetnaCenaString!="" && krajnjaCenaString!="") {
			try {
				float pocetnaCena = Float.parseFloat(pocetnaCenaString);
				float krajnjaCena = Float.parseFloat(krajnjaCenaString);
				List<Apartman> apartmaniZaBrisanje = new ArrayList<Apartman>();
				
				for(Apartman apartman:pronadjeniApartmani) {
					if(!(apartman.getCenaPoNoci()>=pocetnaCena && apartman.getCenaPoNoci()<=krajnjaCena)) {
						apartmaniZaBrisanje.add(apartman);
					}
				}
				pronadjeniApartmani.removeAll(apartmaniZaBrisanje);
				
			} catch (Exception e) {}
		}
		
		getServletContext().setAttribute("apartmani", pronadjeniApartmani);
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/visestrukaPretragaApartmana.jsp");
		disp.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
