package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import beans.Gost;


public class GostDAO {
	private Map<Integer, Gost> gosti = new HashMap<>();
	
	public GostDAO() {
		
	}
	
	public Gost find(Integer id) {
		if (!gosti.containsKey(id)) {
			return null;
		}
		Gost lok = gosti.get(id);
		
		return lok;
	}
	
	public Collection<Gost> findAll() {
		return gosti.values();
	}

}
