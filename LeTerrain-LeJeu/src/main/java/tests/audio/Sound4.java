package tests.audio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.advanced.*;

// MP3, WMA, MPEG, WAV compatible

public class Sound4 {

	private boolean isPlaying = false;
	private AdvancedPlayer player = null;

	public Sound4(String path) throws Exception {
		InputStream in = (InputStream) new BufferedInputStream(new FileInputStream(new File(path)));
		player = new AdvancedPlayer(in);
	}

	public Sound4(String path, PlaybackListener listener) throws Exception {
		InputStream in = (InputStream) new BufferedInputStream(new FileInputStream(new File(path)));
		player = new AdvancedPlayer(in);
		player.setPlayBackListener(listener);
	}

	public void play() throws Exception {
		if (player != null) {
			isPlaying = true;
			player.play();
		}
	}

	public void play(int begin, int end) throws Exception {
		if (player != null) {
			isPlaying = true;
			boolean play = player.play(begin, end);
			System.out.println("play : " + play);
		}
	}

	public void stop() throws Exception {
		if (player != null) {
			isPlaying = false;
			player.stop();
		}
	}

	public boolean isPlaying() {
		return isPlaying;
	}

}