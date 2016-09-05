package modele.bonus;

import java.io.Serializable;
import java.util.Map;

import modele.competence.PersoStat;
import modele.item.personnage.PersoPrenom;

public class Bonus implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// Valeur des stats a ajouter par perso
	private Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap;
	
	public Bonus(Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap) {
		this.bonusMap = bonusMap;
	}

	public Map<PersoPrenom,Map<PersoStat,Integer>> getBonusMap() {
		return bonusMap;
	}
	
}
