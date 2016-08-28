package tests.video;

import java.awt.BorderLayout;
import java.awt.Component;
import java.net.URL;

import javax.media.Manager;
import javax.media.Player;
import javax.swing.JPanel;

public class Lecteur extends JPanel
{
  public Lecteur( URL url_media )
  {
     setLayout( new BorderLayout() );


     Manager.setHint( Manager.LIGHTWEIGHT_RENDERER, true );
     try
     {

        // Créer un lecteur pour lire le fichier specifié    
        Player mediaPlayer = Manager.createRealizedPlayer( url_media );
    	
        // Créer les composants de video et de contrôle PlaysBack
        Component video = mediaPlayer.getVisualComponent();           
        Component controles = mediaPlayer.getControlPanelComponent();  

        // Ajouter les composants  dans le JPanel
        if ( video != null )
           add( video, BorderLayout.CENTER );

        if ( controles != null )
           add( controles, BorderLayout.SOUTH );

        // Lancer la lecture de fichier sélectionné 
        mediaPlayer.start(); 
     } 
     catch ( Exception err )
     {
        System.err.println( "Erreur: "+err.getMessage() );
     } 

  } 
}