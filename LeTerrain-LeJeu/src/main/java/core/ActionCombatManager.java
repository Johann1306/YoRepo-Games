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
		ActionCombat johannAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat johannDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO);
		ActionCombat johannDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO);
		ActionCombat johannDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat johannDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat johannDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO);
		ActionCombat johannDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat johannDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat johannDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE);
		ActionCombat johannSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO);
		ActionCombat johannSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat johannSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat johannSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO);
		ActionCombat johannSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI);
		ActionCombat johannSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO);
		ActionCombat johannSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat johannSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat johannSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO);
		ActionCombat johannSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI);
		ActionCombat johannSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO);
		ActionCombat johannSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI);
		ActionCombat johannSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat johannSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat johannSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO);
		ActionCombat johannSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI);
		ActionCombat johannSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO);
		ActionCombat johannSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI);
		ActionCombat johannSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat johannSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
		
		// Nicolas
		ActionCombat nicolasAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat nicolasDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO);
		ActionCombat nicolasDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO);
		ActionCombat nicolasDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat nicolasDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat nicolasDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO);
		ActionCombat nicolasDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat nicolasDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat nicolasDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE);
		ActionCombat nicolasSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO);
		ActionCombat nicolasSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat nicolasSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat nicolasSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO);
		ActionCombat nicolasSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI);
		ActionCombat nicolasSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO);
		ActionCombat nicolasSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat nicolasSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat nicolasSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO);
		ActionCombat nicolasSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI);
		ActionCombat nicolasSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO);
		ActionCombat nicolasSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI);
		ActionCombat nicolasSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat nicolasSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat nicolasSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO);
		ActionCombat nicolasSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI);
		ActionCombat nicolasSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO);
		ActionCombat nicolasSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI);
		ActionCombat nicolasSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat nicolasSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
	
		// Pierre
		ActionCombat pierreAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat pierreDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO);
		ActionCombat pierreDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO);
		ActionCombat pierreDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat pierreDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat pierreDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO);
		ActionCombat pierreDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat pierreDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat pierreDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE);
		ActionCombat pierreSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO);
		ActionCombat pierreSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat pierreSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat pierreSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO);
		ActionCombat pierreSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI);
		ActionCombat pierreSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO);
		ActionCombat pierreSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat pierreSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat pierreSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO);
		ActionCombat pierreSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI);
		ActionCombat pierreSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO);
		ActionCombat pierreSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI);
		ActionCombat pierreSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat pierreSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat pierreSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO);
		ActionCombat pierreSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI);
		ActionCombat pierreSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO);
		ActionCombat pierreSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI);
		ActionCombat pierreSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat pierreSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
	
		// Yannick
		ActionCombat yannickAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat yannickDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO);
		ActionCombat yannickDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO);
		ActionCombat yannickDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat yannickDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat yannickDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO);
		ActionCombat yannickDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat yannickDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat yannickDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE);
		ActionCombat yannickSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO);
		ActionCombat yannickSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat yannickSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat yannickSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO);
		ActionCombat yannickSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI);
		ActionCombat yannickSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO);
		ActionCombat yannickSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat yannickSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat yannickSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO);
		ActionCombat yannickSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI);
		ActionCombat yannickSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO);
		ActionCombat yannickSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI);
		ActionCombat yannickSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat yannickSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat yannickSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO);
		ActionCombat yannickSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI);
		ActionCombat yannickSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO);
		ActionCombat yannickSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI);
		ActionCombat yannickSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat yannickSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
	
		// Thomas
		ActionCombat thomasAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat thomasDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO);
		ActionCombat thomasDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO);
		ActionCombat thomasDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat thomasDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat thomasDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO);
		ActionCombat thomasDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat thomasDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat thomasDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE);
		ActionCombat thomasSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO);
		ActionCombat thomasSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat thomasSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat thomasSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO);
		ActionCombat thomasSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI);
		ActionCombat thomasSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO);
		ActionCombat thomasSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat thomasSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat thomasSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO);
		ActionCombat thomasSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI);
		ActionCombat thomasSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO);
		ActionCombat thomasSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI);
		ActionCombat thomasSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat thomasSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat thomasSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO);
		ActionCombat thomasSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI);
		ActionCombat thomasSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO);
		ActionCombat thomasSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI);
		ActionCombat thomasSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat thomasSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
	
		// Guillaume
		ActionCombat guillaumeAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat guillaumeDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO);
		ActionCombat guillaumeDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO);
		ActionCombat guillaumeDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat guillaumeDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat guillaumeDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO);
		ActionCombat guillaumeDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat guillaumeDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat guillaumeDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE);
		ActionCombat guillaumeSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO);
		ActionCombat guillaumeSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat guillaumeSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat guillaumeSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO);
		ActionCombat guillaumeSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI);
		ActionCombat guillaumeSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO);
		ActionCombat guillaumeSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat guillaumeSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat guillaumeSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO);
		ActionCombat guillaumeSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI);
		ActionCombat guillaumeSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO);
		ActionCombat guillaumeSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI);
		ActionCombat guillaumeSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat guillaumeSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat guillaumeSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO);
		ActionCombat guillaumeSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI);
		ActionCombat guillaumeSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO);
		ActionCombat guillaumeSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI);
		ActionCombat guillaumeSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat guillaumeSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
	
		// Ali
		ActionCombat aliAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat aliDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO);
		ActionCombat aliDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO);
		ActionCombat aliDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat aliDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat aliDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO);
		ActionCombat aliDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat aliDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat aliDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE);
		ActionCombat aliSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO);
		ActionCombat aliSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat aliSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat aliSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO);
		ActionCombat aliSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI);
		ActionCombat aliSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO);
		ActionCombat aliSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat aliSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat aliSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO);
		ActionCombat aliSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI);
		ActionCombat aliSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO);
		ActionCombat aliSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI);
		ActionCombat aliSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat aliSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat aliSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO);
		ActionCombat aliSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI);
		ActionCombat aliSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO);
		ActionCombat aliSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI);
		ActionCombat aliSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat aliSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
	
		// Jonathan
		ActionCombat jonathanAttaque1 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO);
		ActionCombat jonathanDefense1 = new ActionCombat(incrementId(), "Renvoi degats Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO);
		ActionCombat jonathanDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO);
		ActionCombat jonathanDefense3 = new ActionCombat(incrementId(), "Bouclier Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO);
		ActionCombat jonathanDefense4 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI);
		ActionCombat jonathanDefense5 = new ActionCombat(incrementId(), "Aura Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO);
		ActionCombat jonathanDefense6 = new ActionCombat(incrementId(), "Aura Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO);
		ActionCombat jonathanDefense7 = new ActionCombat(incrementId(), "Aura Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI);
		ActionCombat jonathanDefense8 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE);
		ActionCombat jonathanSort1 = new ActionCombat(incrementId(), "Regen Vie Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO);
		ActionCombat jonathanSort2= new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO);
		ActionCombat jonathanSort3 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI);
		ActionCombat jonathanSort4 = new ActionCombat(incrementId(), "Absorb Vie Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO);
		ActionCombat jonathanSort5 = new ActionCombat(incrementId(), "Absorb Vie Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI);
		ActionCombat jonathanSort6 = new ActionCombat(incrementId(), "Regen Mana Perso", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO);
		ActionCombat jonathanSort7 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO);
		ActionCombat jonathanSort8 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI);
		ActionCombat jonathanSort9 = new ActionCombat(incrementId(), "Absorb Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO);
		ActionCombat jonathanSort10 = new ActionCombat(incrementId(), "Absorb Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI);
		ActionCombat jonathanSort11 = new ActionCombat(incrementId(), "Brulure Mana Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO);
		ActionCombat jonathanSort12 = new ActionCombat(incrementId(), "Brulure Mana Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI);
		ActionCombat jonathanSort13 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO);
		ActionCombat jonathanSort14 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI);
		ActionCombat jonathanSort15 = new ActionCombat(incrementId(), "Taunt Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO);
		ActionCombat jonathanSort16 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI);
		ActionCombat jonathanSort17 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO);
		ActionCombat jonathanSort18 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI);
		ActionCombat jonathanSpecial1 = new ActionCombat(incrementId(), "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI);
		ActionCombat jonathanSpecial2 = new ActionCombat(incrementId(), "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonPaths, videoPaths, disponible, niveau, niveauMax, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL);
		
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
