package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import beans.Adresa;
import beans.Korisnik;
import beans.Lokacija;
import beans.Pol;
import beans.Uloga;

public class lokacijaDAO {
private Map<Adresa, Lokacija> lokacija = new HashMap<>();
	
	
	public lokacijaDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public lokacijaDAO(String contextPath) {
		ucitajLokaciju(contextPath);
	}
	
	
	public Lokacija find(Adresa adresa) {
		if (!lokacija.containsKey(adresa)) {
			return null;
		}
		Lokacija lok = lokacija.get(adresa);
		
		return lok;
	}
	
	public Collection<Lokacija> findAll() {
		return lokacija.values();
	}
	
	
	private void ucitajLokaciju(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/lokacije.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					
					
		//			Adresa adresa = (Adresa) st.nextToken().trim();
					String lozinka = st.nextToken().trim();
					String ime = st.nextToken().trim();
					String prezime = st.nextToken().trim();
					Pol pol = null;
					if(st.nextToken().trim().toString()=="muski")
						pol=Pol.muski;
					else
						pol=Pol.zenski;
					Uloga uloga= null;
					if(st.nextToken().trim().toString()=="Administrator")
						uloga=Uloga.Administrator;
					else if(st.nextToken().trim().toString()=="Domacin")
						uloga=Uloga.Domacin;
					else
						uloga=Uloga.Gost;
					
					//users.put(korisnickoIme, new Korisnik(korisnickoIme, lozinka, ime, prezime, pol,uloga));
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
	}

}
