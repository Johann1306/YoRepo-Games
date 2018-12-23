package modele.evenement;

public enum EvenementTheme {
	ANNIVERSAIRE("Anniversaire"),
	ARRIVEE_NOUVEAU_PERSONNAGE("Nouveau Personnage"),
	VACANCE("Vacance"),
	SORTIE_MUSIQUE("Sortie Musique"),
	SORTIE_JEU_SOCIETE("Sortie Jeu de Société"),
	SORTIE_JEU_VIDEO("Sortie Jeu Vidéo"),
	SORTIE_FILM("Sortie Film"),
	SORTIE_SERIE("Sortie Série"),
	SORTIE_EMISSION("Sortie Emission"),
	SORTIE_DESSIN_ANIME("Sortie Dessin Animé"),
	SORTIE_DESSIN_ANIME_10ANS("Sortie Dessin Animé (10ans)"),
	SORTIE_PUB("Sortie Publicité"),
	SORTIE_OBJET("Sortie Objet"),
	HISTOIRE("Histoire"),
	INTERVENTION_DIVINE("Intervention Divine");
	
	private String nom;

	private EvenementTheme(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
}
