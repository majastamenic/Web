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


import beans.Lokacija;
import beans.StatusApartman;
import beans.TipApartmana;
import beans.Uloga;
import servlets.LogInServlet;



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
					
					Apartman noviApartman = new Apartman(id, tip, brojSoba, brojGostiju, lokacija, dateStr, domacin, cenaPoNoci, vremeZaPrijavu, vremeZaOdjavu, status);
					
					/*for (Map.Entry<Integer, KomentarZaApartman> komentar : KomentarDAO.getKomentari().entrySet()) {		
						if(komentar.getValue().getApartman().getId() == noviApartman.getId()) {
							noviApartman.getKomentar().add(komentar.getValue());
							komentar.getValue().setApartman(noviApartman);
						}
					}*/
				        	
				     
					
					apartmani.put(id, noviApartman);
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
	
	public static Map<Integer, Apartman> ucitajApartmaneOdDomacina(){
		apartmani = ucitajApartmane();
		Map<Integer, Apartman> apartmaniOdDomacina = new HashMap<Integer, Apartman>();
		
		for(Apartman apartman: apartmani.values()) {
			if(apartman.getDomacin().getKorisnickoIme().equals(LogInServlet.ulogovaniKorisnik.getKorisnickoIme())) {
				apartmaniOdDomacina.put(apartman.getId(), apartman);
			}
		}
		
		return apartmaniOdDomacina;
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
			if(apartman.getStatus().equals(StatusApartman.Neaktivno)) {
				neaktivniApartmani.put(apartman.getId(), apartman);
			}
		}
		
		return neaktivniApartmani;
	}
	
	
	public static Map<Integer, Apartman> ucitajApartmaneSpramUloge(){
		try {
			if(LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Administrator) || LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Domacin))
				return ucitajApartmane();
			
		} catch (Exception e) {}
		return aktivniApartmani();			
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
	
	@SuppressWarnings("unlikely-arg-type")
	public static ArrayList<Apartman> pretraga(String tekst){
		ArrayList<Apartman> listaApartmana = new ArrayList<Apartman>();
		apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(tekst.equals(apartman.getTip())) {
				listaApartmana.add(apartman);
			}
			
			if(Integer.parseInt(tekst) == apartman.getBrojSoba() || Integer.parseInt(tekst) == apartman.getBrojGostiju()) {
				listaApartmana.add(apartman);
			}
			
			if(tekst.contains(apartman.getLokacija().getAdresa().getNaseljenoMesto())) {
				listaApartmana.add(apartman);
			}
			
			if(tekst.contains(apartman.getDomacin().getKorisnickoIme())) {
				listaApartmana.add(apartman);
			}
		}
		
		return listaApartmana;
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
				out.write(apartman.getValue().ispisTXT());
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
	//Nisam sigurna da je ovo dobra logika!
	public static ArrayList<Apartman> pretragaPoDatumu(Date pocetniDatum, Date krajnjiDatum){
		ArrayList<Apartman> nadjeniApartmani = new ArrayList<Apartman>();
		ApartmanDAO.apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(apartman.getDostupnostPoDatumima().contains(pocetniDatum) && apartman.getDostupnostPoDatumima().contains(krajnjiDatum)) {
				nadjeniApartmani.add(apartman);
			}
		}
		
		
		return nadjeniApartmani;
	}
	
	public static ArrayList<Apartman> pretragaPoGradu(String nazivGrada){
		ArrayList<Apartman> nadjeniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(apartman.getLokacija().getAdresa().getNaseljenoMesto().equals(nazivGrada)) {
				nadjeniApartmani.add(apartman);
			}
		}
		return nadjeniApartmani;
	}
	/* String a;
	   String b;
	   Person c;
	   Person d;
	   for (int i=0; i< list.size(); i++){
	      for(int j=i; j< list.size()-1; j++){
	         a = list.get(i).getLastName();
	         b = list.get(j+1).getLastName();
	         c = list.get(i);
	         d = list.get(j+1);

	         if ( a.compareTo(b) > 0 )  {

	             Person temp = d;
	             list.set(j+1, c);        
	             list.set(i, temp); 
	        }
	     }
	  }
	  for(Person person: list){
	      System.out.println(person.lastName);
	  }
	}*/
	
	public static List<Apartman> sortiranjePoCeniRastuce(){
		Float a;
		Float b;
		Apartman c;
		Apartman d;
		apartmani = ucitajApartmane();
		List<Apartman> nesortiraniApartmani = new ArrayList<Apartman>(apartmani.values());
		for(int i = 0; i<nesortiraniApartmani.size() ; i++) {
			for(int j = 0 ; j < nesortiraniApartmani.size()-i-1 ; j++) {
				a=nesortiraniApartmani.get(j).getCenaPoNoci();
				b=nesortiraniApartmani.get(j+1).getCenaPoNoci();
				c=nesortiraniApartmani.get(j);
				d=nesortiraniApartmani.get(j+1);
				
				if(a.compareTo(b)>0) {
					Apartman temp=d;
					nesortiraniApartmani.set(j+1, c);
					nesortiraniApartmani.set(j, temp);
				}
			}
		}
		/*List<Apartman> sortiraniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmane();
		List<Apartman> nesortiraniApartmani = new ArrayList<Apartman>(apartmani.values());
		Float max= nesortiraniApartmani.get(0).getCenaPoNoci();
		
		for(int i = 0; i < nesortiraniApartmani.size();i++) {
			if(nesortiraniApartmani.get(i).getCenaPoNoci()> max) {
				
				
			}
		}
		return sortiraniApartmani;*/
		return nesortiraniApartmani;
	}
	
	public static List<Apartman> sortiranjePoCeniOpadajuce(){
		Float a;
		Float b;
		Apartman c;
		Apartman d;
		apartmani = ucitajApartmane();
		List<Apartman> nesortiraniApartmani = new ArrayList<Apartman>(apartmani.values());
		for(int i = 0; i<nesortiraniApartmani.size() ; i++) {
			for(int j = 0 ; j < nesortiraniApartmani.size()-i-1 ; j++) {
				a=nesortiraniApartmani.get(j).getCenaPoNoci();
				b=nesortiraniApartmani.get(j+1).getCenaPoNoci();
				c=nesortiraniApartmani.get(j);
				d=nesortiraniApartmani.get(j+1);
				
				if(a.compareTo(b)<0) {
					Apartman temp=d;
					nesortiraniApartmani.set(j+1, c);
					nesortiraniApartmani.set(j, temp);
				}
			}
		}
		/*List<Apartman> sortiraniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmane();
		List<Apartman> nesortiraniApartmani = new ArrayList<Apartman>(apartmani.values());
		Float max= nesortiraniApartmani.get(0).getCenaPoNoci();
		
		for(int i = 0; i < nesortiraniApartmani.size();i++) {
			if(nesortiraniApartmani.get(i).getCenaPoNoci()> max) {
				
				
			}
		}
		return sortiraniApartmani;*/
		return nesortiraniApartmani;
	}
	


	
	public static ArrayList<Apartman> pretragaPoCeni(float pocetnaCena, float krajnjaCena){
		ArrayList<Apartman> nadjeniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(apartman.getCenaPoNoci()>=pocetnaCena && apartman.getCenaPoNoci()<=krajnjaCena) {
				nadjeniApartmani.add(apartman);
			}
		}
		return nadjeniApartmani;
	}
	
	public static ArrayList<Apartman> pretragaPoBrojuSoba(int pocetniBrSoba, int krajnjiBrSoba){
		ArrayList<Apartman> nadjeniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(apartman.getBrojSoba()>=pocetniBrSoba && apartman.getBrojSoba()<=krajnjiBrSoba) {
				nadjeniApartmani.add(apartman);
			}
		}
		return nadjeniApartmani;
	}
	
	public static ArrayList<Apartman> pretragaPoBrOsoba(int pocetniBrojOsoba, int krajnjiBrojSoba){
		ArrayList<Apartman> nadjeniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(apartman.getBrojGostiju()>=pocetniBrojOsoba && apartman.getBrojGostiju()<=krajnjiBrojSoba) {
				nadjeniApartmani.add(apartman);
			}
		}
		return nadjeniApartmani;
	}
	public static ArrayList<Apartman> pretragaPoTipu(TipApartmana tip) {
		ArrayList<Apartman> nadjeniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(apartman.getTip().equals(tip)) {
				nadjeniApartmani.add(apartman);
			}
		}
		return nadjeniApartmani;
	}
	public static ArrayList<Apartman> pretragaLokaciji(Lokacija lokacija) {
		ArrayList<Apartman> nadjeniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(apartman.getLokacija().equals(lokacija)) {
				nadjeniApartmani.add(apartman);
			}
		}
		return nadjeniApartmani;
	}
	public static ArrayList<Apartman> pretragaPoPogodnostima(Amenities pogodnost) {
		ArrayList<Apartman> nadjeniApartmani = new ArrayList<Apartman>();
		apartmani = ucitajApartmaneSpramUloge();
		
		for(Apartman apartman:apartmani.values()) {
			if(apartman.getSadrzajApartmana().contains(pogodnost)) {
				nadjeniApartmani.add(apartman);
			}
		}
		return nadjeniApartmani;
	}
	
	

}
