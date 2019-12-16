package core;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
	
	public static List<String> chargeVideosParRepertoire(String repertoire) {
		List<String> videoPath = new ArrayList<>();
		
		// Si execution en local
		URL url = FenetrePrincipal.getURL(repertoire);
		if (url != null) {
			File rep = new File(url.getPath());
			String[] list = rep.list();
			
			// Si execution du JAR
			if(list == null) {
				rep = new File("classes/" + repertoire);
				list = rep.list();
			}
			
			for (String path : list) {
				videoPath.add(repertoire + "/" + path);
			}
		}
		
		return videoPath;
	}

}
