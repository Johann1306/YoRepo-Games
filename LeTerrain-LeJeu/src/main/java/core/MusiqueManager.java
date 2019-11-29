package core;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import org.controlsfx.control.Notifications;

import com.google.common.util.concurrent.Service.State;

import core.audio.Sound;
import core.configuration.Constante;
import front.FenetrePrincipal;
import front.FrameFootFX;
import front.MenuPrincipal;
import front.PanelMusique;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.input.MouseButton;
import javafx.geometry.Pos;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Window;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import modele.item.media.audio.Musique;
import modele.item.mission.Mission;
import modele.item.personnage.EnnemiType;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

@SuppressWarnings("restriction")
public class MusiqueManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Sound applicationEvenement = null;
	private static Sound applicationItem = null;
	private static Sound applicationMission = null;
	private static Sound applicationMenuPrincipal = null;
	private static boolean stopped = false;
	private List<Musique> musiques = null; 
	private List<Musique> musiquesCombat = null; 
	private List<Musique> musiquesFoot = null; 
	private List<Musique> musiquesBoss = null; 
	private List<Musique> musiquesShopEnfant = null; 
	private List<Musique> musiquesShopAdulte = null; 
	private List<Musique> musiquesQuizz = null; 
	private transient static JFrame frameMusique = null;

	private static JFXPanel jfxPanel;

	private static boolean popupDejaAffiche = false;

	public void initialise() {
		// Chargement des musiques a debloquer
		musiques = new ArrayList<Musique>();
		
		String sonPath1 = "son/01.Zelda-title.mp3";
		List<String> sonPaths1 = new ArrayList<String>();
		sonPaths1.add(sonPath1);

		String sonPath2 = "son/23-ending.mp3";
		List<String> sonPaths2 = new ArrayList<String>();
		sonPaths2.add(sonPath2);
		
		String sonPath3 = "son/18-overworld-bgm.mp3";
		List<String> sonPaths3 = new ArrayList<String>();
		sonPaths3.add(sonPath3);
		
		musiques.add(new Musique(1, "Zelda Intro Titre", "Nintendo", "", null, null, sonPaths1, null, "La musique d'intro de Zelda 3", true));
		musiques.add(new Musique(2, "Mario Fin", "Nintendo", "", null, null, sonPaths2, null, "La musique de fin de Mario", true));
		musiques.add(new Musique(3, "Mario Bonus", "Nintendo", "", null, null, sonPaths3, null, "La musique du niveau bonus de Mario", true));

		// Chargement des musiques de jeu
		musiquesCombat =  MusiqueManager.chargeMusiquesParRepertoire("musique/combat", 10000);
		musiquesBoss =  MusiqueManager.chargeMusiquesParRepertoire("musique/boss", 10500);
		musiquesShopEnfant =  MusiqueManager.chargeMusiquesParRepertoire("musique/shop/enfant", 11000);
		musiquesShopAdulte =  MusiqueManager.chargeMusiquesParRepertoire("musique/shop/adulte", 11500);
		musiquesQuizz =  MusiqueManager.chargeMusiquesParRepertoire("musique/quizz", 12000);
		musiquesFoot =  MusiqueManager.chargeMusiquesParRepertoire("musique/foot", 130000);
	}

	public static void play(Musique musique) {
		try {
			Sound application = new Sound(musique.getSonPath().get(0));
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						application.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			if (!t.isAlive()) {
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void playSon(String path) {
		try {
			Sound application = new Sound(path);
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						application.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			if (!t.isAlive()) {
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void playSonEvenement(String sonPath) {
		try {
			if (applicationEvenement != null && applicationEvenement.isPlaying()) {
				applicationEvenement.stop();
			}
			applicationEvenement = new Sound(sonPath);
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						applicationEvenement.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			if (!t.isAlive()) {
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void playSonItem(String sonPath) {
		try {
//			if (applicationItem != null && applicationItem.isPlaying()) {
//				applicationItem.stop();
//			}
			applicationItem = new Sound(sonPath);
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						applicationItem.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			if (!t.isAlive()) {
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void playSonMission(List<String> sonPaths) {
		try {
			if (applicationMission != null && applicationMission.isPlaying()) {
				applicationMission.stop();
			}
			applicationMission = new Sound(sonPaths.get(0));
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						// TODO gestion popup musique (probleme thread javafx necessite une JFXFrame initialisé)
//						popupInfoMusique(sonPaths.get(0));
						applicationMission.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			});
			if (!t.isAlive()) {
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void playPlaylist(List<String> sonPaths) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (String sonPath : sonPaths) {
						// Pause 500ms entre 2 musiques
							Thread.sleep(500);
							if (applicationMenuPrincipal == null) {
								applicationMenuPrincipal = new Sound(sonPath);
								applicationMenuPrincipal.play();
							} else {
//								applicationMenuPrincipal.stop();
								applicationMenuPrincipal = new Sound(sonPath);
								applicationMenuPrincipal.play();
							}
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		if (!t.isAlive()) {
			t.start();
		}
	}

	public static void stopAll() {
		try {
			if (applicationMenuPrincipal != null) {
				applicationMenuPrincipal.stop();
			}
			if (applicationEvenement != null) {
				applicationEvenement.stop();
			}
			if (applicationItem != null) {
				applicationItem.stop();
			}
			if (applicationMission != null) {
				applicationMission.stop();
			}
			stopped = true;
			PanelMusique.application.stop();
			System.out.println("-------Stop all lecteurs---------");
		} catch (Exception e) {
			System.out.println("Erreur lors de l arret du lecteur : " + e.getMessage() + " :: " + e);
		}
	}
	

	public List<Musique> getMusiques() {
		return musiques;
	}

	public void setMusiques(List<Musique> musiques) {
		this.musiques = musiques;
	}

	public List<Musique> getMusiquesDisponibles() {
		List<Musique> musiquesDisponibles = new ArrayList<Musique>();
		for (Musique musique : musiques) {
			if (musique.isDisponible()) {
				musiquesDisponibles.add(musique);
			}
		}
		return musiquesDisponibles;
	}

	public List<Musique> getMusiquesCombat() {
		return musiquesCombat;
	}

	private List<Musique> getMusiquesFoot() {
		return musiquesFoot;
	}
	
	public List<Musique> getMusiquesBoss() {
		return musiquesBoss;
	}
	
	public List<Musique> getMusiquesShopEnfant() {
		return musiquesShopEnfant;
	}

	public List<Musique> getMusiquesShopAdulte() {
		return musiquesShopAdulte;
	}

	
	public List<Musique> getMusiquesQuizz() {
		return musiquesQuizz;
	}

	public static void startPlayListEnBoucle(Mission mission) {
		System.out.println("startPlayListEnBoucle()");
		List<Musique> musiques = new ArrayList<>();
		if (mission.getJeu() == NomJeu.JEU_COMBAT) {
			
			if(mission.getTypeEnnemis().name().equals(EnnemiType.BOSS.name())) {
				// Lance une liste de musique de combat aleatoire BOSS
				musiques = MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager().getMusiquesBoss();
			} else {
				// Lance une liste de musique de combat aleatoire
				musiques = MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager().getMusiquesCombat();
				
			}
			
		} else if (mission.getJeu() == NomJeu.JEU_SHOP_ENFANT) {
			// Lance une liste de musique de boutique aleatoire
			musiques = MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager().getMusiquesShopEnfant();
		
		} else if (mission.getJeu() == NomJeu.JEU_SHOP_ADULTE) {
			// Lance une liste de musique de boutique aleatoire
			musiques = MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager().getMusiquesShopAdulte();
		
		} else if (mission.getJeu() == NomJeu.JEU_QUIZZ) {
			// Lance une liste de musique de quizz aleatoire
			musiques = MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager().getMusiquesQuizz();
		
		} else if (mission.getJeu() == NomJeu.JEU_FOOT) {
			// Lance une liste de musique de foot aleatoire
			musiques = MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager().getMusiquesFoot();
		} 	
		
		
		List<String> sonPaths = new ArrayList<String>();
		List<Musique> temp = new ArrayList<Musique>(musiques);
		for (int i = 0 ; i < musiques.size() ; i++) {
			int random = RandomManager.random(0, temp.size()-1);
			Musique musiqueRandom = temp.get(random);			
			sonPaths.add(musiqueRandom.getSonPath().get(0));
			temp.remove(musiqueRandom);
		}
		stopped = false;
		playPlaylistEnBoucle(sonPaths);
		
	}

	public static void startPlayListPerso(PersoPrenom prenom) {
		System.out.println("startPlayListEnBoucle()");
		
		stopAll();
		
		PersonnagePrincipal perso = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoByPrenom(prenom);
		
		// Lance la liste de musique d'ambiance aleatoire pour un perso
		List<Musique> musiques = perso.getMusiques();
		List<String> sonPaths = new ArrayList<String>();
		List<Musique> temp = new ArrayList<>(musiques);
		for (int i = 0 ; i < musiques.size() ; i++) {
			int random = RandomManager.random(0, temp.size()-1);
			Musique musiqueRandom = temp.get(random);			
			sonPaths.add(musiqueRandom.getSonPath().get(0));
			temp.remove(musiqueRandom);
		}
		playSonMission(sonPaths);
		
	}
	
	public static void playPlaylistEnBoucle(List<String> sonPaths) {
//		System.out.println("playPlaylistEnBoucle()");

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("STOPPED : " + stopped);
					while (!stopped) {
						for (String sonPath : sonPaths) {
							System.out.println("Play : " + sonPath);
							// Pause 1s entre 2 musiques
							if (!stopped) {
								Thread.sleep(500);
								if (applicationMenuPrincipal == null) {
									applicationMenuPrincipal = new Sound(sonPath);
									applicationMenuPrincipal.play();
								} else {
									applicationMenuPrincipal = new Sound(sonPath);
									applicationMenuPrincipal.play();
								}
							}
						}
					}
					stopped = false;
					System.out.println("STOPPED : " + stopped);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		if (!t.isAlive()) {
			t.start();
		}
	}
	
	public static void stopPlaylistEnBoucle() {
		try {
			if (applicationMenuPrincipal != null) {
				applicationMenuPrincipal.stop();
			}
			stopped = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Musique> chargeMusiquesParRepertoire(String repertoire, int i) {
		int id = i;
		List<Musique> musiquesPerso = new ArrayList<>();
		System.out.println("Repertoire : " + repertoire);
		
		// Si execution en local
		URL url = FenetrePrincipal.getURL(repertoire);
		System.out.println("URL : " + url);
		File rep = new File(url.getPath());
		System.out.println("File rep : " + rep);
		String[] list = rep.list();
		
		// Si execution du JAR
		if(list == null) {
			rep = new File("classes/" + repertoire);
			list = rep.list();
		}
		
		for (String path : list) {
			System.out.println("Path : " + path);
			List<String> sonPath = new ArrayList<>();
			sonPath.add(repertoire + "/" + path);
			System.out.println("sonPAth.add(" + repertoire + "/" + path + ")");
			Musique musique = new Musique(id, path, "artiste", "album", DateManager.genereUneDate(1990, 8, 1, 10, 0, 0), null, sonPath, null, "informations", true);
			musiquesPerso.add(musique);
			id++;
		}
		
		return musiquesPerso;
	}

	public static void playMusiquesRandom(List<Musique> musiques) {
		int random = RandomManager.random(0, musiques.size()-1);
		playSonEvenement(musiques.get(random).getSonPath().get(0));
	}
	
	public static void playSonRandom(List<Musique> musiques) {
		int random = RandomManager.random(0, musiques.size()-1);
		playSonItem(musiques.get(random).getSonPath().get(0));
	}
	
	public static void popupInfoMusique(String musiquePath) {
		
		String[] tab = musiquePath.split("/");
//		String[] artisteMusique = tab[tab.length-1].split("-");
//		String artiste = artisteMusique[0];
//		String musique = artisteMusique[1];
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initAndShowGUI(tab);
			}
		});
		
	}
	
	private static void initAndShowGUI(String[] tab) {
		
//		Window window = new Window();
//		Screen screen = new Screen();
		
		if (frameMusique == null) {
			frameMusique = new JFrame();
			frameMusique.setSize(200,200);
//			frameMusique.setExtendedState(JFrame.MAXIMIZED_BOTH);
//			frameMusique.setAlwaysOnTop(true);
			jfxPanel = new JFXPanel();
			JPanel content = new JPanel();
			content.setLayout(new BorderLayout());
			content.add(jfxPanel);
			frameMusique.setContentPane(content);
			frameMusique.setVisible(true);
		}
		
		frameMusique.setVisible(true);
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
				initFX(tab);
//			}
//		}).start();
		
	}
	
	private static void initFX(String[] tab) {

		Group root = new Group();
		Scene scene = new Scene(root, Color.BLACK);
		root.getChildren().add(new Label("test"));
		jfxPanel.setScene(scene);
		
		popupDejaAffiche = false;
		
		
		// TODO reporter la gestion de la popup dans la classe MainFrame
		scene.addEventFilter(MouseEvent.ANY, e -> {
			
			if (!popupDejaAffiche) {
				popupDejaAffiche  = true;
				ImageView resizedImage = ImageManager.resizeImageView(new Image("image/ihm/note.jpg"),
						Constante.POPUP_IMAGE_DIMENSION_100_100);
				Notifications.create()
				.darkStyle()
				// .title("Title")
				.text(tab[tab.length - 1])
				.hideCloseButton()
				.position(Pos.BOTTOM_LEFT)
				// .graphic(new Rectangle(100, 100, Color.DARKGRAY.deriveColor(1, 1, 1, 0))) // sets node to display
				.graphic(resizedImage)
				.hideAfter(Duration.seconds(3))
				.show();
			}
		});
		
	}	
}
