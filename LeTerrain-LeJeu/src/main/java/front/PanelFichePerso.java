package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.media.StateTransistor;

import modele.competence.PersoStat;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;

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
		
		JPanel panelStats = new JPanel();
		BoxLayout boxlayoutStats = new BoxLayout(panelStats, BoxLayout.Y_AXIS);
		panelStats.setLayout(boxlayoutStats);
		
		panelStats.add(panelLuck);
		
		panelCentre.add(panelPhoto);
		panelCentre.add(panelInfos);
		panelCentre.add(panelStats);
		
		panelOuest.setBackground(Color.PINK);
		panelCentre.setBackground(couleur);
		panelNord.setBackground(Color.RED);
		panelEst.setBackground(Color.BLUE);
		panelSud.setBackground(Color.GREEN);

		this.setLayout(new BorderLayout());
		this.add(panelNord, BorderLayout.NORTH);
		this.add(panelOuest, BorderLayout.WEST);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelEst, BorderLayout.EAST);
		this.add(panelSud, BorderLayout.SOUTH);
	}

}
