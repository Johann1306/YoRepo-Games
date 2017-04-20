package tests.front;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;

public class SeeThroughImageApplet extends JApplet {

    static String imageFileName = "src/main/resources/image/ali.png";
    private URL imageSrc;

    public SeeThroughImageApplet () {
    }

    public SeeThroughImageApplet (URL imageSrc) {
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
        final SeeThroughComponent st = new SeeThroughComponent(imageSrc);
        add("Center", st);
        JSlider opacitySlider = new JSlider(0, 100);
        opacitySlider.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    JSlider slider = (JSlider)e.getSource();
                    st.setOpacity(slider.getValue()/100f);
                    st.repaint();
                };
            });
        Dimension size = st.getPreferredSize();
        Dimension sliderSize = opacitySlider.getPreferredSize();
        resize(size.width, size.height+sliderSize.height);
        add("South", opacitySlider);
    }

    public static void main(String s[]) {
        JFrame f = new JFrame("See Through Image");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        URL imageSrc = null;
        try {
             imageSrc = ((new File(imageFileName)).toURI()).toURL();
        } catch (MalformedURLException e) {
        }
        SeeThroughImageApplet sta = new SeeThroughImageApplet(imageSrc);
        sta.buildUI();
        f.add("Center", sta);
        f.pack();
        f.setVisible(true);
    }
}