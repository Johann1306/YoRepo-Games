/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2015 Caprica Software Limited.
 */

package uk.co.caprica.vlcjplayer;

import static uk.co.caprica.vlcjplayer.Application.application;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.streams.NativeStreams;
import uk.co.caprica.vlcjplayer.event.ShutdownEvent;
import uk.co.caprica.vlcjplayer.view.action.mediaplayer.StopAction;
import uk.co.caprica.vlcjplayer.view.main.MainFrame;

/**
 * Application entry-point.
 */
public class VlcjPlayer {

    private static final NativeStreams nativeStreams;

    // Redirect the native output streams to files, useful since VLC can generate a lot of noisy native logs we don't care about
    // (on the other hand, if we don't look at the logs we might won't see errors)
    static {
//        if (RuntimeUtil.isNix()) {
//            nativeStreams = new NativeStreams("stdout.log", "stderr.log");
//        }
//        else {
            nativeStreams = null;
//        }
    }
    private JFrame mainFrame;
    private static EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public VlcjPlayer() {
        mediaPlayerComponent = application().mediaPlayerComponent();

        mainFrame = new MainFrame();
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.getMediaPlayer().stop();
                mediaPlayerComponent.release();
                if (nativeStreams != null) {
                    nativeStreams.release();
                }
                application().post(ShutdownEvent.INSTANCE);
            }
            // test

            @Override
            public void windowClosed(WindowEvent e) {
            }
        });
        // TODO empecher la fermeture / virer l'icone
//        mainFrame.setUndecorated(true);
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setVisible(true);

        EmbeddedMediaPlayer embeddedMediaPlayer = mediaPlayerComponent.getMediaPlayer();
        embeddedMediaPlayer.setFullScreenStrategy(new VlcjPlayerFullScreenStrategy(mainFrame));
    }
    

	public void play(String mediaPath) {
        application().addRecentMedia(mediaPath);
        mediaPlayerComponent.getMediaPlayer().playMedia(mediaPath);		
	}

    public JFrame getMainFrame() {
		return mainFrame;
	}

    public void show() {
        mainFrame.setVisible(true);
    }

	public void hide() {
        mainFrame.setVisible(false);
	}
	
	public void stop(){
		StopAction playbackStopAction = (StopAction) application().mediaPlayerActions().playbackStopAction();
		playbackStopAction.getMediaPlayer().stop();
	}

}
