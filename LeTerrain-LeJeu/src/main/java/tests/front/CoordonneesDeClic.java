package tests.front;

import javax.swing.*;
import java.awt.*; // dont Toolkit et Graphics
import java.awt.event.*;

 public class CoordonneesDeClic extends JFrame
{
   //private Image img;
   private Color jauneclair = new Color(255, 255, 212);

   private int x, y;
   private int x1, y1; // pour ... (pas encore utilisé)
   private int xClic, yClic;
   private boolean clic = false;
   
	
   private static Font font10;
   
    public CoordonneesDeClic()
   {
      super("Cliquer dans le cadre pour obtenir les coordonnees du clic sur la console."); // titre
      setSize(538, 770); // dimensions frame (redimensionnable par défaut)
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      addMouseListener(new Moustener());
   }

    public void paint(Graphics g)
   {
		//Graphique des coordonees:
      super.paint(g);Polygon rectangle2 = new Polygon();  // rectangle noir
      rectangle2.addPoint(xClic -20, yClic -12);   // point haut gauche
      rectangle2.addPoint(xClic +22, yClic -12);   // point haut droite
      rectangle2.addPoint(xClic +22, yClic +14);   // point bas droite
      rectangle2.addPoint(xClic -20, yClic +14);   // point bas gauche
      g.setColor(Color.black);    // fond du rectangle
      g.fillPolygon(rectangle2);  // remplissage
      g.drawPolygon(rectangle2);  // affichage
            
              // dessin du graphique des coordonnées (en blanc)
      g.setFont(font10);
      g.setColor(Color.white);
      g.drawString(Integer.toString(yClic), xClic -19, yClic +4); // val. y du clique
      g.drawString(Integer.toString(xClic), xClic -3, yClic -4);  // val. x du clique
         	
         	// flecheAbscisses (x) sans la pointe
      g.drawLine(xClic -2, yClic -1, xClic +18, yClic -1); // points x, y gauche... et droite
            
            // pointe de cette fleche
      g.drawLine(xClic +16, yClic -3, xClic +22, yClic -1); // points x, y gauche... et droite \
      g.drawLine(xClic +16, yClic +2, xClic +22, yClic -1); // points x, y gauche... et droite /
             
         	// flecheOrdonnées (y) sans la pointe
      g.drawLine(xClic, yClic -3, xClic, yClic +9); // points x, y haut... et bas
              
            // pointe de cette fleche
      g.drawLine(xClic -2, yClic +6, xClic, yClic +12); // points x, y haut... et bas \
      g.drawLine(xClic +2, yClic +6, xClic, yClic +12); // points x, y haut... et bas /
   
   }
   
    public static void main(String[] args)
   {
      font10 = new Font("SansSerif", Font.BOLD, 10);
      new CoordonneesDeClic();
   }

    private class Moustener extends MouseAdapter
   {
       public void mouseClicked(MouseEvent evt)
      {
         clic = true;	
         /*System.out.println("\nL 3260  mouseClicked(MouseEvent evt)\n"
            + "       " + "w/h  clic/cliquéEn/trueFalse[icop]/fig :\n"
            + "       " + w + "/" + h + "  " + clic + "/" + cliquéEn
            + "/" + trueFalse[icop] + "/" + fig); */
         xClic = evt.getX();
         yClic = evt.getY();
         System.out.println("L 40  xClic/yClic: "+ xClic + "/" + yClic);
         repaint(); // pour afficher le graphique des coordonnées
      }
   }
}