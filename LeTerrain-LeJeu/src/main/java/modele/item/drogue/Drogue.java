package modele.item.drogue;

import java.awt.Color;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import front.MenuPrincipal;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.personnage.PersoPrenom;

public class Drogue extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private DrogueType drogueType;
	private DrogueClasse drogueClasse;
	private Map<PersoStat, Integer> bonusParStat; 
	private int vitessePeremption;
	private Date datePeremption;
	private Color couleur;
	
	public Drogue(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths,
			List<String> videoPaths, PersoPrenom proprietaire, DrogueType drogueType, DrogueClasse drogueClasse, Map<PersoStat, Integer> bonusParStat, int vitessePeremption, boolean isDisponible) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, ItemType.DROGUE, isDisponible);
		this.drogueType = drogueType;
		this.drogueClasse = drogueClasse;
		this.bonusParStat = bonusParStat;
		this.vitessePeremption = vitessePeremption;
		this.couleur = Color.GRAY;
	}

	public DrogueType getDrogueType() {
		return drogueType;
	}

	public void setDrogueType(DrogueType drogueType) {
		this.drogueType = drogueType;
	}

	public DrogueClasse getDrogueClasse() {
		return drogueClasse;
	}

	public void setDrogueClasse(DrogueClasse drogueClasse) {
		this.drogueClasse = drogueClasse;
	}

	public Map<PersoStat, Integer> getBonusParStat() {
		return bonusParStat;
	}

	public void setBonusParStat(Map<PersoStat, Integer> bonusParStat) {
		this.bonusParStat = bonusParStat;
	}
	
	public int getVitessePeremption() {
		return vitessePeremption;
	}

	public void setVitessePeremption(int vitessePeremption) {
		this.vitessePeremption = vitessePeremption;
	}

	public Date getDatePeremption() {
		return datePeremption;
	}

	public void setDatePeremption(Date datePeremption) {
		this.datePeremption = datePeremption;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder= new StringBuilder();
		stringBuilder.append("Drogue : ");
		stringBuilder.append(getNom());
		stringBuilder.append(" (");
		stringBuilder.append(getInformations());
		stringBuilder.append(")");
		if (!bonusParStat.isEmpty()) {
			stringBuilder.append(" (Bonus : ");
			Set<PersoStat> keySet = bonusParStat.keySet();
			for (PersoStat persoStat : keySet) {
				Integer value = bonusParStat.get(persoStat);
				stringBuilder.append(" +");
				stringBuilder.append(value);
				stringBuilder.append(" ");
				stringBuilder.append(persoStat.name());
			}
			stringBuilder.append(")");
		}
		if (!getInformations().isEmpty()) {
			stringBuilder.append(" - ");
			stringBuilder.append(getInformations());
		}
		return stringBuilder.toString();
	}

	public String getStats() {
		StringBuilder stringBuilder = new StringBuilder();
		if (!bonusParStat.isEmpty()) {
			stringBuilder.append(" (Bonus:");
			Set<PersoStat> keySet = bonusParStat.keySet();
			for (PersoStat persoStat : keySet) {
				Integer value = bonusParStat.get(persoStat);
				stringBuilder.append(" +");
				stringBuilder.append(value);
				stringBuilder.append(" ");
				stringBuilder.append(persoStat.name());
			}
			stringBuilder.append(")");
		}
		// 
		if (datePeremption != null) {
			Date dateCourante = MenuPrincipal.getMainFrame().getCoreManager().getDateManager().getDateCourante();
			long diff = datePeremption.getTime() - dateCourante.getTime();
			if (diff < 0) {
				stringBuilder.append(" (Pourri)");
			} else {
				long jours = (diff)/ (1000 * 60 * 60 * 24); 
				stringBuilder.append(" (" + jours + " jours restants)");
			}
		} else {
			stringBuilder.append(" (Frais)");
		}
		
		return stringBuilder.toString();
	}

	public Color getCouleur() {
		return couleur;
	}
	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

}
