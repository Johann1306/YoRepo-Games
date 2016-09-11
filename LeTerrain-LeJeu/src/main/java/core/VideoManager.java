package core;

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
		lecteur.play(mediaPath);
	}

	public static void hide() {
		if (lecteur != null) {
			lecteur.hide();
		}
	}

}
