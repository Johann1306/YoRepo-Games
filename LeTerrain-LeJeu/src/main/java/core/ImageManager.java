package core;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageManager {
	
	public static ImageIcon resizeImage(ImageIcon image, Dimension dimension) {
		Image scaledInstance = image.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledInstance);
	}

}
