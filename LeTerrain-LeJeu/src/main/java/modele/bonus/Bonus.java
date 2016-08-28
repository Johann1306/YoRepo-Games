package modele.bonus;

import java.util.Map;

import modele.competence.PersoStat;
import modele.item.personnage.PersoPrenom;

public class Bonus {
	
	// Valeur des stats a ajouter par perso
	private Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap;
	
	public Bonus(Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap) {
		this.bonusMap = bonusMap;
	}

	public Map<PersoPrenom,Map<PersoStat,Integer>> getBonusMap() {
		return bonusMap;
	}
	
}
