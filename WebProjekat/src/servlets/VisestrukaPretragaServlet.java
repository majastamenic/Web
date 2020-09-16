package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
public class VisestrukaPretragaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisestrukaPretragaServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		if(pocetniBrojSobaString!=null && krajnjiBrojSobaString!=null && pocetniBrojSobaString!="" && krajnjiBrojSobaString!="") {
			try {
				int pocetniBrojSoba = Integer.parseInt(pocetniBrojSobaString);
				int krajnjiBrojSoba = Integer.parseInt(krajnjiBrojSobaString);
				
				ArrayList<Apartman> apartmani = ApartmanDAO.pretragaPoBrojuSoba(pocetniBrojSoba, krajnjiBrojSoba);
				pronadjeniApartmani.addAll(apartmani);
				
			} catch (Exception e) {}
		}
		
		if(pocetniBrojGostijuString!=null && krajnjiBrojGostijuString!=null && pocetniBrojGostijuString!="" && krajnjiBrojGostijuString!="") {
			try {
				int pocetniBrojGostiju = Integer.parseInt(pocetniBrojGostijuString);
				int krajnjiBrojGostiju = Integer.parseInt(krajnjiBrojGostijuString);
				
				ArrayList<Apartman> apartmani = ApartmanDAO.pretragaPoBrOsoba(pocetniBrojGostiju, krajnjiBrojGostiju);
				pronadjeniApartmani.addAll(apartmani);
			}catch (Exception e) {}
		}
		
		if(tipString!=null && tipString!="") {
			TipApartmana tip = null;
			if(tipString.equals("apartman")) 
				tip = TipApartmana.Apartman;
			else
				tip = TipApartmana.Soba;
			ArrayList<Apartman> apartmani = ApartmanDAO.pretragaPoTipu(tip);
			pronadjeniApartmani.addAll(apartmani);
		}
		
		if(lokacijaString!=null && lokacijaString!="") {
			try {
				Lokacija lokacija = LokacijaDAO.findLocationById(Integer.parseInt(lokacijaString));
				ArrayList<Apartman> apartmani = ApartmanDAO.pretragaLokaciji(lokacija);
				pronadjeniApartmani.addAll(apartmani);
			}catch (Exception e) {}
		}
		
		if(pogodnostiString!=null && pogodnostiString!="") {
			try {
				Amenities pogodnost = AmenitiesDAO.pronadjiPoNazivu(pogodnostiString);
				ArrayList<Apartman> apartmani = ApartmanDAO.pretragaPoPogodnostima(pogodnost);
				pronadjeniApartmani.addAll(apartmani);
				
			} catch (Exception e) {}
		}
		
		if(pocetnaCenaString!=null && krajnjaCenaString!=null && pocetnaCenaString!="" && krajnjaCenaString!="") {
			try {
				float pocetnaCena = Float.parseFloat(pocetnaCenaString);
				float krajnjaCena = Float.parseFloat(krajnjaCenaString);
				
				ArrayList<Apartman> apartmani = ApartmanDAO.pretragaPoCeni(pocetnaCena, krajnjaCena);
				pronadjeniApartmani.addAll(apartmani);
				
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
