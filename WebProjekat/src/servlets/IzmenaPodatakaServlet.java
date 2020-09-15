package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Administrator;
import beans.Domacin;
import beans.Gost;
import beans.Pol;
import beans.Uloga;
import dao.AdministratorDAO;
import dao.DomacinDAO;
import dao.GostDAO;

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
		
		request.setAttribute("ime", LogInServlet.ulogovaniKorisnik.getIme());
		request.setAttribute("prezime", LogInServlet.ulogovaniKorisnik.getPrezime());
		request.setAttribute("pol", LogInServlet.ulogovaniKorisnik.getPol());
		request.setAttribute("lozinka", LogInServlet.ulogovaniKorisnik.getLozinka());
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/izmenaPodataka.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		Pol pol = Pol.valueOf(request.getParameter("pol"));
		String lozinka = request.getParameter("lozinka");
		String ponovljenaLozinka = request.getParameter("ponovljenaLozinka");
		
		if(lozinka.equals(ponovljenaLozinka)) {
			if(LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Administrator)) {
				for(Administrator admin:AdministratorDAO.ucitajAdmine().values()) {
					if(admin.getKorisnickoIme().equals(LogInServlet.ulogovaniKorisnik.getKorisnickoIme())) {
						AdministratorDAO.izmeniAdministratora(new Administrator(admin.getId(), admin.getKorisnickoIme(), lozinka, ime, prezime, pol, admin.getUloga()));
					}
				}
			}
			
			if(LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Gost)) {
				for(Gost gost:GostDAO.ucitajGoste().values()) {
					if(gost.getKorisnickoIme().equals(LogInServlet.ulogovaniKorisnik.getKorisnickoIme())) {
						GostDAO.izmeniGosta(new Gost(gost.getId(), gost.getKorisnickoIme(), lozinka, ime, prezime, pol, gost.getUloga()));
					}
				}
			}

			if(LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Domacin)) {
				for(Domacin domacin:DomacinDAO.ucitajDomacine().values()) {
					if(domacin.getKorisnickoIme().equals(LogInServlet.ulogovaniKorisnik.getKorisnickoIme())) {
						DomacinDAO.izmeniDomacina(new Domacin(domacin.getId(), domacin.getKorisnickoIme(), lozinka, ime, prezime, pol, domacin.getUloga()));
					}
				}
			}
		}
		
		/*		
		if(lozinka.equals(ponovljenaLozinka)) {
			if(korisnik.getUloga().equals(Uloga.Administrator)) {
				java.util.Map<Integer, Administrator> adminMapa = AdministratorDAO.ucitajAdmine();
				for(Administrator admin:adminMapa.values()) {
					if(admin.getKorisnickoIme().equals(korisnik.getKorisnickoIme())) {
						AdministratorDAO.izmeniAdministratora((Administrator) korisnik);
						break;
					}
						
				}
				
			}else if(korisnik.getUloga().equals(Uloga.Domacin)) {
				
				java.util.Map<Integer, Domacin> domacinMapa = DomacinDAO.ucitajDomacine();
				for(Domacin domacin:domacinMapa.values()) {
					if(domacin.getKorisnickoIme().equals(korisnik.getKorisnickoIme())) {
						DomacinDAO.izmeniDomacina((Domacin) korisnik);
						break;
					}
						
				}
				
			}else if(korisnik.getUloga().equals(Uloga.Gost)) {
				java.util.Map<Integer, Gost> gostMapa = GostDAO.ucitajGoste();
				for(Gost gost:gostMapa.values()) {
					if(gost.getKorisnickoIme().equals(korisnik.getKorisnickoIme())) {
						GostDAO.izmeniGosta((Gost) korisnik);
						break;
					}
						
				}
			}
		}
		
		
		*/
	}

}
