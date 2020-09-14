package beans;

import java.util.Date;

public class Rezervacija {
	private int id;
	private Apartman rezervisanApartman;
	private Date pocetniDatum;
	private int brojNocenja;
	private float ukupnaCena;
	private String poruka;
	private Gost gost;
	private StatusRezervacija status;
	
	public String ispisTXT() {
		return id + ";"+ rezervisanApartman.getId() + ";"+ pocetniDatum.toString() + ";"+ brojNocenja
				+ ";"+ ukupnaCena+ ";"+ poruka + ";"+ gost.getId()+";"+ status.toString() + "\n";
	} 
	
	public Rezervacija() {}

	public Rezervacija(int id, Apartman rezervisanApartman, Date pocetniDatum, int brojNocenja, float ukupnaCena,
			String poruka, Gost gost, StatusRezervacija status) {
		super();
		this.id=id;
		this.rezervisanApartman = rezervisanApartman;
		this.pocetniDatum = pocetniDatum;
		this.brojNocenja = brojNocenja;
		this.ukupnaCena = ukupnaCena;
		this.poruka = poruka;
		this.gost = gost;
		this.status = status;
	}

	public Apartman getRezervisanApartman() {
		return rezervisanApartman;
	}

	public void setRezervisanApartman(Apartman rezervisanApartman) {
		this.rezervisanApartman = rezervisanApartman;
	}

	public Date getPocetniDatum() {
		return pocetniDatum;
	}

	public void setPocetniDatum(Date pocetniDatum) {
		this.pocetniDatum = pocetniDatum;
	}

	public int getBrojNocenja() {
		return brojNocenja;
	}

	public void setBrojNocenja(int brojNocenja) {
		this.brojNocenja = brojNocenja;
	}

	public float getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(float ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public StatusRezervacija getStatus() {
		return status;
	}

	public void setStatus(StatusRezervacija status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
