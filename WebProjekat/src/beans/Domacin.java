package beans;

import java.util.ArrayList;
import java.util.List;

public class Domacin extends Korisnik{
	private List<Apartman> apartmaniZaIzdavanje;
	
	public Domacin() {
		apartmaniZaIzdavanje = new ArrayList<Apartman>();
		uloga = Uloga.Domacin;
	}
	
	public Domacin(int id,String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Uloga uloga,
			List<Apartman> apartmaniZaIzdavanje) {
		super(korisnickoIme, lozinka, ime, prezime, pol, uloga);
		this.id=id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.uloga = uloga;
		this.apartmaniZaIzdavanje = apartmaniZaIzdavanje;
	}

	public List<Apartman> getApartmaniZaIzdavanje() {
		return apartmaniZaIzdavanje;
	}

	public void setApartmaniZaIzdavanje(List<Apartman> apartmaniZaIzdavanje) {
		this.apartmaniZaIzdavanje = apartmaniZaIzdavanje;
	}

	@Override
	public String toString() {
		return id + ";"+ korisnickoIme + ";"+ lozinka + ";"+ ime+ ";"+ prezime+ ";"+ pol.toString() + ";"+ uloga.toString() + "\n";
	} 

}
