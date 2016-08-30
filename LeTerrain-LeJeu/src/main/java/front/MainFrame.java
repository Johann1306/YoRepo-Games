package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import core.CoreManager;
import core.DateManager;
import core.EvenementManager;
import core.ItemManager;
import core.MenuManager;
import core.configuration.Constante;

public class MainFrame extends JFrame implements Serializable {

	private static PanelHaut panelHaut = new PanelHaut();
	private static JPanel panelGauche = new JPanel();
	private static PanelCentre panelCentre = new PanelCentre();
	private static JPanel panelDroite = new JPanel();
	private static PanelBas panelBas = new PanelBas();
	
	private CoreManager coreManager;

	public MainFrame() {
		coreManager = new CoreManager();
		coreManager.initialise();
		panelHaut = new PanelHaut();
		panelGauche = new JPanel();
		panelCentre = new PanelCentre();
		panelDroite = new JPanel();
		panelBas = new PanelBas();
	}

	public MainFrame(CoreManager manager) {
		coreManager = manager;
		panelHaut = new PanelHaut();
		panelGauche = new JPanel();
		panelCentre = new PanelCentre();
		panelDroite = new JPanel();
		panelBas = new PanelBas();
	}

	public void startMainFrame() {
		
		// Configuration de la fenetre principale
		setTitle("Le Terrain - Le Jeu");
//		setFont(Constante.PRESS_START_FONT);
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		pack();
//		setResizable(false);
//		setAlwaysOnTop(true);
//		createBufferStrategy(2);
		
		// Gestion de la barre de menu
		setJMenuBar(coreManager.getMenuManager());
		
		// Initialisation des sous Panel ordonnee
		panelCentre.generePanelCentre();
		panelHaut.generePanelHaut();
		panelBas.generePanelBas();
		
		JPanel panelPersonnage = new PanelPersonnage();
		PanelMusique panelMusique = new PanelMusique();
		panelMusique.generePanelMusique();

		// Gestion des JPanel de la fenetre principale
		panelHaut.setBackground(Color.RED);
		panelGauche.setBackground(Color.BLACK);	
		panelCentre.setBackground(Color.YELLOW);	
		panelDroite.setBackground(Color.GREEN);	
		panelBas.setBackground(Color.GRAY);
		
		panelGauche.setPreferredSize(new Dimension(Constante.PANEL_GAUCHE_LARGEUR, Constante.PANEL_GAUCHE_MAX_HAUTEUR));

		panelGauche.add(panelPersonnage);
		panelDroite.add(panelMusique);

		// Gestion de la fenetre principale
		
		// ScrollPane Panel Gauche
		// TODO : decalage de la fenetre horizontalement
		JScrollPane scrollPaneGauche = new JScrollPane();
		scrollPaneGauche.setHorizontalScrollBar(null);
		scrollPaneGauche.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// Vitesse de la barre de scroll
		JScrollBar jScrollBarPersos = new JScrollBar(1, 5, 5, 0, 10);
		jScrollBarPersos.setUnitIncrement(30);
		scrollPaneGauche.setVerticalScrollBar(jScrollBarPersos);
		scrollPaneGauche.getViewport().add(panelGauche);
		
		// ScrollPane Panel Centre
		JScrollPane scrollPaneCentre = new JScrollPane();
		scrollPaneCentre.getViewport().add(panelCentre);
		// TODO : autoscrolls sur les bords
		//scrollPaneCentre.setAutoscrolls(true);
		
		// Gestion Panel video
		
		// Ajout a la frame principale
		final JPanel content = new JPanel();		
		content.setLayout(new BorderLayout());
		content.add(scrollPaneGauche, BorderLayout.WEST);
		content.add(panelHaut, BorderLayout.NORTH);
		content.add(scrollPaneCentre, BorderLayout.CENTER);
		content.add(panelDroite, BorderLayout.EAST);
		// TODO JScrollPane
		content.add(panelBas, BorderLayout.SOUTH);
		
		// Ajout dans la fenetre
		getContentPane().add(content);
		//pack();
		this.setVisible(true);

	}
	
//	public static PanelCentre getPanelHaut(){
//		return panelHaut;
//	}
//	
//	public static PanelCentre getPanelGauche(){
//		return panelGauche;
//	}
	

	public static PanelCentre getPanelCentre(){
		return panelCentre;
	}
	
	public static JPanel getPanelDroite(){
		return panelDroite;
	}
	
	public static PanelBas getPanelBas(){
		return panelBas;
	}
	
	
	public CoreManager getCoreManager() {
		return coreManager;
	}

}
