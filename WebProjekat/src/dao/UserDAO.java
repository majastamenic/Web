package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import beans.Administrator;
import beans.Domacin;
import beans.Gost;
import beans.Korisnik;


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

	
	public static Korisnik findUserByUsername(String korisnickoIme) {
		if (!users.containsKey(korisnickoIme)) {
			return null;
		}
		Korisnik user = users.get(korisnickoIme);
		
		return user;
	}
	
	
}

