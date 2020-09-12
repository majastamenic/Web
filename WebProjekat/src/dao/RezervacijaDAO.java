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
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Mo�e se pristupiti samo iz servleta.
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
	
	public static void dodajRezervaciju(Rezervacija rezervacija) throws IOException {
		RezervacijaDAO.rezervacija= ucitajRezervacije();
		RezervacijaDAO.rezervacija.put(rezervacija.getId(), rezervacija);
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

}
