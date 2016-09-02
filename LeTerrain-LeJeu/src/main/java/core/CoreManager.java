package core;

import java.io.Serializable;

public class CoreManager implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private transient MenuManager menuManager;
	private DateManager dateManager;
	private ItemManager itemManager;
	private EvenementManager evenementManager;
	private MusiqueManager musiqueManager;
	private BonusManager bonusManager;
	private MissionManager missionManager;
	private PersonnageManager personnageManager;
	private VideoManager videoManager;
	private JeuManager jeuManager; 

	public void initialise() {
		
		// Ordonne
		menuManager = new MenuManager();
		menuManager.initialise();
		
		dateManager = new DateManager();
		dateManager.initialise();
		
		itemManager = new ItemManager();
		itemManager.initialise();

		evenementManager = new EvenementManager();
		evenementManager.initialise();

		bonusManager = new BonusManager();
		bonusManager.initialise();
		
		missionManager = new MissionManager();
		missionManager.initialise();
		
		personnageManager = new PersonnageManager();
		personnageManager.initialise();
		
		// Sans ordre
		musiqueManager = new MusiqueManager();
		musiqueManager.initialise();
		
		videoManager = new VideoManager();
		videoManager.initialise();
		
		jeuManager = new JeuManager();
		jeuManager.initialise();
		
	}

	public MenuManager getMenuManager() {
		return menuManager;
	}

	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public EvenementManager getEvenementManager() {
		return evenementManager;
	}

	public void setEvenementManager(EvenementManager evenementManager) {
		this.evenementManager = evenementManager;
	}

	public DateManager getDateManager() {
		return dateManager;
	}

	public void setDateManager(DateManager dateManager) {
		this.dateManager = dateManager;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public MusiqueManager getMusiqueManager() {
		return musiqueManager;
	}

	public void setMusiqueManager(MusiqueManager musiqueManager) {
		this.musiqueManager = musiqueManager;
	}

	public BonusManager getBonusManager() {
		return bonusManager;
	}

	public void setBonusManager(BonusManager bonusManager) {
		this.bonusManager = bonusManager;
	}

	public MissionManager getMissionManager() {
		return missionManager;
	}

	public void setMissionManager(MissionManager missionManager) {
		this.missionManager = missionManager;
	}
	
	public PersonnageManager getPersonnageManager() {
		return personnageManager;
	}

	public void setPersonnageManager(PersonnageManager personnageManager) {
		this.personnageManager = personnageManager;
	}

	public VideoManager getVideoManager() {
		return videoManager;
	}

	public void setVideoManager(VideoManager videoManager) {
		this.videoManager = videoManager;
	}

	public JeuManager getJeuManager() {
		return jeuManager;
	}

	public void setJeuManager(JeuManager jeuManager) {
		this.jeuManager = jeuManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
