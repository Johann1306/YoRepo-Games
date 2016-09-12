package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.ImageManager;
import core.MusiqueManager;
import core.VideoManager;
import core.configuration.Constante;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class FrameCombat extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static boolean win;

	private JPanel panelNord = new JPanel();
	private JPanel panelOuest = new JPanel();
	private JPanel panelCentre = new JPanel();
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

	public FrameCombat(Groupe groupe, Mission mission) {
		
		win = false;
		
		// Configuration de la fenetre
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());

		this.setAlwaysOnTop(true);
		this.setSize(Constante.FENETRE_COMBAT_DIMENSION);
		this.setMinimumSize(Constante.FENETRE_COMBAT_DIMENSION);
		centreFenetre();

		panelNord.setBackground(Color.BLACK);
		panelOuest.setBackground(Color.RED);
		panelCentre.setBackground(Color.WHITE);
		panelEst.setBackground(Color.GREEN);
		panelSud.setBackground(Color.BLUE);
		
		BoxLayout boxlayout = new BoxLayout(panelOuest, BoxLayout.Y_AXIS);
		panelOuest.setLayout(boxlayout);
		
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		PersonnagePrincipal nicolas = leGroupe.getPersoByNom(PersoPrenom.NICOLAS);
		PersonnagePrincipal pierre = leGroupe.getPersoByNom(PersoPrenom.PIERRE);
		PersonnagePrincipal yannick = leGroupe.getPersoByNom(PersoPrenom.YANNICK);
		PersonnagePrincipal thomas = leGroupe.getPersoByNom(PersoPrenom.THOMAS);
		PersonnagePrincipal johann = leGroupe.getPersoByNom(PersoPrenom.JOHANN);
		PersonnagePrincipal ali = leGroupe.getPersoByNom(PersoPrenom.ALI);
		PersonnagePrincipal guillaume = leGroupe.getPersoByNom(PersoPrenom.GUILLAUME);
		PersonnagePrincipal jonathan = leGroupe.getPersoByNom(PersoPrenom.JONATHAN);

		boutonNicolas = new JButton(ImageManager.resizeImage(nicolas.getPhotoPrincipal(), 64, 64));
		boutonPierre = new JButton(pierre.getPhotoPrincipal());
		boutonYannick = new JButton(yannick.getPhotoPrincipal());
		boutonThomas = new JButton(thomas.getPhotoPrincipal());
		boutonJohann = new JButton(johann.getPhotoPrincipal());
		boutonAli = new JButton(ali.getPhotoPrincipal());
		boutonGuillaume = new JButton(guillaume.getPhotoPrincipal());
		boutonJonathan = new JButton(jonathan.getPhotoPrincipal());
		
		boutonNicolas.setName(nicolas.getPrenom().name());
		boutonPierre.setName(pierre.getPrenom().name());
		boutonYannick.setName(yannick.getPrenom().name());
		boutonThomas.setName(thomas.getPrenom().name());
		boutonJohann.setName(johann.getPrenom().name());
		boutonAli.setName(ali.getPrenom().name());
		boutonGuillaume.setName(guillaume.getPrenom().name());
		boutonJonathan.setName(jonathan.getPrenom().name());
		
		if (nicolas.isDejaPresente()) {
			panelOuest.add(boutonNicolas);
		}
		if (pierre.isDejaPresente()) {
			panelOuest.add(boutonPierre);
		}
		if (yannick.isDejaPresente()) {
			panelOuest.add(boutonYannick);
		}
		if (thomas.isDejaPresente()) {
			panelOuest.add(boutonThomas);
		}
		if (johann.isDejaPresente()) {
			panelOuest.add(boutonJohann);
		}
		if (ali.isDejaPresente()) {
			panelOuest.add(boutonAli);
		}
		if (guillaume.isDejaPresente()) {
			panelOuest.add(boutonGuillaume);
		}
		if (jonathan.isDejaPresente()) {
			panelOuest.add(boutonJonathan);
		}
		
		boutonJohann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Yo : " + win);
				stop(mission, win);
			}
		});
		boutonThomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win=true;
				System.out.println("Tom : " + win);
			}
		});
		boutonNicolas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win=false;
				System.out.println("Nico : " + win);
			}
		});

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
		MusiqueManager.stop();
	}
	
	private void stop(Mission mission, boolean win) {
		this.dispose();
		MenuPrincipal.getMainFrame().setEnabled(true);
		MenuPrincipal.getMainFrame().setVisible(true);
		VideoManager.show();
		MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().termineMission(mission, win);
	}

	private void centreFenetre() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}

}