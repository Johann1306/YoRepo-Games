package front;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.configuration.Constante;

public class PanelTitre extends JPanel {
	
	public PanelTitre() {
		JLabel titre = new JLabel("LE TERRAIN");
		titre.setFont(Constante.MARIO_FONT_TITRE);
		titre.setForeground(Color.WHITE);
		this.add(titre);
	}
}
