package front;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import core.ImageManager;
import core.LieuManager;
import core.MissionManager;
import core.MusiqueManager;
import core.PersonnageManager;
import core.SauvegardeManager;
import core.VideoManager;
import core.configuration.Constante;
import modele.evenement.EvenementTheme;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.PersoPrenom;

public class MenuPrincipal extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final Border BORDER = BorderFactory.createLineBorder(Color.YELLOW, 3);
	private static MainFrame mainFrame;
	private JPanel panelDifficulte = null;
	private static JButton boutonQuit = null;

	public MenuPrincipal() {
	}

	public void initialise() {
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxlayout);

		JButton boutonNew = new JButton("Nouvelle Partie");
		JButton boutonContinue = new JButton("Continuer");
		JButton boutonLoad = new JButton("Charger");
		JButton boutonEdit = new JButton("Editer");
		JButton boutonJeux = new JButton("Jeux");
		JButton boutonScore = new JButton("Score");
		boutonQuit = new JButton("Quitter");

		boutonNew.setFont(Constante.MARIO_FONT_MENU);
		boutonContinue.setFont(Constante.MARIO_FONT_MENU);
		boutonLoad.setFont(Constante.MARIO_FONT_MENU);
		boutonEdit.setFont(Constante.MARIO_FONT_MENU);
		boutonJeux.setFont(Constante.MARIO_FONT_MENU);
		boutonScore.setFont(Constante.MARIO_FONT_MENU);
		boutonQuit.setFont(Constante.MARIO_FONT_MENU);

		boutonNew.setBackground(Color.BLACK);
		boutonContinue.setBackground(Color.BLACK);
		boutonLoad.setBackground(Color.BLACK);
		boutonEdit.setBackground(Color.BLACK);
		boutonJeux.setBackground(Color.BLACK);
		boutonScore.setBackground(Color.BLACK);
		boutonQuit.setBackground(Color.BLACK);

		boutonNew.setForeground(Color.WHITE);
		boutonContinue.setForeground(Color.WHITE);
		boutonLoad.setForeground(Color.WHITE);
		boutonEdit.setForeground(Color.WHITE);
		boutonJeux.setForeground(Color.WHITE);
		boutonScore.setForeground(Color.WHITE);
		boutonQuit.setForeground(Color.WHITE);
		
		Dimension max = new Dimension(boutonNew.getMaximumSize().width+50, boutonNew.getMaximumSize().height);

		boutonNew.setMaximumSize(max); // taille de reference
		boutonContinue.setMaximumSize(boutonNew.getMaximumSize());
		boutonLoad.setMaximumSize(boutonNew.getMaximumSize());
		boutonEdit.setMaximumSize(boutonNew.getMaximumSize());
		boutonJeux.setMaximumSize(boutonNew.getMaximumSize());
		boutonScore.setMaximumSize(boutonNew.getMaximumSize());
		boutonQuit.setMaximumSize(boutonNew.getMaximumSize());

		boutonNew.setFocusable(false);
		boutonContinue.setFocusable(false);
		boutonLoad.setFocusable(false);
		boutonEdit.setFocusable(false);
		boutonJeux.setFocusable(false);
		boutonScore.setFocusable(false);
		boutonQuit.setFocusable(false);

		boutonNew.setBorder(null);
		boutonContinue.setBorder(null);
		boutonLoad.setBorder(null);
		boutonEdit.setBorder(null);
		boutonJeux.setBorder(null);
		boutonScore.setBorder(null);
		boutonQuit.setBorder(null);

		// Actions des boutons
		boutonNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Cachage MenuPrincipal
				MenuPrincipal menuPrincipal = getMenuPrincipal();
				Component[] components = menuPrincipal.getComponents();
				for (Component component : components) {
					component.setVisible(false);
				}
				
				panelDifficulte = new JPanel();
				BoxLayout boxlayout = new BoxLayout(panelDifficulte, BoxLayout.Y_AXIS);
				panelDifficulte.setLayout(boxlayout);
				
				JButton boutonFacile = new JButton(Difficulte.FACILE.name());
				JButton boutonNormal = new JButton(Difficulte.NORMAL.name());
				JButton boutonDifficile = new JButton(Difficulte.DIFFICILE.name());
				JButton boutonHeroique = new JButton(Difficulte.HEROIQUE.name());
				
				boutonFacile.setFont(Constante.MARIO_FONT_MENU);
				boutonNormal.setFont(Constante.MARIO_FONT_MENU);
				boutonDifficile.setFont(Constante.MARIO_FONT_MENU);
				boutonHeroique.setFont(Constante.MARIO_FONT_MENU);
				
				boutonFacile.setBackground(Color.BLACK);
				boutonNormal.setBackground(Color.BLACK);
				boutonDifficile.setBackground(Color.BLACK);
				boutonHeroique.setBackground(Color.BLACK);
				
				boutonFacile.setForeground(Color.WHITE);
				boutonNormal.setForeground(Color.WHITE);
				boutonDifficile.setForeground(Color.WHITE);
				boutonHeroique.setForeground(Color.WHITE);

				boutonFacile.setMaximumSize(boutonNew.getMaximumSize());
				boutonNormal.setMaximumSize(boutonNew.getMaximumSize());
				boutonDifficile.setMaximumSize(boutonNew.getMaximumSize());
				boutonHeroique.setMaximumSize(boutonNew.getMaximumSize());
				
				boutonFacile.setFocusable(false);
				boutonNormal.setFocusable(false);
				boutonDifficile.setFocusable(false);
				boutonHeroique.setFocusable(false);
			
				boutonFacile.setBorder(null);
				boutonNormal.setBorder(null);
				boutonDifficile.setBorder(null);
				boutonHeroique.setBorder(null);

				boutonFacile.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lanceNouvellePartie(Difficulte.FACILE);
					}
				});
				boutonNormal.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lanceNouvellePartie(Difficulte.NORMAL);
					}
				});
				boutonDifficile.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lanceNouvellePartie(Difficulte.DIFFICILE);
					}
				});
				boutonHeroique.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lanceNouvellePartie(Difficulte.HEROIQUE);
					}
				});
				
				// Refresh Font on focus
				boutonFacile.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
						boutonFacile.setFont(Constante.MARIO_FONT_MENU);
						boutonFacile.setBorder(null);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						boutonFacile.setFont(Constante.MARIO_FONT_MENU_3);
						boutonFacile.setBorder(BORDER);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				boutonNormal.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
						boutonNormal.setFont(Constante.MARIO_FONT_MENU);
						boutonNormal.setBorder(null);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						boutonNormal.setFont(Constante.MARIO_FONT_MENU_3);
						boutonNormal.setBorder(BORDER);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				boutonDifficile.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
						boutonDifficile.setFont(Constante.MARIO_FONT_MENU);
						boutonDifficile.setBorder(null);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						boutonDifficile.setFont(Constante.MARIO_FONT_MENU_3);
						boutonDifficile.setBorder(BORDER);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				boutonHeroique.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
						boutonHeroique.setFont(Constante.MARIO_FONT_MENU);
						boutonHeroique.setBorder(null);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						boutonHeroique.setFont(Constante.MARIO_FONT_MENU_3);
						boutonHeroique.setBorder(BORDER);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				panelDifficulte.add(boutonFacile);
				panelDifficulte.add(boutonNormal);
				panelDifficulte.add(boutonDifficile);
				panelDifficulte.add(boutonHeroique);
				
				menuPrincipal.add(panelDifficulte);
			}
			
		});
		boutonContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusiqueManager.playSon("son/Super_mario_bros_coin_sound_effect.mp3");
				MusiqueManager.stopPlaylistEnBoucle();
				MainFrame oldMainFrame = MenuPrincipal.getMainFrame();
				if (oldMainFrame != null) {
					oldMainFrame.dispose();
				}
				mainFrame = SauvegardeManager.load();
				mainFrame.startMainFrame();
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
				fenetrePrincipal.hide();
				MainFrame.getPanelCentre().refreshPanelCourant();
				MainFrame.getPanelPersonnage().refreshArriveePersonnage();
				MainFrame.getPanelPersonnage().refreshMortsPersonnage();
			}
		});
		boutonLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusiqueManager.playSon("son/Super_mario_bros_coin_sound_effect.mp3");
				MusiqueManager.stopPlaylistEnBoucle();
				MainFrame oldMainFrame = MenuPrincipal.getMainFrame();
				if (oldMainFrame != null) {
					oldMainFrame.dispose();
				}
				mainFrame = SauvegardeManager.load();
				mainFrame.startMainFrame();
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
				fenetrePrincipal.hide();
				MainFrame.getPanelCentre().refreshPanelCourant();
				MainFrame.getPanelPersonnage().refreshArriveePersonnage();
				MainFrame.getPanelPersonnage().refreshMortsPersonnage();
			}
		});
		boutonEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusiqueManager.playSon("son/Super_mario_bros_coin_sound_effect.mp3");
				MusiqueManager.stopPlaylistEnBoucle();
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
	//			fenetrePrincipal.hide();
			}
		});
		boutonJeux.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusiqueManager.playSon("son/Super_mario_bros_coin_sound_effect.mp3");
				MusiqueManager.stopPlaylistEnBoucle();
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
	//			fenetrePrincipal.hide();
			}
		});
		boutonScore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusiqueManager.playSon("son/Super_mario_bros_coin_sound_effect.mp3");
				MusiqueManager.stopPlaylistEnBoucle();
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
	//			fenetrePrincipal.hide();
			}
		});
		boutonQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusiqueManager.playSon("son/Super_mario_bros_coin_sound_effect.mp3");
				demandeConfirmationQuitter();
			}

		});

		// Refresh Font on focus
		boutonNew.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonNew.setFont(Constante.MARIO_FONT_MENU);
				boutonNew.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonNew.setFont(Constante.MARIO_FONT_MENU_3);
				boutonNew.setBorder(BORDER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonContinue.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonContinue.setFont(Constante.MARIO_FONT_MENU);
				boutonContinue.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonContinue.setFont(Constante.MARIO_FONT_MENU_3);
				boutonContinue.setBorder(BORDER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonLoad.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonLoad.setFont(Constante.MARIO_FONT_MENU);
				boutonLoad.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonLoad.setFont(Constante.MARIO_FONT_MENU_3);
				boutonLoad.setBorder(BORDER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonEdit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonEdit.setFont(Constante.MARIO_FONT_MENU);
				boutonEdit.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonEdit.setFont(Constante.MARIO_FONT_MENU_3);
				boutonEdit.setBorder(BORDER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonJeux.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonJeux.setFont(Constante.MARIO_FONT_MENU);
				boutonJeux.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonJeux.setFont(Constante.MARIO_FONT_MENU_3);
				boutonJeux.setBorder(BORDER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonScore.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonScore.setFont(Constante.MARIO_FONT_MENU);
				boutonScore.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonScore.setFont(Constante.MARIO_FONT_MENU_3);
				boutonScore.setBorder(BORDER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonQuit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonQuit.setFont(Constante.MARIO_FONT_MENU);
				boutonQuit.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonQuit.setFont(Constante.MARIO_FONT_MENU_3);
				boutonQuit.setBorder(BORDER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		this.add(boutonNew);
		this.add(boutonContinue);
		this.add(boutonLoad);
		this.add(boutonEdit);
		this.add(boutonJeux);
		this.add(boutonScore);
		this.add(boutonQuit);
//		this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}
	
	private void lanceNouvellePartie(Difficulte difficulte) {
		
		// TODO son clic en fonction de la difficulte (Facile/bebe ou tetine, Normal/bruit d'epee, Difficile/pistolet, Heroique/hahaha)
		MusiqueManager.stopPlaylistEnBoucle();
		MusiqueManager.playSon("son/Super_mario_bros_coin_sound_effect.mp3");
		
		// Reaffichage panel Menu
		Component[] components = this.getComponents();
		for (Component component : components) {
			component.setVisible(true);
		}
		// Supression panelDifficulte
		panelDifficulte.removeAll();
		panelDifficulte.setVisible(false);
		
		mainFrame = new MainFrame(difficulte);
		mainFrame.startMainFrame();
		FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
		fenetrePrincipal.hide();
//		parent.show();
		
		VideoManager.play("video/debut/PlaystationIntro.mp4");		

		// Message debut
		JLabel messageIntro1 = new JLabel("Attention !!! Message de prevention !");
		JLabel messageIntro2 = new JLabel("Le contenu de ce jeu peut ne pas etre approprie a tous les ages, toutes les sensibilites et tous les sexes!");
		JLabel messageIntro3 = new JLabel("Il a ete developpe par une equipe multiconfessionnelle et d'horizons culturels differents!");
		JLabel messageIntro4 = new JLabel("Les personnages et les situations de ce recit etant purement fictifs...");
		JLabel messageIntro5 = new JLabel("Toute ressemblance avec des personnes ou des situations existantes ne saurait etre que fortuite!");
		
		messageIntro1.setFont(Constante.MARIO_FONT_MENU_2);
		messageIntro2.setFont(Constante.MARIO_FONT_MENU_2);
		messageIntro3.setFont(Constante.MARIO_FONT_MENU_2);
		messageIntro4.setFont(Constante.MARIO_FONT_MENU_2);
		messageIntro5.setFont(Constante.MARIO_FONT_MENU_2);
		
		JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), messageIntro1, EvenementTheme.SORTIE_JEU_VIDEO.getNom(), JOptionPane.WARNING_MESSAGE, null);
		JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), messageIntro2, EvenementTheme.SORTIE_JEU_VIDEO.getNom(), JOptionPane.WARNING_MESSAGE, null);
		JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), messageIntro3, EvenementTheme.SORTIE_JEU_VIDEO.getNom(), JOptionPane.INFORMATION_MESSAGE, null);
		JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), messageIntro4, EvenementTheme.SORTIE_JEU_VIDEO.getNom(), JOptionPane.INFORMATION_MESSAGE, null);
		JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), messageIntro5, EvenementTheme.SORTIE_JEU_VIDEO.getNom(), JOptionPane.ERROR_MESSAGE, null);
			
		
		
		// Choix du perso principal
		PersonnageManager personnageManager = mainFrame.getCoreManager().getPersonnageManager();
		MissionManager missionManager = mainFrame.getCoreManager().getMissionManager();
		LieuManager lieuManager = mainFrame.getCoreManager().getLieuManager();
		
		VideoManager.play("video/debut/zoom.mp4");
		
		// Son menu choix du perso (zelda theme)
		List<String> sonPaths = new ArrayList<>();
		sonPaths.add("musique/personnage/selection/11.zelda-select-screen.mp3");
		MusiqueManager.playPlaylist(sonPaths);
		
		ImageIcon resizeImage = ImageManager.resizeImage(FenetrePrincipal.getImageIcon("image/defaut/defautSelection.png"), Constante.PERSO_IMAGE_DIMENSION_64_64);
		JLabel message = new JLabel("Choisis ton hero principal");
		message.setFont(Constante.MARIO_FONT_MENU_3);
		int valeur = JOptionPane.showOptionDialog(getParent(), message,
				"C'est parti!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				resizeImage,
				new String[] {"Johann", "Nicolas", "Pierre", "Thomas", "Yannick"}, 
				"default");
		
		MusiqueManager.stopAll();

		
		if (valeur == 0) {
			personnageManager.setPersonnagePrincipal(PersoPrenom.Johann);
			personnageManager.getPersoByPrenom(PersoPrenom.Johann).setDisponible(true);
			missionManager.getMissionById(101).setDejaFaite(true);
			missionManager.distribueRecompenses(missionManager.getMissionById(101), true);
		} else if (valeur == 1) {
			personnageManager.setPersonnagePrincipal(PersoPrenom.Nicolas);
			personnageManager.getPersoByPrenom(PersoPrenom.Nicolas).setDisponible(true);
			missionManager.getMissionById(103).setDejaFaite(true);
			missionManager.distribueRecompenses(missionManager.getMissionById(103), true);
		} else if (valeur == 2) {
			personnageManager.setPersonnagePrincipal(PersoPrenom.Pierre);
			personnageManager.getPersoByPrenom(PersoPrenom.Pierre).setDisponible(true);
			missionManager.getMissionById(102).setDejaFaite(true);
			missionManager.distribueRecompenses(missionManager.getMissionById(102), true);
		} else if (valeur == 3) {
			personnageManager.setPersonnagePrincipal(PersoPrenom.Thomas);
			personnageManager.getPersoByPrenom(PersoPrenom.Thomas).setDisponible(true);
			missionManager.getMissionById(105).setDejaFaite(true);
			missionManager.distribueRecompenses(missionManager.getMissionById(105), true);
		} else if (valeur == 4) {
			personnageManager.setPersonnagePrincipal(PersoPrenom.Yannick);
			personnageManager.getPersoByPrenom(PersoPrenom.Yannick).setDisponible(true);
			missionManager.getMissionById(104).setDejaFaite(true);
			missionManager.distribueRecompenses(missionManager.getMissionById(104), true);
		} 
		// On Debloque l'école des le debut
		lieuManager.getLieuById(9).setDisponible(true);
		MainFrame.getPanelPersonnage().refreshArriveePersonnage();
	}

	public void demandeConfirmationQuitter() {
		ImageIcon resizeImage = ImageManager.resizeImage(FenetrePrincipal.getImageIcon("image/defaut/defautEvenement.png"), Constante.PERSO_IMAGE_DIMENSION_180_180);
		int confirme = JOptionPane.showOptionDialog(getParent(), "T'es sur de vouloir t'arreter maintenant?",
				"Attention jeune puceau", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, resizeImage,
				new String[] { "Oui, je suis sur!", "Nan attends, je vais continuer un peu..." }, "default");
		if (confirme == 0) {
			System.exit(0);
		}
	}
	
	public static MainFrame getMainFrame(){
		return mainFrame;
	}
	
	public static MenuPrincipal getMenuPrincipal(){
		return (MenuPrincipal) boutonQuit.getParent();
	}

	public static void setMainFrame(MainFrame frame) {
		mainFrame = frame;
	}
}
