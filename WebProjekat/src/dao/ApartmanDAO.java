package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import static util.Putanja._PROJECT_LOCATION;



import beans.Amenities;
import beans.Apartman;
import beans.Domacin;
import beans.KomentarZaApartman;

import beans.Lokacija;
import beans.Rezervacija;
import beans.StatusApartman;
import beans.TipApartmana;



public class ApartmanDAO {
	private static Map<Integer, Apartman> apartmani = new HashMap<>();
	public ApartmanDAO() {
		
	}
	public ApartmanDAO(String contextPath) {
		ucitajApartmane();
	}
	
	
	public Apartman find(Integer id) {
		if (!apartmani.containsKey(id)) {
			return null;
		}else {
		Apartman rez = apartmani.get(id);
		
		return rez;
		}
	}
	
	public Collection<Apartman> findAll() {
		return apartmani.values();
	}
	
	public static Map<Integer, Apartman> ucitajApartmane() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/apartmani.txt");
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
					TipApartmana tip= null;
					String tipString=st.nextToken().trim().toString();
					if(tipString.equalsIgnoreCase("Apartman"))
						tip=TipApartmana.Apartman;
					else
						tip=TipApartmana.Soba;
					int brojSoba= Integer.parseInt(st.nextToken().trim());
					
					
					int brojGostiju= Integer.parseInt(st.nextToken().trim());
					int idLokacija = Integer.parseInt(st.nextToken().trim());
					lokacijaDAO ld=new lokacijaDAO();
					Lokacija lokacija= ld.findLocationById(idLokacija);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			        Date dateStr = formatter.parse(st.nextToken().trim());
			        
			        StringTokenizer st1;
			        st1 = new StringTokenizer(st.nextToken().trim(), ",");
			        List<Date> dostupni = new ArrayList<Date>();
						while (st1.hasMoreTokens()) {
						Date dostupniDatumi = formatter.parse(st1.nextToken().trim());
						dostupni.add(dostupniDatumi);
						}
						
					int idDomacin = Integer.parseInt(st.nextToken().trim());
					DomacinDAO dd= new DomacinDAO();
					Domacin domacin = dd.findHostById(idDomacin);
					
					int idKomentar= Integer.parseInt(st.nextToken().trim());
					KomentarDAO kd= new KomentarDAO();
					KomentarZaApartman komentar = kd.find(idKomentar);
					
					float cenaPoNoci= Float.parseFloat(st.nextToken().trim());
					String vremeZaPrijavu= st.nextToken().trim();
					String vremeZaOdjavu = st.nextToken().trim();
					
					StatusApartman status= null;
					String statusStr = st.nextToken().trim().toString();
					if(statusStr .equalsIgnoreCase("Aktivno"))
						status=StatusApartman.Aktivno;
					else
						status=StatusApartman.Neaktivno;
			        
					StringTokenizer st2;
			        st2 = new StringTokenizer(st.nextToken().trim(), ".");
			        List<Amenities> pogodnosti = new ArrayList<Amenities>();
			        	while (st2.hasMoreTokens()) {
							int idPogodnost=Integer.parseInt(st2.nextToken().trim());
							AmenitiesDAO ad= new AmenitiesDAO();
							Amenities pogodnost= ad.find(idPogodnost);
							pogodnosti.add(pogodnost);
						}
			        	
			        StringTokenizer st3= new StringTokenizer(st.nextToken().trim(), "/");
			        List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
				        while (st3.hasMoreTokens()) {
							int idRezervacija=Integer.parseInt(st3.nextToken().trim());
							RezervacijaDAO rd= new RezervacijaDAO();
							Rezervacija rezervacija= rd.find(idRezervacija);
							rezervacije.add(rezervacija);
						}
				        	
				     
					
					apartmani.put(id, new Apartman(id, tip, brojSoba, brojGostiju, lokacija, dateStr, dostupni, domacin, komentar, cenaPoNoci, vremeZaPrijavu, vremeZaOdjavu, status, pogodnosti, rezervacije));
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
		return apartmani;
	}
	
	public static Apartman findApartmentById(Integer id) {
		Apartman trazeniApartman = null;
		
		if(apartmani.size() == 0) {
			ucitajApartmane();
		}
		if(apartmani.containsKey(id)) {
			trazeniApartman= apartmani.get(id);
			return trazeniApartman;
		}
		else
			return null;
	}

}
