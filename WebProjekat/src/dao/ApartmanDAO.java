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

import beans.Amenities;
import beans.Apartman;
import beans.Domacin;
import beans.Gost;
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
	public static Map<Integer, Apartman> getApartmani() {
		return apartmani;
	}
	
	
	public static Apartman find(Integer id) {
		if (!apartmani.containsKey(id)) {
			return null;
		}else {
		Apartman rez = apartmani.get(id);
		
		return rez;
		}
	}
	
	public static Collection<Apartman> findAll() {
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
					
					Lokacija lokacija= LokacijaDAO.findLocationById(idLokacija);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			        Date dateStr = formatter.parse(st.nextToken().trim());
			        
			        /*StringTokenizer st1;
			        st1 = new StringTokenizer(st.nextToken().trim(), ",");
			        List<Date> dostupni = new ArrayList<Date>();
						while (st1.hasMoreTokens()) {
						Date dostupniDatumi = formatter.parse(st1.nextToken().trim());
						dostupni.add(dostupniDatumi);
						}*/
						
					int idDomacin = Integer.parseInt(st.nextToken().trim());
					
					Domacin domacin = DomacinDAO.findHostById(idDomacin);
					
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
			        
					/*StringTokenizer st2;
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
						}*/
				        	
				     
					
					apartmani.put(id, new Apartman(idKomentar, tip, brojSoba, brojGostiju, lokacija, dateStr, domacin, komentar, cenaPoNoci, vremeZaPrijavu, vremeZaOdjavu, status));
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
	
	public static Map<Integer, Apartman> aktivniApartmani(){
		apartmani = ucitajApartmane();
		Map<Integer, Apartman> aktivniApartmani = new HashMap<Integer, Apartman>();
		
		for(Apartman apartman: apartmani.values()) {
			if(apartman.getStatus().equals(StatusApartman.Aktivno)) {
				aktivniApartmani.put(apartman.getId(), apartman);
			}
		}
		
		return aktivniApartmani;
	}
	
	public static Map<Integer, Apartman> neaktivniApartmani(){
		apartmani = ucitajApartmane();
		Map<Integer, Apartman> neaktivniApartmani = new HashMap<Integer, Apartman>();
		
		for(Apartman apartman: apartmani.values()) {
			if(apartman.getStatus().equals(StatusApartman.Aktivno)) {
				neaktivniApartmani.put(apartman.getId(), apartman);
			}
		}
		
		return neaktivniApartmani;
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
	
	public static int vratiNajveciID() {
		int maxId = 0;
		for (Map.Entry<Integer , Apartman> apartmani1 : apartmani.entrySet())
		{
		    if ( maxId < apartmani1.getKey().intValue())
		    {
		        maxId = apartmani1.getKey();
		    }
		}
		return maxId;
	}
	
	public static void dodajApartmanUMapu(Apartman noviApartman) {
		if(apartmani.isEmpty())
			apartmani = ucitajApartmane();
			
			noviApartman.setId(vratiNajveciID() + 1);
			apartmani.put(vratiNajveciID() + 1, noviApartman);
		
	}
	public static void sacuvajSveApartmaneIzMape() throws IOException {
		
		
		BufferedWriter out = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/apartmani.txt");
			out = new BufferedWriter(new FileWriter(file));
			 for (Map.Entry<Integer, Apartman> apartman : apartmani.entrySet())  {
				out.write(apartman.getValue().toString());
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
	
	public static Boolean izbrisiApartman(Integer id) {
		Map<Integer, Apartman> apartman = ucitajApartmane();
		if(apartman.containsKey(id)) {
			apartman.remove(id);
		try {
			sacuvajSveApartmaneIzMape();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		}else
			return false;
		
	}
	
	
	public static Boolean izmeniApartman(Apartman izmenjenApartman) {
		apartmani = ucitajApartmane();
		Apartman apartman= new Apartman();
		apartman = findApartmentById(izmenjenApartman.getId());
		if (!(apartman == null)) {
			
			apartman.setTip(izmenjenApartman.getTip());
			apartman.setBrojSoba(izmenjenApartman.getBrojSoba());
			apartman.setBrojGostiju(izmenjenApartman.getBrojGostiju());
			apartman.setLokacija(izmenjenApartman.getLokacija());
			apartman.setDatumZaIzdavanje(izmenjenApartman.getDatumZaIzdavanje());
			apartman.setDostupnostPoDatumima(izmenjenApartman.getDostupnostPoDatumima());
			apartman.setDomacin(izmenjenApartman.getDomacin());
			apartman.setKomentar(izmenjenApartman.getKomentar());
			apartman.setCenaPoNoci(izmenjenApartman.getCenaPoNoci());
			apartman.setVremeZaPrijavu(izmenjenApartman.getVremeZaPrijavu());
			apartman.setVremeZaOdjavu(izmenjenApartman.getVremeZaOdjavu());
			apartman.setStatus(izmenjenApartman.getStatus());
			apartman.setSadrzajApartmana(izmenjenApartman.getSadrzajApartmana());
			apartman.setRezervacije(izmenjenApartman.getRezervacije());
			
			List<Apartman> apartmaniLista= new ArrayList<Apartman>(apartmani.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/apartmani.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(Apartman noviApartman: apartmaniLista) {
					out.write(noviApartman.getTip().toString() + ";"+ noviApartman.getBrojSoba()+ ";"+ noviApartman.getBrojGostiju()
							+ ";"+ noviApartman.getLokacija()+ ";"
							+ noviApartman.getDatumZaIzdavanje().toString()+ ";"+ noviApartman.getDostupnostPoDatumima().toString() 
							+ ";"+ noviApartman.getDomacin().toString()+ ";"+ noviApartman.getKomentar().toString()
							+ ";"+ noviApartman.getCenaPoNoci()+ ";"+ noviApartman.getVremeZaPrijavu()
							+ ";"+ noviApartman.getVremeZaOdjavu()+ ";"+ noviApartman.getStatus().toString()
							+ ";"+ noviApartman.getSadrzajApartmana().toString()+ ";"+ noviApartman.getRezervacije().toString()
							+ "\n");
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
