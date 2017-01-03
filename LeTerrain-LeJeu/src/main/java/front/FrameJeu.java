package front;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.ImageManager;
import core.MusiqueManager;
import core.configuration.Constante;
import modele.item.mission.Mission;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class FrameJeu extends JFrame {

	private boolean musiqueRunning = true;

	public JPanel createPanelInfoMission(Mission mission) {
		JPanel panelInfoMission = new JPanel();
		JButton boutonMusiqueOnOff = new JButton("SON");
		boutonMusiqueOnOff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (musiqueRunning) {
					MusiqueManager.stopPlaylistEnBoucle();
					musiqueRunning = false;
				} else {
					MusiqueManager.startPlayListEnBoucle(mission);
					musiqueRunning = true;
				}
			}
		});

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
		panelInfoMission.add(boutonMusiqueOnOff);

		panelInfoMission
				.setPreferredSize(new Dimension(Constante.PANEL_MISSION_LARGEUR, Constante.PANEL_INFO_MISSION_HAUTEUR));
		return panelInfoMission;
	}
	
	public boolean isMusiqueRunning() {
		return musiqueRunning;
	}

	public void setMusiqueRunning(boolean musiqueRunning) {
		this.musiqueRunning = musiqueRunning;
	}
}
