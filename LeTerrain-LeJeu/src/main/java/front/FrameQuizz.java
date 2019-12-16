package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import core.ImageManager;
import core.MusiqueManager;
import core.QuizzManager;
import core.VideoManager;
import core.configuration.Constante;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;
import modele.quizz.Enigme;
import modele.quizz.Reponse;

public class FrameQuizz extends FrameJeu {
	
	private JPanel panelNord = new JPanel();
	private JPanel panelOuest = new JPanel();
	private JPanel panelCentre = new JPanel();
	private JPanel panelEst = new JPanel();
	private JPanel panelSud = new JPanel();
	
	private Timer timer = null;
	private JLabel labelTimer = null;
	private Mission mission = null;
	private Enigme enigme = null;
	
	public FrameQuizz(Groupe groupe, Mission mission) {
		
		this.mission = mission;
		
		// QuizzManager
		QuizzManager quizzManager = MenuPrincipal.getMainFrame().getCoreManager().getQuizzManager();
		enigme = quizzManager.getRandomEnigmeDisponible(mission.getDifficulty());
		
		// Configuration de la fenetre
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
	
		// -- Panel Nord - Info
		JPanel panelInfoMission = createPanelInfoMission(mission);
		panelNord.add(panelInfoMission);
		
		// -- Panel Centre
		
		// Panel Question
		JPanel panelQuestion = new JPanel();
		String question = enigme.getQuestion();
		JTextArea field = new JTextArea(question);
		field.setLineWrap(true);
		field.setEditable(false);
		field.setFont(Constante.MARIO_FONT_QUESTION_QUIZZ);
		field.setSize(Constante.FENETRE_QUIZZ_DIMENSION_QUESTION);
		field.setMinimumSize(Constante.FENETRE_QUIZZ_DIMENSION_QUESTION);  
		panelQuestion.add(field);
		
		// Panel Reponses possibles
		JPanel panelInfoReponse = new JPanel();
		JPanel panelReponses = new JPanel();
		GridLayout layout = new GridLayout(2,2);
		panelReponses.setLayout(layout);
		List<Reponse> reponses = enigme.getReponsesPossibles();
		for (Reponse reponse : reponses) {
			JButton boutonReponse = new JButton(reponse.getReponse());
			boutonReponse.setFont(Constante.MARIO_FONT_MENU_3);
			// Si clic sur une reponse
			boutonReponse.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (reponse.isBonneReponse()) {
						// Si bonne reponse
						boutonReponse.setBackground(Color.GREEN);
						panelInfoReponse.setVisible(true);
						stop(mission, true, enigme);
					} else {
						// Si mauvaise reponse
						boutonReponse.setBackground(Color.RED);
						stop(mission, false, enigme);
					}
				}
			});
			panelReponses.add(boutonReponse);
		}
		
		// Panel info reponse
		String infoReponse = enigme.getInfoReponse();
		JLabel infoReponseLabel = new JLabel(infoReponse);
		infoReponseLabel.setFont(Constante.MARIO_FONT_MENU_2);
		panelInfoReponse.add(infoReponseLabel);
		panelInfoReponse.setVisible(false);
		
		// Panel Timer
		double maxTime = Constante.QUIZZ_MAX_TEMPS;
		JPanel panelTimer = new JPanel();
		labelTimer = new JLabel(String.valueOf(maxTime));
		labelTimer.setFont(Constante.MARIO_FONT_MENU_2);
		labelTimer.setBackground(Color.BLACK);
		timer = new Timer(10, new MyTimerActionListener(maxTime));
		panelTimer.add(labelTimer);
		
		// --
		
		BoxLayout boxlayout = new BoxLayout(panelCentre, BoxLayout.Y_AXIS);
		panelCentre.setLayout(boxlayout);
		
		panelCentre.add(panelQuestion);
		panelCentre.add(panelReponses);
		panelCentre.add(panelInfoReponse);
		panelCentre.add(panelTimer);

		// --
	
		this.setAlwaysOnTop(true);
		this.setSize(Constante.FENETRE_QUIZZ_DIMENSION);
		this.setMinimumSize(Constante.FENETRE_QUIZZ_DIMENSION);  
		centreFenetre();
		
		panelNord.setBackground(Color.BLACK);
		panelOuest.setBackground(Color.RED);
		panelCentre.setBackground(Color.WHITE);
		panelEst.setBackground(Color.GREEN);
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
		MusiqueManager.startPlayListEnBoucle(mission);
		this.setVisible(false);
		JLabel message = new JLabel("Debut du Quizz");
		message.setFont(Constante.MARIO_FONT_MENU_3);
		JOptionPane.showMessageDialog(this, message);
		this.setVisible(true);
		timer.start();
	}

	// Fin du jeu
	private void stop(Mission mission, boolean win, Enigme enigme) {

		timer.stop();
		
		MusiqueManager.stopAll();
		
		// Message fin du jeu
		if (win) {
			// TODO son bonne reponse
			MusiqueManager.playSon("sonParDefaut/motusWin.mp3");
			ImageIcon icon = FenetrePrincipal.getImageIcon("image/defaut/defautVictoire.png");
			ImageIcon resizeImage = ImageManager.resizeImage(icon, Constante.PERSO_IMAGE_DIMENSION_180_180);
			String message = "Bonne Reponse !";
			JLabel labelMessage = new JLabel(message);
			labelMessage.setForeground(Color.GREEN);
			labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
			JOptionPane.showMessageDialog(this, labelMessage, "Fin du Quizz", 0, resizeImage);
		} else {
			// TODO son mauvaise reponse
			MusiqueManager.playSon("sonParDefaut/maillonFaibleAuRevoir.mp3");
			ImageIcon icon = FenetrePrincipal.getImageIcon("image/defaut/defautDefaite.png");
			ImageIcon resizeImage = ImageManager.resizeImage(icon, Constante.PERSO_IMAGE_DIMENSION_180_180);
			String message = "Mauvaise Reponse !";
			JLabel labelMessage = new JLabel(message);
			labelMessage.setForeground(Color.RED);
			labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
			JOptionPane.showMessageDialog(this, labelMessage, "Fin du Quizz", 0, resizeImage);
		}
		
		// Refesh Liste Enigmes
		QuizzManager quizzManager = MenuPrincipal.getMainFrame().getCoreManager().getQuizzManager();
		quizzManager.refreshEnigme(enigme, win);

		// Fermeture des fenetres
		this.removeAll();
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

	public class MyTimerActionListener implements ActionListener {
		private double time;
		private double maxTime;
		private boolean fini = false;
		private boolean running = false;

		public MyTimerActionListener(double maxTime) {
			super();
			this.time = maxTime;
			this.maxTime = maxTime;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.time = time - 0.01;
			String format = String.format("%1$,.2f", time);
			labelTimer.setText(format);
			labelTimer.setForeground(Color.GREEN);
			if (time < (maxTime/2)) {
				labelTimer.setForeground(Color.ORANGE);
			}
			if (time < (maxTime/4)) {
				labelTimer.setForeground(Color.RED);
			}
			// Tic Tac quand il reste 3s
			if (time <= 3) {
				
				if (!running ) {
					MusiqueManager.playSon("sonParDefaut/tictacQuestion.mp3");
					running = true;
				}
				
			}
			if (time <= 0) {
				// TODO son Ding de fin de timer
//				MusiqueManager.playSon("sonParDefaut/ding.mp3");
				
				labelTimer.setText(String.format("%1$,.2f", new Double(0.0)));
				for (Reponse reponse : enigme.getReponsesPossibles()) {
					if (reponse.isBonneReponse()) {
						stop(mission, false, enigme);
						fini = true;
					}
				}
				if (!fini) {
					stop(mission, true, enigme);
				}
			}
		}

	}
}
