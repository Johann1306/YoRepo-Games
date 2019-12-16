package core.video;

import java.awt.Dimension;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.jna.NativeLibrary;

import front.FenetrePrincipal;
import front.MainFrame;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcjplayer.VlcjPlayer;

public class LecteurMP4 {

	private VlcjPlayer player = null;

	public LecteurMP4() {
		// TODO Auto-generated constructor stub
	}

	public void init() {
		// This will locate LibVLC for the vast majority of cases
		
//		System.setProperty("jna.library.path", "src/main/resources/lib");
//		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "win32-x86-64");
//		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "src/main/resources/lib");
//		System.loadLibrary("lib/libvlc.dll");
//		System.loadLibrary("src/main/resources/lib/libvlccore.dll");
		
		new NativeDiscovery().discover();
//		setLookAndFeel();
		player = new VlcjPlayer();
		  SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                player.show();
	            }
	        });
	}

	public void play(String mediaPath) {
//		if (player.isPlaying()) {
//			player.stop();
//			player.play(mediaPath);
//		} else {
//			player.play(mediaPath);
//		}
		Dimension size = MainFrame.getPanelDroite().getSize();
		player.getMainFrame().setSize(size);
		player.play(mediaPath);
		
	}
	
	private static void setLookAndFeel() {
		String lookAndFeelClassName;
		if (RuntimeUtil.isNix()) {
			lookAndFeelClassName = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
		} else {
			lookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
		}
		try {
			UIManager.setLookAndFeel(lookAndFeelClassName);
		} catch (Exception e) {
			// Silently fail, it doesn't matter
		}
	}

	public void hideAndStop() {
		player.hide();
		player.stop();
	}

	public void show() {
		player.show();
		
	}
}
