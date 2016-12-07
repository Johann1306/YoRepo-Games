package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.ImageManager;
import core.MusiqueManager;
import core.VideoManager;
import core.configuration.Constante;
import modele.item.Item;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.Personnage;
import modele.item.personnage.PersonnageEnnemi;
import modele.item.personnage.PersonnagePrincipal;

public class FrameFoot extends FrameJeu {

	private static final long serialVersionUID = 1L;

	private JPanel panelNord = new JPanel();
	private JPanel panelOuest = new JPanel();
	private static JPanel panelCentre = new JPanel();
	private JPanel panelEst = new JPanel();
	private JPanel panelSud = new JPanel();

	private JButton boutonNicolas = null;
	private JButton boutonPierre = null;
	private JButton boutonYannick = null;
	private JButton boutonThomas = null;
	private JButton boutonJohann = null;
	private JButton boutonAli = null;
	private JButton boutonGuillaume = null;
	private JButton boutonJonathan = null;

	private Item itemSelectionne = null;
	private JPanel panelInfosCombat = null;
	private List<JButton> boutonsAdversaires = null;
	private List<JButton> boutonsAmis = null;
	private List<Personnage> adversaires = null;
	private List<Personnage> persosAmis = null;

	public FrameFoot(Groupe groupe, Mission mission) {

		// Configuration de la fenetre
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());

		this.setAlwaysOnTop(true);
		this.setSize(Constante.FENETRE_COMBAT_DIMENSION);
		this.setMinimumSize(Constante.FENETRE_COMBAT_DIMENSION);
		centreFenetre();

		// Personnages principaux
		PersonnagePrincipal nicolas = groupe.getPersoByNom(PersoPrenom.Nicolas);
		PersonnagePrincipal pierre = groupe.getPersoByNom(PersoPrenom.Pierre);
		PersonnagePrincipal yannick = groupe.getPersoByNom(PersoPrenom.Yannick);
		PersonnagePrincipal thomas = groupe.getPersoByNom(PersoPrenom.Thomas);
		PersonnagePrincipal johann = groupe.getPersoByNom(PersoPrenom.Johann);
		PersonnagePrincipal ali = groupe.getPersoByNom(PersoPrenom.Ali);
		PersonnagePrincipal guillaume = groupe.getPersoByNom(PersoPrenom.Guillaume);
		PersonnagePrincipal jonathan = groupe.getPersoByNom(PersoPrenom.Jonathan);

		// -- Panel Nord - Info
		JPanel panelInfoMission = createPanelInfoMission(mission);
		panelNord.add(panelInfoMission);

		// -- Panel Ouest - Persos
		ImageIcon resizeImage = ImageManager.resizeImage(nicolas.getPhotoPrincipal(),
				Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonNicolas = new JButton(resizeImage);
		boutonPierre = new JButton(
				ImageManager.resizeImage(pierre.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonYannick = new JButton(
				ImageManager.resizeImage(yannick.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonThomas = new JButton(
				ImageManager.resizeImage(thomas.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonJohann = new JButton(
				ImageManager.resizeImage(johann.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonAli = new JButton(
				ImageManager.resizeImage(ali.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonGuillaume = new JButton(
				ImageManager.resizeImage(guillaume.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonJonathan = new JButton(
				ImageManager.resizeImage(jonathan.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));

		boutonNicolas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonPierre.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonYannick.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonThomas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonJohann.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonAli.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonGuillaume.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonJonathan.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);

		boutonNicolas.setName(nicolas.getPrenom());
		boutonPierre.setName(pierre.getPrenom());
		boutonYannick.setName(yannick.getPrenom());
		boutonThomas.setName(thomas.getPrenom());
		boutonJohann.setName(johann.getPrenom());
		boutonAli.setName(ali.getPrenom());
		boutonGuillaume.setName(guillaume.getPrenom());
		boutonJonathan.setName(jonathan.getPrenom());

		JPanel panelPersos = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panelPersos, BoxLayout.Y_AXIS);
		panelPersos.setLayout(boxlayout);
		persosAmis = new ArrayList<Personnage>();
		boutonsAmis = new ArrayList<JButton>();

		if (thomas.isDejaPresente() && !thomas.isMort()) {
			panelPersos.add(boutonThomas);
			boutonsAmis.add(boutonThomas);
			persosAmis.add(thomas);
		}
		if (guillaume.isDejaPresente() && !guillaume.isMort()) {
			panelPersos.add(boutonGuillaume);
			boutonsAmis.add(boutonGuillaume);
			persosAmis.add(guillaume);
		}
		if (nicolas.isDejaPresente() && !nicolas.isMort()) {
			panelPersos.add(boutonNicolas);
			boutonsAmis.add(boutonNicolas);
			persosAmis.add(nicolas);
		}
		if (pierre.isDejaPresente() && !pierre.isMort()) {
			panelPersos.add(boutonPierre);
			boutonsAmis.add(boutonPierre);
			persosAmis.add(pierre);
		}
		if (jonathan.isDejaPresente() && !jonathan.isMort()) {
			panelPersos.add(boutonJonathan);
			boutonsAmis.add(boutonJonathan);
			persosAmis.add(jonathan);
		}
		if (yannick.isDejaPresente() && !yannick.isMort()) {
			panelPersos.add(boutonYannick);
			boutonsAmis.add(boutonYannick);
			persosAmis.add(yannick);
		}
		if (johann.isDejaPresente() && !johann.isMort()) {
			panelPersos.add(boutonJohann);
			boutonsAmis.add(boutonJohann);
			persosAmis.add(johann);
		}
		if (ali.isDejaPresente() && !ali.isMort()) {
			panelPersos.add(boutonAli);
			boutonsAmis.add(boutonAli);
			persosAmis.add(ali);
		}

		// TODO
		for (JButton boutonAmi : boutonsAmis) {
			boutonAmi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
	
		// TODO Gestion nombre persos par equipe (5v5, 7v7, 11v11)
		
		// TODO Gestion adversaire en fonction de l'epoque ( ecole(5v5), terrain(3v3,4v4,5v5,6v6,7v7) , Chelles(7v7,11v11), Noisy(5v5,6v6) ) 

		panelOuest.add(panelPersos);

		// -- Panel Est
		JPanel panelEnnemis = new JPanel();
		BoxLayout boxlayoutEnnemis = new BoxLayout(panelEnnemis, BoxLayout.Y_AXIS);
		panelEnnemis.setLayout(boxlayoutEnnemis);

		// Gestion des adversaires
		boutonsAdversaires = new ArrayList<JButton>();
		adversaires = new ArrayList<Personnage>();

		for (int i = 1; i <= boutonsAmis.size(); i++) {
//			PersonnageEnnemi ennemi = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
//					.createPersonnageEnnemi(mission, i);
//			adversaires.add(ennemi);
//			JButton boutonEnnemi = new JButton(ennemi.getPhotoPrincipal());
//			boutonEnnemi.setName(ennemi.getNom());
//			boutonEnnemi.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
//			boutonEnnemi.setToolTipText(boutonEnnemi.getName());
//			boutonEnnemi.setFocusable(false);
//			panelEnnemis.add(boutonEnnemi);
//			boutonsAdversaires.add(boutonEnnemi);
		}

		panelEst.add(panelEnnemis);

		// -- Panel Sud - Actions

		// -- Panel Centre

		// --
		panelNord.setBackground(Color.BLACK);
		panelOuest.setBackground(Color.GREEN);
		panelCentre.setBackground(Color.WHITE);
		panelEst.setBackground(Color.RED);
		panelSud.setBackground(Color.BLUE);

		content.add(panelNord, BorderLayout.NORTH);
		content.add(panelOuest, BorderLayout.WEST);
		content.add(panelCentre, BorderLayout.CENTER);
		content.add(panelEst, BorderLayout.EAST);
		content.add(panelSud, BorderLayout.SOUTH);

		this.setContentPane(content);
		this.setVisible(true);
	}

	public void start() {
		MenuPrincipal.getMainFrame().setEnabled(false);
		MenuPrincipal.getMainFrame().setVisible(false);
		VideoManager.hideAndStop();
		MusiqueManager.stopAll();
		JOptionPane.showMessageDialog(this, "Debut du match");

		// -- TODO Gestion IA
		lancePartie();
	}

	private void lancePartie() {
		// TODO Auto-generated method stub
		
	}

	// Fin du jeu
	private void stop(Mission mission, boolean win) {

		// Message fin du jeu
		if (win) {
			ImageIcon icon = FenetrePrincipal.getImageIcon("image/defaut/defautVictoire.png");
			JOptionPane.showMessageDialog(this, "Victoire !", "Fin du match", 0, icon);
		} else {
			ImageIcon icon = FenetrePrincipal.getImageIcon("image/defaut/defautDefaite.png");
			JOptionPane.showMessageDialog(this, "Defaite !", "Fin du match", 0, icon);
		}

		// Fermeture de la frame foot et reaffichage de la mainframe
		this.dispose();
		MenuPrincipal.getMainFrame().setEnabled(true);
		MenuPrincipal.getMainFrame().setVisible(true);
		VideoManager.show();
		MusiqueManager.stopAll();

		// Fin de la mission
		MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().termineMission(mission, win);
	}

	private void centreFenetre() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}

	private void manageItemSelectionne(PersoPrenom prenom) {
		if (itemSelectionne != null) {
			int reponse = JOptionPane.showConfirmDialog(this,
					"T'es sur de vouloir utiliser " + itemSelectionne.getNom() + " sur " + prenom.name() + "?");
			if (reponse == 0) {
				// OUI
				boolean itemConsomme = itemSelectionne.consommeItem();
				if (itemConsomme) {
					JOptionPane.showMessageDialog(this, "Consomme : " + itemSelectionne.getNom());
					JLabel label = new JLabel(prenom.name() + " consomme " + itemSelectionne.getNom() + ".");
					// label.setFont(Constante.PRESS_START_FONT_FRAMECOMBAT_INFO);
					panelInfosCombat.add(label, 0);
					// TODO setDisponible(false)? ou etat consomme?
					itemSelectionne.setDisponible(false);

				} else {
					JOptionPane.showMessageDialog(this,
							"L'item : " + itemSelectionne.getNom() + " n'a pas pu etre consomme : raison");
				}
			}
			// TODO : remettre curseur souris normal
			panelOuest.setBorder(null);
			itemSelectionne = null;
		}
	}

	public static FrameFoot getFrameFoot() {
		return (FrameFoot) panelCentre.getParent().getParent().getParent().getParent();
	}
	
}