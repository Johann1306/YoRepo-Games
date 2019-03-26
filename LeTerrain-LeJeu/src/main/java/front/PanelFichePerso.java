package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

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
import core.configuration.Constante;
import modele.competence.PersoStat;
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
		labelPhoto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

		int vie = perso.getVie();
		int vieMax = perso.getVieMax();
		int mana = perso.getMana();
		int manaMax = perso.getManaMax();
		
		JPanel panelVie = new JPanel();
		JPanel panelMana = new JPanel();
		panelVie.setBackground(couleur);
		panelMana.setBackground(couleur);
		
		panelVie.add(new JLabel("Vie : " + vie + "/" + vieMax));
		panelMana.add(new JLabel("Mana : " + mana + "/" + manaMax));
		
		JPanel panelPhoto = new JPanel();
		BoxLayout boxlayoutPhoto = new BoxLayout(panelPhoto, BoxLayout.Y_AXIS);
		panelPhoto.setLayout(boxlayoutPhoto);
		panelPhoto.setBackground(couleur);
		
		panelPhoto.add(labelPhoto);
		panelPhoto.add(panelVie);
		panelPhoto.add(panelMana);
		
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
//		BoxLayout boxlayoutInfo = new BoxLayout(panelInfos, BoxLayout.Y_AXIS);
//		panelInfos.setLayout(boxlayoutInfo);
		panelInfos.setLayout(new GridLayout(5, 2));
			
		JLabel labelNom = new JLabel(nomFamille.name());
		JLabel labelPrenom = new JLabel(prenom);
		JLabel labelSurnom = new JLabel(surnom);
		JLabel labelNaissance = new JLabel(DateManager.getDateFormatee(dateNaissance));
		JLabel labelOrigines = new JLabel(origines);
		
		panelInfos.add(new JLabel("Nom"));
		panelInfos.add(labelNom);
		panelInfos.add(new JLabel("Prenom"));
		panelInfos.add(labelPrenom);
		panelInfos.add(new JLabel("Surnom"));
		panelInfos.add(labelSurnom);
		panelInfos.add(new JLabel("Naissance"));
		panelInfos.add(labelNaissance);
		panelInfos.add(new JLabel("Origines"));
		panelInfos.add(labelOrigines);
		panelInfos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Stats
		JLabel labelLuck = new JLabel(PersoStat.LUCK.name());
		JLabel labelLuckValue = new JLabel(": " + luck + " / " + luckMax );
		JPanel panelLuck = new JPanel();
		panelLuck.add(labelLuck);
		panelLuck.add(labelLuckValue);
		
		JLabel labelExploit = new JLabel(PersoStat.EXPLOIT.name());
		JLabel labelExploitValue = new JLabel(": " + exploit + " / " + exploitMax );
		JPanel panelExploit = new JPanel();
		panelExploit.add(labelExploit);
		panelExploit.add(labelExploitValue);

		JLabel labelTechnique = new JLabel(PersoStat.TECHNIQUE.name());
		JLabel labelTechniqueValue = new JLabel(": " + technique + " / " + techniqueMax );
		JPanel panelTechnique = new JPanel();
		panelTechnique.add(labelTechnique);
		panelTechnique.add(labelTechniqueValue);

		JLabel labelEndurance = new JLabel(PersoStat.ENDURANCE.name());
		JLabel labelEnduranceValue = new JLabel(": " + endurance + " / " + enduranceMax );
		JPanel panelEndurance = new JPanel();
		panelEndurance.add(labelEndurance);
		panelEndurance.add(labelEnduranceValue);

		JLabel labelResistance = new JLabel(PersoStat.RESISTANCE.name());
		JLabel labelResistanceValue = new JLabel(": " + resistance + " / " + resistanceMax );
		JPanel panelResistance = new JPanel();
		panelResistance.add(labelResistance);
		panelResistance.add(labelResistanceValue);

		JLabel labelRapidite = new JLabel(PersoStat.RAPIDITE.name());
		JLabel labelRapiditeValue = new JLabel(": " + rapidite + " / " + rapiditeMax );
		JPanel panelRapidite = new JPanel();
		panelRapidite.add(labelRapidite);
		panelRapidite.add(labelRapiditeValue);

		JLabel labelAgilite = new JLabel(PersoStat.AGILITE.name());
		JLabel labelAgiliteValue = new JLabel(": " + agilite + " / " + agiliteMax );
		JPanel panelAgilite = new JPanel();
		panelAgilite.add(labelAgilite);
		panelAgilite.add(labelAgiliteValue);

		JLabel labelIntelligence = new JLabel(PersoStat.INTELLIGENCE.name());
		JLabel labelIntelligenceValue = new JLabel(": " + intelligence + " / " + intelligenceMax );
		JPanel panelIntelligence = new JPanel();
		panelIntelligence.add(labelIntelligence);
		panelIntelligence.add(labelIntelligenceValue);

		JLabel labelNervosite = new JLabel(PersoStat.NERVOSITE.name());
		JLabel labelNervositeValue = new JLabel(": " + nervosite + " / " + nervositeMax );
		JPanel panelNervosite = new JPanel();
		panelNervosite.add(labelNervosite);
		panelNervosite.add(labelNervositeValue);
		
		JPanel panelStats = new JPanel();
		panelStats.setLayout(new GridLayout(9, 2));
		
		panelStats.add(labelLuck);
		panelStats.add(labelLuckValue);
		panelStats.add(labelExploit);
		panelStats.add(labelExploitValue);
		panelStats.add(labelTechnique);
		panelStats.add(labelTechniqueValue);
		panelStats.add(labelEndurance);
		panelStats.add(labelEnduranceValue);
		panelStats.add(labelResistance);
		panelStats.add(labelResistanceValue);
		panelStats.add(labelRapidite);
		panelStats.add(labelRapiditeValue);
		panelStats.add(labelAgilite);
		panelStats.add(labelAgiliteValue);
		panelStats.add(labelIntelligence);
		panelStats.add(labelIntelligenceValue);
		panelStats.add(labelNervosite);
		panelStats.add(labelNervositeValue);
		panelStats.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel panelArme = new JPanel();
		BoxLayout boxlayoutArme = new BoxLayout(panelArme, BoxLayout.Y_AXIS);
		panelArme.setLayout(boxlayoutArme);
		panelArme.setBackground(couleur);
		
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
			donnees[i][0] = actionCombat.getImagePath().get(0);
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
		panelFiche.add(panelInfos);
		panelFiche.add(panelStats);
		panelFiche.add(panelArme);
        
        panelCentre.add(panelFiche);
//        panelCentre.add(panelActions);
        panelCentre.add(tableau.getTableHeader());
        panelCentre.add(tableau);
        
		JPanel panelBoutonCarte = new JPanel();
		panelBoutonCarte.setOpaque(false);
		addBoutonCarte(panelCentre, panelBoutonCarte);
		
		panelOuest.setBackground(Color.PINK);
		panelCentre.setBackground(couleur);
		panelNord.setBackground(Color.RED);
		panelEst.setBackground(Color.BLUE);
		panelSud.setBackground(Color.GREEN);
		
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
