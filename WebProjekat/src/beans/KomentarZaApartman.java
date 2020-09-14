package beans;

public class KomentarZaApartman {
	private int id;
	private Gost gost;
	private Apartman apartman;
	private String tekst;
	private int ocena;
	
	public KomentarZaApartman() {}
	
	public String ispisTXT() {
		return id + ";"+ gost.getId() + ";"+ apartman.getId() + ";"+ tekst+ ";"+ ocena + "\n";
	} 
	
	public KomentarZaApartman(int id,Gost gost, Apartman apartman, String tekst, int ocena) {
		super();
		this.id=id;
		this.gost = gost;
		this.apartman = apartman;
		this.tekst = tekst;
		this.ocena = ocena;
	}
	

	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public Apartman getApartman() {
		return apartman;
	}

	public void setApartman(Apartman apartman) {
		this.apartman = apartman;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
