package beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Administratori {
	
	private HashMap<String, Administrator> administratoriMapa = new HashMap<String, Administrator>();
	private ArrayList<Administrator> administratoriLista = new ArrayList<Administrator>();
	
	public Administratori(String path) {
		BufferedReader in = null;
		try {
			File file = new File(path+"/administratori.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			readKorisnici(in);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void readKorisnici(BufferedReader in) {
		
		String line;
		String korisnickoIme = "";
		String lozinka = "";
		String ime = "";
		String prezime= "";
		String pol = "";
		String uloga = "";
		
		StringTokenizer stringTokenizer;
		
		try {
			while((line = in.readLine()) != null) {
				line = line.trim();
				
				if(line.equals("") || line.indexOf('#')==0)
					continue;
				
				stringTokenizer = new StringTokenizer(line, ";");
				
				while(stringTokenizer.hasMoreElements()) {
					korisnickoIme = stringTokenizer.nextToken().trim();
					lozinka = stringTokenizer.nextToken().trim();
					ime = stringTokenizer.nextToken().trim();
					prezime = stringTokenizer.nextToken().trim();
					pol = stringTokenizer.nextToken().trim();
					uloga = stringTokenizer.nextToken().trim();
				}
				//Administrator administrator = new Administrator(korisnickoIme, lozinka, ime, prezime, Pol.valueOf(pol), Uloga.valueOf(uloga));
				//administratoriMapa.put(korisnickoIme, administrator);
				//administratoriLista.add(administrator);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
