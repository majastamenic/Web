package dao;

import static util.Putanja._PROJECT_LOCATION;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


import beans.Apartman;
import beans.Domacin;

import beans.Pol;
import beans.Uloga;



public class DomacinDAO {
private static Map<Integer, Domacin> domacini = new HashMap<>();
	
	
	public DomacinDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Može se pristupiti samo iz servleta.
	 */
	public DomacinDAO(String contextPath) {
		ucitajDomacine();
	}
	
	/**
	 * Vraæa korisnika za prosleðeno korisnièko ime i šifru. Vraæa null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public Domacin find(Integer id) {
		if (!domacini.containsKey(id)) {
			return null;
		}
		Domacin komm = domacini.get(id);
		
		return komm;
	}
	
	public Collection<Domacin> findAll() {
		return domacini.values();
	}
	public static Map<Integer, Domacin> ucitajDomacine() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/domacini.txt");
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
					if(polStr=="muski")
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
			        List<Apartman> dostupni = new ArrayList<Apartman>();
						while (st1.hasMoreTokens()) {
							int idApartmana= Integer.parseInt(st1.nextToken().trim());
							ApartmanDAO apartmanDAO=new ApartmanDAO();
							Apartman apartman = apartmanDAO.find(idApartmana);
						
						dostupni.add(apartman);
						}
					
					
			domacini.put(id, new Domacin(id, korisnickoIme, lozinka, ime, prezime, pol, uloga, dostupni));
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
		return domacini;
	}
	
	public static Domacin findHostById(Integer id) {
		
		Domacin trazeniDomacin = null;
			if(domacini.size()==0) {
				ucitajDomacine();
			}
			if(domacini.containsKey(id)) {
				trazeniDomacin=domacini.get(id);
				return trazeniDomacin;
			}
			else
				return null;
			
		}

		
	}
	


