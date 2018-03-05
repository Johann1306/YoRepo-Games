package modele.item.personnage;

import modele.competence.PersoStat;

public class Aura {

	private PersoStat stat;
	private int valeur;
	private int valeurAjoutee;
	
	public Aura(PersoStat stat, int valeur) {
		super();
		this.stat = stat;
		this.valeur = valeur;
		this.valeurAjoutee = 0;
	}

	public int getValeur() {
		return valeur;
	}
	
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public PersoStat getStat() {
		return stat;
	}
	
	public void setStat(PersoStat stat) {
		this.stat = stat;
	}

	public int getValeurAjoutee() {
		return valeurAjoutee;
	}

	public void setValeurAjoutee(int valeurAjoutee) {
		this.valeurAjoutee = valeurAjoutee;
	}
	
	@Override
	public String toString() {
		return stat.name();
	}
	
}
