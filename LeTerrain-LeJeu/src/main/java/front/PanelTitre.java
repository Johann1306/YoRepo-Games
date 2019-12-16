package front;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import core.configuration.Constante;

public class PanelTitre extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public PanelTitre() {
		JLabel titre = new JLabel("LE TERRAIN");
		JLabel titreVide = new JLabel("         *         ");
		JLabel titreSecondaire = new JLabel("FOOT - SCOOTER - SHIT");
		
		titre.setFont(Constante.STARWARS_FONT_TITRE);
		titre.setForeground(Color.BLACK);
		
		titreVide.setFont(Constante.STARWARS_FONT_SOUS_TITRE);
		titreVide.setForeground(Color.YELLOW);
		
		titreSecondaire.setFont(Constante.STARWARS_FONT_SOUS_TITRE);
		titreSecondaire.setForeground(Color.BLACK);
		
		this.add(titre);
		this.add(titreVide);
		this.add(titreSecondaire);
	}
}
