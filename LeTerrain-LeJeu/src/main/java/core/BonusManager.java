package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import front.MainFrame;
import modele.bonus.Bonus;
import modele.competence.PersoStat;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class BonusManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static List<Bonus> allBonus;

	public void initialise() {
		allBonus = new ArrayList<Bonus>();
		
		// Chargement des Bonus
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapVide = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		
//		Map<PersoStat,Integer> statsMapNicoVide = new HashMap<PersoStat,Integer>();
//		Map<PersoStat,Integer> statsMapPipoVide = new HashMap<PersoStat,Integer>();
//		Map<PersoStat,Integer> statsMapYacoVide = new HashMap<PersoStat,Integer>();
//		Map<PersoStat,Integer> statsMapTomVide = new HashMap<PersoStat,Integer>();
//		Map<PersoStat,Integer> statsMapYoVide = new HashMap<PersoStat,Integer>();
//		
//		bonusMapVide.put(PersoPrenom.Nicolas, statsMapNicoVide);
//		bonusMapVide.put(PersoPrenom.Johann, statsMapYoVide);
//		bonusMapVide.put(PersoPrenom.Pierre, statsMapPipoVide);
//		bonusMapVide.put(PersoPrenom.Thomas, statsMapTomVide);
//		bonusMapVide.put(PersoPrenom.Yannick, statsMapYacoVide);
		
		Bonus bonusVide = new Bonus(0, bonusMapVide);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap1 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		
		Map<PersoStat,Integer> statsMapNico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapPipo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapYaco = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapTom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapYo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapAli = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapGuy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapJo = new HashMap<PersoStat,Integer>();
		
		statsMapNico.put(PersoStat.ENDURANCE, new Integer(1));
		statsMapPipo.put(PersoStat.ENDURANCE, new Integer(1));
		statsMapYaco.put(PersoStat.ENDURANCE, new Integer(1));
		statsMapTom.put(PersoStat.ENDURANCE, new Integer(1));
		statsMapYo.put(PersoStat.ENDURANCE, new Integer(1));
		statsMapAli.put(PersoStat.ENDURANCE, new Integer(1));
		statsMapGuy.put(PersoStat.ENDURANCE, new Integer(1));
		statsMapJo.put(PersoStat.ENDURANCE, new Integer(1));
		
		statsMapNico.put(PersoStat.TECHNIQUE, new Integer(1));
		statsMapPipo.put(PersoStat.TECHNIQUE, new Integer(1));
		statsMapYaco.put(PersoStat.TECHNIQUE, new Integer(1));
		statsMapTom.put(PersoStat.TECHNIQUE, new Integer(1));
		statsMapYo.put(PersoStat.TECHNIQUE, new Integer(1));
		statsMapAli.put(PersoStat.TECHNIQUE, new Integer(1));
		statsMapGuy.put(PersoStat.TECHNIQUE, new Integer(1));
		statsMapJo.put(PersoStat.TECHNIQUE, new Integer(1));
		
		statsMapNico.put(PersoStat.AGILITE, new Integer(1));
		statsMapPipo.put(PersoStat.AGILITE, new Integer(1));
		statsMapYaco.put(PersoStat.AGILITE, new Integer(1));
		statsMapTom.put(PersoStat.AGILITE, new Integer(1));
		statsMapYo.put(PersoStat.AGILITE, new Integer(1));
		statsMapAli.put(PersoStat.AGILITE, new Integer(1));
		statsMapGuy.put(PersoStat.AGILITE, new Integer(1));
		statsMapJo.put(PersoStat.AGILITE, new Integer(1));
		
		bonusMap1.put(PersoPrenom.Nicolas, statsMapNico);
		bonusMap1.put(PersoPrenom.Johann, statsMapYo);
		bonusMap1.put(PersoPrenom.Pierre, statsMapPipo);
		bonusMap1.put(PersoPrenom.Thomas, statsMapTom);
		bonusMap1.put(PersoPrenom.Yannick, statsMapYaco);
		bonusMap1.put(PersoPrenom.Ali, statsMapAli);
		bonusMap1.put(PersoPrenom.Guillaume, statsMapGuy);
		bonusMap1.put(PersoPrenom.Jonathan, statsMapJo);

		// Malus -1
//		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap2 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
//		
//		Map<PersoStat,Integer> statsMapNico2 = new HashMap<PersoStat,Integer>();
//		Map<PersoStat,Integer> statsMapPipo2 = new HashMap<PersoStat,Integer>();
//		Map<PersoStat,Integer> statsMapYaco2 = new HashMap<PersoStat,Integer>();
//		Map<PersoStat,Integer> statsMapTom2 = new HashMap<PersoStat,Integer>();
//		Map<PersoStat,Integer> statsMapYo2 = new HashMap<PersoStat,Integer>();
//		
//		statsMapNico2.put(PersoStat.RAPIDITE, new Integer(-1));
//		statsMapPipo2.put(PersoStat.ENDURANCE, new Integer(-1));
//		statsMapYaco2.put(PersoStat.RESISTANCE, new Integer(-1));
//		statsMapTom2.put(PersoStat.INTELLIGENCE, new Integer(-1));
//		statsMapYo2.put(PersoStat.EXPLOIT, new Integer(-1));
//		
//		bonusMap2.put(PersoPrenom.Nicolas, statsMapNico2);
//		bonusMap2.put(PersoPrenom.Johann, statsMapYo2);
//		bonusMap2.put(PersoPrenom.Pierre, statsMapPipo2);
//		bonusMap2.put(PersoPrenom.Thomas, statsMapTom2);
//		bonusMap2.put(PersoPrenom.Yannick, statsMapYaco2);
//		
//		Bonus bonus2 = new Bonus(2, bonusMap2);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap3 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapRuss = new HashMap<PersoStat,Integer>();
		statsMapRuss.put(PersoStat.ENDURANCE, new Integer(1));
		bonusMap3.put(PersoPrenom.Jonathan, statsMapRuss);
		
		Bonus bonusFoot = new Bonus(20, bonusMap1);
		Bonus bonusPiscine = new Bonus(10, bonusMap3);
		
		allBonus.add(bonusVide);
		allBonus.add(bonusFoot);
		allBonus.add(bonusPiscine);
	}
	
	public static void distribueBonus(Groupe groupe, Bonus bonus) {
		for (PersonnagePrincipal perso : groupe.getPersos()) {
			// On distribue le bonus si le perso est deja dans le groupe et qu'il est vivant 
			if (bonus.getBonusMap().containsKey(perso.getPrenomPerso()) && perso.isDejaPresente() && !perso.isMort()) {
				perso.addCompetences(bonus.getBonusMap().get(perso.getPrenomPerso()));
			}
		}
	}
	
	public static List<Bonus> getAllBonus() {
		return allBonus;
	}

	public static Bonus getBonusById(int id) {
		Bonus newBonus = null;
		for (Bonus bonus : allBonus) {
			if (bonus.getId() == id) {
				newBonus = bonus;
			}
		}
		return newBonus;
	}
}
