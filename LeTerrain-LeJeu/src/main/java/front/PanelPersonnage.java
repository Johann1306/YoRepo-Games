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

import core.LieuManager;
import core.MenuManager;
import core.MusiqueManager;
import core.configuration.Constante;
import modele.evenement.EvenementTheme;
import modele.item.media.audio.Musique;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class PanelPersonnage extends JPanel {
	
	// Recuperation des  personnages principaux

	private JButton boutonNicolas = null;
	private JButton boutonPierre = null;
	private JButton boutonYannick = null;
	private JButton boutonThomas = null;
	private JButton boutonJohann = null;
	private JButton boutonAli = null;
	private JButton boutonGuillaume = null;
	private JButton boutonJonathan = null;
	private JButton boutonGroupe = null;
	private static List<JButton> boutons = null;
	
	public PanelPersonnage() {
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxlayout);
		
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		PersonnagePrincipal nicolas = leGroupe.getPersoByNom(PersoPrenom.Nicolas);
		PersonnagePrincipal pierre = leGroupe.getPersoByNom(PersoPrenom.Pierre);
		PersonnagePrincipal yannick = leGroupe.getPersoByNom(PersoPrenom.Yannick);
		PersonnagePrincipal thomas = leGroupe.getPersoByNom(PersoPrenom.Thomas);
		PersonnagePrincipal johann = leGroupe.getPersoByNom(PersoPrenom.Johann);
		PersonnagePrincipal ali = leGroupe.getPersoByNom(PersoPrenom.Ali);
		PersonnagePrincipal guillaume = leGroupe.getPersoByNom(PersoPrenom.Guillaume);
		PersonnagePrincipal jonathan = leGroupe.getPersoByNom(PersoPrenom.Jonathan);

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
		
		boutonNicolas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonPierre.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonYannick.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonThomas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonJohann.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonAli.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonGuillaume.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonJonathan.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		// TODO
		//		boutonGroupe.setMinimumSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()/2));
		boutonGroupe.setMaximumSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
	
		boutonNicolas.setToolTipText(PersoPrenom.Nicolas + " " + PersoNom.LOPEZ);
		boutonPierre.setToolTipText(PersoPrenom.Pierre + " " + PersoNom.SERMAIN);
		boutonYannick.setToolTipText(PersoPrenom.Yannick + " " + PersoNom.BERCOT);
		boutonThomas.setToolTipText(PersoPrenom.Thomas + " " + PersoNom.DARMOUNI);
		boutonJohann.setToolTipText(PersoPrenom.Johann + " " + PersoNom.AVELINE);
		boutonAli.setToolTipText(PersoPrenom.Ali + " " + PersoNom.CHAUDHRY);
		boutonGuillaume.setToolTipText(PersoPrenom.Guillaume + " " + PersoNom.BURGUET);
		boutonJonathan.setToolTipText(PersoPrenom.Jonathan + " " + PersoNom.RUSCITO);
		boutonGroupe.setToolTipText("Le groupe");
		
		PanelCentre panelCentre = MainFrame.getPanelCentre();
		CardLayout cardLayout = panelCentre.getCardLayout();
		PanelBas panelBas = MainFrame.getPanelBas();
		MenuManager menuManager = MenuPrincipal.getMainFrame().getCoreManager().getMenuManager();
		
		// Gestion lien entre boutons Persos et la fenetre centrales
		boutonNicolas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Nicolas.name());
				// TODO : essayer de ne pas rafraichir
				panelBas.refreshPanelBas(PersoPrenom.Nicolas);
				menuManager.lanceRefreshMenu();
				
			}
		});
		boutonPierre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Pierre.name());
				panelBas.refreshPanelBas(PersoPrenom.Pierre);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonYannick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Yannick.name());
				panelBas.refreshPanelBas(PersoPrenom.Yannick);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonThomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Thomas.name());
				panelBas.refreshPanelBas(PersoPrenom.Thomas);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonJohann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Johann.name());
				panelBas.refreshPanelBas(PersoPrenom.Johann);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonAli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Ali.name());
				panelBas.refreshPanelBas(PersoPrenom.Ali);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonGuillaume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Guillaume.name());
				panelBas.refreshPanelBas(PersoPrenom.Guillaume);			
				menuManager.lanceRefreshMenu();
			}
		});
		boutonJonathan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Jonathan.name());
				panelBas.refreshPanelBas(PersoPrenom.Jonathan);			
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
		
		initialiseListeBoutons();
		
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
		
//		refreshArriveePersonnage();
	}

	private void initialiseListeBoutons() {
		boutons = new ArrayList<JButton>();
		boutons.add(boutonNicolas);
		boutons.add(boutonPierre);
		boutons.add(boutonYannick);
		boutons.add(boutonThomas);
		boutons.add(boutonJohann);
		boutons.add(boutonAli);
		boutons.add(boutonGuillaume);
		boutons.add(boutonJonathan);
	}
	
	// Gestion de l arrivee des personnages dans le groupe
	public void refreshArriveePersonnage() {
		//TODO : arreter refresh quand full persos
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		if (leGroupe != null) {
			for (PersonnagePrincipal perso : leGroupe.getPersos()) {
//				System.out.println(perso.getCompetence().toString());
				if (perso.isAvailable()) {
					// presentation du perso
					if ( boutons != null ) {
						for (JButton bouton : boutons) {
							if (bouton.getName().equals(perso.getPrenom().name()) && !bouton.isVisible()) {
								// affichage du bouton du perso
								bouton.setVisible(true);
						
								if (!perso.isDejaPresente()) {
									// lancer le son arrivee dans le groupe
									MusiqueManager.playSon("sonParDefaut/312-SecretOfMana-ally-joins.mp3");
									// affichage du panneau arrivee
									JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), perso.getPrenom() + " a rejoint le Groupe!", EvenementTheme.ARRIVEE_NOUVEAU_PERSONNAGE.name(), JOptionPane.PLAIN_MESSAGE, perso.getPhotoPrincipal());
									// TODO : Affichage fiche perso
									
									perso.setDejaPresente(true);
								}
							} 
						}
					}
				}
			}
		}
	}
	
	// Gestion des morts dans le groupe
	public void refreshMortsPersonnage() {
		boolean finDuJeu = true;
		// Si un perso est mort on grise son bouton
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		if (leGroupe != null) {
			for (PersonnagePrincipal perso : leGroupe.getPersos()) {
				if (perso.isMort()) {
					if ( boutons != null ) {
						for (JButton bouton : boutons) {
							if (bouton.getName().equals(perso.getPrenom().name())) {
								// On grise le bouton du perso
								bouton.setEnabled(false);
							} 
						}
					}
				} else {
					finDuJeu = false;
				}
			}
			// Test fin du Jeu (Tous les persos sont morts)
			if (finDuJeu) {
				System.out.println("GAME OVER");
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(), "GAME OVER");
				// TODO musique fin jeu
				
				// TODO retour menuPrincipal
			}
		}
		
	}
}
