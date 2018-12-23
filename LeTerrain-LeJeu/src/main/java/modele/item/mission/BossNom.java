package modele.item.mission;

public enum BossNom {
	BOSS1("Zinedine Zidane"),
	BOSS2("Lara Croft"),
	BOSS3("Docteur Dre"),
	BOSS4("Adolph Hitler"),
	BOSS5("Anakin Skywalker"),
	BOSS6("Mickael Jackson"),
	BOSS7("Liquid Snake"),
	BOSS8("Arnaud de la piscine"),
	BOSS11("Madame Chatelain"),
	BOSS12("Madame Dubois"),
	BOSS13("Madame Durand"),
	BOSS14("Madame Braquet"),
	BOSS15("Monsieur Bouchera");
	
	private String nom;

	private BossNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

}
