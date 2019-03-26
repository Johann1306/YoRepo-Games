package core;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class ImageManager {
	
	private static Map<String,ImageIcon> proxyImages;
	
	public static ImageIcon resizeImage(ImageIcon image, Dimension dimension) {
		Image scaledInstance = image.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledInstance);
	}

	public static ImageIcon getImageIconProxy(String pathAndFileName) {
		
		if (proxyImages == null) {
			proxyImages = new HashMap<>();
		}
		
		// Si le chemin est null ou vide 
		if (pathAndFileName == null || pathAndFileName.isEmpty()) {
			
			// On retourne null
			return null;
		}
		
		// Si le proxy contient l'image
		if (proxyImages.containsKey(pathAndFileName)) {
			
			System.out.println("RETOURNE UNE IMAGE DU PROXY : " + pathAndFileName);
		
			// On retourne l'image du proxy
			return proxyImages.get(pathAndFileName);

		// Sinon si le proxy ne contient pas l'image
		} else {

			// On recupere l'image
			
		    // Si execution en local
			URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
		    
		    // Si execution du JAR
		    if (url == null) {
		    	File file = new File(pathAndFileName);
		    	try {
					url = file.toURL();
				} catch (MalformedURLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					return null;
				}
		    }
		    ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));

		    // On ajoute l'image à la map
		    proxyImages.put(pathAndFileName, imageIcon);
		    
		    // On retourne l'image		    
			return imageIcon;
		}

	}

}
