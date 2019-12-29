package front;

import java.awt.Color;
import java.awt.Component;
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

	private static final long serialVersionUID = 1L;
	
	private boolean musiqueRunning = true;

	public JPanel createPanelInfoMission(Mission mission) {
		JPanel panelInfoMission = new JPanel();
		JButton boutonMusiqueOnOff = new JButton("Musique ON/OFF");
		boutonMusiqueOnOff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isMusiqueRunning()) {
					MusiqueManager.stopPlaylistEnBoucle();
					setMusiqueRunning(false);
				} else {
					MusiqueManager.stopPlaylistEnBoucle();
					MusiqueManager.startPlayListEnBoucle(mission);
					setMusiqueRunning(true);
				}
			}
		});

		PersoPrenom prenom = mission.getProprietaire();
		ImageIcon image = null;
		if (prenom.name().equals("GROUPE")) {
			image = FenetrePrincipal.getImageIcon("image/groupe.png");
		} else {
			PersonnagePrincipal proprietaire = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getPersoByNom(prenom);
			image = proprietaire.getPhotoPrincipal();
		}
		ImageIcon resizeImagePerso = ImageManager.resizeImage(image,
				new Dimension(Constante.PANEL_INFO_MISSION_HAUTEUR - 10, Constante.PANEL_INFO_MISSION_HAUTEUR - 10));
		
		JLabel labelProprio = new JLabel(mission.getProprietaire().name());
		JLabel labelNom = new JLabel(mission.getNom() + " : ");
		JLabel labelInfo = new JLabel(mission.getInformations());
		labelNom.setFont(Constante.MARIO_FONT_MENU_3);
		labelInfo.setFont(Constante.MARIO_FONT_MENU_2);
		labelNom.setForeground(Color.YELLOW);
		labelInfo.setForeground(Color.WHITE);
		labelNom.setMaximumSize(this.getMaximumSize());
		JLabel labelObjectif = new JLabel(mission.getObjectif());
		JLabel labelConditionVictoire = new JLabel(mission.getConditionVictoire());
		JLabel labelDifficulte = new JLabel(mission.getDifficulty().name());
		JLabel labelTypeMisson = new JLabel(mission.getMissionType().name());
		
		panelInfoMission.add(new JLabel(resizeImagePerso));
//		panelInfoMission.add(labelProprio);
		panelInfoMission.add(labelNom);
		panelInfoMission.add(labelInfo);
//		panelInfoMission.add(labelObjectif);
//		panelInfoMission.add(labelConditionVictoire);
//		panelInfoMission.add(labelDifficulte);
//		panelInfoMission.add(labelTypeMisson);
		panelInfoMission.add(boutonMusiqueOnOff);
		
		panelInfoMission.setBackground(Color.BLACK);
		return panelInfoMission;
	}

	public boolean isMusiqueRunning() {
		return musiqueRunning;
	}

	public void setMusiqueRunning(boolean musiqueRunning) {
		this.musiqueRunning = musiqueRunning;
	}
}
