package tests.front;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JumbledImageApplet extends JApplet {

    static String imageFileName = "src/main/resources/image/ali.png";
    private URL imageSrc;
    private JumbledImage jumbledImage;

    public JumbledImageApplet () {
    }

    public JumbledImageApplet (URL imageSrc) {
        this.imageSrc = imageSrc;
    }

    public void init() {
        try {
            imageSrc = new URL(getCodeBase(), imageFileName);
        } catch (MalformedURLException e) {
        }
        buildUI();
    }
     
    public void buildUI() {
        final JumbledImage ji = new JumbledImage(imageSrc);
        add("Center", ji);
        JButton jumbleButton = new JButton("Jumble");
        jumbleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    ji.jumble();
                    ji.repaint();
                };
            });
        Dimension jumbleSize = ji.getPreferredSize();
        resize(jumbleSize.width, jumbleSize.height+40);
        add("South", jumbleButton);
    }

    public static void main(String s[]) {
        JFrame f = new JFrame("Jumbled Image");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        URL imageSrc = null;
        try {
             imageSrc = ((new File(imageFileName)).toURI()).toURL();
        } catch (MalformedURLException e) {
        }
        JumbledImageApplet jumbler = new JumbledImageApplet(imageSrc);
        jumbler.buildUI();
        f.add("Center", jumbler);
        f.pack();
        f.setVisible(true);
    }
}