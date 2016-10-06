package front;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.ImageManager;
import core.configuration.Constante;
import modele.item.mission.Mission;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class FrameJeu extends JFrame {

	public JPanel createPanelInfoMission(Mission mission) {
		JPanel panelInfoMission = new JPanel();

		PersoPrenom prenom = mission.getProprietaire();
		ImageIcon image = null;
		if (prenom.name().equals("GROUPE")) {
			// TODO : image groupe
			image = FenetrePrincipal.getImageIcon("image/groupe.png");
		} else {
			PersonnagePrincipal proprietaire = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getPersoByNom(prenom);
			image = proprietaire.getPhotoPrincipal();
		}
		ImageIcon resizeImagePerso = ImageManager.resizeImage(image,
				new Dimension(Constante.PANEL_INFO_MISSION_HAUTEUR - 10, Constante.PANEL_INFO_MISSION_HAUTEUR - 10));
		panelInfoMission.add(new JLabel(resizeImagePerso));
		panelInfoMission.add(new JLabel(mission.getProprietaire().name()));
		panelInfoMission.add(new JLabel(mission.getNom()));
		panelInfoMission.add(new JLabel(mission.getInformations()));
		panelInfoMission.add(new JLabel(mission.getObjectif()));
		panelInfoMission.add(new JLabel(mission.getConditionVictoire()));
		panelInfoMission.add(new JLabel(mission.getDifficulty().name()));
		panelInfoMission.add(new JLabel(mission.getMissionType().name()));

		panelInfoMission
				.setPreferredSize(new Dimension(Constante.PANEL_MISSION_LARGEUR, Constante.PANEL_INFO_MISSION_HAUTEUR));
		return panelInfoMission;
	}
	
}
