package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JViewport;

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
		
		panelVie.add(new JLabel(vie + "/" + vieMax));
		panelMana.add(new JLabel(mana + "/" + manaMax));
		
		JPanel panelPhoto = new JPanel();
		BoxLayout boxlayoutPhoto = new BoxLayout(panelPhoto, BoxLayout.Y_AXIS);
		panelPhoto.setLayout(boxlayoutPhoto);
		
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
		BoxLayout boxlayoutInfo = new BoxLayout(panelInfos, BoxLayout.Y_AXIS);
		panelInfos.setLayout(boxlayoutInfo);
		
		JLabel labelNom = new JLabel(nomFamille.name());
		JLabel labelPrenom = new JLabel(prenom);
		
		panelInfos.add(labelNom);
		panelInfos.add(labelPrenom);
		
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
		BoxLayout boxlayoutStats = new BoxLayout(panelStats, BoxLayout.Y_AXIS);
		panelStats.setLayout(boxlayoutStats);
		
		panelStats.add(panelLuck);
		panelStats.add(panelExploit);
		panelStats.add(panelTechnique);
		panelStats.add(panelEndurance);
		panelStats.add(panelResistance);
		panelStats.add(panelRapidite);
		panelStats.add(panelAgilite);
		panelStats.add(panelIntelligence);
		panelStats.add(panelNervosite);
		
//		Object[][] donnees =  new Object[perso.getActionsCombatDisponibles().size()][9]; 
//		int i = 0;
		
		// Actions combat
		JPanel panelActions = new JPanel();
		BoxLayout boxlayoutActionsCombat = new BoxLayout(panelActions, BoxLayout.Y_AXIS);
		panelActions.setLayout(boxlayoutActionsCombat);		
		for (ActionCombat actionCombat : perso.getActionsCombatDisponibles()) {
			
			JPanel panelActionCombat = new JPanel();
			BoxLayout boxlayoutActionCombat = new BoxLayout(panelActionCombat, BoxLayout.X_AXIS);
			panelActionCombat.setLayout(boxlayoutActionCombat);
			
			JLabel image = new JLabel(ImageManager.resizeImage(FenetrePrincipal.getImageIcon(actionCombat.getImagePath().get(0)), Constante.PERSO_IMAGE_DIMENSION_50_50));
			JLabel nom = new JLabel(" " + actionCombat.getNom());
			JLabel info = new JLabel(" " + actionCombat.getInformations());
			JLabel niveau = new JLabel(" " + actionCombat.getNiveau() + " / " + actionCombat.getNiveauMax());
			JLabel progression = new JLabel(" " + actionCombat.getProgression() + " / " + actionCombat.getNiveau() * 10);
			JLabel typeCible = new JLabel(" " + actionCombat.getCibleType().name());
			JLabel typeEnergie = new JLabel(" " + actionCombat.getEnergieType().name());
			JLabel typeSort = new JLabel(" " + actionCombat.getSortType().name());
			JLabel typeStat = new JLabel(" " + actionCombat.getPersoStat().name());
			
			panelActionCombat.add(image);
			panelActionCombat.add(nom);
			panelActionCombat.add(info);
			panelActionCombat.add(niveau);
			panelActionCombat.add(progression);
			panelActionCombat.add(typeCible);
			panelActionCombat.add(typeEnergie);
			panelActionCombat.add(typeSort);
			panelActionCombat.add(typeStat);
			
			panelActions.add(panelActionCombat);
			
//			Object[] donnee = {ImageManager.resizeImage(FenetrePrincipal.getImageIcon(actionCombat.getImagePath().get(0)), Constante.PERSO_IMAGE_DIMENSION_50_50),
//					actionCombat.getNom(),
//					actionCombat.getInformations(),
//					actionCombat.getNiveau() + " / " + actionCombat.getNiveauMax(),
//					actionCombat.getProgression() + " / " + actionCombat.getNiveau() * 10,
//					actionCombat.getCibleType().name(),
//					actionCombat.getEnergieType().name(),
//					actionCombat.getSortType().name(),
//					actionCombat.getPersoStat().name()}; 
//			donnees[i] = donnee;
//			i++;
		}
		
//        String[] entetes = {"Image", "Nom", "Infos", "Niveau", "Progression", "Cible", "Energie", "Sort", "Stat"};
// 
//        JTable tableau = new JTable(donnees, entetes);
//        tableau.setForeground(Color.WHITE);
//        tableau.setBackground(couleur);
        
        panelCentre.add(panelPhoto);
        panelCentre.add(panelInfos);
        panelCentre.add(panelStats);

//        BoxLayout boxlayoutSud = new BoxLayout(panelSud, BoxLayout.Y_AXIS);
//        panelSud.setLayout(boxlayoutSud);		
// 
//        panelSud.add(tableau.getTableHeader(), BorderLayout.CENTER);
//        panelSud.add(tableau, BorderLayout.CENTER);
		
		panelSud.add(panelActions);
		
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

}
