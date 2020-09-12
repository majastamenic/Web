package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Apartman {
	private int id;
	private TipApartmana tip;
	private int brojSoba;
	private int brojGostiju;
	private Lokacija lokacija;
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
	private List<Rezervacija> rezervacije;
	
	@Override
	public String toString() {
		return id + ";"+ tip.toString() + ";"+ brojSoba + ";"+ brojGostiju+ ";"+ lokacija.toString()+ ";"
				+ datumZaIzdavanje.toString() + ";"+ domacin.toString() 
				+ ";"+ komentar.toString() + ";"+ cenaPoNoci + ";"+ vremeZaPrijavu
				+ ";"+ vremeZaOdjavu + ";"+ status.toString() + "\n";
	} 
	
	public Apartman() {
		dostupnostPoDatumima = new ArrayList<Date>();
		sadrzajApartmana = new ArrayList<Amenities>();
		rezervacije = new ArrayList<Rezervacija>();
	}

	public Apartman(int id, TipApartmana tip, int brojSoba, int brojGostiju, Lokacija lokacija, Date datumZaIzdavanje,
			List<Date> dostupnostPoDatumima, Domacin domacin, KomentarZaApartman komentar, float cenaPoNoci,
			String vremeZaPrijavu, String vremeZaOdjavu, StatusApartman status, List<Amenities> sadrzajApartmana,
			List<Rezervacija> rezervacije) {
		super();
		this.id=id;
		this.tip = tip;
		this.brojSoba = brojSoba;
		this.brojGostiju = brojGostiju;
		this.lokacija = lokacija;
		this.datumZaIzdavanje = datumZaIzdavanje;
		this.dostupnostPoDatumima = dostupnostPoDatumima;
		this.domacin = domacin;
		this.komentar = komentar;
		this.cenaPoNoci = cenaPoNoci;
		this.vremeZaPrijavu = vremeZaPrijavu;
		this.vremeZaOdjavu = vremeZaOdjavu;
		this.status = status;
		this.sadrzajApartmana = sadrzajApartmana;
		this.rezervacije = rezervacije;
	}

	

	 



	public TipApartmana getTip() {
		return tip;
	}

	public void setTip(TipApartmana tip) {
		this.tip = tip;
	}

	public int getBrojSoba() {
		return brojSoba;
	}

	public void setBrojSoba(int brojSoba) {
		this.brojSoba = brojSoba;
	}

	public int getBrojGostiju() {
		return brojGostiju;
	}

	public void setBrojGostiju(int brojGostiju) {
		this.brojGostiju = brojGostiju;
	}

	public Lokacija getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}

	public Date getDatumZaIzdavanje() {
		return datumZaIzdavanje;
	}

	public void setDatumZaIzdavanje(Date datumZaIzdavanje) {
		this.datumZaIzdavanje = datumZaIzdavanje;
	}

	public List<Date> getDostupnostPoDatumima() {
		return dostupnostPoDatumima;
	}

	public void setDostupnostPoDatumima(List<Date> dostupnostPoDatumima) {
		this.dostupnostPoDatumima = dostupnostPoDatumima;
	}

	public Domacin getDomacin() {
		return domacin;
	}

	public void setDomacin(Domacin domacin) {
		this.domacin = domacin;
	}

	public KomentarZaApartman getKomentar() {
		return komentar;
	}

	public void setKomentar(KomentarZaApartman komentar) {
		this.komentar = komentar;
	}

	public float getCenaPoNoci() {
		return cenaPoNoci;
	}

	public void setCenaPoNoci(float cenaPoNoci) {
		this.cenaPoNoci = cenaPoNoci;
	}

	public String getVremeZaPrijavu() {
		return vremeZaPrijavu;
	}

	public void setVremeZaPrijavu(String vremeZaPrijavu) {
		this.vremeZaPrijavu = vremeZaPrijavu;
	}

	public String getVremeZaOdjavu() {
		return vremeZaOdjavu;
	}

	public void setVremeZaOdjavu(String vremeZaOdjavu) {
		this.vremeZaOdjavu = vremeZaOdjavu;
	}

	public StatusApartman getStatus() {
		return status;
	}

	public void setStatus(StatusApartman status) {
		this.status = status;
	}

	public List<Amenities> getSadrzajApartmana() {
		return sadrzajApartmana;
	}

	public void setSadrzajApartmana(List<Amenities> sadrzajApartmana) {
		this.sadrzajApartmana = sadrzajApartmana;
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
