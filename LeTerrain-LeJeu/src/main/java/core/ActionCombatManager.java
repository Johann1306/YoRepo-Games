package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modele.competence.PersoStat;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.action.ActionCombat;
import modele.item.personnage.action.ActionCombatType;
import modele.item.personnage.action.CibleType;
import modele.item.personnage.action.EnergieType;

public class ActionCombatManager implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Map<String,List<ActionCombat>> actionsByPerso;
	private int id = 0;

	public void initialise() {
		actionsByPerso = new HashMap<String,List<ActionCombat>>();
		
		List<String> imagePaths = new ArrayList<String>();
		imagePaths.add("image/defautActionCombat.png");
		
		List<String> sonPaths = new ArrayList<String>();
		sonPaths.add("src/main/resources/sonParDefaut/defautActionCombat.mp3");

		List<String> videoPaths = new ArrayList<String>();
		videoPaths.add("src/main/resources/video/Trololo.mp4");
		
		boolean disponible = true;

		int niveau = 1;
		int niveauMax = 10;
		int progression = 0;
		
		// Johann
		ActionCombat johannAttaque1 = new ActionCombat(incrementId(), "Le coup du rapace", "Se jette sur sa proie la narine saillante", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE);
		ActionCombat johannAttaque2 = new ActionCombat(incrementId(), "Le coup de boule", "Frappe avec son unique couille", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE);
		ActionCombat johannAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE);
		ActionCombat johannDefense1 = new ActionCombat(incrementId(), "Defense 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE);
		ActionCombat johannDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE);
		ActionCombat johannSort1 = new ActionCombat(incrementId(), "Soin 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE);
		ActionCombat johannSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE);
		ActionCombat johannSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE);
		ActionCombat johannSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE);
		
		// Nico
		ActionCombat nicoAttaque1 = new ActionCombat(incrementId(), "Le grappin", "Lance son grappin sur sa cible et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.CHARGE, CibleType.ENNEMI, PersoStat.TECHNIQUE);
				
		List<ActionCombat> johannActions = new ArrayList<ActionCombat>();
		List<ActionCombat> nicolasActions = new ArrayList<ActionCombat>();
		
		johannActions.add(johannAttaque1);
		johannActions.add(johannAttaque2);
		johannActions.add(johannAttaque3);
		johannActions.add(johannDefense1);
		johannActions.add(johannDefense2);
		johannActions.add(johannSort1);
		johannActions.add(johannSort2);
		johannActions.add(johannSpecial1);
		johannActions.add(johannSpecial2);
		
		nicolasActions.add(nicoAttaque1);
		
		actionsByPerso.put(PersoPrenom.JOHANN.name(), johannActions);
		actionsByPerso.put(PersoPrenom.NICOLAS.name(), nicolasActions);
	}

	public List<ActionCombat> getActionsCombat(String personnageNom) {
		return actionsByPerso.get(personnageNom);
	}
	
	private int incrementId() {
		id = id +1;
		return id;
	}

	public List<ActionCombat> getActionsCombatPersosPrincipaux() {
		List<ActionCombat> actions = new ArrayList<ActionCombat>();
		// Prenoms des personnages principaux
		 PersoPrenom[] prenoms = PersoPrenom.values();
		 for (PersoPrenom prenom : prenoms) {
			if (prenom != PersoPrenom.GROUPE) {
				List<ActionCombat> actionsParPerso = actionsByPerso.get(prenom.name());
				if (actionsParPerso != null) {
					actions.addAll(actionsParPerso);
				}
			}
		}
		return actions;
	}

}
