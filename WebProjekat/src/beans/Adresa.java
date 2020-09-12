package beans;

public class Adresa {
	private int id;
	private String ulicaBroj;
	private String naseljenoMesto;
	private int postanskiBroj;
	
	public Adresa() {}
	
	public Adresa(int id, String ulicaBroj, String naseljenoMesto, int postanskiBroj) {
		super();
		this.id=id;
		this.ulicaBroj = ulicaBroj;
		this.naseljenoMesto = naseljenoMesto;
		this.postanskiBroj = postanskiBroj;
	}
	public String getUlicaBroj() {
		return ulicaBroj;
	}
	public void setUlicaBroj(String ulicaBroj) {
		this.ulicaBroj = ulicaBroj;
	}
	public String getNaseljenoMesto() {
		return naseljenoMesto;
	}
	public void setNaseljenoMesto(String naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
