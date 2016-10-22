package modele.competence;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Competence implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<PersoStat, Integer> stats = null;
	
	public Competence() {
		
		stats = new HashMap<PersoStat, Integer>();
		
//			normal 		/	 jeu de foot			/	 jeu de combat					/	jeu de Quizz
//		-Luck			/Liberte Creative-Chance	/Chance de critique					/
//		-Exploit		/Attaque-Tir				/Degats Critique					/
//		-Technique		/Technique					/Attaque degats min					/
//		-Endurance		/Energie-Endurance			/Vie								/
//		-Rapidite		/Reactivite-Vitesse			/Vitesse de recuperation stun		/
//		-Resistance		/Robustesse-Defense			/Defense							/
//		-Agilite		/Acceleration-Agilite		/Agilite							/
//		-Intelligence	/Instinct					/Mana								/
//		-Noobisme		/Nervosite					/Nombre de charge					/
		
		stats.put(PersoStat.LUCK, 50);
		stats.put(PersoStat.EXPLOIT, 50);
		stats.put(PersoStat.TECHNIQUE, 50);
		stats.put(PersoStat.ENDURANCE, 50);
		stats.put(PersoStat.RAPIDITE, 50);
		stats.put(PersoStat.RESISTANCE, 50);
		stats.put(PersoStat.AGILITE, 50);
		stats.put(PersoStat.INTELLIGENCE, 50);
		stats.put(PersoStat.NERVOSITE, 50);
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
