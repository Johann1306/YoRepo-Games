package modele.item.arme;

import java.util.List;

import modele.item.Item;
import modele.item.ItemType;
import modele.item.personnage.PersoPrenom;

public class Arme extends Item {
	
	private int degatsMin;
	private int degatsMax;
	private ArmeType armeType;
	private ArmeClasse armeClasse;

	public Arme(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths,
			List<String> videoPaths, PersoPrenom proprietaire, int degatsMin, int degatsMax, ArmeType armeType, ArmeClasse armeClasse, boolean isDisponible) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, ItemType.ARME, isDisponible);
		this.degatsMin = degatsMin;
		this.degatsMax = degatsMax;
		this.armeClasse = armeClasse;
		this.armeType = armeType;
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

}
