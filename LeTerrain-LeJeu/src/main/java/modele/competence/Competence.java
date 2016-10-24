package modele.competence;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import modele.item.mission.enums.MissionDifficulty;

public class Competence implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<PersoStat, Integer> stats = null;
	
	public Competence() {
		
		stats = new HashMap<PersoStat, Integer>();
		
//			normal 		/	 jeu de foot			/	 jeu de combat					/	jeu de Quizz
//		-Luck			/Liberte Creative-Chance	/Chance de critique					/
//		-Exploit		/Attaque-Tir				/Degats critique					/
//		-Technique		/Technique					/Degats min							/
//		-Endurance		/Energie-Endurance			/Vie max							/
//		-Rapidite		/Reactivite-Vitesse			/Vitesse de recuperation stun		/
//		-Resistance		/Robustesse-Defense			/Reduction Degats					/
//		-Agilite		/Acceleration-Agilite		/chance d'esquive							/
//		-Intelligence	/Instinct					/Mana max							/
//		-Nervosite		/Nervosite					/Nombre de charge max				/
		
		stats.put(PersoStat.LUCK, 50);			// min 3 => chance de crit min = chance/3				(/3)
		stats.put(PersoStat.EXPLOIT, 50);		// min 10 => degats crit min = expl/10					(/10)
		stats.put(PersoStat.TECHNIQUE, 50);
		stats.put(PersoStat.ENDURANCE, 50);
		stats.put(PersoStat.RAPIDITE, 50);
		stats.put(PersoStat.RESISTANCE, 50);	// min 0 (conseille 20) => reduction degats max = -80% 	(-20)
		stats.put(PersoStat.AGILITE, 50);		// min 2 => degats min = agi/2 							(/2)
		stats.put(PersoStat.INTELLIGENCE, 50);
		stats.put(PersoStat.NERVOSITE, 50);
	}
	
	public Competence(int valeur) {
		
		stats = new HashMap<PersoStat, Integer>();
		
		stats.put(PersoStat.LUCK, valeur);			
		stats.put(PersoStat.EXPLOIT, valeur);		
		stats.put(PersoStat.TECHNIQUE, valeur);
		stats.put(PersoStat.ENDURANCE, valeur);
		stats.put(PersoStat.RAPIDITE, valeur);
		stats.put(PersoStat.RESISTANCE, valeur);	
		stats.put(PersoStat.AGILITE, valeur);		
		stats.put(PersoStat.INTELLIGENCE, valeur);
		stats.put(PersoStat.NERVOSITE, valeur);
	}
	
	public Map<PersoStat, Integer> getStats() {
		return stats;
	}

	@Override
	public String toString() {
		return "Competence [stats=" + stats + "]";
	}

	public int getLuck() {
		return stats.get(PersoStat.LUCK);
	}
	
	public int getExploit() {
		return stats.get(PersoStat.EXPLOIT);
	}
	
	public int getTechnique() {
		return stats.get(PersoStat.TECHNIQUE);
	}
	
	public int getEndurance() {
		return stats.get(PersoStat.ENDURANCE);
	}
	
	public int getRapidite() {
		return stats.get(PersoStat.RAPIDITE);
	}
	
	public int getResistance() {
		return stats.get(PersoStat.RESISTANCE);
	}
	
	public int getAgilite() {
		return stats.get(PersoStat.AGILITE);
	}
	
	public int getIntelligence() {
		return stats.get(PersoStat.INTELLIGENCE);
	}
	
	public int getNervosite() {
		return stats.get(PersoStat.NERVOSITE);
	}
}
