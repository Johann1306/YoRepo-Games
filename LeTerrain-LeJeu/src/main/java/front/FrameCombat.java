package front;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.configuration.Constante;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;

public class FrameCombat extends JFrame {

	public FrameCombat() {
		
		// Configuration de la fenetre
		JPanel content = new JPanel();
		this.setAlwaysOnTop(true);
		this.setSize(Constante.FENETRE_COMBAT_DIMENSION);
		this.setMinimumSize(Constante.FENETRE_COMBAT_DIMENSION);  
		centreFenetre();
		
		this.setContentPane(content);
		this.setVisible(true);
	}
	
	public boolean start(Groupe groupe, Mission mission) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(false);
		return false;
	}

	private void centreFenetre() {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	}
}
