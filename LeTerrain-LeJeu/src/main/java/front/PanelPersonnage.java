package front;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.MenuManager;
import core.MusiqueManager;
import core.PersonnageManager;
import core.configuration.Constante;
import modele.evenement.EvenementTheme;
import modele.item.media.audio.Musique;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class PanelPersonnage extends JPanel {
	
	// Recuperation des  personnages principaux

//	private ImageIcon iconNicolas = null;
//	private ImageIcon iconPierre = null;
//	private ImageIcon iconYannick = null;
//	private ImageIcon iconThomas = null;
//	private ImageIcon iconJohann = null;
//	private ImageIcon iconAli = null;
//	private ImageIcon iconGuillaume = null;
//	private ImageIcon iconJonathan = null;

	private static JButton boutonNicolas = null;
	private static JButton boutonPierre = null;
	private static JButton boutonYannick = null;
	private static JButton boutonThomas = null;
	private static JButton boutonJohann = null;
	private static JButton boutonAli = null;
	private static JButton boutonGuillaume = null;
	private static JButton boutonJonathan = null;
	private static JButton boutonGroupe = null;
	private static List<JButton> boutons = null;
	
	public PanelPersonnage() {
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxlayout);
		
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		PersonnagePrincipal nicolas = leGroupe.getPersoByNom(PersoPrenom.NICOLAS);
		PersonnagePrincipal pierre = leGroupe.getPersoByNom(PersoPrenom.PIERRE);
		PersonnagePrincipal yannick = leGroupe.getPersoByNom(PersoPrenom.YANNICK);
		PersonnagePrincipal thomas = leGroupe.getPersoByNom(PersoPrenom.THOMAS);
		PersonnagePrincipal johann = leGroupe.getPersoByNom(PersoPrenom.JOHANN);
		PersonnagePrincipal ali = leGroupe.getPersoByNom(PersoPrenom.ALI);
		PersonnagePrincipal guillaume = leGroupe.getPersoByNom(PersoPrenom.GUILLAUME);
		PersonnagePrincipal jonathan = leGroupe.getPersoByNom(PersoPrenom.JONATHAN);

		boutonNicolas = new JButton(nicolas.getPhotoPrincipal());
		boutonPierre = new JButton(pierre.getPhotoPrincipal());
		boutonYannick = new JButton(yannick.getPhotoPrincipal());
		boutonThomas = new JButton(thomas.getPhotoPrincipal());
		boutonJohann = new JButton(johann.getPhotoPrincipal());
		boutonAli = new JButton(ali.getPhotoPrincipal());
		boutonGuillaume = new JButton(guillaume.getPhotoPrincipal());
		boutonJonathan = new JButton(jonathan.getPhotoPrincipal());
		boutonGroupe = new JButton("GROUPE");
		
		boutonNicolas.setName(nicolas.getPrenom().name());
		boutonPierre.setName(pierre.getPrenom().name());
		boutonYannick.setName(yannick.getPrenom().name());
		boutonThomas.setName(thomas.getPrenom().name());
		boutonJohann.setName(johann.getPrenom().name());
		boutonAli.setName(ali.getPrenom().name());
		boutonGuillaume.setName(guillaume.getPrenom().name());
		boutonJonathan.setName(jonathan.getPrenom().name());
		
		boutonNicolas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonPierre.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonYannick.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonThomas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonJohann.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonAli.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonGuillaume.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonJonathan.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		// TODO
		//		boutonGroupe.setMinimumSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()/2));
		boutonGroupe.setMaximumSize(Constante.PERSO_IMAGE_DIMENSION);
	
		boutonNicolas.setToolTipText(PersoPrenom.NICOLAS + " " + PersoNom.LOPEZ);
		boutonPierre.setToolTipText(PersoPrenom.PIERRE + " " + PersoNom.SERMAIN);
		boutonYannick.setToolTipText(PersoPrenom.YANNICK + " " + PersoNom.BERCOT);
		boutonThomas.setToolTipText(PersoPrenom.THOMAS + " " + PersoNom.DARMOUNI);
		boutonJohann.setToolTipText(PersoPrenom.JOHANN + " " + PersoNom.AVELINE);
		boutonAli.setToolTipText(PersoPrenom.ALI + " " + PersoNom.CHAUDHRY);
		boutonGuillaume.setToolTipText(PersoPrenom.GUILLAUME + " " + PersoNom.BURGUET);
		boutonJonathan.setToolTipText(PersoPrenom.JONATHAN + " " + PersoNom.RUSCITO);
		boutonGroupe.setToolTipText("Le groupe");
		
		PanelCentre panelCentre = MainFrame.getPanelCentre();
		CardLayout cardLayout = panelCentre.getCardLayout();
		PanelBas panelBas = MainFrame.getPanelBas();
		MenuManager menuManager = MenuPrincipal.getMainFrame().getCoreManager().getMenuManager();
		
		// Gestion lien entre boutons Persos et la fenetre centrales
		boutonNicolas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.NICOLAS.name());
				// TODO : essayer de ne pas rafraichir
				panelBas.refreshPanelBas(PersoPrenom.NICOLAS);
				menuManager.lanceRefreshMenu();
			}
		});
		boutonPierre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.PIERRE.name());
				panelBas.refreshPanelBas(PersoPrenom.PIERRE);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonYannick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.YANNICK.name());
				panelBas.refreshPanelBas(PersoPrenom.YANNICK);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonThomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.THOMAS.name());
				panelBas.refreshPanelBas(PersoPrenom.THOMAS);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonJohann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.JOHANN.name());
				panelBas.refreshPanelBas(PersoPrenom.JOHANN);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonAli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.ALI.name());
				panelBas.refreshPanelBas(PersoPrenom.ALI);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonGuillaume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.GUILLAUME.name());
				panelBas.refreshPanelBas(PersoPrenom.GUILLAUME);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonJonathan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.JONATHAN.name());
				panelBas.refreshPanelBas(PersoPrenom.JONATHAN);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.GROUPE.name());
				panelBas.refreshPanelBas(PersoPrenom.GROUPE);			
				menuManager.lanceRefreshMenu();
			}
		});
		
		boutonNicolas.setVisible(false);
		boutonPierre.setVisible(false);
		boutonYannick.setVisible(false);
		boutonThomas.setVisible(false);
		boutonJohann.setVisible(false);
		boutonAli.setVisible(false);
		boutonGuillaume.setVisible(false);
		boutonJonathan.setVisible(false);
		
		boutons = new ArrayList<JButton>();
		boutons.add(boutonNicolas);
		boutons.add(boutonPierre);
		boutons.add(boutonYannick);
		boutons.add(boutonThomas);
		boutons.add(boutonJohann);
		boutons.add(boutonAli);
		boutons.add(boutonGuillaume);
		boutons.add(boutonJonathan);
		
//		JPanel panelVide = new JPanel();
//		panelVide.setBackground(Color.RED);
//		Dimension d = new Dimension(0, 5);
//		panelVide.setSize(d);
		
		this.add(boutonGroupe);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonNicolas);
		//		this.add(panelVide);
		this.add(boutonPierre);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonYannick);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonThomas);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonJohann);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonAli);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonGuillaume);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonJonathan);
		
//		refreshPanelPersonnage();
	}
	
	// Gestion de l arrivee des personnages dans le groupe
	public static void refreshArriveePersonnage() {
		//TODO : arreter refresh quand full persos
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		if (leGroupe != null) {
			for (PersonnagePrincipal perso : leGroupe.getPersos()) {
	//			System.out.println(perso.getCompetence().toString());
				if (perso.isAvailable()) {
					if ( boutons != null ) {
						for (JButton bouton : boutons) {
							if (bouton.getName().equals(perso.getPrenom().name()) && !bouton.isVisible()) {
								// affichage du bouton du perso
								bouton.setVisible(true);
								// lancer le son arrivee dans le groupe
								MusiqueManager.play(new Musique("src/main/resources/sonParDefaut/312-SecretOfMana-ally-joins.mp3"));
								// affichage du panneau arrivee
								JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), perso.getPrenom() + " a rejoint le Groupe!", EvenementTheme.ARRIVEE_NOUVEAU_PERSONNAGE.name(), JOptionPane.PLAIN_MESSAGE, perso.getPhotoPrincipal());
							} 
						}
					}
				}
			}
		}
	}
}
