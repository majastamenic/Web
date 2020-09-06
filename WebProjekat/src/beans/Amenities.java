package beans;

public class Amenities {
	protected Integer id;
	
	protected String naziv;
	
	public Amenities(Integer id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
