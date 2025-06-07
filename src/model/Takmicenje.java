package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Takmicenje {
	private String naziv;
	private String imeClana;
	private String kategorija;
	private String rezultat;
	
	public Takmicenje(String naziv, String imeClana, String kategorija, String rezultat) {
		super();
		this.naziv = naziv;
		this.imeClana = imeClana;
		this.kategorija = kategorija;
		this.rezultat = rezultat;
	}

	public String getImeClana() {
		return imeClana;
	}

	public void setImeClana(String imeClana) {
		this.imeClana = imeClana;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getRezultat() {
		return rezultat;
	}

	public void setRezultat(String rezultat) {
		this.rezultat = rezultat;
	}
	
	
	
	
	

}
