package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;
import java.util.StringTokenizer;


import beans.Apartman;
import beans.Lokacija;
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
			        
			        
					
					/*int idApartman= Integer.parseInt(st.nextToken().trim());
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
					if(st.nextToken().trim().toString()=="Kreirana")
						status=StatusRezervacija.Kreirana;
					else if(st.nextToken().trim().toString()=="Odbijena")
						status=StatusRezervacija.Odbijena;
					else if(st.nextToken().trim().toString()=="Odustanak")
						status=StatusRezervacija.Odustanak;
					else if(st.nextToken().trim().toString()=="Prihvacena")
						status=StatusRezervacija.Prihvacena;
					else
						status=StatusRezervacija.Zavrsena;*/
			        
					
					//apartmani.put(id, new Rezervacija(idGost, apartman, dateStr, brojNocenja, ukupnaCena, poruka, gost, status));
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
