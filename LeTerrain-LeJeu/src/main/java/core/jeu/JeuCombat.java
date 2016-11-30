package core.jeu;

import java.io.Serializable;
import java.util.List;

import core.NomJeu;
import front.FrameCombat;
import modele.item.Item;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnageSecondaire;
import modele.jeu.Jeu;

public class JeuCombat extends Jeu implements Serializable {

	private static final long serialVersionUID = 1L;

	public JeuCombat(NomJeu nomJeu) {
		super(nomJeu);
	}
	
	@Override
	public void start(Groupe groupe, Mission mission) {
		
		int chanceVictoire = mission.getChanceVictoire();
		Difficulte difficulty = mission.getDifficulty();
		List<PersonnageSecondaire> personnagesSecondaires = mission.getPersonnagesSecondaires();
		PersoPrenom proprietaire = mission.getProprietaire();
		List<String> sonPaths = mission.getSonPaths();
		String conditionDefaite = mission.getConditionDefaite();
		String conditionVictoire = mission.getConditionVictoire();
		List<Item> itemsDebloques = mission.getItemsDebloques();
		
		// Frame Combat
		FrameCombat frameCombat = new FrameCombat(groupe, mission);
		frameCombat.start();
	}
}