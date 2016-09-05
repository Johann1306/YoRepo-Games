package modele.item.personnage;

import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;

public class PersonnageSecondaire implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean available;
	private String nom;
	private String prenom;
	private String surnomPrincipal;
	private List<String> surnoms;
	private List<String> particularitesPhysique;
	private List<String> particularitesSocial;
	private List<String> phrasesPerso;
	private ImageIcon photoPrincipal;
	private List<ImageIcon> photos;	
	private List<Pouvoir> pouvoirs;

	

}
