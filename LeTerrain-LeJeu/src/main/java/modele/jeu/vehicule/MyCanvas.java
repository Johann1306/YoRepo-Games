package modele.jeu.vehicule;

import java.awt.Graphics;

import javax.swing.JComponent;

public class MyCanvas extends JComponent {

	public void paint(Graphics g) {
		g.drawRect(10, 10, 50, 100);
	}
}
