package core;

import java.io.Serializable;
import java.net.URL;

import core.video.LecteurMP4;
import front.FenetrePrincipal;

public class VideoManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static LecteurMP4 lecteur;

	public void initialise() {
		lecteur = new LecteurMP4();
		lecteur.init();
	}
	
	public static void play(String mediaPath) {
		URL url = FenetrePrincipal.getURL(mediaPath);
		if (lecteur == null) {
			lecteur = new LecteurMP4();
			lecteur.init();
		}
		String file = url.getFile();
		System.out.println("Play Video : " + file);
		String path = url.getFile();
		path = path.replaceAll("C:/Users/Nathalie/git/YoRepo-Games/LeTerrain-LeJeu/", "");
		System.out.println("Play Video Cut : " + path);
		
		lecteur.play(path);
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
