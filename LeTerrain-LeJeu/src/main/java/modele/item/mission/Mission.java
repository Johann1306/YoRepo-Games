package modele.item.mission;

import java.util.Date;
import java.util.List;

import core.DateManager;
import core.NomJeu;
import modele.bonus.Bonus;
import modele.item.Item;
import modele.item.lieu.Lieu;
import modele.item.mission.enums.MissionDifficulty;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;

/**
 * 
 * @author Johann
 * 
 *         Exemple de mission : (jouer a la deli delo)
 * 
 *         nom : La Deli Delo chanceVictoire : 70% conditionsEntree : Connaitre
 *         une fille / savoir courir conditionVictoire : toucher quelqu'un
 *         conditionDefaite : tomber / se faire toucher objectif : battre
 *         l'autre equipe bonus : +agilite/+vitesse/+connaissances filles malus
 *         : -agilite/-vitesse/-confiance gain : 1 perte : 1 gainMax : 2
 *         perteMax : 2 personnagesRequis : Un personnagesInterdits : thomas
 *         (trop physique) personnagesSecondaires : Tous itemsNecessaires :
 *         itemsDebloques :
 * 
 **/
public class Mission {

	private int id;
	private String nom;
	private String informations;
	private List<String> imagePaths;
	private List<String> sonPaths;
	private List<String> videoPaths;
	private PersoPrenom proprietaire;
	private Lieu lieu;
	private int chanceVictoire;
	private String conditionVictoire;
	private String conditionDefaite;
	private String objectif;
	private Bonus gain;
	private Bonus perte;
	private int gainMax;
	private int perteMax;
	private Date date;
	private MissionType type;
	private MissionDifficulty difficulty;
	private List<NomJeu> jeux;
	private List<PersonnagePrincipal> personnagesRequis;
	private List<PersonnagePrincipal> personnagesInterdits;
	private List<PersonnageSecondaire> personnagesSecondaires;
	private List<Item> itemsNecessaires;
	private List<Item> itemsDebloques;
	private boolean isDisponible = false;
	private boolean isRepetable = false;
	private boolean isDejaFaite = false;
	private boolean isDejaPresentee = false;
	private int nombreEssai;
	private int nombreWin;

	public Mission(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths,
			List<String> videoPaths, PersoPrenom proprietaire, Lieu lieu, int chanceVictoire, String conditionVictoire,
			String conditionDefaite, String objectif, Bonus gain, Bonus perte, int gainMax, int perteMax, Date date,
			MissionType type, MissionDifficulty difficulty, List<NomJeu> jeux, List<PersonnagePrincipal> personnagesRequis,
			List<PersonnagePrincipal> personnagesInterdits, List<PersonnageSecondaire> personnagesSecondaires,
			List<Item> itemsNecessaires, List<Item> itemsDebloques, boolean isRepetable) {
		super();
		this.id = id;
		this.nom = nom;
		this.informations = informations;
		this.imagePaths = imagePaths;
		this.sonPaths = sonPaths;
		this.videoPaths = videoPaths;
		this.proprietaire = proprietaire;
		this.lieu = lieu;
		this.chanceVictoire = chanceVictoire;
		this.conditionVictoire = conditionVictoire;
		this.conditionDefaite = conditionDefaite;
		this.objectif = objectif;
		this.gain = gain;
		this.perte = perte;
		this.gainMax = gainMax;
		this.perteMax = perteMax;
		this.date = date;
		this.type = type;
		this.difficulty = difficulty;
		this.jeux = jeux;
		this.personnagesRequis = personnagesRequis;
		this.personnagesInterdits = personnagesInterdits;
		this.personnagesSecondaires = personnagesSecondaires;
		this.itemsNecessaires = itemsNecessaires;
		this.itemsDebloques = itemsDebloques;
		this.isRepetable = isRepetable;
		this.nombreEssai = 0;
		this.nombreWin = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getInformations() {
		return informations;
	}

	public void setInformations(String informations) {
		this.informations = informations;
	}

	public List<String> getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
	}

	public List<String> getSonPaths() {
		return sonPaths;
	}

	public void setSonPaths(List<String> sonPaths) {
		this.sonPaths = sonPaths;
	}

	public List<String> getVideoPaths() {
		return videoPaths;
	}

	public void setVideoPaths(List<String> videoPaths) {
		this.videoPaths = videoPaths;
	}

	public PersoPrenom getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(PersoPrenom proprietaire) {
		this.proprietaire = proprietaire;
	}

	public int getChanceVictoire() {
		return chanceVictoire;
	}

	public void setChanceVictoire(int chanceVictoire) {
		this.chanceVictoire = chanceVictoire;
	}

	public String getConditionVictoire() {
		return conditionVictoire;
	}

	public void setConditionVictoire(String conditionVictoire) {
		this.conditionVictoire = conditionVictoire;
	}

	public String getConditionDefaite() {
		return conditionDefaite;
	}

	public void setConditionDefaite(String conditionDefaite) {
		this.conditionDefaite = conditionDefaite;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public Bonus getGain() {
		return gain;
	}

	public void setGain(Bonus gain) {
		this.gain = gain;
	}

	public Bonus getPerte() {
		return perte;
	}

	public void setPerte(Bonus perte) {
		this.perte = perte;
	}

	public int getGainMax() {
		return gainMax;
	}

	public void setGainMax(int gainMax) {
		this.gainMax = gainMax;
	}

	public int getPerteMax() {
		return perteMax;
	}

	public void setPerteMax(int perteMax) {
		this.perteMax = perteMax;
	}

	public MissionType getType() {
		return type;
	}

	public void setType(MissionType type) {
		this.type = type;
	}

	public MissionDifficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(MissionDifficulty difficulty) {
		this.difficulty = difficulty;
	}

	public List<PersonnagePrincipal> getPersonnagesRequis() {
		return personnagesRequis;
	}

	public void setPersonnagesRequis(List<PersonnagePrincipal> personnagesRequis) {
		this.personnagesRequis = personnagesRequis;
	}

	public List<PersonnagePrincipal> getPersonnagesInterdits() {
		return personnagesInterdits;
	}

	public void setPersonnagesInterdits(List<PersonnagePrincipal> personnagesInterdits) {
		this.personnagesInterdits = personnagesInterdits;
	}

	public List<PersonnageSecondaire> getPersonnagesSecondaires() {
		return personnagesSecondaires;
	}

	public void setPersonnagesSecondaires(List<PersonnageSecondaire> personnagesSecondaires) {
		this.personnagesSecondaires = personnagesSecondaires;
	}

	public List<Item> getItemsNecessaires() {
		return itemsNecessaires;
	}

	public void setItemsNecessaires(List<Item> itemsNecessaires) {
		this.itemsNecessaires = itemsNecessaires;
	}

	public List<Item> getItemsDebloques() {
		return itemsDebloques;
	}

	public void setItemsDebloques(List<Item> itemsDebloques) {
		this.itemsDebloques = itemsDebloques;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}

	public boolean isRepetable() {
		return isRepetable;
	}

	public void setRepetable(boolean isRepetable) {
		this.isRepetable = isRepetable;
	}

	public boolean isDejaFaite() {
		return isDejaFaite;
	}

	public void setDejaFaite(boolean isDejaFaite) {
		this.isDejaFaite = isDejaFaite;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public boolean estDisponibleAPresenter() {
		if (isDejaPresentee) {
			return false;
		}
		// dispo objet needed
		for (Item item : itemsNecessaires) {
			if (!item.isDisponible()) {
				return false;
			}
		} 
		// dispo date 
		if (date != null) {
			if (!DateManager.estEgaleALaDateCourante(date) || !DateManager.estApresLaDateCourrante(date)) {
				return false;
			}
		}
		isDisponible = true;
		return isDisponible;
	}

	public boolean isDejaPresentee() {
		return isDejaPresentee;
	}

	public void setDejaPresentee(boolean isDejaPresente) {
		this.isDejaPresentee = isDejaPresente;
	}

	public List<NomJeu> getJeux() {
		return jeux;
	}

	public int getNombreEssai() {
		return nombreEssai;
	}

	public void setNombreEssai(int nombreEssai) {
		this.nombreEssai = nombreEssai;
	}

	public int getNombreWin() {
		return nombreWin;
	}

	public void setNombreWin(int nombreWin) {
		this.nombreWin = nombreWin;
	}

}
