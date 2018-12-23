package core.audio;

import front.FenetrePrincipal;
import javazoom.jl.player.Player;

// MP3, WMA, MPEG, WAV compatible

public class Sound {

	private boolean isPlaying = false;
	private Player player = null;
//	private static Player player = null;
	private int position = 0;

	public Sound(String path) throws Exception {
		if (player != null) {
			player.close();
		}
		player = new Player(FenetrePrincipal.getStream(path));
	}

	public void play() throws Exception {
		System.out.println("1 Play() ......");
		if (player != null) {
			System.out.println("2 Player isPlaying() " + isPlaying);
			if (isPlaying) {
				System.out.println("3 Player close()");
				player.close();
			}
			isPlaying = true;
			System.out.println("4 Player play()");
			player.play();
		} else {
			System.out.println("0 Player == null");
		}
		System.out.println("5 Player ...... OK");
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