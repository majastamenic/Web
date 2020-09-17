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

import beans.Domacin;
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
	
	public static Collection<Gost> findAll() {
		return gosti.values();
	}
	
	public static Map<Integer, Gost> ucitajGoste() {
		BufferedReader in = null;
		RezervacijaDAO.ucitajRezervacije();
		
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
						pol=Pol.Muski;
					else
						pol=Pol.Zenski;
					Uloga uloga= null;
					String ulogaStr = st.nextToken().trim().toString();
					if(ulogaStr.equalsIgnoreCase("Administrator"))
						uloga=Uloga.Administrator;
					else if(ulogaStr.equalsIgnoreCase("Domacin"))
						uloga=Uloga.Domacin;
					else
						uloga=Uloga.Gost;
					// Ovde pocinje citanje drugog fajla
					Gost noviGost = new Gost(id, korisnickoIme, lozinka, ime, prezime, pol, uloga);
					
					for (Map.Entry<Integer, Rezervacija> rezervacija : RezervacijaDAO.getRezervacije().entrySet()) {		
						if(rezervacija.getValue().getGost().getId() == noviGost.getId()) {
							noviGost.getIznajmljeniApartmani().add(rezervacija.getValue().getRezervisanApartman());
							rezervacija.getValue().setGost(noviGost);
						}
					}
					
//			        st1 = new StringTokenizer(st.nextToken().trim(), ",");
//			        List<Apartman> iznajmljeni = new ArrayList<Apartman>();
//						while (st1.hasMoreTokens()) {
//							int idApartmana= Integer.parseInt(st1.nextToken().trim());
//							ApartmanDAO apartmanDAO=new ApartmanDAO();
//							Apartman apartman = apartmanDAO.find(idApartmana);
//						
//							iznajmljeni.add(apartman);
//						}
//						
					
					for (Map.Entry<Integer, Rezervacija> rezervacija : RezervacijaDAO.getRezervacije().entrySet()) {		
						if(rezervacija.getValue().getGost().getId() == noviGost.getId()) {
							noviGost.getRezervacije().add(rezervacija.getValue());
							rezervacija.getValue().setGost(noviGost);
						}
					}
					
					
			gosti.put(noviGost.getId() , noviGost );
				}
				
			
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
				try {
					in.close();
				}
				catch (Exception e) { }
		}
		return gosti;
	}
	
	public static Gost findGuestById(Integer id) {
		gosti = ucitajGoste();
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
	
	public static int vratiNajveciID() {
		int maxId = 0;
		for (Map.Entry<Integer , Gost> gost : gosti.entrySet())
		{
		    if ( maxId < gost.getKey().intValue())
		    {
		        maxId = gost.getKey();
		    }
		}
		return maxId;
	}
	
	public static void dodajGostaUMapu(Gost noviGost) {
		if(gosti.isEmpty())
			gosti = ucitajGoste();
			
			noviGost.setId(vratiNajveciID() + 1);
			gosti.put(vratiNajveciID() + 1, noviGost);
		
	}
	public static void sacuvajSveGosteIzMape() throws IOException {
		
		
		BufferedWriter out = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/gosti.txt");
			out = new BufferedWriter(new FileWriter(file));
			 for (Map.Entry<Integer, Gost> gost : gosti.entrySet())  {
				out.write(gost.getValue().ispisTXT());
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
		Map<Integer, Gost> gosti1 = ucitajGoste();
		if(gosti1.containsKey(id)) {
		gosti1.remove(id);
		try {
			sacuvajSveGosteIzMape();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		}else
			return false;
		
	}
	
	
	public static Boolean izmeniGosta(Gost izmenjenGost) {
		gosti = ucitajGoste();
		Gost gost= new Gost();
		gost = findGuestById(izmenjenGost.getId());
		if (!(gost == null)) {
			
			gost.setKorisnickoIme(izmenjenGost.getKorisnickoIme());
			gost.setLozinka(izmenjenGost.getLozinka());
			gost.setIme(izmenjenGost.getIme());
			gost.setPrezime(izmenjenGost.getPrezime());
			gost.setPol(izmenjenGost.getPol().toString()); // izmenjenj je seter za POl.
			gost.setUloga(izmenjenGost.getUloga());
			gost.setRezervacije(izmenjenGost.getRezervacije());
			gost.setIznajmljeniApartmani(izmenjenGost.getIznajmljeniApartmani());
			
			List<Gost> gostiLista= new ArrayList<Gost>(gosti.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/gosti.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Gost noviGost: gostiLista) {
					out.write(noviGost.getId()+ ";" + noviGost.getKorisnickoIme() + ";"+ noviGost.getLozinka()+ ";"+ noviGost.getIme()
					+ ";"+ noviGost.getPrezime()+ ";"+ noviGost.getPol().toString()+ ";"+ noviGost.getUloga().toString()
					 +"\n");
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
	
	public static ArrayList<Gost> ucitajGosteZaDomacina(Domacin domacin) {
		ArrayList<Gost> gosti1 = new ArrayList<Gost>();
		gosti = ucitajGoste();		
		for(Gost gost:gosti.values()) {
			for(Rezervacija rez:RezervacijaDAO.ucitajRezervacijeZaDomacina(domacin)) {
				if(gost.equals(rez.getGost())) {
					gosti1.add(gost);
				}
			}
		}
		return gosti1;
	}
	
public static Gost findGuestByUsername(String username) {
		
			if(gosti.size()==0) {
				ucitajGoste();
			}
			List<Gost> gostiLista= new ArrayList<Gost>(gosti.values());
			for(Gost noviGost: gostiLista) {
				if(noviGost.getKorisnickoIme().equals(username)) {
					return noviGost;
				}
			}
			return null;	
			
		}

	public static Gost pretragaPoId(int id) {
		gosti = ucitajGoste();
		Gost pronadjeniGost = new Gost();
		
		for(Gost gost:gosti.values()) {
			if(gost.getId() == id)
				pronadjeniGost = gost;
		}
		
		return pronadjeniGost;
	}
	
	public static Gost pretragaPoKorisnickomImenu(String korisnickoIme) {
		gosti = ucitajGoste();
		Gost pronadjeniGost = new Gost();
		
		for(Gost gost:gosti.values()) {
			if(gost.getKorisnickoIme().equals(korisnickoIme))
				pronadjeniGost = gost;
		}
		
		return pronadjeniGost;
	}

}
