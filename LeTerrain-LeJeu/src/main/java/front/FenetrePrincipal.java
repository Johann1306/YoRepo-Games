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
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import core.ImageManager;
import core.MusiqueManager;
import core.configuration.Constante;

public class FenetrePrincipal extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	private static JLayeredPane content;
	private static MenuPrincipal menu;

	public FenetrePrincipal() {
		super();
        addKeyListener(this);
        this.setUndecorated(true);
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
				MainFrame mainFrame = MenuPrincipal.getMainFrame();
				if (mainFrame != null) {
					FenetrePrincipal.getFenetrePrincipal().setVisible(false);
					mainFrame.setEnabled(true);
				} else {
					System.exit(0);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
			
		});
		this.setAlwaysOnTop(true);
		this.setSize(Constante.FENETRE_PRINCIPAL_DIMENSION);
		this.setMinimumSize(Constante.FENETRE_PRINCIPAL_DIMENSION);  
		this.centreFenetre();
	}
	
	public void start() {
		
		// Lecture musiques d'ambiances en boucle menu principal
		joueMusiquesAmbiances();

		// Panel content
        content = new JLayeredPane();
        content.setLayout(new LayeredLayoutManager());
		
		final JPanel titre = new PanelTitre();
		titre.setOpaque(false);
		titre.setLocation(0, 100);
		
		// JPanel Menu		
		menu = new MenuPrincipal();
		menu.initialise();
		menu.setOpaque(false);
		
		// Refresh panel menu position quand resize
		this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {}
			
			@Override
			public void componentResized(ComponentEvent e) {
				int x = (getRootPane().getWidth()/2) - (menu.getMaximumSize().width/2);
				int y = (getRootPane().getHeight()/2) - (menu.getMaximumSize().height/2);
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
		ImageIcon image = getImageIcon("image/carte/montfermeil.png");
		JLabel label = new JLabel(image);
		label.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 15), BorderFactory.createLineBorder(Color.WHITE, 5)));
		content.add(label, Integer.valueOf(1));
		content.add(titre, Integer.valueOf(5));
//		content.add(titre);
		content.add(menu, Integer.valueOf(10));
		// Ajout dans la fenetre
		this.setContentPane(content);
		this.setVisible(true);
	}

	public static void joueMusiquesAmbiances() {
		List<String> musiquesPaths = new ArrayList<String>();
		String musiquePath0 = "son/smw_course_clear.wav";
		String musiquePath1 = "son/23-ending.mp3";
		String musiquePath2 = "son/01AlexKid-title-screen.mp3"; 
		musiquesPaths.add(musiquePath1);
		musiquesPaths.add(musiquePath0);
		musiquesPaths.add(musiquePath2);
		MusiqueManager.playPlaylistEnBoucle(musiquesPaths);
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
		
	public static ImageIcon getImageIcon(final String pathAndFileName) {
		System.out.println("getImageIcon : " + pathAndFileName);
	    return ImageManager.getImageIconProxy(pathAndFileName);
	}
	
	public static URL getURL(final String pathAndFileName) {
		System.out.println("getURL : " + pathAndFileName);
	    final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
	    return url;
	}

	public static InputStream getStream(String pathAndFileName) {
		System.out.println("getStream : " + pathAndFileName);
		final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathAndFileName);
		return stream;
	}

}
