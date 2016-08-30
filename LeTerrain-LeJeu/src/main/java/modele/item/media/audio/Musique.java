package modele.item.media.audio;

import java.util.Date;

public class Musique {

	private String nom;
	private String artiste;
	private String album;
	private Date sortie;
	private String musiquePath;
	private String imagePath;

	public Musique(String musiquePath) {
		this.musiquePath = musiquePath;
		this.nom = "-";
		this.artiste = "-";
		this.album = "-";
		this.sortie = null;
		this.musiquePath = musiquePath;
		this.imagePath = "-";
	}
	
	public Musique(String nom, String artiste, String album, Date sortie, String musiquePath, String imagePath) {
		super();
		this.nom = nom;
		this.artiste = artiste;
		this.album = album;
		this.sortie = sortie;
		this.musiquePath = musiquePath;
		this.imagePath = imagePath;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Date getSortie() {
		return sortie;
	}

	public void setSortie(Date sortie) {
		this.sortie = sortie;
	}

	public String getMusiquePath() {
		return musiquePath;
	}

	public void setMusiquePath(String musiquePath) {
		this.musiquePath = musiquePath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
