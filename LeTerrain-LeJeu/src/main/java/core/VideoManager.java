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
		System.out.println("Play Video MediaPath : " + mediaPath);
		URL url = FenetrePrincipal.getURL(mediaPath);
		if (lecteur == null) {
			lecteur = new LecteurMP4();
			lecteur.init();
		}
		String file = url.getFile();
		System.out.println("Play Video File : " + file);
		String path = url.getPath();
//		path = path.replaceAll("file:C:/Users/Nathalie/git/YoRepo-Games/LeTerrain-LeJeu/target", "");
//		path = path.replaceAll("file:/C:/Users/Johann/git/YoRepo-Games/LeTerrain-LeJeu/target/", "");
		System.out.println("Play Video Path : " + path);
		
		// TODO probleme lecture a partir du jar (essayer de gerer les 2 cas)
		// En local
		lecteur.play("src/main/resources/" + mediaPath);

		// A partir du jar
		
		// TODO switcher quand jar
//		lecteur.play("classes/" + mediaPath);

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
