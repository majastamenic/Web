package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import static util.Putanja._PROJECT_LOCATION;


import beans.Apartman;
import beans.Gost;
import beans.KomentarZaApartman;


public class KomentarDAO {
private static Map<Integer, KomentarZaApartman> komentari = new HashMap<>();
	
	
	public KomentarDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public KomentarDAO(String contextPath) {
		ucitajKomentare();
	}
	
	/**
	 * Vraæa korisnika za prosleðeno korisnièko ime i šifru. Vraæa null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public KomentarZaApartman find(Integer id) {
		if (!komentari.containsKey(id)) {
			return null;
		}
		KomentarZaApartman komm = komentari.get(id);
		
		return komm;
	}
	
	public Collection<KomentarZaApartman> findAll() {
		return komentari.values();
	}
	
	/**
	 * Uèitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #users}.
	 * Kljuè je korisnièko ime korisnika.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	public static Map<Integer, KomentarZaApartman> ucitajKomentare() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/komentari.txt");
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
					int idGosta=Integer.parseInt(st.nextToken().trim());
					
					Gost gost= GostDAO.findGuestById(idGosta);
					int idApartmana=Integer.parseInt(st.nextToken().trim());
					ApartmanDAO ad=new ApartmanDAO();
					Apartman apartman= ad.findApartmentById(idApartmana);
					String tekst =st.nextToken().trim();
					int ocena= Integer.parseInt(st.nextToken().trim());
	
					
					komentari.put(id, new KomentarZaApartman(id, gost, apartman, tekst, ocena));
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
		return komentari;
	}
	
	public static KomentarZaApartman findCommentById(Integer id) {
		
		KomentarZaApartman trazeniKomentar = null;
			if(komentari.size()==0) {
				ucitajKomentare();
			}
			if(komentari.containsKey(id)) {
				trazeniKomentar=komentari.get(id);
				return trazeniKomentar;
			}
			else
				return null;
			
		}
	

}
