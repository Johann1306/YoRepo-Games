package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import core.configuration.Constante;

public class FenetrePrincipal extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	private static JLayeredPane content;
	private static MenuPrincipal menu;

	public FenetrePrincipal() {
		super();
        addKeyListener(this);
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				FenetrePrincipal.getFenetrePrincipal().hide();
				MainFrame.getMainFrame().enable();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
			
		});
		this.setAlwaysOnTop(true);
		this.setSize(Constante.FENETRE_PRINCIPAL_DIMENSION);
		this.setMinimumSize(Constante.FENETRE_PRINCIPAL_DIMENSION);  
		centreFenetre();
	}
	
	public void start() {

        content = new JLayeredPane();
        content.setLayout(new LayeredLayoutManager());
		
		final JPanel titre = new PanelTitre();
		titre.setOpaque(false);
		
		// JPanel Menu		
		menu = new MenuPrincipal();
		menu.initialise();
		menu.setOpaque(false);
		int x = (getRootPane().getWidth()/2) - (Constante.MENU_WIDTH/2);
		int y = (getRootPane().getHeight()/2) - (Constante.MENU_HEIGHT/2);
		menu.setLocation(new Point(x, y));
		
		// Refresh panel menu position quand resize
		this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {}
			
			@Override
			public void componentResized(ComponentEvent e) {
				int x = (getRootPane().getWidth()/2) - (Constante.MENU_WIDTH/2);
				int y = (getRootPane().getHeight()/2) - (Constante.MENU_HEIGHT/2);
				menu.setLocation(new Point(x, y));
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {}
			
			@Override
			public void componentHidden(ComponentEvent e) {}
		});
		
		menu.setBackground(Color.BLACK);
		content.setBackground(Color.WHITE);

		// Ajout du menu a la fenetre
		ImageIcon image = new ImageIcon("src/main/resources/image/carte/montfermeil.png");
		JLabel label = new JLabel(image);
		content.add(label, Integer.valueOf(1));
		content.add(titre, Integer.valueOf(5));
//		content.add(titre);
		content.add(menu, Integer.valueOf(10));
		// Ajout dans la fenetre
		this.setContentPane(content);
		this.setVisible(true);
	}

	private void centreFenetre() {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("KeyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased");
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
			menu.demandeConfirmationQuitter();
		}
	}
	
	public static FenetrePrincipal getFenetrePrincipal() {
		return (FenetrePrincipal) content.getParent().getParent().getParent();
	}
		
}
