package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreningPlan {
	private String imeClana;
	private Date datumKreiranja;
	private List<String> vezbe;
	
	public TreningPlan(String imeClana, Date datumKreiranja, List<String> vezbe) {
		super();
		this.imeClana = imeClana;
		this.datumKreiranja = datumKreiranja;
		this.vezbe = vezbe;
	}

	public String getImeClana() {
		return imeClana;
	}

	public void setImeClana(String imeClana) {
		this.imeClana = imeClana;
	}

	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public List<String> getVezbe() {
		return vezbe;
	}

	public void setVezbe(List<String> vezbe) {
		this.vezbe = vezbe;
	}
	
	
	
	

}
