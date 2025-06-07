package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Clan;
import model.CsvCitac;
import model.DataPovezivac;
import model.Takmicenje;
import model.TreningPlan;
import view.ClanView;

public class ClanController {
    private ClanView view;
    private List<Clan> clanovi;
    private List<TreningPlan> treningPlanovi;
    private List<Takmicenje> takmicenja;
    private List<Clan> trenutnoPrikazaniClanovi;   

    public ClanController(ClanView view) {
        this.view = view;
        
        clanovi = CsvCitac.ucitajClanove();
        treningPlanovi = CsvCitac.ucitajTreningPlanove();
        takmicenja = CsvCitac.ucitajTakmicenja();
        
        DataPovezivac.poveziPodatke(clanovi, treningPlanovi, takmicenja);
        this.trenutnoPrikazaniClanovi = new ArrayList<>(clanovi); 
        
        view.prikaziClanove(clanovi);
        
        setupListeners();
    }

    private void setupListeners() {
        view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = view.getSearchField().getText().trim().toLowerCase();
                
                if (searchTerm.isEmpty()) {
                    view.prikaziClanove(clanovi);
                    return;
                }
                
                boolean found = false;
                for (Clan clan : clanovi) {
                    if (clan.getIme().toLowerCase().contains(searchTerm) || 
                        clan.getPrezime().toLowerCase().contains(searchTerm)) {
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    view.prikaziGresku("Član sa tim imenom ne postoji!");
                    view.getSearchField().setText("");
                    return;
                }
                
                List<Clan> filtriraniClanovi = new ArrayList<>();
                for (Clan clan : clanovi) {
                    if (clan.getIme().toLowerCase().contains(searchTerm) || 
                        clan.getPrezime().toLowerCase().contains(searchTerm)) {
                        filtriraniClanovi.add(clan);
                    }
                }
                
                view.prikaziClanove(filtriraniClanovi);
                trenutnoPrikazaniClanovi = filtriraniClanovi;
            }
        });

        // dodato - uvid u takmičenja
        view.getUvidTakmicenjaButton().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTabela().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, 
                        "Morate odabrati člana iz tabele!", 
                        "Greška", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                Clan selectedClan = trenutnoPrikazaniClanovi.get(selectedRow);
                view.prikaziDetaljeTakmicenja(selectedClan.getTakmicenja());
            }
        });

        // dodato - uvid u treninge
        view.getUvidTreningButton().addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTabela().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, 
                        "Morate odabrati člana iz tabele!", 
                        "Greška", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                Clan selectedClan = trenutnoPrikazaniClanovi.get(selectedRow);
                view.prikaziDetaljeTreninga(selectedClan.getTreningPlanovi());
            }
        });
    }
}
                                                                      

    	

