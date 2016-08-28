package modele.item.personnage;

import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import modele.competence.Competence;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.lieu.Lieu;
import modele.item.media.audio.Musique;
import modele.item.media.audio.Son;

public class PersonnagePrincipal { //extends Item {
	
	private String nom;
	private PersoPrenom prenom;
	private String surnomPrincipal;
	private List<String> surnoms;
	private List<String> particularitesPhysique;
	private List<String> particularitesSocial;
	private List<String> phrasesPerso;
	private ImageIcon photoPrincipal;
	private List<ImageIcon> photos;
	
	private List<Pouvoir> pouvoirs;
	private List<Objectif> objectifs;
	private List<MomentCle> momentsCle;
	private List<PersonnageEnnemi> boss;
	private List<PersonnageSecondaire> connaissances;
	private List<Son> sons;
	private List<Musique> musiques;
	private List<Item> sac;
	private Lieu domicile;
	private Competence competence;
	private boolean available;

	public PersonnagePrincipal(String nom, PersoPrenom prenom, String surnomPrincipal, List<String> surnoms,
			List<String> particularitesPhysique, List<String> particularitesSocial, List<String> phrasesPerso,
			ImageIcon photoPrincipal, List<ImageIcon> photos, List<Pouvoir> pouvoirs, List<Objectif> objectifs,
			List<MomentCle> momentsCle, List<PersonnageEnnemi> boss, List<PersonnageSecondaire> connaissances,
			List<Son> sons, List<Musique> musiques, List<Item> sac, Lieu domicile, Competence competence,
			boolean available) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.surnomPrincipal = surnomPrincipal;
		this.surnoms = surnoms;
		this.particularitesPhysique = particularitesPhysique;
		this.particularitesSocial = particularitesSocial;
		this.phrasesPerso = phrasesPerso;
		this.photoPrincipal = photoPrincipal;
		this.photos = photos;
		this.pouvoirs = pouvoirs;
		this.objectifs = objectifs;
		this.momentsCle = momentsCle;
		this.boss = boss;
		this.connaissances = connaissances;
		this.sons = sons;
		this.musiques = musiques;
		this.sac = sac;
		this.domicile = domicile;
		this.competence = competence;
		this.available = available;
	}

	public void addCompetences(Map<PersoStat, Integer> map) {
		// On recupere les stats du perso
		Map<PersoStat, Integer> statsPerso = competence.getStats();
		
		// Pour chaque stat
		for (PersoStat stat : statsPerso.keySet()) {
			
			// Si cette stat est modifiée
			if (map.containsKey(stat)) {
				
				// On la modifie
				Integer valeurStat = statsPerso.get(stat);
				Integer valeurAAJouter = map.get(stat);
				Integer valeurModifie = valeurStat + valeurAAJouter;
				// On met a jour les stats du perso
				statsPerso.put(stat, valeurModifie);				
			}
		}
	}
	
	public String getNom() {
		return nom;
	}

	public PersoPrenom getPrenom() {
		return prenom;
	}

	public String getSurnomPrincipal() {
		return surnomPrincipal;
	}

	public List<String> getSurnoms() {
		return surnoms;
	}

	public List<String> getParticularitesPhysique() {
		return particularitesPhysique;
	}

	public List<String> getParticularitesSocial() {
		return particularitesSocial;
	}

	public List<String> getPhrasesPerso() {
		return phrasesPerso;
	}

	public ImageIcon getPhotoPrincipal() {
		return photoPrincipal;
	}

	public List<ImageIcon> getPhotos() {
		return photos;
	}

	public List<Pouvoir> getPouvoirs() {
		return pouvoirs;
	}

	public List<Objectif> getObjectifs() {
		return objectifs;
	}

	public List<MomentCle> getMomentsCle() {
		return momentsCle;
	}

	public List<PersonnageEnnemi> getBoss() {
		return boss;
	}

	public List<PersonnageSecondaire> getConnaissances() {
		return connaissances;
	}

	public List<Son> getSons() {
		return sons;
	}

	public List<Musique> getMusiques() {
		return musiques;
	}

	public List<Item> getSac() {
		return sac;
	}

	public Lieu getDomicile() {
		return domicile;
	}

	public Competence getCompetence() {
		return competence;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
