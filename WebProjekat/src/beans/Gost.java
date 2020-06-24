package beans;

import java.util.ArrayList;
import java.util.List;

public class Gost extends Korisnik{
	
	private List<Apartman> iznajmljeniApartmani;
	private List<Rezervacija> rezervacije;
	
	public Gost() {
		iznajmljeniApartmani = new ArrayList<Apartman>();
		rezervacije = new ArrayList<Rezervacija>();
		uloga = Uloga.Gost;
	}
	
	public Gost(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Uloga uloga,
			List<Apartman> iznajmljeniApartmani, List<Rezervacija> rezervacije) {
		super(korisnickoIme, lozinka, ime, prezime, pol, uloga);
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.uloga = uloga;
		this.iznajmljeniApartmani = iznajmljeniApartmani;
		this.rezervacije = rezervacije;
	}

	public List<Apartman> getIznajmljeniApartmani() {
		return iznajmljeniApartmani;
	}

	public void setIznajmljeniApartmani(List<Apartman> iznajmljeniApartmani) {
		this.iznajmljeniApartmani = iznajmljeniApartmani;
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	

	

}
