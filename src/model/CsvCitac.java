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

public class CsvCitac {
	
	public static List<Clan> ucitajClanove(){
		List<Clan> clanovi = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader("data/clanovi.csv"))){
			String red;
			while((red = br.readLine()) != null) {
				String[] podaci = red.split(",");
				Clan clan = new Clan(
						podaci[0].trim(),
						podaci[1].trim(),
						podaci[2].trim(),
						podaci[3].trim()
				);
				clanovi.add(clan);
						
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clanovi;
	}
	
	
	public static List<Takmicenje> ucitajTakmicenja(){
		List<Takmicenje> takmicenja = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader("data/takmicenja.csv"))){
			String red;
			while((red = br.readLine()) != null) {
				String[] podaci = red.split(",");
				Takmicenje takmicenje = new Takmicenje(
						podaci[0].trim(),
						podaci[1].trim(),
						podaci[2].trim(),
						podaci[3].trim()
				);
				takmicenja.add(takmicenje);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return takmicenja;
	}
	
	
	public static List<TreningPlan> ucitajTreningPlanove(){
		List<TreningPlan> planovi = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try(BufferedReader br = new BufferedReader(new FileReader("data/trening_planovi.csv"))){
			String red;
			while((red = br.readLine()) != null) {
				String[] podaci = red.split(",");
				Date datum = sdf.parse(podaci[1].trim());
				
				List<String> vezbe = new ArrayList<>();
				for (int i = 2; i < podaci.length; i ++) {
					vezbe.add(podaci[i].trim());
					
				}
				TreningPlan plan = new TreningPlan(
						podaci[0].trim(),
						datum,
						vezbe
				);
				planovi.add(plan);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return planovi;
		
	}

}
