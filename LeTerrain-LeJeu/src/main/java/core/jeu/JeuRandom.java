package core.jeu;

import java.io.Serializable;
import java.util.List;

import core.NomJeu;
import core.RandomManager;
import front.MenuPrincipal;
import modele.item.Item;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnageSecondaire;
import modele.jeu.Jeu;

public class JeuRandom extends Jeu implements Serializable {

	private static final long serialVersionUID = 1L;

	public JeuRandom(NomJeu nomJeu) {
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
		
		boolean win = false;
		
		
		// random 1 à 100
		int random100 = RandomManager.random1_100();
		
		// TODO : front

		if (random100 > 95) {
			//critique loose
		}
		if (random100 <= 5) {
			//critique win
		}
		if (random100 <= chanceVictoire){
			win = true;
		}
		MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().termineMission(mission, win);
	}

	
	

}
