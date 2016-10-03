package modele.item.media.audio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import modele.item.Item;
import modele.item.ItemType;

public class Musique extends Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nom;
	private String artiste;
	private String album;
	private Date sortie;
	
	public Musique(int id, String nom, String artiste, String album, Date sortie, List<String> imagePaths, List<String> sonPaths, List<String> videoPaths, String informations, boolean isDisponible) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, null, ItemType.MUSIQUE, isDisponible);
		this.nom = nom;
		this.artiste = artiste;
		this.album = album;
		this.sortie = sortie;
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
	
	
}
