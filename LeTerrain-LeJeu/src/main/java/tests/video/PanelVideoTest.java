package tests.video;

import java.awt.Color;
import java.awt.Component;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class PanelVideoTest extends JFrame {
	private EmbeddedMediaPlayerComponent component;
	private EmbeddedMediaPlayer player;

	public PanelVideoTest() {
		setUpPanel();
	}

	private void setUpPanel() {
//		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "VLCx86");
		new NativeDiscovery().discover();
		component = new EmbeddedMediaPlayerComponent();
		player = component.getMediaPlayer();

		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		setLayout(null);
		setBackground(Color.RED);
//		setAlignmentX(Component.LEFT_ALIGNMENT);
//		setBorder(emptyBorder);
	}

	public void setImageName(String imageName) {
		player.stop();
		player.prepareMedia(imageName);
		player.parseMedia();
		player.play();
	}

	public void setVideoName(final String videoTitle) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				player.stop();
				player.prepareMedia(videoTitle);
				player.parseMedia();
				player.play();
			}
		}).start();
	}
	
	public static void main(String[] args) throws InterruptedException {
//		JFrame frame = new JFrame("test");
//		frame.setSize(500, 500);
//		frame.setBackground(Color.BLUE);
		PanelVideoTest panelVideo = new PanelVideoTest();
		panelVideo.setBackground(Color.RED);
		panelVideo.setSize(400,400);
		panelVideo.setVisible(true);
		panelVideo.revalidate();
		panelVideo.repaint();
//		frame.revalidate();
//		frame.repaint();
//		frame.setContentPane(panelVideo);
//		frame.setVisible(true);

		panelVideo.setImageName("src/main/resources/image/ali.png");
//		panelVideo.setVideoName("src/main/resources/video/Trololo.mp4");
		
	}
}