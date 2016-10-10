package core.audio;

import front.FenetrePrincipal;
import javazoom.jl.player.Player;

// MP3, WMA, MPEG, WAV compatible

public class Sound {

	private boolean isPlaying = false;
	private Player player = null;
	private int position = 0;

	public Sound(String path) throws Exception {
		System.out.println("Play : " + path);
		player = new Player(FenetrePrincipal.getStream(path));
	}

	public void play() throws Exception {
		if (player != null) {
			isPlaying = true;
			player.play();
		}
	}

	public void pause() throws Exception {
//		if (player != null) {
//			if (isPlaying()) {
//				isPlaying = false;
//				position = player.getPosition();
//				System.out.println("Pause 1 : " + position);
//				player.close();
//			} else {
//				System.out.println("Pause 2 : " + position);
//				isPlaying = true;
//				player.play(position);	
//			}
//			
//		}
	}

	public void stop() throws Exception {
		if (player != null) {
			isPlaying = false;
			player.close();
		}
	}

	public boolean isPlaying() {
		return isPlaying;
	}
	
	public boolean isFinished() {
		return player.isComplete();
	}

}