package core;

import java.io.File;
import java.io.Serializable;

import core.video.LecteurMP4;

public class VideoManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static LecteurMP4 lecteur;

	public void initialise() {
		lecteur = new LecteurMP4();
		lecteur.init();
	}
	
	public static void play(String mediaPath) {
		
		if (lecteur == null) {
			lecteur = new LecteurMP4();
			lecteur.init();
		}

		File file = new File("classes/" + mediaPath);
		
		if (file.exists()) {
			// Si execution du JAR
			lecteur.play("classes/" + mediaPath);
		} else {
			// Si execution en local
			lecteur.play("src/main/resources/" + mediaPath);
		}

	}

	public static void hideAndStop() {
		if (lecteur != null) {
			lecteur.hideAndStop();
		}
	}

	public static void show() {
		if (lecteur != null) {
			lecteur.show();
		}
	}

}
