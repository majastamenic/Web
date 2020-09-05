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
import beans.Pol;
import beans.Uloga;

public class AdresaDAO {

private Map<String, Adresa> adrese = new HashMap<>();
	
	
	public AdresaDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public AdresaDAO(String contextPath) {
		ucitajAdrese(contextPath);
	}
	
	/**
	 * Vraæa korisnika za prosleðeno korisnièko ime i šifru. Vraæa null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public Adresa find(String UlicaBroj) {
		if (!adrese.containsKey(UlicaBroj)) {
			return null;
		}
		Adresa adresa = adrese.get(UlicaBroj);
		
		return adresa;
	}
	
	public Collection<Adresa> findAll() {
		return adrese.values();
	}
	
	/**
	 * Uèitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #users}.
	 * Kljuè je korisnièko ime korisnika.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	private void ucitajAdrese(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/adrese.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					
					
					String ulicaBroj = st.nextToken().trim();
					String naseljenoMesto = st.nextToken().trim();
					int postanskiBroj = Integer.parseInt( st.nextToken().trim());
					
					adrese.put(ulicaBroj, new Adresa(ulicaBroj, naseljenoMesto, postanskiBroj));
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
