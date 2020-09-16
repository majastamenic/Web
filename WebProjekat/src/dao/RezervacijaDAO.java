package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	public static Map<Integer, Rezervacija> getRezervacije() {
		return rezervacija;
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
	
	public static Collection<Rezervacija> findAll() {
		return rezervacija.values();
	}
	
	
	public static Map<Integer, Rezervacija> ucitajRezervacije() {
		ApartmanDAO.ucitajApartmane();
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
//					ApartmanDAO ad= new ApartmanDAO();
					Apartman apartman= ApartmanDAO.findApartmentById(idApartman);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			        Date dateStr = formatter.parse(st.nextToken().trim());
					int brojNocenja = Integer.parseInt(st.nextToken().trim());
					float ukupnaCena= Float.parseFloat(st.nextToken().trim());
					String poruka = st.nextToken().trim();
					int idGost = Integer.parseInt(st.nextToken().trim());
//					Ne cemo ovo jer cemo prvo goste da upisemo, mi cemo zacuvari ID gosta za dalju pretragu
//					GostDAO gd= new GostDAO();
//					Gost gost= gd.find(idGost);
					
					Gost gost = new Gost();
					gost.setId(idGost);
					
					StatusRezervacija status= null;
					String statusStr= st.nextToken().trim();
					if(statusStr.equalsIgnoreCase("Kreirana"))
						status=StatusRezervacija.Kreirana;
					else if(statusStr.equalsIgnoreCase("Odbijena"))
						status=StatusRezervacija.Odbijena;
					else if(statusStr.equalsIgnoreCase("Odustanak"))
						status=StatusRezervacija.Odustanak;
					else if(statusStr.equalsIgnoreCase("Prihvacena"))
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
	
	public static Rezervacija findReservationById(Integer id) {
		
		Rezervacija trazenaRezervacija = null;
			if(rezervacija.size()==0) {
				ucitajRezervacije();
			}
			if(rezervacija.containsKey(id)) {
				trazenaRezervacija=rezervacija.get(id);
				return trazenaRezervacija;
			}
			else
				return null;
			
		}
	
	public static List<Rezervacija> sortiranjePoCeniOpadajuce(){
		Float a;
		Float b;
		Rezervacija c;
		Rezervacija d;
		rezervacija = ucitajRezervacije();
		List<Rezervacija> nesortiraneRezervacije = new ArrayList<Rezervacija>(rezervacija.values());
		for(int i = 0; i<nesortiraneRezervacije.size() ; i++) {
			for(int j = 0 ; j < nesortiraneRezervacije.size()-i-1 ; j++) {
				a=nesortiraneRezervacije.get(j).getUkupnaCena();
				b=nesortiraneRezervacije.get(j+1).getUkupnaCena();
				c=nesortiraneRezervacije.get(j);
				d=nesortiraneRezervacije.get(j+1);
				
				if(a.compareTo(b)<0) {
					Rezervacija temp=d;
					nesortiraneRezervacije.set(j+1, c);
					nesortiraneRezervacije.set(j, temp);
				}
			}
		}
		
		return nesortiraneRezervacije;
	}
	public static List<Rezervacija> sortiranjePoCeniRastuce(){
		Float a;
		Float b;
		Rezervacija c;
		Rezervacija d;
		rezervacija = ucitajRezervacije();
		List<Rezervacija> nesortiraneRezervacije = new ArrayList<Rezervacija>(rezervacija.values());
		for(int i = 0; i<nesortiraneRezervacije.size() ; i++) {
			for(int j = 0 ; j < nesortiraneRezervacije.size()-i-1 ; j++) {
				a=nesortiraneRezervacije.get(j).getUkupnaCena();
				b=nesortiraneRezervacije.get(j+1).getUkupnaCena();
				c=nesortiraneRezervacije.get(j);
				d=nesortiraneRezervacije.get(j+1);
				
				if(a.compareTo(b)>0) {
					Rezervacija temp=d;
					nesortiraneRezervacije.set(j+1, c);
					nesortiraneRezervacije.set(j, temp);
				}
			}
		}
		
		return nesortiraneRezervacije;
	}
	
	public static int vratiNajveciID() {
		int maxId = 0;
		for (Map.Entry<Integer , Rezervacija> rezervacije : rezervacija.entrySet())
		{
		    if ( maxId < rezervacije.getKey().intValue())
		    {
		        maxId = rezervacije.getKey();
		    }
		}
		return maxId;
	}
	
	public static void dodajRezervacijuUMapu(Rezervacija novaRezervacija) {
		if(rezervacija.isEmpty())
			rezervacija = ucitajRezervacije();
			
			novaRezervacija.setId(vratiNajveciID() + 1);
			rezervacija.put(vratiNajveciID() + 1, novaRezervacija);
		
	}
	public static void sacuvajSveRezervacijeIzMape() throws IOException {
		
		
		BufferedWriter out = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/rezervacije.txt");
			out = new BufferedWriter(new FileWriter(file));
			 for (Map.Entry<Integer, Rezervacija> rez : rezervacija.entrySet())  {
				out.write(rez.getValue().ispisTXT());
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



	public static Boolean izbrisiRezervaciju(Integer id) {
		rezervacija = ucitajRezervacije();
		Rezervacija rezervacija= new Rezervacija();
		rezervacija = findReservationById(id);
		if (!(rezervacija == null)) {
			RezervacijaDAO.rezervacija.remove(id);
			List<Rezervacija> listaRezervacija= new ArrayList<Rezervacija>(RezervacijaDAO.rezervacija.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/rezervacije.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Rezervacija novaRezervacija: listaRezervacija) {
					out.write(novaRezervacija.getRezervisanApartman().toString() + ";"+ novaRezervacija.getPocetniDatum().toString()+ ";"
							+ novaRezervacija.getBrojNocenja()+ ";"+ novaRezervacija.getUkupnaCena()+ ";"+ novaRezervacija.getPoruka()
							+ ";"+ novaRezervacija.getGost().toString() + ";"+ novaRezervacija.getStatus().toString() + "\n");
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
	
	
	public static Boolean izmeniRezervaciju(Rezervacija izmenjenaRezervacija) {
		rezervacija = ucitajRezervacije();
		Rezervacija rezervacija= new Rezervacija();
		rezervacija = findReservationById(izmenjenaRezervacija.getId());
		if (!(rezervacija == null)) {
			
			rezervacija.setRezervisanApartman(izmenjenaRezervacija.getRezervisanApartman());
			rezervacija.setPocetniDatum(izmenjenaRezervacija.getPocetniDatum());
			rezervacija.setBrojNocenja(izmenjenaRezervacija.getBrojNocenja());
			rezervacija.setUkupnaCena(izmenjenaRezervacija.getUkupnaCena());
			rezervacija.setPoruka(izmenjenaRezervacija.getPoruka());
			rezervacija.setGost(izmenjenaRezervacija.getGost());
			rezervacija.setStatus(izmenjenaRezervacija.getStatus());
			
			List<Rezervacija> listaRezervacija= new ArrayList<Rezervacija>(RezervacijaDAO.rezervacija.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/rezervacije.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Rezervacija novaRezervacija: listaRezervacija) {
					out.write(novaRezervacija.getRezervisanApartman().toString() + ";"+ novaRezervacija.getPocetniDatum().toString()+ ";"
							+ novaRezervacija.getBrojNocenja()+ ";"+ novaRezervacija.getUkupnaCena()+ ";"+ novaRezervacija.getPoruka()
							+ ";"+ novaRezervacija.getGost().toString() + ";"+ novaRezervacija.getStatus().toString() + "\n");
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
	
	public static Map<Integer, Rezervacija> odbijenaIzavrsenaRezervacija(){
		rezervacija = ucitajRezervacije();
		Map<Integer, Rezervacija> odbijeneIzavrseneRezervacije = new HashMap<Integer, Rezervacija>();
		
		for(Rezervacija rezervacija: odbijeneIzavrseneRezervacije.values()) {
			if(rezervacija.getStatus().equals(StatusRezervacija.Odbijena)||rezervacija.getStatus().equals(StatusRezervacija.Zavrsena)) {
				odbijeneIzavrseneRezervacije.put(rezervacija.getId(), rezervacija);
			}
		}
		
		return odbijeneIzavrseneRezervacije;
	}
	
	public static List<Rezervacija> pretragaPoKorisnickomImenu(String korisnickoIme){
		ArrayList<Rezervacija> rezervacijeLista = new ArrayList<Rezervacija>();
		rezervacija = ucitajRezervacije();
		
		for(Rezervacija rez:rezervacija.values()) {
			if(rez.getGost().getKorisnickoIme().contains(korisnickoIme)) {
				rezervacijeLista.add(rez);
			}
		}
		return rezervacijeLista;
	}

}
