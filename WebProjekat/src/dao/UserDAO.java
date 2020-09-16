package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import beans.Administrator;
import beans.Apartman;
import beans.Domacin;
import beans.Gost;
import beans.Korisnik;
import beans.Pol;
import beans.Rezervacija;
import beans.Uloga;
import servlets.LogInServlet;


/***
 * <p>Klasa namenjena da uèita korisnike iz fajla i pruža operacije nad njima (poput pretrage).
 * Korisnici se nalaze u fajlu WebContent/users.txt u obliku: <br>
 * firstName;lastName;email;username;password</p>
 * <p><b>NAPOMENA:</b> Lozinke se u praksi <b>nikada</b> ne snimaju u èistu tekstualnom obliku.</p>
 * @author Lazar
 *
 */
public class UserDAO {
	private static Map<String, Korisnik> users = new HashMap<>();
	
	
	
	public UserDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public UserDAO(String contextPath) {
		loadUsers();
	}
	
	/**
	 * Vraæa korisnika za prosleðeno korisnièko ime i šifru. Vraæa null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public Korisnik find(String korisnickoIme, String lozinka) {
		if (!users.containsKey(korisnickoIme)) {
			return null;
		}
		Korisnik user = users.get(korisnickoIme);
		if (!user.getLozinka().equals(lozinka)) {
			return null;
		}
		return user;
	}
	
	public static Collection<Korisnik> findAll() {
		return users.values();
	}
	
	/**
	 * Uèitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #users}.
	 * Kljuè je korisnièko ime korisnika.
	 * @param _PROJECT_LOCATION 
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	public static void loadUsers() {		
		DomacinDAO.ucitajDomacine();
		GostDAO.ucitajGoste();
		AdministratorDAO.ucitajAdmine();
	}
	
	public static Korisnik findUserByCredentials(String korisnickoIme, String lozinka) {
		
		Collection<Domacin> domacini = DomacinDAO.findAll();
			DomacinDAO.ucitajDomacine();
		for(Domacin domacin : domacini) {
			if(domacin.getKorisnickoIme().equals(korisnickoIme) && domacin.getLozinka().equals(lozinka))
				return domacin;
			
		}
		Collection<Administrator> admini = AdministratorDAO.findAll();
			AdministratorDAO.ucitajAdmine();
		for(Administrator admin : admini) {
			if(admin.getKorisnickoIme().equals(korisnickoIme) && admin.getLozinka().equals(lozinka) )
				return admin;
			
		}
		Collection<Gost> gosti = GostDAO.findAll();
			GostDAO.ucitajGoste();
		for(Gost gost : gosti) {
			if( gost.getKorisnickoIme().equals(korisnickoIme)  && gost.getLozinka().equals(lozinka) )
				return gost;
			
		}
		
		return null;
	}

	public static ArrayList<Korisnik> ucitajKorisnikeSpramUloge(){
		ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
		Collection<Apartman> apartmaniDomacina = ApartmanDAO.ucitajApartmaneOdDomacina((Domacin) LogInServlet.ulogovaniKorisnik).values();
		if(LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Domacin)) {
			for(Rezervacija rezervacija:RezervacijaDAO.ucitajRezervacije().values()) {
				for(Apartman apartman:apartmaniDomacina) {
					if(rezervacija.getRezervisanApartman().equals(apartman)) {
						korisnici.add(rezervacija.getGost());
					}
				}
			}
			
		}else {
			korisnici.addAll(AdministratorDAO.ucitajAdmine().values());
			korisnici.addAll(GostDAO.ucitajGoste().values());
			korisnici.addAll(DomacinDAO.ucitajDomacine().values());
		}
		return korisnici;
	}
	
	public static Korisnik findUserByUsername(String korisnickoIme) {
		if (!users.containsKey(korisnickoIme)) {
			return null;
		}
		Korisnik user = users.get(korisnickoIme);
		
		return user;
	}

	public static ArrayList<Korisnik> pretragaPoImenu(String ime) {
		ArrayList<Korisnik> nadjeniKorisnici = new ArrayList<Korisnik>();
		
		for(Korisnik korisnik:ucitajKorisnikeSpramUloge()) {
			if(korisnik.getIme().contains(ime)) {
				nadjeniKorisnici.add(korisnik);
			}
		}
		
		return nadjeniKorisnici;
	}


	public static ArrayList<Korisnik> pretragaPoPrezimenu(String prezime) {
ArrayList<Korisnik> nadjeniKorisnici = new ArrayList<Korisnik>();
		
		for(Korisnik korisnik:ucitajKorisnikeSpramUloge()) {
			if(korisnik.getPrezime().contains(prezime)) {
				nadjeniKorisnici.add(korisnik);
			}
		}
		
		return nadjeniKorisnici;
	}

	public static ArrayList<Korisnik> pretragaPoPolu(Pol pol) {
		ArrayList<Korisnik> nadjeniKorisnici = new ArrayList<Korisnik>();
		
		for(Korisnik korisnik:ucitajKorisnikeSpramUloge()) {
			if(korisnik.getPol().equals(pol)) {
				nadjeniKorisnici.add(korisnik);
			}
		}
		
		return nadjeniKorisnici;
	}

	public static ArrayList<Korisnik> pronadjiAdministratore() {
		ArrayList<Korisnik> pronadjeniAdministratori = new ArrayList<Korisnik>();
		
		for(Administrator admin:AdministratorDAO.ucitajAdmine().values()) {
			pronadjeniAdministratori.add(admin);
		}
		
		return pronadjeniAdministratori;
	}

	public static ArrayList<Korisnik> pronadjiDomacine() {
		ArrayList<Korisnik> pronadjeniDomacini = new ArrayList<Korisnik>();
		
		for(Domacin domacin:DomacinDAO.ucitajDomacine().values()) {
			pronadjeniDomacini.add(domacin);
		}
		
		return pronadjeniDomacini;
	}

	public static Collection<? extends Korisnik> pronadjiGoste() {
		ArrayList<Korisnik> pronadjeniGosti = new ArrayList<Korisnik>();
		
		for(Gost gost:GostDAO.ucitajGoste().values()) {
			pronadjeniGosti.add(gost);
		}
		
		return pronadjeniGosti;
	}	
	
}

