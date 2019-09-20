package front;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import core.configuration.Constante;

public class PanelTitre extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public PanelTitre() {
		JLabel titre = new JLabel("LE TERRAIN");
		JLabel titreSecondaire = new JLabel("SCOOTER FOOT SHIT **");
		
		titre.setFont(Constante.MARIO_FONT_TITRE);
		titre.setForeground(Color.WHITE);
		
		titreSecondaire.setFont(Constante.MARIO_FONT_SOUS_TITRE);
		titreSecondaire.setForeground(Color.WHITE);
		
		this.add(titre);
		this.add(titreSecondaire);
	}
}
