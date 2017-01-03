package modele.bonus;

import java.io.Serializable;
import java.util.Map;

import modele.competence.PersoStat;
import modele.item.personnage.PersoPrenom;

public class Bonus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;

	// Valeur des stats a ajouter par perso
	private Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap;
		
	public Bonus(int id, Map<PersoPrenom,Map<PersoStat,Integer>> bonusMap) {
		this.id = id;
		this.bonusMap = bonusMap;
	}

	public Map<PersoPrenom,Map<PersoStat,Integer>> getBonusMap() {
		return bonusMap;
	}

	public int getId() {
		return id;
	}
	
}
