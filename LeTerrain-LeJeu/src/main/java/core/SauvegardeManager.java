package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import front.MainFrame;
import front.MenuPrincipal;

public class SauvegardeManager {

	public static void save() {

		System.out.println("sauvegarde");
		CoreManager coreManager = MenuPrincipal.getMainFrame().getCoreManager();
		ObjectOutputStream oos = null;

		FileOutputStream fichierOut;
		try {
			fichierOut = new FileOutputStream("save.ser");
			oos = new ObjectOutputStream(fichierOut);
			oos.writeObject(coreManager);
			oos.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("fin sauvegarde");
	}
	
	public static MainFrame load() {
		System.out.println("Chargement");
		ObjectInputStream ois = null;
		MainFrame frame = null;
		
		try {
			final FileInputStream fichierIn = new FileInputStream("save.ser");
			ois = new ObjectInputStream(fichierIn);
			CoreManager manager = (CoreManager) ois.readObject();
			frame = new MainFrame(manager);
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("fin Chargement");
		return frame;
	}
	
}
