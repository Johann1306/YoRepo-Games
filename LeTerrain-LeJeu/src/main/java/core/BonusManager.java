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
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapFoot = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		
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
		
		bonusMapFoot.put(PersoPrenom.Nicolas, statsMapNico);
		bonusMapFoot.put(PersoPrenom.Johann, statsMapYo);
		bonusMapFoot.put(PersoPrenom.Pierre, statsMapPipo);
		bonusMapFoot.put(PersoPrenom.Thomas, statsMapTom);
		bonusMapFoot.put(PersoPrenom.Yannick, statsMapYaco);
		bonusMapFoot.put(PersoPrenom.Ali, statsMapAli);
		bonusMapFoot.put(PersoPrenom.Guillaume, statsMapGuy);
		bonusMapFoot.put(PersoPrenom.Jonathan, statsMapJo);

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
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapPiscine = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapRuss = new HashMap<PersoStat,Integer>();
		statsMapRuss.put(PersoStat.ENDURANCE, new Integer(1));
		bonusMapPiscine.put(PersoPrenom.Jonathan, statsMapRuss);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapBoss1 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapBoss1Yo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss1Nico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss1Pip = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss1Tom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss1Ya = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss1Ali = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss1Guy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss1Russ = new HashMap<PersoStat,Integer>();
		statsMapBoss1Yo.put(PersoStat.LUCK, new Integer(20));
		statsMapBoss1Nico.put(PersoStat.LUCK, new Integer(20));
		statsMapBoss1Pip.put(PersoStat.LUCK, new Integer(20));
		statsMapBoss1Tom.put(PersoStat.LUCK, new Integer(20));
		statsMapBoss1Ya.put(PersoStat.LUCK, new Integer(20));
		statsMapBoss1Ali.put(PersoStat.LUCK, new Integer(20));
		statsMapBoss1Guy.put(PersoStat.LUCK, new Integer(20));
		statsMapBoss1Russ.put(PersoStat.LUCK, new Integer(20));
		bonusMapBoss1.put(PersoPrenom.Johann, statsMapBoss1Yo);
		bonusMapBoss1.put(PersoPrenom.Nicolas, statsMapBoss1Nico);
		bonusMapBoss1.put(PersoPrenom.Pierre, statsMapBoss1Pip);
		bonusMapBoss1.put(PersoPrenom.Thomas, statsMapBoss1Tom);
		bonusMapBoss1.put(PersoPrenom.Yannick, statsMapBoss1Ya);
		bonusMapBoss1.put(PersoPrenom.Ali, statsMapBoss1Ali);
		bonusMapBoss1.put(PersoPrenom.Guillaume, statsMapBoss1Guy);
		bonusMapBoss1.put(PersoPrenom.Jonathan, statsMapBoss1Russ);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapBoss2 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapBoss2Yo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss2Nico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss2Pip = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss2Tom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss2Ya = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss2Ali = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss2Guy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss2Russ = new HashMap<PersoStat,Integer>();
		statsMapBoss2Yo.put(PersoStat.EXPLOIT, new Integer(20));
		statsMapBoss2Nico.put(PersoStat.EXPLOIT, new Integer(20));
		statsMapBoss2Pip.put(PersoStat.EXPLOIT, new Integer(20));
		statsMapBoss2Tom.put(PersoStat.EXPLOIT, new Integer(20));
		statsMapBoss2Ya.put(PersoStat.EXPLOIT, new Integer(20));
		statsMapBoss2Ali.put(PersoStat.EXPLOIT, new Integer(20));
		statsMapBoss2Guy.put(PersoStat.EXPLOIT, new Integer(20));
		statsMapBoss2Russ.put(PersoStat.EXPLOIT, new Integer(20));
		bonusMapBoss2.put(PersoPrenom.Johann, statsMapBoss2Yo);
		bonusMapBoss2.put(PersoPrenom.Nicolas, statsMapBoss2Nico);
		bonusMapBoss2.put(PersoPrenom.Pierre, statsMapBoss2Pip);
		bonusMapBoss2.put(PersoPrenom.Thomas, statsMapBoss2Tom);
		bonusMapBoss2.put(PersoPrenom.Yannick, statsMapBoss2Ya);
		bonusMapBoss2.put(PersoPrenom.Ali, statsMapBoss2Ali);
		bonusMapBoss2.put(PersoPrenom.Guillaume, statsMapBoss2Guy);
		bonusMapBoss2.put(PersoPrenom.Jonathan, statsMapBoss2Russ);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapBoss3 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapBoss3Yo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss3Nico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss3Pip = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss3Tom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss3Ya = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss3Ali = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss3Guy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss3Russ = new HashMap<PersoStat,Integer>();
		statsMapBoss3Yo.put(PersoStat.AGILITE, new Integer(20));
		statsMapBoss3Nico.put(PersoStat.AGILITE, new Integer(20));
		statsMapBoss3Pip.put(PersoStat.AGILITE, new Integer(20));
		statsMapBoss3Tom.put(PersoStat.AGILITE, new Integer(20));
		statsMapBoss3Ya.put(PersoStat.AGILITE, new Integer(20));
		statsMapBoss3Ali.put(PersoStat.AGILITE, new Integer(20));
		statsMapBoss3Guy.put(PersoStat.AGILITE, new Integer(20));
		statsMapBoss3Russ.put(PersoStat.AGILITE, new Integer(20));
		bonusMapBoss3.put(PersoPrenom.Johann, statsMapBoss3Yo);
		bonusMapBoss3.put(PersoPrenom.Nicolas, statsMapBoss3Nico);
		bonusMapBoss3.put(PersoPrenom.Pierre, statsMapBoss3Pip);
		bonusMapBoss3.put(PersoPrenom.Thomas, statsMapBoss3Tom);
		bonusMapBoss3.put(PersoPrenom.Yannick, statsMapBoss3Ya);
		bonusMapBoss3.put(PersoPrenom.Ali, statsMapBoss3Ali);
		bonusMapBoss3.put(PersoPrenom.Guillaume, statsMapBoss3Guy);
		bonusMapBoss3.put(PersoPrenom.Jonathan, statsMapBoss3Russ);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapBoss4 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapBoss4Yo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss4Nico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss4Pip = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss4Tom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss4Ya = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss4Ali = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss4Guy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss4Russ = new HashMap<PersoStat,Integer>();
		statsMapBoss4Yo.put(PersoStat.INTELLIGENCE, new Integer(20));
		statsMapBoss4Nico.put(PersoStat.INTELLIGENCE, new Integer(20));
		statsMapBoss4Pip.put(PersoStat.INTELLIGENCE, new Integer(20));
		statsMapBoss4Tom.put(PersoStat.INTELLIGENCE, new Integer(20));
		statsMapBoss4Ya.put(PersoStat.INTELLIGENCE, new Integer(20));
		statsMapBoss4Ali.put(PersoStat.INTELLIGENCE, new Integer(20));
		statsMapBoss4Guy.put(PersoStat.INTELLIGENCE, new Integer(20));
		statsMapBoss4Russ.put(PersoStat.INTELLIGENCE, new Integer(20));
		bonusMapBoss4.put(PersoPrenom.Johann, statsMapBoss4Yo);
		bonusMapBoss4.put(PersoPrenom.Nicolas, statsMapBoss4Nico);
		bonusMapBoss4.put(PersoPrenom.Pierre, statsMapBoss4Pip);
		bonusMapBoss4.put(PersoPrenom.Thomas, statsMapBoss4Tom);
		bonusMapBoss4.put(PersoPrenom.Yannick, statsMapBoss4Ya);
		bonusMapBoss4.put(PersoPrenom.Ali, statsMapBoss4Ali);
		bonusMapBoss4.put(PersoPrenom.Guillaume, statsMapBoss4Guy);
		bonusMapBoss4.put(PersoPrenom.Jonathan, statsMapBoss4Russ);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapBoss5 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapBoss5Yo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss5Nico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss5Pip = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss5Tom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss5Ya = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss5Ali = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss5Guy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss5Russ = new HashMap<PersoStat,Integer>();
		statsMapBoss5Yo.put(PersoStat.RESISTANCE, new Integer(20));
		statsMapBoss5Nico.put(PersoStat.RESISTANCE, new Integer(20));
		statsMapBoss5Pip.put(PersoStat.RESISTANCE, new Integer(20));
		statsMapBoss5Tom.put(PersoStat.RESISTANCE, new Integer(20));
		statsMapBoss5Ya.put(PersoStat.RESISTANCE, new Integer(20));
		statsMapBoss5Ali.put(PersoStat.RESISTANCE, new Integer(20));
		statsMapBoss5Guy.put(PersoStat.RESISTANCE, new Integer(20));
		statsMapBoss5Russ.put(PersoStat.RESISTANCE, new Integer(20));
		bonusMapBoss5.put(PersoPrenom.Johann, statsMapBoss5Yo);
		bonusMapBoss5.put(PersoPrenom.Nicolas, statsMapBoss5Nico);
		bonusMapBoss5.put(PersoPrenom.Pierre, statsMapBoss5Pip);
		bonusMapBoss5.put(PersoPrenom.Thomas, statsMapBoss5Tom);
		bonusMapBoss5.put(PersoPrenom.Yannick, statsMapBoss5Ya);
		bonusMapBoss5.put(PersoPrenom.Ali, statsMapBoss5Ali);
		bonusMapBoss5.put(PersoPrenom.Guillaume, statsMapBoss5Guy);
		bonusMapBoss5.put(PersoPrenom.Jonathan, statsMapBoss5Russ);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapBoss6 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapBoss6Yo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss6Nico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss6Pip = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss6Tom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss6Ya = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss6Ali = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss6Guy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss6Russ = new HashMap<PersoStat,Integer>();
		statsMapBoss6Yo.put(PersoStat.RAPIDITE, new Integer(20));
		statsMapBoss6Nico.put(PersoStat.RAPIDITE, new Integer(20));
		statsMapBoss6Pip.put(PersoStat.RAPIDITE, new Integer(20));
		statsMapBoss6Tom.put(PersoStat.RAPIDITE, new Integer(20));
		statsMapBoss6Ya.put(PersoStat.RAPIDITE, new Integer(20));
		statsMapBoss6Ali.put(PersoStat.RAPIDITE, new Integer(20));
		statsMapBoss6Guy.put(PersoStat.RAPIDITE, new Integer(20));
		statsMapBoss6Russ.put(PersoStat.RAPIDITE, new Integer(20));
		bonusMapBoss6.put(PersoPrenom.Johann, statsMapBoss6Yo);
		bonusMapBoss6.put(PersoPrenom.Nicolas, statsMapBoss6Nico);
		bonusMapBoss6.put(PersoPrenom.Pierre, statsMapBoss6Pip);
		bonusMapBoss6.put(PersoPrenom.Thomas, statsMapBoss6Tom);
		bonusMapBoss6.put(PersoPrenom.Yannick, statsMapBoss6Ya);
		bonusMapBoss6.put(PersoPrenom.Ali, statsMapBoss6Ali);
		bonusMapBoss6.put(PersoPrenom.Guillaume, statsMapBoss6Guy);
		bonusMapBoss6.put(PersoPrenom.Jonathan, statsMapBoss6Russ);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapBoss7 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapBoss7Yo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss7Nico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss7Pip = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss7Tom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss7Ya = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss7Ali = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss7Guy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss7Russ = new HashMap<PersoStat,Integer>();
		statsMapBoss7Yo.put(PersoStat.TECHNIQUE, new Integer(20));
		statsMapBoss7Nico.put(PersoStat.TECHNIQUE, new Integer(20));
		statsMapBoss7Pip.put(PersoStat.TECHNIQUE, new Integer(20));
		statsMapBoss7Tom.put(PersoStat.TECHNIQUE, new Integer(20));
		statsMapBoss7Ya.put(PersoStat.TECHNIQUE, new Integer(20));
		statsMapBoss7Ali.put(PersoStat.TECHNIQUE, new Integer(20));
		statsMapBoss7Guy.put(PersoStat.TECHNIQUE, new Integer(20));
		statsMapBoss7Russ.put(PersoStat.TECHNIQUE, new Integer(20));
		bonusMapBoss7.put(PersoPrenom.Johann, statsMapBoss7Yo);
		bonusMapBoss7.put(PersoPrenom.Nicolas, statsMapBoss7Nico);
		bonusMapBoss7.put(PersoPrenom.Pierre, statsMapBoss7Pip);
		bonusMapBoss7.put(PersoPrenom.Thomas, statsMapBoss7Tom);
		bonusMapBoss7.put(PersoPrenom.Yannick, statsMapBoss7Ya);
		bonusMapBoss7.put(PersoPrenom.Ali, statsMapBoss7Ali);
		bonusMapBoss7.put(PersoPrenom.Guillaume, statsMapBoss7Guy);
		bonusMapBoss7.put(PersoPrenom.Jonathan, statsMapBoss7Russ);
		
		Map<PersoPrenom,Map<PersoStat,Integer>> bonusMapBoss8 = new HashMap<PersoPrenom,Map<PersoStat,Integer>>();
		Map<PersoStat,Integer> statsMapBoss8Yo = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss8Nico = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss8Pip = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss8Tom = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss8Ya = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss8Ali = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss8Guy = new HashMap<PersoStat,Integer>();
		Map<PersoStat,Integer> statsMapBoss8Russ = new HashMap<PersoStat,Integer>();
		statsMapBoss8Yo.put(PersoStat.ENDURANCE, new Integer(20));
		statsMapBoss8Nico.put(PersoStat.ENDURANCE, new Integer(20));
		statsMapBoss8Pip.put(PersoStat.ENDURANCE, new Integer(20));
		statsMapBoss8Tom.put(PersoStat.ENDURANCE, new Integer(20));
		statsMapBoss8Ya.put(PersoStat.ENDURANCE, new Integer(20));
		statsMapBoss8Ali.put(PersoStat.ENDURANCE, new Integer(20));
		statsMapBoss8Guy.put(PersoStat.ENDURANCE, new Integer(20));
		statsMapBoss8Russ.put(PersoStat.ENDURANCE, new Integer(20));
		statsMapBoss8Yo.put(PersoStat.NERVOSITE, new Integer(20));
		statsMapBoss8Nico.put(PersoStat.NERVOSITE, new Integer(20));
		statsMapBoss8Pip.put(PersoStat.NERVOSITE, new Integer(20));
		statsMapBoss8Tom.put(PersoStat.NERVOSITE, new Integer(20));
		statsMapBoss8Ya.put(PersoStat.NERVOSITE, new Integer(20));
		statsMapBoss8Ali.put(PersoStat.NERVOSITE, new Integer(20));
		statsMapBoss8Guy.put(PersoStat.NERVOSITE, new Integer(20));
		statsMapBoss8Russ.put(PersoStat.NERVOSITE, new Integer(20));
		bonusMapBoss8.put(PersoPrenom.Johann, statsMapBoss8Yo);
		bonusMapBoss8.put(PersoPrenom.Nicolas, statsMapBoss8Nico);
		bonusMapBoss8.put(PersoPrenom.Pierre, statsMapBoss8Pip);
		bonusMapBoss8.put(PersoPrenom.Thomas, statsMapBoss8Tom);
		bonusMapBoss8.put(PersoPrenom.Yannick, statsMapBoss8Ya);
		bonusMapBoss8.put(PersoPrenom.Ali, statsMapBoss8Ali);
		bonusMapBoss8.put(PersoPrenom.Guillaume, statsMapBoss8Guy);
		bonusMapBoss8.put(PersoPrenom.Jonathan, statsMapBoss8Russ);
		
		Bonus bonusPiscine = new Bonus(10, bonusMapPiscine);
		Bonus bonusFoot = new Bonus(20, bonusMapFoot);
		Bonus bonusBoss1 = new Bonus(101, bonusMapBoss1);
		Bonus bonusBoss2 = new Bonus(102, bonusMapBoss2);
		Bonus bonusBoss3 = new Bonus(103, bonusMapBoss3);
		Bonus bonusBoss4 = new Bonus(104, bonusMapBoss4);
		Bonus bonusBoss5 = new Bonus(105, bonusMapBoss5);
		Bonus bonusBoss6 = new Bonus(106, bonusMapBoss6);
		Bonus bonusBoss7 = new Bonus(107, bonusMapBoss7);
		Bonus bonusBoss8 = new Bonus(108, bonusMapBoss8);
		
		allBonus.add(bonusVide);
		allBonus.add(bonusFoot);
		allBonus.add(bonusPiscine);
		allBonus.add(bonusBoss1);
		allBonus.add(bonusBoss2);
		allBonus.add(bonusBoss3);
		allBonus.add(bonusBoss4);
		allBonus.add(bonusBoss5);
		allBonus.add(bonusBoss6);
		allBonus.add(bonusBoss7);
		allBonus.add(bonusBoss8);
	}
	
	public static void distribueBonus(Groupe groupe, Bonus bonus) {
		// TODO gestion perte/gain bonus/malus
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
