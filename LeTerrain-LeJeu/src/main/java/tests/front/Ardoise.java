package tests.front;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
class Ardoise extends JPanel implements ActionListener {
	private Timer declencheur;
	private Random alea;
	private Image terre;
	private int largeur = 400, hauteur = 200;
	private int r, v, b;
	private int x; // abscisse du coin supérieur gauche de l'image
	private int largeurImage = 50; // largeur de l'image
	private int hauteurImage = 50; // hauteur de l'image
	private Rectangle vieuxRectangle;

	Ardoise() {
		setPreferredSize(new Dimension(largeur, hauteur));
		setBackground(Color.BLUE);
		alea = new Random();
		getCouleurs();
		x = - largeurImage - 5;
		try {
			terre = ImageIO.read(new File("src/main/resources/image/ali.png"));
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}
		x = - largeurImage - 5;
		vieuxRectangle = new Rectangle(0, 0, 0, 0); 
		declencheur = new Timer(100, this);
		declencheur.start();
	}

	void getCouleurs() {
		r = Math.abs(alea.nextInt()) % 256;
		v = Math.abs(alea.nextInt()) % 256;
		b = Math.abs(alea.nextInt()) % 256;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == declencheur) {
			x += 5;
			if (x > getWidth()) x = - largeurImage;

			/* on calcule l'union de l'ancien rectangle
			* contenant l'image et du nouveau rectangle */
			Rectangle nouveauRectangle = new Rectangle(x, getHeight()/3, largeurImage , hauteurImage);
			Rectangle rect = nouveauRectangle.union(vieuxRectangle);
			vieuxRectangle = nouveauRectangle;

			/* on repeint uniquement l'union des rectangles */
			repaint(rect.x, rect.y, rect.width, rect.height);
		}

		else {
			String commande = e.getActionCommand();
			if (commande.equals("arreter"))declencheur.stop();
			else if (commande.equals("reprendre")) declencheur.restart();
			else if (commande.equals("changerCouleurs")) {
				getCouleurs();
				repaint();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		largeur = getWidth();
		hauteur = getHeight();
		for (int i = 0 ; i < largeur; i++) {
			g.setColor(new Color((r + i / 3) % 255, (v + i) % 255, (b + i / 2 )% 255));
			g.drawArc(i, i, largeur - 2 * i, 2*hauteur - 2 * i, 0, 180);
		}
		if (terre != null) g.drawImage(terre, x, getHeight()/3,
 largeurImage, hauteurImage, this);
	}
	
	public static void main(String[] arg) {
		JFrame fenetre = new JFrame();
		fenetre.setContentPane(new IHMMouvement());
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
	}
}

@SuppressWarnings("serial")
class IHMMouvement extends JPanel implements ActionListener {
	private JButton arret = new JButton("arret");
	private JButton reprise = new JButton("reprendre");
	private JButton couleurs = new JButton("couleurs");
	private Ardoise ardoise = new Ardoise();

	IHMMouvement() {
		arret.setActionCommand("arreter");
		arret.addActionListener(ardoise);
		arret.addActionListener(this);

		reprise.setActionCommand("reprendre");
		reprise.addActionListener(ardoise);
		reprise.addActionListener(this);
		reprise.setEnabled(false);

		couleurs.setActionCommand("changerCouleurs");
		couleurs.addActionListener(ardoise);

		JPanel boutons = new JPanel();		
		boutons.setBackground(Color.BLUE);
		boutons.add(arret);
		boutons.add(reprise);
		boutons.add(couleurs);

		setLayout(new BorderLayout());
		add(boutons, BorderLayout.NORTH);
		add(ardoise, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("arreter")) {
			arret.setEnabled(false);
			reprise.setEnabled(true);
		}

		else if (e.getActionCommand().equals("reprendre")) {
			arret.setEnabled(true);
			reprise.setEnabled(false);
		}
	}

}