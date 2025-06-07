package aplikacija;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.ClanController;

import view.ClanView;

public class Main extends JFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		        ClanView view = new ClanView();
		        new ClanController(view);
		        view.setVisible(true);
		    }
		});

		}

   


}


