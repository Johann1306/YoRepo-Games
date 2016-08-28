package modele.competence;

import java.util.HashMap;
import java.util.Map;

public class Competence {

	private Map<PersoStat, Integer> stats = null;
	
	public void initialise() {
		
		stats = new HashMap<>();
		
		stats.put(PersoStat.LUCK, 50);
		stats.put(PersoStat.LIBERTE_CREATIVE, 50);
		stats.put(PersoStat.EXPLOIT, 50);
		stats.put(PersoStat.TECHNIQUE, 50);
		stats.put(PersoStat.TIR, 50);
		stats.put(PersoStat.ENDURANCE, 50);
		stats.put(PersoStat.ENERGIE, 50);
		stats.put(PersoStat.RAPIDITE, 50);
		stats.put(PersoStat.REACTIVITE, 50);
		stats.put(PersoStat.RESISTANCE, 50);
		stats.put(PersoStat.ROBUSTESSE, 50);
		stats.put(PersoStat.AGILITE, 50);
		stats.put(PersoStat.ACCELERATION, 50);
		stats.put(PersoStat.INTELLIGENCE, 50);
		stats.put(PersoStat.INSTINCT, 50);
		stats.put(PersoStat.NERVOSITE, 50);
		stats.put(PersoStat.NOOBISME, 50);
	}
	
	
}
