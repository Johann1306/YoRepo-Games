package core;

import core.video.LecteurMP4;

public class VideoManager {

	private static LecteurMP4 lecteur;

	public void initialise() {
		lecteur = new LecteurMP4();
		lecteur.init();
	}
	
	public static void play(String mediaPath) {
		lecteur.play(mediaPath);;
	}
}
