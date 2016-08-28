package core;

import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tests.video.Lecteur;

public class TestLecteur
{

  public static void main( String args[] )
  {
     // Créer un objet JFileChooser
     JFileChooser fileChooser = new JFileChooser();

     // Afficher le JFileChooser
     int etat = fileChooser.showOpenDialog( null );

     // Si un fichier a été sélectionné
     if ( etat == JFileChooser.APPROVE_OPTION ) 
     {
        URL fichierVideo = null;

        try
        {

           fichierVideo = fileChooser.getSelectedFile().toURL();
           JFrame mediaTest = new JFrame( "Lecteur Multimedia" );
           mediaTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

           // Faire appel à la classe Lecteur créée précédemment 
           Lecteur monLecteur = new Lecteur( fichierVideo );
           mediaTest.add( monLecteur );

           // Afficher le lecteur
           monLecteur.setSize( 350, 300 );
           monLecteur.setVisible( true );
        } 
        catch ( Exception err )
        {
           JOptionPane.showMessageDialog(null, "Erreur "+err );
           System.exit(0);
        } 


     } 
  } 
}