package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modele.competence.PersoStat;
import modele.item.mission.BossNom;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.EnnemiType;
import modele.item.personnage.PersoClasse;
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

	public void initialise(Difficulte difficultePartie) {
		actionsByPerso = new HashMap<String,List<ActionCombat>>();
		
		List<String> imagePaths = new ArrayList<String>();
		imagePaths.add("image/defautActionCombat.png");
		
		String sonAttaque = "sonParDefaut/defautAttaque.mp3";
		String sonAttaqueCritique = "sonParDefaut/defautAttaqueCritique.mp3";
		String sonREZ = "sonParDefaut/defautREZ.mp3";
		String sonREZCritique = "sonParDefaut/defautREZCritique.mp3";
		String sonBouclier = "sonParDefaut/defautBouclier.mp3";
		String sonBouclierCritique = "sonParDefaut/defautBouclierCritique.mp3";
		
		List<String> videoPaths = new ArrayList<String>();
		videoPaths.add("video/Trololo.mp4");
		
		boolean disponible = true;

		int niveau_1 = 1;
		int niveauMax_10 = 10;
		int progression = 0;
		
		// Johann
		ActionCombat johannAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Johann);
		ActionCombat johannAttaque2 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Johann);
		ActionCombat johannDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Johann);
		ActionCombat johannDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Johann);
		ActionCombat johannDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Johann);
		ActionCombat johannDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Johann);
		ActionCombat johannDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Johann);
		ActionCombat johannDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Johann);
		ActionCombat johannDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Johann);
		ActionCombat johannDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Johann);
		ActionCombat johannSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Johann);
		ActionCombat johannSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Johann);
		ActionCombat johannSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Johann);
		ActionCombat johannSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Johann);
		ActionCombat johannSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Johann);
		ActionCombat johannSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Johann);
		ActionCombat johannSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Johann);
		ActionCombat johannSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Johann);
		ActionCombat johannSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Johann);
		ActionCombat johannSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Johann);
		ActionCombat johannSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Johann);
		ActionCombat johannSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Johann);
		ActionCombat johannSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Johann);
		ActionCombat johannSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Johann);
		ActionCombat johannSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Johann);
		ActionCombat johannSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Johann);
		ActionCombat johannSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Johann);
		ActionCombat johannSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Johann);
		ActionCombat johannSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Johann);
		ActionCombat johannSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Johann);
		
		// Nicolas
		ActionCombat nicolasAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasAttaque2 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Nicolas);
		ActionCombat nicolasDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Nicolas);
		ActionCombat nicolasDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Nicolas);
		ActionCombat nicolasDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Nicolas);
		ActionCombat nicolasSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonREZ, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Nicolas);
		ActionCombat nicolasSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Nicolas);
		ActionCombat nicolasSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Nicolas);
	
		// Pierre
		ActionCombat pierreAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Pierre);
		ActionCombat pierreAttaque2 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Pierre);
		ActionCombat pierreDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Pierre);
		ActionCombat pierreDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Pierre);
		ActionCombat pierreDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Pierre);
		ActionCombat pierreDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Pierre);
		ActionCombat pierreDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Pierre);
		ActionCombat pierreSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Pierre);
		ActionCombat pierreSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Pierre);
		ActionCombat pierreSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Pierre);
		ActionCombat pierreSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Pierre);
		ActionCombat pierreSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Pierre);
		ActionCombat pierreSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Pierre);
		ActionCombat pierreSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Pierre);
		ActionCombat pierreSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Pierre);
		ActionCombat pierreSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonREZ, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Pierre);
		ActionCombat pierreSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Pierre);
		ActionCombat pierreSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Pierre);
		ActionCombat pierreSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Pierre);
	
		// Yannick
		ActionCombat yannickAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Yannick);
		ActionCombat yannickAttaque2 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Yannick);
		ActionCombat yannickDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Yannick);
		ActionCombat yannickDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Yannick);
		ActionCombat yannickDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Yannick);
		ActionCombat yannickDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Yannick);
		ActionCombat yannickDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Yannick);
		ActionCombat yannickSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Yannick);
		ActionCombat yannickSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Yannick);
		ActionCombat yannickSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Yannick);
		ActionCombat yannickSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Yannick);
		ActionCombat yannickSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Yannick);
		ActionCombat yannickSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Yannick);
		ActionCombat yannickSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Yannick);
		ActionCombat yannickSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Yannick);
		ActionCombat yannickSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Yannick);
		ActionCombat yannickSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Yannick);
		ActionCombat yannickSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Yannick);
		ActionCombat yannickSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Yannick);
	
		// Thomas
		ActionCombat thomasAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Thomas);
		ActionCombat thomasAttaque2 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Thomas);
		ActionCombat thomasDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Thomas);
		ActionCombat thomasDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Thomas);
		ActionCombat thomasDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Thomas);
		ActionCombat thomasDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Thomas);
		ActionCombat thomasDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Thomas);
		ActionCombat thomasSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Thomas);
		ActionCombat thomasSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Thomas);
		ActionCombat thomasSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Thomas);
		ActionCombat thomasSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Thomas);
		ActionCombat thomasSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Thomas);
		ActionCombat thomasSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Thomas);
		ActionCombat thomasSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Thomas);
		ActionCombat thomasSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Thomas);
		ActionCombat thomasSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Thomas);
		ActionCombat thomasSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Thomas);
		ActionCombat thomasSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Thomas);
		ActionCombat thomasSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Thomas);
	
		// Guillaume
		ActionCombat guillaumeAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeAttaque2 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Guillaume);
		ActionCombat guillaumeDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Guillaume);
		ActionCombat guillaumeDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Guillaume);
		ActionCombat guillaumeDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Guillaume);
		ActionCombat guillaumeSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Guillaume);
		ActionCombat guillaumeSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Guillaume);
	
		// Ali
		ActionCombat aliAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Ali);
		ActionCombat aliAttaque2 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Ali);
		ActionCombat aliDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Ali);
		ActionCombat aliDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Ali);
		ActionCombat aliDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Ali);
		ActionCombat aliDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Ali);
		ActionCombat aliDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Ali);
		ActionCombat aliDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Ali);
		ActionCombat aliDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Ali);
		ActionCombat aliDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Ali);
		ActionCombat aliSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Ali);
		ActionCombat aliSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Ali);
		ActionCombat aliSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Ali);
		ActionCombat aliSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Ali);
		ActionCombat aliSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Ali);
		ActionCombat aliSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Ali);
		ActionCombat aliSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Ali);
		ActionCombat aliSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Ali);
		ActionCombat aliSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Ali);
		ActionCombat aliSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Ali);
		ActionCombat aliSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Ali);
		ActionCombat aliSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Ali);
		ActionCombat aliSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Ali);
		ActionCombat aliSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Ali);
		ActionCombat aliSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Ali);
		ActionCombat aliSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Ali);
		ActionCombat aliSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Ali);
		ActionCombat aliSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Ali);
		ActionCombat aliSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Ali);
		ActionCombat aliSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Ali);
	
		// Jonathan
		ActionCombat jonathanAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanAttaque2 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Jonathan);
		ActionCombat jonathanDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Jonathan);
		ActionCombat jonathanDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Jonathan);
		ActionCombat jonathanDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Jonathan);
		ActionCombat jonathanSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Jonathan);
		ActionCombat jonathanSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Jonathan);
		ActionCombat jonathanSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Jonathan);
		
		//////////////////// ENNEMIS ///////////////////////
		int niveauSort = 0;
		int niveauMaxSort = 10;
		if (difficultePartie == Difficulte.FACILE) {
			niveauSort = 1;
		} else if (difficultePartie == Difficulte.NORMAL) {
			niveauSort = 3;
		} else if (difficultePartie == Difficulte.DIFFICILE) {
			niveauSort = 6;
		} else if (difficultePartie == Difficulte.HEROIQUE) {
			niveauSort = 10;
		}
		
		// Boss1
		ActionCombat boss1Attaque1 = new ActionCombat(incrementId(), "Attaque 1", "attaque 1 info", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		
		// Ennemi Gitan Tank
		ActionCombat gitanTankAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanTankDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.ENDURANCE, SortType.ESQUIVE, null);
		ActionCombat gitanTankDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat gitanTankSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.NERVOSITE, SortType.STUN_MONO, null);
		ActionCombat gitanTankSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.NERVOSITE, SortType.TAUNT_MULTI, null);

		// Ennemi Gitan Healer
		ActionCombat gitanHealerAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanHealerDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MULTI, null);
		ActionCombat gitanHealerSort1 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, null);
		ActionCombat gitanHealerSort2 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, null);
		ActionCombat gitanHealerSort3 = new ActionCombat(incrementId(), "Resurection Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, null);
		ActionCombat gitanHealerSpecial1 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, null);
		ActionCombat gitanHealerSpecial2 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, null);

		// Ennemi Gitan DPS
		ActionCombat gitanDpsAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanDpsAttaque2= new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);
		ActionCombat gitanDpsDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.EXPLOIT, SortType.ESQUIVE, null);
		ActionCombat gitanDpsSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.EXPLOIT, SortType.STUN_MONO, null);
		ActionCombat gitanDpsSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);

		// Ennemi Gitan Mage
		ActionCombat gitanMageAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanMageDefense1 = new ActionCombat(incrementId(), "Bouclier perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat gitanMageDefense2 = new ActionCombat(incrementId(), "Regen Mana perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, null);
		ActionCombat gitanMageSort1 = new ActionCombat(incrementId(), "Absorption Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, null);
		ActionCombat gitanMageSort2 = new ActionCombat(incrementId(), "Absorption Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, null);
		ActionCombat gitanMageSort3 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO, null);
		ActionCombat gitanMageSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MULTI, null);
		ActionCombat gitanMageSpecial2 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.STUN_MULTI, null);

		// Ennemi Gitan Barde
		ActionCombat gitanBardeAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanBardeDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.BOUCLIER_MULTI, null);
		ActionCombat gitanBardeSort1 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.REGEN_MANA_MULTI, null);
		ActionCombat gitanBardeSort2 = new ActionCombat(incrementId(), "Absorption Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.ABSORPTION_VIE_MULTI, null);
		ActionCombat gitanBardeSort3 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.REGEN_VIE_MONO, null);
		ActionCombat gitanBardeSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.TAUNT_MULTI, null);
		ActionCombat gitanBardeSpecial2 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.RESURRECTION_MONO, null);

		
		// Ennemi Noir
		// la mer noire

		List<ActionCombat> johannActions = new ArrayList<ActionCombat>();
		List<ActionCombat> nicolasActions = new ArrayList<ActionCombat>();
		List<ActionCombat> pierreActions = new ArrayList<ActionCombat>();
		List<ActionCombat> thomasActions = new ArrayList<ActionCombat>();
		List<ActionCombat> yannickActions = new ArrayList<ActionCombat>();
		List<ActionCombat> guillaumeActions = new ArrayList<ActionCombat>();
		List<ActionCombat> aliActions = new ArrayList<ActionCombat>();
		List<ActionCombat> jonathanActions = new ArrayList<ActionCombat>();
		
		List<ActionCombat> boss1Actions = new ArrayList<ActionCombat>();
		
		List<ActionCombat> gitanTankActions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanHealerActions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanDpsActions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanMageActions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanBardeActions = new ArrayList<ActionCombat>();
		
		johannActions.add(johannAttaque1);
		johannActions.add(johannAttaque2);
		johannActions.add(johannDefense1);
		johannActions.add(johannDefense2);
		johannActions.add(johannDefense3);
		johannActions.add(johannDefense4);
		johannActions.add(johannDefense5);
		johannActions.add(johannDefense6);
		johannActions.add(johannDefense7);
		johannActions.add(johannDefense8);
		johannActions.add(johannSort1);
		johannActions.add(johannSort2);
		johannActions.add(johannSort3);
		johannActions.add(johannSort4);
		johannActions.add(johannSort5);
		johannActions.add(johannSort6);
		johannActions.add(johannSort7);
		johannActions.add(johannSort8);
		johannActions.add(johannSort9);
		johannActions.add(johannSort10);
		johannActions.add(johannSort11);
		johannActions.add(johannSort12);
		johannActions.add(johannSort13);
		johannActions.add(johannSort14);
		johannActions.add(johannSort15);
		johannActions.add(johannSort16);
		johannActions.add(johannSort17);
		johannActions.add(johannSort18);
		johannActions.add(johannSpecial1);
		johannActions.add(johannSpecial2);
		
		nicolasActions.add(nicolasAttaque1);
		nicolasActions.add(nicolasAttaque2);
		nicolasActions.add(nicolasDefense1);
		nicolasActions.add(nicolasDefense2);
		nicolasActions.add(nicolasDefense3);
		nicolasActions.add(nicolasDefense4);
		nicolasActions.add(nicolasDefense5);
		nicolasActions.add(nicolasDefense6);
		nicolasActions.add(nicolasDefense7);
		nicolasActions.add(nicolasDefense8);
		nicolasActions.add(nicolasSort1);
		nicolasActions.add(nicolasSort2);
		nicolasActions.add(nicolasSort3);
		nicolasActions.add(nicolasSort4);
		nicolasActions.add(nicolasSort5);
		nicolasActions.add(nicolasSort6);
		nicolasActions.add(nicolasSort7);
		nicolasActions.add(nicolasSort8);
		nicolasActions.add(nicolasSort9);
		nicolasActions.add(nicolasSort10);
		nicolasActions.add(nicolasSort11);
		nicolasActions.add(nicolasSort12);
		nicolasActions.add(nicolasSort13);
		nicolasActions.add(nicolasSort14);
		nicolasActions.add(nicolasSort15);
		nicolasActions.add(nicolasSort16);
		nicolasActions.add(nicolasSort17);
		nicolasActions.add(nicolasSort18);
		nicolasActions.add(nicolasSpecial1);
		nicolasActions.add(nicolasSpecial2);

		thomasActions.add(thomasAttaque1);
		thomasActions.add(thomasAttaque2);
		thomasActions.add(thomasDefense1);
		thomasActions.add(thomasDefense2);
		thomasActions.add(thomasDefense3);
		thomasActions.add(thomasDefense4);
		thomasActions.add(thomasDefense5);
		thomasActions.add(thomasDefense6);
		thomasActions.add(thomasDefense7);
		thomasActions.add(thomasDefense8);
		thomasActions.add(thomasSort1);
		thomasActions.add(thomasSort2);
		thomasActions.add(thomasSort3);
		thomasActions.add(thomasSort4);
		thomasActions.add(thomasSort5);
		thomasActions.add(thomasSort6);
		thomasActions.add(thomasSort7);
		thomasActions.add(thomasSort8);
		thomasActions.add(thomasSort9);
		thomasActions.add(thomasSort10);
		thomasActions.add(thomasSort11);
		thomasActions.add(thomasSort12);
		thomasActions.add(thomasSort13);
		thomasActions.add(thomasSort14);
		thomasActions.add(thomasSort15);
		thomasActions.add(thomasSort16);
		thomasActions.add(thomasSort17);
		thomasActions.add(thomasSort18);
		thomasActions.add(thomasSpecial1);
		thomasActions.add(thomasSpecial2);
		
		pierreActions.add(pierreAttaque1);
		pierreActions.add(pierreAttaque2);
		pierreActions.add(pierreDefense1);
		pierreActions.add(pierreDefense2);
		pierreActions.add(pierreDefense3);
		pierreActions.add(pierreDefense4);
		pierreActions.add(pierreDefense5);
		pierreActions.add(pierreDefense6);
		pierreActions.add(pierreDefense7);
		pierreActions.add(pierreDefense8);
		pierreActions.add(pierreSort1);
		pierreActions.add(pierreSort2);
		pierreActions.add(pierreSort3);
		pierreActions.add(pierreSort4);
		pierreActions.add(pierreSort5);
		pierreActions.add(pierreSort6);
		pierreActions.add(pierreSort7);
		pierreActions.add(pierreSort8);
		pierreActions.add(pierreSort9);
		pierreActions.add(pierreSort10);
		pierreActions.add(pierreSort11);
		pierreActions.add(pierreSort12);
		pierreActions.add(pierreSort13);
		pierreActions.add(pierreSort14);
		pierreActions.add(pierreSort15);
		pierreActions.add(pierreSort16);
		pierreActions.add(pierreSort17);
		pierreActions.add(pierreSort18);
		pierreActions.add(pierreSpecial1);
		pierreActions.add(pierreSpecial2);
		
		yannickActions.add(yannickAttaque1);
		yannickActions.add(yannickAttaque2);
		yannickActions.add(yannickDefense1);
		yannickActions.add(yannickDefense2);
		yannickActions.add(yannickDefense3);
		yannickActions.add(yannickDefense4);
		yannickActions.add(yannickDefense5);
		yannickActions.add(yannickDefense6);
		yannickActions.add(yannickDefense7);
		yannickActions.add(yannickDefense8);
		yannickActions.add(yannickSort1);
		yannickActions.add(yannickSort2);
		yannickActions.add(yannickSort3);
		yannickActions.add(yannickSort4);
		yannickActions.add(yannickSort5);
		yannickActions.add(yannickSort6);
		yannickActions.add(yannickSort7);
		yannickActions.add(yannickSort8);
		yannickActions.add(yannickSort9);
		yannickActions.add(yannickSort10);
		yannickActions.add(yannickSort11);
		yannickActions.add(yannickSort12);
		yannickActions.add(yannickSort13);
		yannickActions.add(yannickSort14);
		yannickActions.add(yannickSort15);
		yannickActions.add(yannickSort16);
		yannickActions.add(yannickSort17);
		yannickActions.add(yannickSort18);
		yannickActions.add(yannickSpecial1);
		yannickActions.add(yannickSpecial2);
		
		aliActions.add(aliAttaque1);
		aliActions.add(aliAttaque2);
		aliActions.add(aliDefense1);
		aliActions.add(aliDefense2);
		aliActions.add(aliDefense3);
		aliActions.add(aliDefense4);
		aliActions.add(aliDefense5);
		aliActions.add(aliDefense6);
		aliActions.add(aliDefense7);
		aliActions.add(aliDefense8);
		aliActions.add(aliSort1);
		aliActions.add(aliSort2);
		aliActions.add(aliSort3);
		aliActions.add(aliSort4);
		aliActions.add(aliSort5);
		aliActions.add(aliSort6);
		aliActions.add(aliSort7);
		aliActions.add(aliSort8);
		aliActions.add(aliSort9);
		aliActions.add(aliSort10);
		aliActions.add(aliSort11);
		aliActions.add(aliSort12);
		aliActions.add(aliSort13);
		aliActions.add(aliSort14);
		aliActions.add(aliSort15);
		aliActions.add(aliSort16);
		aliActions.add(aliSort17);
		aliActions.add(aliSort18);
		aliActions.add(aliSpecial1);
		aliActions.add(aliSpecial2);
		
		guillaumeActions.add(guillaumeAttaque1);
		guillaumeActions.add(guillaumeAttaque2);
		guillaumeActions.add(guillaumeDefense1);
		guillaumeActions.add(guillaumeDefense2);
		guillaumeActions.add(guillaumeDefense3);
		guillaumeActions.add(guillaumeDefense4);
		guillaumeActions.add(guillaumeDefense5);
		guillaumeActions.add(guillaumeDefense6);
		guillaumeActions.add(guillaumeDefense7);
		guillaumeActions.add(guillaumeDefense8);
		guillaumeActions.add(guillaumeSort1);
		guillaumeActions.add(guillaumeSort2);
		guillaumeActions.add(guillaumeSort3);
		guillaumeActions.add(guillaumeSort4);
		guillaumeActions.add(guillaumeSort5);
		guillaumeActions.add(guillaumeSort6);
		guillaumeActions.add(guillaumeSort7);
		guillaumeActions.add(guillaumeSort8);
		guillaumeActions.add(guillaumeSort9);
		guillaumeActions.add(guillaumeSort10);
		guillaumeActions.add(guillaumeSort11);
		guillaumeActions.add(guillaumeSort12);
		guillaumeActions.add(guillaumeSort13);
		guillaumeActions.add(guillaumeSort14);
		guillaumeActions.add(guillaumeSort15);
		guillaumeActions.add(guillaumeSort16);
		guillaumeActions.add(guillaumeSort17);
		guillaumeActions.add(guillaumeSort18);
		guillaumeActions.add(guillaumeSpecial1);
		guillaumeActions.add(guillaumeSpecial2);
		
		jonathanActions.add(jonathanAttaque1);
		jonathanActions.add(jonathanAttaque2);
		jonathanActions.add(jonathanDefense1);
		jonathanActions.add(jonathanDefense2);
		jonathanActions.add(jonathanDefense3);
		jonathanActions.add(jonathanDefense4);
		jonathanActions.add(jonathanDefense5);
		jonathanActions.add(jonathanDefense6);
		jonathanActions.add(jonathanDefense7);
		jonathanActions.add(jonathanDefense8);
		jonathanActions.add(jonathanSort1);
		jonathanActions.add(jonathanSort2);
		jonathanActions.add(jonathanSort3);
		jonathanActions.add(jonathanSort4);
		jonathanActions.add(jonathanSort5);
		jonathanActions.add(jonathanSort6);
		jonathanActions.add(jonathanSort7);
		jonathanActions.add(jonathanSort8);
		jonathanActions.add(jonathanSort9);
		jonathanActions.add(jonathanSort10);
		jonathanActions.add(jonathanSort11);
		jonathanActions.add(jonathanSort12);
		jonathanActions.add(jonathanSort13);
		jonathanActions.add(jonathanSort14);
		jonathanActions.add(jonathanSort15);
		jonathanActions.add(jonathanSort16);
		jonathanActions.add(jonathanSort17);
		jonathanActions.add(jonathanSort18);
		jonathanActions.add(jonathanSpecial1);
		jonathanActions.add(jonathanSpecial2);
		
		boss1Actions.add(boss1Attaque1);

		gitanTankActions.add(gitanTankAttaque1);
		gitanTankActions.add(gitanTankDefense1);
		gitanTankActions.add(gitanTankDefense2);
		gitanTankActions.add(gitanTankSort1);
		gitanTankActions.add(gitanTankSpecial1);

		gitanHealerActions.add(gitanHealerAttaque1);
		gitanHealerActions.add(gitanHealerDefense1);
		gitanHealerActions.add(gitanHealerSort1);
		gitanHealerActions.add(gitanHealerSort2);
		gitanHealerActions.add(gitanHealerSort3);
		gitanHealerActions.add(gitanHealerSpecial1);
		gitanHealerActions.add(gitanHealerSpecial2);
		
		gitanDpsActions.add(gitanDpsAttaque1);
		gitanDpsActions.add(gitanDpsAttaque2);
		gitanDpsActions.add(gitanDpsDefense1);
		gitanDpsActions.add(gitanDpsSort1);
		gitanDpsActions.add(gitanDpsSpecial1);
		
		gitanMageActions.add(gitanMageAttaque1);
		gitanMageActions.add(gitanMageDefense1);
		gitanMageActions.add(gitanMageDefense2);
		gitanMageActions.add(gitanMageSort1);
		gitanMageActions.add(gitanMageSort2);
		gitanMageActions.add(gitanMageSort3);
		gitanMageActions.add(gitanMageSpecial1);
		gitanMageActions.add(gitanMageSpecial2);
		
		gitanBardeActions.add(gitanBardeAttaque1);
		gitanBardeActions.add(gitanBardeDefense1);
		gitanBardeActions.add(gitanBardeSort1);
		gitanBardeActions.add(gitanBardeSort2);
		gitanBardeActions.add(gitanBardeSort3);
		gitanBardeActions.add(gitanBardeSpecial1);
		gitanBardeActions.add(gitanBardeSpecial2);
		
		actionsByPerso.put(PersoPrenom.Johann.name(), johannActions);
		actionsByPerso.put(PersoPrenom.Nicolas.name(), nicolasActions);
		actionsByPerso.put(PersoPrenom.Pierre.name(), pierreActions);
		actionsByPerso.put(PersoPrenom.Thomas.name(), thomasActions);
		actionsByPerso.put(PersoPrenom.Yannick.name(), yannickActions);
		actionsByPerso.put(PersoPrenom.Guillaume.name(), guillaumeActions);
		actionsByPerso.put(PersoPrenom.Ali.name(), aliActions);
		actionsByPerso.put(PersoPrenom.Jonathan.name(), jonathanActions);
		
		actionsByPerso.put(BossNom.BOSS1.name(), boss1Actions);
		
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.TANK.name(), gitanTankActions);
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.HEALER.name(), gitanHealerActions);
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.DPS.name(), gitanDpsActions);
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.MAGE.name(), gitanMageActions);
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.BARDE.name(), gitanBardeActions);
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
