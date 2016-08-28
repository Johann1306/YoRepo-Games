package modele.evenement;

import java.util.Date;
import java.util.List;

import core.DateManager;
import modele.item.Item;

public class Evenement {

	private String titre;
	private String informations;
	private String imagePath;
	private String sonPath;
	private String videoPath;
	private EvenementTheme theme;
	private Date date;
	private List<Item> itemsDebloques;

	public Evenement(String titre, String informations, String imagePath, String sonPath, String videoPath, EvenementTheme theme, Date date, List<Item> itemsDebloques) {
		this.titre = titre;
		this.informations = informations;
		this.imagePath = imagePath;
		this.sonPath = sonPath;
		this.videoPath = videoPath;
		this.theme = theme;
		this.date = date;
		this.itemsDebloques = itemsDebloques;
	}

	public boolean estDisponible() {
		if (DateManager.estEgaleALaDateCourante(date)) {
			return true;
		}
		if (DateManager.estAvantLaDateCourrante(date)) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public String getTitre() {
		return titre;
	}

	public String getInformations() {
		return informations;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public String getVideoPath() {
		return videoPath;
	}

	public EvenementTheme getTheme() {
		return theme;
	}
	
	public List<Item> getItemsDebloques() {
		return itemsDebloques;
	}
	
	public String getSonPath() {
		return sonPath;
	}

	public Date getDate() {
		return date;
	}

}
