package dao;

import static util.Putanja._PROJECT_LOCATION;

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

import beans.Apartman;

import beans.Gost;
import beans.Pol;
import beans.Rezervacija;
import beans.Uloga;


public class GostDAO {
	private static Map<Integer, Gost> gosti = new HashMap<>();
	
	public GostDAO() {
		
	}
	
	public Gost find(Integer id) {
		if (!gosti.containsKey(id)) {
			return null;
		}
		Gost lok = gosti.get(id);
		
		return lok;
	}
	
	public Collection<Gost> findAll() {
		return gosti.values();
	}
	
	public static Map<Integer, Gost> ucitajGoste() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/gosti.txt");
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
					String korisnickoIme = st.nextToken().trim();
					String lozinka = st.nextToken().trim();
					String ime = st.nextToken().trim();
					String prezime = st.nextToken().trim();
					Pol pol = null;
					String polStr=st.nextToken().trim().toString();
					if(polStr.equalsIgnoreCase("muski"))
						pol=Pol.muski;
					else
						pol=Pol.zenski;
					Uloga uloga= null;
					String ulogaStr = st.nextToken().trim().toString();
					if(ulogaStr.equalsIgnoreCase("Administrator"))
						uloga=Uloga.Administrator;
					else if(ulogaStr.equalsIgnoreCase("Domacin"))
						uloga=Uloga.Domacin;
					else
						uloga=Uloga.Gost;
					
					StringTokenizer st1;
			        st1 = new StringTokenizer(st.nextToken().trim(), ",");
			        List<Apartman> iznajmljeni = new ArrayList<Apartman>();
						while (st1.hasMoreTokens()) {
							int idApartmana= Integer.parseInt(st1.nextToken().trim());
							ApartmanDAO apartmanDAO=new ApartmanDAO();
							Apartman apartman = apartmanDAO.find(idApartmana);
						
							iznajmljeni.add(apartman);
						}
						
						StringTokenizer st2;
				        st2 = new StringTokenizer(st.nextToken().trim(), ",");
				        List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
							while (st2.hasMoreTokens()) {
								int idRezervacije= Integer.parseInt(st2.nextToken().trim());
								RezervacijaDAO rezervacijaDAO=new RezervacijaDAO();
								Rezervacija rezervacija= rezervacijaDAO.find(idRezervacije);
							
								rezervacije.add(rezervacija);
							}		
					
					
			gosti.put(id, new Gost(id, korisnickoIme, lozinka, ime, prezime, pol, uloga, iznajmljeni, rezervacije));
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
		return gosti;
	}
	
	public static Gost findGuestById(Integer id) {
		
		Gost trazeniGost = null;
			if(gosti.size()==0) {
				ucitajGoste();
			}
			if(gosti.containsKey(id)) {
				trazeniGost=gosti.get(id);
				return trazeniGost;
			}
			else
				return null;
			
		}
	
	public static void dodajGosta(Gost gost) throws IOException {
		gosti= ucitajGoste();
		gosti.put(gost.getId(), gost);
		List<Gost> gostiLista= new ArrayList<Gost>(gosti.values());
		
		
		BufferedWriter out = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/gosti.txt");
			out = new BufferedWriter(new FileWriter(file));
			for(Gost noviGost: gostiLista) {
				out.write(noviGost.getKorisnickoIme() + ";"+ noviGost.getLozinka()+ ";"+ noviGost.getIme()
				+ ";"+ noviGost.getPrezime()+ ";"+ noviGost.getPol().toString()+ ";"+ noviGost.getUloga().toString()
				+ ";"+ noviGost.getIznajmljeniApartmani().toString()+";"+ noviGost.getRezervacije()+ "\n");
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
	      
	



	public static Boolean izbrisiGosta(Integer id) {
		gosti = ucitajGoste();
		Gost gost= new Gost();
		gost = findGuestById(id);
		if (!(gost == null)) {
			gosti.remove(id);
			List<Gost> gostiLista= new ArrayList<Gost>(gosti.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/gosti.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Gost noviGost: gostiLista) {
					out.write(noviGost.getKorisnickoIme() + ";"+ noviGost.getLozinka()+ ";"+ noviGost.getIme()
					+ ";"+ noviGost.getPrezime()+ ";"+ noviGost.getPol().toString()+ ";"+ noviGost.getUloga().toString()
					+ ";"+ noviGost.getIznajmljeniApartmani().toString()+";"+ noviGost.getRezervacije()+ "\n");
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
