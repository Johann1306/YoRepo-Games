package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		Map<PersoStat,Integer> statsMapNicoVide = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapPipoVide = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapYacoVide = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapTomVide = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapYoVide = new HashMap<PersoStat,Integer>();
		
		bonusMapVide.put(PersoPrenom.Nicolas, statsMapNicoVide);
		bonusMapVide.put(PersoPrenom.Johann, statsMapYoVide);
		bonusMapVide.put(PersoPrenom.Pierre, statsMapPipoVide);
		bonusMapVide.put(PersoPrenom.Thomas, statsMapTomVide);
		bonusMapVide.put(PersoPrenom.Yannick, statsMapYacoVide);
		
		Bonus bonusVide = new Bonus(bonusMapVide);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap1 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		
		Map<PersoStat,Integer> statsMapNico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapPipo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapYaco = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapTom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapYo = new HashMap<PersoStat,Integer>();
		
		statsMapNico.put(PersoStat.RAPIDITE, new Integer(2));
		statsMapPipo.put(PersoStat.ENDURANCE, new Integer(2));
		statsMapYaco.put(PersoStat.RESISTANCE, new Integer(2));
		statsMapTom.put(PersoStat.INTELLIGENCE, new Integer(2));
		statsMapYo.put(PersoStat.EXPLOIT, new Integer(2));
		
		bonusMap1.put(PersoPrenom.Nicolas, statsMapNico);
		bonusMap1.put(PersoPrenom.Johann, statsMapYo);
		bonusMap1.put(PersoPrenom.Pierre, statsMapPipo);
		bonusMap1.put(PersoPrenom.Thomas, statsMapTom);
		bonusMap1.put(PersoPrenom.Yannick, statsMapYaco);
		
		Bonus bonus1 = new Bonus(bonusMap1);
		
		// Chargement des Bonus
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap2 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		
		Map<PersoStat,Integer> statsMapNico2 = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapPipo2 = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapYaco2 = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapTom2 = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapYo2 = new HashMap<PersoStat,Integer>();
		
		statsMapNico2.put(PersoStat.RAPIDITE, new Integer(-1));
		statsMapPipo2.put(PersoStat.ENDURANCE, new Integer(-1));
		statsMapYaco2.put(PersoStat.RESISTANCE, new Integer(-1));
		statsMapTom2.put(PersoStat.INTELLIGENCE, new Integer(-1));
		statsMapYo2.put(PersoStat.EXPLOIT, new Integer(-1));
		
		bonusMap2.put(PersoPrenom.Nicolas, statsMapNico2);
		bonusMap2.put(PersoPrenom.Johann, statsMapYo2);
		bonusMap2.put(PersoPrenom.Pierre, statsMapPipo2);
		bonusMap2.put(PersoPrenom.Thomas, statsMapTom2);
		bonusMap2.put(PersoPrenom.Yannick, statsMapYaco2);
		
		Bonus bonus2 = new Bonus(bonusMap2);
		
		allBonus.add(bonusVide);
		allBonus.add(bonus1);
		allBonus.add(bonus2);
	}
	
	public static void distribueBonus(Groupe groupe, Bonus bonus) {
		for (PersonnagePrincipal perso : groupe.getPersos()) {
			if (bonus.getBonusMap().containsKey(perso.getPrenom())) {
				perso.addCompetences(bonus.getBonusMap().get(perso.getPrenom()));
			}
		}
	}
	
	public static List<Bonus> getAllBonus() {
		return allBonus;
	}
}
