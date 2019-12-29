package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JViewport;

import core.DateManager;
import core.ImageManager;
import core.MusiqueManager;
import core.configuration.Constante;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;
import modele.item.personnage.action.ActionCombat;

public class PanelFichePerso extends JPanel {

	public PanelFichePerso(String prenomPerso) {
		// On recupere les infos du perso
		PersonnagePrincipal perso = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoByPrenom(prenomPerso);
		
		// On les affiche
		Color couleur = perso.getCouleur();
		int luck = perso.getCompetence().getLuck();
		int exploit = perso.getCompetence().getExploit();
		int technique = perso.getCompetence().getTechnique();
		int endurance = perso.getCompetence().getEndurance();
		int resistance = perso.getCompetence().getResistance();
		int rapidite = perso.getCompetence().getRapidite();
		int agilite = perso.getCompetence().getAgilite();
		int intelligence = perso.getCompetence().getIntelligence();
		int nervosite = perso.getCompetence().getNervosite();

		int luckMax = perso.getCompetenceMax().getLuck();
		int exploitMax = perso.getCompetenceMax().getExploit();
		int techniqueMax = perso.getCompetenceMax().getTechnique();
		int enduranceMax = perso.getCompetenceMax().getEndurance();
		int resistanceMax = perso.getCompetenceMax().getResistance();
		int rapiditeMax = perso.getCompetenceMax().getRapidite();
		int agiliteMax = perso.getCompetenceMax().getAgilite();
		int intelligenceMax = perso.getCompetenceMax().getIntelligence();
		int nervositeMax = perso.getCompetenceMax().getNervosite();

		JPanel panelNord = new JPanel();
		JPanel panelOuest = new JPanel();
		JPanel panelCentre = new JPanel();
		JPanel panelEst = new JPanel();
		JPanel panelSud = new JPanel();
		
		// Photo Vie Mana
		JLabel labelPhoto = new JLabel(perso.getPhotoPrincipal());
		JLabel labelCrados = new JLabel();
		JLabel labelDBZ = new JLabel();
		JLabel labelStarWars = new JLabel();
		
		// Photo Crados
		Map<Item, Integer> sac = perso.getSac();
		Set<Item> keySet = sac.keySet();
		for (Item item : keySet) {
			if (item.getType() == ItemType.CARTE_CRADOS && item.isDisponible()) {
				ImageIcon imageIconProxy = ImageManager.getImageIconProxy(item.getImagePath().get(0));
				ImageIcon resizeImage = ImageManager.resizeImage(imageIconProxy, Constante.CRADOS_IMAGE_DIMENSION_130_180);
				labelCrados.setIcon(resizeImage);
			}
		}
		
		// Photo DBZ
		for (Item item : keySet) {
			if (item.getType() == ItemType.CARTE_DBZ && item.isDisponible()) {
				ImageIcon imageIconProxy = ImageManager.getImageIconProxy(item.getImagePath().get(0));
				ImageIcon resizeImage = ImageManager.resizeImage(imageIconProxy, Constante.DBZ_IMAGE_DIMENSION_130_180);
				labelDBZ.setIcon(resizeImage);
			}
		}
		
		// Photo Star Wars
		for (Item item : keySet) {
			if (item.getType() == ItemType.CARTE_STARWARS && item.isDisponible()) {
				ImageIcon imageIconProxy = ImageManager.getImageIconProxy(item.getImagePath().get(0));
				ImageIcon resizeImage = ImageManager.resizeImage(imageIconProxy, Constante.STARWARS_IMAGE_DIMENSION_130_180);
				labelStarWars.setIcon(resizeImage);
			}
		}
		

		int vie = perso.getVie();
		int vieMax = perso.getVieMax();
		int mana = perso.getMana();
		int manaMax = perso.getManaMax();
		
		JPanel panelVie = new JPanel();
		JPanel panelMana = new JPanel();
		panelVie.setBackground(Color.BLACK);
		panelMana.setBackground(Color.BLACK);
		
		JLabel labelVie = new JLabel("Vie : " + vie + "/" + vieMax);
		labelVie.setFont(Constante.MARIO_FONT_MENU_FICHE);
		labelVie.setForeground(Color.WHITE);
		panelVie.add(labelVie);
		JLabel labelMana = new JLabel("Mana : " + mana + "/" + manaMax);
		labelMana.setFont(Constante.MARIO_FONT_MENU_FICHE);
		labelMana.setForeground(Color.CYAN);
		panelMana.add(labelMana);
		
		JPanel panelPhoto = new JPanel();
		BoxLayout boxlayoutPhoto = new BoxLayout(panelPhoto, BoxLayout.Y_AXIS);
		panelPhoto.setLayout(boxlayoutPhoto);
		panelPhoto.setBackground(couleur);
		
		JPanel panelVieEtMana = new JPanel(new GridLayout(2,1));
		panelVieEtMana.add(panelVie);
		panelVieEtMana.add(panelMana);
		
		JPanel panelPhotoEtVie = new JPanel(new FlowLayout((FlowLayout.LEFT)));
		panelPhotoEtVie.add(labelPhoto);
		panelPhotoEtVie.add(panelVieEtMana);
		panelPhotoEtVie.add(labelCrados);
		panelPhotoEtVie.add(labelDBZ);
		panelPhotoEtVie.add(labelStarWars);
		
		panelPhoto.add(panelPhotoEtVie);
		
		panelPhotoEtVie.setBackground(Color.BLACK);
		panelPhoto.setBackground(Color.BLACK);
		

		
		// Infos
		PersoNom nomFamille = perso.getNomFamille();
		String prenom = perso.getPrenom();
		String surnom = perso.getSurnomPrincipal();
//		List<String> surnoms = perso.getSurnoms();
		Date dateNaissance = perso.getDateNaissance();
		String origines = perso.getOrigines();
		List<String> particularitesPhysique = perso.getParticularitesPhysique();
		List<String> particularitesSocial = perso.getParticularitesSocial();
		// TODO phrases persos deblocables
		List<String> phrasesPerso = perso.getPhrasesPerso();
		List<PersonnageSecondaire> connaissances = perso.getConnaissances();
		
		JPanel panelInfos = new JPanel();
		panelPhoto.add(panelInfos);
//		BoxLayout boxlayoutInfo = new BoxLayout(panelInfos, BoxLayout.Y_AXIS);
//		panelInfos.setLayout(boxlayoutInfo);
		panelInfos.setLayout(new GridLayout(5, 2));
			
		JLabel labelNom2 = new JLabel(nomFamille.name());
		JLabel labelPrenom2 = new JLabel(prenom);
		JLabel labelSurnom2 = new JLabel(surnom);
		JLabel labelNaissance2 = new JLabel(DateManager.getDateFormatee(dateNaissance));
		JLabel labelOrigines2 = new JLabel(origines);
		
		JLabel labelNom = new JLabel("Nom");
		JPanel panelNom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelNom.add(labelNom);
		panelNom.setBackground(Color.BLACK);
		labelNom.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelNom.setForeground(Color.YELLOW);
		labelNom2.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelNom2.setForeground(Color.WHITE);
		panelInfos.add(panelNom);
		panelInfos.add(labelNom2);
		JLabel labelPrenom = new JLabel("Prenom");
		JPanel panelPrenom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelPrenom.add(labelPrenom);
		panelPrenom.setBackground(Color.BLACK);
		labelPrenom.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelPrenom.setForeground(Color.YELLOW);
		labelPrenom2.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelPrenom2.setForeground(Color.WHITE);
		panelInfos.add(panelPrenom);
		panelInfos.add(labelPrenom2);
		JLabel labelSurnom = new JLabel("Surnom");
		JPanel panelSurnom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSurnom.add(labelSurnom);
		panelSurnom.setBackground(Color.BLACK);
		labelSurnom.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelSurnom.setForeground(Color.YELLOW);
		labelSurnom2.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelSurnom2.setForeground(Color.WHITE);
		panelInfos.add(panelSurnom);
		panelInfos.add(labelSurnom2);
		JLabel labelNaissance = new JLabel("Naissance");
		JPanel panelNaissance = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelNaissance.add(labelNaissance);
		panelNaissance.setBackground(Color.BLACK);
		labelNaissance.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelNaissance.setForeground(Color.YELLOW);
		labelNaissance2.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelNaissance2.setForeground(Color.WHITE);
		panelInfos.add(panelNaissance);
		panelInfos.add(labelNaissance2);
		JLabel labelOrigines = new JLabel("Origines");
		JPanel panelOrigines = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelOrigines.add(labelOrigines);
		panelOrigines.setBackground(Color.BLACK);
		labelOrigines.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelOrigines.setForeground(Color.YELLOW);
		labelOrigines2.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
		labelOrigines2.setForeground(Color.WHITE);
		panelInfos.add(panelOrigines);
		panelInfos.add(labelOrigines2);
		
		panelInfos.setBackground(Color.BLACK);
//		panelInfos.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, false));
		
		// Stats
		
		
		JPanel panelStats = new JPanel();
		panelStats.setLayout(new GridLayout(9, 2));
		
		for (PersoStat persoStat : PersoStat.values()) {
			String nomStat = persoStat.toString();
			
			JLabel label = new JLabel(nomStat.substring(0, 1));
			label.setFont(Constante.MARIO_FONT_MENU_FICHE_3);
			label.setForeground(Color.RED);
			
			JLabel label2 = new JLabel(nomStat.substring(1));
			label2.setFont(Constante.MARIO_FONT_MENU_FICHE);
			label2.setForeground(Color.YELLOW);
			
			
			
			JLabel labelValue = new JLabel();
			if (persoStat == PersoStat.LUCK) {
				labelValue.setText(": " + luck + " / " + luckMax); 
			} else if (persoStat == PersoStat.AGILITE) {
				labelValue.setText(": " + agilite + " / " + agiliteMax); 
			} else if (persoStat == PersoStat.ENDURANCE) {
				labelValue.setText(": " + endurance + " / " + enduranceMax); 
			} else if (persoStat == PersoStat.EXPLOIT) {
				labelValue.setText(": " + exploit + " / " + exploitMax); 
			} else if (persoStat == PersoStat.INTELLIGENCE) {
				labelValue.setText(": " + intelligence + " / " + intelligenceMax); 
			} else if (persoStat == PersoStat.NERVOSITE) {
				labelValue.setText(": " + nervosite + " / " + nervositeMax); 
			} else if (persoStat == PersoStat.RAPIDITE) {
				labelValue.setText(": " + rapidite + " / " + rapiditeMax); 
			} else if (persoStat == PersoStat.RESISTANCE) {
				labelValue.setText(": " + resistance + " / " + resistanceMax); 
			} else if (persoStat == PersoStat.TECHNIQUE) {
				labelValue.setText(": " + technique + " / " + techniqueMax); 
			}

			labelValue.setFont(Constante.MARIO_FONT_MENU_FICHE_2);
			labelValue.setForeground(Color.WHITE);
		
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panel.add(label);
			panel.add(label2);
			
			panel.setOpaque(true);

			
			panelStats.add(panel);
			panelStats.add(labelValue);
			panel.setBackground(Color.BLACK);
			panelStats.setBackground(Color.BLACK);
		}
		

//		panelStats.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, false));
		
		JPanel panelArme = new JPanel();
		BoxLayout boxlayoutArme = new BoxLayout(panelArme, BoxLayout.Y_AXIS);
		panelArme.setLayout(boxlayoutArme);
		panelArme.setBackground(Color.BLACK);
		
		if (perso.getArme() != null) {
			ImageIcon imageArme = FenetrePrincipal.getImageIcon(perso.getArme().getImagePath().get(0));
			ImageIcon resizedImage = ImageManager.resizeImage(imageArme, Constante.ARME_IMAGE_DIMENSION_100_100);
			JLabel labelArme = new JLabel(resizedImage);
			Color colorBorder = perso.getArme().getCouleur();
			labelArme.setBorder(BorderFactory.createLineBorder(colorBorder, 3, true));
			labelArme.setToolTipText(perso.getArme().toString());
			panelArme.add(labelArme);
		}
		
		

		BoxLayout boxlayoutCentre = new BoxLayout(panelCentre, BoxLayout.Y_AXIS);
		panelCentre.setLayout(boxlayoutCentre);		
		
		JPanel panelFiche = new JPanel();
		panelFiche.setBackground(couleur);
		
		// Actions combat
		JPanel panelActions = new JPanel();
		panelActions.setLayout(new GridLayout(perso.getActionsCombatDisponibles().size() + 1, 1));	
		
		// Entetes
//		JPanel panelEntetes = new JPanel();
//		panelEntetes.setLayout(new GridLayout(1, 9));
//		panelEntetes.add(new JLabel("Image"));
//		panelEntetes.add(new JLabel("Nom"));
//		panelEntetes.add(new JLabel("Info"));
//		panelEntetes.add(new JLabel("Niveau"));
//		panelEntetes.add(new JLabel("Pogression"));
//		panelEntetes.add(new JLabel("Type Cible"));
//		panelEntetes.add(new JLabel("Type Energie"));
//		panelEntetes.add(new JLabel("Type Sort"));
//		panelEntetes.add(new JLabel("Type Stat"));
//		panelEntetes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		panelActions.add(panelEntetes);
//		
//		for (ActionCombat actionCombat : perso.getActionsCombatDisponibles()) {
//			
//			JPanel panelActionCombat = new JPanel();
//			panelActionCombat.setLayout(new GridLayout(1, perso.getActionsCombatDisponibles().size()));
//			
//			JLabel image = new JLabel(ImageManager.resizeImage(FenetrePrincipal.getImageIcon(actionCombat.getImagePath().get(0)), Constante.PERSO_IMAGE_DIMENSION_50_50));
//			JLabel nom = new JLabel(" " + actionCombat.getNom());
//			JLabel info = new JLabel(" " + actionCombat.getInformations());
//			JLabel niveau = new JLabel(" " + actionCombat.getNiveau() + " / " + actionCombat.getNiveauMax());
//			JLabel progression = new JLabel(" " + actionCombat.getProgression() + " / " + actionCombat.getNiveau() * 10);
//			JLabel typeCible = new JLabel(" " + actionCombat.getCibleType().name());
//			JLabel typeEnergie = new JLabel(" " + actionCombat.getEnergieType().name());
//			JLabel typeSort = new JLabel(" " + actionCombat.getSortType().name());
//			JLabel typeStat = new JLabel(" " + actionCombat.getPersoStat().name());
//			
//			panelActionCombat.add(image);
//			panelActionCombat.add(nom);
//			panelActionCombat.add(info);
//			panelActionCombat.add(niveau);
//			panelActionCombat.add(progression);
//			panelActionCombat.add(typeCible);
//			panelActionCombat.add(typeEnergie);
//			panelActionCombat.add(typeSort);
//			panelActionCombat.add(typeStat);
//			
//			panelActionCombat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//			
//			panelActions.add(panelActionCombat);
//		}
//		panelActions.setPreferredSize(panelEntetes.getPreferredSize());
		
		String[] entetes = {"Image", "Nom", "Info", "Niveau", "Pogression", "Type Cible", "Type Energie", "Type Sort", "Type Stat"};

		Object[][] donnees = new Object[perso.getActionsCombatDisponibles().size()][9];
		int i = 0;
		for (ActionCombat actionCombat : perso.getActionsCombatDisponibles()) {
			donnees[i][0] = actionCombat;
			donnees[i][1] = actionCombat.getNom();
			donnees[i][2] = actionCombat.getInformations();
			donnees[i][3] = actionCombat.getNiveau() + " / " + actionCombat.getNiveauMax();
			donnees[i][4] = actionCombat.getProgression() + " / " + actionCombat.getNiveau() * 10;
			donnees[i][5] = actionCombat.getCibleType().name();
			donnees[i][6] = actionCombat.getEnergieType().name();
			donnees[i][7] = actionCombat.getSortType().name();
			donnees[i][8] = actionCombat.getPersoStat().name();			
			i++;
		}
		
		JTable tableau = new JTable(donnees, entetes);
		tableau.setRowHeight(50);;
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableau.getColumnModel().getColumn(0).setCellRenderer(new MyImageCellRenderer());
		tableau.getColumnModel().getColumn(0).setMaxWidth(50);
		tableau.getColumnModel().getColumn(1).setMaxWidth(350);
		tableau.getColumnModel().getColumn(2).setMaxWidth(960);
		tableau.getColumnModel().getColumn(3).setMaxWidth(60);
		tableau.getColumnModel().getColumn(4).setMaxWidth(60);
		tableau.getColumnModel().getColumn(5).setMaxWidth(120);
		tableau.getColumnModel().getColumn(6).setMaxWidth(120);
		tableau.getColumnModel().getColumn(7).setMaxWidth(170);
		tableau.getColumnModel().getColumn(8).setMaxWidth(100);
		
		panelFiche.add(panelPhoto);
//		panelFiche.add(panelInfos);
		panelFiche.add(panelStats);
		panelFiche.add(panelArme);
		
		panelPhoto.setBorder(BorderFactory.createLineBorder(couleur, 5, true));
		panelFiche.setBackground(Color.BLACK);
        
        panelCentre.add(panelFiche);
//        panelCentre.add(panelActions);
        panelCentre.add(tableau.getTableHeader());
        panelCentre.add(tableau);
        
		JPanel panelBoutonCarte = new JPanel();
		panelBoutonCarte.setOpaque(false);
		addBoutonCarte(panelCentre, panelBoutonCarte);
		
		panelOuest.setBackground(couleur);
		panelCentre.setBackground(couleur);
		panelNord.setBackground(couleur);
		panelEst.setBackground(couleur);
		panelSud.setBackground(couleur);
		
		// Gestion scroll dragged panel centre
		Moustener moustener = new Moustener(this);
		MainFrame.getScrollPaneCentre().getViewport().addMouseMotionListener(moustener);
		MainFrame.getScrollPaneCentre().getViewport().addMouseListener(moustener);

		this.setLayout(new BorderLayout());
		this.add(panelNord, BorderLayout.NORTH);
		this.add(panelOuest, BorderLayout.WEST);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelEst, BorderLayout.EAST);
		this.add(panelSud, BorderLayout.SOUTH);
	}
	
	private class Moustener extends MouseAdapter {
		
		// TODO probleme curseur qui s'affiche quand il veut
	    private final Cursor defCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
	    private final Cursor hndCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	    private final Point pp = new Point();
	    private JPanel panel;

	    public Moustener(JPanel panel) {
	        this.panel = panel;
	    }
		
		@Override
		public void mouseDragged(MouseEvent e) {
	        JViewport vport = (JViewport)e.getSource();
	        Point cp = e.getPoint();
	        Point vp = vport.getViewPosition();
	        vp.translate(pp.x-cp.x, pp.y-cp.y);
	        panel.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
	        pp.setLocation(cp);
		}
		
		public void mousePressed(MouseEvent e) {
	        panel.setCursor(hndCursor);
	        pp.setLocation(e.getPoint());
	    }

	    public void mouseReleased(MouseEvent e) {
	        panel.setCursor(defCursor);
	        panel.repaint();
	    }
	}
	
	private void addBoutonCarte(JComponent panel, JPanel panelBouton) {
		JButton boutonCarte = new JButton("Retour Carte");
		boutonCarte.setFont(Constante.SIMPSON_FONT);
		boutonCarte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MusiqueManager.playSon("sonParDefaut/boutonRetour.mp3");
				panel.removeAll();
				PanelCentre panelCentre = MainFrame.getPanelCentre();
				panelCentre.refreshPanelCourant();
				revalidate();
			}
		});
		panelBouton.add(boutonCarte);
		panelBouton.setLocation(-880, 0);
		panel.add(panelBouton, Integer.valueOf(2));
	}

}
