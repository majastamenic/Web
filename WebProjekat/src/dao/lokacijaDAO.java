package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import static util.Putanja._PROJECT_LOCATION;

import beans.Adresa;

import beans.Lokacija;


public class lokacijaDAO {
private static Map<Integer, Lokacija> lokacija = new HashMap<>();
	
	
	public lokacijaDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public lokacijaDAO(String contextPath) {
		ucitajLokaciju();
	}
	
	
	public Lokacija find(Integer id) {
		if (!lokacija.containsKey(id)) {
			return null;
		}
		Lokacija lok = lokacija.get(id);
		
		return lok;
	}
	
	public Collection<Lokacija> findAll() {
		return lokacija.values();
	}
	
	
public static Map<Integer, Lokacija> ucitajLokaciju() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/lokacije.txt");
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
					float geografskaSirina = Float.parseFloat(st.nextToken().trim());
					float geografskaDuzina = Float.parseFloat(st.nextToken().trim());
					int idAdresa = Integer.parseInt(st.nextToken().trim());
					AdresaDAO ad= new AdresaDAO();
					Adresa adresa = ad.find(idAdresa);
					
			lokacija.put(id, new Lokacija(id, geografskaSirina, geografskaDuzina, adresa));
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
		return lokacija;
	}

public static Lokacija findLocationById(Integer id) {
	
	Lokacija trazenaLokacija = null;
		if(lokacija.size()==0) {
			ucitajLokaciju();
		}
		if(lokacija.containsKey(id)) {
			trazenaLokacija=lokacija.get(id);
			return trazenaLokacija;
		}
		else
			return null;
		
	}
}
