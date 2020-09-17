package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import static util.Putanja._PROJECT_LOCATION;

import beans.Adresa;

import beans.Lokacija;


public class LokacijaDAO {
private static Map<Integer, Lokacija> lokacija = new HashMap<>();
	
	
	public LokacijaDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public LokacijaDAO(String contextPath) {
		ucitajLokaciju();
	}
	
	
	public Lokacija find(Integer id) {
		if (!lokacija.containsKey(id)) {
			return null;
		}
		Lokacija lok = lokacija.get(id);
		
		return lok;
	}
	
	public static Collection<Lokacija> findAll() {
		lokacija = ucitajLokaciju();
		return lokacija.values();
	}
	
	public static List<Lokacija> listaLokacija(){
		List<Lokacija> lokacije = new ArrayList<Lokacija>();
		for(Lokacija lokacija:ucitajLokaciju().values()) {
			lokacije.add(lokacija);
		}
		return lokacije;
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

	public static void dodajLokaciju(Lokacija lokacija) throws IOException {
		LokacijaDAO.lokacija= ucitajLokaciju();
		LokacijaDAO.lokacija.put(lokacija.getId(), lokacija);
		List<Lokacija> lokacijeLista= new ArrayList<Lokacija>(LokacijaDAO.lokacija.values());
		
		
		BufferedWriter out = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/lokacije.txt");
			out = new BufferedWriter(new FileWriter(file));
			for(Lokacija novaLokacija: lokacijeLista) {
				out.write(novaLokacija.getGeografskaSirina() + ";"+ novaLokacija.getGeografskaDuzina()+ ";"+ novaLokacija.getAdresa()+ "\n");
			}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
			finally {
		}
			if (out != null) {
				try {
					out.close();
				}
				catch (Exception e) { }
			}
	}
      




	public static Boolean izbrisiLokaciju(Integer id) {
		LokacijaDAO.lokacija = ucitajLokaciju();
		Lokacija lokacija= new Lokacija();
		lokacija = findLocationById(id);
		if (!(lokacija == null)) {
			LokacijaDAO.lokacija.remove(id);
			List<Lokacija> lokacijaLista= new ArrayList<Lokacija>(LokacijaDAO.lokacija.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/lokacije.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Lokacija novaLokacija: lokacijaLista) {
					out.write(novaLokacija.getGeografskaSirina() + ";"+ novaLokacija.getGeografskaDuzina()+ ";"+ novaLokacija.getAdresa()+ "\n");
				}
					
				
			}catch(Exception e){
				e.printStackTrace();
			}
				finally {
			}
				if (out != null) {
					try {
						out.close();
					}
					catch (Exception e) { }
				}
			return true;
		}else
			return false;
	}
	
	
	public static Boolean izmeniLokaciju(Lokacija izmenjenaLokacija) {
		LokacijaDAO.lokacija = ucitajLokaciju();
		Lokacija lokacija= new Lokacija();
		lokacija = findLocationById(izmenjenaLokacija.getId());
		if (!(lokacija == null)) {
			
			lokacija.setGeografskaSirina(izmenjenaLokacija.getGeografskaSirina());
			lokacija.setGeografskaDuzina(izmenjenaLokacija.getGeografskaDuzina());
			lokacija.setAdresa(izmenjenaLokacija.getAdresa());
			
			List<Lokacija> lokacijaLista= new ArrayList<Lokacija>(LokacijaDAO.lokacija.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/lokacije.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Lokacija novaLokacija: lokacijaLista) {
					out.write(novaLokacija.getGeografskaSirina() + ";"+ novaLokacija.getGeografskaDuzina()+ ";"
							+ novaLokacija.getAdresa()+ "\n");
				}
					
				
			}catch(Exception e){
				e.printStackTrace();
			}
				finally {
			}
				if (out != null) {
					try {
						out.close();
					}
					catch (Exception e) { }
				}
			return true;
		}else
			return false;
	}
	
	public static List<Lokacija> lokacijeSaAdresama(List<Lokacija> lokacije){
		
		for(Lokacija lokacija:lokacije) {
			for(Adresa adresa:AdresaDAO.ucitajAdrese().values()) {
				if(lokacija.getAdresa().getId() == adresa.getId()) {
					lokacija.setAdresa(adresa);
				}
			}
		}
		
		return lokacije;
	}

}
