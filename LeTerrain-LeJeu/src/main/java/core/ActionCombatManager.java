package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modele.competence.PersoStat;
import modele.item.mission.BossNom;
import modele.item.personnage.EnnemiType;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.action.ActionCombat;
import modele.item.personnage.action.ActionCombatType;
import modele.item.personnage.action.CibleType;
import modele.item.personnage.action.EnergieType;
import modele.item.personnage.action.SortType;

public class ActionCombatManager implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Map<String,List<ActionCombat>> actionsByPerso;
	private int id = 0;

	public void initialise() {
		actionsByPerso = new HashMap<String,List<ActionCombat>>();
		
		List<String> imagePaths = new ArrayList<String>();
		imagePaths.add("image/defautActionCombat.png");
		
		List<String> sonPaths = new ArrayList<String>();
		sonPaths.add("sonParDefaut/defautActionCombat.mp3");

		List<String> videoPaths = new ArrayList<String>();
		videoPaths.add("video/Trololo.mp4");
		
		boolean disponible = true;

		int niveau = 1;
		int niveauMax = 10;
		int progression = 0;
		
		// Johann
		ActionCombat johannAttaque1 = new ActionCombat(incrementId(), "Le coup du rapace", "Se jette sur sa proie la narine saillante", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat johannAttaque2 = new ActionCombat(incrementId(), "Le coup de boule", "Frappe avec son unique couille", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MULTI);
		ActionCombat johannAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat johannDefense1 = new ActionCombat(incrementId(), "Defense 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat johannDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat johannDefense3 = new ActionCombat(incrementId(), "Defense 3", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat johannDefense4 = new ActionCombat(incrementId(), "Defense 4", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat johannSort1 = new ActionCombat(incrementId(), "Soin 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.RIEN, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat johannSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat johannSort3 = new ActionCombat(incrementId(), "Sort 3", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat johannSort4 = new ActionCombat(incrementId(), "Sort 4", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat johannSort5 = new ActionCombat(incrementId(), "Sort 5", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat johannSort6 = new ActionCombat(incrementId(), "Sort 6", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat johannSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat johannSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
		
		// Nicolas
		ActionCombat nicolasAttaque1 = new ActionCombat(incrementId(), "Le grappin", "Lance son grappin sur sa cible et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat nicolasAttaque2 = new ActionCombat(incrementId(), "La technique du dragon", "Tourne autour de son adversaire et lui met un coup de pied dans le dos ", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO);
		ActionCombat nicolasAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat nicolasDefense1 = new ActionCombat(incrementId(), "Le Mefiento", "Technique d'esquive : l'adversaire ne peut pas penetrer dans l'espace personnel", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat nicolasDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MONO);
		ActionCombat nicolasSort1 = new ActionCombat(incrementId(), "La grenade Ludovic Das Neves", "Ludovic Das Neves surgit et jette une grenade : CREUVEZ !!!", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat nicolasSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.REGEN_VIE_MULTI);
		ActionCombat nicolasSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat nicolasSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);

		// Pierre
		ActionCombat pierreAttaque1 = new ActionCombat(incrementId(), "Le coup du rapace", "Se jette sur sa proie la narine saillante", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat pierreAttaque2 = new ActionCombat(incrementId(), "Le coup de boule", "Frappe avec son unique couille", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO);
		ActionCombat pierreAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat pierreDefense1 = new ActionCombat(incrementId(), "Defense 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat pierreDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MONO);
		ActionCombat pierreSort1 = new ActionCombat(incrementId(), "Soin 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MONO);
		ActionCombat pierreSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.REGEN_VIE_MULTI);
		ActionCombat pierreSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat pierreSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);

		// Yannick
		ActionCombat yannickAttaque1 = new ActionCombat(incrementId(), "Le coup du rapace", "Se jette sur sa proie la narine saillante", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat yannickAttaque2 = new ActionCombat(incrementId(), "Le coup de boule", "Frappe avec son unique couille", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO);
		ActionCombat yannickAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat yannickDefense1 = new ActionCombat(incrementId(), "Defense 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat yannickDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MONO);
		ActionCombat yannickSort1 = new ActionCombat(incrementId(), "Soin 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MONO);
		ActionCombat yannickSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.REGEN_VIE_MULTI);
		ActionCombat yannickSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat yannickSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);

		// Thomas
		ActionCombat thomasAttaque1 = new ActionCombat(incrementId(), "Le coup du rapace", "Se jette sur sa proie la narine saillante", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat thomasAttaque2 = new ActionCombat(incrementId(), "Le coup de boule", "Frappe avec son unique couille", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO);
		ActionCombat thomasAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat thomasDefense1 = new ActionCombat(incrementId(), "Defense 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat thomasDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MONO);
		ActionCombat thomasSort1 = new ActionCombat(incrementId(), "Soin 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MONO);
		ActionCombat thomasSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.REGEN_VIE_MULTI);
		ActionCombat thomasSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat thomasSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);

		// Guillaume
		ActionCombat guillaumeAttaque1 = new ActionCombat(incrementId(), "Le coup du rapace", "Se jette sur sa proie la narine saillante", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat guillaumeAttaque2 = new ActionCombat(incrementId(), "Le coup de boule", "Frappe avec son unique couille", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO);
		ActionCombat guillaumeAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat guillaumeDefense1 = new ActionCombat(incrementId(), "Defense 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat guillaumeDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MONO);
		ActionCombat guillaumeSort1 = new ActionCombat(incrementId(), "Soin 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MONO);
		ActionCombat guillaumeSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.REGEN_VIE_MULTI);
		ActionCombat guillaumeSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat guillaumeSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);

		// Ali
		ActionCombat aliAttaque1 = new ActionCombat(incrementId(), "Le coup du rapace", "Se jette sur sa proie la narine saillante", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat aliAttaque2 = new ActionCombat(incrementId(), "Le coup de boule", "Frappe avec son unique couille", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO);
		ActionCombat aliAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat aliDefense1 = new ActionCombat(incrementId(), "Defense 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat aliDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MONO);
		ActionCombat aliSort1 = new ActionCombat(incrementId(), "Soin 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MONO);
		ActionCombat aliSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.REGEN_VIE_MULTI);
		ActionCombat aliSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat aliSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);

		// Jonathan
		ActionCombat jonathanAttaque1 = new ActionCombat(incrementId(), "Le coup du rapace", "Se jette sur sa proie la narine saillante", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat jonathanAttaque2 = new ActionCombat(incrementId(), "Le coup de boule", "Frappe avec son unique couille", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO);
		ActionCombat jonathanAttaque3 = new ActionCombat(incrementId(), "Le croche mensonge", "Attrappe sa proie entre ses jambes et ne la lache plus", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat jonathanDefense1 = new ActionCombat(incrementId(), "Defense 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat jonathanDefense2 = new ActionCombat(incrementId(), "Defense 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.RIEN, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MONO);
		ActionCombat jonathanSort1 = new ActionCombat(incrementId(), "Soin 1", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MONO);
		ActionCombat jonathanSort2 = new ActionCombat(incrementId(), "Sort 2", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.REGEN_VIE_MULTI);
		ActionCombat jonathanSpecial1 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat jonathanSpecial2 = new ActionCombat(incrementId(), "Debut de merde", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		
		// Boss1
		ActionCombat boss1Attaque1 = new ActionCombat(incrementId(), "Attaque 1", "attaque 1 info", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		
		//Ennemi Gitan
		ActionCombat gitanAttaque1= new ActionCombat(incrementId(), "Attaque 1", "attaque 1 info", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		
		List<ActionCombat> johannActions = new ArrayList<ActionCombat>();
		List<ActionCombat> nicolasActions = new ArrayList<ActionCombat>();
		List<ActionCombat> pierreActions = new ArrayList<ActionCombat>();
		List<ActionCombat> thomasActions = new ArrayList<ActionCombat>();
		List<ActionCombat> yannickActions = new ArrayList<ActionCombat>();
		List<ActionCombat> guillaumeActions = new ArrayList<ActionCombat>();
		List<ActionCombat> aliActions = new ArrayList<ActionCombat>();
		List<ActionCombat> jonathanActions = new ArrayList<ActionCombat>();
		List<ActionCombat> boss1Actions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanActions = new ArrayList<ActionCombat>();
		
		johannActions.add(johannAttaque1);
		johannActions.add(johannAttaque2);
		johannActions.add(johannAttaque3);
		johannActions.add(johannDefense1);
		johannActions.add(johannDefense2);
		johannActions.add(johannDefense3);
		johannActions.add(johannDefense4);
		johannActions.add(johannSort1);
		johannActions.add(johannSort2);
		johannActions.add(johannSort3);
		johannActions.add(johannSort4);
		johannActions.add(johannSort5);
		johannActions.add(johannSort6);
		johannActions.add(johannSpecial1);
		johannActions.add(johannSpecial2);
		
		nicolasActions.add(nicolasAttaque1);
		nicolasActions.add(nicolasAttaque2);
		nicolasActions.add(nicolasAttaque3);
		nicolasActions.add(nicolasDefense1);
		nicolasActions.add(nicolasDefense2);
		nicolasActions.add(nicolasSort1);
		nicolasActions.add(nicolasSort2);
		nicolasActions.add(nicolasSpecial1);
		nicolasActions.add(nicolasSpecial2);
		
		pierreActions.add(pierreAttaque1);
		pierreActions.add(pierreAttaque2);
		pierreActions.add(pierreAttaque3);
		pierreActions.add(pierreDefense1);
		pierreActions.add(pierreDefense2);
		pierreActions.add(pierreSort1);
		pierreActions.add(pierreSort2);
		pierreActions.add(pierreSpecial1);
		pierreActions.add(pierreSpecial2);

		yannickActions.add(yannickAttaque1);
		yannickActions.add(yannickAttaque2);
		yannickActions.add(yannickAttaque3);
		yannickActions.add(yannickDefense1);
		yannickActions.add(yannickDefense2);
		yannickActions.add(yannickSort1);
		yannickActions.add(yannickSort2);
		yannickActions.add(yannickSpecial1);
		yannickActions.add(yannickSpecial2);
		
		thomasActions.add(thomasAttaque1);
		thomasActions.add(thomasAttaque2);
		thomasActions.add(thomasAttaque3);
		thomasActions.add(thomasDefense1);
		thomasActions.add(thomasDefense2);
		thomasActions.add(thomasSort1);
		thomasActions.add(thomasSort2);
		thomasActions.add(thomasSpecial1);
		thomasActions.add(thomasSpecial2);
		
		guillaumeActions.add(guillaumeAttaque1);
		guillaumeActions.add(guillaumeAttaque2);
		guillaumeActions.add(guillaumeAttaque3);
		guillaumeActions.add(guillaumeDefense1);
		guillaumeActions.add(guillaumeDefense2);
		guillaumeActions.add(guillaumeSort1);
		guillaumeActions.add(guillaumeSort2);
		guillaumeActions.add(guillaumeSpecial1);
		guillaumeActions.add(guillaumeSpecial2);
		
		aliActions.add(aliAttaque1);
		aliActions.add(aliAttaque2);
		aliActions.add(aliAttaque3);
		aliActions.add(aliDefense1);
		aliActions.add(aliDefense2);
		aliActions.add(aliSort1);
		aliActions.add(aliSort2);
		aliActions.add(aliSpecial1);
		aliActions.add(aliSpecial2);
		
		jonathanActions.add(jonathanAttaque1);
		jonathanActions.add(jonathanAttaque2);
		jonathanActions.add(jonathanAttaque3);
		jonathanActions.add(jonathanDefense1);
		jonathanActions.add(jonathanDefense2);
		jonathanActions.add(jonathanSort1);
		jonathanActions.add(jonathanSort2);
		jonathanActions.add(jonathanSpecial1);
		jonathanActions.add(jonathanSpecial2);
		
		boss1Actions.add(boss1Attaque1);

		gitanActions.add(gitanAttaque1);

		actionsByPerso.put(PersoPrenom.Johann.name(), johannActions);
		actionsByPerso.put(PersoPrenom.Nicolas.name(), nicolasActions);
		actionsByPerso.put(PersoPrenom.Pierre.name(), pierreActions);
		actionsByPerso.put(PersoPrenom.Thomas.name(), thomasActions);
		actionsByPerso.put(PersoPrenom.Yannick.name(), yannickActions);
		actionsByPerso.put(PersoPrenom.Guillaume.name(), guillaumeActions);
		actionsByPerso.put(PersoPrenom.Ali.name(), aliActions);
		actionsByPerso.put(PersoPrenom.Jonathan.name(), jonathanActions);
		actionsByPerso.put(BossNom.BOSS1.name(), boss1Actions);
		actionsByPerso.put(EnnemiType.GITANS.name(), gitanActions);
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
