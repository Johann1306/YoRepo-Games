package tests.front;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EffetFondu extends JPanel implements ActionListener {

	Image img;
	Timer timer = new Timer(20, this);

	private float alpha = 1f;

	public EffetFondu() {
		img = getImage();
		if (img != null)
			timer.start();
	}

	private Image getImage() // Choisir une image
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Sélectionner une image");
		int returnVal = chooser.showOpenDialog(null);
		String imgURL = "";
		if (returnVal == JFileChooser.APPROVE_OPTION)

		{
			imgURL = chooser.getSelectedFile().getAbsolutePath();
		}
		return new ImageIcon(imgURL).getImage();
	}

	// Afficher l'image sélectionnée dans le frame
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(img, 10, 10, null);
	}

	// Appliquer l'effet fondu sur l'image
	public void actionPerformed(ActionEvent e) {
		alpha += -0.01f;
		if (alpha <= 0) {
			alpha = 0;
			timer.stop();
		}
		repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Animation et Transparence");
		frame.add(new EffetFondu());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 300);
		frame.setVisible(true);
	}

}