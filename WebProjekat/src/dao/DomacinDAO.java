package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import beans.Domacin;


public class DomacinDAO {
private Map<Integer, Domacin> domacini = new HashMap<>();
	
	
	public DomacinDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Mo�e se pristupiti samo iz servleta.
	 */
	public DomacinDAO(String contextPath) {
		ucitajDomacine(contextPath);
	}
	
	/**
	 * Vra�a korisnika za prosle�eno korisni�ko ime i �ifru. Vra�a null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public Domacin find(Integer id) {
		if (!domacini.containsKey(id)) {
			return null;
		}
		Domacin komm = domacini.get(id);
		
		return komm;
	}
	
	public Collection<Domacin> findAll() {
		return domacini.values();
	}
	private void ucitajDomacine(String contextPath) {
		
	}
	

}
