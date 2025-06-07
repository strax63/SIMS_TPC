package model;

import java.util.ArrayList;
import java.util.List;

public class Clan {
	private String ime;
	private String prezime;
	private String email;
	private String pol;
	private List<TreningPlan> treningPlanovi;
	private List<Takmicenje> takmicenja;
	
	public Clan(String ime, String prezime, String email, String pol) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.pol = pol;
		this.treningPlanovi = new ArrayList<>();
		this.takmicenja = new ArrayList<>();
		
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getEmail() {
		return email;
	}

	public String getPol() {
		return pol;
	}

	public List<TreningPlan> getTreningPlanovi() {
		return treningPlanovi;
	}

	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}
	
	public void dodajTreningPlan(TreningPlan plan) {
		treningPlanovi.add(plan);
	}
	
	public void dodajTakmicenje(Takmicenje takmicenje) {
		takmicenja.add(takmicenje);
	}
	
	
	
	
	
	
	
	

}
