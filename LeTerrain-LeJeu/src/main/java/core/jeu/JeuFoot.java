package core.jeu;

import java.io.Serializable;
import java.util.List;

import javax.swing.SwingUtilities;

import core.NomJeu;
import front.FrameFootFX;
import modele.item.Item;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnageSecondaire;
import modele.jeu.Jeu;

public class JeuFoot extends Jeu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private transient FrameFootFX frame = null;

	public JeuFoot(NomJeu nomJeu) {
		super(nomJeu);
	}
	
	@Override
	public void start(Groupe groupe, Mission mission) {
		
		int chanceVictoire = mission.getChanceVictoire();
		Difficulte difficulty = mission.getDifficulty();
		List<PersonnageSecondaire> personnagesSecondaires = mission.getPersonnagesSecondaires();
		PersoPrenom proprietaire = mission.getProprietaire();
		List<String> sonPaths = mission.getSonPaths();
		String conditionDefaite = mission.getConditionDefaite();
		String conditionVictoire = mission.getConditionVictoire();
		List<Item> itemsDebloques = mission.getItemsDebloques();

		// FrameFootFX
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initAndShowGUI(mission);
			}
		});
		
	}
	
	private void initAndShowGUI(Mission mission) {
		// This method is invoked on the EDT thread
		System.out.println("Nouvelle instance de FrameFootFX");
		frame = new FrameFootFX(mission);
		frame.setVisible(true);
		frame.start();
	}

}