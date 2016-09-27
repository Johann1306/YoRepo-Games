package core;

import java.io.Serializable;

public class CoreManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient MenuManager menuManager;
	private transient VideoManager videoManager;
	private DateManager dateManager;
	private ItemManager itemManager;
	private EvenementManager evenementManager;
	private MusiqueManager musiqueManager;
	private BonusManager bonusManager;
	private MissionManager missionManager;
	private PersonnageManager personnageManager;
	private JeuManager jeuManager;
	private PoiManager poiManager;
	private LieuManager lieuManager;
	private CarteManager carteManager;
	private ActionCombatManager actionCombatManager;

	public CoreManager() {
	}

	public void initialise() {

		// Ordonne
		menuManager = new MenuManager();
		menuManager.initialise();

		dateManager = new DateManager();
		dateManager.initialise();

		itemManager = new ItemManager();
		itemManager.initialise();

		evenementManager = new EvenementManager();
		evenementManager.initialise(itemManager);

		bonusManager = new BonusManager();
		bonusManager.initialise();

		missionManager = new MissionManager();
		missionManager.initialise();
		
		actionCombatManager = new ActionCombatManager();
		actionCombatManager.initialise();

		personnageManager = new PersonnageManager();
		personnageManager.initialise(actionCombatManager);

		// Sans ordre
		musiqueManager = new MusiqueManager();
		musiqueManager.initialise();

		videoManager = new VideoManager();
		videoManager.initialise();

		jeuManager = new JeuManager();
		jeuManager.initialise();
		
		poiManager = new PoiManager();
		poiManager.initialise(missionManager);
		
		lieuManager = new LieuManager();
		lieuManager.initialise(poiManager);
		
		carteManager = new CarteManager();
		carteManager.initialise(lieuManager);


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

	public LieuManager getLieuManager() {
		return lieuManager;
	}

	public void setLieuManager(LieuManager lieuManager) {
		this.lieuManager = lieuManager;
	}
	
	public PoiManager getPoiManager() {
		return poiManager;
	}

	public void setPoiManager(PoiManager poiManager) {
		this.poiManager = poiManager;
	}

	public CarteManager getCarteManager() {
		return carteManager;
	}

	public void setCarteManager(CarteManager carteManager) {
		this.carteManager = carteManager;
	}

	public ActionCombatManager getActionCombatManager() {
		return actionCombatManager;
	}

	public void setActionCombatManager(ActionCombatManager actionCombatManager) {
		this.actionCombatManager = actionCombatManager;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
