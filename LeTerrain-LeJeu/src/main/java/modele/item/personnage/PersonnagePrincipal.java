
package modele.item.personnage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import front.MainFrame;
import modele.competence.Competence;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.lieu.Lieu;
import modele.item.media.audio.Musique;
import modele.item.media.audio.Son;
import modele.item.personnage.action.ActionCombat;
import modele.location.Location;

public class PersonnagePrincipal extends Personnage { //extends Item {
	
	private static final long serialVersionUID = 1L;
	
	private PersoNom nomFamille;
	private PersoPrenom prenomPerso;
	private String surnomPrincipal;
	private List<String> surnoms;
	private Date dateNaissance;
	private String origines;
	private List<ImageIcon> photos;
	private Color couleur;
	
	private List<ActionCombat> actionsCombat;
	private List<Objectif> objectifs;
	private List<MomentCle> momentsCle;
	private List<PersonnageEnnemi> boss;
	private List<PersonnageSecondaire> connaissances;
	private List<Son> sons;
	private List<Musique> musiques;
	private Map<Item, Integer> sac;
	private Lieu domicile;
	private Location location;
	public boolean isDejaPresente;
	private Competence competenceMax;
	private String messageDieu;
	
	public PersonnagePrincipal(PersoNom nomFamille, PersoPrenom prenomPerso, String surnomPrincipal, List<String> surnoms, Date dateNaissance, String origines,
			List<String> particularitesPhysique, List<String> particularitesSocial, List<String> phrasesPerso,
			ImageIcon photoPrincipal, ImageIcon photoCombat, List<ImageIcon> photos, Color couleur, List<ActionCombat> actionsCombat, List<Objectif> objectifs,
			List<MomentCle> momentsCle, String messageDieu, List<PersonnageEnnemi> boss, List<PersonnageSecondaire> connaissances,
			List<Son> sons, List<Musique> musiques, Map<Item, Integer> sac, Lieu domicile, Competence competence, Competence competenceMax,
			boolean disponible) {
		super(prenomPerso.name(), nomFamille.name(), disponible);
		this.nomFamille = nomFamille;
		this.prenomPerso = prenomPerso;
		this.surnomPrincipal = surnomPrincipal;
		this.surnoms = surnoms;
		this.dateNaissance = dateNaissance;
		this.origines = origines;
		this.setParticularitesPhysique(particularitesPhysique);
		this.setParticularitesSocial(particularitesSocial);
		this.setPhrasesPerso(phrasesPerso);
		this.setPhotoPrincipal(photoPrincipal);
		this.setPhotoCombat(photoCombat);
		this.photos = photos;
		this.couleur = couleur;
		this.actionsCombat = actionsCombat;
		this.objectifs = objectifs;
		this.momentsCle = momentsCle;
		this.messageDieu = messageDieu;
		this.boss = boss;
		this.connaissances = connaissances;
		this.sons = sons;
		this.musiques = musiques;
		this.sac = sac;
		this.domicile = domicile;
		// TODO : location/domicile a setter plus tard (apres intialisation du coreManager)
		this.location = null;
		this.setCompetence(competence);
		this.setCompetenceMax(competenceMax);
		this.isDejaPresente = false;
		this.setDisponible(disponible);
		this.setVieMax(competence.getEndurance()*10); // max vie = 1000
		this.setVie(competence.getEndurance()*10);
		this.setManaMax(competence.getIntelligence());
		this.setMana(competence.getIntelligence());
		this.setVitesseCharge(competence.getRapidite());
		this.setNombreChargeMax(competence.getNervosite()/20); // max charge = 5
		this.setNombreCharge(0);
		this.setBouclier(0);
	}

	public PersoNom getNomFamille() {
		return nomFamille;
	}

	public PersoPrenom getPrenomPerso() {
		return prenomPerso;
	}

	public String getSurnomPrincipal() {
		return surnomPrincipal;
	}

	public List<String> getSurnoms() {
		return surnoms;
	}

	public List<ImageIcon> getPhotos() {
		return photos;
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

	public Map<Item, Integer> getSac() {
		return sac;
	}

	public Lieu getDomicile() {
		return domicile;
	}
	
	public void setDomicile(Lieu domicile) {
		this.domicile = domicile;
	}

	public boolean isDejaPresente() {
		return isDejaPresente;
	}

	public void setDejaPresente(boolean isDejaPresente) {
		this.isDejaPresente = isDejaPresente;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<ActionCombat> getActionsCombat() {
		return actionsCombat;
	}

	public void setActionsCombat(List<ActionCombat> actionsCombat) {
		this.actionsCombat = actionsCombat;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public Competence getCompetenceMax() {
		return competenceMax;
	}

	public void setCompetenceMax(Competence competenceMax) {
		this.competenceMax = competenceMax;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getOrigines() {
		return origines;
	}
	
	public String getMessageDieu() {
		return messageDieu;
	}

	public void addCompetences(Map<PersoStat, Integer> map) {
		
		if (map != null) {
			// On recupere les stats du perso
			Map<PersoStat, Integer> statsPerso = getCompetence().getStats();
			
			// Pour chaque stat
			for (PersoStat stat : statsPerso.keySet()) {
				
				// Si cette stat est modifiee
				if (map.containsKey(stat)) {
					
					// On la modifie
					Integer valeurStat = statsPerso.get(stat);
					Integer valeurAAJouter = map.get(stat);
					Integer valeurModifie = valeurStat + valeurAAJouter;
					Integer valeurMax = competenceMax.getStats().get(stat);
					
					if (valeurStat == valeurMax) {
						// TODO prevenir le joueur si la stat est deja au max
					}
					
					// On plafonne les competences a la valeur max du perso
					if (valeurModifie > valeurMax) {
						// TODO prevenir le joueur si la stat arrive au max
						valeurModifie = valeurMax;
					}
					// TODO affichage info bonus
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), this.getPrenom()
							+ " a gagné : " + (valeurModifie - valeurStat) + " point(s) de " + stat.name(), "Points de competences gagnés", 0, this.getPhotoPrincipal());
					
					// On met a jour les stats du perso
					statsPerso.put(stat, valeurModifie);	
					
				}
			}
		}
	}
	
	public void addCompetences(PersoStat stat, int valeur) {
		Map<PersoStat, Integer> statsPerso = new HashMap<PersoStat, Integer>();
		statsPerso.put(stat, valeur);
		addCompetences(statsPerso);
	}


	public List<ActionCombat> getActionsCombatDisponibles() {
			List<ActionCombat> actionsCombatDispo = new ArrayList<ActionCombat>();
			for (ActionCombat action : actionsCombat) {
				if (action.isDisponible()) {
					actionsCombatDispo.add(action);
				}
			}
			return actionsCombatDispo;
		}


}
