package modele.competence;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import modele.item.personnage.PersoPrenom;

public class Competence implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<PersoStat, Integer> stats = null;

	public Competence() {

		stats = new HashMap<PersoStat, Integer>();

		// normal / jeu de foot / jeu de combat / jeu de Quizz
		// -Luck /Liberte Creative-Chance /Chance de critique /
		// -Exploit /Attaque-Tir /Degats critique /
		// -Technique /Technique /Degats min /
		// -Endurance /Energie-Endurance /Vie max /
		// -Rapidite /Reactivite-Vitesse /Vitesse de recuperation stun /
		// -Resistance /Robustesse-Defense /Reduction Degats /
		// -Agilite /Acceleration-Agilite /chance d'esquive /
		// -Intelligence /Instinct /Mana max /
		// -Nervosite /Nervosite /Nombre de charge max /

		stats.put(PersoStat.LUCK, 50); // min 3 => chance de crit min = chance/3
										// / esquive 10% (/3)
		stats.put(PersoStat.EXPLOIT, 50); // min 20 => degats crit min = expl/20
											// (/20)
		stats.put(PersoStat.TECHNIQUE, 50); // min 2 => degats min = agi/2 (/2)
		stats.put(PersoStat.ENDURANCE, 50); // vie Max = endu*10 (*10)
		stats.put(PersoStat.RAPIDITE, 50); // esquive 10%
		stats.put(PersoStat.RESISTANCE, 50); // min 0 (conseille 20) =>
												// reduction degats max = -80%
												// (-20)
		stats.put(PersoStat.AGILITE, 50); // esquive 10%
		stats.put(PersoStat.INTELLIGENCE, 50); // mana max = inte
		stats.put(PersoStat.NERVOSITE, 50); // min 25 => nombre charge max = 5
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

	// TODO stats ali/russ/guy plus elevees car arrivée tardive dans le jeu
	public Competence(PersoPrenom prenom, boolean max) {
		stats = new HashMap<PersoStat, Integer>();

		// TODO equilibrer les persos / fonction de la difficulte ??
		// (debut =~ 300/900)
		// (fin =~ 600/900)

		// Competences max
		if (max) {
			if (prenom == PersoPrenom.Johann) {
				stats.put(PersoStat.LUCK, 100);
				stats.put(PersoStat.EXPLOIT, 40);
				stats.put(PersoStat.TECHNIQUE, 90);
				stats.put(PersoStat.ENDURANCE, 70);
				stats.put(PersoStat.RAPIDITE, 90);
				stats.put(PersoStat.RESISTANCE, 70);
				stats.put(PersoStat.AGILITE, 70);
				stats.put(PersoStat.INTELLIGENCE, 70);
				stats.put(PersoStat.NERVOSITE, 90);
			} else if (prenom == PersoPrenom.Nicolas) {
				stats.put(PersoStat.LUCK, 90);
				stats.put(PersoStat.EXPLOIT, 100);
				stats.put(PersoStat.TECHNIQUE, 50);
				stats.put(PersoStat.ENDURANCE, 50);
				stats.put(PersoStat.RAPIDITE, 50);
				stats.put(PersoStat.RESISTANCE, 50);
				stats.put(PersoStat.AGILITE, 60);
				stats.put(PersoStat.INTELLIGENCE, 60);
				stats.put(PersoStat.NERVOSITE, 70);
			} else if (prenom == PersoPrenom.Pierre) {
				stats.put(PersoStat.LUCK, 70);
				stats.put(PersoStat.EXPLOIT, 50);
				stats.put(PersoStat.TECHNIQUE, 80);
				stats.put(PersoStat.ENDURANCE, 90);
				stats.put(PersoStat.RAPIDITE, 80);
				stats.put(PersoStat.RESISTANCE, 80);
				stats.put(PersoStat.AGILITE, 100);
				stats.put(PersoStat.INTELLIGENCE, 90);
				stats.put(PersoStat.NERVOSITE, 40);
			} else if (prenom == PersoPrenom.Thomas) {
				stats.put(PersoStat.LUCK, 30);
				stats.put(PersoStat.EXPLOIT, 60);
				stats.put(PersoStat.TECHNIQUE, 40);
				stats.put(PersoStat.ENDURANCE, 80);
				stats.put(PersoStat.RAPIDITE, 40);
				stats.put(PersoStat.RESISTANCE, 60);
				stats.put(PersoStat.AGILITE, 50);
				stats.put(PersoStat.INTELLIGENCE, 100);
				stats.put(PersoStat.NERVOSITE, 30);
			} else if (prenom == PersoPrenom.Yannick) {
				stats.put(PersoStat.LUCK, 80);
				stats.put(PersoStat.EXPLOIT, 30);
				stats.put(PersoStat.TECHNIQUE, 30);
				stats.put(PersoStat.ENDURANCE, 40);
				stats.put(PersoStat.RAPIDITE, 30);
				stats.put(PersoStat.RESISTANCE, 100);
				stats.put(PersoStat.AGILITE, 40);
				stats.put(PersoStat.INTELLIGENCE, 80);
				stats.put(PersoStat.NERVOSITE, 50);
			} else if (prenom == PersoPrenom.Ali) {
				stats.put(PersoStat.LUCK, 40);
				stats.put(PersoStat.EXPLOIT, 80);
				stats.put(PersoStat.TECHNIQUE, 60);
				stats.put(PersoStat.ENDURANCE, 60);
				stats.put(PersoStat.RAPIDITE, 100);
				stats.put(PersoStat.RESISTANCE, 30);
				stats.put(PersoStat.AGILITE, 90);
				stats.put(PersoStat.INTELLIGENCE, 50);
				stats.put(PersoStat.NERVOSITE, 80);
			} else if (prenom == PersoPrenom.Guillaume) {
				stats.put(PersoStat.LUCK, 60);
				stats.put(PersoStat.EXPLOIT, 70);
				stats.put(PersoStat.TECHNIQUE, 100);
				stats.put(PersoStat.ENDURANCE, 30);
				stats.put(PersoStat.RAPIDITE, 60);
				stats.put(PersoStat.RESISTANCE, 40);
				stats.put(PersoStat.AGILITE, 80);
				stats.put(PersoStat.INTELLIGENCE, 30);
				stats.put(PersoStat.NERVOSITE, 60);
			} else if (prenom == PersoPrenom.Jonathan) {
				stats.put(PersoStat.LUCK, 50);
				stats.put(PersoStat.EXPLOIT, 90);
				stats.put(PersoStat.TECHNIQUE, 70);
				stats.put(PersoStat.ENDURANCE, 100);
				stats.put(PersoStat.RAPIDITE, 70);
				stats.put(PersoStat.RESISTANCE, 90);
				stats.put(PersoStat.AGILITE, 30);
				stats.put(PersoStat.INTELLIGENCE, 40);
				stats.put(PersoStat.NERVOSITE, 100);
			}
		} else {
			// Competences de depart
			if (prenom == PersoPrenom.Johann) {
				stats.put(PersoStat.LUCK, 50);
				stats.put(PersoStat.EXPLOIT, 25);
				stats.put(PersoStat.TECHNIQUE, 25);
				stats.put(PersoStat.ENDURANCE, 25);
				stats.put(PersoStat.RAPIDITE, 25);
				stats.put(PersoStat.RESISTANCE, 25);
				stats.put(PersoStat.AGILITE, 25);
				stats.put(PersoStat.INTELLIGENCE, 25);
				stats.put(PersoStat.NERVOSITE, 25);
			} else if (prenom == PersoPrenom.Nicolas) {
				stats.put(PersoStat.LUCK, 25);
				stats.put(PersoStat.EXPLOIT, 50);
				stats.put(PersoStat.TECHNIQUE, 25);
				stats.put(PersoStat.ENDURANCE, 25);
				stats.put(PersoStat.RAPIDITE, 25);
				stats.put(PersoStat.RESISTANCE, 25);
				stats.put(PersoStat.AGILITE, 25);
				stats.put(PersoStat.INTELLIGENCE, 25);
				stats.put(PersoStat.NERVOSITE, 25);
			} else if (prenom == PersoPrenom.Pierre) {
				stats.put(PersoStat.LUCK, 25);
				stats.put(PersoStat.EXPLOIT, 25);
				stats.put(PersoStat.TECHNIQUE, 25);
				stats.put(PersoStat.ENDURANCE, 25);
				stats.put(PersoStat.RAPIDITE, 25);
				stats.put(PersoStat.RESISTANCE, 25);
				stats.put(PersoStat.AGILITE, 50);
				stats.put(PersoStat.INTELLIGENCE, 25);
				stats.put(PersoStat.NERVOSITE, 25);
			} else if (prenom == PersoPrenom.Thomas) {
				stats.put(PersoStat.LUCK, 25);
				stats.put(PersoStat.EXPLOIT, 25);
				stats.put(PersoStat.TECHNIQUE, 25);
				stats.put(PersoStat.ENDURANCE, 25);
				stats.put(PersoStat.RAPIDITE, 25);
				stats.put(PersoStat.RESISTANCE, 25);
				stats.put(PersoStat.AGILITE, 25);
				stats.put(PersoStat.INTELLIGENCE, 50);
				stats.put(PersoStat.NERVOSITE, 25);
			} else if (prenom == PersoPrenom.Yannick) {
				stats.put(PersoStat.LUCK, 25);
				stats.put(PersoStat.EXPLOIT, 25);
				stats.put(PersoStat.TECHNIQUE, 25);
				stats.put(PersoStat.ENDURANCE, 25);
				stats.put(PersoStat.RAPIDITE, 25);
				stats.put(PersoStat.RESISTANCE, 50);
				stats.put(PersoStat.AGILITE, 25);
				stats.put(PersoStat.INTELLIGENCE, 25);
				stats.put(PersoStat.NERVOSITE, 25);
			}
			// TODO stats plus eleve pour les 3 derniers persos
			else if (prenom == PersoPrenom.Ali) {
				// Ali stats max -30
				stats.put(PersoStat.LUCK, 25);
				stats.put(PersoStat.EXPLOIT, 50);
				stats.put(PersoStat.TECHNIQUE, 30);
				stats.put(PersoStat.ENDURANCE, 30);
				stats.put(PersoStat.RAPIDITE, 70);
				stats.put(PersoStat.RESISTANCE, 25);
				stats.put(PersoStat.AGILITE, 60);
				stats.put(PersoStat.INTELLIGENCE, 25);
				stats.put(PersoStat.NERVOSITE, 50);
			} else if (prenom == PersoPrenom.Guillaume) {
				// Guillaume stats max -20
				stats.put(PersoStat.LUCK, 40);
				stats.put(PersoStat.EXPLOIT, 50);
				stats.put(PersoStat.TECHNIQUE, 80);
				stats.put(PersoStat.ENDURANCE, 25);
				stats.put(PersoStat.RAPIDITE, 40);
				stats.put(PersoStat.RESISTANCE, 20);
				stats.put(PersoStat.AGILITE, 60);
				stats.put(PersoStat.INTELLIGENCE, 25);
				stats.put(PersoStat.NERVOSITE, 40);
			} else if (prenom == PersoPrenom.Jonathan) {
				// Jonathan stats max -10
				stats.put(PersoStat.LUCK, 40);
				stats.put(PersoStat.EXPLOIT, 80);
				stats.put(PersoStat.TECHNIQUE, 60);
				stats.put(PersoStat.ENDURANCE, 90);
				stats.put(PersoStat.RAPIDITE, 60);
				stats.put(PersoStat.RESISTANCE, 80);
				stats.put(PersoStat.AGILITE, 25);
				stats.put(PersoStat.INTELLIGENCE, 30);
				stats.put(PersoStat.NERVOSITE, 90);
			}
		}
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
