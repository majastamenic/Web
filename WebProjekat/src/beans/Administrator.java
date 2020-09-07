package beans;


public class Administrator extends Korisnik{
	private int id;

	public Administrator(Integer id,String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Uloga uloga) {
		super(korisnickoIme, lozinka, ime, prezime, pol, uloga);
		this.setId(id);
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.uloga = uloga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
