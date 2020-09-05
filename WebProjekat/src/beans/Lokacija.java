package beans;

public class Lokacija extends Adresa{
	

	private float geografskaSirina;
	private float geografskaDuzina;
	
	
	public Lokacija(String ulicaBroj, String naseljenoMesto, int postanskiBroj) {
		super(ulicaBroj, naseljenoMesto, postanskiBroj);
		// TODO Auto-generated constructor stub
		
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

	
}
