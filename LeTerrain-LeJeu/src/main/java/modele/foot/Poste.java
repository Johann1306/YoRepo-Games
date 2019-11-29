package modele.foot;

public enum Poste {
	G("Gardien"),
	AG("Arriere Gauche"),
	AD("Arriere Droit"),
	DCG("Defenseur Central Gauche"),
	DCD("Defenseur Central Droit"),
	MG("Milieu Gauche"),
	MD("Milieu Droit"),
	MC("Milieu Centre"),
	MCG("Milieu Cente Gauche"),
	MCD("Milieu Centre Droit"),
	BG("Buteur Gauche"),
	BD("Buteur Droit");
	
	private String nom;

	private Poste(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
}
