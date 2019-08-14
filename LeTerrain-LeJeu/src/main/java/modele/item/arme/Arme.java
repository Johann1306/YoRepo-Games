package modele.item.arme;

import java.awt.Color;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.personnage.PersoPrenom;

public class Arme extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int degatsMin;
	private int degatsMax;
	private ArmeType armeType;
	private ArmeClasse armeClasse;
	private Map<PersoStat, Integer> bonusParStat; 
	private PersoStat persoStat;
	private Color couleur;

	public Arme(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths,
			List<String> videoPaths, PersoPrenom proprietaire, int degatsMin, int degatsMax, ArmeType armeType, ArmeClasse armeClasse, PersoStat persoStat, boolean isDisponible) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, ItemType.ARME, isDisponible);
		this.degatsMin = degatsMin;
		this.degatsMax = degatsMax;
		this.armeClasse = armeClasse;
		this.armeType = armeType;
		this.persoStat = persoStat;
		this.bonusParStat = new HashMap<PersoStat, Integer>();
		this.couleur = Color.GRAY;
	}

	public ArmeType getArmeType() {
		return armeType;
	}

	public void setArmeType(ArmeType armeType) {
		this.armeType = armeType;
	}

	public ArmeClasse getArmeClasse() {
		return armeClasse;
	}

	public void setArmeClasse(ArmeClasse armeClasse) {
		this.armeClasse = armeClasse;
	}

	public int getDegatsMin() {
		return degatsMin;
	}

	public void setDegatsMin(int degatsMin) {
		this.degatsMin = degatsMin;
	}

	public int getDegatsMax() {
		return degatsMax;
	}

	public void setDegatsMax(int degatsMax) {
		this.degatsMax = degatsMax;
	}

	public PersoStat getPersoStat() {
		return persoStat;
	}

	public void setPersoStat(PersoStat persoStat) {
		this.persoStat = persoStat;
	}

	public Map<PersoStat, Integer> getBonusParStat() {
		return bonusParStat;
	}

	public void setBonusParStat(Map<PersoStat, Integer> bonusParStat) {
		this.bonusParStat = bonusParStat;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder= new StringBuilder();
		stringBuilder.append("Arme : ");
		stringBuilder.append(getNom());
		stringBuilder.append(" (");
		stringBuilder.append(getDegatsMin());
		stringBuilder.append("-");
		stringBuilder.append(getDegatsMax());
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
		StringBuilder stringBuilder= new StringBuilder();
		stringBuilder.append("Degats:");
		stringBuilder.append(" (");
		stringBuilder.append(getDegatsMin());
		stringBuilder.append("-");
		stringBuilder.append(getDegatsMax());
		stringBuilder.append(")");
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
		return stringBuilder.toString();
	}

}
