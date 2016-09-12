package core;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageManager {
	
	public static ImageIcon resizeImage(ImageIcon image, int width, int height) {
		Image scaledInstance = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledInstance);
	}

}
