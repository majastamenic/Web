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
	
	public static Collection<Adresa> findAll() {
		adrese = ucitajAdrese();
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
					
					int id= Integer.parseInt(st.nextToken().trim());
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
	
	public static Adresa findAdressById(Integer id) {
		
		Adresa trazenaAdresa = null;
		if(adrese.size()==0) {
			ucitajAdrese();
		}
		if(adrese.containsKey(id)) {
			trazenaAdresa=adrese.get(id);
			return trazenaAdresa;
		}
		else
			return null;
		
	}
	
	public static void dodajAdresu(Adresa adresa) throws IOException {
		adrese= ucitajAdrese();
		adrese.put(adresa.getId(), adresa);
		List<Adresa> adresaLista= new ArrayList<Adresa>(adrese.values());
		
		
		BufferedWriter out = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/adrese.txt");
			out = new BufferedWriter(new FileWriter(file));
			for(Adresa novaAdresa: adresaLista) {
				out.write(novaAdresa.getUlicaBroj() + ";"+ novaAdresa.getNaseljenoMesto()+ ";"+ adresa.getPostanskiBroj()+"\n");
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
	      
	



	public static Boolean izbrisiAdresu(Integer id) {
		adrese = ucitajAdrese();
		Adresa adresa= new Adresa();
		adresa = findAdressById(id);
		if (!(adresa == null)) {
			adrese.remove(id);
			List<Adresa> adresaLista= new ArrayList<Adresa>(adrese.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/adrese.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Adresa adresa1: adresaLista) {
					out.write(adresa1.getUlicaBroj() + ";"+ adresa1.getNaseljenoMesto() + ";"+ adresa1.getPostanskiBroj()+ "\n");
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
	
	public static Boolean izmeniAdresu(Adresa izmenjenaAdresa) {
		adrese = ucitajAdrese();
		Adresa adresa= new Adresa();
		adresa = findAdressById(izmenjenaAdresa.getId());
		if (!(adresa == null)) {
			adresa.setNaseljenoMesto(izmenjenaAdresa.getNaseljenoMesto());
			adresa.setPostanskiBroj(izmenjenaAdresa.getPostanskiBroj());
			adresa.setUlicaBroj(izmenjenaAdresa.getUlicaBroj());

			List<Adresa> adresaLista= new ArrayList<Adresa>(adrese.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/adrese.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Adresa adresa1: adresaLista) {
					out.write(adresa1.getUlicaBroj() + ";"+ adresa1.getNaseljenoMesto() + ";"+ adresa1.getPostanskiBroj()+ "\n");
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
}
