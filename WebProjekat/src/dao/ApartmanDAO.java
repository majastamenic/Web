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



import beans.Amenities;
import beans.Apartman;
import beans.Domacin;
import beans.KomentarZaApartman;
import beans.Lokacija;
import beans.Rezervacija;
import beans.StatusApartman;
import beans.TipApartmana;



public class ApartmanDAO {
	private Map<Integer, Apartman> apartmani = new HashMap<>();
	public ApartmanDAO() {
		
	}
	public ApartmanDAO(String contextPath) {
		ucitajApartmane(contextPath);
	}
	
	
	public Apartman find(Integer id) {
		if (!apartmani.containsKey(id)) {
			return null;
		}
		Apartman rez = apartmani.get(id);
		
		return rez;
	}
	
	public Collection<Apartman> findAll() {
		return apartmani.values();
	}
	
	private void ucitajApartmane(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/apartmani.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					
					/*private int id;
					private TipApartmana tip;
					private int brojSoba;
					private int brojGostiju;
					private String lokacija;
					private Date datumZaIzdavanje;
					private List<Date> dostupnostPoDatumima;
					private Domacin domacin;
					private KomentarZaApartman komentar;
					//slike
					private float cenaPoNoci;
					private String vremeZaPrijavu;
					private String vremeZaOdjavu;
					private StatusApartman status;
					private List<Amenities> sadrzajApartmana;
					private List<Rezervacija> rezervacije;*/
					int id= Integer.parseInt(st.nextToken().trim());
					TipApartmana tip= null;
					if(st.nextToken().trim()=="Apartman")
						tip=TipApartmana.Apartman;
					else
						tip=TipApartmana.Soba;
					int brojSoba= Integer.parseInt(st.nextToken().trim());
					int brojGostiju= Integer.parseInt(st.nextToken().trim());
					int idLokacija = Integer.parseInt(st.nextToken().trim());
					lokacijaDAO ld=new lokacijaDAO();
					Lokacija lokacija= ld.find(idLokacija);
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
					Domacin domacin = dd.find(idDomacin);
					
					int idKomentar= Integer.parseInt(st.nextToken().trim());
					KomentarDAO kd= new KomentarDAO();
					KomentarZaApartman komentar = kd.find(idKomentar);
					
					float cenaPoNoci= Float.parseFloat(st.nextToken().trim());
					String vremeZaPrijavu= st.nextToken().trim();
					String vremeZaOdjavu = st.nextToken().trim();
					
					StatusApartman status= null;
					if(st.nextToken().trim() =="Aktivno")
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
	}

}
