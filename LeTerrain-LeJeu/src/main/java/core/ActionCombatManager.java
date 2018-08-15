package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modele.competence.PersoStat;
import modele.item.mission.BossNom;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.EnnemiType;
import modele.item.personnage.PersoClasse;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.action.ActionCombat;
import modele.item.personnage.action.ActionCombatType;
import modele.item.personnage.action.CibleType;
import modele.item.personnage.action.EnergieType;
import modele.item.personnage.action.SortType;

public class ActionCombatManager implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Map<String,List<ActionCombat>> actionsByPerso;
	private int id = 0;

	public void initialise(Difficulte difficultePartie) {
		actionsByPerso = new HashMap<String,List<ActionCombat>>();

		List<String> imagePaths = new ArrayList<String>();
		imagePaths.add("image/defaut/defautActionCombat.png");
		
		// Yo
		List<String> imagePaths101 = new ArrayList<String>();
		imagePaths101.add("image/actionCombat/shortBalboula.jpg");

		List<String> imagePaths112 = new ArrayList<String>();
		imagePaths112.add("image/actionCombat/golden.jpg");
		
		List<String> imagePaths113 = new ArrayList<String>();
		imagePaths113.add("image/actionCombat/teteDansCul.jpg");
		
		List<String> imagePaths117 = new ArrayList<String>();
		imagePaths117.add("image/actionCombat/lucky.jpg");

		List<String> imagePaths118 = new ArrayList<String>();
		imagePaths118.add("image/actionCombat/wow.jpg");

		List<String> imagePaths131 = new ArrayList<String>();
		imagePaths131.add("image/actionCombat/traire.png");

		List<String> imagePaths139 = new ArrayList<String>();
		imagePaths139.add("image/actionCombat/crayon.jpg");
		
		List<String> imagePaths145 = new ArrayList<String>();
		imagePaths145.add("image/actionCombat/tecktonik.jpg");
		
		List<String> imagePaths147 = new ArrayList<String>();
		imagePaths147.add("image/actionCombat/lacrymo.png");

		List<String> imagePaths181 = new ArrayList<String>();
		imagePaths181.add("image/actionCombat/helico.jpg");		
		
		
		// Nico
		List<String> imagePaths201 = new ArrayList<String>();
		imagePaths201.add("image/actionCombat/ugly.jpg");

		List<String> imagePaths202 = new ArrayList<String>();
		imagePaths202.add("image/actionCombat/sagat.jpg");
		
		List<String> imagePaths212 = new ArrayList<String>();
		imagePaths212.add("image/actionCombat/mightyMask.png");
		
		List<String> imagePaths217 = new ArrayList<String>();
		imagePaths217.add("image/actionCombat/jurassik.png");

		List<String> imagePaths218 = new ArrayList<String>();
		imagePaths218.add("image/actionCombat/matrix.jpg");

		List<String> imagePaths231 = new ArrayList<String>();
		imagePaths231.add("image/actionCombat/wolverine.jpg");

		List<String> imagePaths234 = new ArrayList<String>();
		imagePaths234.add("image/actionCombat/raptout.jpg");
		
		List<String> imagePaths241 = new ArrayList<String>();
		imagePaths241.add("image/actionCombat/servietsky.jpeg");
		
		List<String> imagePaths248 = new ArrayList<String>();
		imagePaths248.add("image/actionCombat/schwarzy.jpg");

		List<String> imagePaths281 = new ArrayList<String>();
		imagePaths281.add("image/actionCombat/grappin.jpg");		
		
		
		// Pip
		List<String> imagePaths301 = new ArrayList<String>();
		imagePaths301.add("image/actionCombat/krisKross.jpeg");

		List<String> imagePaths302 = new ArrayList<String>();
		imagePaths302.add("image/actionCombat/ca.jpg");
		
		List<String> imagePaths313 = new ArrayList<String>();
		imagePaths313.add("image/actionCombat/cagoule.jpg");
		
		List<String> imagePaths314 = new ArrayList<String>();
		imagePaths314.add("image/actionCombat/deck.jpg");
		
		List<String> imagePaths317 = new ArrayList<String>();
		imagePaths317.add("image/actionCombat/trompe.png");

		List<String> imagePaths334 = new ArrayList<String>();
		imagePaths334.add("image/actionCombat/c19.jpg");

		List<String> imagePaths338 = new ArrayList<String>();
		imagePaths338.add("image/actionCombat/cheval.jpg");

		List<String> imagePaths343 = new ArrayList<String>();
		imagePaths343.add("image/actionCombat/futur.png");
		
		List<String> imagePaths346 = new ArrayList<String>();
		imagePaths346.add("image/actionCombat/2be3.jpg");
		
		List<String> imagePaths381 = new ArrayList<String>();
		imagePaths381.add("image/actionCombat/didier.jpg");

		
		// Ya
		List<String> imagePaths401 = new ArrayList<String>();
		imagePaths401.add("image/actionCombat/jaime.jpg");
		
		List<String> imagePaths412 = new ArrayList<String>();
		imagePaths412.add("image/actionCombat/terminator.jpg");

		List<String> imagePaths414 = new ArrayList<String>();
		imagePaths414.add("image/actionCombat/sabre.png");
		
		List<String> imagePaths416 = new ArrayList<String>();
		imagePaths416.add("image/actionCombat/huggy.jpg");
		
		List<String> imagePaths417 = new ArrayList<String>();
		imagePaths417.add("image/actionCombat/boris.jpg");
		
		List<String> imagePaths439 = new ArrayList<String>();
		imagePaths439.add("image/actionCombat/buffy.jpg");

		List<String> imagePaths442 = new ArrayList<String>();
		imagePaths442.add("image/actionCombat/poison.jpg");

		List<String> imagePaths446 = new ArrayList<String>();
		imagePaths446.add("image/actionCombat/nirvana.jpg");

		List<String> imagePaths448 = new ArrayList<String>();
		imagePaths448.add("image/actionCombat/peinture.jpg");
		
		List<String> imagePaths481 = new ArrayList<String>();
		imagePaths481.add("image/actionCombat/explosion.jpg");

		// Tom
		List<String> imagePaths501 = new ArrayList<String>();
		imagePaths501.add("image/actionCombat/chain.jpg");
		
		List<String> imagePaths512 = new ArrayList<String>();
		imagePaths512.add("image/actionCombat/bulma.jpg");

		List<String> imagePaths517 = new ArrayList<String>();
		imagePaths517.add("image/actionCombat/scout.jpg");
		
		List<String> imagePaths531 = new ArrayList<String>();
		imagePaths531.add("image/actionCombat/tampax.jpg");
		
		List<String> imagePaths533 = new ArrayList<String>();
		imagePaths533.add("image/actionCombat/tyrion.png");
		
		List<String> imagePaths535 = new ArrayList<String>();
		imagePaths535.add("image/actionCombat/kleenex.jpg");

		List<String> imagePaths541 = new ArrayList<String>();
		imagePaths541.add("image/actionCombat/armenie.jpg");

		List<String> imagePaths543 = new ArrayList<String>();
		imagePaths543.add("image/actionCombat/saigne.jpg");

		List<String> imagePaths544 = new ArrayList<String>();
		imagePaths544.add("image/actionCombat/messmer.jpg");
		
		List<String> imagePaths581 = new ArrayList<String>();
		imagePaths581.add("image/actionCombat/centPatates.jpg");
		
		
		// Guy
		List<String> imagePaths601 = new ArrayList<String>();
		imagePaths601.add("image/actionCombat/gainsbar.jpg");
		
		List<String> imagePaths612 = new ArrayList<String>();
		imagePaths612.add("image/actionCombat/waterloo.jpg");

		List<String> imagePaths613 = new ArrayList<String>();
		imagePaths613.add("image/actionCombat/doudoune.jpg");
		
		List<String> imagePaths617 = new ArrayList<String>();
		imagePaths617.add("image/actionCombat/footBande.jpg");
		
		List<String> imagePaths631 = new ArrayList<String>();
		imagePaths631.add("image/actionCombat/pizzaMayo.jpg");
		
		List<String> imagePaths634 = new ArrayList<String>();
		imagePaths634.add("image/actionCombat/guillaumeFroissard.png");

		List<String> imagePaths636 = new ArrayList<String>();
		imagePaths636.add("image/actionCombat/chaman.jpg");

		List<String> imagePaths640 = new ArrayList<String>();
		imagePaths640.add("image/actionCombat/trou.jpg");

		List<String> imagePaths648 = new ArrayList<String>();
		imagePaths648.add("image/actionCombat/piscine.jpg");
		
		List<String> imagePaths681 = new ArrayList<String>();
		imagePaths681.add("image/actionCombat/spit.jpg");
		
		
		// Ali
		List<String> imagePaths701 = new ArrayList<String>();
		imagePaths701.add("image/actionCombat/zidane.jpg");
		
		List<String> imagePaths712 = new ArrayList<String>();
		imagePaths712.add("image/actionCombat/cascade.jpg");

		List<String> imagePaths717 = new ArrayList<String>();
		imagePaths717.add("image/actionCombat/aladdin.jpg");
		
		List<String> imagePaths718 = new ArrayList<String>();
		imagePaths718.add("image/actionCombat/soirees.jpg");
		
		List<String> imagePaths731 = new ArrayList<String>();
		imagePaths731.add("image/actionCombat/teton.jpg");
		
		List<String> imagePaths742 = new ArrayList<String>();
		imagePaths742.add("image/actionCombat/lacrymo.jpg");

		List<String> imagePaths743 = new ArrayList<String>();
		imagePaths743.add("image/actionCombat/healWorld.jpg");

		List<String> imagePaths746 = new ArrayList<String>();
		imagePaths746.add("image/actionCombat/culCoince.jpeg");

		List<String> imagePaths747 = new ArrayList<String>();
		imagePaths747.add("image/actionCombat/crochePied.jpg");
		
		List<String> imagePaths781 = new ArrayList<String>();
		imagePaths781.add("image/actionCombat/bollywood.jpg");
		
		// Russ
		List<String> imagePaths801 = new ArrayList<String>();
		imagePaths801.add("image/actionCombat/orangina.jpg");
		
		List<String> imagePaths812 = new ArrayList<String>();
		imagePaths812.add("image/actionCombat/poilu.jpg");

		List<String> imagePaths817 = new ArrayList<String>();
		imagePaths817.add("image/emission/trilogieSamedi.jpg");
		
		List<String> imagePaths818 = new ArrayList<String>();
		imagePaths818.add("image/actionCombat/autruche.jpg");
		
		List<String> imagePaths836 = new ArrayList<String>();
		imagePaths836.add("image/actionCombat/peau.jpg");
		
		List<String> imagePaths842 = new ArrayList<String>();
		imagePaths842.add("image/actionCombat/coupDeSoleil.jpg");

		List<String> imagePaths846 = new ArrayList<String>();
		imagePaths846.add("image/actionCombat/diehard3.jpg");

		List<String> imagePaths847 = new ArrayList<String>();
		imagePaths847.add("image/actionCombat/rush.jpg");

		List<String> imagePaths848 = new ArrayList<String>();
		imagePaths848.add("image/actionCombat/requin.jpg");
		
		List<String> imagePaths882 = new ArrayList<String>();
		imagePaths882.add("image/actionCombat/pasteque.jpg");

		// Son par defaut
		String sonAttaque = "sonParDefaut/defautAttaque.mp3";
		String sonAttaqueCritique = "sonParDefaut/defautAttaqueCritique.mp3";
		String sonREZ = "sonParDefaut/defautREZ.mp3";
		// TODO autre sons : "aimons nous vivant" REZ multi
		String sonREZCritique = "sonParDefaut/defautREZCritique.mp3";
		String sonBouclier = "sonParDefaut/defautBouclier.mp3";
		String sonBouclierCritique = "sonParDefaut/defautBouclierCritique.mp3";
		String sonRegenMana = "sonParDefaut/defautRegenMana.mp3";
		String sonRegenManaCritique = "sonParDefaut/defautRegenManaCritique.mp3";
		String sonRegenVie = "sonParDefaut/defautRegenVie.mp3";
		String sonRegenVieCritique = "sonParDefaut/defautRegenVieCritique.mp3";
		
		// Son par perso attaque special
		String sonAttaque181 = "son/actionCombat/pet.mp3";
		String sonAttaqueCritique181 = "son/actionCombat/mozart.mp3";
		String sonAttaque281 = "son/actionCombat/finishHim.mp3";
		String sonAttaqueCritique281 = "son/actionCombat/fatality.mp3";
		String sonAttaque381 = "son/actionCombat/over9000.mp3";
		String sonAttaqueCritique381 = "son/actionCombat/smoke-weed-everyday.mp3";
		String sonAttaque481 = "son/actionCombat/oh_la_la_worms.mp3";
		String sonAttaqueCritique481 = "sonParDefaut/defautREZ.mp3";
		String sonAttaque581 = "son/actionCombat/centPatates.mp3";
		String sonAttaqueCritique581 = "son/actionCombat/quandMeme.mp3";
		String sonAttaque681 = "son/actionCombat/crachat.mp3";
		String sonAttaqueCritique681 = "son/actionCombat/crachatCritique.mp3";
		String sonAttaque781 = "son/actionCombat/mickael.mp3";
		String sonAttaqueCritique781 = "son/actionCombat/mickaelCritique.mp3";
		String sonAttaque882 = "son/actionCombat/pasteque.mp3";
		String sonAttaqueCritique882 = "son/actionCombat/sparta.mp3";
		
		List<String> videoPaths = new ArrayList<String>();
		videoPaths.add("video/Trololo.mp4");
		
		// TODO remettre niveau_1 a 1
		int niveau_1 = 1;
		int niveau_5 = 5;
		int niveau_6 = 6;
		int niveau_7 = 7;
		int niveauMax_10 = 10;
		int progression = 0;
		boolean disponible = true;
		boolean indisponible = false;
		
		// TODO mettre des sorts en fonction de la stat principal du perso
		// TODO restreindre le nombre de sort par perso en fonction de la classe
		// TODO -> (Avoir/Choisir une classe de départ avec 3-4-5 type de sorts max (par type, ex : TANK = {Bouclier perso, Taunt}) et possibilité d'avoir plusieurs classes par la suite pour debloquer tous les sorts ???
		// TODO noms et sons de sort specifiques
		// TODO sorts special niv 5 des le debut ? oui
		// TODO progression fixe a 10 ? (quelque soit le niveau) 
		
		// Johann (Chance)
		
		// Image : shortBalboula - caleçon cana
		ActionCombat johannAttaque1 = new ActionCombat(101, "(Degats Mono) Rocky Balboula", "Met autant de claques à l'ennemi qu'il fera de conneries, de boulettes vestimentaires et qu'il bamboulera dans sa vie", imagePaths101, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Johann);
//		ActionCombat johannAttaque2 = new ActionCombat(102, "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.DEGATS_MULTI, PersoPrenom.Johann);
//		ActionCombat johannDefense1 = new ActionCombat(111, "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.LUCK, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Johann);
		// TODO Mission : "Protection naturelle", "Pisser dans le bain sans s'endormir pour générer une fine pellicule odorante et repulsive sur la peau qui protège du soleil et des moustiques" / Image : golden - james bond sous la douche
		ActionCombat johannDefense2 = new ActionCombat(112, "(Bouclier Perso) Golden Gun Shower", "Met son manteau carapace, prend du Jumanji, pisse dans l'escalier puis dans un pistolet à eau et s'asperge lui même pour se protéger", imagePaths112, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.LUCK, SortType.BOUCLIER_PERSO, PersoPrenom.Johann);
		// TODO Mission : "Défaillances temporelles", "Se déguiser en pute effeministe pour le carnaval, se voiler la face et ne jamais réussir à se resituer vestimentairement et musicalement dans l'espace et le temps" / Image : teteDansCul - tete dans son cul
		ActionCombat johannDefense3 = new ActionCombat(113, "(Bouclier Mono) Juvy dans mon cul", "Met des oeillères, se coupe du monde et reste bloqué dans le passé afin de créer une bulle nostalgique memorielle pour protéger un allié des ravages du temps", imagePaths113, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.LUCK, SortType.BOUCLIER_MONO, PersoPrenom.Johann);
//		ActionCombat johannDefense4 = new ActionCombat(114, "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.BOUCLIER_MULTI, PersoPrenom.Johann);
//		ActionCombat johannDefense5 = new ActionCombat(115, "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.LUCK, SortType.AURA_PERSO, PersoPrenom.Johann);
//		ActionCombat johannDefense6 = new ActionCombat(116, "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.LUCK, SortType.AURA_MONO, PersoPrenom.Johann);
		// TODO Mission : "Chatroulette", "Ne pas réussir à se faire voler son booster et son portable, se faire controler sans se faire choper mais se faire emprunter sa Playstation à vie" / Image : lucky - trefle canabis / Son : jackpot
		ActionCombat johannDefense7 = new ActionCombat(117, "(Aura Multi - Chance) Yo la charte", "Enroule un trèfle à quatre feuilles pour gratter mille francs de Banco et écrire sur les murs puis invoque une aura qui augmente la Chance de ses alliés illico", imagePaths117, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.AURA_MULTI, PersoPrenom.Johann);
		// TODO Mission : "Guerre bactériologique", "Lécher les murs, boire dans les flaques, prendre de la merde avec ses doigts et se laisser lécher par son chat" / Image : wow - cartman chie dans un pot / Musique : Live to win
		ActionCombat johannDefense8 = new ActionCombat(118, "(Esquive) Immunité Virtuelle", "S'isole pour jouer au même Meuporg pendant 5 ans avec sa guilde et se nourrire uniquement de pain et de grecs pour esquiver toutes autres aggressions exterieurs", imagePaths118, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.LUCK, SortType.ESQUIVE, PersoPrenom.Johann);
		// TODO Mission : "Père de claque", "Insister pour pouvoir assister à la soirée creperie avec ses potes et refaire la gueule en faisant greve de la faim avant de se faire décalquer le portrait au premier degré" / Image : traire - meuf qui boit directement a la source
		ActionCombat johannSort1 	= new ActionCombat(131, "(Regen Vie Perso) D'une pierre deux couilles", "Se régénère en se malaxant regulièrement la couille droite tout en mangeant une bonne escalope à point avec une tarte en dessert", imagePaths131, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.LUCK, SortType.REGEN_VIE_PERSO, PersoPrenom.Johann);
//		ActionCombat johannSort2 	= new ActionCombat(132, "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.REGEN_VIE_MONO, PersoPrenom.Johann);
//		ActionCombat johannSort3 	= new ActionCombat(133, "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.REGEN_VIE_MULTI, PersoPrenom.Johann);
//		ActionCombat johannSort4 	= new ActionCombat(134, "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.LUCK, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Johann);
//		ActionCombat johannSort5 	= new ActionCombat(135, "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Johann);
//		ActionCombat johannSort6 	= new ActionCombat(136, "Regen Mana Perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.LUCK, SortType.REGEN_MANA_PERSO, PersoPrenom.Johann);
//		ActionCombat johannSort7 	= new ActionCombat(137, "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.REGEN_MANA_MONO, PersoPrenom.Johann);
//		ActionCombat johannSort8 	= new ActionCombat(138, "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.REGEN_MANA_MULTI, PersoPrenom.Johann);
		// TODO Mission : "Amour vache" : "Planter Judith, Thomas, Jonathan et Jeremy, récolter la dent de Pierre, répondre aux adultes puis ne plus être inviter aux anniversaires" / Image : crayon - crayon du joker
		ActionCombat johannSort9 	= new ActionCombat(139, "(Absorb Mana Mono) Fallait pas l'inviter", "Entame un début de relation amicale avec son ennemi puis le plante soudainement avec ce qu'il peut dans un excès de folie exfoliant pour lui absorber son Mana", imagePaths139, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.LUCK, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Johann);
//		ActionCombat johannSort10 	= new ActionCombat(140, "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Johann);
//		ActionCombat johannSort11 	= new ActionCombat(141, "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.LUCK, SortType.BRULURE_MANA_MONO, PersoPrenom.Johann);
//		ActionCombat johannSort12 	= new ActionCombat(142, "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.BRULURE_MANA_MULTI, PersoPrenom.Johann);
//		ActionCombat johannSort13 	= new ActionCombat(143, "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.RESURRECTION_MONO, PersoPrenom.Johann);
//		ActionCombat johannSort14 	= new ActionCombat(144, "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.RESURRECTION_MULTI, PersoPrenom.Johann);
		// TODO Mission : "La ronde du vautour" : "Faire un nez d'aigle pour s'échauffer puis danser du rap en reculant mais toujours le doigt levé" / Image : tecktonik - embleme tecktonik nazy
		ActionCombat johannSort15 	= new ActionCombat(145, "(Taunt Mono) Dance nazitude vol. 13", "Fait 33 tours autour de l'ennemi tel un rapace à l'affût de sa proie et le provoque en le clashant tecktonikement", imagePaths145, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.LUCK, SortType.TAUNT_MONO, PersoPrenom.Johann);
//		ActionCombat johannSort16 	= new ActionCombat(146, "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.TAUNT_MULTI, PersoPrenom.Johann);
		// TODO Mission : "Magic Light", "Casser une vitre et tirer un coup de fusil sur un pneu à bout portant pour ricocher et éclater un lampadaire et mettre plein de morceaux d'étoiles dans les yeux de ses alliés" / Image : lacrymo - jcvd aveuglé / Son : Macron perlimpinpin remix
		ActionCombat johannSort17 	= new ActionCombat(147, "(Stun Mono) Perlimpinpin", "Effrite un peu de parmesan de gland affiné de trois jours, le mélange à du popo sable doux et jete de la poudre aux yeux de l'ennemi pour l'enfumer et le bloquer", imagePaths147, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.LUCK, SortType.STUN_MONO, PersoPrenom.Johann);
//		ActionCombat johannSort18 	= new ActionCombat(148, "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.STUN_MULTI, PersoPrenom.Johann);
		// TODO Mission : "Sketch à chier", "Tomber malade chez Nico, avoir la soiffade, descendre les 5 marches de la gloire, chevaucher le trone des Walkyries et reciter une cantate à Carmina Burana" / Image : helico - helico canadair / Son : carmina burana - valkyries
		ActionCombat johannSpecial1 = new ActionCombat(181, "(Degats Multi) Super Copter", "Chope la gastro et fait un début de merde mal maitrisé combiné à la technique de l'hélico pour emmerder littéralement les ennemis", imagePaths181, sonAttaque181, sonAttaqueCritique181, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.DEGATS_MULTI, PersoPrenom.Johann);
//		ActionCombat johannSpecial2 = new ActionCombat(182, "(Degats All)", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Johann);
		
		
		// Nicolas (Exploit)
		
		// Image : Ugly Mr Bean
		ActionCombat nicolasAttaque1 = new ActionCombat(201, "(Degats Mono) Petit et pas beau", "Met autant de claques à l'ennemi qu'on lui demandera sa carte d'identité pour vérifier son age, sa taille et sa nationalité dans sa vie", imagePaths201, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Nicolas);
		// Mission "Bas, R, Haut, L, Y, B", "Regarder Blade Runner sans rien comprendre puis Best of the Best pour répliquer une technique de combat imparable" / image : Sagat genou
		ActionCombat nicolasAttaque2 = new ActionCombat(202, "(Degats Multi) L'attaque du Tigre et Dragon", "Encercle ses ennemis à lui tout seul en leur assénant des genou-kicks par derrière tel Alexander Grady en furie", imagePaths202, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, PersoPrenom.Nicolas);
//		ActionCombat nicolasDefense1 = new ActionCombat(211, "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Nicolas);
		// Mission "Haut comme trois pommes", "Réaliser que quand les trois frères se montent sur les épaules, ils atteignent presque la taille d'un homme adulte" / Image : mightyMask - dragonball trunk sur goten
		ActionCombat nicolasDefense2 = new ActionCombat(212, "(Bouclier Perso) Fraternanisme", "Appel à la rescousse Danielo dit 'La ponceuse de Madrid au doigt qui pue' et Marcou dit 'Le petit pedestre de Thriller briseur de carreau' pour se protéger", imagePaths212, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.EXPLOIT, SortType.BOUCLIER_PERSO, PersoPrenom.Nicolas);
//		ActionCombat nicolasDefense3 = new ActionCombat(213, "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Nicolas);
//		ActionCombat nicolasDefense4 = new ActionCombat(214, "(Bouclier Multi)", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Nicolas);
//		ActionCombat nicolasDefense5 = new ActionCombat(215, "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.EXPLOIT, SortType.AURA_PERSO, PersoPrenom.Nicolas);
//		ActionCombat nicolasDefense6 = new ActionCombat(216, "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.EXPLOIT, SortType.AURA_MONO, PersoPrenom.Nicolas);
		// Mission "L'appel de la nature", "Aller au stade de foot un dimanche et se rendre compte de la difficulté qu'ont eu tous nos ancêtres de ne pas avoir eu l'eau courante et le PQ" / image : jurassik - chiasse de bronchiosaure
		ActionCombat nicolasDefense7 = new ActionCombat(217, "(Aura Multi - Exploit) Je suis malfaisant", "Invoque une aura qui augmente les Exploits de ses alliés comme la capacité de se retenir pendant cinq jours ou à l'inverse de chier instantanement au contact de la nature", imagePaths217, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.EXPLOIT, SortType.AURA_MULTI, PersoPrenom.Nicolas);
		// Mission "Antifioniste", "Regarder matrix et se brancher un lecteur de disquette dans le sion pour connaitre le kung-fu, le krav-maga et le pencak-silat" / image : matrix esquivant balles / Son : twist again
		ActionCombat nicolasDefense8 = new ActionCombat(218, "(Esquive) El Mefiento", "Esquive les attaques sans contacts en faisant des twist nuggets et protège son espace vital grâce à une technique d'auto-défense brésilo-colombienne ancestrale", imagePaths218, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.EXPLOIT, SortType.ESQUIVE, PersoPrenom.Nicolas);
		// Mission "Extrêmes limites", "Survivre à moult periples dont une lésion têtal fenestré, une fracture du tibia en escalier, une cagette nasifère volante et quelques molestages fraternels" / image : wolverine
		ActionCombat nicolasSort1 	 = new ActionCombat(231, "(Regen Vie Perso) Bénédiction divine", "Se régénère grâce à ses pouvoirs magiques d'aigrison rapide, ses talents en fitness extrémiste et son squelette en AdamEtEve-antuim rabougri", imagePaths231, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.EXPLOIT, SortType.REGEN_VIE_PERSO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort2 	 = new ActionCombat(232, "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort3 	 = new ActionCombat(233, "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Nicolas);
		// Mission "Les insectes sont nos amis", "Attraper avant tout du papier cul puis chasser les araignées en farfouillant sous ses draps tous les soirs et vice et versa" / Image: raptout - Les inconus vampire
		ActionCombat nicolasSort4 	 = new ActionCombat(234, "(Absorb Vie Mono) Le suce-sang", "Absorbe la vie de son ennemi en lui lançant des sangsues suceuses de sang faisant des suçons saignants sans susciter la suspission du sucé sus-cité sous-jacent", imagePaths234, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.EXPLOIT, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort5 	 = new ActionCombat(235, "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort6 	 = new ActionCombat(236, "Regen Mana Perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort7 	 = new ActionCombat(237, "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort8 	 = new ActionCombat(238, "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort9 	 = new ActionCombat(239, "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort10 	 = new ActionCombat(240, "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Nicolas);
		// Mission "J'ai les yeux rouges?", "Se faire doucher par un enfant, lui faire manger ses parents et reprendre le commerce mafiamiliale avant de développer une double personnalité mi-gitan mi-chips mi-randa" / image : servietski
		ActionCombat nicolasSort11 	 = new ActionCombat(241, "(Brulure Mana Mono) Vico Corleone", "Laisse son double maléfique saoulant et grisonnant prendre le dessus et propose de tirer une taff de l'honneur barbiturée irrefusable à l'ennemi pour lui fumer son ame de non-roux", imagePaths241, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.EXPLOIT, SortType.BRULURE_MANA_MONO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort12 	 = new ActionCombat(242, "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort13 	 = new ActionCombat(243, "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort14 	 = new ActionCombat(244, "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort15 	 = new ActionCombat(245, "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort16 	 = new ActionCombat(246, "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Nicolas);
//		ActionCombat nicolasSort17 	 = new ActionCombat(247, "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Nicolas);
		// Mission "No Pain No Gain", "Faire un regime 'Ni pain Ni cola' puis se muscler la musculature en s'injectant des supo-stéroides anal-bolisants au café, les couilles tartinées de beurre et de miel" / image : schwarzy
		ActionCombat nicolasSort18 	 = new ActionCombat(248, "(Stun Multi) Hulk Logan Legout", "Bande ses muscles jusqu'à démouler un Arabinou de café ou jouis de ses propres contractions utérines ou mange des céréales en boite pour impressioner et bloquer les ennemis", imagePaths248, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.STUN_MULTI, PersoPrenom.Nicolas);
		// Mission : "Atchoum" "S'inspirer de Ricky morve au nez et se faire éternuer à la demande pour projetter 5 jets de slime sur les cibles plus grande et blanche que soi" / image : Grappin Link (TODO : Main collante verte ?)
		ActionCombat nicolasSpecial1 = new ActionCombat(281, "(Degats Multi) Grapina Nicolada", "Grappine tout ce qu'il peut et saoule fatalement ses ennemies pour terminer en 'Finish Him' qui arrache et déchire les membres grappinés jusqu'à la moelle", imagePaths281, sonAttaque281, sonAttaqueCritique281, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, PersoPrenom.Nicolas);
//		ActionCombat nicolasSpecial2 = new ActionCombat(282, "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Nicolas);
	
		
		// Pierre (Agilite)
		
		// Image : KrisKross
		ActionCombat pierreAttaque1 = new ActionCombat(301, "(Degats Mono) Christ Crossroads", "Met autant de claques à l'ennemi qu'il ira faire la queue à Carrefour le samedi et à l'Eglise le dimanche dans sa vie", imagePaths301, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Pierre);
		// Mission : "Spray buccal", "Regarder le film 'Il est revenu' et devenir asthmatique temporairement pour faire crari le babtou fragile et sensible" / image : ca - 'Ca' qui se transforme 
		ActionCombat pierreAttaque2 = new ActionCombat(302, "(Degats Multi) Pulverisation faciale", "Asperge le visage de ses ennemis avec de la Ventoline et leur fait respirer une bouteille contenant du pet macéré", imagePaths302, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.AGILITE, SortType.DEGATS_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreDefense1 = new ActionCombat(311, "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Pierre);
//		ActionCombat pierreDefense2 = new ActionCombat(312, "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Pierre);
		// Mission : "Théorie et Pratique", "Recevoir à noël des vêtements pour être habiller pour l'hiver ainsi qu'une bible et un livre sur l'onanisme" / image : cagoule - cagoule en forme de gland
		ActionCombat pierreDefense3 = new ActionCombat(313, "(Bouclier Mono) Fous ta cagoule", "Protège un allié en lui pretant sa cagoule verte, ses bottes des sept lieux à semelles amovibles et ses pantoufles à gland", imagePaths313, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.AGILITE, SortType.BOUCLIER_MONO, PersoPrenom.Pierre);
		// Mission : "Pierre 'Magic' Bellemarre", "Arrêter de faire des flaques partout en étanchant sa soif et protéger son jeu de carte des intempéries et de soi-même" / image : deck - carte magic alcoolisé
		ActionCombat pierreDefense4 = new ActionCombat(314, "(Bouclier Multi) Deck Slivovitz", "Protège ses alliés en invoquant un cercle de protection Artefact plastifié et gagne un bonus +1/+1 pour chaque personne lui commandant une bouteille", imagePaths314, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.AGILITE, SortType.BOUCLIER_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreDefense5 = new ActionCombat(315, "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.AURA_PERSO, PersoPrenom.Pierre);
//		ActionCombat pierreDefense6 = new ActionCombat(316, "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.AGILITE, SortType.AURA_MONO, PersoPrenom.Pierre);
		// Mission : "La mole c'est dur", "Valider par l'experience personnelle le fait scientifique que certains organes poussent toute la vie" / image : trompe - elephant avec une trompe bite
		ActionCombat pierreDefense7 = new ActionCombat(317, "(Aura Multi - Agilité) Membres croissants", "Invoque une aura permettant d'améliorer l'Agilité et les sens des ses alliés en développant leurs organes externes comme le nez, les oreilles et la queue", imagePaths317, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.AGILITE, SortType.AURA_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreDefense8 = new ActionCombat(318, "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Pierre);
//		ActionCombat pierreSort1 	= new ActionCombat(331, "Regen Vie Perso", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Pierre);
//		ActionCombat pierreSort2 	= new ActionCombat(332, "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Pierre);
//		ActionCombat pierreSort3 	= new ActionCombat(333, "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Pierre);
		// Mission : "Pierre Paul Ciseau", "Inventer un jeu de main tirant profit des années d'experience et d'entrainement de cette dernière" / image : c19 - Kim Jong Un en c19
		ActionCombat pierreSort4	= new ActionCombat(334, "(Absorb Vie Mono) Serre main de fer", "Absorbe la vie de son ennemi en lui serrant la main avec une poigne de fer, sans lui jeter la pierre, mais le bouchon de pinard Saint-Pujadas", imagePaths334, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.AGILITE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Pierre);
//		ActionCombat pierreSort5 	= new ActionCombat(335, "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreSort6 	= new ActionCombat(336, "Regen Mana Perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Pierre);
//		ActionCombat pierreSort7 	= new ActionCombat(337, "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Pierre);
		// Mission : "Soirée racaille", "Changer de coiffure pour un style moins chevelu et plus chevaleresque et de dress-code pour un style moins orthodoxe et plus racouillu" / image : cheval - tete de cheval troll
		ActionCombat pierreSort8 	= new ActionCombat(338, "(Regen Mana Multi) Circoncision exquise", "Redonne du mana à ses alliés en excisant sa petite queue de cheveux magique démodée en échange d'une grande queue de cheval equitable", imagePaths338, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.AGILITE, SortType.REGEN_MANA_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreSort9 	= new ActionCombat(339, "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Pierre);
//		ActionCombat pierreSort10 	= new ActionCombat(340, "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreSort11 	= new ActionCombat(341, "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Pierre);
//		ActionCombat pierreSort12 	= new ActionCombat(342, "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Pierre);
		// Mission : "Demain à la une", "Retourner dans le passé pour empêcher ces fils de pute de japanese de se faire secteur-Analiser et torcher l'anus du monde" / image : futur - marty qui tient l'almanak
		ActionCombat pierreSort13 	= new ActionCombat(343, "(Resurrection Mono) L'Almarak des sports", "Retourne dans le passé pour rencontrer Marek, père de Marak et fils de morse, écouter son histoire ayant ni queue ni tête, et empêcher la mort d'un allié", imagePaths343, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.AGILITE, SortType.RESURRECTION_MONO, PersoPrenom.Pierre);
//		ActionCombat pierreSort14 	= new ActionCombat(344, "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreSort15 	= new ActionCombat(345, "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Pierre);
		// Mission : "Boys-Band à B-Boys", "Evoluer radicalement de style musical en passant de la merde commerciale française au rap commercial américain comme son frère" / image : 2be3 - boys band choregraphie
		ActionCombat pierreSort16 	= new ActionCombat(346, "(Taunt Multi) Warren G Squad", "Travaille son style de danseur rappeur en improvisant une chorégraphie sans tête à queue pour provoquer les ennemis", imagePaths346, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.AGILITE, SortType.TAUNT_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreSort17 	= new ActionCombat(347, "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Pierre);
//		ActionCombat pierreSort18 	= new ActionCombat(348, "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Pierre);
		// Mission : "Optic 2000" "Rouler deux cônes et descendre croquer un croc sans se taper de barre ou se casser les dents dans l'escalier pour ne pas se faire tricard par sa daronne qui dort d'un oeil sur ses 5 oreilles" / image : didier - didier l'embrouille avec oeil au beurre noir
		ActionCombat pierreSpecial1 = new ActionCombat(381, "(Degats Multi) Oeil pour Oeil, Dent pour Dent", "Traite les ennemis en queue de peloton de la même façon qu'ils ont traité ou voulu traiter ses alliés grâce à sa dent de fer et à sa mère borgne", imagePaths381, sonAttaque381, sonAttaqueCritique381, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.AGILITE, SortType.DEGATS_MULTI, PersoPrenom.Pierre);
//		ActionCombat pierreSpecial2 = new ActionCombat(382, "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Pierre);
	
		
		// Yannick (Resistance)
		
		// Image : jaime - Jaime Lannister
		ActionCombat yannickAttaque1 = new ActionCombat(401, "(Degats Mono) Stark Wars Kid", "Met autant de claques à l'ennemi qu'il rêvera de guerres de l'étoile, de se faire couper le moignon et de s'acoquiner avec sa soeur dans sa vie", imagePaths401, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Yannick);
//		ActionCombat yannickAttaque2 = new ActionCombat(402, "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickDefense1 = new ActionCombat(411, "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Yannick);
		// Mission : "Poker Face", "Ecraser une vogue menthol dans sa main quand ça sent le roussi et se brûler sans emotion pour ne pas se faire cramer, alors que c'est cuit" / image : terminator - T1000 avec une balle dans la tete
		ActionCombat yannickDefense2 = new ActionCombat(412, "(Bouclier Perso) Même pas mal", "Se protège grâce à son insensibilité naturelle aux brûlures, au rap, au foot, à presque tout sauf à la prise de l'étouffement", imagePaths412, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Yannick);
//		ActionCombat yannickDefense3 = new ActionCombat(413, "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Yannick);
		// Mission : "Lapidation dilapidante", "Résister sans assistance aux assauts incessants et insistants de ses assaillants en persistant et sans se désister" / image : sabre - entrainement de Luke au sabre
		ActionCombat yannickDefense4 = new ActionCombat(414, "(Bouclier Multi) Defense de Jedi Knight", "Protège ses alliés grâce à ses reflexes et son taux de midi-alcolo-rien élevé mais limité, l'empêchant de tomber du coté obscur de la Forza", imagePaths414, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.BOUCLIER_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickDefense5 = new ActionCombat(415, "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.AURA_PERSO, PersoPrenom.Yannick);
		// Mission : "Sainte Marie-Jeanne", "Rouler des graines de pavot avec un blunt mal séché pour atteindre le Nirvana et préciser que boire de l'eau annule les effets" / image : huggy - Huggy les bons tuyaux
		ActionCombat yannickDefense6 = new ActionCombat(416, "(Aura Mono - Technique) Conseil d'ami", "Invoque une aura violette améliorant la Technique de consommation florale d'un allié comme la fameuse tulipe fanée triple vrillée et casquée en cappuccino frappé", imagePaths416, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Yannick);
		// Mission : "Célébration cyclique", "Participer au premier jour de l'an des familles, à base d'oeufs pourris, de main dans le caca et de traces de pneu enflammées" / image : boris - Boris meurt gelé
		ActionCombat yannickDefense7 = new ActionCombat(417, "(Aura Multi - Resistance) Retour à la base", "Invoque une aura permettant d'améliorer l'accent russe et la Résistance de ses alliés au froid, au 'Golden Gun' et aux tickets resto", imagePaths417, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.AURA_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickDefense8 = new ActionCombat(418, "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Yannick);
//		ActionCombat yannickSort1	 = new ActionCombat(431, "Regen Vie Perso", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Yannick);
//		ActionCombat yannickSort2 	 = new ActionCombat(432, "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Yannick);
//		ActionCombat yannickSort3 	 = new ActionCombat(433, "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickSort4 	 = new ActionCombat(434, "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Yannick);
//		ActionCombat yannickSort5 	 = new ActionCombat(435, "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickSort6 	 = new ActionCombat(436, "Regen Mana Perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Yannick);
//		ActionCombat yannickSort7 	 = new ActionCombat(437, "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Yannick);
//		ActionCombat yannickSort8 	 = new ActionCombat(438, "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Yannick);
		// Mission : "Sans contrefaçon", "Mater l'intégralité des 7 saisons de Buffy sans se branler et les 119 épisodes d'Higlander sans se faire griller par sa soeur" / image : buffy - sexy buffy
		ActionCombat yannickSort9 	 = new ActionCombat(439, "(Absorb Mana Mono) Amante religieuse", "Absorbe le mana de l'ennemi en lui plantant profondément son pieu, en lui tranchant la tête ou en le mordant, en le sucant et en avalant son mana", imagePaths439, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.RESISTANCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Yannick);
//		ActionCombat yannickSort10 	 = new ActionCombat(440, "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickSort11 	 = new ActionCombat(441, "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Yannick);
		// Mission : "Romance Romano-Romantique", "Ecraser sa Ryan Philip Morris et regarder une fois de plus 'Roméo + Juliette' en sachant pertinemment qu'à la fin le Titanic coulera" / image : poison - poison pour juliette
		ActionCombat yannickSort12 	 = new ActionCombat(442, "(Brulure Mana Multi) Juliette je t'aime", "Empoisonne les ennemis sans capituler ni monter dans les aigus et fume leur mana allongé sur un banc en regardant les étoiles", imagePaths442, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RESISTANCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickSort13 	 = new ActionCombat(443, "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Yannick);
//		ActionCombat yannickSort14 	 = new ActionCombat(444, "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickSort15 	 = new ActionCombat(445, "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Yannick);
		// Mission : "Ya Nickelback to the past", "Acheter une guitare et imposer son propre style musical et vestimentaire malgré la pression sociale de la masse" / image : nirvana - sucette differente
		ActionCombat yannickSort16 	 = new ActionCombat(446, "(Taunt Multi) FF Ya NTM", "Met de la musique à contre-courant, un T-Shirt à manches courtes sur un T-Shirt à manches longues, un soutien-gorge et des Vans pour provoquer les ennemis", imagePaths446, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RESISTANCE, SortType.TAUNT_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickSort17 	 = new ActionCombat(447, "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Yannick);
		// Mission : "A un poil près", "Partir en virée nocturne pour une ratonnade de réverbère et ramener Yo chez lui avant que sa mère ne l'enferme sur le balcon" / image : peinture - peinture lascaux
		ActionCombat yannickSort18 	 = new ActionCombat(448, "(Stun Multi) Peinture rupestre volé", "Fait de mémoire un saint dessin des seins de la mère de Yo non retouché par Mme Braquet et le montre aux ennemis pour les bloquer", imagePaths448, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RESISTANCE, SortType.STUN_MULTI, PersoPrenom.Yannick);
		// Mission : "Quelle guêpe t'as piqué", "Faire passer 5 grammmes de shit au shampoing aux Etats-Unis et acheter de la beuh de Montreal puis revenir jouer à Braveheart entre deux parties de worms dictateurs" / image : explosion - explosion en doigt d'honneur / Son : 
		ActionCombat yannickSpecial1 = new ActionCombat(481, "(Degats Multi) Banana Bombe Sainte", "Effectue une frappe chirurgicale avec une bombe de type BOB-SA-66 sur les ennemis pour instaurer une démocratie sainte et une république bananière", imagePaths481, sonAttaque481, sonAttaqueCritique481, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RESISTANCE, SortType.DEGATS_MULTI, PersoPrenom.Yannick);
//		ActionCombat yannickSpecial2 = new ActionCombat(482, "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Yannick);
	
		
		// Thomas (Intelligence)
		
		// Image : chain - imitation d'emmanuel Chain
		ActionCombat thomasAttaque1 = new ActionCombat(501, "(Degats Mono) Tu bluffes Martino", "Met autant de claques à l'ennemi qu'il plagiera de repliques de films, de sketchs cultes et de chansons funky dans sa vie", imagePaths501, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Thomas);
//		ActionCombat thomasAttaque2 = new ActionCombat(502, "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasDefense1 = new ActionCombat(511, "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Thomas);
		// Mission : "La technique de la Tortue", "Développer son instinct de survie en inventant une technique personnelle de parade adapté à toutes les situations dangereuses" / image : bulma - tortue geniale saigne du nez
		ActionCombat thomasDefense2 = new ActionCombat(512, "(Bouclier Perso) Tortue Géniale", "Se protège instinctivement en se créant un casque-carapace de bras à la vue d'un projectile ou d'une culotte afin d'éviter tout saignement nasal incontrôlé", imagePaths512, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Thomas);
//		ActionCombat thomasDefense3 = new ActionCombat(513, "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Thomas);
//		ActionCombat thomasDefense4 = new ActionCombat(514, "(Bouclier Multi)", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasDefense5 = new ActionCombat(515, "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.AURA_PERSO, PersoPrenom.Thomas);
//		ActionCombat thomasDefense6 = new ActionCombat(516, "(Aura Mono) ", "", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.AURA_MONO, PersoPrenom.Thomas);
		// Mission : "Danse avec les louveteaux", "Faire du feu et survivre à une nuit en forêt en évitant les animaux, les bêtes et les trois doigts de Jackie Chang le moniteur" / image : scout - gerard jugnot matte des seins
		ActionCombat thomasDefense7 = new ActionCombat(517, "(Aura Multi - Intelligence) Scout en Schott", "Son experience et son adaptabilité aux milieux hostiles lui permet d'invoquer une aura qui augmente l'Intelligence, la survivabilité et la scratchitude de ses alliés", imagePaths517, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.AURA_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasDefense8 = new ActionCombat(518, "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Thomas);
		// Mission : "Coagulation nasale", "Maitriser son flux et son reflux sanguin pour ne pas lacher la sauce et se vider involontairement en cas de choc pedestre" / image : tampax - tampax sur l'oreille
		ActionCombat thomasSort1 	= new ActionCombat(531, "(Regen Vie Perso) Sang pur Sans coton", "Utilise tout objet absorbant à portée ou son sous-pull à col roulé en licra, pour arrêter une quelconque hémorragie et se soigner", imagePaths531, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Thomas);
//		ActionCombat thomasSort2 	= new ActionCombat(532, "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Thomas);
		// Mission :"Grand saigneur", "Inviter ses alliés à squatter dans son apart, dans son jardin secret magique et dans la voiture-épave de son frère"  / image : tyrion - Tyrion Darmouni
		ActionCombat thomasSort3 	= new ActionCombat(533, "(Regen Vie Multi) Seigneur Soigneur", "Offre son hospitalité à ses péons squatters drogués dans son domaine, les amuse et les nourrit, ce qui leur redonne de la vie", imagePaths533, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasSort4 	= new ActionCombat(534, "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Thomas);
		// Mission : "Pilou face", "Boursicoter mollement sur le cours de l'action du mouchoir pour amortir sa surconsommation menstruelle mise en branle avec l'érection des sites de bourses en ligne" / image : kleenex - poubelle qui deborde de papier
		ActionCombat thomasSort5 	= new ActionCombat(535, "(Absorb Vie Multi) Forfait Kleenex Millenium", "Se mouche de manière gratuite et illimitée les soirs et week-end avec des mouchoirs ultra-absorbants, absorbant même la vie des ennemis", imagePaths535, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasSort6 	= new ActionCombat(536, "Regen Mana Perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Thomas);
//		ActionCombat thomasSort7 	= new ActionCombat(537, "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Thomas);
//		ActionCombat thomasSort8 	= new ActionCombat(538, "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasSort9 	= new ActionCombat(539, "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Thomas);
//		ActionCombat thomasSort10 	= new ActionCombat(540, "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Thomas);
		// Mission : "Mange pas mes papiers", "Acheter un briquet à gaz hilarant et faire un aquarium asphyxiant en brulant du papier par crémation dans l'antichambre à air conditionné" / image : armenie - papier d'armenie
		ActionCombat thomasSort11 	= new ActionCombat(541, "(Brulure Mana Mono) Papier d'Armouni", "Absorbe nasalement un retour de toncar en brulant du papier d'Arménie, le mana de l'ennemi et l'ennemi dans un four à gaza", imagePaths541, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Thomas);
//		ActionCombat thomasSort12 	= new ActionCombat(542, "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Thomas);
		// Mission : "Les règles en tête", "Utiliser son surplus sanguin nazifère à des fins curatives comme l'aurait fait la croix pas gammé rouge en période de débarquement pour éviter les pertes" / image : saigne - Pif et Hercule pd
		ActionCombat thomasSort13 	= new ActionCombat(543, "(Resurrection Mono) Soigne du pif", "Redonne la vie à un allié en tombant dos à dos et en faisant du nez à nez grâce à ses dons et à ses capacités de perfusion olfactive herculienne", imagePaths543, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Thomas);
		// Mission : "Expert en communication", "Faire une séance éclair de spiritisme dans son salon avec l'étincelant Claude François sans péter les plombs ni pisser dans le bain" / image : messmer
		ActionCombat thomasSort14 	= new ActionCombat(544, "(Resurrection Multi) Harmonie Extra-Sang-Soral", "Sa connaissance courante de la Kabbale, lui a procuré un don en communication afin de se tenir au jus, de contacter les morts et de les ressusciter", imagePaths544, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasSort15 	= new ActionCombat(545, "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Thomas);
//		ActionCombat thomasSort16 	= new ActionCombat(546, "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasSort17 	= new ActionCombat(547, "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Thomas);
//		ActionCombat thomasSort18 	= new ActionCombat(548, "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Thomas);
		// Mission : "Donnant-Donnant", "Gratter l'amitié avec 5 orphelines de l'est en leur payant un jus de fruit et en abandonnant son corps à la science en échange" / image : centPatates : tetes de dosés
		ActionCombat thomasSpecial1 = new ActionCombat(581, "(Degats Multi) Shoot Sans patate", "Appelle à la rescousse Fred, son flingue à billes et l'enculé de Steph pour l'attaque des trois frères donnant cent patates aux ennemis, puis les reprenant... Quand même!", imagePaths581, sonAttaque581, sonAttaqueCritique581, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MULTI, PersoPrenom.Thomas);
//		ActionCombat thomasSpecial2 = new ActionCombat(582, "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_1, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Thomas);
	
		
		// Ali (Vitesse)
		// TODO sort niveau elevee(5?) car arrivée tardive
		
		// Image : zidane - coup de boule Materazzi
		ActionCombat aliAttaque1 = new ActionCombat(701, "(Degats Mono) Taxeur Teteur fou", "Met autant de claques à l'ennemi qu'il taxera de cigarettes et qu'il mettra de coup de tête dans sa vie", imagePaths701, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_5, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Ali);
//		ActionCombat aliAttaque2 = new ActionCombat(702, "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.RAPIDITE, SortType.DEGATS_MULTI, PersoPrenom.Ali);
//		ActionCombat aliDefense1 = new ActionCombat(711, "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RAPIDITE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Ali);
		// Mission : "Dépucelage mécanique", "Se forger son expérience sur des engins de seconde main, se planter, tirer des fusées de detresse puis piloter des avions de chasse, des missiles et des bombes atomiques" / image : cascade - cascade avion moto voiture
		ActionCombat aliDefense2 = new ActionCombat(712, "(Bouclier Perso) Pilote de l'extrême", "Se protège grâce à son experience en conduite terroriste multirécidiviste multisupport en sortant toujours couvert", imagePaths712, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RAPIDITE, SortType.BOUCLIER_PERSO, PersoPrenom.Ali);
//		ActionCombat aliDefense3 = new ActionCombat(713, "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RAPIDITE, SortType.BOUCLIER_MONO, PersoPrenom.Ali);
//		ActionCombat aliDefense4 = new ActionCombat(714, "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.RAPIDITE, SortType.BOUCLIER_MULTI, PersoPrenom.Ali);
//		ActionCombat aliDefense5 = new ActionCombat(715, "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RAPIDITE, SortType.AURA_PERSO, PersoPrenom.Ali);
//		ActionCombat aliDefense6 = new ActionCombat(716, "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RAPIDITE, SortType.AURA_MONO, PersoPrenom.Ali);
		// Mission : "Coup de génie", "Emprunter des trucs chez Jafar sans se faire prendre la main dans le sac pour financer un traffic international de tapis volant" / image : aladdin - mechant qui coupe une main
		ActionCombat aliDefense7 = new ActionCombat(717, "(Aura Multi - Rapidité) Pas vu, paprika", "Invoque une aura qui augmente la Rapidité et la dextérité de ses alliés pour voler d'immeuble en immeuble comme Superman, Batman ou Spiderman", imagePaths717, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.RAPIDITE, SortType.AURA_MULTI, PersoPrenom.Ali);
		// Mission : "Changement de bord", "Modifier ses fréquentations de manière radical et apprendre à gérer ses émotions derrière un pédalo à pédales douces" / image : soirées - Omar tu viens plus aux soirees
		ActionCombat aliDefense8 = new ActionCombat(718, "(Esquive) Ali doudou", "Esquive les anniversaires, ne vient plus aux soirées et peut désormais sauter un filet de tennis sans se rétamer", imagePaths718, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RAPIDITE, SortType.ESQUIVE, PersoPrenom.Ali);
		// Mission : "Expérience sensorielle", "Survivre à la chaleur écrasante de l'Espagne en inventant un style de jeu peu orthodoxe 'avé l'acceng' de la garrigue" / image : teton - teton glacon humide
		ActionCombat aliSort1 	 = new ActionCombat(731, "(Regen Vie Perso) Ice Pedoula Challenge", "Se régénère en s'allongant sur un canapé et en se caressant sensuellement les tétons avec un glaçon Antartica", imagePaths731, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.RAPIDITE, SortType.REGEN_VIE_PERSO, PersoPrenom.Ali);
//		ActionCombat aliSort2 	 = new ActionCombat(732, "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.RAPIDITE, SortType.REGEN_VIE_MONO, PersoPrenom.Ali);
//		ActionCombat aliSort3 	 = new ActionCombat(733, "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.RAPIDITE, SortType.REGEN_VIE_MULTI, PersoPrenom.Ali);
//		ActionCombat aliSort4 	 = new ActionCombat(734, "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.RAPIDITE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Ali);
//		ActionCombat aliSort5 	 = new ActionCombat(735, "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RAPIDITE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Ali);
		// TODO mission cloclo
//		ActionCombat aliSort6    = new ActionCombat(736, "Regen Mana Perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.RAPIDITE, SortType.REGEN_MANA_PERSO, PersoPrenom.Ali);
//		ActionCombat aliSort7 	 = new ActionCombat(737, "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.RAPIDITE, SortType.REGEN_MANA_MONO, PersoPrenom.Ali);
//		ActionCombat aliSort8 	 = new ActionCombat(738, "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.RAPIDITE, SortType.REGEN_MANA_MULTI, PersoPrenom.Ali);
//		ActionCombat aliSort9 	 = new ActionCombat(739, "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.RAPIDITE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Ali);
//		ActionCombat aliSort10 	 = new ActionCombat(740, "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RAPIDITE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Ali);
//		ActionCombat aliSort11 	 = new ActionCombat(741, "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.RAPIDITE, SortType.BRULURE_MANA_MONO, PersoPrenom.Ali);
		// Mission : "Roulette pakistanaise", "Tirer avec un pistolet dans une pièce fermée sans savoir si il est chargé, pour devenir cascadeur figurant terroriste" / image : lacrymo - JCVD aveugle
		ActionCombat aliSort12 	 = new ActionCombat(742, "(Brulure Mana Multi) Plein les yeux", "Tire un coup de pistolet lacrymogène en intérieur pour bruler les yeux de ses ennemis et s'enfuit en se jetant par la fenêtre", imagePaths742, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RAPIDITE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Ali);
		// Mission : "Heal the world", "Ecrire une chanson qui redonne espoir en la vie, après son mariage en secret avec Aïcha 9 ans à ArabeLand" / image : healWorld - des mains autour de la Terre
		ActionCombat aliSort13 	 = new ActionCombat(743, "(Resurrection Mono) Le chant de sucre rouge", "Redonne la vie à un allié en chantant et en mélangeant quelques épices rougeatres en référence au sang versé dans les champs de canne à sucre", imagePaths743, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.RAPIDITE, SortType.RESURRECTION_MONO, PersoPrenom.Ali);
//		ActionCombat aliSort14 	 = new ActionCombat(744, "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.RAPIDITE, SortType.RESURRECTION_MULTI, PersoPrenom.Ali);
//		ActionCombat aliSort15 	 = new ActionCombat(745, "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.RAPIDITE, SortType.TAUNT_MONO, PersoPrenom.Ali);
		// Mission : "Cambriolage amical", "Mener l'opération de pénétration par effraction chez Yannick en utilisant ses qualités naturelles d'homme javelot cerf-volant" / image : culCoince - petite biche coince dans une grille
		ActionCombat aliSort16   = new ActionCombat(746, "(Taunt Multi) Operation Sex Piege", "Se coince dans une grille et baisse son froc pour provoquer les ennemis et les attirer tel un trou noir en criant niech niech", imagePaths746, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RAPIDITE, SortType.TAUNT_MULTI, PersoPrenom.Ali);
		// Mission : "Le maitre et l'élève", "Admirer les techniques de combat sur chaise de Johann et en prendre de la graine de starloose academy" / image : crochePied - croche pied d'une journaliste sur une pere et son gosse
		ActionCombat aliSort17 	 = new ActionCombat(747, "(Stun Mono) Croche-mensonge", "Bloque l'ennemi avec ses jambes pour lui frotter son sexe sur le corps, et l'imprégner d'une odeur de putois épicée entrainant l'évanouïte", imagePaths747, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.RAPIDITE, SortType.STUN_MONO, PersoPrenom.Ali);
//		ActionCombat aliSort18 	 = new ActionCombat(748, "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RAPIDITE, SortType.STUN_MULTI, PersoPrenom.Ali);
		// Mission : "Mohamed Ali Jackson", "Suivre les traces de son idole sous la contrainte de ses 5 soeurs et se battre pour atteindre son objectif sans se laisser rouler sur les chaussures noires" / image : bollywood - Michael Jackson indien sur Thriller / Son : 
		ActionCombat aliSpecial1 = new ActionCombat(781, "(Degats Multi) Ali! Ali!", "Profite de l'engouement général pour se donner en spectacle bollywoodien, faire son one man chaud du rire sous l'oeil du grand blond et infliger des dégats aux ennemis", imagePaths781, sonAttaque781, sonAttaqueCritique781, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.RAPIDITE, SortType.DEGATS_MULTI, PersoPrenom.Ali);
//		ActionCombat aliSpecial2 = new ActionCombat(782, "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_5, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.RAPIDITE, SortType.DEGATS_ALL, PersoPrenom.Ali);
		
		
		// Guillaume (Technique)
		// TODO sort niveau elevee(6?) car arrivée tardive
		
		// Image : gainsbar - serge gainsbourg
		ActionCombat guillaumeAttaque1 = new ActionCombat(601, "(Degats Mono) 50 nuances de grisé", "Met autant de claques à l'ennemi qu'il fera de soirées complétement déchiré au whisky coca sans coca dans sa vie", imagePaths601, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeAttaque2 = new ActionCombat(602, "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeDefense1 = new ActionCombat(611, "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Guillaume);
		// Mission : "Le calme après la tempête", "Survivre à une grosse soirée houleuse sans trépasser ni faiblir tel un moussaillon déguisé en dancing Queen" / image : waterloo - vieil homme qui sort d'un taxi en peignoir
		ActionCombat guillaumeDefense2 = new ActionCombat(612, "(Bouclier Perso) Waterloo", "Se protège grâce à son expérience au combat contre les pirates, les zombies et soi-même et grâce à son peignoir Napoléonien à bas prix", imagePaths612, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.BOUCLIER_PERSO, PersoPrenom.Guillaume);
		// Mission : "L'enfer de la mode", "Acheter un accoutrement cher qui protégera son porteur des vols de portable et autre patates perdues de fin d'embrouille de soirée racaille" / image : doudoune - doudoune sans manche orange
		ActionCombat guillaumeDefense3 = new ActionCombat(613, "(Bouclier Mono) A moitié vide", "Prete sa doudoune sans manche et sa banane Lacoste à un allié pour une semi protection contre le froid, les dégats et le style", imagePaths613, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.BOUCLIER_MONO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeDefense4 = new ActionCombat(614, "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeDefense5 = new ActionCombat(615, "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.AURA_PERSO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeDefense6 = new ActionCombat(616, "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.TECHNIQUE, SortType.AURA_MONO, PersoPrenom.Guillaume);
		// Mission : "La ronde des jonglerettes", "S'entrainer techniquement et physiquement pour essayer de finir un match debout dans sa vie en se mettant à la recherche du poumon perdu" / image : footBande - footballer pd
		ActionCombat guillaumeDefense7 = new ActionCombat(617, "(Aura Multi - Technique) Tu m'as fait bander", "Glorifie ses alliés pour augmenter leur Technique en mêlant sport, sexualité et grand banditisme", imagePaths617, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeDefense8 = new ActionCombat(618, "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.AGILITE, SortType.ESQUIVE, PersoPrenom.Guillaume);
		// Mission : "GuiHam Burger", "Créer une recette saine et équilibrée pour se nourrir quotidiennement de manière étrange, efficace et brève de Bruges" / image : pizzaMayo - gros burger degeulasse
		ActionCombat guillaumeSort1    = new ActionCombat(631, "(Regen Vie Perso) Pizza mayo sandwich", "Se régénère en ingurgitant une composition personnelle pliable de mets savoureux qui poussent naturellement dans le frigo", imagePaths631, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.REGEN_VIE_PERSO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort2    = new ActionCombat(632, "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort3    = new ActionCombat(633, "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Guillaume);
		// Mission : "Réseaux sociaux anonymes", "Trouver un moyen d'avoir plein d'amies sur Fakebook pour la Saint-Barthélemy tout en conservant son corps de lache" / image : guillaumeFroissard - la petit guillaume des 'Faut-il?'
		ActionCombat guillaumeSort4    = new ActionCombat(634, "(Absorb Vie Mono) Guillaume Froissard", "Pénètre analogiquement le corps de qu'en'qu'in d'autre sur le dark web pour lui sucer son identité et sa richesse et la redistribuer aux plus démunis", imagePaths634, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort5    = new ActionCombat(635, "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Guillaume);
		// Mission : "Repos chamanique", "Faire une petite sieste en soirée, le temps de retrouver ses esprits, après avoir entrainer Alice dans sa chute au fond du trou" / image : chaman - chaman avec de la peinture sur la gueule
		ActionCombat guillaumeSort6    = new ActionCombat(636, "(Regen Mana Perso) Méditation éthylique", "Tombe dans un coma régénérateur au pays des merveilles des escargots dans le slip après avoir pris un petit dejeuner aux ongles de chocapic dans ce dernier", imagePaths636, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.TECHNIQUE, SortType.REGEN_MANA_PERSO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort7    = new ActionCombat(637, "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort8    = new ActionCombat(638, "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort9    = new ActionCombat(639, "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Guillaume);
		// Mission : "Ingurgite mais ne vomit pas", "Boire comme un trou pour être immunisé contre le vomissement, le bescherelle et les serpents" / image : trou - trou dans un lac
		ActionCombat guillaumeSort10   = new ActionCombat(640, "(Absorb Mana Multi) Gorge profonde", "Absorbe une quantité astronomique de Mana sans en perdre une goutte et sans devoir régurgiter, mollarder ou recracher le surplus", imagePaths640, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort11   = new ActionCombat(641, "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort12   = new ActionCombat(642, "Brulure Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort13   = new ActionCombat(643, "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort14   = new ActionCombat(644, "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort15   = new ActionCombat(645, "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort16   = new ActionCombat(646, "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.TAUNT_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSort17   = new ActionCombat(647, "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.STUN_MONO, PersoPrenom.Guillaume);
		// Mission : "Le dauphin, la baleine, et l'éléphant", "Trouver un moyen de focaliser l'attention des spectateurs, en préparant un ballet aquatique alcoolique trompeur" / image : piscine - saut d'un asiat avec une vieille gueule
		ActionCombat guillaumeSort18   = new ActionCombat(648, "(Stun Multi) Vous voulez voir mon cul?", "Emet une hypothèse embarrassante pour attirer l'attention puis effectue une action encore plus salace pour surprendre et bloquer les ennemis", imagePaths648, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.STUN_MULTI, PersoPrenom.Guillaume);
		// Mission : "Brasserie Mollard", "Rouler sa bosse pour devenir chamelier et étancher sa soif en buvant 5 verres sans cracher dans la soupe ni baver sur la serveuse" / image : spit - crachat dans un verre / Son : crachat roulé
		ActionCombat guillaumeSpecial1 = new ActionCombat(681, "(Degats Multi) Crache pas dans les verres", "Utilise une expression cocasse qui n'existe pas dans un contexte inaprorié pour infliger des dégats pendant que les ennemis restent perplexe", imagePaths681, sonAttaque681, sonAttaqueCritique681, videoPaths, indisponible, niveau_6, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Guillaume);
//		ActionCombat guillaumeSpecial2 = new ActionCombat(682, "Debut de merde (Degats All)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_6, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.TECHNIQUE, SortType.DEGATS_ALL, PersoPrenom.Guillaume);
	
		
		// Jonathan (Endurance) 
		// TODO sorts niveau 7 car arrivée en dernier ???
		// TODO anachronisme
		
		// Image : orangina - boudder 'Mais pourquoi est-il aussi mechant?'
		ActionCombat jonathanAttaque1 = new ActionCombat(801, "(Degats Mono) Abul de nerf à vif", "Met autant de claques à l'ennemi qu'il fera d'années d'étude, qu'il aura de zero en dictée et qu'il s'énervera de manières disproportionnées dans sa vie", imagePaths801, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveau_7, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, PersoPrenom.Jonathan);
//		ActionCombat jonathanAttaque2 = new ActionCombat(802, "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Jonathan);
//		ActionCombat jonathanDefense1 = new ActionCombat(811, "Renvoi degats Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.RENVOI_DEGATS_PERSO, PersoPrenom.Jonathan);
		// TODO trouver une image de meilleur qualité
		// Mission : "Un homme de fer dans une toison de velour", "Se regarder dans un miroir et realiser que l'on est plus proche du singe que de l'homo-xeno-phobo-erectus" / image : poilu - un homme tres poilu / Son : chewbaka
		ActionCombat jonathanDefense2 = new ActionCombat(812, "(Bouclier Perso) Torse poil", "Se protège grâce à sa pilosité abondante en laissant repousser instantanement son manteau en poil d'ours brun", imagePaths812, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.ENDURANCE, SortType.BOUCLIER_PERSO, PersoPrenom.Jonathan);
//		ActionCombat jonathanDefense3 = new ActionCombat(813, "Bouclier Mono", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.RESISTANCE, SortType.BOUCLIER_MONO, PersoPrenom.Jonathan);
//		ActionCombat jonathanDefense4 = new ActionCombat(814, "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.BOUCLIER_MULTI, PersoPrenom.Jonathan);
//		ActionCombat jonathanDefense5 = new ActionCombat(815, "Aura Perso", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.ENDURANCE, SortType.AURA_PERSO, PersoPrenom.Jonathan);
//		ActionCombat jonathanDefense6 = new ActionCombat(816, "Aura Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.ALLIE, PersoStat.ENDURANCE, SortType.AURA_MONO, PersoPrenom.Jonathan);
		// TODO trouver une meilleur image que la trilogie du samedi
		// Mission : "Premier samedi du mois", "Regarder la trilogie du samedi en attendant que ses parents s'endorment pour enregistrer discrètement sur VHS les 26 saisons de Turbo" / image : trilogieSamedi - 
		ActionCombat jonathanDefense7 = new ActionCombat(817, "(Aura Multi - Endurance) Le Triathlon du dimanche", "Invoque une aura d'Endurance physique et auto-moto-masturbo-télévisuelle pour ses alliés", imagePaths817, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.ENDURANCE, SortType.AURA_MULTI, PersoPrenom.Jonathan);
		// Mission : "Vibreur silencieux", "Omettre de répondre à son GSM le temps de mater un match et une emission culturelle juste avant le mariage d'Ali et son frère à Molenbeek" / image : autruche - rituel avec la tete planter dans le sol
		ActionCombat jonathanDefense8 = new ActionCombat(818, "(Esquive) La technique de l'Autroych", "Ne sort plus du troux pour esquiver les attaques judiciaires en chantant la ligue des questions pour un champion allah capello en fa mineur avec l'accent belge", imagePaths818, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.ENDURANCE, SortType.ESQUIVE, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort1    = new ActionCombat(831, "Regen Vie Perso", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_PERSO, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort2    = new ActionCombat(832, "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort3    = new ActionCombat(833, "Regen Vie Multi", "La pizza de Gino", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort4    = new ActionCombat(834, "Absorb Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort5    = new ActionCombat(835, "Absorb Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MULTI, PersoPrenom.Jonathan);
		// Mission : "Peau de caméléon", "S'entretenir l'épiderme à cause des agressions du quotidien comme les gerçures, les peaux sèches et autres plantage de crayon dans la main" / image : peau - giclade dans l'oeil d'une bonnasse
		ActionCombat jonathanSort6    = new ActionCombat(836, "(Regen Mana Perso) Cure de jouvence", "Se régénère en s'éclaboussant de crême blanche rajeunissante, de gel visqueux bio et de liquide de refroidissement anti-vieillissement", imagePaths836, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.PERSO, PersoStat.ENDURANCE, SortType.REGEN_MANA_PERSO, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort7    = new ActionCombat(837, "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort8    = new ActionCombat(838, "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MULTI, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort9    = new ActionCombat(839, "Absorb Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort10   = new ActionCombat(840, "Absorb Mana Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MULTI, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort11   = new ActionCombat(841, "Brulure Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.BRULURE_MANA_MONO, PersoPrenom.Jonathan);
		// Mission : "Bronzage extreme", "S'exposer au soleil de manière prolongée tel un baleineau échoué sur la banquise jusqu'à devenir noir de peau" / image : coupDeSoleil - bebe avec des coups de soleil
		ActionCombat jonathanSort12   = new ActionCombat(842, "(Brulure Mana Multi) Coups de soleil", "Se rase intégralement sans couper ses pattes et plonge dans une piscine de graisse à traire pour refléter les rayons du soleil et bruler les ennemis", imagePaths842, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.ENDURANCE, SortType.BRULURE_MANA_MULTI, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort13   = new ActionCombat(843, "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort14   = new ActionCombat(844, "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, PersoPrenom.Jonathan);
//		ActionCombat jonathanSort15   = new ActionCombat(845, "Taunt Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.TAUNT_MONO, PersoPrenom.Jonathan);
		// Mission : "Johnathan McCain", "Regarder le film 'Die Hard 3' en evitant les pièges de cristal en moins de 58 minutes avant de retourner en enfer pour une belle journée" / image : diehard3 - pancarte 'I hate Niggers' / son : la mer noire
		ActionCombat jonathanSort16   = new ActionCombat(846, "(Taunt Multi) La mer noire", "Met son maillot de bain moule bambou, lit le code noir en écoutant 'De La Soul' et affiche son tatouage mussolinien pour provoquer les ennemis", imagePaths846, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.ENDURANCE, SortType.TAUNT_MULTI, PersoPrenom.Jonathan);
		// Mission : "Un poing c'est tout", "Acheter la première d'une longue lignée de Fiat Punto et s'énerver en réalisant qu'on a du sang africain et asiatique... sur le pare-brise" / image : rush - rush hour jackie chang et Chris Tucker
		ActionCombat jonathanSort17   = new ActionCombat(847, "(Stun Mono) Rush Hour", "Stoppe brusquement sa conduite nerveuse de Jacky en faisant crisser ses pneus et gueule dans son retro ou sort de sa Punto pour impressioner un ennemi et le bloquer", imagePaths847, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.NERVOSITE, SortType.STUN_MONO, PersoPrenom.Jonathan);
		// Mission : "Pompes de racaille", "Acheter les premières d'une longue lignée de requins, une veste flashy, un banc de muscu et un Kärcher" / image : requin - mechant requin dans Nemo
		ActionCombat jonathanSort18   = new ActionCombat(848, "(Stun Multi) Requins Arlequin et Haribo", "Met son accoutrement fluorescent quadricolor de la Commedia dell'Arte ou fait le baffie bouffi bouffon pour éblouir les ennemis et les bloquer", imagePaths848, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.ENDURANCE, SortType.STUN_MULTI, PersoPrenom.Jonathan);
//		ActionCombat jonathanSpecial1 = new ActionCombat(881, "Debut de merde (Degats Multi)", "Fait un debut de merde mal maitrisé", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, PersoPrenom.Jonathan);
		// Mission : "La pizza de Gino", "Maitriser la cuisson des pâtes aux croutes de parmesan sans mettre de maillot et se taper 5 fruits et légumes par jour" / image : pasteque - pasteque qui explose / Son : 
		ActionCombat jonathanSpecial2 = new ActionCombat(882, "(Degats All) Italien ou Russe mais pas Azteque", "Sacrifie une pastèque Inca en la fracassant sur l'autel dans un excès de rage pour infliger des dégats à tout le monde", imagePaths882, sonAttaque882, sonAttaqueCritique882, videoPaths, indisponible, niveau_7, niveauMax_10, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.TOUS, PersoStat.NERVOSITE, SortType.DEGATS_ALL, PersoPrenom.Jonathan);
		
		
		
		
		//////////////////// ENNEMIS ///////////////////////
		int niveauSort = 1;
		int niveauMaxSort = 10;
		// TODO niveau des sort ennemis/boss en fonction de la difficulte / du niveau max des sorts des persos ???
		
		// TODO nom des sorts boss / sorts specifiques par boss
		
		// Boss1 (Yo) (Zinedine Zidane) 
		ActionCombat boss1Attaque1 = new ActionCombat(incrementId(), "(Degats Mono) Coup de boule", "(Le triplé) Commence par deux coups de tête et fini sur un coup de boule", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat boss1Attaque2 = new ActionCombat(incrementId(), "(Degats Multi) Attaque du Real", "attaque 1 info", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		ActionCombat boss1Defense7 = new ActionCombat(incrementId(), "(Aura Multi - Chance) La chance du débutant", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.AURA_MULTI, null);
		ActionCombat boss1Special1 = new ActionCombat(incrementId(), "(Degats Mono) Reprise du gauche en final", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);

		// Boss2 (Nico) (Lara Croft)
		ActionCombat boss2Attaque1 = new ActionCombat(incrementId(), "(Degats Mono) Munitions illimitées", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat boss2Attaque2 = new ActionCombat(incrementId(), "(Degats Multi) Attaque de Loups", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		ActionCombat boss2Defense7 = new ActionCombat(incrementId(), "(Aura Multi - Exploit) Situation critique", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.EXPLOIT, SortType.AURA_MULTI, null);
		ActionCombat boss2Special1 = new ActionCombat(incrementId(), "(Degats Mono) Motorboat", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);

		// Boss3 (Pip) (Dr Dre)
		ActionCombat boss3Attaque1 = new ActionCombat(incrementId(), "(Degats Mono) Coup de mic", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat boss3Attaque2 = new ActionCombat(incrementId(), "(Degats Multi) Attaque de gang", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		ActionCombat boss3Defense7 = new ActionCombat(incrementId(), "(Aura Multi - Agilité) Pas de danse", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.AGILITE, SortType.AURA_MULTI, null);
		ActionCombat boss3Special1 = new ActionCombat(incrementId(), "(Degats Mono) The difference between me and you", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);

		// Boss4 (Tom) (Hitler)
		ActionCombat boss4Attaque1 = new ActionCombat(incrementId(), "(Degats Mono) Coup de tête", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat boss4Attaque2 = new ActionCombat(incrementId(), "(Degats Multi) Attaque de SS", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		ActionCombat boss4Defense7 = new ActionCombat(incrementId(), "(Aura Multi - Intelligence) Blitzkrieg", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.AURA_MULTI, null);
		ActionCombat boss4Special1 = new ActionCombat(incrementId(), "(Degats Mono) Solution finale", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		
		// Boss5 (Ya) (Anakin)
		ActionCombat boss5Attaque1 = new ActionCombat(incrementId(), "(Degats Mono) Coup de sabre laser", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat boss5Attaque2 = new ActionCombat(incrementId(), "(Degats Multi) Attaque de Droïdes", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		ActionCombat boss5Defense7 = new ActionCombat(incrementId(), "(Aura Multi - Resistance) Aura de Jedi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.RESISTANCE, SortType.AURA_MULTI, null);
		ActionCombat boss5Special1 = new ActionCombat(incrementId(), "(Degats Mono) Ablation de la main", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);

		// Boss6 (Ali) (Mickael Jackson)
		ActionCombat boss6Attaque1 = new ActionCombat(incrementId(), "(Degats Mono) Beat it", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat boss6Attaque2 = new ActionCombat(incrementId(), "(Degats Multi) Attaque de Zombies", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		ActionCombat boss6Defense7 = new ActionCombat(incrementId(), "(Aura Multi - Rapidité) Déplacement accrue", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.RAPIDITE, SortType.AURA_MULTI, null);
		ActionCombat boss6Special1 = new ActionCombat(incrementId(), "(Degats Mono) Moonwalk", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);

		// Boss7 (Guy) (Liquid Snake)
		ActionCombat boss7Attaque1 = new ActionCombat(incrementId(), "(Degats Mono) Coup de trop", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat boss7Attaque2 = new ActionCombat(incrementId(), "(Degats Multi) Attaque de Serpents", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		ActionCombat boss7Defense7 = new ActionCombat(incrementId(), "(Aura Multi - Technique) Ivresse télépathique", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.TECHNIQUE, SortType.AURA_MULTI, null);
		ActionCombat boss7Special1 = new ActionCombat(incrementId(), "(Degats Mono) Cascade furtive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);

		// Boss8 (Russ) (Arnaud de la piscine)
		ActionCombat boss8Attaque1 = new ActionCombat(incrementId(), "(Degats Mono) Coup d'épée dans l'eau", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat boss8Attaque2 = new ActionCombat(incrementId(), "(Degats Multi) Pavé dans la mare", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.TECHNIQUE, SortType.DEGATS_MULTI, null);
		ActionCombat boss8Defense7 = new ActionCombat(incrementId(), "(Aura Multi - Endurance) Iron Man", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.ENDURANCE, SortType.AURA_MULTI, null);
		ActionCombat boss8Special1 = new ActionCombat(incrementId(), "(Degats Mono) Dans la peau de John Malkovich", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauMaxSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);

		// Gitans
		
		// Ennemi Gitan Tank
		ActionCombat gitanTankAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanTankDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.ENDURANCE, SortType.ESQUIVE, null);
		ActionCombat gitanTankDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat gitanTankSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.NERVOSITE, SortType.STUN_MONO, null);
		ActionCombat gitanTankSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.NERVOSITE, SortType.TAUNT_MULTI, null);

		// Ennemi Gitan Healer
		ActionCombat gitanHealerAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanHealerDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MULTI, null);
		ActionCombat gitanHealerSort1 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, null);
		ActionCombat gitanHealerSort2 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, null);
		ActionCombat gitanHealerSort3 = new ActionCombat(incrementId(), "Resurection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, null);
		ActionCombat gitanHealerSpecial1 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, null);
		ActionCombat gitanHealerSpecial2 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, null);

		// Ennemi Gitan DPS
		ActionCombat gitanDpsAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanDpsAttaque2= new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);
		ActionCombat gitanDpsDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.EXPLOIT, SortType.ESQUIVE, null);
		ActionCombat gitanDpsSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.EXPLOIT, SortType.STUN_MONO, null);
		ActionCombat gitanDpsSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);

		// Ennemi Gitan Mage
		ActionCombat gitanMageAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanMageDefense1 = new ActionCombat(incrementId(), "Bouclier perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat gitanMageDefense2 = new ActionCombat(incrementId(), "Regen Mana perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, null);
		ActionCombat gitanMageSort1 = new ActionCombat(incrementId(), "Absorption Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, null);
		ActionCombat gitanMageSort2 = new ActionCombat(incrementId(), "Absorption Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, null);
		ActionCombat gitanMageSort3 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO, null);
		ActionCombat gitanMageSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MULTI, null);
		ActionCombat gitanMageSpecial2 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.STUN_MULTI, null);

		// Ennemi Gitan Barde
		ActionCombat gitanBardeAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat gitanBardeDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.BOUCLIER_MULTI, null);
		ActionCombat gitanBardeSort1 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.REGEN_MANA_MULTI, null);
		ActionCombat gitanBardeSort2 = new ActionCombat(incrementId(), "Absorption Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.ABSORPTION_VIE_MULTI, null);
		ActionCombat gitanBardeSort3 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.REGEN_VIE_MONO, null);
		ActionCombat gitanBardeSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.TAUNT_MULTI, null);
		ActionCombat gitanBardeSpecial2 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.RESURRECTION_MONO, null);

		// Arabes
		
		// Ennemi Arabe Tank
		ActionCombat arabeTankAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat arabeTankDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.ENDURANCE, SortType.ESQUIVE, null);
		ActionCombat arabeTankDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat arabeTankSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.NERVOSITE, SortType.STUN_MONO, null);
		ActionCombat arabeTankSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.NERVOSITE, SortType.TAUNT_MULTI, null);

		// Ennemi Arabe Healer
		ActionCombat arabeHealerAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat arabeHealerDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MULTI, null);
		ActionCombat arabeHealerSort1 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, null);
		ActionCombat arabeHealerSort2 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, null);
		ActionCombat arabeHealerSort3 = new ActionCombat(incrementId(), "Resurection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, null);
		ActionCombat arabeHealerSpecial1 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, null);
		ActionCombat arabeHealerSpecial2 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, null);

		// Ennemi Arabe DPS
		ActionCombat arabeDpsAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat arabeDpsAttaque2= new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);
		ActionCombat arabeDpsDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.EXPLOIT, SortType.ESQUIVE, null);
		ActionCombat arabeDpsSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.EXPLOIT, SortType.STUN_MONO, null);
		ActionCombat arabeDpsSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);

		// Ennemi Arabe Mage
		ActionCombat arabeMageAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat arabeMageDefense1 = new ActionCombat(incrementId(), "Bouclier perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat arabeMageDefense2 = new ActionCombat(incrementId(), "Regen Mana perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, null);
		ActionCombat arabeMageSort1 = new ActionCombat(incrementId(), "Absorption Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, null);
		ActionCombat arabeMageSort2 = new ActionCombat(incrementId(), "Absorption Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, null);
		ActionCombat arabeMageSort3 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO, null);
		ActionCombat arabeMageSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MULTI, null);
		ActionCombat arabeMageSpecial2 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.STUN_MULTI, null);

		// Ennemi Arabe Barde
		ActionCombat arabeBardeAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat arabeBardeDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.BOUCLIER_MULTI, null);
		ActionCombat arabeBardeSort1 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.REGEN_MANA_MULTI, null);
		ActionCombat arabeBardeSort2 = new ActionCombat(incrementId(), "Absorption Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.ABSORPTION_VIE_MULTI, null);
		ActionCombat arabeBardeSort3 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.REGEN_VIE_MONO, null);
		ActionCombat arabeBardeSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.TAUNT_MULTI, null);
		ActionCombat arabeBardeSpecial2 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.RESURRECTION_MONO, null);

		// Noirs
		
		// Ennemi Noir Tank
		ActionCombat noirTankAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat noirTankDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.ENDURANCE, SortType.ESQUIVE, null);
		ActionCombat noirTankDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat noirTankSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.NERVOSITE, SortType.STUN_MONO, null);
		ActionCombat noirTankSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.NERVOSITE, SortType.TAUNT_MULTI, null);

		// Ennemi Noir Healer
		ActionCombat noirHealerAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat noirHealerDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MULTI, null);
		ActionCombat noirHealerSort1 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, null);
		ActionCombat noirHealerSort2 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, null);
		ActionCombat noirHealerSort3 = new ActionCombat(incrementId(), "Resurection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, null);
		ActionCombat noirHealerSpecial1 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, null);
		ActionCombat noirHealerSpecial2 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, null);

		// Ennemi Noir DPS
		ActionCombat noirDpsAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat noirDpsAttaque2= new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);
		ActionCombat noirDpsDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.EXPLOIT, SortType.ESQUIVE, null);
		ActionCombat noirDpsSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.EXPLOIT, SortType.STUN_MONO, null);
		ActionCombat noirDpsSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);

		// Ennemi Noir Mage
		ActionCombat noirMageAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat noirMageDefense1 = new ActionCombat(incrementId(), "Bouclier perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat noirMageDefense2 = new ActionCombat(incrementId(), "Regen Mana perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, null);
		ActionCombat noirMageSort1 = new ActionCombat(incrementId(), "Absorption Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, null);
		ActionCombat noirMageSort2 = new ActionCombat(incrementId(), "Absorption Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, null);
		ActionCombat noirMageSort3 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO, null);
		ActionCombat noirMageSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MULTI, null);
		ActionCombat noirMageSpecial2 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.STUN_MULTI, null);

		// Ennemi Noir Barde
		ActionCombat noirBardeAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat noirBardeDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.BOUCLIER_MULTI, null);
		ActionCombat noirBardeSort1 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.REGEN_MANA_MULTI, null);
		ActionCombat noirBardeSort2 = new ActionCombat(incrementId(), "Absorption Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.ABSORPTION_VIE_MULTI, null);
		ActionCombat noirBardeSort3 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.REGEN_VIE_MONO, null);
		ActionCombat noirBardeSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.TAUNT_MULTI, null);
		ActionCombat noirBardeSpecial2 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.RESURRECTION_MONO, null);

		// Handicapes
		
		// Ennemi Handicape Tank
		ActionCombat handicapeTankAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat handicapeTankDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.ENDURANCE, SortType.ESQUIVE, null);
		ActionCombat handicapeTankDefense2 = new ActionCombat(incrementId(), "Bouclier Perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.RESISTANCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat handicapeTankSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.NERVOSITE, SortType.STUN_MONO, null);
		ActionCombat handicapeTankSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.NERVOSITE, SortType.TAUNT_MULTI, null);

		// Ennemi Handicape Healer
		ActionCombat handicapeHealerAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat handicapeHealerDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.BOUCLIER_MULTI, null);
		ActionCombat handicapeHealerSort1 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MONO, null);
		ActionCombat handicapeHealerSort2 = new ActionCombat(incrementId(), "Regen Mana Mono", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_MONO, null);
		ActionCombat handicapeHealerSort3 = new ActionCombat(incrementId(), "Resurection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MONO, null);
		ActionCombat handicapeHealerSpecial1 = new ActionCombat(incrementId(), "Regen Vie Multi", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.REGEN_VIE_MULTI, null);
		ActionCombat handicapeHealerSpecial2 = new ActionCombat(incrementId(), "Resurrection Multi", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ALLIES, PersoStat.INTELLIGENCE, SortType.RESURRECTION_MULTI, null);

		// Ennemi Handicape DPS
		ActionCombat handicapeDpsAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat handicapeDpsAttaque2= new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);
		ActionCombat handicapeDpsDefense1 = new ActionCombat(incrementId(), "Esquive", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.EXPLOIT, SortType.ESQUIVE, null);
		ActionCombat handicapeDpsSort1 = new ActionCombat(incrementId(), "Stun Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.EXPLOIT, SortType.STUN_MONO, null);
		ActionCombat handicapeDpsSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.EXPLOIT, SortType.DEGATS_MULTI, null);

		// Ennemi Handicape Mage
		ActionCombat handicapeMageAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat handicapeMageDefense1 = new ActionCombat(incrementId(), "Bouclier perso", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.BOUCLIER_PERSO, null);
		ActionCombat handicapeMageDefense2 = new ActionCombat(incrementId(), "Regen Mana perso", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.PERSO, PersoStat.INTELLIGENCE, SortType.REGEN_MANA_PERSO, null);
		ActionCombat handicapeMageSort1 = new ActionCombat(incrementId(), "Absorption Mana Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_MANA_MONO, null);
		ActionCombat handicapeMageSort2 = new ActionCombat(incrementId(), "Absorption Vie Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.ABSORPTION_VIE_MONO, null);
		ActionCombat handicapeMageSort3 = new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ENNEMI, PersoStat.INTELLIGENCE, SortType.DEGATS_MONO, null);
		ActionCombat handicapeMageSpecial1 = new ActionCombat(incrementId(), "Degats Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.DEGATS_MULTI, null);
		ActionCombat handicapeMageSpecial2 = new ActionCombat(incrementId(), "Stun Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.INTELLIGENCE, SortType.STUN_MULTI, null);

		// Ennemi Handicape Barde
		ActionCombat handicapeBardeAttaque1= new ActionCombat(incrementId(), "Degats Mono", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.ATTAQUE, EnergieType.RIEN, CibleType.ENNEMI, PersoStat.TECHNIQUE, SortType.DEGATS_MONO, null);
		ActionCombat handicapeBardeDefense1 = new ActionCombat(incrementId(), "Bouclier Multi", "abc", imagePaths, sonBouclier, sonBouclierCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.DEFENSE, EnergieType.CHARGE, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.BOUCLIER_MULTI, null);
		ActionCombat handicapeBardeSort1 = new ActionCombat(incrementId(), "Regen Mana Multi", "abc", imagePaths, sonRegenMana, sonRegenManaCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ALLIES, PersoStat.LUCK, SortType.REGEN_MANA_MULTI, null);
		ActionCombat handicapeBardeSort2 = new ActionCombat(incrementId(), "Absorption Vie Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.ABSORPTION_VIE_MULTI, null);
		ActionCombat handicapeBardeSort3 = new ActionCombat(incrementId(), "Regen Vie Mono", "abc", imagePaths, sonRegenVie, sonRegenVieCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.POUVOIR, EnergieType.MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.REGEN_VIE_MONO, null);
		ActionCombat handicapeBardeSpecial1 = new ActionCombat(incrementId(), "Taunt Multi", "abc", imagePaths, sonAttaque, sonAttaqueCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.GROUPE_ENNEMIS, PersoStat.LUCK, SortType.TAUNT_MULTI, null);
		ActionCombat handicapeBardeSpecial2 = new ActionCombat(incrementId(), "Resurrection Mono", "abc", imagePaths, sonREZ, sonREZCritique, videoPaths, disponible, niveauSort, niveauMaxSort, progression, ActionCombatType.SPECIAL, EnergieType.CHARGE_ET_MANA, CibleType.ALLIE, PersoStat.LUCK, SortType.RESURRECTION_MONO, null);
		

		List<ActionCombat> johannActions = new ArrayList<ActionCombat>();
		List<ActionCombat> nicolasActions = new ArrayList<ActionCombat>();
		List<ActionCombat> pierreActions = new ArrayList<ActionCombat>();
		List<ActionCombat> thomasActions = new ArrayList<ActionCombat>();
		List<ActionCombat> yannickActions = new ArrayList<ActionCombat>();
		List<ActionCombat> guillaumeActions = new ArrayList<ActionCombat>();
		List<ActionCombat> aliActions = new ArrayList<ActionCombat>();
		List<ActionCombat> jonathanActions = new ArrayList<ActionCombat>();
		
		List<ActionCombat> boss1Actions = new ArrayList<ActionCombat>();
		List<ActionCombat> boss2Actions = new ArrayList<ActionCombat>();
		List<ActionCombat> boss3Actions = new ArrayList<ActionCombat>();
		List<ActionCombat> boss4Actions = new ArrayList<ActionCombat>();
		List<ActionCombat> boss5Actions = new ArrayList<ActionCombat>();
		List<ActionCombat> boss6Actions = new ArrayList<ActionCombat>();
		List<ActionCombat> boss7Actions = new ArrayList<ActionCombat>();
		List<ActionCombat> boss8Actions = new ArrayList<ActionCombat>();
		
		List<ActionCombat> gitanTankActions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanHealerActions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanDpsActions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanMageActions = new ArrayList<ActionCombat>();
		List<ActionCombat> gitanBardeActions = new ArrayList<ActionCombat>();
		
		List<ActionCombat> arabeTankActions = new ArrayList<ActionCombat>();
		List<ActionCombat> arabeHealerActions = new ArrayList<ActionCombat>();
		List<ActionCombat> arabeDpsActions = new ArrayList<ActionCombat>();
		List<ActionCombat> arabeMageActions = new ArrayList<ActionCombat>();
		List<ActionCombat> arabeBardeActions = new ArrayList<ActionCombat>();
		
		List<ActionCombat> noirTankActions = new ArrayList<ActionCombat>();
		List<ActionCombat> noirHealerActions = new ArrayList<ActionCombat>();
		List<ActionCombat> noirDpsActions = new ArrayList<ActionCombat>();
		List<ActionCombat> noirMageActions = new ArrayList<ActionCombat>();
		List<ActionCombat> noirBardeActions = new ArrayList<ActionCombat>();
		
		List<ActionCombat> handicapeTankActions = new ArrayList<ActionCombat>();
		List<ActionCombat> handicapeHealerActions = new ArrayList<ActionCombat>();
		List<ActionCombat> handicapeDpsActions = new ArrayList<ActionCombat>();
		List<ActionCombat> handicapeMageActions = new ArrayList<ActionCombat>();
		List<ActionCombat> handicapeBardeActions = new ArrayList<ActionCombat>();
		
		johannActions.add(johannAttaque1);
//		johannActions.add(johannAttaque2);
//		johannActions.add(johannDefense1);
		johannActions.add(johannDefense2);
		johannActions.add(johannDefense3);
//		johannActions.add(johannDefense4);
//		johannActions.add(johannDefense5);
//		johannActions.add(johannDefense6);
		johannActions.add(johannDefense7);
		johannActions.add(johannDefense8);
		johannActions.add(johannSort1);
//		johannActions.add(johannSort2);
//		johannActions.add(johannSort3);
//		johannActions.add(johannSort4);
//		johannActions.add(johannSort5);
//		johannActions.add(johannSort6);
//		johannActions.add(johannSort7);
//		johannActions.add(johannSort8);
		johannActions.add(johannSort9);
//		johannActions.add(johannSort10);
//		johannActions.add(johannSort11);
//		johannActions.add(johannSort12);
//		johannActions.add(johannSort13);
//		johannActions.add(johannSort14);
		johannActions.add(johannSort15);
//		johannActions.add(johannSort16);
		johannActions.add(johannSort17);
//		johannActions.add(johannSort18);
		johannActions.add(johannSpecial1);
//		johannActions.add(johannSpecial2);
		
		nicolasActions.add(nicolasAttaque1);
		nicolasActions.add(nicolasAttaque2);
//		nicolasActions.add(nicolasDefense1);
		nicolasActions.add(nicolasDefense2);
//		nicolasActions.add(nicolasDefense3);
//		nicolasActions.add(nicolasDefense4);
//		nicolasActions.add(nicolasDefense5);
//		nicolasActions.add(nicolasDefense6);
		nicolasActions.add(nicolasDefense7);
		nicolasActions.add(nicolasDefense8);
		nicolasActions.add(nicolasSort1);
//		nicolasActions.add(nicolasSort2);
//		nicolasActions.add(nicolasSort3);
		nicolasActions.add(nicolasSort4);
//		nicolasActions.add(nicolasSort5);
//		nicolasActions.add(nicolasSort6);
//		nicolasActions.add(nicolasSort7);
//		nicolasActions.add(nicolasSort8);
//		nicolasActions.add(nicolasSort9);
//		nicolasActions.add(nicolasSort10);
		nicolasActions.add(nicolasSort11);
//		nicolasActions.add(nicolasSort12);
//		nicolasActions.add(nicolasSort13);
//		nicolasActions.add(nicolasSort14);
//		nicolasActions.add(nicolasSort15);
//		nicolasActions.add(nicolasSort16);
//		nicolasActions.add(nicolasSort17);
		nicolasActions.add(nicolasSort18);
		nicolasActions.add(nicolasSpecial1);
//		nicolasActions.add(nicolasSpecial2);

		thomasActions.add(thomasAttaque1);
//		thomasActions.add(thomasAttaque2);
//		thomasActions.add(thomasDefense1);
		thomasActions.add(thomasDefense2);
//		thomasActions.add(thomasDefense3);
//		thomasActions.add(thomasDefense4);
//		thomasActions.add(thomasDefense5);
//		thomasActions.add(thomasDefense6);
		thomasActions.add(thomasDefense7);
//		thomasActions.add(thomasDefense8);
		thomasActions.add(thomasSort1);
//		thomasActions.add(thomasSort2);
		thomasActions.add(thomasSort3);
//		thomasActions.add(thomasSort4);
		thomasActions.add(thomasSort5);
//		thomasActions.add(thomasSort6);
//		thomasActions.add(thomasSort7);
//		thomasActions.add(thomasSort8);
//		thomasActions.add(thomasSort9);
//		thomasActions.add(thomasSort10);
		thomasActions.add(thomasSort11);
//		thomasActions.add(thomasSort12);
		thomasActions.add(thomasSort13);
		thomasActions.add(thomasSort14);
//		thomasActions.add(thomasSort15);
//		thomasActions.add(thomasSort16);
//		thomasActions.add(thomasSort17);
//		thomasActions.add(thomasSort18);
		thomasActions.add(thomasSpecial1);
//		thomasActions.add(thomasSpecial2);
		
		pierreActions.add(pierreAttaque1);
		pierreActions.add(pierreAttaque2);
//		pierreActions.add(pierreDefense1);
//		pierreActions.add(pierreDefense2);
		pierreActions.add(pierreDefense3);
		pierreActions.add(pierreDefense4);
//		pierreActions.add(pierreDefense5);
//		pierreActions.add(pierreDefense6);
		pierreActions.add(pierreDefense7);
//		pierreActions.add(pierreDefense8);
//		pierreActions.add(pierreSort1);
//		pierreActions.add(pierreSort2);
//		pierreActions.add(pierreSort3);
		pierreActions.add(pierreSort4);
//		pierreActions.add(pierreSort5);
//		pierreActions.add(pierreSort6);
//		pierreActions.add(pierreSort7);
		pierreActions.add(pierreSort8);
//		pierreActions.add(pierreSort9);
//		pierreActions.add(pierreSort10);
//		pierreActions.add(pierreSort11);
//		pierreActions.add(pierreSort12);
		pierreActions.add(pierreSort13);
//		pierreActions.add(pierreSort14);
//		pierreActions.add(pierreSort15);
		pierreActions.add(pierreSort16);
//		pierreActions.add(pierreSort17);
//		pierreActions.add(pierreSort18);
		pierreActions.add(pierreSpecial1);
//		pierreActions.add(pierreSpecial2);
		
		yannickActions.add(yannickAttaque1);
//		yannickActions.add(yannickAttaque2);
//		yannickActions.add(yannickDefense1);
		yannickActions.add(yannickDefense2);
//		yannickActions.add(yannickDefense3);
		yannickActions.add(yannickDefense4);
//		yannickActions.add(yannickDefense5);
		yannickActions.add(yannickDefense6);
		yannickActions.add(yannickDefense7);
//		yannickActions.add(yannickDefense8);
//		yannickActions.add(yannickSort1);
//		yannickActions.add(yannickSort2);
//		yannickActions.add(yannickSort3);
//		yannickActions.add(yannickSort4);
//		yannickActions.add(yannickSort5);
//		yannickActions.add(yannickSort6);
//		yannickActions.add(yannickSort7);
//		yannickActions.add(yannickSort8);
		yannickActions.add(yannickSort9);
//		yannickActions.add(yannickSort10);
//		yannickActions.add(yannickSort11);
		yannickActions.add(yannickSort12);
//		yannickActions.add(yannickSort13);
//		yannickActions.add(yannickSort14);
//		yannickActions.add(yannickSort15);
		yannickActions.add(yannickSort16);
//		yannickActions.add(yannickSort17);
		yannickActions.add(yannickSort18);
		yannickActions.add(yannickSpecial1);
//		yannickActions.add(yannickSpecial2);
		
		aliActions.add(aliAttaque1);
//		aliActions.add(aliAttaque2);
//		aliActions.add(aliDefense1);
		aliActions.add(aliDefense2);
//		aliActions.add(aliDefense3);
//		aliActions.add(aliDefense4);
//		aliActions.add(aliDefense5);
//		aliActions.add(aliDefense6);
		aliActions.add(aliDefense7);
		aliActions.add(aliDefense8);
		aliActions.add(aliSort1);
//		aliActions.add(aliSort2);
//		aliActions.add(aliSort3);
//		aliActions.add(aliSort4);
//		aliActions.add(aliSort5);
//		aliActions.add(aliSort6);
//		aliActions.add(aliSort7);
//		aliActions.add(aliSort8);
//		aliActions.add(aliSort9);
//		aliActions.add(aliSort10);
//		aliActions.add(aliSort11);
		aliActions.add(aliSort12);
		aliActions.add(aliSort13);
//		aliActions.add(aliSort14);
//		aliActions.add(aliSort15);
		aliActions.add(aliSort16);
		aliActions.add(aliSort17);
//		aliActions.add(aliSort18);
		aliActions.add(aliSpecial1);
//		aliActions.add(aliSpecial2);
		
		guillaumeActions.add(guillaumeAttaque1);
//		guillaumeActions.add(guillaumeAttaque2);
//		guillaumeActions.add(guillaumeDefense1);
		guillaumeActions.add(guillaumeDefense2);
		guillaumeActions.add(guillaumeDefense3);
//		guillaumeActions.add(guillaumeDefense4);
//		guillaumeActions.add(guillaumeDefense5);
//		guillaumeActions.add(guillaumeDefense6);
		guillaumeActions.add(guillaumeDefense7);
//		guillaumeActions.add(guillaumeDefense8);
		guillaumeActions.add(guillaumeSort1);
//		guillaumeActions.add(guillaumeSort2);
//		guillaumeActions.add(guillaumeSort3);
		guillaumeActions.add(guillaumeSort4);
//		guillaumeActions.add(guillaumeSort5);
		guillaumeActions.add(guillaumeSort6);
//		guillaumeActions.add(guillaumeSort7);
//		guillaumeActions.add(guillaumeSort8);
//		guillaumeActions.add(guillaumeSort9);
		guillaumeActions.add(guillaumeSort10);
//		guillaumeActions.add(guillaumeSort11);
//		guillaumeActions.add(guillaumeSort12);
//		guillaumeActions.add(guillaumeSort13);
//		guillaumeActions.add(guillaumeSort14);
//		guillaumeActions.add(guillaumeSort15);
//		guillaumeActions.add(guillaumeSort16);
//		guillaumeActions.add(guillaumeSort17);
		guillaumeActions.add(guillaumeSort18);
		guillaumeActions.add(guillaumeSpecial1);
//		guillaumeActions.add(guillaumeSpecial2);
		
		jonathanActions.add(jonathanAttaque1);
//		jonathanActions.add(jonathanAttaque2);
//		jonathanActions.add(jonathanDefense1);
		jonathanActions.add(jonathanDefense2);
//		jonathanActions.add(jonathanDefense3);
//		jonathanActions.add(jonathanDefense4);
//		jonathanActions.add(jonathanDefense5);
//		jonathanActions.add(jonathanDefense6);
		jonathanActions.add(jonathanDefense7);
		jonathanActions.add(jonathanDefense8);
//		jonathanActions.add(jonathanSort1);
//		jonathanActions.add(jonathanSort2);
//		jonathanActions.add(jonathanSort3);
//		jonathanActions.add(jonathanSort4);
//		jonathanActions.add(jonathanSort5);
		jonathanActions.add(jonathanSort6);
//		jonathanActions.add(jonathanSort7);
//		jonathanActions.add(jonathanSort8);
//		jonathanActions.add(jonathanSort9);
//		jonathanActions.add(jonathanSort10);
//		jonathanActions.add(jonathanSort11);
		jonathanActions.add(jonathanSort12);
//		jonathanActions.add(jonathanSort13);
//		jonathanActions.add(jonathanSort14);
//		jonathanActions.add(jonathanSort15);
		jonathanActions.add(jonathanSort16);
		jonathanActions.add(jonathanSort17);
		jonathanActions.add(jonathanSort18);
//		jonathanActions.add(jonathanSpecial1);
		jonathanActions.add(jonathanSpecial2);
		
		boss1Actions.add(boss1Attaque1);
		boss1Actions.add(boss1Attaque2);
		boss1Actions.add(boss1Defense7);
		boss1Actions.add(boss1Special1);
		
		boss2Actions.add(boss2Attaque1);
		boss2Actions.add(boss2Attaque2);
		boss2Actions.add(boss2Defense7);
		boss2Actions.add(boss2Special1);
		
		boss3Actions.add(boss3Attaque1);
		boss3Actions.add(boss3Attaque2);
		boss3Actions.add(boss3Defense7);
		boss3Actions.add(boss3Special1);
		
		boss4Actions.add(boss4Attaque1);
		boss4Actions.add(boss4Attaque2);
		boss4Actions.add(boss4Defense7);
		boss4Actions.add(boss4Special1);
		
		boss5Actions.add(boss5Attaque1);
		boss5Actions.add(boss5Attaque2);
		boss5Actions.add(boss5Defense7);
		boss5Actions.add(boss5Special1);
		
		boss6Actions.add(boss6Attaque1);
		boss6Actions.add(boss6Attaque2);
		boss6Actions.add(boss6Defense7);
		boss6Actions.add(boss6Special1);
		
		boss7Actions.add(boss7Attaque1);
		boss7Actions.add(boss7Attaque2);
		boss7Actions.add(boss7Defense7);
		boss7Actions.add(boss7Special1);
		
		boss8Actions.add(boss8Attaque1);
		boss8Actions.add(boss8Attaque2);
		boss8Actions.add(boss8Defense7);
		boss8Actions.add(boss8Special1);

		gitanTankActions.add(gitanTankAttaque1);
		gitanTankActions.add(gitanTankDefense1);
		gitanTankActions.add(gitanTankDefense2);
		gitanTankActions.add(gitanTankSort1);
		gitanTankActions.add(gitanTankSpecial1);

		gitanHealerActions.add(gitanHealerAttaque1);
		gitanHealerActions.add(gitanHealerDefense1);
		gitanHealerActions.add(gitanHealerSort1);
		gitanHealerActions.add(gitanHealerSort2);
		gitanHealerActions.add(gitanHealerSort3);
		gitanHealerActions.add(gitanHealerSpecial1);
		gitanHealerActions.add(gitanHealerSpecial2);
		
		gitanDpsActions.add(gitanDpsAttaque1);
		gitanDpsActions.add(gitanDpsAttaque2);
		gitanDpsActions.add(gitanDpsDefense1);
		gitanDpsActions.add(gitanDpsSort1);
		gitanDpsActions.add(gitanDpsSpecial1);
		
		gitanMageActions.add(gitanMageAttaque1);
		gitanMageActions.add(gitanMageDefense1);
		gitanMageActions.add(gitanMageDefense2);
		gitanMageActions.add(gitanMageSort1);
		gitanMageActions.add(gitanMageSort2);
		gitanMageActions.add(gitanMageSort3);
		gitanMageActions.add(gitanMageSpecial1);
		gitanMageActions.add(gitanMageSpecial2);
		
		gitanBardeActions.add(gitanBardeAttaque1);
		gitanBardeActions.add(gitanBardeDefense1);
		gitanBardeActions.add(gitanBardeSort1);
		gitanBardeActions.add(gitanBardeSort2);
		gitanBardeActions.add(gitanBardeSort3);
		gitanBardeActions.add(gitanBardeSpecial1);
		gitanBardeActions.add(gitanBardeSpecial2);
		
		arabeTankActions.add(arabeTankAttaque1);
		arabeTankActions.add(arabeTankDefense1);
		arabeTankActions.add(arabeTankDefense2);
		arabeTankActions.add(arabeTankSort1);
		arabeTankActions.add(arabeTankSpecial1);

		arabeHealerActions.add(arabeHealerAttaque1);
		arabeHealerActions.add(arabeHealerDefense1);
		arabeHealerActions.add(arabeHealerSort1);
		arabeHealerActions.add(arabeHealerSort2);
		arabeHealerActions.add(arabeHealerSort3);
		arabeHealerActions.add(arabeHealerSpecial1);
		arabeHealerActions.add(arabeHealerSpecial2);
		
		arabeDpsActions.add(arabeDpsAttaque1);
		arabeDpsActions.add(arabeDpsAttaque2);
		arabeDpsActions.add(arabeDpsDefense1);
		arabeDpsActions.add(arabeDpsSort1);
		arabeDpsActions.add(arabeDpsSpecial1);
		
		arabeMageActions.add(arabeMageAttaque1);
		arabeMageActions.add(arabeMageDefense1);
		arabeMageActions.add(arabeMageDefense2);
		arabeMageActions.add(arabeMageSort1);
		arabeMageActions.add(arabeMageSort2);
		arabeMageActions.add(arabeMageSort3);
		arabeMageActions.add(arabeMageSpecial1);
		arabeMageActions.add(arabeMageSpecial2);
		
		arabeBardeActions.add(arabeBardeAttaque1);
		arabeBardeActions.add(arabeBardeDefense1);
		arabeBardeActions.add(arabeBardeSort1);
		arabeBardeActions.add(arabeBardeSort2);
		arabeBardeActions.add(arabeBardeSort3);
		arabeBardeActions.add(arabeBardeSpecial1);
		arabeBardeActions.add(arabeBardeSpecial2);
		
		noirTankActions.add(noirTankAttaque1);
		noirTankActions.add(noirTankDefense1);
		noirTankActions.add(noirTankDefense2);
		noirTankActions.add(noirTankSort1);
		noirTankActions.add(noirTankSpecial1);

		noirHealerActions.add(noirHealerAttaque1);
		noirHealerActions.add(noirHealerDefense1);
		noirHealerActions.add(noirHealerSort1);
		noirHealerActions.add(noirHealerSort2);
		noirHealerActions.add(noirHealerSort3);
		noirHealerActions.add(noirHealerSpecial1);
		noirHealerActions.add(noirHealerSpecial2);
		
		noirDpsActions.add(noirDpsAttaque1);
		noirDpsActions.add(noirDpsAttaque2);
		noirDpsActions.add(noirDpsDefense1);
		noirDpsActions.add(noirDpsSort1);
		noirDpsActions.add(noirDpsSpecial1);
		
		noirMageActions.add(noirMageAttaque1);
		noirMageActions.add(noirMageDefense1);
		noirMageActions.add(noirMageDefense2);
		noirMageActions.add(noirMageSort1);
		noirMageActions.add(noirMageSort2);
		noirMageActions.add(noirMageSort3);
		noirMageActions.add(noirMageSpecial1);
		noirMageActions.add(noirMageSpecial2);
		
		noirBardeActions.add(noirBardeAttaque1);
		noirBardeActions.add(noirBardeDefense1);
		noirBardeActions.add(noirBardeSort1);
		noirBardeActions.add(noirBardeSort2);
		noirBardeActions.add(noirBardeSort3);
		noirBardeActions.add(noirBardeSpecial1);
		noirBardeActions.add(noirBardeSpecial2);
		
		handicapeTankActions.add(handicapeTankAttaque1);
		handicapeTankActions.add(handicapeTankDefense1);
		handicapeTankActions.add(handicapeTankDefense2);
		handicapeTankActions.add(handicapeTankSort1);
		handicapeTankActions.add(handicapeTankSpecial1);

		handicapeHealerActions.add(handicapeHealerAttaque1);
		handicapeHealerActions.add(handicapeHealerDefense1);
		handicapeHealerActions.add(handicapeHealerSort1);
		handicapeHealerActions.add(handicapeHealerSort2);
		handicapeHealerActions.add(handicapeHealerSort3);
		handicapeHealerActions.add(handicapeHealerSpecial1);
		handicapeHealerActions.add(handicapeHealerSpecial2);
		
		handicapeDpsActions.add(handicapeDpsAttaque1);
		handicapeDpsActions.add(handicapeDpsAttaque2);
		handicapeDpsActions.add(handicapeDpsDefense1);
		handicapeDpsActions.add(handicapeDpsSort1);
		handicapeDpsActions.add(handicapeDpsSpecial1);
		
		handicapeMageActions.add(handicapeMageAttaque1);
		handicapeMageActions.add(handicapeMageDefense1);
		handicapeMageActions.add(handicapeMageDefense2);
		handicapeMageActions.add(handicapeMageSort1);
		handicapeMageActions.add(handicapeMageSort2);
		handicapeMageActions.add(handicapeMageSort3);
		handicapeMageActions.add(handicapeMageSpecial1);
		handicapeMageActions.add(handicapeMageSpecial2);
		
		handicapeBardeActions.add(handicapeBardeAttaque1);
		handicapeBardeActions.add(handicapeBardeDefense1);
		handicapeBardeActions.add(handicapeBardeSort1);
		handicapeBardeActions.add(handicapeBardeSort2);
		handicapeBardeActions.add(handicapeBardeSort3);
		handicapeBardeActions.add(handicapeBardeSpecial1);
		handicapeBardeActions.add(handicapeBardeSpecial2);
		
		actionsByPerso.put(PersoPrenom.Johann.name(), johannActions);
		actionsByPerso.put(PersoPrenom.Nicolas.name(), nicolasActions);
		actionsByPerso.put(PersoPrenom.Pierre.name(), pierreActions);
		actionsByPerso.put(PersoPrenom.Thomas.name(), thomasActions);
		actionsByPerso.put(PersoPrenom.Yannick.name(), yannickActions);
		actionsByPerso.put(PersoPrenom.Guillaume.name(), guillaumeActions);
		actionsByPerso.put(PersoPrenom.Ali.name(), aliActions);
		actionsByPerso.put(PersoPrenom.Jonathan.name(), jonathanActions);
		
		actionsByPerso.put(BossNom.BOSS1.name(), boss1Actions);
		actionsByPerso.put(BossNom.BOSS2.name(), boss2Actions);
		actionsByPerso.put(BossNom.BOSS3.name(), boss3Actions);
		actionsByPerso.put(BossNom.BOSS4.name(), boss4Actions);
		actionsByPerso.put(BossNom.BOSS5.name(), boss5Actions);
		actionsByPerso.put(BossNom.BOSS6.name(), boss6Actions);
		actionsByPerso.put(BossNom.BOSS7.name(), boss7Actions);
		actionsByPerso.put(BossNom.BOSS8.name(), boss8Actions);
		
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.TANK.name(), gitanTankActions);
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.HEALER.name(), gitanHealerActions);
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.DPS.name(), gitanDpsActions);
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.MAGE.name(), gitanMageActions);
		actionsByPerso.put(EnnemiType.GITANS.name() + PersoClasse.BARDE.name(), gitanBardeActions);
		
		actionsByPerso.put(EnnemiType.ARABES.name() + PersoClasse.TANK.name(), arabeTankActions);
		actionsByPerso.put(EnnemiType.ARABES.name() + PersoClasse.HEALER.name(), arabeHealerActions);
		actionsByPerso.put(EnnemiType.ARABES.name() + PersoClasse.DPS.name(), arabeDpsActions);
		actionsByPerso.put(EnnemiType.ARABES.name() + PersoClasse.MAGE.name(), arabeMageActions);
		actionsByPerso.put(EnnemiType.ARABES.name() + PersoClasse.BARDE.name(), arabeBardeActions);
		
		actionsByPerso.put(EnnemiType.NOIRS.name() + PersoClasse.TANK.name(), noirTankActions);
		actionsByPerso.put(EnnemiType.NOIRS.name() + PersoClasse.HEALER.name(), noirHealerActions);
		actionsByPerso.put(EnnemiType.NOIRS.name() + PersoClasse.DPS.name(), noirDpsActions);
		actionsByPerso.put(EnnemiType.NOIRS.name() + PersoClasse.MAGE.name(), noirMageActions);
		actionsByPerso.put(EnnemiType.NOIRS.name() + PersoClasse.BARDE.name(), noirBardeActions);
		
		actionsByPerso.put(EnnemiType.HANDICAPES.name() + PersoClasse.TANK.name(), handicapeTankActions);
		actionsByPerso.put(EnnemiType.HANDICAPES.name() + PersoClasse.HEALER.name(), handicapeHealerActions);
		actionsByPerso.put(EnnemiType.HANDICAPES.name() + PersoClasse.DPS.name(), handicapeDpsActions);
		actionsByPerso.put(EnnemiType.HANDICAPES.name() + PersoClasse.MAGE.name(), handicapeMageActions);
		actionsByPerso.put(EnnemiType.HANDICAPES.name() + PersoClasse.BARDE.name(), handicapeBardeActions);
	}

	public List<ActionCombat> getActionsCombat(String personnageNom) {
		return actionsByPerso.get(personnageNom);
	}
	
	private int incrementId() {
		id = id +1;
		return id;
	}

	public List<ActionCombat> getActionsCombatPersosPrincipaux() {
		List<ActionCombat> actions = new ArrayList<ActionCombat>();
		// Prenoms des personnages principaux
		 PersoPrenom[] prenoms = PersoPrenom.values();
		 for (PersoPrenom prenom : prenoms) {
			if (prenom != PersoPrenom.GROUPE) {
				List<ActionCombat> actionsParPerso = actionsByPerso.get(prenom.name());
				if (actionsParPerso != null) {
					actions.addAll(actionsParPerso);
				}
			}
		}
		return actions;
	}

	public ActionCombat getActionById(int i) {
		Collection<List<ActionCombat>> allActions = actionsByPerso.values();
		for (List<ActionCombat> actions : allActions) {
			for (ActionCombat actionCombat : actions) {
				if (actionCombat.getId() == i) {
					return actionCombat;
				}
			}
		}
		System.out.println("Aucune actionCombat avec cet identifiant : " + i);
		return null;
	}

}
