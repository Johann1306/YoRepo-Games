package core;

import java.awt.Color;
import java.awt.Component;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import front.MainFrame;
import front.MenuPrincipal;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.arme.Arme;
import modele.item.arme.ArmeClasse;
import modele.item.arme.ArmeType;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.Personnage;
import modele.item.personnage.PersonnageEnnemi;
import modele.item.personnage.PersonnagePrincipal;

public class ItemManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Item itemSelectionne;
	private List<Item> items;
	private List<Item> itemsDisponibles;
	private List<Item> itemsIndisponibles;
	private static int id = 10000;

	public void initialise() {

		items = new ArrayList<Item>();
		itemsDisponibles = new ArrayList<Item>();
		itemsIndisponibles = new ArrayList<Item>();

		// Chargement des items
		
		// Images
		List<String> imagePathsPopoVie = new ArrayList<String>();
		String imagePathPopoVie = "image/item/consommable/popoVie.jpg";
		imagePathsPopoVie.add(imagePathPopoVie);

		List<String> imagePathsPopoMana = new ArrayList<String>();
		String imagePathPopoMana = "image/item/consommable/popoMana.jpg";
		imagePathsPopoMana.add(imagePathPopoMana);
		
		List<String> imagePathsBonus = new ArrayList<String>();
		String imagePathBonus = "image/item/consommable/popoBonus.jpg";
		imagePathsBonus.add(imagePathBonus);
		
		
		List<String> imagePathsdiehard3VHS = new ArrayList<String>();
		String imagePathVHS = "image/film/diehard3_VHS.jpg";
		imagePathsdiehard3VHS.add(imagePathVHS);
		
		
		List<String> imagePathsCles = new ArrayList<String>();
		String imagePathCles = "image/item/quete/cles.png";
		imagePathsCles.add(imagePathCles);
		
		List<String> imagePathsGraisse = new ArrayList<String>();
		String imagePathGraisse = "image/item/quete/graisseATraire.jpg";
		imagePathsGraisse.add(imagePathGraisse);
		
		
		// TODO changer les images par defaut
		List<String> imagePaths1 = new ArrayList<String>();
		String imagePath1 = "image/mp3Player/stop.png";
		imagePaths1.add(imagePath1);

		List<String> imagePaths2 = new ArrayList<String>();
		String imagePath2 = "image/mp3Player/pause.png";
		imagePaths2.add(imagePath2);

		List<String> imagePaths3 = new ArrayList<String>();
		String imagePath3 = "image/mp3Player/back.png";
		imagePaths3.add(imagePath3);
		

		// Images Armes
		List<String> imagePaths500 = new ArrayList<String>();
		String imagePath500 = "image/arme/kleenex.jpg";
		imagePaths500.add(imagePath500);
		
		List<String> imagePaths501 = new ArrayList<String>();
		String imagePath501 = "image/arme/patate.jpg";
		imagePaths501.add(imagePath501);
		
		List<String> imagePaths502 = new ArrayList<String>();
		String imagePath502 = "image/arme/mousqueton.jpg";
		imagePaths502.add(imagePath502);
		
		List<String> imagePaths503 = new ArrayList<String>();
		String imagePath503 = "image/arme/couteauPapillon.jpg";
		imagePaths503.add(imagePath503);
		
		List<String> imagePaths504 = new ArrayList<String>();
		String imagePath504 = "image/arme/epeeBois.jpg";
		imagePaths504.add(imagePath504);
		
		List<String> imagePaths505 = new ArrayList<String>();
		String imagePath505 = "image/arme/sabreLaser.jpg";
		imagePaths505.add(imagePath505);
		
		List<String> imagePaths506 = new ArrayList<String>();
		String imagePath506 = "image/arme/ballon.jpg";
		imagePaths506.add(imagePath506);
		
		List<String> imagePaths507 = new ArrayList<String>();
		String imagePath507 = "image/arme/fusil.jpg";
		imagePaths507.add(imagePath507);
		
		List<String> imagePaths508 = new ArrayList<String>();
		String imagePath508 = "image/arme/ventoline.jpg";
		imagePaths508.add(imagePath508);

		List<String> imagePaths509 = new ArrayList<String>();
		String imagePath509 = "image/arme/oeufs.jpg";
		imagePaths509.add(imagePath509);
		
		List<String> imagePaths510 = new ArrayList<String>();
		String imagePath510 = "image/arme/grappin.jpg";
		imagePaths510.add(imagePath510);
		
		List<String> imagePaths511 = new ArrayList<String>();
		String imagePath511 = "image/arme/selPoivre.jpg";
		imagePaths511.add(imagePath511);
		
		List<String> imagePaths512 = new ArrayList<String>();
		String imagePath512 = "image/arme/cigarette.jpg";
		imagePaths512.add(imagePath512);
		
		List<String> imagePaths513 = new ArrayList<String>();
		String imagePath513 = "image/arme/epices.jpg";
		imagePaths513.add(imagePath513);
		
		List<String> imagePaths514 = new ArrayList<String>();
		String imagePath514 = "image/arme/micro.jpg";
		imagePaths514.add(imagePath514);
		
		List<String> imagePaths515 = new ArrayList<String>();
		String imagePath515 = "image/arme/verre.jpg";
		imagePaths515.add(imagePath515);
		
		List<String> imagePaths516 = new ArrayList<String>();
		String imagePath516 = "image/arme/bouteille.jpg";
		imagePaths516.add(imagePath516);
		
		List<String> imagePaths517 = new ArrayList<String>();
		String imagePath517 = "image/arme/bescherelle.jpg";
		imagePaths517.add(imagePath517);
		
		List<String> imagePaths518 = new ArrayList<String>();
		String imagePath518 = "image/arme/creme.jpg";
		imagePaths518.add(imagePath518);
		
		List<String> imagePaths519 = new ArrayList<String>();
		String imagePath519 = "image/arme/pasteque.jpg";
		imagePaths519.add(imagePath519);
		
		List<String> imagePaths520 = new ArrayList<String>();
		String imagePath520 = "image/arme/tampon.jpg";
		imagePaths520.add(imagePath520);
		
		List<String> imagePaths521 = new ArrayList<String>();
		String imagePath521 = "image/arme/rasoir.jpg";
		imagePaths521.add(imagePath521);
		
		List<String> imagePaths522 = new ArrayList<String>();
		String imagePath522 = "image/arme/plug.jpg";
		imagePaths522.add(imagePath522);
		
		List<String> imagePaths523 = new ArrayList<String>();
		String imagePath523 = "image/arme/glacon.jpg";
		imagePaths523.add(imagePath523);
		
		List<String> imagePaths524 = new ArrayList<String>();
		String imagePath524 = "image/arme/bananes.jpg";
		imagePaths524.add(imagePath524);
		
		List<String> imagePaths525 = new ArrayList<String>();
		String imagePath525 = "image/arme/guitare.jpg";
		imagePaths525.add(imagePath525);
		
		List<String> imagePaths526 = new ArrayList<String>();
		String imagePath526 = "image/arme/dent.jpg";
		imagePaths526.add(imagePath526);
		
		List<String> imagePaths527 = new ArrayList<String>();
		String imagePath527 = "image/arme/dictaphone.jpg";
		imagePaths527.add(imagePath527);
		
		List<String> imagePaths528 = new ArrayList<String>();
		String imagePath528 = "image/arme/walkman.jpg";
		imagePaths528.add(imagePath528);
		
		List<String> imagePaths529 = new ArrayList<String>();
		String imagePath529 = "image/arme/ciseau.jpg";
		imagePaths529.add(imagePath529);
		
		List<String> imagePaths530 = new ArrayList<String>();
		String imagePath530 = "image/arme/rhum.jpg";
		imagePaths530.add(imagePath530);
		
		List<String> imagePaths531 = new ArrayList<String>();
		String imagePath531 = "image/arme/pq.jpg";
		imagePaths531.add(imagePath531);
		
		List<String> imagePaths532 = new ArrayList<String>();
		String imagePath532 = "image/arme/steroides.jpg";
		imagePaths532.add(imagePath532);
		
		List<String> imagePaths533 = new ArrayList<String>();
		String imagePath533 = "image/arme/nuggets.jpg";
		imagePaths533.add(imagePath533);
		
		List<String> imagePaths534 = new ArrayList<String>();
		String imagePath534 = "image/arme/pistoletEau.jpg";
		imagePaths534.add(imagePath534);
		
		List<String> imagePaths535 = new ArrayList<String>();
		String imagePath535 = "image/arme/reveil.jpg";
		imagePaths535.add(imagePath535);
		
		List<String> imagePaths536 = new ArrayList<String>();
		String imagePath536 = "image/arme/trefle.jpg";
		imagePaths536.add(imagePath536);
		
		List<String> imagePaths537 = new ArrayList<String>();
		String imagePath537 = "image/arme/baguettePain.jpg";
		imagePaths537.add(imagePath537);
		
		List<String> imagePaths538 = new ArrayList<String>();
		String imagePath538 = "image/arme/coton.jpg";
		imagePaths538.add(imagePath538);
		
		List<String> imagePaths539 = new ArrayList<String>();
		String imagePath539 = "image/arme/pansement.jpg";
		imagePaths539.add(imagePath539);

		List<String> imagePaths540 = new ArrayList<String>();
		String imagePath540 = "image/arme/svastika.jpg";
		imagePaths540.add(imagePath540);
		
		
		List<String> imagePaths550 = new ArrayList<String>();
		String imagePath550 = "image/arme/cagette.jpg";
		imagePaths550.add(imagePath550);

		List<String> imagePaths551 = new ArrayList<String>();
		String imagePath551 = "image/arme/gazeuse.jpg";
		imagePaths551.add(imagePath551);

		List<String> imagePaths552 = new ArrayList<String>();
		String imagePath552 = "image/arme/taser.jpg";
		imagePaths552.add(imagePath552);

		List<String> imagePaths553 = new ArrayList<String>();
		String imagePath553 = "image/arme/bouteilleCassee.jpg";
		imagePaths553.add(imagePath553);

		List<String> imagePaths554 = new ArrayList<String>();
		String imagePath554 = "image/arme/bouteillePuante.jpg";
		imagePaths554.add(imagePath554);

		List<String> imagePaths555 = new ArrayList<String>();
		String imagePath555 = "image/arme/bouleBowling.jpg";
		imagePaths555.add(imagePath555);

		List<String> imagePaths556 = new ArrayList<String>();
		String imagePath556 = "image/arme/batteBaseball.jpg";
		imagePaths556.add(imagePath556);

		List<String> imagePaths557 = new ArrayList<String>();
		String imagePath557 = "image/arme/poingAmericain.jpg";
		imagePaths557.add(imagePath557);

		List<String> imagePaths558 = new ArrayList<String>();
		String imagePath558 = "image/arme/raquetteTennis.jpg";
		imagePaths558.add(imagePath558);

		List<String> imagePaths559 = new ArrayList<String>();
		String imagePath559 = "image/arme/baton.jpg";
		imagePaths559.add(imagePath559);

		List<String> imagePaths560 = new ArrayList<String>();
		String imagePath560 = "image/arme/javelot.jpg";
		imagePaths560.add(imagePath560);

		List<String> imagePaths561 = new ArrayList<String>();
		String imagePath561 = "image/arme/barreFer.jpg";
		imagePaths561.add(imagePath561);

		List<String> imagePaths562 = new ArrayList<String>();
		String imagePath562 = "image/arme/marteau.jpg";
		imagePaths562.add(imagePath562);

		List<String> imagePaths563 = new ArrayList<String>();
		String imagePath563 = "image/arme/pelle.jpg";
		imagePaths563.add(imagePath563);

		List<String> imagePaths564 = new ArrayList<String>();
		String imagePath564 = "image/arme/couteau.jpg";
		imagePaths564.add(imagePath564);

		List<String> imagePaths565 = new ArrayList<String>();
		String imagePath565 = "image/arme/epee.jpg";
		imagePaths565.add(imagePath565);

		List<String> imagePaths566 = new ArrayList<String>();
		String imagePath566 = "image/arme/sabre.jpg";
		imagePaths566.add(imagePath566);

		List<String> imagePaths567 = new ArrayList<String>();
		String imagePath567 = "image/arme/arc.jpg";
		imagePaths567.add(imagePath567);

		List<String> imagePaths568 = new ArrayList<String>();
		String imagePath568 = "image/arme/arbalete.jpg";
		imagePaths568.add(imagePath568);

		List<String> imagePaths569 = new ArrayList<String>();
		String imagePath569 = "image/arme/carabinePlomb.jpg";
		imagePaths569.add(imagePath569);

		List<String> imagePaths570 = new ArrayList<String>();
		String imagePath570 = "image/arme/revolver.jpg";
		imagePaths570.add(imagePath570);

		List<String> imagePaths571 = new ArrayList<String>();
		String imagePath571 = "image/arme/pistolet.jpg";
		imagePaths571.add(imagePath571);

		List<String> imagePaths572 = new ArrayList<String>();
		String imagePath572 = "image/arme/pistoletLacrymo.jpg";
		imagePaths572.add(imagePath572);

		List<String> imagePaths573 = new ArrayList<String>();
		String imagePath573 = "image/arme/pistoletBille.jpg";
		imagePaths573.add(imagePath573);

		List<String> imagePaths574 = new ArrayList<String>();
		String imagePath574 = "image/arme/pistoletLaser.jpg";
		imagePaths574.add(imagePath574);

		List<String> imagePaths575 = new ArrayList<String>();
		String imagePath575 = "image/arme/fusilPompe.jpg";
		imagePaths575.add(imagePath575);

		List<String> imagePaths576 = new ArrayList<String>();
		String imagePath576 = "image/arme/fusilHomme.jpg";
		imagePaths576.add(imagePath576);

		List<String> imagePaths577 = new ArrayList<String>();
		String imagePath577 = "image/arme/fusilFemme.jpg";
		imagePaths577.add(imagePath577);

		List<String> imagePaths578 = new ArrayList<String>();
		String imagePath578 = "image/arme/sulfateuse.jpg";
		imagePaths578.add(imagePath578);

		List<String> imagePaths579 = new ArrayList<String>();
		String imagePath579 = "image/arme/sniper.jpg";
		imagePaths579.add(imagePath579);

		List<String> imagePaths580 = new ArrayList<String>();
		String imagePath580 = "image/arme/bazooka.jpg";
		imagePaths580.add(imagePath580);

		List<String> imagePaths581 = new ArrayList<String>();
		String imagePath581 = "image/arme/ceintureExplosive.jpg";
		imagePaths581.add(imagePath581);

		List<String> imagePaths582 = new ArrayList<String>();
		String imagePath582 = "image/arme/grenade.jpg";
		imagePaths582.add(imagePath582);

		List<String> imagePaths583 = new ArrayList<String>();
		String imagePath583 = "image/arme/lanceGrenade.jpg";
		imagePaths583.add(imagePath583);

		List<String> imagePaths584 = new ArrayList<String>();
		String imagePath584 = "image/arme/lanceRoquette.jpg";
		imagePaths584.add(imagePath584);

		List<String> imagePaths585 = new ArrayList<String>();
		String imagePath585 = "image/arme/god.jpg";
		imagePaths585.add(imagePath585);

		
		
		List<String> imagePaths1001 = new ArrayList<String>();
		String imagePath1001 = "image/item/boss/ballon_dor.jpg";
		imagePaths1001.add(imagePath1001);

		List<String> imagePaths1002 = new ArrayList<String>();
		String imagePath1002 = "image/item/boss/grappin_dor.jpg";
		imagePaths1002.add(imagePath1002);
		
		List<String> imagePaths1003 = new ArrayList<String>();
		String imagePath1003 = "image/item/boss/medaille_dor.png";
		imagePaths1003.add(imagePath1003);
		
		List<String> imagePaths1004 = new ArrayList<String>();
		String imagePath1004 = "image/item/boss/mouchoir_dor.jpg";
		imagePaths1004.add(imagePath1004);
		
		List<String> imagePaths1005 = new ArrayList<String>();
		String imagePath1005 = "image/item/boss/sabre_dor.png";
		imagePaths1005.add(imagePath1005);
		
		List<String> imagePaths1006 = new ArrayList<String>();
		String imagePath1006 = "image/item/boss/micro_dor.jpg";
		imagePaths1006.add(imagePath1006);
		
		List<String> imagePaths1007 = new ArrayList<String>();
		String imagePath1007 = "image/item/boss/coupe_dor.jpg";
		imagePaths1007.add(imagePath1007);
		
		List<String> imagePaths1008 = new ArrayList<String>();
		String imagePath1008 = "image/item/boss/palme_dor.jpg";
		imagePaths1008.add(imagePath1008);
		
		
		
		// Sons
		List<String> sonPathsManger1 = new ArrayList<String>();
		String sonPathManger1 = "sonParDefaut/manger1.mp3";
		sonPathsManger1.add(sonPathManger1);
		
		List<String> sonPathsdiehard3 = new ArrayList<String>();
		String sonPathdiehard3 = "son/film/diehard3.mp3";
		sonPathsdiehard3.add(sonPathdiehard3);
		
		List<String> sonPathsBoire1 = new ArrayList<String>();
		String sonPathBoire1 = "sonParDefaut/manger2.mp3";
		sonPathsBoire1.add(sonPathBoire1);
		
		
		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "sonParDefaut/inception.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<String>();
		String sonPath2 = "sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);
		
		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "video/Trololo.mp4";
		videoPaths1.add(videoPath1);
		
		// Videos
		List<String> videoPathsNull = null;

		// Consommables Combat
		
		// Popo : vie/mana
		Item popoVie25   = new Item(100, "Potion de vie (25%)",   "Redonne 25% des points de vie", imagePathsPopoVie, sonPathsManger1, null, PersoPrenom.GROUPE, ItemType.POTION_VIE_25, false);
		Item popoVie50   = new Item(101, "Potion de vie (50%)",   "Redonne 50% des points de vie", imagePathsPopoVie, sonPathsManger1, null, PersoPrenom.GROUPE, ItemType.POTION_VIE_50, false);
		Item popoVie75   = new Item(102, "Potion de vie (75%)",   "Redonne 75% des points de vie", imagePathsPopoVie, sonPathsManger1, null, PersoPrenom.GROUPE, ItemType.POTION_VIE_75, false);
		Item popoVie100  = new Item(103, "Potion de vie (100%)",  "Redonne 100% des points de vie", imagePathsPopoVie, sonPathsManger1, null, PersoPrenom.GROUPE, ItemType.POTION_VIE_100, false);
		Item popoMana25  = new Item(200, "Potion de mana (25%)",  "Redonne 25% des points de mana", imagePathsPopoMana, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.POTION_MANA_25, false);
		Item popoMana50  = new Item(201, "Potion de mana (50%)",  "Redonne 50% des points de mana", imagePathsPopoMana, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.POTION_MANA_50, false);
		Item popoMana75  = new Item(202, "Potion de mana (75%)",  "Redonne 75% des points de mana", imagePathsPopoMana, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.POTION_MANA_75, false);
		Item popoMana100 = new Item(203, "Potion de mana (100%)", "Redonne 100% des points de mana", imagePathsPopoMana, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.POTION_MANA_100, false);
		
		// Bonus competences (+5, +10, +20)
		Item bonusChance5 = 	   new Item(300, "Bonus de chance (+5)", "Gagne 5 de Chance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_CHANCE_5, false);
		Item bonusChance10 =       new Item(301, "Bonus de chance (+10)", "Gagne 10 de Chance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_CHANCE_10, false);
		Item bonusChance20 =       new Item(302, "Bonus de chance (+20)", "Gagne 20 de Chance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_CHANCE_20, false);
		Item bonusExploit5 =       new Item(303, "Bonus d'exploit (+5)", "Gagne 5 d'Exploit de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_EXPLOIT_5, false);
		Item bonusExploit10 =      new Item(304, "Bonus d'exploit (+10)", "Gagne 10 d'Exploit de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_EXPLOIT_10, false);
		Item bonusExploit20 =      new Item(305, "Bonus d'exploit (+20)", "Gagne 20 d'Exploit de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_EXPLOIT_20, false);
		Item bonusTechnique5 =     new Item(306, "Bonus de technique (+5)", "Gagne 5 de Technique de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_TECHNIQUE_5, false);
		Item bonusTechnique10 =    new Item(307, "Bonus de technique (+10)", "Gagne 10 de Technique de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_TECHNIQUE_10, false);
		Item bonusTechnique20 =    new Item(308, "Bonus de technique (+20)", "Gagne 20 de Technique de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_TECHNIQUE_20, false);
		Item bonusEndurance5 =     new Item(309, "Bonus d'endurance (+5)", "Gagne 5 d'Endurance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_ENDURANCE_5, false);
		Item bonusEndurance10 =    new Item(310, "Bonus d'endurance (+10)", "Gagne 10 d'Endurance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_ENDURANCE_10, false);
		Item bonusEndurance20 =    new Item(311, "Bonus d'endurance (+20)", "Gagne 20 d'Endurance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_ENDURANCE_20, false);
		Item bonusRapidite5 =      new Item(312, "Bonus de rapidité (+5)", "Gagne 5 de Rapidité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RAPIDITE_5, false);
		Item bonusRapidite10 =     new Item(313, "Bonus de rapidité (+10)", "Gagne 10 de Rapidité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RAPIDITE_10, false);
		Item bonusRapidite20 =     new Item(314, "Bonus de rapidité (+20)", "Gagne 20 de Rapidité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RAPIDITE_20, false);
		Item bonusResistance5 =    new Item(315, "Bonus de resistance (+5)", "Gagne 5 de Resistance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RESISTANCE_5, false);
		Item bonusResistance10 =   new Item(316, "Bonus de resistance (+10)", "Gagne 10 de Resistance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RESISTANCE_10, false);
		Item bonusResistance20 =   new Item(317, "Bonus de resistance (+20)", "Gagne 20 de Resistance de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RESISTANCE_20, false);
		Item bonusAgilite5 =       new Item(318, "Bonus d'agilité (+5)", "Gagne 5 d'Agilité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_AGILITE_5, false);
		Item bonusAgilite10 = 	   new Item(319, "Bonus d'agilité (+10)", "Gagne 10 d'Agilité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_AGILITE_10, false);
		Item bonusAgilite20 = 	   new Item(320, "Bonus d'agilité (+20)", "Gagne 20 d'Agilité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_AGILITE_20, false);
		Item bonusIntelligence5 =  new Item(321, "Bonus d'intelligence (+5)", "Gagne 5 d'Intelligence de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_INTELLIGENCE_5, false);
		Item bonusIntelligence10 = new Item(322, "Bonus d'intelligence (+10)", "Gagne 10 d'Intelligence de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_INTELLIGENCE_10, false);
		Item bonusIntelligence20 = new Item(323, "Bonus d'intelligence (+20)", "Gagne 20 d'Intelligence de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_INTELLIGENCE_20, false);
		Item bonusNervosite5 = 	   new Item(324, "Bonus de nervosité (+5)", "Gagne 5 de Nervosité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_NERVOSITE_5, false);
		Item bonusNervosite10 =    new Item(325, "Bonus de nervosité (+10)", "Gagne 10 de Nervosité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_NERVOSITE_10, false);
		Item bonusNervosite20 =    new Item(326, "Bonus de nervosité (+20)", "Gagne 20 de Nervosité de manière permanente", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_NERVOSITE_20, false);

		// Objets de quete (pas d'utilisation)
		Item cleTerrain = new Item(400, "Les Clés du terrain", "info2", imagePathsCles, sonPaths1, null, PersoPrenom.Johann, ItemType.OBJET_QUETE, false);
		Item graisse = new Item(401, ConfigurationManager.getProperties("item.jonathan.401.nom"), ConfigurationManager.getProperties("item.jonathan.401.inf"), imagePathsGraisse, sonPaths1, null, PersoPrenom.Jonathan, ItemType.OBJET_QUETE, false);
		
		// Films
		Item VHS_diehard3 = new Item(600, "VHS - Die Hard 3", "", imagePathsdiehard3VHS, sonPathsdiehard3, null, PersoPrenom.GROUPE, ItemType.FILM, false);
		
		// Objets evenements
		
		// TODO sons des armes (plusieurs sons aleatoires par arme)
		// TODO arme de groupe
		// TODO info des armes
		
		// ARMES PAR PERSO
		Arme mouchoir = new Arme(500, "Paquet de Mouchoir", "", imagePaths500, sonPaths1, videoPathsNull, PersoPrenom.Thomas, 0, 0, ArmeType.MOUCHOIR, ArmeClasse.GRIS, PersoStat.INTELLIGENCE, false);
		Arme patate = new Arme(501, "Patates", "", imagePaths501, sonPaths1, videoPathsNull, PersoPrenom.Thomas, 0, 0, ArmeType.PATATE, ArmeClasse.GRIS, PersoStat.INTELLIGENCE, false);
		Arme tampon = new Arme(520, "Tampon", "", imagePaths520, sonPaths1, videoPathsNull, PersoPrenom.Thomas, 0, 0, ArmeType.TAMPON, ArmeClasse.GRIS, PersoStat.INTELLIGENCE, false);
		Arme coton = new Arme(538, "Coton", "", imagePaths538, sonPaths1, videoPathsNull, PersoPrenom.Thomas, 0, 0, ArmeType.COTON, ArmeClasse.GRIS, PersoStat.INTELLIGENCE, false);
		Arme pansement = new Arme(539, "Pansement", "", imagePaths539, sonPaths1, videoPathsNull, PersoPrenom.Thomas, 0, 0, ArmeType.PANSEMENT, ArmeClasse.GRIS, PersoStat.INTELLIGENCE, false);
		Arme croix = new Arme(540, "Svastika", "", imagePaths540, sonPaths1, videoPathsNull, PersoPrenom.Thomas, 0, 0, ArmeType.CROIX, ArmeClasse.GRIS, PersoStat.INTELLIGENCE, false);
			
		Arme mousqueton = new Arme(502, "Mousqueton poing americain", "", imagePaths502, sonPaths1, videoPathsNull, PersoPrenom.Yannick, 0, 0, ArmeType.MOUSQUETON, ArmeClasse.GRIS, PersoStat.RESISTANCE, false);
		Arme couteauPapillon = new Arme(503, "Couteau papillon", "", imagePaths503, sonPaths1, videoPathsNull, PersoPrenom.Yannick, 0, 0, ArmeType.COUTEAU_PAPILLON, ArmeClasse.GRIS, PersoStat.RESISTANCE, false);
		Arme epeeBois = new Arme(504, "Epée en bois", "Fait maison", imagePaths504, sonPaths1, videoPathsNull, PersoPrenom.Yannick, 0, 0, ArmeType.EPEE_EN_BOIS, ArmeClasse.GRIS, PersoStat.RESISTANCE, false);
		Arme sabreLaser = new Arme(505, "Sabre laser", "", imagePaths505, sonPaths1, videoPathsNull, PersoPrenom.Yannick, 0, 0, ArmeType.SABRE_LASER, ArmeClasse.GRIS, PersoStat.RESISTANCE, false);
		Arme banane = new Arme(524, "Bananes", "", imagePaths524, sonPaths1, videoPathsNull, PersoPrenom.Yannick, 0, 0, ArmeType.BANANE, ArmeClasse.GRIS, PersoStat.RESISTANCE, false);
		Arme guitare = new Arme(525, "Guitare", "", imagePaths525, sonPaths1, videoPathsNull, PersoPrenom.Yannick, 0, 0, ArmeType.GUITARE, ArmeClasse.GRIS, PersoStat.RESISTANCE, false);
		
		Arme ballon = new Arme(506, "Ballon de foot", "La balle molle", imagePaths506, sonPaths1, videoPathsNull, PersoPrenom.Johann, 0, 0, ArmeType.BALLON, ArmeClasse.GRIS, PersoStat.LUCK, false);
		Arme fusil = new Arme(507, "Fusil de chasse", "", imagePaths507, sonPaths1, videoPathsNull, PersoPrenom.Johann, 0, 0, ArmeType.FUSIL, ArmeClasse.GRIS, PersoStat.LUCK, false);
		Arme pistoletAEau = new Arme(534, "Pissstolet à eau", "", imagePaths534, sonPaths1, videoPathsNull, PersoPrenom.Johann, 0, 0, ArmeType.PISTOLET_A_EAU, ArmeClasse.GRIS, PersoStat.LUCK, false);
		Arme reveil = new Arme(535, "Réveil midi", "", imagePaths535, sonPaths1, videoPathsNull, PersoPrenom.Johann, 0, 0, ArmeType.REVEIL, ArmeClasse.GRIS, PersoStat.LUCK, false);
		Arme trefle = new Arme(536, "Trèfle à 4 feuilles", "", imagePaths536, sonPaths1, videoPathsNull, PersoPrenom.Johann, 0, 0, ArmeType.TREFLE, ArmeClasse.GRIS, PersoStat.LUCK, false);
		Arme pain = new Arme(537, "Baguette de pain", "Le pain c'est la vie", imagePaths537, sonPaths1, videoPathsNull, PersoPrenom.Johann, 0, 0, ArmeType.PAIN, ArmeClasse.GRIS, PersoStat.LUCK, false);

		Arme ventoline = new Arme(508, "Ventoline", "", imagePaths508, sonPaths1, videoPathsNull, PersoPrenom.Pierre, 0, 0, ArmeType.VENTOLINE, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		Arme oeufs = new Arme(509, "Oeufs pourris", "", imagePaths509, sonPaths1, videoPathsNull, PersoPrenom.Pierre, 0, 0, ArmeType.OEUFS, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		Arme dent = new Arme(526, "Dent", "", imagePaths526, sonPaths1, videoPathsNull, PersoPrenom.Pierre, 0, 0, ArmeType.DENT, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		Arme dictaphone = new Arme(527, "Dictaphone", "", imagePaths527, sonPaths1, videoPathsNull, PersoPrenom.Pierre, 0, 0, ArmeType.DICTAPHONE, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		Arme walkman = new Arme(528, "Walkman", "", imagePaths528, sonPaths1, videoPathsNull, PersoPrenom.Pierre, 0, 0, ArmeType.WALKMAN, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		Arme ciseau = new Arme(529, "Paire de ciseau", "", imagePaths529, sonPaths1, videoPathsNull, PersoPrenom.Pierre, 0, 0, ArmeType.CISEAU, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		Arme rhum = new Arme(530, "Bouteille de Rhum", "Le rhum de l'enculé de Pierre", imagePaths530, sonPaths1, videoPathsNull, PersoPrenom.Pierre, 0, 0, ArmeType.RHUM, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		
		Arme grappin = new Arme(510, "Grappin", "", imagePaths510, sonPaths1, videoPathsNull, PersoPrenom.Nicolas, 0, 0, ArmeType.GRAPPIN, ArmeClasse.GRIS, PersoStat.EXPLOIT, false);
		Arme selPoivre = new Arme(511, "Sel et Poivre", "", imagePaths511, sonPaths1, videoPathsNull, PersoPrenom.Nicolas, 0, 0, ArmeType.SEL_ET_POIVRE, ArmeClasse.GRIS, PersoStat.EXPLOIT, false);
		Arme pq = new Arme(531, "Rouleau de PQ", "", imagePaths531, sonPaths1, videoPathsNull, PersoPrenom.Nicolas, 0, 0, ArmeType.PQ, ArmeClasse.GRIS, PersoStat.EXPLOIT, false);
		Arme steroide = new Arme(532, "Stéroïdes", "", imagePaths532, sonPaths1, videoPathsNull, PersoPrenom.Nicolas, 0, 0, ArmeType.STEROIDE, ArmeClasse.GRIS, PersoStat.EXPLOIT, false);
		Arme nuggets = new Arme(533, "Nuggets", "", imagePaths533, sonPaths1, videoPathsNull, PersoPrenom.Nicolas, 0, 0, ArmeType.NUGGETS, ArmeClasse.GRIS, PersoStat.EXPLOIT, false);
		
		Arme paquet = new Arme(512, "Paquet de Kingston vide", "La cigarette des Rois (Garder un paquet de clope vide, c'est comme garder un preservatif usagé)", imagePaths512, sonPaths1, videoPathsNull, PersoPrenom.Ali, 0, 0, ArmeType.PAQUET_CLOPE, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		Arme epices = new Arme(513, "Sachet d'épices", "", imagePaths513, sonPaths1, videoPathsNull, PersoPrenom.Ali, 0, 0, ArmeType.EPICES, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		Arme micro = new Arme(514, "Microphone", "", imagePaths514, sonPaths1, videoPathsNull, PersoPrenom.Ali, 0, 0, ArmeType.MICRO, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		Arme plug = new Arme(522, "Plug", "", imagePaths522, sonPaths1, videoPathsNull, PersoPrenom.Ali, 0, 0, ArmeType.PLUG, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		Arme glacon = new Arme(523, "Glaçon", "", imagePaths523, sonPaths1, videoPathsNull, PersoPrenom.Ali, 0, 0, ArmeType.GLACON, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);

		Arme verre = new Arme(515, "Verre vide", "", imagePaths515, sonPaths1, videoPathsNull, PersoPrenom.Guillaume, 0, 0, ArmeType.VERRE, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme bouteille = new Arme(516, "Bouteille vide", "", imagePaths516, sonPaths1, videoPathsNull, PersoPrenom.Guillaume, 0, 0, ArmeType.BOUTEILLE, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme bescherelle = new Arme(517, "Bescherelle", "", imagePaths517, sonPaths1, videoPathsNull, PersoPrenom.Guillaume, 0, 0, ArmeType.BESCHERELLE, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		
		Arme creme = new Arme(518, "Creme", "", imagePaths518, sonPaths1, videoPathsNull, PersoPrenom.Jonathan, 0, 0, ArmeType.CREME, ArmeClasse.GRIS, PersoStat.ENDURANCE, false);
		Arme pasteque = new Arme(519, "Pasteque", "", imagePaths519, sonPaths1, videoPathsNull, PersoPrenom.Jonathan, 0, 0, ArmeType.PASTEQUE, ArmeClasse.GRIS, PersoStat.NERVOSITE, false);
		Arme rasoir = new Arme(521, "Rasoir", "", imagePaths521, sonPaths1, videoPathsNull, PersoPrenom.Jonathan, 0, 0, ArmeType.RASOIR, ArmeClasse.GRIS, PersoStat.ENDURANCE, false);



		// ARMES DE GROUPE
		Arme cagette = new Arme(550, "Cagette", "", imagePaths550, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.CAGETTE, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		Arme gazeuse = new Arme(551, "Gazeuse", "", imagePaths551, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.GAZEUSE, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		Arme taser = new Arme(552, "Taser", "", imagePaths552, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.TASER, ArmeClasse.GRIS, PersoStat.NERVOSITE, false);
		// Disponible des le debut pour les ennemis
		Arme bouteilleCassee = new Arme(553, "Bouteille cassée", "", imagePaths553, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.BOUTEILLE_CASSEE, ArmeClasse.GRIS, PersoStat.TECHNIQUE, true);
		Arme bouteillePuante = new Arme(554, "Bouteille puante", "", imagePaths554, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.BOUTEILLE_QUI_PUE, ArmeClasse.GRIS, PersoStat.AGILITE, false);
		Arme bouleBowling = new Arme(555, "Boule de Bowling", "", imagePaths555, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.BOULE_DE_BOWLING, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		// Disponible des le debut pour les ennemis
		Arme batte = new Arme(556, "Batte de Baseball", "", imagePaths556, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.BATTE_DE_BASEBALL, ArmeClasse.GRIS, PersoStat.NERVOSITE, true);
		// Disponible des le debut pour les ennemis
		Arme poingAmericain = new Arme(557, "Poing Americain", "", imagePaths557, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.POING_AMERICAIN, ArmeClasse.GRIS, PersoStat.RESISTANCE, true);
		Arme raquette = new Arme(558, "Raquette de Tennis", "", imagePaths558, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.RAQUETTE_TENNIS, ArmeClasse.GRIS, PersoStat.LUCK, false);
		// Disponible des le debut pour les ennemis
		Arme baton = new Arme(559, "Baton", "", imagePaths559, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.BATON, ArmeClasse.GRIS, PersoStat.EXPLOIT, true);
		Arme javelot = new Arme(560, "Javelot", "", imagePaths560, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.JAVELOT, ArmeClasse.GRIS, PersoStat.LUCK, false);
		// Disponible des le debut pour les ennemis
		Arme barreDeFer = new Arme(561, "Barre de Fer", "", imagePaths561, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.BARRE_DE_FER, ArmeClasse.GRIS, PersoStat.INTELLIGENCE, true);
		Arme marteau = new Arme(562, "Marteau", "", imagePaths562, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.MARTEAU, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		// Disponible des le debut pour les ennemis
		Arme pelle = new Arme(563, "Pelle", "", imagePaths563, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.PELLE, ArmeClasse.GRIS, PersoStat.ENDURANCE, true);
		Arme couteau = new Arme(564, "Couteau", "", imagePaths564, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.COUTEAU, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme epee = new Arme(565, "Epée", "", imagePaths565, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.EPEE, ArmeClasse.GRIS, PersoStat.RESISTANCE, false);
		Arme sabre = new Arme(566, "Sabre", "", imagePaths566, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.SABRE, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		Arme arc = new Arme(567, "Arc", "", imagePaths567, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.ARC, ArmeClasse.GRIS, PersoStat.LUCK, false);
		Arme arbalete = new Arme(568, "Arbalète", "", imagePaths568, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.ARBALETE, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme carabine = new Arme(569, "Carabine", "", imagePaths569, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.CARABINE_A_PLOMB, ArmeClasse.GRIS, PersoStat.RESISTANCE, false);
		Arme revolver = new Arme(570, "Revolver", "", imagePaths570, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.REVOLVER, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme pistolet = new Arme(571, "Pistolet", "", imagePaths571, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.PISTOLET, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme pistoletLacrymo = new Arme(572, "Pistolet Lacrymo", "Ne pas utiliser en intérieur", imagePaths572, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.PISTOLET_LACRYMO, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		Arme pistoletBille = new Arme(573, "Flingue à Bille", "", imagePaths573, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.PISTOLET_A_BILLE, ArmeClasse.GRIS, PersoStat.LUCK, false);
		Arme pistoletLaser = new Arme(574, "Pistolet Laser", "", imagePaths574, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.PISTOLET_LASER, ArmeClasse.GRIS, PersoStat.EXPLOIT, false);
		Arme fusilPompe = new Arme(575, "Fusil à Pompe", "", imagePaths575, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.FUSIL_A_POMPE, ArmeClasse.GRIS, PersoStat.ENDURANCE, false);
		Arme fusilHomme = new Arme(576, "Fusil Homme", "", imagePaths576, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.FUSIL_QUI_PARLE_HOMME_KINGPIN, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme fusilFemme = new Arme(577, "Fusil Femme", "", imagePaths577, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.FUSIL_QUI_PARLE_FEMME_CHAUDE, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme mitraillette = new Arme(578, "Sulfateuse", "", imagePaths578, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.MITRAILLETTE, ArmeClasse.GRIS, PersoStat.ENDURANCE, false);
		Arme sniper = new Arme(579, "Sniper", "", imagePaths579, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.SNIPER, ArmeClasse.GRIS, PersoStat.INTELLIGENCE, false);
		Arme bazooka = new Arme(580, "Bazooka", "Fatal", imagePaths580, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.BAZOOKA, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme ceinture = new Arme(581, "Ceinture Explosive", "Je ne suis pas Charlie", imagePaths581, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.CEINTURE_EXPLOSIF, ArmeClasse.GRIS, PersoStat.EXPLOIT, false);
		Arme grenade = new Arme(582, "Grenade", "Creuveeeeeeez", imagePaths582, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.GRENADE, ArmeClasse.GRIS, PersoStat.EXPLOIT, false);
		Arme lanceGrenade = new Arme(583, "Lance Grenade", "", imagePaths583, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.LANCE_GRENADE, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme lanceRoquette = new Arme(584, "Lance Roquette", "", imagePaths584, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.LANCE_ROQUETTE, ArmeClasse.GRIS, PersoStat.TECHNIQUE, false);
		Arme god = new Arme(585, "God montguichet", "", imagePaths585, sonPaths1, videoPathsNull, PersoPrenom.GROUPE, 0, 0, ArmeType.GOD, ArmeClasse.GRIS, PersoStat.RAPIDITE, false);
		
		// Equipements
		
		// Objets sort (REZ, damage, casse bouclier)
		
		// Objets de quete
		// Cartes
		// Billes
		// Vetements
		// Argent
		// Consommables (Boissons, Barres, Bonbons, ...)
		// CDs, cassettes, vyniles, VHS, 
		
		// Collections (Cartes (dbz, panini foot), billes, pogs, pins, jouets (puce rebondissante, ressort multicolore, jeu video pocket, avions en papier,) 
		// TODO Donner les cartes en tant que recompenses de missions
		// TODO Faire les rapports entre la carte et le joueur (Jo = Popovich)
		Item carteDBZ1 = new Item(901, "Carte DBZ n°1", "Carte de San Goku",  imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ2 = new Item(902, "Carte DBZ n°2", "Carte de San Gohan", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ3 = new Item(903, "Carte DBZ n°3", "Carte de Krilin",    imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ4 = new Item(904, "Carte DBZ n°4", "Carte de Yamcha",    imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ5 = new Item(905, "Carte DBZ n°5", "Carte de Picolo",    imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ6 = new Item(906, "Carte DBZ n°6", "Carte de Vegeta",    imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ7 = new Item(907, "Carte DBZ n°7", "Carte de Cell",      imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ8 = new Item(908, "Carte DBZ n°8", "Carte de Spopovich", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		
		Item carteCrados1 = new Item(911, "Carte Crados n°1", "Carte de Johann", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_CRADOS, false);
		Item carteCrados2 = new Item(912, "Carte Crados n°2", "Carte de Nicolas", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_CRADOS, false);
		Item carteCrados3 = new Item(913, "Carte Crados n°3", "Carte de Pierre", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_CRADOS, false);
		Item carteCrados4 = new Item(914, "Carte Crados n°4", "Carte de Yannick", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_CRADOS, false);
		Item carteCrados5 = new Item(915, "Carte Crados n°5", "Carte de Thomas", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_CRADOS, false);
		Item carteCrados6 = new Item(916, "Carte Crados n°6", "Carte de Ali", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_CRADOS, false);
		Item carteCrados7 = new Item(917, "Carte Crados n°7", "Carte de Guillaume", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_CRADOS, false);
		Item carteCrados8 = new Item(918, "Carte Crados n°8", "Carte de Jonathan", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_CRADOS, false);
		
		// Recompenses de BOSS
		// TODO infos recompenses de BOSS marrantes
		Item ballon_dor 	= new Item(1001, "Le Ballon d'Or", "Bonus Chance", imagePaths1001, sonPaths1, videoPaths1, PersoPrenom.Johann, ItemType.OBJET_QUETE, false);
		Item grappin_dor 	= new Item(1002, "Le Grappin d'Or", "Bonus Exploit", imagePaths1002, sonPaths1, videoPaths1, PersoPrenom.Nicolas, ItemType.OBJET_QUETE, false);
		Item medaille_dor 	= new Item(1003, "La Médaille d'Or", "Bonus Agilité", imagePaths1003, sonPaths1, videoPaths1, PersoPrenom.Pierre, ItemType.OBJET_QUETE, false);
		Item mouchoir_dor 	= new Item(1004, "Le Mouchoir d'Or", "Bonus Intelligence", imagePaths1004, sonPaths1, videoPaths1, PersoPrenom.Thomas, ItemType.OBJET_QUETE, false);
		Item sabre_dor 		= new Item(1005, "Le Sabre d'Or", "Bonus Resistance", imagePaths1005, sonPaths1, videoPaths1, PersoPrenom.Yannick, ItemType.OBJET_QUETE, false);
		Item micro_dor 		= new Item(1006, "Le Micro d'Or", "Bonus Vitesse", imagePaths1006, sonPaths1, videoPaths1, PersoPrenom.Ali, ItemType.OBJET_QUETE, false);
		Item coupe_dor		= new Item(1007, "La Coupe d'Or", "Bonus Technique", imagePaths1007, sonPaths1, videoPaths1, PersoPrenom.Guillaume, ItemType.OBJET_QUETE, false);
		Item palme_dor		= new Item(1008, "La Palme d'Or", "Bonus Endurance", imagePaths1008, sonPaths1, videoPaths1, PersoPrenom.Jonathan, ItemType.OBJET_QUETE, false);
	
		items.add(ballon_dor);
		items.add(grappin_dor);
		items.add(medaille_dor);
		items.add(mouchoir_dor);
		items.add(sabre_dor);
		items.add(micro_dor);
		items.add(coupe_dor);
		items.add(palme_dor);
		
		// Ajout a la liste
		items.add(popoVie25);
		items.add(popoVie50);
		items.add(popoVie75);
		items.add(popoVie100);
		items.add(popoMana25);
		items.add(popoMana50);
		items.add(popoMana75);
		items.add(popoMana100);
		items.add(bonusChance5);
		items.add(bonusChance10);
		items.add(bonusChance20);
		items.add(bonusExploit5);
		items.add(bonusExploit10);
		items.add(bonusExploit20);
		items.add(bonusTechnique5);
		items.add(bonusTechnique10);
		items.add(bonusTechnique20);
		items.add(bonusEndurance5);
		items.add(bonusEndurance10);
		items.add(bonusEndurance20);
		items.add(bonusRapidite5);
		items.add(bonusRapidite10);
		items.add(bonusRapidite20);
		items.add(bonusResistance5);
		items.add(bonusResistance10);
		items.add(bonusResistance20);
		items.add(bonusAgilite5);
		items.add(bonusAgilite10);
		items.add(bonusAgilite20);
		items.add(bonusIntelligence5);
		items.add(bonusIntelligence10);
		items.add(bonusIntelligence20);
		items.add(bonusNervosite5);
		items.add(bonusNervosite10);
		items.add(bonusNervosite20);
		
		items.add(cleTerrain);
		items.add(graisse);
		items.add(VHS_diehard3);
		
		items.add(mouchoir);
		items.add(patate);
		items.add(tampon);
		items.add(mousqueton);
		items.add(couteauPapillon);
		items.add(epeeBois);
		items.add(sabreLaser);
		items.add(ballon);
		items.add(fusil);
		items.add(ventoline);
		items.add(oeufs);
		items.add(grappin);
		items.add(selPoivre);
		items.add(paquet);
		items.add(epices);
		items.add(micro);
		items.add(verre);
		items.add(bouteille);
		items.add(bescherelle);
		items.add(creme);
		items.add(pasteque);
		items.add(god);
		items.add(lanceRoquette);
		items.add(lanceGrenade);
		items.add(grenade);
		items.add(ceinture);
		items.add(bazooka);
		items.add(sniper);
		items.add(mitraillette);
		items.add(fusilFemme);
		items.add(fusilHomme);
		items.add(fusilPompe);
		items.add(pistoletLaser);
		items.add(pistoletBille);
		items.add(pistoletLacrymo);
		items.add(pistolet);
		items.add(revolver);
		items.add(carabine);
		items.add(arbalete);
		items.add(arc);
		items.add(sabre);
		items.add(epee);
		items.add(couteau);
		items.add(pelle);
		items.add(marteau);
		items.add(barreDeFer);
		items.add(javelot);
		items.add(baton);
		items.add(raquette);
		items.add(poingAmericain);
		items.add(batte);
		items.add(bouleBowling);
		items.add(bouteillePuante);
		items.add(bouteilleCassee);
		items.add(taser);
		items.add(gazeuse);
		items.add(cagette);
		items.add(croix);
		items.add(pansement);
		items.add(coton);
		items.add(pain);
		items.add(trefle);
		items.add(reveil);
		items.add(pistoletAEau);
		items.add(nuggets);
		items.add(steroide);
		items.add(pq);
		items.add(rhum);
		items.add(ciseau);
		items.add(walkman);
		items.add(dictaphone);
		items.add(dent);
		items.add(guitare);
		items.add(banane);
		items.add(glacon);
		items.add(plug);
		items.add(rasoir);

		
		items.add(carteDBZ1);
		items.add(carteDBZ2);
		items.add(carteDBZ3);
		items.add(carteDBZ4);
		items.add(carteDBZ5);
		items.add(carteDBZ6);
		items.add(carteDBZ7);
		items.add(carteDBZ8);
		
		items.add(carteCrados1);
		items.add(carteCrados2);
		items.add(carteCrados3);
		items.add(carteCrados4);
		items.add(carteCrados5);
		items.add(carteCrados6);
		items.add(carteCrados7);
		items.add(carteCrados8);

		// Refresh Listes
		triItems();
	}

	public List<Item> getAllItems() {
		return items;
	}

	public Item getItemByNom(String nom) {
		for (Item item : items) {
			if (item.getNom().equals(nom)) {
				return item;
			}
		}
		return null;
	}
	
	public Item getItemById(int id) {
		for (Item item : items) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public List<Item> getItemsDisponiblesByPerso(PersoPrenom nomPerso) {
		List<Item> itemPerso = new ArrayList<Item>();
		for (Item item : items) {
			if (item.getProprietaire().equals(nomPerso) && item.isDisponible()) {
				itemPerso.add(item);
			}
		}
		return itemPerso;
	}

	public List<Item> getItemsDisponibles() {
		refreshItems();
		return itemsDisponibles;
	}

	public List<Item> getItemsIndisponibles() {
		refreshItems();
		return itemsIndisponibles;
	}

	private void triItems() {
		for (Item item : items) {
			if (item.isDisponible()) {
				itemsDisponibles.add(item);
			} else {
				itemsIndisponibles.add(item);
			}
		}
	}

	private void refreshItems() {
		List<Item> indispoTemp = new ArrayList<Item>(itemsIndisponibles);
		for (Item item : indispoTemp) {
			if (item.isDisponible()) {
				// Refresh
				itemsDisponibles.add(item);
				itemsIndisponibles.remove(item);
			}
		}
	}
	
	private static int incrementeIdArme() {
		id = id +1;
		return id;
	}

	public static void gestionItemSelectionne(PersoPrenom prenomCible, Component panel) {
		
		// Si on a selectionne un item, on utilise l'item sur la cible et on decremente l'item
		if (itemSelectionne != null) {
			
			if (prenomCible != PersoPrenom.GROUPE) {
				
				int reponse = JOptionPane.showConfirmDialog(panel,
						"T'es sur de vouloir utiliser " + itemSelectionne.getNom() + " sur " + prenomCible.name() + "?");
				if (reponse == 0) {
					
					// On recupere le perso lanceur et le perso cible
					PersonnagePrincipal persoCible = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoByPrenom(prenomCible);
					
					// Si c'est une popo
					if (itemSelectionne.isConsommable()) {
					
						if (itemSelectionne.getType() == ItemType.POTION_VIE_25) {
							int vie = persoCible.getVie() + ((persoCible.getVieMax()*25)/100);
							if (vie > persoCible.getVieMax()) {
								vie = persoCible.getVieMax();
							}
							persoCible.setVie(vie);					
						} else if (itemSelectionne.getType() == ItemType.POTION_VIE_50) {
							int vie = persoCible.getVie() + ((persoCible.getVieMax()*50)/100);
							if (vie > persoCible.getVieMax()) {
								vie = persoCible.getVieMax();
							}
							persoCible.setVie(vie);	
						} else if (itemSelectionne.getType() == ItemType.POTION_VIE_75) {
							int vie = persoCible.getVie() + ((persoCible.getVieMax()*75)/100);
							if (vie > persoCible.getVieMax()) {
								vie = persoCible.getVieMax();
							}
							persoCible.setVie(vie);	
						} else if (itemSelectionne.getType() == ItemType.POTION_VIE_100) {
							persoCible.setVie(persoCible.getVieMax());	
							
						} else if (itemSelectionne.getType() == ItemType.POTION_MANA_25) {
							int mana = persoCible.getMana() + ((persoCible.getManaMax()*25)/100);
							if (mana > persoCible.getManaMax()) {
								mana = persoCible.getManaMax();
							}
							persoCible.setMana(mana);	
						} else if (itemSelectionne.getType() == ItemType.POTION_MANA_50) {
							int mana = persoCible.getMana() + ((persoCible.getManaMax()*50)/100);
							if (mana > persoCible.getManaMax()) {
								mana = persoCible.getManaMax();
							}
							persoCible.setMana(mana);	
						} else if (itemSelectionne.getType() == ItemType.POTION_MANA_75) {
							int mana = persoCible.getMana() + ((persoCible.getManaMax()*75)/100);
							if (mana > persoCible.getManaMax()) {
								mana = persoCible.getManaMax();
							}
							persoCible.setMana(mana);	
						} else if (itemSelectionne.getType() == ItemType.POTION_MANA_100) {
							persoCible.setMana(persoCible.getManaMax());	
							
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_CHANCE_5) {
							persoCible.addCompetences(PersoStat.LUCK, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_CHANCE_10) {
							persoCible.addCompetences(PersoStat.LUCK, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_CHANCE_20) {
							persoCible.addCompetences(PersoStat.LUCK, 20);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_EXPLOIT_5) {
							persoCible.addCompetences(PersoStat.EXPLOIT, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_EXPLOIT_10) {
							persoCible.addCompetences(PersoStat.EXPLOIT, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_EXPLOIT_20) {
							persoCible.addCompetences(PersoStat.EXPLOIT, 20);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_TECHNIQUE_5) {
							persoCible.addCompetences(PersoStat.TECHNIQUE, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_TECHNIQUE_10) {
							persoCible.addCompetences(PersoStat.TECHNIQUE, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_TECHNIQUE_20) {
							persoCible.addCompetences(PersoStat.TECHNIQUE, 20);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_ENDURANCE_5) {
							persoCible.addCompetences(PersoStat.ENDURANCE, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_ENDURANCE_10) {
							persoCible.addCompetences(PersoStat.ENDURANCE, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_ENDURANCE_20) {
							persoCible.addCompetences(PersoStat.ENDURANCE, 20);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RAPIDITE_5) {
							persoCible.addCompetences(PersoStat.RAPIDITE, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RAPIDITE_10) {
							persoCible.addCompetences(PersoStat.RAPIDITE, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RAPIDITE_20) {
							persoCible.addCompetences(PersoStat.RAPIDITE, 20);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RESISTANCE_5) {
							persoCible.addCompetences(PersoStat.RESISTANCE, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RESISTANCE_10) {
							persoCible.addCompetences(PersoStat.RESISTANCE, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RESISTANCE_20) {
							persoCible.addCompetences(PersoStat.RESISTANCE, 20);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_AGILITE_5) {
							persoCible.addCompetences(PersoStat.AGILITE, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_AGILITE_10) {
							persoCible.addCompetences(PersoStat.AGILITE, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_AGILITE_20) {
							persoCible.addCompetences(PersoStat.AGILITE, 20);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_INTELLIGENCE_5) {
							persoCible.addCompetences(PersoStat.INTELLIGENCE, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_INTELLIGENCE_10) {
							persoCible.addCompetences(PersoStat.INTELLIGENCE, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_INTELLIGENCE_20) {
							persoCible.addCompetences(PersoStat.INTELLIGENCE, 20);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_NERVOSITE_5) {
							persoCible.addCompetences(PersoStat.NERVOSITE, 5);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_NERVOSITE_10) {
							persoCible.addCompetences(PersoStat.NERVOSITE, 10);
						} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_NERVOSITE_20) {
							persoCible.addCompetences(PersoStat.NERVOSITE, 20);
						}
						
						// Cas du Groupe : On decremente l'objet dans le sac du groupe
						Map<Item, Integer> sac = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getSac();
						Integer valeur = sac.get(itemSelectionne);
						sac.put(itemSelectionne, valeur -1);
						
						JOptionPane.showMessageDialog(panel, persoCible.getPrenom() + " a consommé : " + itemSelectionne.getNom());
						
					// Si c'est une Arme
					} else if (itemSelectionne.getType() == ItemType.ARME) {
						
						Arme armeCourante = persoCible.getArme();
						Arme arme = (Arme)itemSelectionne;

						// Si le perso peut utiliser cette arme
						if (arme.getProprietaire() == PersoPrenom.GROUPE || arme.getProprietaire() == persoCible.getPrenomPerso()) {
							
							// Si c'est une arme perso
							if (arme.getProprietaire() != PersoPrenom.GROUPE) {
								
								// Si le perso n'a pas d'arme
								if (armeCourante == null) {
	
									// On donne la nouvelle arme au perso
									persoCible.setArme(arme);
									
									// On la retire du sac du perso
									Map<Item, Integer> sac = persoCible.getSac();
									Integer valeur = sac.get(arme);
									sac.put(arme, valeur -1);
									
								// Si le perso a deja une arme
								} else {
									
									// Si c'est une arme perso, on remet dans le sac du perso l'arme courante
									if (armeCourante.getProprietaire() != PersoPrenom.GROUPE) {
										Map<Item, Integer> sacPerso = persoCible.getSac();
										Integer valeur = sacPerso.get(armeCourante);
										sacPerso.put(armeCourante, valeur +1);
										
									// Sinon, on remet dans le sac du groupe l'arme courante du perso
									} else {
										Map<Item, Integer> sac = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getSac();
										Integer valeur = sac.get(armeCourante);
										sac.put(armeCourante, valeur +1);
									}
									
									// On retire la stat bonus au perso
									if (!armeCourante.getBonusParStat().isEmpty()) {
										for (PersoStat stat : armeCourante.getBonusParStat().keySet()) {
											persoCible.addCompetences(stat, -armeCourante.getBonusParStat().get(stat));
										}
									}
										
									// On donne la nouvelle arme au perso
									persoCible.setArme(arme);
									
									// On retire la nouvelle arme du sac du perso
									Map<Item, Integer> sac = persoCible.getSac();
									Integer valeur = sac.get(arme);
									sac.put(arme, valeur -1);
								}
		
							// Si c'est une arme groupe
							} else {
	
								// Si le perso n'a pas d'arme
								if (armeCourante == null) {
	
									// On donne la nouvelle arme au perso
									persoCible.setArme(arme);
									
									// On la retire du sac du groupe
									Map<Item, Integer> sac = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getSac();
									Integer valeur = sac.get(arme);
									sac.put(arme, valeur -1);
									
								// Si le perso a deja une arme
								} else {
									
									// Si c'est une arme perso, on remet dans le sac du perso l'arme courante
									if (armeCourante.getProprietaire() != PersoPrenom.GROUPE) {
										Map<Item, Integer> sacPerso = persoCible.getSac();
										Integer valeur = sacPerso.get(armeCourante);
										sacPerso.put(armeCourante, valeur +1);
										
									// Sinon, on remet dans le sac du groupe l'arme courante du perso
									} else {
										Map<Item, Integer> sac = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getSac();
										Integer valeur = sac.get(armeCourante);
										sac.put(armeCourante, valeur +1);
									}
									
									// On retire la stat bonus au perso
									if (!armeCourante.getBonusParStat().isEmpty()) {
										for (PersoStat stat : armeCourante.getBonusParStat().keySet()) {
											persoCible.addCompetences(stat, -armeCourante.getBonusParStat().get(stat));
										}
									}
									
									// On donne la nouvelle arme au perso
									persoCible.setArme(arme);
									
									// On la retire du sac du groupe
									Map<Item, Integer> sac = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getSac();
									Integer valeur = sac.get(arme);
									sac.put(arme, valeur -1);
								}
								
							}
							// On affiche le message de changement d'arme
							JOptionPane.showMessageDialog(panel, persoCible.getPrenom() + " s'est équipé d'une nouvelle " + arme.toString());

							// On ajoute la stat bonus au perso
							if (!arme.getBonusParStat().isEmpty()) {
								for (PersoStat stat : arme.getBonusParStat().keySet()) {
									persoCible.addCompetences(stat, arme.getBonusParStat().get(stat));
								}
							}
						
						// Si le perso ne peut pas utiliser cette arme
						} else {
							// On affiche le message de restriction
							JOptionPane.showMessageDialog(panel, persoCible.getPrenom() + " ne peut pas s'équiper de ce type d'arme (" + arme.getArmeType().name() + ")" );
						}
					}
					itemSelectionne = null;
					// On refresh le panelPersonnage MainFrame et le PanelBas
					MainFrame.getPanelPersonnage().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
					// TODO
					// On refresh le panelPersonnage FrameCombat
					
				} else {
					// Si on accepte pas d'utiliser la popo ou l'arme, on ne fait rien
				}
				
	
			}

		} else {
			// Si il n'y a pas d'item selectionne, on ne fait rien
		}
		MainFrame.getPanelBas().refreshPanelBas(prenomCible);
	}

	public static Item getItemSelectionne() {
		return itemSelectionne;
	}

	public static void setItemSelectionne(Item itemSelectionne) {
		ItemManager.itemSelectionne = itemSelectionne;
	}

	public static Arme genereArme(Arme modele, Mission mission, PersonnageManager personnageManager, PersoPrenom proprietaire) {
		
		PersonnagePrincipal proprio = personnageManager.getPersoByPrenom(proprietaire);
		
		Arme arme = copieArme(modele);
		arme.setId(incrementeIdArme());
		arme.setDisponible(true);
		arme.setArmeClasse(randomArmeClasse(mission.getDifficulty()));
		arme.setCouleur(getCouleurArme(arme.getArmeClasse()));
		arme.setDegatsMin(randomDegatsMin(mission.getDifficulty(), arme.getArmeClasse(), personnageManager, proprio));
		arme.setDegatsMax(randomDegatsMax(mission.getDifficulty(), arme.getArmeClasse(), arme.getDegatsMin(), personnageManager, proprio));
		arme.setBonusParStat(randomBonusStat(mission.getDifficulty(), arme, personnageManager, proprio));
		
		//////////////////////////
		StringBuilder bonusArme = new StringBuilder();
		for (PersoStat stat : arme.getBonusParStat().keySet()) {
			bonusArme.append(" +" + arme.getBonusParStat().get(stat) + " " + stat.name() + " -");
		}
		System.out.println("Nouvelle Arme " + id + " (" + arme.getArmeType().name() + ") (" + arme.getArmeClasse() + ") : " + arme.getDegatsMin() + " - " + arme.getDegatsMax() + " (" + bonusArme + ")" + " pour " + arme.getProprietaire().name()  );
		//////////////////////////
		
		return arme;
	}
	


	private static Color getCouleurArme(ArmeClasse armeClasse) {
		Color couleur = Color.GRAY;
		if (armeClasse == ArmeClasse.GRIS) {
			couleur = Color.GRAY;
		} else if (armeClasse == ArmeClasse.VERT) {
			couleur = Color.GREEN;
		} else if (armeClasse == ArmeClasse.BLEU) {
			couleur = Color.BLUE;
		} else if (armeClasse == ArmeClasse.VIOLET) {
			couleur = Color.MAGENTA;
		}
		return couleur;
	}

	public Arme genereArmeEnnemi(ArmeClasse classe, Mission mission, PersonnageManager personnageManager, PersonnageEnnemi proprio) {

		// En fonction de la difficulte tous les ennemis n'ont pas forcement d'arme (a part pendant les missions boss (boss inclus))
		if(mission.getMissionType() != MissionType.BOSS) {
			int chance = 0;
			if (mission.getDifficulty() == Difficulte.FACILE) {
				chance = Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.ennemi.facile"));
			} else if (mission.getDifficulty() == Difficulte.NORMAL) {
				chance = Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.ennemi.normal"));
			} else if (mission.getDifficulty() == Difficulte.DIFFICILE) {
				chance = Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.ennemi.difficile"));
			} else if (mission.getDifficulty() == Difficulte.HEROIQUE) {
				chance = Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.ennemi.heroique"));
			}
			int random = RandomManager.random0_100();
			if (random > chance) {
				return null;
			}
		}
		
		// Random un modele d'arme qui a deja été decouvert		
		Arme modele = getRandomArmeDejaDecouverte();
		
		Arme arme = copieArme(modele);
		arme.setId(incrementeIdArme());
		if(classe != null) {
			arme.setArmeClasse(classe);
		} else {
			arme.setArmeClasse(randomArmeClasse(mission.getDifficulty()));
		}
		arme.setCouleur(getCouleurArme(arme.getArmeClasse()));
		arme.setDegatsMin(randomDegatsMin(mission.getDifficulty(), arme.getArmeClasse(), personnageManager, proprio));
		arme.setDegatsMax(randomDegatsMax(mission.getDifficulty(), arme.getArmeClasse(), arme.getDegatsMin(), personnageManager, proprio));
		arme.setBonusParStat(randomBonusStat(mission.getDifficulty(), arme, personnageManager, proprio));
		
		//////////////////////////
		StringBuilder bonusArme = new StringBuilder();
		for (PersoStat stat : arme.getBonusParStat().keySet()) {
			bonusArme.append(" +" + arme.getBonusParStat().get(stat) + " " + stat.name() + " -");
		}
		System.out.println("Nouvelle Arme Ennemi" + id + " (" + arme.getArmeType().name() + ") (" + arme.getArmeClasse() + ") : " + arme.getDegatsMin() + " - " + arme.getDegatsMax() + " (" + bonusArme + ")" + " pour " + arme.getProprietaire().name()  );
		//////////////////////////
		
		return arme;
		
	}

	private Arme getRandomArmeDejaDecouverte() {
		List<Arme> itemsPerso = new ArrayList<>();
		for (Item item : items) {
			if ((item.getType() == ItemType.ARME) && (item.getProprietaire() == PersoPrenom.GROUPE) && (item.isDisponible())) {
				itemsPerso.add((Arme)item);
			}
		}
		
		int randomIndex = RandomManager.random(0, itemsPerso.size()-1);
		Arme arme = itemsPerso.get(randomIndex);
		
		return arme;
	}

	private static Arme copieArme(Arme modele) {

		int id = modele.getId();
		String nom = modele.getNom();
		String informations = modele.getInformations();
		List<String> imagePaths = modele.getImagePath();
		List<String> sonPaths = modele.getSonPath();
		List<String> videoPaths = modele.getVideoPaths();
		PersoPrenom proprietaire = modele.getProprietaire();
		int degatsMin = modele.getDegatsMin();
		int degatsMax = modele.getDegatsMax();
		ArmeType armeType = modele.getArmeType();
		ArmeClasse armeClasse = modele.getArmeClasse();
		PersoStat persoStat = modele.getPersoStat();
		boolean isDisponible = modele.isDisponible();
		
		Arme arme = new Arme(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, degatsMin, degatsMax, armeType, armeClasse, persoStat, isDisponible);
		return arme;
	}

	private static int randomDegatsMin(Difficulte difficulty, ArmeClasse armeClasse, PersonnageManager personnageManager, Personnage proprio) {
		// En fonction de la difficulte + de la classe (Gris, Vert, Bleu, Violet) + de niv du perso
		int degatsMin = 0; 
		
		if (difficulty == Difficulte.FACILE) {
			degatsMin = degatsMin + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.min.facile")));
		} else if (difficulty == Difficulte.NORMAL) {
			degatsMin = degatsMin + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.min.normal")));
		} else if (difficulty == Difficulte.DIFFICILE) {
			degatsMin = degatsMin + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.min.difficile")));
		} else if (difficulty == Difficulte.HEROIQUE) {
			degatsMin = degatsMin + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.min.heroique")));
		}  
		
		if (armeClasse == ArmeClasse.GRIS) {
			degatsMin = degatsMin + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.min.gris")));
		} else if (armeClasse == ArmeClasse.VERT) {
			degatsMin = degatsMin + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.min.vert")));
		} else if (armeClasse == ArmeClasse.BLEU) {
			degatsMin = degatsMin + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.min.bleu")));
		} else if (armeClasse == ArmeClasse.VIOLET) {
			degatsMin = degatsMin + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.min.violet")));
		}  
		
		// Ponderation avec le niveau de TECHNIQUE du proprio ou celui du meilleur perso du groupe
		if (proprio == null) {
			int technique = personnageManager.getBestStatPersoVivant(PersoStat.TECHNIQUE);
			degatsMin = (degatsMin * technique)/100;
		} else {
			int technique = proprio.getCompetence().getTechnique();
			degatsMin = (degatsMin * technique)/100;
		}			
		return degatsMin;
	}

	private static int randomDegatsMax(Difficulte difficulty, ArmeClasse armeClasse, int degatsMin, PersonnageManager personnageManager, Personnage proprio) {
		// En fonction de la difficulte + de la classe (Gris, Vert, Bleu, Violet) + de niv du perso + de degatsMin
		int degatsMax = 0;
		
		if (difficulty == Difficulte.FACILE) {
			degatsMax = degatsMax + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.max.facile")));
		} else if (difficulty == Difficulte.NORMAL) {
			degatsMax = degatsMax + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.max.normal")));
		} else if (difficulty == Difficulte.DIFFICILE) {
			degatsMax = degatsMax + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.max.difficile")));
		} else if (difficulty == Difficulte.HEROIQUE) {
			degatsMax = degatsMax + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.max.heroique")));
		}   
		
		if (armeClasse == ArmeClasse.GRIS) {
			degatsMax = degatsMax + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.max.gris")));
		} else if (armeClasse == ArmeClasse.VERT) {
			degatsMax = degatsMax + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.max.vert")));
		} else if (armeClasse == ArmeClasse.BLEU) {
			degatsMax = degatsMax + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.max.bleu")));
		} else if (armeClasse == ArmeClasse.VIOLET) {
			degatsMax = degatsMax + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.degats.max.violet")));
		}  

		// Ponderation avec le niveau de TECHNIQUE du proprio ou celui du meilleur perso du groupe
		if (proprio == null) {
			int technique = personnageManager.getBestStatPersoVivant(PersoStat.TECHNIQUE);
			degatsMax = (degatsMax * technique)/100;
		} else  {
			int technique = proprio.getCompetence().getTechnique();
			degatsMax = (degatsMax * technique)/100;
		}			
		
		if (degatsMin > degatsMax) {
			degatsMax = degatsMin + 1;
		}
		
		return degatsMax;
	}

	private static ArmeClasse randomArmeClasse(Difficulte difficulty) {
		ArmeClasse armeClasse = ArmeClasse.GRIS;
		int random = RandomManager.random0_100();
		if (difficulty == Difficulte.FACILE) {
			// 10 % de chance que ce soit Violet
			if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.facile.violet")))) {
				armeClasse = ArmeClasse.VIOLET;
			// 20 % de chance que ce soit Bleu
			} else if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.facile.bleu")))) {
				armeClasse = ArmeClasse.BLEU;
			// 30 % de chance que ce soit Vert
			} else if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.facile.vert")))) {
				armeClasse = ArmeClasse.VERT;
			}
		} else if (difficulty == Difficulte.NORMAL) {
			// 10 % de chance que ce soit Violet
			if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.normal.violet")))) {
				armeClasse = ArmeClasse.VIOLET;
			// 20 % de chance que ce soit Bleu
			} else if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.normal.bleu")))) {
				armeClasse = ArmeClasse.BLEU;
			// 30 % de chance que ce soit Vert
			} else if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.normal.vert")))) {
				armeClasse = ArmeClasse.VERT;
			}
		} else if (difficulty == Difficulte.DIFFICILE) {
			// 10 % de chance que ce soit Violet
			if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.difficile.violet")))) {
				armeClasse = ArmeClasse.VIOLET;
			// 20 % de chance que ce soit Bleu
			} else if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.difficile.bleu")))) {
				armeClasse = ArmeClasse.BLEU;
			// 30 % de chance que ce soit Vert
			} else if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.difficile.vert")))) {
				armeClasse = ArmeClasse.VERT;
			}
		} else if (difficulty == Difficulte.HEROIQUE) {
			// 10 % de chance que ce soit Violet
			if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.heroique.violet")))) {
				armeClasse = ArmeClasse.VIOLET;
			// 20 % de chance que ce soit Bleu
			} else if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.heroique.bleu")))) {
				armeClasse = ArmeClasse.BLEU;
			// 30 % de chance que ce soit Vert
			} else if (random < RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.classe.heroique.vert")))) {
				armeClasse = ArmeClasse.VERT;
			}
		}  
		return armeClasse;
	}
	
	private static Map<PersoStat, Integer> randomBonusStat(Difficulte difficulty, Arme arme, PersonnageManager personnageManager, Personnage proprio) {

		Map<PersoStat, Integer> bonusParStat = new HashMap<>(); 
		
		int bonus = 0;
		int bonusDifficulte = 0;
		
		// Si c'est une arme de groupe, on se base sur les competences du meilleur personnage ayant la meme statistique que celle de l'arme
		Personnage proprioTemp = proprio;
		if (proprio == null) {
			proprioTemp = personnageManager.getBestPersoVivant(arme.getPersoStat());
		}
		// Sinon si c'est une arme perso, on se base sur la competence du proprietaire de l'arme
		
		if (difficulty == Difficulte.FACILE) {
			bonusDifficulte = RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.facile")));
		} else if (difficulty == Difficulte.NORMAL) {
			bonusDifficulte = RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.normal")));
		} else if (difficulty == Difficulte.DIFFICILE) {
			bonusDifficulte = RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.difficile")));
		} else if (difficulty == Difficulte.HEROIQUE) {
			bonusDifficulte = RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.heroique")));
		}
		
		// Pas de bonus si c'est du gris
		if (arme.getArmeClasse() == ArmeClasse.GRIS) {
			
		// 1 Stat bonus si c'est du vert (celle du perso)
		} else if (arme.getArmeClasse() == ArmeClasse.VERT) {
			bonus = bonusDifficulte + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.vert")));
			// Ponderation avec le niveau de la competence du perso
			int stat = proprioTemp.getCompetence().getStats().get(arme.getPersoStat());
			bonus = (bonus * stat)/100;
			if (bonus > 0) {
				bonusParStat.put(arme.getPersoStat(), bonus);
			}
			
		// 2 Stats bonus si c'est du vert (celle du perso + 1 aleatoire differente)
		} else if (arme.getArmeClasse() == ArmeClasse.BLEU) {
			bonus = bonusDifficulte + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.bleu")));
			// Ponderation avec le niveau de la competence du perso
			int stat = proprioTemp.getCompetence().getStats().get(arme.getPersoStat());
			bonus = (bonus * stat)/100;
			if (bonus > 0) {
				bonusParStat.put(arme.getPersoStat(), bonus);
			}
			
			bonus = bonusDifficulte + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.bleu")));
			List<PersoStat> persoStatList = new ArrayList<>();
			persoStatList.add(arme.getPersoStat());
			// Ponderation avec le niveau de la competence du perso
			PersoStat randomPersoStat = randomPersoStat(persoStatList);
			int stat2 = proprioTemp.getCompetence().getStats().get(randomPersoStat);
			bonus = (bonus * stat2)/100;
			if (bonus > 0) {
				bonusParStat.put(randomPersoStat, bonus);
			}
			
		// 3 Stats bonus si c'est du vert (celle du perso + 2 aleatoires differentes)
		} else if (arme.getArmeClasse() == ArmeClasse.VIOLET) {
			bonus = bonusDifficulte + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.violet")));
			// Ponderation avec le niveau de la competence du perso
			int stat = proprioTemp.getCompetence().getStats().get(arme.getPersoStat());
			bonus = (bonus * stat)/100;
			if (bonus > 0) {
				bonusParStat.put(arme.getPersoStat(), bonus);
			}
			
			bonus = bonusDifficulte + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.violet")));
			List<PersoStat> persoStatList1 = new ArrayList<>();
			persoStatList1.add(arme.getPersoStat());
			// Ponderation avec le niveau de la competence du perso
			PersoStat randomPersoStat = randomPersoStat(persoStatList1);
			int stat1 = proprioTemp.getCompetence().getStats().get(randomPersoStat);
			bonus = (bonus * stat1)/100;
			if (bonus > 0) {
				bonusParStat.put(randomPersoStat, bonus);
			}
			
			bonus = bonusDifficulte + RandomManager.random(0, Integer.valueOf(ConfigurationManager.getProperties("arme.creation.random.bonus.stat.violet")));
			List<PersoStat> persoStatList2 = new ArrayList<>(bonusParStat.keySet());
			// Ponderation avec le niveau de la competence du perso
			PersoStat randomPersoStat2 = randomPersoStat(persoStatList2);
			int stat2 = proprioTemp.getCompetence().getStats().get(randomPersoStat2);
			bonus = (bonus * stat2)/100;
			if (bonus > 0) {
				bonusParStat.put(randomPersoStat2, bonus);
			}
		}

		return bonusParStat;
	}

	private static PersoStat randomPersoStat(List<PersoStat> persoStat) {
		List<PersoStat> statPossibles = new ArrayList<>();
		PersoStat[] values = PersoStat.values();
		for (PersoStat stat : values) {
			if (!persoStat.contains(stat)) {
				statPossibles.add(stat);
			}
		}
		int random = RandomManager.random(0, statPossibles.size()-1);
		
		return statPossibles.get(random);
	}

	public Item getArmeById(int id) {
		for (Item item : items) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public Arme getRandomArme(PersoPrenom proprio) {
		List<Arme> itemsPerso = new ArrayList<>();
		for (Item item : items) {
			if ( (item.getProprietaire() == proprio) && (item.getType() == ItemType.ARME) ) {
				itemsPerso.add((Arme)item);
			}
		}
		int randomIndex = RandomManager.random(0, itemsPerso.size()-1);
		Arme arme = itemsPerso.get(randomIndex);
		
		return arme;
	}


}
