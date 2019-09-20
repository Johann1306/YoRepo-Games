package front;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import core.configuration.Constante;

public class PanelInfoTitre extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelInfoTitre() {
		JLabel infoTitre = new JLabel("** (Titre provisoire impose par Guillaume Burguet)");
		
		infoTitre.setFont(Constante.MARIO_FONT_INFO_TITRE);
		infoTitre.setForeground(Color.WHITE);
		
		this.add(infoTitre);
	}
}
