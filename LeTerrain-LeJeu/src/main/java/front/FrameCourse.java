package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.configuration.Constante;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;
import modele.jeu.vehicule.Vehicule;

public class FrameCourse extends JFrame {
	
	private Vehicule vehicule1;
	
	public FrameCourse() {
		
		// Configuration de la fenetre
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		
		JPanel panelNord = new JPanel();
		JPanel panelOuest = new JPanel();
		JPanel panelCentre = new JPanel();
		JPanel panelEst = new JPanel();
		JPanel panelSud = new JPanel();
		
		vehicule1 = new Vehicule(new Point(100, 100), 0, 0, 30, 10, 1, 2); 
		
		// Gestion Panel Centre
		panelCentre.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("KeyTyped : " + e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_Z) {
					// Arreter d'avancer / freiner progressivement
					System.out.println("Arreter d'avancer / freiner progressivement");
					vehicule1.freineLentement();
				} else if(e.getKeyCode() == KeyEvent.VK_S) {
					// Arreter de freiner / freiner progressivement
					System.out.println("Arreter de freiner / freiner progressivement");
					vehicule1.freineLentement();
				} else if(e.getKeyCode() == KeyEvent.VK_Q) {
					// Arreter de tourner a Gauche / direction devant
					System.out.println("Arreter de freiner / freiner progressivement");
					vehicule1.freineLentement();
				} else if(e.getKeyCode() == KeyEvent.VK_D) {
					// Arreter de tourner a Droite / direction devant
					System.out.println("Arreter de freiner / freiner progressivement");
					vehicule1.freineLentement();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_Z) {
					// Avancer
					System.out.println("Avancer");
					vehicule1.avance();
				} else if(e.getKeyCode() == KeyEvent.VK_S) {
					// Freiner
					System.out.println("Freiner");
					vehicule1.freine();
				} else if(e.getKeyCode() == KeyEvent.VK_Q) {
					// Tourner a Gauche
					System.out.println("Tourner a Gauche");
					vehicule1.tourneGauche();
				} else if(e.getKeyCode() == KeyEvent.VK_D) {
					// Tourner a Droite
					System.out.println("Tourner a Droite");
					vehicule1.tourneDroite();				}
			}
		});
		
		this.setAlwaysOnTop(true);
		this.setSize(Constante.FENETRE_COURSE_DIMENSION);
		this.setMinimumSize(Constante.FENETRE_COURSE_DIMENSION);  
		centreFenetre();
		
		panelNord.setBackground(Color.BLACK);
		panelOuest.setBackground(Color.RED);
		panelCentre.setBackground(Color.WHITE);
		panelEst.setBackground(Color.GREEN);
		panelSud.setBackground(Color.BLUE);
		
		content.add(panelNord, BorderLayout.NORTH);
		content.add(panelOuest, BorderLayout.WEST);
		content.add(panelCentre, BorderLayout.CENTER);
		content.add(panelEst, BorderLayout.EAST);
		content.add(panelSud, BorderLayout.SOUTH);
		
		this.setContentPane(content);
		this.setVisible(true);
	}
	
	public void start(Groupe groupe, Mission mission) {

		boolean win = false;
		boolean termine = false;
		
		// Jeu de course
		while (!termine) {
			System.out.println("Dans la boucle infini");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
			// Refresh Panel Centre

			
			// Si Termine / Si vehicule est dans la zone de fin
//			if (vehicule1.contains(arrivee)) {
//				termine = true;
//				if (vehicule1.isFirst()) {
//					win = true;
//				}
//			}
			
			
		}
		System.out.println("Sortie de la boucle infini");

		// Suppression de la Fenetre
		this.setVisible(false);
		this.dispose();
	}

	private void centreFenetre() {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	}
}
