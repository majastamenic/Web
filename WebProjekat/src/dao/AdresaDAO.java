package dao;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import beans.Adresa;
import static util.Putanja._PROJECT_LOCATION;

public class AdresaDAO {

private static Map<Integer, Adresa> adrese = new HashMap<>();
	
	
	public AdresaDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public AdresaDAO(String contextPath) {
		ucitajAdrese();
	}
	
	/**
	 * Vraæa korisnika za prosleðeno korisnièko ime i šifru. Vraæa null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public Adresa find(Integer id) {
		if (!adrese.containsKey(id)) {
			return null;
		}
		Adresa adresa = adrese.get(id);
		
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
	public static Map<Integer,Adresa> ucitajAdrese() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/adrese.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					
					Integer id= Integer.parseInt(st.nextToken().trim());
					String ulicaBroj = st.nextToken().trim();
					String naseljenoMesto = st.nextToken().trim();
					int postanskiBroj = Integer.parseInt( st.nextToken().trim());
					
					adrese.put(id, new Adresa(id, ulicaBroj, naseljenoMesto, postanskiBroj));
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
		return adrese;
	}
}
