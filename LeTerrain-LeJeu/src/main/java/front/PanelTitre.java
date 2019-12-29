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
		
		titre.setFont(Constante.STARWARS_FONT_TITRE);
		titre.setForeground(Color.BLACK);
		
		titreVide.setFont(Constante.ZELDA_FONT_SOUS_TITRE_SYMBOLE);
		titreVide.setForeground(Color.YELLOW);
		
		this.add(titre);
		this.add(titreVide);
	}
}
