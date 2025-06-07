package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Clan;
import model.Takmicenje;

public class ClanView extends JFrame {
	private JTable tabela;
    private JTextField searchField;
    private JButton searchButton;
    private DefaultTableModel model;
    private JButton uvidTakmicenjaButton;

    public ClanView() {
        setTitle("Lista članova");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLayout(new BorderLayout());

        String[] kolone = {"Ime", "Prezime", "Email", "Pol"};
        model = new DefaultTableModel(kolone, 0);
        tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);

        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Pretraži");
        
        searchPanel.add(new JLabel("Pretraži po imenu:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();                        
        uvidTakmicenjaButton = new JButton("Uvid u takmičenja");
        
        buttonPanel.add(uvidTakmicenjaButton); 
        
        
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void prikaziClanove(List<Clan> clanovi) {
        model.setRowCount(0);
        for (Clan clan : clanovi) {
            model.addRow(new Object[]{
                    clan.getIme(),
                    clan.getPrezime(),
                    clan.getEmail(),
                    clan.getPol()
            });
        }
    }

    public void prikaziGresku(String poruka) {
        JOptionPane.showMessageDialog(this, poruka, "Greška", JOptionPane.ERROR_MESSAGE);
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JTable getTabela() {
        return tabela;
    }
    
    public JButton getUvidTakmicenjaButton() {                     
        return uvidTakmicenjaButton;
    }
    
    public void prikaziDetaljeTakmicenja(List<Takmicenje> takmicenja) {         
        StringBuilder sb = new StringBuilder();                                  
        for (Takmicenje t : takmicenja) {
            sb.append("Naziv: ").append(t.getNaziv()).append("\n")
              .append("Kategorija: ").append(t.getKategorija()).append("\n")
              .append("Rezultat: ").append(t.getRezultat()).append("\n\n");
        }
        
        JOptionPane.showMessageDialog(this, 
            sb.toString(), 
            "Takmicenja za clana", 
            JOptionPane.INFORMATION_MESSAGE);
    }   

}
