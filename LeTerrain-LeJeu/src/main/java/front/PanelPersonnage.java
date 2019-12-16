package front;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.CoreManager;
import core.ItemManager;
import core.MenuManager;
import core.MusiqueManager;
import core.PersonnageManager;
import core.VideoManager;
import core.configuration.Constante;
import modele.competence.PersoStat;
import modele.evenement.EvenementTheme;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.media.audio.Musique;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class PanelPersonnage extends JPanel {
	
	// Recuperation des personnages principaux

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
		
		boutonNicolas.setName(nicolas.getPrenom());
		boutonPierre.setName(pierre.getPrenom());
		boutonYannick.setName(yannick.getPrenom());
		boutonThomas.setName(thomas.getPrenom());
		boutonJohann.setName(johann.getPrenom());
		boutonAli.setName(ali.getPrenom());
		boutonGuillaume.setName(guillaume.getPrenom());
		boutonJonathan.setName(jonathan.getPrenom());
		
		boutonNicolas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonPierre.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonYannick.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonThomas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonJohann.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonAli.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonGuillaume.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);
		boutonJonathan.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_180_180);

		// TODO bouton groupe
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
				panelBas.refreshPanelBas(PersoPrenom.Nicolas);
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
				gestionItemSelectionne(PersoPrenom.Nicolas);
				MusiqueManager.stopAll();
				MusiqueManager.startPlayListPerso(PersoPrenom.Nicolas);
			}
		});
		boutonPierre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Pierre.name());
				panelBas.refreshPanelBas(PersoPrenom.Pierre);			
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
				gestionItemSelectionne(PersoPrenom.Pierre);
				MusiqueManager.stopAll();
				MusiqueManager.startPlayListPerso(PersoPrenom.Pierre);
			}
		});
		boutonYannick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Yannick.name());
				panelBas.refreshPanelBas(PersoPrenom.Yannick);			
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
				gestionItemSelectionne(PersoPrenom.Yannick);
				MusiqueManager.stopAll();
				MusiqueManager.startPlayListPerso(PersoPrenom.Yannick);
			}
		});
		boutonThomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Thomas.name());
				panelBas.refreshPanelBas(PersoPrenom.Thomas);			
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
				gestionItemSelectionne(PersoPrenom.Thomas);
				MusiqueManager.stopAll();
				MusiqueManager.startPlayListPerso(PersoPrenom.Thomas);
			}
		});
		boutonJohann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Johann.name());
				panelBas.refreshPanelBas(PersoPrenom.Johann);			
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
				gestionItemSelectionne(PersoPrenom.Johann);
				MusiqueManager.stopAll();
				MusiqueManager.startPlayListPerso(PersoPrenom.Johann);
			}
		});
		boutonAli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Ali.name());
				panelBas.refreshPanelBas(PersoPrenom.Ali);			
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
				gestionItemSelectionne(PersoPrenom.Ali);
				MusiqueManager.stopAll();
				MusiqueManager.startPlayListPerso(PersoPrenom.Ali);
			}
		});
		boutonGuillaume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Guillaume.name());
				panelBas.refreshPanelBas(PersoPrenom.Guillaume);			
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
				gestionItemSelectionne(PersoPrenom.Guillaume);
				MusiqueManager.stopAll();
				MusiqueManager.startPlayListPerso(PersoPrenom.Guillaume);
			}
		});
		boutonJonathan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.Jonathan.name());
				panelBas.refreshPanelBas(PersoPrenom.Jonathan);			
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
				gestionItemSelectionne(PersoPrenom.Jonathan);
				MusiqueManager.stopAll();
				MusiqueManager.startPlayListPerso(PersoPrenom.Jonathan);
			}
		});
		boutonGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.GROUPE.name());
				panelBas.refreshPanelBas(PersoPrenom.GROUPE);
				gestionItemSelectionne(PersoPrenom.GROUPE);
				menuManager.lanceRefreshMenu();
				panelCentre.refreshPanelCourant();
//				MusiqueManager.stopAll();
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
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
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
				if (perso.isDisponible()) {
					// presentation du perso
					if ( boutons != null ) {
						for (JButton bouton : boutons) {
							if (bouton.getName().equals(perso.getPrenom()) && !bouton.isVisible()) {
								// affichage du bouton du perso
								bouton.setVisible(true);
								revalidate();
								if (!perso.isDejaPresente()) {
									// lancer le son arrivee dans le groupe
									MusiqueManager.playSon("sonParDefaut/312-SecretOfMana-ally-joins.mp3");
									// affichage du panneau arrivee
									JLabel messageLabel = new JLabel(perso.getPrenom() + " a rejoint le Groupe!");
									messageLabel.setFont(Constante.MARIO_FONT_MENU_3);
									JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), messageLabel, EvenementTheme.ARRIVEE_NOUVEAU_PERSONNAGE.getNom(), JOptionPane.PLAIN_MESSAGE, perso.getPhotoPrincipal());
									perso.setDejaPresente(true);
									// Affichage fiche perso
									MainFrame.getPanelCentre().afficheFichePerso(perso.getPrenomPerso().name());

									// Dieu donne la stat prefere du perso avec un message 
									MusiqueManager.playSon("sonParDefaut/defautREZCritique.mp3");									
									ImageIcon iconDieu = FenetrePrincipal.getImageIcon("image/pnj/dieu.png");
									JLabel messageLabel2 = new JLabel(perso.getPrenom() + " : " + perso.getMessageDieu());
									messageLabel2.setFont(Constante.MARIO_FONT_MENU_3);
									JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), messageLabel2, EvenementTheme.INTERVENTION_DIVINE.getNom(), JOptionPane.PLAIN_MESSAGE, iconDieu);
									
									// Demarre une musique d'ambiance 
									MusiqueManager.stopAll();
									List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("musique/reveil", 20000);
									MusiqueManager.playMusiquesRandom(musiques);
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
		CoreManager coreManager = MenuPrincipal.getMainFrame().getCoreManager();
		PersonnageManager personnageManager = coreManager.getPersonnageManager();
		Groupe leGroupe = personnageManager.getLeGroupe();
		if (leGroupe != null) {
			for (PersonnagePrincipal perso : leGroupe.getPersosDejaPresentes()) {
				if (perso.isMort()) {
					if ( boutons != null ) {
						for (JButton bouton : boutons) {
							if (bouton.getName().equals(perso.getPrenom())) {
								// On grise le bouton du perso
								bouton.setEnabled(false);
							} 
						}
					}
				} else {
					if ( boutons != null ) {
						for (JButton bouton : boutons) {
							if (bouton.getName().equals(perso.getPrenom())) {
								// On degrise le bouton du perso
								bouton.setEnabled(true);
							} 
						}
					}
					finDuJeu = false;
				}
			}
			// TODO Fin du Jeu (Tous les persos sont morts)
			if (finDuJeu) {
				System.out.println("GAME OVER");
				
				// Musique fin du jeu
				MusiqueManager.playSon("son/10AlexKid-game-over.mp3");
				
				// Message fin du jeu
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(), "GAME OVER");

				// Retour menuPrincipal
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
				fenetrePrincipal.setVisible(true);
				FenetrePrincipal.joueMusiquesAmbiances();

				// Supprime le panelVideo et la MainFrame
				MenuPrincipal.getMainFrame().dispose();
				VideoManager.hideAndStop();
			} 
			// Sinon on continue en reaffichant le panel d'un perso vivant // ou toujours le panel groupe ???
			else {
				
				// On recupere le perso du panel courant
				PanelCentre panelCentre = MainFrame.getPanelCentre();
				PanelBas panelBas = MainFrame.getPanelBas();
				String prenom = panelCentre.getPanelShowing().getName();
				
				// Si il est mort, on affiche le panel d'un perso vivant
//				System.out.println("PANEL_SHOWING : " + prenom);
				// TODO Nullpointer gestion si panel groupe
				CardLayout cardLayout = panelCentre.getCardLayout();
				if (!prenom.equals(PersoPrenom.GROUPE.name())) {
					PersonnagePrincipal perso = personnageManager.getPersoByPrenom(prenom);
					
					if (perso.isMort()) {
						List<PersonnagePrincipal> persoVivants = personnageManager.getPersoVivants();
						PersonnagePrincipal persoVivant = persoVivants.get(0);
						cardLayout.show(panelCentre, persoVivant.getPrenom());
						panelBas.refreshPanelBas(persoVivant.getPrenomPerso());			
					}
				} else {
					cardLayout.show(panelCentre, prenom);
					panelBas.refreshPanelBas(PersoPrenom.GROUPE);			
				}
				coreManager.getMenuManager().lanceRefreshMenu();
			}
		}
	}
	
	private void gestionItemSelectionne(PersoPrenom prenomCible) {
		ItemManager.gestionItemSelectionne(prenomCible, MainFrame.getPanelCentre().getParent());
	}
}
