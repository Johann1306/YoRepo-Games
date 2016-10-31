package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import core.CoreManager;
import core.MenuManager;
import core.configuration.Constante;
import modele.item.mission.enums.MissionDifficulty;

//public class MainFrame extends JFrame implements KeyListener {
public class MainFrame extends JFrame {

	private static PanelHaut panelHaut = new PanelHaut();
	private static JPanel panelGauche = new JPanel();
	private static PanelCentre panelCentre = new PanelCentre();
	private static JPanel panelDroite = new JPanel();
	private static PanelBas panelBas = new PanelBas();
	private static PanelPersonnage panelPersonnage;
	
	private CoreManager coreManager;
	
	private static JPanel content = null;

	// Nouvelle Partie
	public MainFrame(MissionDifficulty missionDifficulty) {
		super();
		coreManager = new CoreManager(missionDifficulty);
		coreManager.initialise();
		panelHaut = new PanelHaut();
		panelGauche = new JPanel();
		panelCentre = new PanelCentre();
		panelDroite = new JPanel();
		panelBas = new PanelBas();
//	    addKeyListener(this);
	}

	// Chargement Partie
	public MainFrame(CoreManager manager) {
		// TODO : virer super ?
		super();
		coreManager = manager;
		MenuManager menuManager = new MenuManager();
		menuManager.initialise();
		coreManager.setMenuManager(menuManager);
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
//      setUndecorated(true);
		
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
		
		panelPersonnage = new PanelPersonnage();
		PanelMusique panelMusique = new PanelMusique();
		panelMusique.generePanelMusique();

		// Gestion des JPanel de la fenetre principale
		panelHaut.setBackground(Color.RED);
		panelGauche.setBackground(Color.BLACK);	
		panelCentre.setBackground(Color.YELLOW);	
		panelDroite.setBackground(Color.GREEN);	
		panelBas.setBackground(Color.GRAY);
		
//		panelGauche.setPreferredSize(new Dimension(Constante.PANEL_GAUCHE_LARGEUR, Constante.PANEL_GAUCHE_MAX_HAUTEUR));

//		panelGauche.add(panelPersonnage);
		panelDroite.add(panelMusique);

		// Gestion de la fenetre principale
		
		// ScrollPane Panel Gauche
		// TODO : decalage de la fenetre horizontalement
		JScrollPane scrollPaneGauche = new JScrollPane();
		scrollPaneGauche.setHorizontalScrollBar(null);
		scrollPaneGauche.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// Vitesse de la barre de scroll
		JScrollBar jScrollBarPersos = new JScrollBar(1, 5, 5, 0, 10);
		jScrollBarPersos.setUnitIncrement(50);
		scrollPaneGauche.setVerticalScrollBar(jScrollBarPersos);
		scrollPaneGauche.getViewport().add(panelPersonnage);
		
		// ScrollPane Panel Centre
		JScrollPane scrollPaneCentre = new JScrollPane();
		// Vitesse de la barre de scroll
		// TODO : trop rapide
		JScrollBar jScrollBarCentre = new JScrollBar(1, 5, 5, 0, 10);
		jScrollBarCentre.setUnitIncrement(50);
		scrollPaneCentre.setVerticalScrollBar(jScrollBarCentre);
		scrollPaneCentre.getViewport().add(panelCentre);
		
		// TODO : autoscrolls sur les bords
//		scrollPaneCentre.setAutoscrolls(true);
		
		// Gestion Panel video
		
		// Ajout a la frame principale
		content = new JPanel();		
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
	
	public static PanelPersonnage getPanelPersonnage(){
		return panelPersonnage;
	}
	
	public CoreManager getCoreManager() {
		return coreManager;
	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		System.out.println("KeyTyped");				
//	}
//	
//	@Override
//	public void keyReleased(KeyEvent e) {
//		System.out.println("KeyTyped");				
//	}
//	
//	@Override
//	public void keyPressed(KeyEvent e) {
//		System.out.println("KeyTyped");				
//	}

}
