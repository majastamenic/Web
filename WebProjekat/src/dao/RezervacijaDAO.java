package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import static util.Putanja._PROJECT_LOCATION;


import beans.Apartman;
import beans.Gost;

import beans.Rezervacija;
import beans.StatusRezervacija;


public class RezervacijaDAO {
private static Map<Integer, Rezervacija> rezervacija = new HashMap<>();
	
	
	public RezervacijaDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public RezervacijaDAO(String contextPath) {
		ucitajRezervacije();
	}
	
	
	public Rezervacija find(Integer id) {
		if (!rezervacija.containsKey(id)) {
			return null;
		}
		Rezervacija rez = rezervacija.get(id);
		
		return rez;
	}
	
	public Collection<Rezervacija> findAll() {
		return rezervacija.values();
	}
	
	
	public static Map<Integer, Rezervacija> ucitajRezervacije() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/rezervacije.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					int id= Integer.parseInt(st.nextToken().trim());
					int idApartman= Integer.parseInt(st.nextToken().trim());
					ApartmanDAO ad= new ApartmanDAO();
					Apartman apartman= ad.find(idApartman);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			        Date dateStr = formatter.parse(st.nextToken().trim());
					int brojNocenja = Integer.parseInt(st.nextToken().trim());
					float ukupnaCena= Float.parseFloat(st.nextToken().trim());
					String poruka = st.nextToken().trim();
					int idGost = Integer.parseInt(st.nextToken().trim());
					GostDAO gd= new GostDAO();
					Gost gost= gd.find(idGost);
					StatusRezervacija status= null;
					String statusStr= st.nextToken().trim();
					if(statusStr=="Kreirana")
						status=StatusRezervacija.Kreirana;
					else if(statusStr=="Odbijena")
						status=StatusRezervacija.Odbijena;
					else if(statusStr=="Odustanak")
						status=StatusRezervacija.Odustanak;
					else if(statusStr=="Prihvacena")
						status=StatusRezervacija.Prihvacena;
					else
						status=StatusRezervacija.Zavrsena;
			        
					
					rezervacija.put(id, new Rezervacija(id, apartman, dateStr, brojNocenja, ukupnaCena, poruka, gost, status));
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
		return rezervacija;
	}

}
