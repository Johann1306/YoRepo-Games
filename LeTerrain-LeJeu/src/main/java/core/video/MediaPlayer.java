package core.video;

import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.Track;
import javafx.stage.Stage;

/**
 * A sample media player which loops indefinitely over the same video
 */
public class MediaPlayer extends Application {
	private static final String MEDIA_URL = "file:///C:/Dev/workspace/LeTerrain-LeJeu-2/src/main/resources/video/Trololo.mp4";
//	private static final String MEDIA_URL = "file:///C:/Dev/workspace/LeTerrain-LeJeu-2/src/main/resources/son/18-overworld-bgm.mp3";
	private static String arg1;

	@Override
	public void start(Stage stage) throws URISyntaxException {
		stage.setTitle("Media Player");

		// Create media player
		System.out.println(MEDIA_URL);
		Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
		ReadOnlyIntegerProperty heightProperty = media.heightProperty();
		ReadOnlyIntegerProperty widthProperty = media.widthProperty();
		System.out.println("Source : " + media.getSource());
		System.out.println("Tracks : " + media.getTracks());
		System.out.println("Width : " + media.getWidth());
		System.out.println("Height : " + media.getHeight());
		System.out.println("Error : " + media.getError());
		System.out.println("Duration : " + media.getDuration());
		System.out.println("Markers : " + media.getMarkers());
		System.out.println("Metadata : " + media.getMetadata());
		System.out.println("HeightProp : " + heightProperty.getValue().toString());
		System.out.println("WidthProp : " + widthProperty.getValue().toString());
		javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);

		
		// Print track and metadata information
		media.getTracks().addListener(new ListChangeListener<Track>() {
			public void onChanged(Change<? extends Track> change) {
				System.out.println("Track> " + change.getList());
			}
		});
		media.getMetadata().addListener(new MapChangeListener<String, Object>() {
			public void onChanged(MapChangeListener.Change<? extends String, ? extends Object> change) {
				System.out.println("Metadata> " + change.getKey() + " -> " + change.getValueAdded());
			}
		});
		
		// Add media display node to the scene graph
		MediaView mediaView = new MediaView(mediaPlayer);
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600);
		root.getChildren().add(mediaView);
		stage.setScene(scene);
		stage.show();
	}

//	public static void main(String[] args) {
//		if (args.length > 0) {
//			arg1 = args[0];
//		}
//		Application.launch(args);
//	}
}