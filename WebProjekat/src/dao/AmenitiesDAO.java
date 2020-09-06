package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import beans.Amenities;


public class AmenitiesDAO {

private Map<Integer, Amenities> pogodnosti = new HashMap<>();
	
	
	public AmenitiesDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public AmenitiesDAO(String contextPath) {
		ucitajPogodnosti(contextPath);
	}
	
	/**
	 * Vraæa korisnika za prosleðeno korisnièko ime i šifru. Vraæa null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public Amenities find(Integer id) {
		if (!pogodnosti.containsKey(id)) {
			return null;
		}
		Amenities komm = pogodnosti.get(id);
		
		return komm;
	}
	
	public Collection<Amenities> findAll() {
		return pogodnosti.values();
	}
	
	/**
	 * Uèitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #users}.
	 * Kljuè je korisnièko ime korisnika.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	private void ucitajPogodnosti(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/pogodnosti.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					
					
					int id=Integer.parseInt(st.nextToken().trim());
					String naziv = st.nextToken().trim();
	
					
					pogodnosti.put(id, new Amenities(id, naziv));
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
