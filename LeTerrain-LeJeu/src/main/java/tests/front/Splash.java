//package tests.front;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.util.Timer;
//
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class Splash extends JDialog {
//
//    public Splash() {
//        //On place le JDialog au centre de l'écran
//        setLocationRelativeTo(null);
//
//        //On désactive la barre de titre setUndecorated(true);
//
//        //On est organisés alors on place tout les les éléments voulus dans un panel
//        //On choisit un GridLayout de 1 ligne sur 1 colonne, on se complique pas pour l'exemple !
//        JPanel main = new JPanel(new GridLayout(1, 1));
//        JLabel label = new JLabel("Hello Kitty !");
//
//        //On écrit GROS, pour que ça se voit de loin !
//        label.setFont(new Font("Arial",Font.BOLD, 20));
//
//        this.add(main);
//        main.add(label);
//        this.setVisible(true);
//        pack();
//
//        //On crée notre Timer Timer timer = new Timer();
//        Timer timer = new Timer();
//        
//        //Et on lance le fade-out, on attend 500 ms avant de commencer à estomper
//        //Puis on estompe un peu plus toutes les 5ms
//        timer.schedule(new Fader(this),500, 5);
//    }
//    
//    public static void main(String[] args) {
//		new Splash();
//	}
//}
//
