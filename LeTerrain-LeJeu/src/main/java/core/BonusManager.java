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

	private static List<Bonus> allBonus;

	public void initialise() {
		allBonus = new ArrayList<>();
		
		// Chargement des Bonus
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapVide = new HashMap<>();
		
		Map<PersoStat,Integer> statsMapNicoVide = new HashMap<>();
		Map<PersoStat,Integer> statsMapPipoVide = new HashMap<>();
		Map<PersoStat,Integer> statsMapYacoVide = new HashMap<>();
		Map<PersoStat,Integer> statsMapTomVide = new HashMap<>();
		Map<PersoStat,Integer> statsMapYoVide = new HashMap<>();
		
		bonusMapVide.put(PersoPrenom.NICOLAS, statsMapNicoVide);
		bonusMapVide.put(PersoPrenom.JOHANN, statsMapYoVide);
		bonusMapVide.put(PersoPrenom.PIERRE, statsMapPipoVide);
		bonusMapVide.put(PersoPrenom.THOMAS, statsMapTomVide);
		bonusMapVide.put(PersoPrenom.YANNICK, statsMapYacoVide);
		
		Bonus bonusVide = new Bonus(bonusMapVide);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap1 = new HashMap<>();
		
		Map<PersoStat,Integer> statsMapNico = new HashMap<>();
		Map<PersoStat,Integer> statsMapPipo = new HashMap<>();
		Map<PersoStat,Integer> statsMapYaco = new HashMap<>();
		Map<PersoStat,Integer> statsMapTom = new HashMap<>();
		Map<PersoStat,Integer> statsMapYo = new HashMap<>();
		
		statsMapNico.put(PersoStat.ACCELERATION, new Integer(2));
		statsMapPipo.put(PersoStat.ACCELERATION, new Integer(2));
		statsMapYaco.put(PersoStat.ACCELERATION, new Integer(2));
		statsMapTom.put(PersoStat.ACCELERATION, new Integer(2));
		statsMapYo.put(PersoStat.ACCELERATION, new Integer(2));
		
		bonusMap1.put(PersoPrenom.NICOLAS, statsMapNico);
		bonusMap1.put(PersoPrenom.JOHANN, statsMapYo);
		bonusMap1.put(PersoPrenom.PIERRE, statsMapPipo);
		bonusMap1.put(PersoPrenom.THOMAS, statsMapTom);
		bonusMap1.put(PersoPrenom.YANNICK, statsMapYaco);
		
		Bonus bonus1 = new Bonus(bonusMap1);
		
		// Chargement des Bonus
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap2 = new HashMap<>();
		
		Map<PersoStat,Integer> statsMapNico2 = new HashMap<>();
		Map<PersoStat,Integer> statsMapPipo2 = new HashMap<>();
		Map<PersoStat,Integer> statsMapYaco2 = new HashMap<>();
		Map<PersoStat,Integer> statsMapTom2 = new HashMap<>();
		Map<PersoStat,Integer> statsMapYo2 = new HashMap<>();
		
		statsMapNico2.put(PersoStat.ACCELERATION, new Integer(-1));
		statsMapPipo2.put(PersoStat.ACCELERATION, new Integer(-1));
		statsMapYaco2.put(PersoStat.ACCELERATION, new Integer(-1));
		statsMapTom2.put(PersoStat.ACCELERATION, new Integer(-1));
		statsMapYo2.put(PersoStat.ACCELERATION, new Integer(-1));
		
		bonusMap2.put(PersoPrenom.NICOLAS, statsMapNico2);
		bonusMap2.put(PersoPrenom.JOHANN, statsMapYo2);
		bonusMap2.put(PersoPrenom.PIERRE, statsMapPipo2);
		bonusMap2.put(PersoPrenom.THOMAS, statsMapTom2);
		bonusMap2.put(PersoPrenom.YANNICK, statsMapYaco2);
		
		Bonus bonus2 = new Bonus(bonusMap2);
		
		allBonus.add(bonusVide);
		allBonus.add(bonus1);
		allBonus.add(bonus2);
	}
	
	public static void distribueBonus(Groupe groupe, Bonus bonus) {
		for (PersonnagePrincipal perso : groupe.getPersos()) {
			if (bonus.getBonusMap().containsKey(perso)) {
				perso.addCompetences(bonus.getBonusMap().get(perso));
			}
		}
	}
	
	public static List<Bonus> getAllBonus() {
		return allBonus;
	}
}
