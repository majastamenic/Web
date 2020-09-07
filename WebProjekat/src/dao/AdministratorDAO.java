package dao;

import static util.Putanja._PROJECT_LOCATION;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;
import java.util.StringTokenizer;

import beans.Administrator;

import beans.Pol;

import beans.Uloga;

public class AdministratorDAO {
	
private static Map<Integer, Administrator> administratori = new HashMap<>();
	
	public AdministratorDAO() {
		
	}
	
	public Administrator find(Integer id) {
		if (!administratori.containsKey(id)) {
			return null;
		}
		Administrator admin = administratori.get(id);
		
		return admin;
	}
	
	public Collection<Administrator> findAll() {
		return administratori.values();
	}
	
	public static Map<Integer, Administrator> ucitajAdmine() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/admini.txt");
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
					if(ulogaStr=="Administrator")
						uloga=Uloga.Administrator;
					else if(ulogaStr=="Domacin")
						uloga=Uloga.Domacin;
					else
						uloga=Uloga.Gost;
					
					
					
					
			administratori.put(id, new Administrator(id, korisnickoIme, lozinka, ime, prezime, pol, uloga));
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
		return administratori;
	}
	
	public static Administrator findAdminById(Integer id) {
		
		Administrator trazeniAdmin = null;
			if(administratori.size()==0) {
				ucitajAdmine();
			}
			if(administratori.containsKey(id)) {
				trazeniAdmin=administratori.get(id);
				return trazeniAdmin;
			}
			else
				return null;
			
		}



}
