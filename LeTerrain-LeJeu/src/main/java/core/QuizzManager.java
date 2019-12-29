package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modele.item.mission.enums.Difficulte;
import modele.quizz.Enigme;
import modele.quizz.Reponse;
import modele.quizz.TypeEnigme;

public class QuizzManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Enigme> enigmesInconnus;
	private List<Enigme> enigmesConnus;
	private List<Enigme> enigmesResolus;

	public void initialise() {

		enigmesInconnus = new ArrayList<Enigme>();
		enigmesConnus = new ArrayList<Enigme>();
		enigmesResolus = new ArrayList<Enigme>();
		
		// Chargement de toutes les enigmes
		
		// Image / Video
		
		// Question 1
		String imagePath1 = "image/defaut/defautQuestion.png";
		String videoPath1 = null;
		String question1 = "Hallowenn est une fete d'origine :";
		Reponse reponse1a = new Reponse("Irlandaise", true);
		Reponse reponse1b = new Reponse("Americaine", false);
		Reponse reponse1c = new Reponse("Francaise", false);
		Reponse reponse1d = new Reponse("Australienne", false);
		List<Reponse> reponsesPossibles1 = new ArrayList<Reponse>();
		reponsesPossibles1.add(reponse1a);
		reponsesPossibles1.add(reponse1b);
		reponsesPossibles1.add(reponse1c);
		reponsesPossibles1.add(reponse1d);
		String infoReponse1 = "Elle est introduite aux Etats-Unis et au Canada apres l'arrivee massive d'emigrants irlandais et ecossais vers 1850";

		
		// Question 2
		String imagePath2 = "image/defaut/defautQuestion.png";
		String videoPath2 = null;
		String question2 = "Les taureaux sont enerves principalement par :";
		Reponse reponse2a = new Reponse("Le rouge", false);
		Reponse reponse2b = new Reponse("Le orange", false);
		Reponse reponse2c = new Reponse("Le rose", false);
		Reponse reponse2d = new Reponse("Le jaune", false);
		List<Reponse> reponsesPossibles2 = new ArrayList<Reponse>();
		reponsesPossibles2.add(reponse2a);
		reponsesPossibles2.add(reponse2b);
		reponsesPossibles2.add(reponse2c);
		reponsesPossibles2.add(reponse2d);
		String infoReponse2 = "Les taureaux sont dichromates (ils ne voient pas les couleurs). C'est le mouvement de la cape du matador qui est percu comme une menace";
		
		// Question 3
		String imagePath3 = "image/defaut/defautQuestion.png";
		String videoPath3 = null;
		String question3 = "Si je me situe a l'Equateur et que je regarde mon lavabo se vider. L'eau s'ecoule :";
		Reponse reponse3a = new Reponse("Sans rotation", false);
		Reponse reponse3b = new Reponse("Dans le sens horaire", false);
		Reponse reponse3c = new Reponse("Dans le sens anti-horaire", false);
		Reponse reponse3d = new Reponse("Ce n'est pas previsible", true);
		List<Reponse> reponsesPossibles3 = new ArrayList<Reponse>();
		reponsesPossibles3.add(reponse3a);
		reponsesPossibles3.add(reponse3b);
		reponsesPossibles3.add(reponse3c);
		reponsesPossibles3.add(reponse3d);
		String infoReponse3 = "Meme si la force de Coriolis existe, a cette echelle l'impact est negligeable. Ce n'est pas previsible.";
		
		// Question 4
		String imagePath4 = "image/defaut/defautQuestion.png";
		String videoPath4 = null;
		String question4 = "Quel est le meilleur moyen pour un pingouin de se deplacer?";
		Reponse reponse4a = new Reponse("Il vole", true);
		Reponse reponse4b = new Reponse("Il marche", false);
		Reponse reponse4c = new Reponse("Il glisse", false);
		Reponse reponse4d = new Reponse("Il nage", false);
		List<Reponse> reponsesPossibles4 = new ArrayList<Reponse>();
		reponsesPossibles4.add(reponse4a);
		reponsesPossibles4.add(reponse4b);
		reponsesPossibles4.add(reponse4c);
		reponsesPossibles4.add(reponse4d);
		String infoReponse4 = "Il y a confusion avec le manchot qui dans beaucoup de langue a une traduction proche du mot pingouin (Pinguin en anglais)";
		
		// Question 5
		String imagePath5 = "image/defaut/defautQuestion.png";
		String videoPath5 = null;
		String question5 = "En 2019 combien denombre-t-on officiellement de planetes dans le systeme solaire?";
		Reponse reponse5a = new Reponse("8", true);
		Reponse reponse5b = new Reponse("9", false);
		Reponse reponse5c = new Reponse("10", false);
		Reponse reponse5d = new Reponse("Des milliards", false);
		List<Reponse> reponsesPossibles5 = new ArrayList<Reponse>();
		reponsesPossibles5.add(reponse5a);
		reponsesPossibles5.add(reponse5b);
		reponsesPossibles5.add(reponse5c);
		reponsesPossibles5.add(reponse5d);
		String infoReponse5 = "Pluton ayant ete recemment releguee au rang de planete Naine venant rejoindre Ceres, Haumea, Makemake et Eris";
		
		// Question 6
		String imagePath6 = "image/defaut/defautQuestion.png";
		String videoPath6 = null;
		String question6 = "Que sont les etoiles?";
		Reponse reponse6a = new Reponse("Des soleils", true);
		Reponse reponse6b = new Reponse("Des planetes", false);
		Reponse reponse6c = new Reponse("Des cometes de glace", false);
		Reponse reponse6d = new Reponse("Des amas de galaxies", false);
		List<Reponse> reponsesPossibles6 = new ArrayList<Reponse>();
		reponsesPossibles6.add(reponse6a);
		reponsesPossibles6.add(reponse6b);
		reponsesPossibles6.add(reponse6c);
		reponsesPossibles6.add(reponse6d);
		String infoReponse6 = "Une etoile est un corps celeste qui se deplace dans l'espace et qui emet sa propre lumiere. La plus proche de nous est le soleil.";
		
		// Question 7
		String imagePath7 = "image/defaut/defautQuestion.png";
		String videoPath7 = null;
		String question7 = "Si l'on prend la masse totale de notre systeme solaire. Le soleil en represente :";
		Reponse reponse7a = new Reponse("99,9%", true);
		Reponse reponse7b = new Reponse("69,9%", false);
		Reponse reponse7c = new Reponse("39,9%", false);
		Reponse reponse7d = new Reponse("9,9%", false);
		List<Reponse> reponsesPossibles7 = new ArrayList<Reponse>();
		reponsesPossibles7.add(reponse7a);
		reponsesPossibles7.add(reponse7b);
		reponsesPossibles7.add(reponse7c);
		reponsesPossibles7.add(reponse7d);
		String infoReponse7 = "Sa masse est d’environ 1,989 × 10^30 kg soit environ 330 000 fois celle de la Terre.";
		
		// Question 8
		String imagePath8 = "image/defaut/defautQuestion.png";
		String videoPath8 = null;
		String question8 = "Quelle difference y a-t-il entre un meteore et une meteorite";
		Reponse reponse8a = new Reponse("Les meteorites touchent la terre", true);
		Reponse reponse8b = new Reponse("Le salaire", false);
		Reponse reponse8c = new Reponse("Les meteorites brulent dans l'atmosphere", false);
		Reponse reponse8d = new Reponse("Les metorites sont de petits meteores", false);
		List<Reponse> reponsesPossibles8 = new ArrayList<Reponse>();
		reponsesPossibles8.add(reponse8a);
		reponsesPossibles8.add(reponse8b);
		reponsesPossibles8.add(reponse8c);
		reponsesPossibles8.add(reponse8d);
		String infoReponse8 = "Voila! J'ai rien a rajouter.";
		
		// Question 9
		String imagePath9 = "image/defaut/defautQuestion.png";
		String videoPath9 = null;
		String question9 = "Combien de personnes ont pose le pied sur la lune?";
		Reponse reponse9a = new Reponse("12", true);
		Reponse reponse9b = new Reponse("1", false);
		Reponse reponse9c = new Reponse("3", false);
		Reponse reponse9d = new Reponse("69", false);
		List<Reponse> reponsesPossibles9 = new ArrayList<Reponse>();
		reponsesPossibles9.add(reponse9a);
		reponsesPossibles9.add(reponse9b);
		reponsesPossibles9.add(reponse9c);
		reponsesPossibles9.add(reponse9d);
		String infoReponse9 = "Douze americains sur une periode de 3 ans et demi";
		
		// Question 10
		String imagePath10 = "image/defaut/defautQuestion.png";
		String videoPath10 = null;
		String question10 = "Les oiseaux dorment :";
		Reponse reponse10a = new Reponse("Debout sur une branche", true);
		Reponse reponse10b = new Reponse("Assis dans leur nid", false);
		Reponse reponse10c = new Reponse("Pendu a une branche", false);
		Reponse reponse10d = new Reponse("Allonge sur le sol", false);
		List<Reponse> reponsesPossibles10 = new ArrayList<Reponse>();
		reponsesPossibles10.add(reponse10a);
		reponsesPossibles10.add(reponse10b);
		reponsesPossibles10.add(reponse10c);
		reponsesPossibles10.add(reponse10d);
		String infoReponse10 = "Ils sont munis de tendons flechisseurs qui se contractent automatiquement les empechant de lacher la branche";
		
		// Question 11
		String imagePath11 = "image/defaut/defautQuestion.png";
		String videoPath11 = null;
		String question11 = "Lorsque je mange un oeuf de poule, je mange :";
		Reponse reponse11a = new Reponse("Un oeuf de dinosaure", true);
		Reponse reponse11b = new Reponse("Un oeuf de mammifere", false);
		Reponse reponse11c = new Reponse("Un oeuf de d'ophidien", false);
		Reponse reponse11d = new Reponse("Un oeuf de pachyderme", false);
		List<Reponse> reponsesPossibles11 = new ArrayList<Reponse>();
		reponsesPossibles11.add(reponse11a);
		reponsesPossibles11.add(reponse11b);
		reponsesPossibles11.add(reponse11c);
		reponsesPossibles11.add(reponse11d);
		String infoReponse11 = "Les poules ne descendent pas des dinosaures. Elles SONT des dinosaures.";
		
		// Question 12
		String imagePath12 = "image/defaut/defautQuestion.png";
		String videoPath12 = null;
		String question12 = "Les nuages sont :";
		Reponse reponse12a = new Reponse("Des gouttes d'eau en suspension", true);
		Reponse reponse12b = new Reponse("De la vapeur d'eau", false);
		Reponse reponse12c = new Reponse("Du coton hydratant", false);
		Reponse reponse12d = new Reponse("De la fumee", false);
		List<Reponse> reponsesPossibles12 = new ArrayList<Reponse>();
		reponsesPossibles12.add(reponse12a);
		reponsesPossibles12.add(reponse12b);
		reponsesPossibles12.add(reponse12c);
		reponsesPossibles12.add(reponse12d);
		String infoReponse12 = "La vapeur d'eau est invisible. Le nuage visible est la formation de mini goutelettes ou cristaux qui tombent une fois trop lourd";
		
		// Question 13
		String imagePath13 = "image/defaut/defautQuestion.png";
		String videoPath13 = null;
		String question13 = "La peau des Velociraptors etait recouverte :";
		Reponse reponse13a = new Reponse("De plumes", true);
		Reponse reponse13b = new Reponse("De poils", false);
		Reponse reponse13c = new Reponse("D'ecailles", false);
		Reponse reponse13d = new Reponse("De laine", false);
		List<Reponse> reponsesPossibles13 = new ArrayList<Reponse>();
		reponsesPossibles13.add(reponse13a);
		reponsesPossibles13.add(reponse13b);
		reponsesPossibles13.add(reponse13c);
		reponsesPossibles13.add(reponse13d);
		String infoReponse13 = "Et il ne depassait pas les 75cm de hauteur.";
		
		// Question 14
		String imagePath14 = "image/defaut/defautQuestion.png";
		String videoPath14 = null;
		String question14 = "Quand on fait craquer ses doigts, le bruit provient :";
		Reponse reponse14a = new Reponse("De la formation d'une bulle", true);
		Reponse reponse14b = new Reponse("De l'eclatement d'une bulle", false);
		Reponse reponse14c = new Reponse("Des os", false);
		Reponse reponse14d = new Reponse("Des cartilages", false);
		List<Reponse> reponsesPossibles14 = new ArrayList<Reponse>();
		reponsesPossibles14.add(reponse14a);
		reponsesPossibles14.add(reponse14b);
		reponsesPossibles14.add(reponse14c);
		reponsesPossibles14.add(reponse14d);
		String infoReponse14 = "Quand nous effectuons un geste rapide, la pression negative cree une bulle de gaz (le fameux bruit) dans le liquide entre deux cartilages d'une articulation.";
		
		// Question 15
		String imagePath15 = "image/defaut/defautQuestion.png";
		String videoPath15 = null;
		String question15 = "Le meilleur remede contre les piqures de meduses c'est :";
		Reponse reponse15a = new Reponse("Rincer a l'eau de mer", true);
		Reponse reponse15b = new Reponse("Rincer a l'eau douce", false);
		Reponse reponse15c = new Reponse("Rincer au vinaigre", false);
		Reponse reponse15d = new Reponse("Rincer a la pisse", false);
		List<Reponse> reponsesPossibles15 = new ArrayList<Reponse>();
		reponsesPossibles15.add(reponse15a);
		reponsesPossibles15.add(reponse15b);
		reponsesPossibles15.add(reponse15c);
		reponsesPossibles15.add(reponse15d);
		String infoReponse15 = "Arretez de pisser sur vos proches en vacances.";
		
		// Question 16
		String imagePath16 = "image/defaut/defautQuestion.png";
		String videoPath16 = null;
		String question16 = "Les chauves-souris sont :";
		Reponse reponse16a = new Reponse("Sourdes", false);
		Reponse reponse16b = new Reponse("Aveugles", false);
		Reponse reponse16c = new Reponse("Chauves", false);
		Reponse reponse16d = new Reponse("Muettes", false);
		List<Reponse> reponsesPossibles16 = new ArrayList<Reponse>();
		reponsesPossibles16.add(reponse16a);
		reponsesPossibles16.add(reponse16b);
		reponsesPossibles16.add(reponse16c);
		reponsesPossibles16.add(reponse16d);
		String infoReponse16 = "Meme si elles ont un systeme d'echo localisation permettant de se deplacer dans le noir, tous leurs sens sont actifs";
		
		// Question 17
		String imagePath17 = "image/defaut/defautQuestion.png";
		String videoPath17 = null;
		String question17 = "Apres avoir manger, pour ne pas s'hydrocuter en plongeant dans la piscine, il faut attendre :";
		Reponse reponse17a = new Reponse("45 min", false);
		Reponse reponse17b = new Reponse("2h", false);
		Reponse reponse17c = new Reponse("4h", false);
		Reponse reponse17d = new Reponse("2 jours", false);
		List<Reponse> reponsesPossibles17 = new ArrayList<Reponse>();
		reponsesPossibles17.add(reponse17a);
		reponsesPossibles17.add(reponse17b);
		reponsesPossibles17.add(reponse17c);
		reponsesPossibles17.add(reponse17d);
		String infoReponse17 = "L'hydrocution est le resultat de la difference de temperature. La digestion n'intervient pas dans le phenomene. Il faut surtout se mouiller avant de plonger.";
		
		// Question 18
		String imagePath18 = "image/defaut/defautQuestion.png";
		String videoPath18 = null;
		String question18 = "Un suppositoire doit s'inserer :";
		Reponse reponse18a = new Reponse("Du cote plat", true);
		Reponse reponse18b = new Reponse("Du cote fusele", false);
		Reponse reponse18c = new Reponse("Dans l'oreil", false);
		Reponse reponse18d = new Reponse("Fondu a l'avance", false);
		List<Reponse> reponsesPossibles18 = new ArrayList<Reponse>();
		reponsesPossibles18.add(reponse18a);
		reponsesPossibles18.add(reponse18b);
		reponsesPossibles18.add(reponse18c);
		reponsesPossibles18.add(reponse18d);
		String infoReponse18 = "Le cote fusele permet justement de le propulser quand la porte se referme.";
		
		// Question 19
		String imagePath19 = "image/defaut/defautQuestion.png";
		String videoPath19 = null;
		String question19 = "Les moustiques sont attires par :";
		Reponse reponse19a = new Reponse("Les odeurs", true);
		Reponse reponse19b = new Reponse("La lumiere", false);
		Reponse reponse19c = new Reponse("Les couleurs", false);
		Reponse reponse19d = new Reponse("Les ondes", false);
		List<Reponse> reponsesPossibles19 = new ArrayList<Reponse>();
		reponsesPossibles19.add(reponse19a);
		reponsesPossibles19.add(reponse19b);
		reponsesPossibles19.add(reponse19c);
		reponsesPossibles19.add(reponse19d);
		String infoReponse19 = "Beaucoup d'insectes sont attires par la lumiere mais pas les moustiques.";
		
		// Question 20
		String imagePath20 = "image/defaut/defautQuestion.png";
		String videoPath20 = null;
		String question20 = "Pourquoi y a-t-il autant de fausses fenetres sur les batiments dans Paris?";
		Reponse reponse20a = new Reponse("A cause des impots", true);
		Reponse reponse20b = new Reponse("Pour une raison de pudeur", false);
		Reponse reponse20c = new Reponse("Par soucis de sante", false);
		Reponse reponse20d = new Reponse("Pour le cote artistique", false);
		List<Reponse> reponsesPossibles20 = new ArrayList<Reponse>();
		reponsesPossibles20.add(reponse20a);
		reponsesPossibles20.add(reponse20b);
		reponsesPossibles20.add(reponse20c);
		reponsesPossibles20.add(reponse20d);
		String infoReponse20 = "En 1798 un impot fut mis en place en fonction du nombre de portes et fenetres des logements. De nombreuses fenetres furent condamnes.";
		
		// Question 21
		String imagePath21 = "image/defaut/defautQuestion.png";
		String videoPath21 = null;
		String question21 = "Les Poms Poms girls etaient a l'origine :";
		Reponse reponse21a = new Reponse("Des hommmes", true);
		Reponse reponse21b = new Reponse("Des enfants", false);
		Reponse reponse21c = new Reponse("Des femmes agees", false);
		Reponse reponse21d = new Reponse("Des nains", false);
		List<Reponse> reponsesPossibles21 = new ArrayList<Reponse>();
		reponsesPossibles21.add(reponse21a);
		reponsesPossibles21.add(reponse21b);
		reponsesPossibles21.add(reponse21c);
		reponsesPossibles21.add(reponse21d);
		String infoReponse21 = "Les remplacants chantaient pour les supporters et les joueurs. Sera reserve aux femmes a partir de 1960.";
		
		// Question 22
		String imagePath22 = "image/defaut/defautQuestion.png";
		String videoPath22 = null;
		String question22 = "Les statues Grecs et Romaines en marbre de l'antiquite etaient :";
		Reponse reponse22a = new Reponse("Recouvertes de peinture", true);
		Reponse reponse22b = new Reponse("Taillees avec les ongles", false);
		Reponse reponse22c = new Reponse("Habillees de vrais vetements", false);
		Reponse reponse22d = new Reponse("En bronze", false);
		List<Reponse> reponsesPossibles22 = new ArrayList<Reponse>();
		reponsesPossibles22.add(reponse22a);
		reponsesPossibles22.add(reponse22b);
		reponsesPossibles22.add(reponse22c);
		reponsesPossibles22.add(reponse22d);
		String infoReponse22 = "De nombreuses statues comportent encore des reste de peintures.";
		
		// Question 23
		String imagePath23 = "image/defaut/defautQuestion.png";
		String videoPath23 = null;
		String question23 = "En France, combien comportent d'habitants les villes les moins peuples?";
		Reponse reponse23a = new Reponse("0", true);
		Reponse reponse23b = new Reponse("2", false);
		Reponse reponse23c = new Reponse("12", false);
		Reponse reponse23d = new Reponse("53", false);
		List<Reponse> reponsesPossibles23 = new ArrayList<Reponse>();
		reponsesPossibles23.add(reponse23a);
		reponsesPossibles23.add(reponse23b);
		reponsesPossibles23.add(reponse23c);
		reponsesPossibles23.add(reponse23d);
		String infoReponse23 = "Il existe 6 villes sans habitants pres de Verdun, detruites pendant la guerre, qui ont un maire designe pour entretenir les lieux.";
		
		// Question 24
		String imagePath24 = "image/defaut/defautQuestion.png";
		String videoPath24 = null;
		String question24 = "Le corps humain est compose d'eau a :";
		Reponse reponse24a = new Reponse("63%", true);
		Reponse reponse24b = new Reponse("93%", false);
		Reponse reponse24c = new Reponse("33%", false);
		Reponse reponse24d = new Reponse("3%", false);
		List<Reponse> reponsesPossibles24 = new ArrayList<Reponse>();
		reponsesPossibles24.add(reponse24a);
		reponsesPossibles24.add(reponse24b);
		reponsesPossibles24.add(reponse24c);
		reponsesPossibles24.add(reponse24d);
		String infoReponse24 = "En comparaison, les meduses sont constitues a 98% d'eau.";
		
		// Question 25
		String imagePath25 = "image/defaut/defautQuestion.png";
		String videoPath25 = null;
		String question25 = "Google provient du mot :";
		Reponse reponse25a = new Reponse("Googol", true);
		Reponse reponse25b = new Reponse("Go and Goal", false);
		Reponse reponse25c = new Reponse("Gogole", false);
		Reponse reponse25d = new Reponse("Igloo", false);
		List<Reponse> reponsesPossibles25 = new ArrayList<Reponse>();
		reponsesPossibles25.add(reponse25a);
		reponsesPossibles25.add(reponse25b);
		reponsesPossibles25.add(reponse25c);
		reponsesPossibles25.add(reponse25d);
		String infoReponse25 = "Un Googol represente un '1' suivi de cent '0'.";
		
		// Question 26
		String imagePath26 = "image/defaut/defautQuestion.png";
		String videoPath26 = null;
		String question26 = "Charles Darwin avait pour habitude :";
		Reponse reponse26a = new Reponse("De gouter les especes decouvertes", true);
		Reponse reponse26b = new Reponse("D'empailler les especes decouvertes", false);
		Reponse reponse26c = new Reponse("D'enculer les especes decouvertes", false);
		Reponse reponse26d = new Reponse("De feconder les especes decouvertes", false);
		List<Reponse> reponsesPossibles26 = new ArrayList<Reponse>();
		reponsesPossibles26.add(reponse26a);
		reponsesPossibles26.add(reponse26b);
		reponsesPossibles26.add(reponse26c);
		reponsesPossibles26.add(reponse26d);
		String infoReponse26 = "Parmis les especes goutees : Le Puma, l'Iguane, Le Faucon, Le Hibou, La Tortue, Le Tatoo ou encore des rongeurs.";
		
		// Question 27
		String imagePath27 = "image/defaut/defautQuestion.png";
		String videoPath27 = null;
		String question27 = "Quel est l'ordre logique des couleurs des cartes?";
		Reponse reponse27a = new Reponse("Coeur, Trefle, Carreau, Pique", true);
		Reponse reponse27b = new Reponse("Trefle, Carreau, Pique, Coeur", false);
		Reponse reponse27c = new Reponse("Carreau, Pique, Coeur, Trefle", false);
		Reponse reponse27d = new Reponse("Pique, Coeur, Trefle, Carreau", false);
		List<Reponse> reponsesPossibles27 = new ArrayList<Reponse>();
		reponsesPossibles27.add(reponse27a);
		reponsesPossibles27.add(reponse27b);
		reponsesPossibles27.add(reponse27c);
		reponsesPossibles27.add(reponse27d);
		String infoReponse27 = "Coeur=2, Trefle=3, Carreau=4, Pique=5";
		
		// Question 28
		String imagePath28 = "image/defaut/defautQuestion.png";
		String videoPath28 = null;
		String question28 = "Le jeu d'echec se jouait a l'origine :";
		Reponse reponse28a = new Reponse("Avec des des", true);
		Reponse reponse28b = new Reponse("Sur un plateau rond", false);
		Reponse reponse28c = new Reponse("Seul", false);
		Reponse reponse28d = new Reponse("Sur un plateau de 16 cases", false);
		List<Reponse> reponsesPossibles28 = new ArrayList<Reponse>();
		reponsesPossibles28.add(reponse28a);
		reponsesPossibles28.add(reponse28b);
		reponsesPossibles28.add(reponse28c);
		reponsesPossibles28.add(reponse28d);
		String infoReponse28 = "Plus proche de la version originale provenant d'Inde la version avec des des sera interdite par l'eglise car consideree comme jeu de hasard.";
		
		// Question 29
		String imagePath29 = "image/defaut/defautQuestion.png";
		String videoPath29 = null;
		String question29 = "Durant les jeux olympiques de l'antiquite, quelle regle n'existait pas?";
		Reponse reponse29a = new Reponse("On peut intimider ses adversaires", true);
		Reponse reponse29b = new Reponse("Les femmes mariees ne peuvent assister aux jeux", false);
		Reponse reponse29c = new Reponse("Il ne faut pas etre esclave ou meteque", false);
		Reponse reponse29d = new Reponse("Les athletes et entraineurs doivent etre nus", false);
		List<Reponse> reponsesPossibles29 = new ArrayList<Reponse>();
		reponsesPossibles29.add(reponse29a);
		reponsesPossibles29.add(reponse29b);
		reponsesPossibles29.add(reponse29c);
		reponsesPossibles29.add(reponse29d);
		String infoReponse29 = "On avait pas le droit d'intimider son adversaire.";
		
		// Question 30
		String imagePath30 = "image/defaut/defautQuestion.png";
		String videoPath30 = null;
		String question30 = "Jusqu'au 20 eme siecle, lors d'un divorce en Angleterre, l'homme avait pour coutume :";
		Reponse reponse30a = new Reponse("De mettre en vente sa femme", true);
		Reponse reponse30b = new Reponse("De separer les enfants au hasard", false);
		Reponse reponse30c = new Reponse("De tuer les animaux de compagnie", false);
		Reponse reponse30d = new Reponse("De rembourser les beaux parents", false);
		List<Reponse> reponsesPossibles30 = new ArrayList<Reponse>();
		reponsesPossibles30.add(reponse30a);
		reponsesPossibles30.add(reponse30b);
		reponsesPossibles30.add(reponse30c);
		reponsesPossibles30.add(reponse30d);
		String infoReponse30 = "On vendait sa femme au marche ou plus tardivement a un ami.";
		
		// Question 31
		String imagePath31 = "image/defaut/defautQuestion.png";
		String videoPath31 = null;
		String question31 = "New York est :";
		Reponse reponse31a = new Reponse("Une ville", false);
		Reponse reponse31b = new Reponse("Un etat", false);
		Reponse reponse31c = new Reponse("Un continent", false);
		Reponse reponse31d = new Reponse("un quartier", false);
		List<Reponse> reponsesPossibles31 = new ArrayList<Reponse>();
		reponsesPossibles31.add(reponse31a);
		reponsesPossibles31.add(reponse31b);
		reponsesPossibles31.add(reponse31c);
		reponsesPossibles31.add(reponse31d);
		String infoReponse31 = "Ville + Etat. New York est une ville dans l'etat de New York dont la capitale est Albany";
		
		// Question 32
		String imagePath32 = "image/defaut/defautQuestion.png";
		String videoPath32 = null;
		String question32 = "Combien y a-t-il de panneau 'stop' dans Paris?";
		Reponse reponse32a = new Reponse("0", true);
		Reponse reponse32b = new Reponse("33", false);
		Reponse reponse32c = new Reponse("69", false);
		Reponse reponse32d = new Reponse("111", false);
		List<Reponse> reponsesPossibles32 = new ArrayList<Reponse>();
		reponsesPossibles32.add(reponse32a);
		reponsesPossibles32.add(reponse32b);
		reponsesPossibles32.add(reponse32c);
		reponsesPossibles32.add(reponse32d);
		String infoReponse32 = "Le dernier a ete enleve en 2013.";
		
		// Question 33
		String imagePath33 = "image/defaut/defautQuestion.png";
		String videoPath33 = null;
		String question33 = "La musique du jeu Tetris est d'origine :";
		Reponse reponse33a = new Reponse("Russe", true);
		Reponse reponse33b = new Reponse("Americaine", false);
		Reponse reponse33c = new Reponse("Japonaise", false);
		Reponse reponse33d = new Reponse("Francaise", false);
		List<Reponse> reponsesPossibles33 = new ArrayList<Reponse>();
		reponsesPossibles33.add(reponse33a);
		reponsesPossibles33.add(reponse33b);
		reponsesPossibles33.add(reponse33c);
		reponsesPossibles33.add(reponse33d);
		String infoReponse33 = "C'est une reprise d'un air russe connu.";
		
		// Question 34
		String imagePath34 = "image/defaut/defautQuestion.png";
		String videoPath34 = null;
		String question34 = "Si je double le deuxieme avant la ligne d'arrivee, je termine :";
		Reponse reponse34a = new Reponse("deuxieme", true);
		Reponse reponse34b = new Reponse("premier", false);
		Reponse reponse34c = new Reponse("penultieme", false);
		Reponse reponse34d = new Reponse("dernier", false);
		List<Reponse> reponsesPossibles34 = new ArrayList<Reponse>();
		reponsesPossibles34.add(reponse34a);
		reponsesPossibles34.add(reponse34b);
		reponsesPossibles34.add(reponse34c);
		reponsesPossibles34.add(reponse34d);
		String infoReponse34 = "";
		
		// Question 35
		String imagePath35 = "image/defaut/defautQuestion.png";
		String videoPath35 = null;
		String question35 = "Quelle etait la couleur du cheval blanc d'Henry IV?";
		Reponse reponse35a = new Reponse("blanche", true);
		Reponse reponse35b = new Reponse("noire", false);
		Reponse reponse35c = new Reponse("grise", false);
		Reponse reponse35d = new Reponse("marron", false);
		List<Reponse> reponsesPossibles35 = new ArrayList<Reponse>();
		reponsesPossibles35.add(reponse35a);
		reponsesPossibles35.add(reponse35b);
		reponsesPossibles35.add(reponse35c);
		reponsesPossibles35.add(reponse35d);
		String infoReponse35 = "Ca marche que a l'oral en fait...";
		
		// Question 36
		String imagePath36 = "image/defaut/defautQuestion.png";
		String videoPath36 = null;
		String question36 = "Combien de gouttes d'eau peut-on mettre dans un verre vide?";
		Reponse reponse36a = new Reponse("1", true);
		Reponse reponse36b = new Reponse("Moins de 10 000", false);
		Reponse reponse36c = new Reponse("Plus de 10 000", false);
		Reponse reponse36d = new Reponse("10 000", false);
		List<Reponse> reponsesPossibles36 = new ArrayList<Reponse>();
		reponsesPossibles36.add(reponse36a);
		reponsesPossibles36.add(reponse36b);
		reponsesPossibles36.add(reponse36c);
		reponsesPossibles36.add(reponse36d);
		String infoReponse36 = "Apres la premiere goutte, le verre n'est plus vide.";
		
		// Question 37
		String imagePath37 = "image/defaut/defautQuestion.png";
		String videoPath37 = null;
		String question37 = "Un fermier a 17 vaches. Elles meurent toutes sauf 9. Combien en reste-t-il?";
		Reponse reponse37a = new Reponse("9", true);
		Reponse reponse37b = new Reponse("8", false);
		Reponse reponse37c = new Reponse("13", false);
		Reponse reponse37d = new Reponse("2", false);
		List<Reponse> reponsesPossibles37 = new ArrayList<Reponse>();
		reponsesPossibles37.add(reponse37a);
		reponsesPossibles37.add(reponse37b);
		reponsesPossibles37.add(reponse37c);
		reponsesPossibles37.add(reponse37d);
		String infoReponse37 = "";
		
		// Question 38
		String imagePath38 = "image/defaut/defautQuestion.png";
		String videoPath38 = null;
		String question38 = "Qu'est-ce qui est jaune et qui attend?";
		Reponse reponse38a = new Reponse("Jonathan", true);
		Reponse reponse38b = new Reponse("Un chewing-gum colle au cul de Tarzan", false);
		Reponse reponse38c = new Reponse("Un six tronc", false);
		Reponse reponse38d = new Reponse("Un quoi feur", false);
		List<Reponse> reponsesPossibles38 = new ArrayList<Reponse>();
		reponsesPossibles38.add(reponse38a);
		reponsesPossibles38.add(reponse38b);
		reponsesPossibles38.add(reponse38c);
		reponsesPossibles38.add(reponse38d);
		String infoReponse38 = "La ressemblance est indeniable. Physiquement et vocalement.";
		
		// Question 39
		String imagePath39 = "image/defaut/defautQuestion.png";
		String videoPath39 = null;
		String question39 = "Quel est le vrai nom de Dorothee?";
		Reponse reponse39a = new Reponse("Frederique Hoschede", true);
		Reponse reponse39b = new Reponse("Ariane Carletti", false);
		Reponse reponse39c = new Reponse("Helene Rolles", false);
		Reponse reponse39d = new Reponse("Camille Raymond", false);
		List<Reponse> reponsesPossibles39 = new ArrayList<Reponse>();
		reponsesPossibles39.add(reponse39a);
		reponsesPossibles39.add(reponse39b);
		reponsesPossibles39.add(reponse39c);
		reponsesPossibles39.add(reponse39d);
		String infoReponse39 = "";
		
		// Question 40
		String imagePath40 = "image/defaut/defautQuestion.png";
		String videoPath40 = null;
		String question40 = "Quelle annee a suivi l'an 1 avant JC?";
		Reponse reponse40a = new Reponse("L'an 1 apres JC", true);
		Reponse reponse40b = new Reponse("L'an 0", false);
		Reponse reponse40c = new Reponse("L'an 2 avant JC", false);
		Reponse reponse40d = new Reponse("L'an 12 apres Jean Claude", false);
		List<Reponse> reponsesPossibles40 = new ArrayList<Reponse>();
		reponsesPossibles40.add(reponse40a);
		reponsesPossibles40.add(reponse40b);
		reponsesPossibles40.add(reponse40c);
		reponsesPossibles40.add(reponse40d);
		String infoReponse40 = "";
		
		// Question 41
		String imagePath41 = "image/defaut/defautQuestion.png";
		String videoPath41 = null;
		String question41 = "Quelle equipe est la seule selection a n'avoir manque aucune phase finale de Coupe du monde?";
		Reponse reponse41a = new Reponse("Le Bresil", true);
		Reponse reponse41b = new Reponse("L'Argentine", false);
		Reponse reponse41c = new Reponse("Le Paraguay", false);
		Reponse reponse41d = new Reponse("L'Allemagne", false);
		List<Reponse> reponsesPossibles41 = new ArrayList<Reponse>();
		reponsesPossibles41.add(reponse41a);
		reponsesPossibles41.add(reponse41b);
		reponsesPossibles41.add(reponse41c);
		reponsesPossibles41.add(reponse41d);
		String infoReponse41 = "Elle detient egalement le record du nombre de victoires avec ses 5 trophees";
		
		// Question 42
		String imagePath42 = "image/defaut/defautQuestion.png";
		String videoPath42 = null;
		String question42 = "En moyenne un humain au cours de sa vie marche :";
		Reponse reponse42a = new Reponse("185 000 km", true);
		Reponse reponse42b = new Reponse("18 500 km", false);
		Reponse reponse42c = new Reponse("1 850 km", false);
		Reponse reponse42d = new Reponse("185 km", false);
		List<Reponse> reponsesPossibles42 = new ArrayList<Reponse>();
		reponsesPossibles42.add(reponse42a);
		reponsesPossibles42.add(reponse42b);
		reponsesPossibles42.add(reponse42c);
		reponsesPossibles42.add(reponse42d);
		String infoReponse42 = "Soit plus de 4 fois le tour de la terre!";
		
		// Question 43
		String imagePath43 = "image/defaut/defautQuestion.png";
		String videoPath43 = null;
		String question43 = "Le lion est le roi de la jungle et il vit :";
		Reponse reponse43a = new Reponse("Dans les plaines", true);
		Reponse reponse43b = new Reponse("Dans la jungle", false);
		Reponse reponse43c = new Reponse("Dans la foret", false);
		Reponse reponse43d = new Reponse("Dans le desert", false);
		List<Reponse> reponsesPossibles43 = new ArrayList<Reponse>();
		reponsesPossibles43.add(reponse43a);
		reponsesPossibles43.add(reponse43b);
		reponsesPossibles43.add(reponse43c);
		reponsesPossibles43.add(reponse43d);
		String infoReponse43 = "";
		
		// Question 44
		String imagePath44 = "image/defaut/defautQuestion.png";
		String videoPath44 = null;
		String question44 = "Qui est apparu en premier?";
		Reponse reponse44a = new Reponse("Le briquet", true);
		Reponse reponse44b = new Reponse("L'allumette", false);
		Reponse reponse44c = new Reponse("Le papier toilette", false);
		Reponse reponse44d = new Reponse("La dynamite", false);
		List<Reponse> reponsesPossibles44 = new ArrayList<Reponse>();
		reponsesPossibles44.add(reponse44a);
		reponsesPossibles44.add(reponse44b);
		reponsesPossibles44.add(reponse44c);
		reponsesPossibles44.add(reponse44d);
		String infoReponse44 = "Le premier briquet a ete invente en 1823 et les premieres allumettes en 1827.";
		
		// Question 45
		String imagePath45 = "image/defaut/defautQuestion.png";
		String videoPath45 = null;
		String question45 = "Quel est le plus grand fabriquant de pneu au monde?";
		Reponse reponse45a = new Reponse("LEGO", true);
		Reponse reponse45b = new Reponse("Michelin", false);
		Reponse reponse45c = new Reponse("Goodyear", false);
		Reponse reponse45d = new Reponse("Airbag", false);
		List<Reponse> reponsesPossibles45 = new ArrayList<Reponse>();
		reponsesPossibles45.add(reponse45a);
		reponsesPossibles45.add(reponse45b);
		reponsesPossibles45.add(reponse45c);
		reponsesPossibles45.add(reponse45d);
		String infoReponse45 = "La societe produit plus de 300 millions d'unites par an, des pneus miniatures bien sur.";
		
		// Question 46
		String imagePath46 = "image/defaut/defautQuestion.png";
		String videoPath46 = null;
		String question46 = "En France jusqu'en 1933 les gendarmes etaient oblige de porter :";
		Reponse reponse46a = new Reponse("La moustache", true);
		Reponse reponse46b = new Reponse("Des mocassins a gland", false);
		Reponse reponse46c = new Reponse("Des culottes courtes", false);
		Reponse reponse46d = new Reponse("Un monocle", false);
		List<Reponse> reponsesPossibles46 = new ArrayList<Reponse>();
		reponsesPossibles46.add(reponse46a);
		reponsesPossibles46.add(reponse46b);
		reponsesPossibles46.add(reponse46c);
		reponsesPossibles46.add(reponse46d);
		String infoReponse46 = "";
		
		// Question 47
		String imagePath47 = "image/defaut/defautQuestion.png";
		String videoPath47 = null;
		String question47 = "Quel est le premier long metrage d'animation de Disney?";
		Reponse reponse47a = new Reponse("Blanche neige et les 7 nains", true);
		Reponse reponse47b = new Reponse("Bambi", false);
		Reponse reponse47c = new Reponse("Pinocchio", false);
		Reponse reponse47d = new Reponse("Dumbo", false);
		List<Reponse> reponsesPossibles47 = new ArrayList<Reponse>();
		reponsesPossibles47.add(reponse47a);
		reponsesPossibles47.add(reponse47b);
		reponsesPossibles47.add(reponse47c);
		reponsesPossibles47.add(reponse47d);
		String infoReponse47 = "Sortie en 1938, il sera interdit au moins de 16 ans ou censure dans certains pays d'Europe.";
		
		// Question 48
		String imagePath48 = "image/defaut/defautQuestion.png";
		String videoPath48 = null;
		String question48 = "Combien de bacteries vivent dans votre tube digestif?";
		Reponse reponse48a = new Reponse("100 trilliards", true);
		Reponse reponse48b = new Reponse("100 milliards", false);
		Reponse reponse48c = new Reponse("100 millions", false);
		Reponse reponse48d = new Reponse("0, le tube gigestif les detruisants toutes", false);
		List<Reponse> reponsesPossibles48 = new ArrayList<Reponse>();
		reponsesPossibles48.add(reponse48a);
		reponsesPossibles48.add(reponse48b);
		reponsesPossibles48.add(reponse48c);
		reponsesPossibles48.add(reponse48d);
		String infoReponse48 = "Dans le meme temps, 25.000 germes se promenent sur chaque centimetre carre de votre telephone portable, et 7,2 milliards sur l’eponge qui se trouve dans votre cuisine.";
		
		// Question 49
		String imagePath49 = "image/defaut/defautQuestion.png";
		String videoPath49 = null;
		String question49 = "Si on deroule l'ADN de l'ensemble de nos cellules la distance serait equivalente a :";
		Reponse reponse49a = new Reponse("Faire 52028 fois le trajet Terre-Lune", true);
		Reponse reponse49b = new Reponse("Traverser 28 fois l'Atlantique", false);
		Reponse reponse49c = new Reponse("Faire 128 tours de la Terre", false);
		Reponse reponse49d = new Reponse("Faire un Montfermeil-Gagny en 604", false);
		List<Reponse> reponsesPossibles49 = new ArrayList<Reponse>();
		reponsesPossibles49.add(reponse49a);
		reponsesPossibles49.add(reponse49b);
		reponsesPossibles49.add(reponse49c);
		reponsesPossibles49.add(reponse49d);
		String infoReponse49 = "On dispose de 2 metres d’ADN dans chaque cellule de notre corps, qui en compte 10 trillions (soit 10 000 milliards de cellules)";
		
		// Question 50
		String imagePath50 = "image/defaut/defautQuestion.png";
		String videoPath50 = null;
		String question50 = "En fonction de la temperature, la hauteur de la Tour Eiffel peut varier de :";
		Reponse reponse50a = new Reponse("15 centimetres", true);
		Reponse reponse50b = new Reponse("15 millimetres", false);
		Reponse reponse50c = new Reponse("15 metres", false);
		Reponse reponse50d = new Reponse("C'est imperceptible.", false);
		List<Reponse> reponsesPossibles50 = new ArrayList<Reponse>();
		reponsesPossibles50.add(reponse50a);
		reponsesPossibles50.add(reponse50b);
		reponsesPossibles50.add(reponse50c);
		reponsesPossibles50.add(reponse50d);
		String infoReponse50 = "L’acier dont elle est constituee a un coefficient de dilatation relativement important, ce qui explique de telles variations.";
		
		// Question 51
		String imagePath51 = "image/defaut/defautQuestion.png";
		String videoPath51 = null;
		String question51 = "Quelle est la bonne affirmation?";
		Reponse reponse51a = new Reponse("La Terre tourne autour du Soleil", true);
		Reponse reponse51b = new Reponse("Le Soleil tourne autour de la Terre", false);
		Reponse reponse51c = new Reponse("La Soleil tourne autour de la Lune", false);
		Reponse reponse51d = new Reponse("En fait... La Terre est plate", false);
		List<Reponse> reponsesPossibles51 = new ArrayList<Reponse>();
		reponsesPossibles51.add(reponse51a);
		reponsesPossibles51.add(reponse51b);
		reponsesPossibles51.add(reponse51c);
		reponsesPossibles51.add(reponse51d);
		String infoReponse51 = "C'est la gravitation, force qui nous retient au sol et qui maintient les planetes en orbite autour du Soleil car plus massif";
		
		// Question 52
		String imagePath52 = "image/defaut/defautQuestion.png";
		String videoPath52 = null;
		String question52 = "Les planetes tournent autour du soleil :";
		Reponse reponse52a = new Reponse("Dans le meme sens", true);
		Reponse reponse52b = new Reponse("Dans des sens differents", false);
		Reponse reponse52c = new Reponse("De gauche a droite", false);
		Reponse reponse52d = new Reponse("De maniere parallele", false);
		List<Reponse> reponsesPossibles52 = new ArrayList<Reponse>();
		reponsesPossibles52.add(reponse52a);
		reponsesPossibles52.add(reponse52b);
		reponsesPossibles52.add(reponse52c);
		reponsesPossibles52.add(reponse52d);
		String infoReponse52 = "Ce phenomene est une consequence de la facon dont le soleil et les planetes se sont formees (a partir d'une nebuleuse en rotation).";
		
		// Question 53
		String imagePath53 = "image/defaut/defautQuestion.png";
		String videoPath53 = null;
		String question53 = "Le Permafrost qui a deja commence a fondre contient :";
		Reponse reponse53a = new Reponse("2 fois plus de CO2 que dans l'atmosphere actuelle", true);
		Reponse reponse53b = new Reponse("2 fois moins de CO2 que dans l'atmosphere actuelle", false);
		Reponse reponse53c = new Reponse("10 fois moins de CO2 que dans l'atmosphere actuelle", false);
		Reponse reponse53d = new Reponse("Pas de CO2", false);
		List<Reponse> reponsesPossibles53 = new ArrayList<Reponse>();
		reponsesPossibles53.add(reponse53a);
		reponsesPossibles53.add(reponse53b);
		reponsesPossibles53.add(reponse53c);
		reponsesPossibles53.add(reponse53d);
		String infoReponse53 = "Ca sent la merde. Ou le CO2.";
		
		// Question 54
		String imagePath54 = "image/defaut/defautQuestion.png";
		String videoPath54 = null;
		String question54 = "En 2014, lors d'un conference au National Press Club la presidente du FMI Christine Lagarde fait un discours qui parle de :";
		Reponse reponse54a = new Reponse("Numerologie", true);
		Reponse reponse54b = new Reponse("Spiritisme", false);
		Reponse reponse54c = new Reponse("Religion", false);
		Reponse reponse54d = new Reponse("Reduction de la population", false);
		List<Reponse> reponsesPossibles54 = new ArrayList<Reponse>();
		reponsesPossibles54.add(reponse54a);
		reponsesPossibles54.add(reponse54b);
		reponsesPossibles54.add(reponse54c);
		reponsesPossibles54.add(reponse54d);
		String infoReponse54 = "Un discours pour le moins atypique.";
		
		// Question 55
		String imagePath55 = "image/defaut/defautQuestion.png";
		String videoPath55 = null;
		String question55 = "Combien fait 1+2+3+4+5+6+7+8+9?";
		Reponse reponse55a = new Reponse("45", true);
		Reponse reponse55b = new Reponse("100", false);
		Reponse reponse55c = new Reponse("50", false);
		Reponse reponse55d = new Reponse("39", false);
		List<Reponse> reponsesPossibles55 = new ArrayList<Reponse>();
		reponsesPossibles55.add(reponse55a);
		reponsesPossibles55.add(reponse55b);
		reponsesPossibles55.add(reponse55c);
		reponsesPossibles55.add(reponse55d);
		String infoReponse55 = "";
		
		// Question 56
		String imagePath56 = "image/defaut/defautQuestion.png";
		String videoPath56 = null;
		String question56 = "En logique, si A est vrai et que B est faux, A et B est :";
		Reponse reponse56a = new Reponse("Faux", true);
		Reponse reponse56b = new Reponse("Vrai", false);
		Reponse reponse56c = new Reponse("Null", false);
		Reponse reponse56d = new Reponse("Indetermine", false);
		List<Reponse> reponsesPossibles56 = new ArrayList<Reponse>();
		reponsesPossibles56.add(reponse56a);
		reponsesPossibles56.add(reponse56b);
		reponsesPossibles56.add(reponse56c);
		reponsesPossibles56.add(reponse56d);
		String infoReponse56 = "Vrai et Faux = Faux";
		
		// Question 57
		String imagePath57 = "image/defaut/defautQuestion.png";
		String videoPath57 = null;
		String question57 = "En logique, si A est faux et que B est faux, A et B est :";
		Reponse reponse57a = new Reponse("Faux", true);
		Reponse reponse57b = new Reponse("Vrai", false);
		Reponse reponse57c = new Reponse("Null", false);
		Reponse reponse57d = new Reponse("Indetermine", false);
		List<Reponse> reponsesPossibles57 = new ArrayList<Reponse>();
		reponsesPossibles57.add(reponse57a);
		reponsesPossibles57.add(reponse57b);
		reponsesPossibles57.add(reponse57c);
		reponsesPossibles57.add(reponse57d);
		String infoReponse57 = "Faux et Faux = Faux";
		
		// Question 58
		String imagePath58 = "image/defaut/defautQuestion.png";
		String videoPath58 = null;
		String question58 = "En logique, si A est faux et que B est vrai, A ou B est :";
		Reponse reponse58a = new Reponse("Vrai", true);
		Reponse reponse58b = new Reponse("Faux", false);
		Reponse reponse58c = new Reponse("Null", false);
		Reponse reponse58d = new Reponse("Indetermine", false);
		List<Reponse> reponsesPossibles58 = new ArrayList<Reponse>();
		reponsesPossibles58.add(reponse58a);
		reponsesPossibles58.add(reponse58b);
		reponsesPossibles58.add(reponse58c);
		reponsesPossibles58.add(reponse58d);
		String infoReponse58 = "Faux ou Vrai = Vrai";
		
		// Question 59
		String imagePath59 = "image/defaut/defautQuestion.png";
		String videoPath59 = null;
		String question59 = "Dans la repartition de la biomasse en fonction des groupes d'etres vivants, les plantes representent :";
		Reponse reponse59a = new Reponse("82%", true);
		Reponse reponse59b = new Reponse("22%", false);
		Reponse reponse59c = new Reponse("42%", false);
		Reponse reponse59d = new Reponse("62%", false);
		List<Reponse> reponsesPossibles59 = new ArrayList<Reponse>();
		reponsesPossibles59.add(reponse59a);
		reponsesPossibles59.add(reponse59b);
		reponsesPossibles59.add(reponse59c);
		reponsesPossibles59.add(reponse59d);
		String infoReponse59 = "Les animaux ne representant que 0,5% du total.";
		
		// Question 60
		String imagePath60 = "image/defaut/defautQuestion.png";
		String videoPath60 = null;
		String question60 = "Sur le volume totale d'eau sur la planete, le volume d'eau douce represente :";
		Reponse reponse60a = new Reponse("3%", true);
		Reponse reponse60b = new Reponse("18%", false);
		Reponse reponse60c = new Reponse("33%", false);
		Reponse reponse60d = new Reponse("90%", false);
		List<Reponse> reponsesPossibles60 = new ArrayList<Reponse>();
		reponsesPossibles60.add(reponse60a);
		reponsesPossibles60.add(reponse60b);
		reponsesPossibles60.add(reponse60c);
		reponsesPossibles60.add(reponse60d);
		String infoReponse60 = "Sur ces 3% d’eau douce, 99% sont tres difficilement exploitables : 77 % sont geles au niveau des calottes polaires et dans les glaciers de montagne et 22 % sont profondement enfouis dans le sous-sol.";
		
		// Question 61
		String imagePath61 = "image/defaut/defautQuestion.png";
		String videoPath61 = null;
		String question61 = "Selon les connaissances actuelles, l'age de la Terre est de :";
		Reponse reponse61a = new Reponse("4,5 milliards d'annees", true);
		Reponse reponse61b = new Reponse("13,7 milliards d'annees", false);
		Reponse reponse61c = new Reponse("7,5 millions d'annees", false);
		Reponse reponse61d = new Reponse("4000 ans", false);
		List<Reponse> reponsesPossibles61 = new ArrayList<Reponse>();
		reponsesPossibles61.add(reponse61a);
		reponsesPossibles61.add(reponse61b);
		reponsesPossibles61.add(reponse61c);
		reponsesPossibles61.add(reponse61d);
		String infoReponse61 = " Cette datation repose sur des preuves scientifiques provenant de la datation radiometrique des meteorites et se trouve coherente avec l'age des echantillons des plus anciennes roches lunaires et terrestres connues";
		
		// Question 62
		String imagePath62 = "image/defaut/defautQuestion.png";
		String videoPath62 = null;
		String question62 = "Selon les connaissances actuelles, l'age de l'Univers est de :";
		Reponse reponse62a = new Reponse("4,5 milliards d'annees", false);
		Reponse reponse62b = new Reponse("13,7 milliards d'annees", true);
		Reponse reponse62c = new Reponse("7,5 millions d'annees", false);
		Reponse reponse62d = new Reponse("4000 ans", false);
		List<Reponse> reponsesPossibles62 = new ArrayList<Reponse>();
		reponsesPossibles62.add(reponse62a);
		reponsesPossibles62.add(reponse62b);
		reponsesPossibles62.add(reponse62c);
		reponsesPossibles62.add(reponse62d);
		String infoReponse62 = "Le fait que l'Univers soit en expansion nous permet de determiner un point d'origine et la vitesse d'expansion nous donne un age.";
		
		// Question 63
		String imagePath63 = "image/defaut/defautQuestion.png";
		String videoPath63 = null;
		String question63 = "Pi est un nombre :";
		Reponse reponse63a = new Reponse("Irrationel et Transcendant", true);
		Reponse reponse63b = new Reponse("Irrationel", false);
		Reponse reponse63c = new Reponse("Transcendant", false);
		Reponse reponse63d = new Reponse("Entier", false);
		List<Reponse> reponsesPossibles63 = new ArrayList<Reponse>();
		reponsesPossibles63.add(reponse63a);
		reponsesPossibles63.add(reponse63b);
		reponsesPossibles63.add(reponse63c);
		reponsesPossibles63.add(reponse63d);
		String infoReponse63 = "Pi est irrationnel, c’est-a-dire qu’on ne peut pas l’exprimer comme un rapport de deux nombres entiers. Pi est un nombre transcendant, ce qui signifie qu’il n’existe pas de polynome non nul a coefficients entiers dont Pi soit une racine. ";
		
		// Question 64
		String imagePath64 = "image/defaut/defautQuestion.png";
		String videoPath64 = null;
		String question64 = "Le nombre d'or Phi est egale a :";
		Reponse reponse64a = new Reponse("1,618...", true);
		Reponse reponse64b = new Reponse("0,618...", false);
		Reponse reponse64c = new Reponse("2,618...", false);
		Reponse reponse64d = new Reponse("3,141...", false);
		List<Reponse> reponsesPossibles64 = new ArrayList<Reponse>();
		reponsesPossibles64.add(reponse64a);
		reponsesPossibles64.add(reponse64b);
		reponsesPossibles64.add(reponse64c);
		reponsesPossibles64.add(reponse64d);
		String infoReponse64 = "Son carre est egal a lui-meme plus un, soit 2,618... et son inverse est egal a lui meme moins 1, soit 0,618... .";
		
		// Question 65
		String imagePath65 = "image/defaut/defautQuestion.png";
		String videoPath65 = null;
		String question65 = "Dans la suite de Fibonacci, quand on divise un terme de la suite par celui d'avant, on obtient :";
		Reponse reponse65a = new Reponse("Une approximation du nombre d'or", true);
		Reponse reponse65b = new Reponse("Leonard de Vinci", false);
		Reponse reponse65c = new Reponse("Une approximation de Pi", false);
		Reponse reponse65d = new Reponse("Un entier", false);
		List<Reponse> reponsesPossibles65 = new ArrayList<Reponse>();
		reponsesPossibles65.add(reponse65a);
		reponsesPossibles65.add(reponse65b);
		reponsesPossibles65.add(reponse65c);
		reponsesPossibles65.add(reponse65d);
		String infoReponse65 = "Plus on avance dans la suite, plus l'approximation est precise";
		
		// Question 66
		String imagePath66 = "image/defaut/defautQuestion.png";
		String videoPath66 = null;
		String question66 = "Notre decompte du temps en base 60 provient :";
		Reponse reponse66a = new Reponse("Des Sumeriens", true);
		Reponse reponse66b = new Reponse("Des Romains", false);
		Reponse reponse66c = new Reponse("Des Grecs", false);
		Reponse reponse66d = new Reponse("Des Anglais", false);
		List<Reponse> reponsesPossibles66 = new ArrayList<Reponse>();
		reponsesPossibles66.add(reponse66a);
		reponsesPossibles66.add(reponse66b);
		reponsesPossibles66.add(reponse66c);
		reponsesPossibles66.add(reponse66d);
		String infoReponse66 = "Ils nous ont leguer les jours de 24h, les heures decoupees en 60min, les minutes en 60s mais egalement le cercle de 360 degre.";
		
		// Question 67
		String imagePath67 = "image/defaut/defautQuestion.png";
		String videoPath67 = null;
		String question67 = "Combien fait 2 * 4 * 6 * 8 * 0 ?";
		Reponse reponse67a = new Reponse("0", true);
		Reponse reponse67b = new Reponse("384", false);
		Reponse reponse67c = new Reponse("483", false);
		Reponse reponse67d = new Reponse("348", false);
		List<Reponse> reponsesPossibles67 = new ArrayList<Reponse>();
		reponsesPossibles67.add(reponse67a);
		reponsesPossibles67.add(reponse67b);
		reponsesPossibles67.add(reponse67c);
		reponsesPossibles67.add(reponse67d);
		String infoReponse67 = "N'importe quoi fois 0 egal 0.";
		
		// Question 68
		String imagePath68 = "image/defaut/defautQuestion.png";
		String videoPath68 = null;
		String question68 = "Combien fait 1 divise par 0 ?";
		Reponse reponse68a = new Reponse("Ce n'est pas possible", true);
		Reponse reponse68b = new Reponse("1", false);
		Reponse reponse68c = new Reponse("0", false);
		Reponse reponse68d = new Reponse("0,5", false);
		List<Reponse> reponsesPossibles68 = new ArrayList<Reponse>();
		reponsesPossibles68.add(reponse68a);
		reponsesPossibles68.add(reponse68b);
		reponsesPossibles68.add(reponse68c);
		reponsesPossibles68.add(reponse68d);
		String infoReponse68 = "Nous ne pouvons pas diviser par zero";
		
		// Question 69
		String imagePath69 = "image/defaut/defautQuestion.png";
		String videoPath69 = null;
		String question69 = "Si j'ai 13 billes dans ma poche et que j'en ramasse 8 par terre, combien il reste de billes dans ma poche?";
		Reponse reponse69a = new Reponse("13", true);
		Reponse reponse69b = new Reponse("8", false);
		Reponse reponse69c = new Reponse("21", false);
		Reponse reponse69d = new Reponse("5", false);
		List<Reponse> reponsesPossibles69 = new ArrayList<Reponse>();
		reponsesPossibles69.add(reponse69a);
		reponsesPossibles69.add(reponse69b);
		reponsesPossibles69.add(reponse69c);
		reponsesPossibles69.add(reponse69d);
		String infoReponse69 = "";
		
		// Question 70
		String imagePath70 = "image/defaut/defautQuestion.png";
		String videoPath70 = null;
		String question70 = "Homo Habilis aurait vecu il y a environ :";
		Reponse reponse70a = new Reponse("2 million d'annees", true);
		Reponse reponse70b = new Reponse("200 000 ans", false);
		Reponse reponse70c = new Reponse("20 000 ans", false);
		Reponse reponse70d = new Reponse("2 000 ans", false);
		List<Reponse> reponsesPossibles70 = new ArrayList<Reponse>();
		reponsesPossibles70.add(reponse70a);
		reponsesPossibles70.add(reponse70b);
		reponsesPossibles70.add(reponse70c);
		reponsesPossibles70.add(reponse70d);
		String infoReponse70 = "Le genre Homo commence a manier des outils";
		
		// Question 71
		String imagePath71 = "image/defaut/defautQuestion.png";
		String videoPath71 = null;
		String question71 = "A l'echelle de l'Univers, l'homme moderne a vecu :";
		Reponse reponse71a = new Reponse("0,00001% du temps", true);
		Reponse reponse71b = new Reponse("10% du temps", false);
		Reponse reponse71c = new Reponse("1% du temps", false);
		Reponse reponse71d = new Reponse("0.1% du temps", false);
		List<Reponse> reponsesPossibles71 = new ArrayList<Reponse>();
		reponsesPossibles71.add(reponse71a);
		reponsesPossibles71.add(reponse71b);
		reponsesPossibles71.add(reponse71c);
		reponsesPossibles71.add(reponse71d);
		String infoReponse71 = "Soit les 10 dernieres secondes, si l'Univers avant 1 an. Dieu a decidemment mis beaucoup de temps a nous fabriquer!";
		
		// Question 72
		String imagePath72 = "image/defaut/defautQuestion.png";
		String videoPath72 = null;
		String question72 = "Les personnes ayant les yeux bleus ont tous un ancetre commun qui vivait il y a environ :";
		Reponse reponse72a = new Reponse("8 000 ans", true);
		Reponse reponse72b = new Reponse("8 millions d'annees", false);
		Reponse reponse72c = new Reponse("800 ans", false);
		Reponse reponse72d = new Reponse("8 milliers d'annee", false);
		List<Reponse> reponsesPossibles72 = new ArrayList<Reponse>();
		reponsesPossibles72.add(reponse72a);
		reponsesPossibles72.add(reponse72b);
		reponsesPossibles72.add(reponse72c);
		reponsesPossibles72.add(reponse72d);
		String infoReponse72 = " Cet ancetre commun aurait porte une mutation genetique spontanee soustrayant l'eumelanine des yeux marrons, alors dominants, pour donner du bleu.";
		
		// Question 73
		String imagePath73 = "image/defaut/defautQuestion.png";
		String videoPath73 = null;
		String question73 = "Notre genome est identique a celui du chimpanze a :";
		Reponse reponse73a = new Reponse("99%", true);
		Reponse reponse73b = new Reponse("69%", false);
		Reponse reponse73c = new Reponse("39%", false);
		Reponse reponse73d = new Reponse("9%", false);
		List<Reponse> reponsesPossibles73 = new ArrayList<Reponse>();
		reponsesPossibles73.add(reponse73a);
		reponsesPossibles73.add(reponse73b);
		reponsesPossibles73.add(reponse73c);
		reponsesPossibles73.add(reponse73d);
		String infoReponse73 = "Pour information, nous avons 90% de genes en commun avec la souris, et 60% avec la mouche.";
		
		// Question 74
		String imagePath74 = "image/defaut/defautQuestion.png";
		String videoPath74 = null;
		String question74 = "L'homme descend-t-il du singe?";
		Reponse reponse74a = new Reponse("Non, l'homme est un singe", true);
		Reponse reponse74b = new Reponse("Oui", false);
		Reponse reponse74c = new Reponse("Non, Dieu a cree l'homme a son image", false);
		Reponse reponse74d = new Reponse("Non, l'homme descend du cochon", false);
		List<Reponse> reponsesPossibles74 = new ArrayList<Reponse>();
		reponsesPossibles74.add(reponse74a);
		reponsesPossibles74.add(reponse74b);
		reponsesPossibles74.add(reponse74c);
		reponsesPossibles74.add(reponse74d);
		String infoReponse74 = "Plus precisemment l'homme est un primate";
		
		// Question 75
		String imagePath75 = "image/defaut/defautQuestion.png";
		String videoPath75 = null;
		String question75 = "Alpha, Beta, ... ?";
		Reponse reponse75a = new Reponse("Gamma", true);
		Reponse reponse75b = new Reponse("Ceta", false);
		Reponse reponse75c = new Reponse("Omega", false);
		Reponse reponse75d = new Reponse("Delta", false);
		List<Reponse> reponsesPossibles75 = new ArrayList<Reponse>();
		reponsesPossibles75.add(reponse75a);
		reponsesPossibles75.add(reponse75b);
		reponsesPossibles75.add(reponse75c);
		reponsesPossibles75.add(reponse75d);
		String infoReponse75 = "C’est la troisieme lettre de l’alphabet grec, qui correspond au 'g' de notre alphabet.";
		
		// Question 76
		String imagePath76 = "image/defaut/defautQuestion.png";
		String videoPath76 = null;
		String question76 = "Le spectre visible se situe entre :";
		Reponse reponse76a = new Reponse("L'ultraviolet et l'infrarouge", true);
		Reponse reponse76b = new Reponse("Les rayons Gamma et les rayons X", false);
		Reponse reponse76c = new Reponse("Le rayons X et l'ultraviolet", false);
		Reponse reponse76d = new Reponse("L'infrarouge et les ondes radio", false);
		List<Reponse> reponsesPossibles76 = new ArrayList<Reponse>();
		reponsesPossibles76.add(reponse76a);
		reponsesPossibles76.add(reponse76b);
		reponsesPossibles76.add(reponse76c);
		reponsesPossibles76.add(reponse76d);
		String infoReponse76 = "Le spectre visible se situe entre 400 et 700 nanometres. Chaque couleur correspond a une certaine longueur d’onde.";
		
		// Question 77
		String imagePath77 = "image/defaut/defautQuestion.png";
		String videoPath77 = null;
		String question77 = "Si je refroidi une pastille en ceramique a -200 degre et que je met un aimant dessus, que se passe-t-il?";
		Reponse reponse77a = new Reponse("L'aimant levite", true);
		Reponse reponse77b = new Reponse("Rien", false);
		Reponse reponse77c = new Reponse("L'aimant est ejecte", false);
		Reponse reponse77d = new Reponse("L'aimant attire la ceramique", false);
		List<Reponse> reponsesPossibles77 = new ArrayList<Reponse>();
		reponsesPossibles77.add(reponse77a);
		reponsesPossibles77.add(reponse77b);
		reponsesPossibles77.add(reponse77c);
		reponsesPossibles77.add(reponse77d);
		String infoReponse77 = "Un supraconducteur est un materiau qui, lorsqu'il est refroidi en dessous d'une temperature critique, presente une resistance nulle et un diamagnetisme parfait.";
		
		// Question 78
		String imagePath78 = "image/defaut/defautQuestion.png";
		String videoPath78 = null;
		String question78 = "Plus on va vite :";
		Reponse reponse78a = new Reponse("Plus le temps ralenti", true);
		Reponse reponse78b = new Reponse("Plus le temps accelere", false);
		Reponse reponse78c = new Reponse("Plus la masse augmente", false);
		Reponse reponse78d = new Reponse("Plus la masse diminue", false);
		List<Reponse> reponsesPossibles78 = new ArrayList<Reponse>();
		reponsesPossibles78.add(reponse78a);
		reponsesPossibles78.add(reponse78b);
		reponsesPossibles78.add(reponse78c);
		reponsesPossibles78.add(reponse78d);
		String infoReponse78 = "Ainsi, apres un voyage dans l’espace a bord d’une fusee super rapide (10% de la vitesse de la lumiere), tu reviendrais chez toi plus jeune que tes potes restes sur Terre. Pendant ton sejour spatial, ta montre sera au ralenti, mais egalement tes fonctions biologiques : ton rythme cardiaque, le vieillissement de tes cellules, ...";
		
		// Question 79
		String imagePath79 = "image/defaut/defautQuestion.png";
		String videoPath79 = null;
		String question79 = "Un objet en mouvement peut-il depasser la vitesse de la lumiere?";
		Reponse reponse79a = new Reponse("Non", true);
		Reponse reponse79b = new Reponse("Oui, 3 fois", false);
		Reponse reponse79c = new Reponse("Oui, avec une acceleration continue", false);
		Reponse reponse79d = new Reponse("Oui, en jetant assez fort", false);
		List<Reponse> reponsesPossibles79 = new ArrayList<Reponse>();
		reponsesPossibles79.add(reponse79a);
		reponsesPossibles79.add(reponse79b);
		reponsesPossibles79.add(reponse79c);
		reponsesPossibles79.add(reponse79d);
		String infoReponse79 = "Selon la relativite restreinte, la vitesse de la lumiere dans le vide est la vitesse maximale que peuvent atteindre toutes formes de matiere ou d'information dans l'univers.";
		
		// Question 80
		String imagePath80 = "image/defaut/defautQuestion.png";
		String videoPath80 = null;
		String question80 = "La vitesse de la lumiere est d'environ?";
		Reponse reponse80a = new Reponse("300 000 km/s", true);
		Reponse reponse80b = new Reponse("300 000 m/s", false);
		Reponse reponse80c = new Reponse("300 000 km/h", false);
		Reponse reponse80d = new Reponse("300 000 m/h", false);
		List<Reponse> reponsesPossibles80 = new ArrayList<Reponse>();
		reponsesPossibles80.add(reponse80a);
		reponsesPossibles80.add(reponse80b);
		reponsesPossibles80.add(reponse80c);
		reponsesPossibles80.add(reponse80d);
		String infoReponse80 = "Sa valeur exacte est 299 792 458 m/s";
		
		// Question 81
		String imagePath81 = "image/defaut/defautQuestion.png";
		String videoPath81 = null;
		String question81 = "Pourquoi voit-on la lune la nuit?";
		Reponse reponse81a = new Reponse("Elle reflete la lumiere du soleil", true);
		Reponse reponse81b = new Reponse("Elle reflete la lumiere de la Terre", false);
		Reponse reponse81c = new Reponse("Elle genere sa propre lumiere", false);
		Reponse reponse81d = new Reponse("Elle reflete la lumiere des etoiles", false);
		List<Reponse> reponsesPossibles81 = new ArrayList<Reponse>();
		reponsesPossibles81.add(reponse81a);
		reponsesPossibles81.add(reponse81b);
		reponsesPossibles81.add(reponse81c);
		reponsesPossibles81.add(reponse81d);
		String infoReponse81 = "Comme les planetes du systeme solaire, on les voit car elles refletent la lumiere du soleil.";
		
		// Question 82
		String imagePath82 = "image/defaut/defautQuestion.png";
		String videoPath82 = null;
		String question82 = "Une fois dans le corps de la femme, les spermatozoides ont une duree de vie de :";
		Reponse reponse82a = new Reponse("2 a 5 jours", true);
		Reponse reponse82b = new Reponse("2 a 5 minutes", false);
		Reponse reponse82c = new Reponse("2 a 5 heures", false);
		Reponse reponse82d = new Reponse("2 a 5 semaines", false);
		List<Reponse> reponsesPossibles82 = new ArrayList<Reponse>();
		reponsesPossibles82.add(reponse82a);
		reponsesPossibles82.add(reponse82b);
		reponsesPossibles82.add(reponse82c);
		reponsesPossibles82.add(reponse82d);
		String infoReponse82 = "Ils perdent leur aptitude a feconder apres ce delai";
		
		// Question 83
		String imagePath83 = "image/defaut/defautQuestion.png";
		String videoPath83 = null;
		String question83 = "Une fois a l'air libre, les spermatozoides ont une duree de vie de :";
		Reponse reponse83a = new Reponse("30 minutes", true);
		Reponse reponse83b = new Reponse("30 jours", false);
		Reponse reponse83c = new Reponse("30 secondes", false);
		Reponse reponse83d = new Reponse("30 heures", false);
		List<Reponse> reponsesPossibles83 = new ArrayList<Reponse>();
		reponsesPossibles83.add(reponse83a);
		reponsesPossibles83.add(reponse83b);
		reponsesPossibles83.add(reponse83c);
		reponsesPossibles83.add(reponse83d);
		String infoReponse83 = "";
		
		// Question 84
		String imagePath84 = "image/defaut/defautQuestion.png";
		String videoPath84 = null;
		String question84 = "Si ils ne sont pas 'utilises' les spermatozoides vivent dans vos boules?";
		Reponse reponse84a = new Reponse("30 jours", true);
		Reponse reponse84b = new Reponse("30 mois", false);
		Reponse reponse84c = new Reponse("30 semaines", false);
		Reponse reponse84d = new Reponse("30 heures", false);
		List<Reponse> reponsesPossibles84 = new ArrayList<Reponse>();
		reponsesPossibles84.add(reponse84a);
		reponsesPossibles84.add(reponse84b);
		reponsesPossibles84.add(reponse84c);
		reponsesPossibles84.add(reponse84d);
		String infoReponse84 = "Apres ce delai, ils sont remplaces.";
		
		// Question 85
		String imagePath85 = "image/defaut/defautQuestion.png";
		String videoPath85 = null;
		String question85 = "Quelle est la moyenne mondiale d'un zgeg au repos?";
		Reponse reponse85a = new Reponse("7 a 10 cm", true);
		Reponse reponse85b = new Reponse("10 a 13 cm", false);
		Reponse reponse85c = new Reponse("4 a 7 cm", false);
		Reponse reponse85d = new Reponse("12 coudees", false);
		List<Reponse> reponsesPossibles85 = new ArrayList<Reponse>();
		reponsesPossibles85.add(reponse85a);
		reponsesPossibles85.add(reponse85b);
		reponsesPossibles85.add(reponse85c);
		reponsesPossibles85.add(reponse85d);
		String infoReponse85 = "La moyenne en erection allant de 12 a 16 cm. A vos regles.";
		
		// Question 86
		String imagePath86 = "image/defaut/defautQuestion.png";
		String videoPath86 = null;
		String question86 = "Le XXI eme siecle a commence le :";
		Reponse reponse86a = new Reponse("1er janvier 2001", true);
		Reponse reponse86b = new Reponse("1er janvier 2000", false);
		Reponse reponse86c = new Reponse("1er janvier 2100", false);
		Reponse reponse86d = new Reponse("1er janvier 1900", false);
		List<Reponse> reponsesPossibles86 = new ArrayList<Reponse>();
		reponsesPossibles86.add(reponse86a);
		reponsesPossibles86.add(reponse86b);
		reponsesPossibles86.add(reponse86c);
		reponsesPossibles86.add(reponse86d);
		String infoReponse86 = "";
		
		// Question 87
		String imagePath87 = "image/defaut/defautQuestion.png";
		String videoPath87 = null;
		String question87 = "Combien y a-t-il eu d'explosion de bombes nucleaires dans le monde?";
		Reponse reponse87a = new Reponse("Plus de 2000", true);
		Reponse reponse87b = new Reponse("2", false);
		Reponse reponse87c = new Reponse("Plus de 200", false);
		Reponse reponse87d = new Reponse("Plus de 20", false);
		List<Reponse> reponsesPossibles87 = new ArrayList<Reponse>();
		reponsesPossibles87.add(reponse87a);
		reponsesPossibles87.add(reponse87b);
		reponsesPossibles87.add(reponse87c);
		reponsesPossibles87.add(reponse87d);
		String infoReponse87 = "Tous les grands pays ayant l'arme nucleaire ont procede a des essais. La moitie des explosions officielles recensees, avec 1 050 explosions, ont eu lieu aux Etats-Unis suivies par l'Union sovietique avec 715 explosions officielles. La France est a la troisieme place avec 210 explosions.";
		
		// Question 88
		String imagePath88 = "image/defaut/defautQuestion.png";
		String videoPath88 = null;
		String question88 = "Si je suis sur la lune et que je lache un marteau et une plume en meme temps. Que se passe-t-il?";
		Reponse reponse88a = new Reponse("Ils touchent le sol en meme temps", true);
		Reponse reponse88b = new Reponse("Le marteau touche le sol en premier", false);
		Reponse reponse88c = new Reponse("La plume touche le sol en premier", false);
		Reponse reponse88d = new Reponse("Ca fait des chocapic", false);
		List<Reponse> reponsesPossibles88 = new ArrayList<Reponse>();
		reponsesPossibles88.add(reponse88a);
		reponsesPossibles88.add(reponse88b);
		reponsesPossibles88.add(reponse88c);
		reponsesPossibles88.add(reponse88d);
		String infoReponse88 = "En l'absence de frottements de l'air, les objets sont soumis a la meme attraction independamment de leur poids";
		
		// Question 89
		String imagePath89 = "image/defaut/defautQuestion.png";
		String videoPath89 = null;
		String question89 = "Si je suis en haut de la Tour Eiffel et que je lache un marteau et une plume en meme temps. Que se passe-t-il?";
		Reponse reponse89a = new Reponse("Ils touchent le sol en meme temps", false);
		Reponse reponse89b = new Reponse("Le marteau touche le sol en premier", true);
		Reponse reponse89c = new Reponse("La plume touche le sol en premier", false);
		Reponse reponse89d = new Reponse("Ils fusionnent lors de la chute", false);
		List<Reponse> reponsesPossibles89 = new ArrayList<Reponse>();
		reponsesPossibles89.add(reponse89a);
		reponsesPossibles89.add(reponse89b);
		reponsesPossibles89.add(reponse89c);
		reponsesPossibles89.add(reponse89d);
		String infoReponse89 = "La plume est enormement ralenti par les frottement de l'air.";
		
		// Question 90
		String imagePath90 = "image/defaut/defautQuestion.png";
		String videoPath90 = null;
		String question90 = "Si je lance un objet a 28 440 km/h, il :";
		Reponse reponse90a = new Reponse("Se met en orbite autour de la Terre", true);
		Reponse reponse90b = new Reponse("Sort de l'attraction terrestre", false);
		Reponse reponse90c = new Reponse("Retombe sur terre", false);
		Reponse reponse90d = new Reponse("Se desintegre dans l'atmosphere", false);
		List<Reponse> reponsesPossibles90 = new ArrayList<Reponse>();
		reponsesPossibles90.add(reponse90a);
		reponsesPossibles90.add(reponse90b);
		reponsesPossibles90.add(reponse90c);
		reponsesPossibles90.add(reponse90d);
		String infoReponse90 = "C'est la vitesse de satellisation minimale, soit la vitesse minimale qu'il faudrait theoriquement communiquer a un corps au depart d'un astre pour le satelliser au plus pres de ce dernier sur une orbite circulaire.";
		
		// Question 91
		String imagePath91 = "image/defaut/defautQuestion.png";
		String videoPath91 = null;
		String question91 = "A l'origine, Nintendo produisait :";
		Reponse reponse91a = new Reponse("Des cartes a jouer", true);
		Reponse reponse91b = new Reponse("Des vetements", false);
		Reponse reponse91c = new Reponse("Des jeux de societe", false);
		Reponse reponse91d = new Reponse("Des dessins animes", false);
		List<Reponse> reponsesPossibles91 = new ArrayList<Reponse>();
		reponsesPossibles91.add(reponse91a);
		reponsesPossibles91.add(reponse91b);
		reponsesPossibles91.add(reponse91c);
		reponsesPossibles91.add(reponse91d);
		String infoReponse91 = "C'est ensuite que la societe a diversifie ses activites en produisant des jouets et des bornes d’arcade.";
		
		// Question 92
		String imagePath92 = "image/defaut/defautQuestion.png";
		String videoPath92 = null;
		String question92 = "En 2016, quel pourcentage de la population mondiale detient la moitie des richesses de la planete?";
		Reponse reponse92a = new Reponse("1%", true);
		Reponse reponse92b = new Reponse("5%", false);
		Reponse reponse92c = new Reponse("10%", false);
		Reponse reponse92d = new Reponse("50%", false);
		List<Reponse> reponsesPossibles92 = new ArrayList<Reponse>();
		reponsesPossibles92.add(reponse92a);
		reponsesPossibles92.add(reponse92b);
		reponsesPossibles92.add(reponse92c);
		reponsesPossibles92.add(reponse92d);
		String infoReponse92 = "Les 62 personnes les plus riches detiennent plus que les 3,5 milliards les plus pauvres (62 / 3 500 000 000) )";

		// Question 93
		String imagePath93 = "image/defaut/defautQuestion.png";
		String videoPath93 = null;
		String question93 = "Combien de fois peut on plier une feuille au maximum?";
		Reponse reponse93a = new Reponse("7 fois", false);
		Reponse reponse93b = new Reponse("8 fois", false);
		Reponse reponse93c = new Reponse("100 fois", false);
		Reponse reponse93d = new Reponse("Il n'y a pas de limite", true);
		List<Reponse> reponsesPossibles93 = new ArrayList<Reponse>();
		reponsesPossibles93.add(reponse93a);
		reponsesPossibles93.add(reponse93b);
		reponsesPossibles93.add(reponse93c);
		reponsesPossibles93.add(reponse93d);
		String infoReponse93 = "Theoriquement, si la feuille est suffisament grande et qu'on a l'energie pour la plier, il n'y a pas de limite. Le record actuel est de 13 fois.";
		
		// Question 94
		String imagePath94 = "image/defaut/defautQuestion.png";
		String videoPath94 = null;
		String question94 = "Une annee lumiere est une unite de :";
		Reponse reponse94a = new Reponse("Distance", true);
		Reponse reponse94b = new Reponse("Temps", false);
		Reponse reponse94c = new Reponse("Vitesse", false);
		Reponse reponse94d = new Reponse("Force", false);
		List<Reponse> reponsesPossibles94 = new ArrayList<Reponse>();
		reponsesPossibles94.add(reponse94a);
		reponsesPossibles94.add(reponse94b);
		reponsesPossibles94.add(reponse94c);
		reponsesPossibles94.add(reponse94d);
		String infoReponse94 = "L'Union astronomique internationale la definit comme la distance parcourue par un photon (ou plus simplement la lumiere) dans le vide, en une annee julienne (soit 365,25 jours)";

		// Question 95
		String imagePath95 = "image/defaut/defautQuestion.png";
		String videoPath95 = null;
		String question95 = "Le ciel est bleu a cause :";
		Reponse reponse95a = new Reponse("De l'atmosphere", true);
		Reponse reponse95b = new Reponse("Des oceans", false);
		Reponse reponse95c = new Reponse("Du reflet de l'espace", false);
		Reponse reponse95d = new Reponse("Des nuages", false);
		List<Reponse> reponsesPossibles95 = new ArrayList<Reponse>();
		reponsesPossibles95.add(reponse95a);
		reponsesPossibles95.add(reponse95b);
		reponsesPossibles95.add(reponse95c);
		reponsesPossibles95.add(reponse95d);
		String infoReponse95 = "Le bleu du ciel est le resultat de la diffusion de la lumiere solaire par l'atmosphere.";

		// Question 96
		String imagePath96 = "image/defaut/defautQuestion.png";
		String videoPath96 = null;
		String question96 = "Quelle est la couleur du soleil?";
		Reponse reponse96a = new Reponse("Blanc aryen", true);
		Reponse reponse96b = new Reponse("Jaune poussin", false);
		Reponse reponse96c = new Reponse("Orange grenadine", false);
		Reponse reponse96d = new Reponse("Rouge regles", false);
		List<Reponse> reponsesPossibles96 = new ArrayList<Reponse>();
		reponsesPossibles96.add(reponse96a);
		reponsesPossibles96.add(reponse96b);
		reponsesPossibles96.add(reponse96c);
		reponsesPossibles96.add(reponse96d);
		String infoReponse96 = "C'est la diffusion des rayons du soleil dans l'atmosphere qui donne la couleur jaune";
		
		// Question 97
		String imagePath97 = "image/defaut/defautQuestion.png";
		String videoPath97 = null;
		String question97 = "La celebre Joconde de Leonard De Vinci est peinte avec :";
		Reponse reponse97a = new Reponse("De la peinture a l'huile sur un panneau de bois", true);
		Reponse reponse97b = new Reponse("De la peinture acrylique sur une toile en soie", false);
		Reponse reponse97c = new Reponse("De la peinture a l'eau sur une toile en chanvre", false);
		Reponse reponse97d = new Reponse("Du sperme sur une toile en peau de couille", false);
		List<Reponse> reponsesPossibles97 = new ArrayList<Reponse>();
		reponsesPossibles97.add(reponse97a);
		reponsesPossibles97.add(reponse97b);
		reponsesPossibles97.add(reponse97c);
		reponsesPossibles97.add(reponse97d);
		String infoReponse97 = "";
		
		// Question 98
		String imagePath98 = "image/defaut/defautQuestion.png";
		String videoPath98 = null;
		String question98 = "Le pere noel est habille en rouge a cause :";
		Reponse reponse98a = new Reponse("De la culture populaire", true);
		Reponse reponse98b = new Reponse("De Coca Cola", false);
		Reponse reponse98c = new Reponse("De l'eglise", false);
		Reponse reponse98d = new Reponse("Des Femen", false);
		List<Reponse> reponsesPossibles98 = new ArrayList<Reponse>();
		reponsesPossibles98.add(reponse98a);
		reponsesPossibles98.add(reponse98b);
		reponsesPossibles98.add(reponse98c);
		reponsesPossibles98.add(reponse98d);
		String infoReponse98 = "Il a d’abord ete dessine par Thomas Nast en 1863, a l'origine en monochrome. Plusieurs colorations anonymes de ses dessins, vertes, rouges ou bleues, ont commence a emerger, jusqu’a ce que le rouge devienne majoritaire. Lorsque Coca-Cola commenca a l’utiliser dans les annees 1930, son image etait deja courante dans les medias et la culture populaire.";
		
		// Question 99
		String imagePath99 = "image/defaut/defautQuestion.png";
		String videoPath99 = null;
		String question99 = "En 2010, il restera pendant 3 mois a la premiere place des singles en France avec 'Mignon, mignon'. Le celebre Rene est ";
		Reponse reponse99a = new Reponse("Une marmotte", true);
		Reponse reponse99b = new Reponse("Une taupe", false);
		Reponse reponse99c = new Reponse("Un castor", false);
		Reponse reponse99d = new Reponse("Une chatte", false);
		List<Reponse> reponsesPossibles99 = new ArrayList<Reponse>();
		reponsesPossibles99.add(reponse99a);
		reponsesPossibles99.add(reponse99b);
		reponsesPossibles99.add(reponse99c);
		reponsesPossibles99.add(reponse99d);
		String infoReponse99 = "Le design est bien plus proche d'une marmotte que d'une taupe";
		
		// Question 100
		String imagePath100 = "image/defaut/defautQuestion.png";
		String videoPath100 = null;
		String question100 = "Vu de la Terre, la taille de la Lune par rapport au Soleil est :";
		Reponse reponse100a = new Reponse("Quasiment la meme", true);
		Reponse reponse100b = new Reponse("Tres Inferieur", false);
		Reponse reponse100c = new Reponse("Tres Superieur", false);
		Reponse reponse100d = new Reponse("Posterieur", false);
		List<Reponse> reponsesPossibles100 = new ArrayList<Reponse>();
		reponsesPossibles100.add(reponse100a);
		reponsesPossibles100.add(reponse100b);
		reponsesPossibles100.add(reponse100c);
		reponsesPossibles100.add(reponse100d);
		String infoReponse100 = "La distance de la Terre au Soleil varie suivant l'annee, mais ceci a un faible impact. En moyenne, la Lune parait legerement plus petite que le Soleil, ainsi la majorite des eclipses centrales sont annulaires.";
		
		// Question 101
		String imagePath101 = "image/defaut/defautQuestion.png";
		String videoPath101 = null;
		String question101 = "Cleopatre a vecu a une epoque plus proche de :";
		Reponse reponse101a = new Reponse("L'invention du telephone", true);
		Reponse reponse101b = new Reponse("L'erection des pyramides", false);
		Reponse reponse101c = new Reponse("La naissance des dinosaures", false);
		Reponse reponse101d = new Reponse("La creation de l'ecriture", false);
		List<Reponse> reponsesPossibles101 = new ArrayList<Reponse>();
		reponsesPossibles101.add(reponse101a);
		reponsesPossibles101.add(reponse101b);
		reponsesPossibles101.add(reponse101c);
		reponsesPossibles101.add(reponse101d);
		String infoReponse101 = "En effet, Cleopatre a vecu entre 69 avavt JC. et 30 avant JC. Les grandes pyramides d’Egypte ont ete construites aux alentours de 2560 avant JC. L'iPhone a ete invente en 2007.";
		
		// Question 102
		String imagePath102 = "image/defaut/defautQuestion.png";
		String videoPath102 = null;
		String question102 = "Cleopatre etait d'origine :";
		Reponse reponse102a = new Reponse("Grecque", true);
		Reponse reponse102b = new Reponse("Egyptienne", false);
		Reponse reponse102c = new Reponse("Romaine", false);
		Reponse reponse102d = new Reponse("Gauloise", false);
		List<Reponse> reponsesPossibles102 = new ArrayList<Reponse>();
		reponsesPossibles102.add(reponse102a);
		reponsesPossibles102.add(reponse102b);
		reponsesPossibles102.add(reponse102c);
		reponsesPossibles102.add(reponse102d);
		String infoReponse102 = "Elle appartient a la dynastie d'origine macedonienne des Lagides qui est typiquement grecque et se reclame comme telle.";
		
		// Question 103
		String imagePath103 = "image/defaut/defautQuestion.png";
		String videoPath103 = null;
		String question103 = "Le T-Rex a vecu a une epoque plus proche :";
		Reponse reponse103a = new Reponse("Des premiers hommes", true);
		Reponse reponse103b = new Reponse("Du premier Stegosaure", false);
		Reponse reponse103c = new Reponse("De la separation de l'Afrique et l'Amerique du Sud", false);
		Reponse reponse103d = new Reponse("Des premieres meduses", false);
		List<Reponse> reponsesPossibles103 = new ArrayList<Reponse>();
		reponsesPossibles103.add(reponse103a);
		reponsesPossibles103.add(reponse103b);
		reponsesPossibles103.add(reponse103c);
		reponsesPossibles103.add(reponse103d);
		String infoReponse103 = "Le Stegosaure a vecu entre 156 et 140 millions d’annees avant notre ere alors que le T-Rex aurait vecu il y a environ 65 a 70 millions d'annees. Ce qui rapproche plus le T-Rex de notre ere que de celle du Stegosaure.";
		
		// Question 104
		String imagePath104 = "image/defaut/defautQuestion.png";
		String videoPath104 = null;
		String question104 = "En proportion, il y a pour chaque humain sur Terre :";
		Reponse reponse104a = new Reponse("1,6 million de fourmis", true);
		Reponse reponse104b = new Reponse("160 000 fourmis", false);
		Reponse reponse104c = new Reponse("16 000 fourmis", false);
		Reponse reponse104d = new Reponse("160 fourmis", false);
		List<Reponse> reponsesPossibles104 = new ArrayList<Reponse>();
		reponsesPossibles104.add(reponse104a);
		reponsesPossibles104.add(reponse104b);
		reponsesPossibles104.add(reponse104c);
		reponsesPossibles104.add(reponse104d);
		String infoReponse104 = "En considerant qu’il existe 3 millions d’especes (dont 1 million seulement sont connues aujourd’hui). Il y aurait plus d’un milliard de milliards de fourmis sur Terre.";
		
		// Question 105
		String imagePath105 = "image/defaut/defautQuestion.png";
		String videoPath105 = null;
		String question105 = "Dans son celebre jeu, lorsqu'il saute, Mario casse les blocs avec :";
		Reponse reponse105a = new Reponse("La main", true);
		Reponse reponse105b = new Reponse("La tete", false);
		Reponse reponse105c = new Reponse("Le pied", false);
		Reponse reponse105d = new Reponse("La moustache", false);
		List<Reponse> reponsesPossibles105 = new ArrayList<Reponse>();
		reponsesPossibles105.add(reponse105a);
		reponsesPossibles105.add(reponse105b);
		reponsesPossibles105.add(reponse105c);
		reponsesPossibles105.add(reponse105d);
		String infoReponse105 = "";
		
		// Question 106
		String imagePath106 = "image/defaut/defautQuestion.png";
		String videoPath106 = null;
		String question106 = "Pourquoi les ouragans portent-ils des noms de personne?";
		Reponse reponse106a = new Reponse("A cause des politiciens", true);
		Reponse reponse106b = new Reponse("A cause des religieux", false);
		Reponse reponse106c = new Reponse("A cause des scientifiques", false);
		Reponse reponse106d = new Reponse("A cause des femmes", false);
		List<Reponse> reponsesPossibles106 = new ArrayList<Reponse>();
		reponsesPossibles106.add(reponse106a);
		reponsesPossibles106.add(reponse106b);
		reponsesPossibles106.add(reponse106c);
		reponsesPossibles106.add(reponse106d);
		String infoReponse106 = "Les cyclones et les ouragans portent le nom de personnes en raison de Clement Wragge, un meteorologue qui utilisait les noms de politiciens qu'il n'aimait pas pour leur signifier qu'ils etaient destructeurs et qu'ils erraient sans but.";
		
		
		// Question 107
		String imagePath107 = "image/defaut/defautQuestion.png";
		String videoPath107 = null;
		String question107 = "Quel animal a la morsure la plus puissante?";
		Reponse reponse107a = new Reponse("Le crocodile", true);
		Reponse reponse107b = new Reponse("Le requin", false);
		Reponse reponse107c = new Reponse("Le morse", false);
		Reponse reponse107d = new Reponse("Le cachalot", false);
		List<Reponse> reponsesPossibles107 = new ArrayList<Reponse>();
		reponsesPossibles107.add(reponse107a);
		reponsesPossibles107.add(reponse107b);
		reponsesPossibles107.add(reponse107c);
		reponsesPossibles107.add(reponse107d);
		String infoReponse107 = "Avec une machoire capable d'exercer une pression de plus de 2 tonnes, c'est le grand gagnant.";
		
		// Question 108
		String imagePath108 = "image/defaut/defautQuestion.png";
		String videoPath108 = null;
		String question108 = "Sur ces 243 annees d'existences les Etats Unis ont ete en guerre :";
		Reponse reponse108a = new Reponse("222 annees", true);
		Reponse reponse108b = new Reponse("243 annees", false);
		Reponse reponse108c = new Reponse("107 annees", false);
		Reponse reponse108d = new Reponse("27 annees", false);
		List<Reponse> reponsesPossibles108 = new ArrayList<Reponse>();
		reponsesPossibles108.add(reponse108a);
		reponsesPossibles108.add(reponse108b);
		reponsesPossibles108.add(reponse108c);
		reponsesPossibles108.add(reponse108d);
		String infoReponse108 = "Le pays n’a ete en paix que 21 ans depuis sa creation en 1776.";
		
		// Question 109
		String imagePath109 = "image/defaut/defautQuestion.png";
		String videoPath109 = null;
		String question109 = "Que represente une annee?";
		Reponse reponse109a = new Reponse("La Terre fait un tour de Soleil", true);
		Reponse reponse109b = new Reponse("Le Soleil fait 365,25 tours de Terre", false);
		Reponse reponse109c = new Reponse("La Lune fait 12 tours de Terre", false);
		Reponse reponse109d = new Reponse("Le Soleil fait un tour de Terre", false);
		List<Reponse> reponsesPossibles109 = new ArrayList<Reponse>();
		reponsesPossibles109.add(reponse109a);
		reponsesPossibles109.add(reponse109b);
		reponsesPossibles109.add(reponse109c);
		reponsesPossibles109.add(reponse109d);
		String infoReponse109 = "La Terre met 365,2422 jours exactement a faire le tour du Soleil";
		
		// Questions Burger Quizz
		// Idees recus / legendes urbaines
		// Faits extraordinaires
		
		
		// Qu'est-ce que c'est ???
		// Sable au microscope : Pierres precieuses, etre vivants, des mini-bonbons?
		
		// Faim / Soif / Sante / Richesses
		
		// Politique
		// Quelle personnalité est presente sur la pochette de l'album des Beatlles ()? Aleister Crowley
		
		// Ecologie
		
		// Energies
		
		// Guerres
		// Nombre de pays ou les etats unis sont implanté militairement =74/324 (France 10, Royaume Unis 7) (source : https://reseauinternational.net/tous-les-pays-ou-les-etats-unis-ont-une-presence-militaire/)
		
		//Culture générale
		
		// Decouvertes
		// Tesla
		// Homme
		//
		
		enigmesInconnus.add(new Enigme(imagePath1, videoPath1, question1, reponsesPossibles1, infoReponse1, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath2, videoPath2, question2, reponsesPossibles2, infoReponse2, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath3, videoPath3, question3, reponsesPossibles3, infoReponse3, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath4, videoPath4, question4, reponsesPossibles4, infoReponse4, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath5, videoPath5, question5, reponsesPossibles5, infoReponse5, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath6, videoPath6, question6, reponsesPossibles6, infoReponse6, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath7, videoPath7, question7, reponsesPossibles7, infoReponse7, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath8, videoPath8, question8, reponsesPossibles8, infoReponse8, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath9, videoPath9, question9, reponsesPossibles9, infoReponse9, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath10, videoPath10, question10, reponsesPossibles10, infoReponse10, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath11, videoPath11, question11, reponsesPossibles11, infoReponse11, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath12, videoPath12, question12, reponsesPossibles12, infoReponse12, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath13, videoPath13, question13, reponsesPossibles13, infoReponse13, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath14, videoPath14, question14, reponsesPossibles14, infoReponse14, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath15, videoPath15, question15, reponsesPossibles15, infoReponse15, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath16, videoPath16, question16, reponsesPossibles16, infoReponse16, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath17, videoPath17, question17, reponsesPossibles17, infoReponse17, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath18, videoPath18, question18, reponsesPossibles18, infoReponse18, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath19, videoPath19, question19, reponsesPossibles19, infoReponse19, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath20, videoPath20, question20, reponsesPossibles20, infoReponse20, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath21, videoPath21, question21, reponsesPossibles21, infoReponse21, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath22, videoPath22, question22, reponsesPossibles22, infoReponse22, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath23, videoPath23, question23, reponsesPossibles23, infoReponse23, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath24, videoPath24, question24, reponsesPossibles24, infoReponse24, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath25, videoPath25, question25, reponsesPossibles25, infoReponse25, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath26, videoPath26, question26, reponsesPossibles26, infoReponse26, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath27, videoPath27, question27, reponsesPossibles27, infoReponse27, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath28, videoPath28, question28, reponsesPossibles28, infoReponse28, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath29, videoPath29, question29, reponsesPossibles29, infoReponse29, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath30, videoPath30, question30, reponsesPossibles30, infoReponse30, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath31, videoPath31, question31, reponsesPossibles31, infoReponse31, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath32, videoPath32, question32, reponsesPossibles32, infoReponse32, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath33, videoPath33, question33, reponsesPossibles33, infoReponse33, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath34, videoPath34, question34, reponsesPossibles34, infoReponse34, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath35, videoPath35, question35, reponsesPossibles35, infoReponse35, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath36, videoPath36, question36, reponsesPossibles36, infoReponse36, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath37, videoPath37, question37, reponsesPossibles37, infoReponse37, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath38, videoPath38, question38, reponsesPossibles38, infoReponse38, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath39, videoPath39, question39, reponsesPossibles39, infoReponse39, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath40, videoPath40, question40, reponsesPossibles40, infoReponse40, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath41, videoPath41, question41, reponsesPossibles41, infoReponse41, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath42, videoPath42, question42, reponsesPossibles42, infoReponse42, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath43, videoPath43, question43, reponsesPossibles43, infoReponse43, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath44, videoPath44, question44, reponsesPossibles44, infoReponse44, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath45, videoPath45, question45, reponsesPossibles45, infoReponse45, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath46, videoPath46, question46, reponsesPossibles46, infoReponse46, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath47, videoPath47, question47, reponsesPossibles47, infoReponse47, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath48, videoPath48, question48, reponsesPossibles48, infoReponse48, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath49, videoPath49, question49, reponsesPossibles49, infoReponse49, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath50, videoPath50, question50, reponsesPossibles50, infoReponse50, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath51, videoPath51, question51, reponsesPossibles51, infoReponse51, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath52, videoPath52, question52, reponsesPossibles52, infoReponse52, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath53, videoPath53, question53, reponsesPossibles53, infoReponse53, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath54, videoPath54, question54, reponsesPossibles54, infoReponse54, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath55, videoPath55, question55, reponsesPossibles55, infoReponse55, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath56, videoPath56, question56, reponsesPossibles56, infoReponse56, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath57, videoPath57, question57, reponsesPossibles57, infoReponse57, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath58, videoPath58, question58, reponsesPossibles58, infoReponse58, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath59, videoPath59, question59, reponsesPossibles59, infoReponse59, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath60, videoPath60, question60, reponsesPossibles60, infoReponse60, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath61, videoPath61, question61, reponsesPossibles61, infoReponse61, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath62, videoPath62, question62, reponsesPossibles62, infoReponse62, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath63, videoPath63, question63, reponsesPossibles63, infoReponse63, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath64, videoPath64, question64, reponsesPossibles64, infoReponse64, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath65, videoPath65, question65, reponsesPossibles65, infoReponse65, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath66, videoPath66, question66, reponsesPossibles66, infoReponse66, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath67, videoPath67, question67, reponsesPossibles67, infoReponse67, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath68, videoPath68, question68, reponsesPossibles68, infoReponse68, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath69, videoPath69, question69, reponsesPossibles69, infoReponse69, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath70, videoPath70, question70, reponsesPossibles70, infoReponse70, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath71, videoPath71, question71, reponsesPossibles71, infoReponse71, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath72, videoPath72, question72, reponsesPossibles72, infoReponse72, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath73, videoPath73, question73, reponsesPossibles73, infoReponse73, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath74, videoPath74, question74, reponsesPossibles74, infoReponse74, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath75, videoPath75, question75, reponsesPossibles75, infoReponse75, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath76, videoPath76, question76, reponsesPossibles76, infoReponse76, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath77, videoPath77, question77, reponsesPossibles77, infoReponse77, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath78, videoPath78, question78, reponsesPossibles78, infoReponse78, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath79, videoPath79, question79, reponsesPossibles79, infoReponse79, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath80, videoPath80, question80, reponsesPossibles80, infoReponse80, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath81, videoPath81, question81, reponsesPossibles81, infoReponse81, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath82, videoPath82, question82, reponsesPossibles82, infoReponse82, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath83, videoPath83, question83, reponsesPossibles83, infoReponse83, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath84, videoPath84, question84, reponsesPossibles84, infoReponse84, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath85, videoPath85, question85, reponsesPossibles85, infoReponse85, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath86, videoPath86, question86, reponsesPossibles86, infoReponse86, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath87, videoPath87, question87, reponsesPossibles87, infoReponse87, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath88, videoPath88, question88, reponsesPossibles88, infoReponse88, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath89, videoPath89, question89, reponsesPossibles89, infoReponse89, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath90, videoPath90, question90, reponsesPossibles90, infoReponse90, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath91, videoPath91, question91, reponsesPossibles91, infoReponse91, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath92, videoPath92, question92, reponsesPossibles92, infoReponse92, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath93, videoPath93, question93, reponsesPossibles93, infoReponse93, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath94, videoPath94, question94, reponsesPossibles94, infoReponse94, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath95, videoPath95, question95, reponsesPossibles95, infoReponse95, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath96, videoPath96, question96, reponsesPossibles96, infoReponse96, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath97, videoPath97, question97, reponsesPossibles97, infoReponse97, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath98, videoPath98, question98, reponsesPossibles98, infoReponse98, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath99, videoPath99, question99, reponsesPossibles99, infoReponse99, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath100, videoPath100, question100, reponsesPossibles100, infoReponse100, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath101, videoPath101, question101, reponsesPossibles101, infoReponse101, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath102, videoPath102, question102, reponsesPossibles102, infoReponse102, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath103, videoPath103, question103, reponsesPossibles103, infoReponse103, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath104, videoPath104, question104, reponsesPossibles104, infoReponse104, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath105, videoPath105, question105, reponsesPossibles105, infoReponse105, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath106, videoPath106, question106, reponsesPossibles106, infoReponse106, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath107, videoPath107, question107, reponsesPossibles107, infoReponse107, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath108, videoPath108, question108, reponsesPossibles108, infoReponse108, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath109, videoPath109, question109, reponsesPossibles109, infoReponse109, TypeEnigme.ECOLE));
		
	}

	public Enigme getRandomEnigmeDisponible(Difficulte difficulty) {
		
		Enigme enigme = null;
		
		// TODO gestion difficulte
		
		// Gestion rotation enigmes deja poses / deja resolus
		testFinEnigmes(); 
		
		enigme = enigmesInconnus.get(RandomManager.random(0, enigmesInconnus.size()-1));
		
		// Refresh Liste enigmes poses
		enigmesConnus.add(enigme);
		enigmesInconnus.remove(enigme);
		
		return enigme;
	}

	private void testFinEnigmes() {
		// Si toutes les enigmes ont ete poses au moins une fois
		if (enigmesInconnus.isEmpty()) {
			System.out.println("Toutes les enigmes on ete poses au moins une fois");
			// Si il reste des enigmes non resolus 
			if (!enigmesConnus.isEmpty()) {
				// On repose les enigmes non resolus
				System.out.println("On repose les enigmes non resolus");
				enigmesInconnus.addAll(enigmesConnus);
				enigmesConnus.removeAll(enigmesInconnus);
			// Si toutes les enigmes ont ete resolus au moins une fois
			} else {
				// TODO Achievement TOUTE LES ENIGMES RESOLUS => recompenses
				System.out.println("Achievement TOUTE LES ENIGMES RESOLUS");
				// On repose toutes les enigmes
				enigmesInconnus.addAll(enigmesResolus);
				enigmesResolus.removeAll(enigmesInconnus);
			}
		}
	}

	public void refreshEnigme(Enigme enigme, boolean win) {
		// Refresh Liste enigmes resolus
		if (win) {
			enigmesConnus.remove(enigme);
			enigmesResolus.add(enigme);
			testFinEnigmes(); 
		} 
	}

}
