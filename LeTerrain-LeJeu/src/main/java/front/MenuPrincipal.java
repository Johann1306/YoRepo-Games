package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.SauvegardeManager;
import core.configuration.Constante;

public class MenuPrincipal extends JPanel {
	
	private static MainFrame mainFrame;

	public MenuPrincipal() {
	}

	public void initialise() {
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxlayout);

		JButton boutonNew = new JButton("Nouvelle Partie");
		JButton boutonContinue = new JButton("Continuer");
		JButton boutonLoad = new JButton("Charger");
		JButton boutonEdit = new JButton("Editer");
		JButton boutonJeux = new JButton("Jeux");
		JButton boutonScore = new JButton("Score");
		JButton boutonQuit = new JButton("Quitter");

		boutonNew.setFont(Constante.PRESS_START_FONT_MENU);
		boutonContinue.setFont(Constante.PRESS_START_FONT_MENU);
		boutonLoad.setFont(Constante.PRESS_START_FONT_MENU);
		boutonEdit.setFont(Constante.PRESS_START_FONT_MENU);
		boutonJeux.setFont(Constante.PRESS_START_FONT_MENU);
		boutonScore.setFont(Constante.PRESS_START_FONT_MENU);
		boutonQuit.setFont(Constante.PRESS_START_FONT_MENU);

		boutonNew.setBackground(Color.BLACK);
		boutonContinue.setBackground(Color.BLACK);
		boutonLoad.setBackground(Color.BLACK);
		boutonEdit.setBackground(Color.BLACK);
		boutonJeux.setBackground(Color.BLACK);
		boutonScore.setBackground(Color.BLACK);
		boutonQuit.setBackground(Color.BLACK);

		boutonNew.setForeground(Color.WHITE);
		boutonContinue.setForeground(Color.WHITE);
		boutonLoad.setForeground(Color.WHITE);
		boutonEdit.setForeground(Color.WHITE);
		boutonJeux.setForeground(Color.WHITE);
		boutonScore.setForeground(Color.WHITE);
		boutonQuit.setForeground(Color.WHITE);
		
		Dimension max = new Dimension(boutonNew.getMaximumSize().width+50, boutonNew.getMaximumSize().height);

		boutonNew.setMaximumSize(max); // taille de reference
		boutonContinue.setMaximumSize(boutonNew.getMaximumSize());
		boutonLoad.setMaximumSize(boutonNew.getMaximumSize());
		boutonEdit.setMaximumSize(boutonNew.getMaximumSize());
		boutonJeux.setMaximumSize(boutonNew.getMaximumSize());
		boutonScore.setMaximumSize(boutonNew.getMaximumSize());
		boutonQuit.setMaximumSize(boutonNew.getMaximumSize());

		boutonNew.setFocusable(false);
		boutonContinue.setFocusable(false);
		boutonLoad.setFocusable(false);
		boutonEdit.setFocusable(false);
		boutonJeux.setFocusable(false);
		boutonScore.setFocusable(false);
		boutonQuit.setFocusable(false);

		// Actions des boutons
		boutonNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame = new MainFrame();
				mainFrame.startMainFrame();
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
				fenetrePrincipal.hide();
//				parent.show();
			}
		});
		boutonContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame = SauvegardeManager.load();
				mainFrame.startMainFrame();
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
				fenetrePrincipal.hide();
			}
		});
		boutonLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame = SauvegardeManager.load();
				mainFrame.startMainFrame();
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
				fenetrePrincipal.hide();
			}
		});
		boutonEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
	//			fenetrePrincipal.hide();
			}
		});
		boutonJeux.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
	//			fenetrePrincipal.hide();
			}
		});
		boutonScore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
	//			fenetrePrincipal.hide();
			}
		});
		boutonQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				demandeConfirmationQuitter();
			}

		});

		// Refresh Font on focus
		boutonNew.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonNew.setFont(Constante.PRESS_START_FONT_MENU);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonNew.setFont(Constante.PRESS_START_FONT_MENU_SELECTED);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonContinue.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonContinue.setFont(Constante.PRESS_START_FONT_MENU);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonContinue.setFont(Constante.PRESS_START_FONT_MENU_SELECTED);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonLoad.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonLoad.setFont(Constante.PRESS_START_FONT_MENU);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonLoad.setFont(Constante.PRESS_START_FONT_MENU_SELECTED);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonEdit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonEdit.setFont(Constante.PRESS_START_FONT_MENU);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonEdit.setFont(Constante.PRESS_START_FONT_MENU_SELECTED);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonJeux.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonJeux.setFont(Constante.PRESS_START_FONT_MENU);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonJeux.setFont(Constante.PRESS_START_FONT_MENU_SELECTED);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonScore.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonScore.setFont(Constante.PRESS_START_FONT_MENU);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonScore.setFont(Constante.PRESS_START_FONT_MENU_SELECTED);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boutonQuit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boutonQuit.setFont(Constante.PRESS_START_FONT_MENU);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boutonQuit.setFont(Constante.PRESS_START_FONT_MENU_SELECTED);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		this.add(boutonNew);
		this.add(boutonContinue);
		this.add(boutonLoad);
		this.add(boutonEdit);
		this.add(boutonJeux);
		this.add(boutonScore);
		this.add(boutonQuit);
	}

	public void demandeConfirmationQuitter() {
		int confirme = JOptionPane.showOptionDialog(getParent(), "T'es sûr de vouloir t'arreter maintenant?",
				"Attention jeune puceau", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("src/main/resources/image/defaut/defautEvenement.png"),
				new String[] { "Oui, je suis sûr!", "Nan attends, je vais continuer un peu..." }, // this
																									// is
																									// the
																									// array
				"default");
		System.out.println(confirme);
		if (confirme == 0) {
			System.exit(0);
		}
	}
	
	public static MainFrame getMainFrame(){
		return mainFrame;
	}

	public static void setMainFrame(MainFrame frame) {
		mainFrame = frame;
	}
}
