package tests.front;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestScroll {

	    public static void main(String[] args) {
	        new TestScroll();
	    }

	    public TestScroll() {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	                    ex.printStackTrace();
	                }

	                JFrame frame = new JFrame("Testing");
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.add(new TestPane());
	                frame.pack();
	                frame.setLocationRelativeTo(null);
	                frame.setVisible(true);
	            }
	        });
	    }

	    public class TestPane extends JPanel {

	        private JLabel map;

	        public TestPane() {
	            setLayout(new BorderLayout());
	            try {
	                map = new JLabel(new ImageIcon(ImageIO.read(new File("src/main/resources/image/carte/montfermeil.png"))));
	                map.setAutoscrolls(true);
	                add(new JScrollPane(map));

	                MouseAdapter ma = new MouseAdapter() {

	                    private Point origin;

	                    @Override
	                    public void mousePressed(MouseEvent e) {
	                        origin = new Point(e.getPoint());
	                    }

	                    @Override
	                    public void mouseReleased(MouseEvent e) {
	                    }

	                    @Override
	                    public void mouseDragged(MouseEvent e) {
	                        if (origin != null) {
	                            JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, map);
	                            if (viewPort != null) {
	                                int deltaX = origin.x - e.getX();
	                                int deltaY = origin.y - e.getY();

	                                Rectangle view = viewPort.getViewRect();
	                                view.x += deltaX;
	                                view.y += deltaY;

	                                map.scrollRectToVisible(view);
	                            }
	                        }
	                    }

	                };

	                map.addMouseListener(ma);
	                map.addMouseMotionListener(ma);
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }

	        @Override
	        public Dimension getPreferredSize() {
	            return new Dimension(200, 200);
	        }

	    }

}
