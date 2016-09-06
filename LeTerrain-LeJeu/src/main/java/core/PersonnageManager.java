package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import modele.competence.Competence;
import modele.item.Item;
import modele.item.lieu.Lieu;
import modele.item.media.audio.Musique;
import modele.item.media.audio.Son;
import modele.item.personnage.Groupe;
import modele.item.personnage.MomentCle;
import modele.item.personnage.Objectif;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnageEnnemi;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;
import modele.item.personnage.Pouvoir;

public class PersonnageManager implements Serializable {

	// Need PouvoirManager instancie avant
	
	private static final long serialVersionUID = 1L;
	
	private Groupe leGroupe;
	private List<PersonnageSecondaire> personnagesSecondaires;

	public void initialise() {

		leGroupe = new Groupe();

		// Chargement des personnages Principaux
		
		ImageIcon iconNicolas = new ImageIcon("src/main/resources/image/nico petit.png");
		ImageIcon iconPierre = new ImageIcon("src/main/resources/image/pierre petit.png");
		ImageIcon iconYannick = new ImageIcon("src/main/resources/image/yannick petit.png");
		ImageIcon iconThomas = new ImageIcon("src/main/resources/image/thomas petit.png");
		ImageIcon iconJohann = new ImageIcon("src/main/resources/image/johann petit.png");
		ImageIcon iconAli = new ImageIcon("src/main/resources/image/ali.png");
		ImageIcon iconGuillaume = new ImageIcon("src/main/resources/image/guillaume.png");
		ImageIcon iconJonathan = new ImageIcon("src/main/resources/image/jonathan.png");
		
		PersonnagePrincipal johann = new PersonnagePrincipal(PersoNom.AVELINE, PersoPrenom.JOHANN, "Yo", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), iconJohann, new ArrayList<ImageIcon>(), new ArrayList<Pouvoir>(), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), new Lieu(), new Competence(), true);
		PersonnagePrincipal nicolas = new PersonnagePrincipal(PersoNom.LOPEZ, PersoPrenom.NICOLAS, "Nico",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconNicolas, new ArrayList<ImageIcon>(), new ArrayList<Pouvoir>(), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), new Lieu(), new Competence(), true);
		PersonnagePrincipal pierre = new PersonnagePrincipal(PersoNom.SERMAIN, PersoPrenom.PIERRE, "Pip", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconPierre, new ArrayList<ImageIcon>(), new ArrayList<Pouvoir>(), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), new Lieu(), new Competence(), true);
		PersonnagePrincipal thomas = new PersonnagePrincipal(PersoNom.DARMOUNI, PersoPrenom.THOMAS, "Darm", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconThomas, new ArrayList<ImageIcon>(), new ArrayList<Pouvoir>(), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), new Lieu(), new Competence(), true);
		PersonnagePrincipal yannick = new PersonnagePrincipal(PersoNom.BERCOT, PersoPrenom.YANNICK, "Ya", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconYannick, new ArrayList<ImageIcon>(), new ArrayList<Pouvoir>(), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), new Lieu(), new Competence(), true);
		PersonnagePrincipal ali = new PersonnagePrincipal(PersoNom.CHAUDHRY, PersoPrenom.ALI, "Ali", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconAli, new ArrayList<ImageIcon>(), new ArrayList<Pouvoir>(), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), new Lieu(), new Competence(), true);
		PersonnagePrincipal guillaume = new PersonnagePrincipal(PersoNom.BURGUET, PersoPrenom.GUILLAUME, "Guy", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconGuillaume, new ArrayList<ImageIcon>(), new ArrayList<Pouvoir>(), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), new Lieu(), new Competence(), true);
		PersonnagePrincipal jonathan = new PersonnagePrincipal(PersoNom.RUSCITO, PersoPrenom.JONATHAN, "Russ", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconJonathan, new ArrayList<ImageIcon>(), new ArrayList<Pouvoir>(), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), new Lieu(), new Competence(), true);
		
		leGroupe.ajoutePerso(johann);
		leGroupe.ajoutePerso(nicolas);
		leGroupe.ajoutePerso(pierre);
		leGroupe.ajoutePerso(thomas);
		leGroupe.ajoutePerso(yannick);
		leGroupe.ajoutePerso(ali);
		leGroupe.ajoutePerso(guillaume);
		leGroupe.ajoutePerso(jonathan);

		// Chargement des personnages Secondaires
		personnagesSecondaires = new ArrayList<PersonnageSecondaire>();
		PersonnageSecondaire barbara = new PersonnageSecondaire();
		
		personnagesSecondaires.add(barbara);
		
	}

	public PersonnagePrincipal getPersoByNom(PersoPrenom nom) {
		return leGroupe.getPersoByNom(nom);
	}

	public Groupe getLeGroupe() {
		return leGroupe;
	}

	public List<PersonnageSecondaire> getPersonnagesSecondaires() {
		return personnagesSecondaires;
	}

}
