package model;

import java.util.List;

public class DataPovezivac {
	public static void poveziPodatke(List<Clan> clanovi, List<TreningPlan> treningPlanovi, List<Takmicenje> takmicenja) {
		for(Clan clan : clanovi) {
			for (TreningPlan plan : treningPlanovi) {
				if (plan.getImeClana().equals(clan.getIme())) {
					clan.dodajTreningPlan(plan);
				}
			}
			
			for (Takmicenje takmicenje : takmicenja) {
				if (takmicenje.getImeClana().equals(clan.getIme())) {
					clan.dodajTakmicenje(takmicenje);
					
				}
			}
		}
	}

}
