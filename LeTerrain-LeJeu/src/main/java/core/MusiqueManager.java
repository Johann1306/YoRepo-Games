package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import core.audio.Sound;
import front.MenuPrincipal;
import front.PanelMusique;
import modele.item.media.audio.Musique;
import modele.item.mission.Mission;

public class MusiqueManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Sound applicationEvenement = null;
	private static Sound applicationItem = null;
	private static Sound applicationMission = null;
	private static Sound applicationMenuPrincipal = null;
	private static boolean stopped = false;
	private List<Musique> musiques = null; 
	private List<Musique> musiquesCombat = null; 

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

		// Chargement des musiques de combat
		musiquesCombat = new ArrayList<Musique>();
		
		String musiquePath1 = "musique/combat/11-Zelda-battle.mp3";
		List<String> musiquePaths1 = new ArrayList<String>();
		musiquePaths1.add(musiquePath1);
		
		String musiquePath2 = "musique/combat/111-SoulCalibur-confrontation.mp3";
		List<String> musiquePaths2 = new ArrayList<String>();
		musiquePaths2.add(musiquePath2);
		
		String musiquePath3 = "musique/combat/13-Zelda-boss-battle.mp3";
		List<String> musiquePaths3 = new ArrayList<String>();
		musiquePaths3.add(musiquePath3);
		
		String musiquePath4 = "musique/combat/18.Zelda-boss-bgm.mp3";
		List<String> musiquePaths4 = new ArrayList<String>();
		musiquePaths4.add(musiquePath4);
		
		String musiquePath5 = "musique/combat/201-SecretOfMana-danger.mp3";
		List<String> musiquePaths5 = new ArrayList<String>();
		musiquePaths5.add(musiquePath5);
		
		String musiquePath6 = "musique/combat/303-SecretOfMana-oracle.mp3";
		List<String> musiquePaths6 = new ArrayList<String>();
		musiquePaths6.add(musiquePath6);
		
		String musiquePath7 = "musique/combat/307-SecretOfMana-meridian-dance.mp3";
		List<String> musiquePaths7 = new ArrayList<String>();
		musiquePaths7.add(musiquePath7);
		
		String musiquePath8 = "musique/combat/37-Zelda-middle-boss-battle.mp3";
		List<String> musiquePaths8 = new ArrayList<String>();
		musiquePaths8.add(musiquePath8);
		
		String musiquePath9 = "musique/combat/38-Zelda-dinosaur-boss-battle.mp3";
		List<String> musiquePaths9 = new ArrayList<String>();
		musiquePaths9.add(musiquePath9);
		
		String musiquePath10 = "musique/combat/77-Zelda-ganondorf-battle.mp3";
		List<String> musiquePaths10 = new ArrayList<String>();
		musiquePaths10.add(musiquePath10);
		
		musiquesCombat.add(new Musique(1, "", "", "", null, null, musiquePaths1, null, "", true));
		musiquesCombat.add(new Musique(2, "", "", "", null, null, musiquePaths2, null, "", true));
		musiquesCombat.add(new Musique(3, "", "", "", null, null, musiquePaths3, null, "", true));
		musiquesCombat.add(new Musique(4, "", "", "", null, null, musiquePaths4, null, "", true));
		musiquesCombat.add(new Musique(5, "", "", "", null, null, musiquePaths5, null, "", true));
		musiquesCombat.add(new Musique(6, "", "", "", null, null, musiquePaths6, null, "", true));
		musiquesCombat.add(new Musique(7, "", "", "", null, null, musiquePaths7, null, "", true));
		musiquesCombat.add(new Musique(8, "", "", "", null, null, musiquePaths8, null, "", true));
		musiquesCombat.add(new Musique(9, "", "", "", null, null, musiquePaths9, null, "", true));
		musiquesCombat.add(new Musique(10, "", "", "", null, null, musiquePaths10, null, "", true));
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
			if (applicationItem != null && applicationItem.isPlaying()) {
				applicationItem.stop();
			}
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

	public static void playPlaylistEnBoucle(List<String> sonPaths) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// Boucle infini
					while (!stopped) {
						for (String sonPath : sonPaths) {
							System.out.println("Play : " + sonPath);
							// Pause 1s entre 2 musiques
							if (!stopped) {
								Thread.sleep(1000);
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
			PanelMusique.application.stop();
		} catch (Exception e) {
			e.printStackTrace();
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

	public static void startPlayListEnBoucle(Mission mission) {
		if (mission.getJeu() == NomJeu.JEU_COMBAT) {
			// Lance une liste de musique de combat aleatoire
			List<Musique> musiquesCombat = MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager().getMusiquesCombat();
			List<String> sonPaths = new ArrayList<String>();
			List<Musique> temp = new ArrayList<Musique>(musiquesCombat);
			for (int i = 0 ; i < musiquesCombat.size() ; i++) {
				int random = RandomManager.random(0, temp.size()-1);
				Musique musiqueRandom = temp.get(random);			
				sonPaths.add(musiqueRandom.getSonPath().get(0));
				temp.remove(musiqueRandom);
			}
			playPlaylistEnBoucle(sonPaths);
		}
	}

}
