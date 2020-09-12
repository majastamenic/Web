package beans;

public class Korisnik{
	
	@Override
	public String toString() {
		return id + ";"+ korisnickoIme + ";"+ lozinka + ";"+ ime+ ";"+ prezime+ ";"+ pol.toString() + ";"+ uloga.toString() + "\n";
	} 
	/**
	 * 
	 */
	protected int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	protected String korisnickoIme;
	protected String lozinka;
	protected String ime;
	protected String prezime;
	protected Pol pol;
	protected Uloga uloga;
	
	public Korisnik() {}
	
	public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Uloga uloga) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.uloga = uloga;
	}
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Pol getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = Pol.valueOf(pol);
	}
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
}
