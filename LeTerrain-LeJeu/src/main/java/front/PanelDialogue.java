package front;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDialogue extends JPanel {
	
	private String texte;
	
	// Panel de dialogue a affichage progressif et avec une limite de taille. Appuyer RoundButton pour continuer de lire.
	public PanelDialogue(String texte) {
		this.texte = texte;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		PanelDialogue panel = new PanelDialogue("test");

		RoundButton button = new RoundButton(new ImageIcon("src/main/resources/image/mp3Player/back.png"));
		panel.add(button);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}

}
