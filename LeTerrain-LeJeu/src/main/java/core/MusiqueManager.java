package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import core.audio.Sound;
import front.PanelMusique;
import modele.item.media.audio.Musique;

public class MusiqueManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Sound applicationEvenement = null;
	private static Sound applicationItem = null;
	private static Sound applicationMission = null;
	private static Sound applicationMenuPrincipal = null;
	private static boolean stopped = false;
	private List<Musique> musiques = null; 

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
		
		musiques.add(new Musique(1, "Zelda intro titre", "Nintendo", "", null, null, sonPaths1, null, "La musique d'intro de Zelda 3", true));
		musiques.add(new Musique(2, "Mario fin", "Nintendo", "", null, null, sonPaths2, null, "La musique de fin de Mario", true));
		musiques.add(new Musique(3, "Mario Bonus", "Nintendo", "", null, null, sonPaths3, null, "La musique du niveau bonus de Mario", true));
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
						// Pause 1s entre 2 musiques
							Thread.sleep(1000);
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

	public static void stop() {
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

}
