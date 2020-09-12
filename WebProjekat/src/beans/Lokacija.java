package beans;

public class Lokacija{
	
	private int id;
	private float geografskaSirina;
	private float geografskaDuzina;
	private Adresa adresa;
	
	
	
	public Lokacija() {}
	

	public Lokacija(int id, float geografskaSirina, float geografskaDuzina, Adresa adresa) {
		super();
		this.id=id;
		this.geografskaSirina = geografskaSirina;
		this.geografskaDuzina = geografskaDuzina;
		this.adresa = adresa;
	}

	public float getGeografskaSirina() {
		return geografskaSirina;
	}

	public void setGeografskaSirina(float geografskaSirina) {
		this.geografskaSirina = geografskaSirina;
	}

	public float getGeografskaDuzina() {
		return geografskaDuzina;
	}

	public void setGeografskaDuzina(float geografskaDuzina) {
		this.geografskaDuzina = geografskaDuzina;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
