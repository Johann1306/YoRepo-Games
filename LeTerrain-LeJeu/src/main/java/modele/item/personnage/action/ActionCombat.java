package modele.item.personnage.action;

import java.io.Serializable;
import java.util.List;

import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.ItemType;

public class ActionCombat extends Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private int niveau;
	private int niveauMax;
	private int progression;
	private ActionCombatType actionCombatType;
	private EnergieType energieType;
	private CibleType cibleType;
	private PersoStat persoStat;
	private SortType sortType;

	public ActionCombat(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths,
			List<String> videoPaths, boolean isDisponible, int niveau,
			int niveauMax, int progression, ActionCombatType actionCombatType, EnergieType energieType,
			CibleType cibleType, PersoStat persoStat, SortType sortType) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, null, ItemType.ACTION_COMBAT, isDisponible);
		this.niveau = niveau;
		this.niveauMax = niveauMax;
		this.progression = progression;
		this.actionCombatType = actionCombatType;
		this.energieType = energieType;
		this.cibleType = cibleType;
		this.persoStat = persoStat;
		this.sortType = sortType;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public ActionCombatType getActionCombatType() {
		return actionCombatType;
	}

	public void setActionCombatType(ActionCombatType actionCombatType) {
		this.actionCombatType = actionCombatType;
	}

	public EnergieType getEnergieType() {
		return energieType;
	}

	public void setEnergieType(EnergieType energieType) {
		this.energieType = energieType;
	}

	public CibleType getCibleType() {
		return cibleType;
	}

	public void setCibleType(CibleType cibleType) {
		this.cibleType = cibleType;
	}

	public int getProgression() {
		return progression;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}

	public int getNiveauMax() {
		return niveauMax;
	}

	public void setNiveauMax(int niveauMax) {
		this.niveauMax = niveauMax;
	}
	
	public PersoStat getPersoStat() {
		return persoStat;
	}

	public SortType getSortType() {
		return sortType;
	}

	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}

	@Override
	public boolean amelioreItem() {
		
		boolean itemAmeliore = false;
		if (niveau < niveauMax) {
			niveau = niveau + 1;
			progression = 0;
			itemAmeliore = true;
		}
		return itemAmeliore;
	}
}

