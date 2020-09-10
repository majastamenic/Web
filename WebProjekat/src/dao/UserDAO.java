package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import beans.Korisnik;
import beans.Pol;
import beans.Uloga;
import static util.Putanja._PROJECT_LOCATION;

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
	public static Map<String,Korisnik> loadUsers() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/users.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					
					
					String korisnickoIme = st.nextToken().trim();
					String lozinka = st.nextToken().trim();
					String ime = st.nextToken().trim();
					String prezime = st.nextToken().trim();
					Pol pol = null;
					String polStr=st.nextToken().trim().toString();
					if(polStr.equalsIgnoreCase("muski"))
						pol=Pol.valueOf("muski");
					else
						pol=Pol.valueOf("zenski");
					Uloga uloga= null;
					String ulogaStr = st.nextToken().trim().toString();
					if(ulogaStr.equalsIgnoreCase("Administrator"))
						uloga=Uloga.Administrator;
					else if(ulogaStr.equalsIgnoreCase("Domacin"))
						uloga=Uloga.Domacin;
					else
						uloga=Uloga.Gost;
					
					users.put(korisnickoIme, new Korisnik(korisnickoIme, lozinka, ime, prezime, pol,uloga));
				}
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (Exception e) { }
			}
		}
		return users;
	}
	
	public static Korisnik findUserByCredentials(String korisnickoIme, String lozinka) {
		Korisnik trazeniKorisnik = null;
		
		if(users.size() == 0) {
			loadUsers();
		}
		if(users.containsKey(korisnickoIme))
			trazeniKorisnik= users.get(korisnickoIme);
		
		if(trazeniKorisnik.getLozinka().equals(lozinka) && trazeniKorisnik!=null)
			return trazeniKorisnik;
		else
			return null;
	}
	
	public static Korisnik findUserByUsername(String korisnickoIme) {
		if (!users.containsKey(korisnickoIme)) {
			return null;
		}
		Korisnik user = users.get(korisnickoIme);
		
		return user;
	}
	
	public static void addUser(String korisnickoIme, String lozinka, String ime, String prezime,Pol pol,Uloga uloga) {
		if(!users.containsKey(korisnickoIme)) {
			return;
		}
		else {
			users.put(korisnickoIme, new Korisnik(korisnickoIme, lozinka, ime, prezime, pol, uloga));
		}
	}
	
}
