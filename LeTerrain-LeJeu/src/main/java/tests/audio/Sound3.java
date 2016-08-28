package tests.audio;

import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.media.ClockStoppedException;
import javax.media.Control;
import javax.media.Controller;
import javax.media.ControllerListener;
import javax.media.GainControl;
import javax.media.IncompatibleSourceException;
import javax.media.IncompatibleTimeBaseException;
import javax.media.Player;
import javax.media.Time;
import javax.media.TimeBase;
import javax.media.protocol.DataSource;


public class Sound3 {
	
	private boolean isPlaying = false;
	private Player player;

	public Sound3(String path) throws Exception {
		InputStream in = (InputStream) new BufferedInputStream(new FileInputStream(new File(path)));
		player = new Player() {
			
			@Override
			public Time getDuration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void syncStart(Time arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTimeBase(TimeBase arg0) throws IncompatibleTimeBaseException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStopTime(Time arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public float setRate(float arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void setMediaTime(Time arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Time mapToTimeBase(Time arg0) throws ClockStoppedException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public TimeBase getTimeBase() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Time getSyncTime() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Time getStopTime() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public float getRate() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Time getMediaTime() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getMediaNanoseconds() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void removeControllerListener(ControllerListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void realize() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void prefetch() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getTargetState() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getState() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Time getStartLatency() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Control[] getControls() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Control getControl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deallocate() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addControllerListener(ControllerListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setSource(DataSource arg0) throws IOException, IncompatibleSourceException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeController(Controller arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Component getVisualComponent() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GainControl getGainControl() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Component getControlPanelComponent() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addController(Controller arg0) throws IncompatibleTimeBaseException {
				// TODO Auto-generated method stub
				
			}
		};
	}

	public void play() throws Exception {
		if (player != null) {
			isPlaying = true;
			player.start();
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
			player.stop();
		}
	}

	public boolean isPlaying() {
		return isPlaying; // !isFinished()
	}
	
	public boolean isFinished() {
		return ((player.getStopTime().getSeconds() - player.getMediaTime().getSeconds()) > 0);
	}
}
