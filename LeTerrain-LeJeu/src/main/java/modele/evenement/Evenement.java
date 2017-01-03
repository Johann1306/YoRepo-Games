package modele.evenement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import front.MenuPrincipal;
import modele.item.Item;

public class Evenement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String titre;
	private String informations;
	private String imagePath;
	private String sonPath;
	private String videoPath;
	private EvenementTheme theme;
	private Date date;
	private List<Item> itemsDebloques;
	private boolean isDejaPresente;

	public Evenement(String titre, String informations, String imagePath, String sonPath, String videoPath, EvenementTheme theme, Date date, List<Item> itemsDebloques) {
		this.titre = titre;
		this.informations = informations;
		this.imagePath = imagePath;
		this.sonPath = sonPath;
		this.videoPath = videoPath;
		this.theme = theme;
		this.date = date;
		this.itemsDebloques = itemsDebloques;
		this.isDejaPresente = false;
	}

	public boolean estDisponibleAPresenter() {
		boolean disponible = false;
		if (MenuPrincipal.getMainFrame().getCoreManager().getDateManager().compare(date) <= 0 && !isDejaPresente) {
			disponible = true;
		} 
		return disponible;
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

	public boolean isDejaPresente() {
		return isDejaPresente;
	}

	public void setDejaPresente(boolean isDejaPresente) {
		this.isDejaPresente = isDejaPresente;
	}
}
