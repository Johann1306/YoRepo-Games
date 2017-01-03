package tests.front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import core.audio.Sound;
import core.configuration.Constante;

public class WindowMP3WithTitles {

	public static Sound application = null;
	public static int indexCourrant = 0;
	public static File[] musiques = null;
	public static boolean enchaineNext = true;
	public static String titre = null;
	public static PanelTitreMP3 panelTitre = null;
	public static JLabel jTitre = null;
	
	public static void main(String[] args) {

		File rep = new File("src/main/resources/son");
		musiques = rep.listFiles();

		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Lecteur MP3");
//		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the panel to add buttons
		JPanel panelControle = new JPanel();
		panelControle.setBackground(Color.BLACK);
//		panel.setOpaque(false);

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panelControle, BoxLayout.X_AXIS);

		// Set the Boxayout to be Y_AXIS from top to down
		// BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panelControle.setLayout(boxlayout);

		// Set border for the panel
	//	panelControle.setBorder(new EmptyBorder(new Insets(20, 0, 0, 0)));
		// panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

		ImageIcon pressIcon1 = new ImageIcon("src/main/resources/image/mp3Player/back.png");
		ImageIcon pressIcon2 = new ImageIcon("src/main/resources/image/mp3Player/play.png");
		ImageIcon pressIcon3 = new ImageIcon("src/main/resources/image/mp3Player/pause.png");
		ImageIcon pressIcon4 = new ImageIcon("src/main/resources/image/mp3Player/stop.png");
		ImageIcon pressIcon5 = new ImageIcon("src/main/resources/image/mp3Player/next.png");

		JButton back = new JButton(pressIcon1);
		JButton play = new JButton(pressIcon2);
		JButton pause = new JButton(pressIcon3);
		JButton stop = new JButton(pressIcon4);
		JButton next = new JButton(pressIcon5);

		back.setBackground(Color.BLACK);
		play.setBackground(Color.BLACK);
		pause.setBackground(Color.BLACK);
		stop.setBackground(Color.BLACK);
		next.setBackground(Color.BLACK);

		back.setPreferredSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()));
		play.setPreferredSize(new Dimension(pressIcon2.getIconWidth(), pressIcon2.getIconHeight()));
		pause.setPreferredSize(new Dimension(pressIcon3.getIconWidth(), pressIcon3.getIconHeight()));
		stop.setPreferredSize(new Dimension(pressIcon4.getIconWidth(), pressIcon4.getIconHeight()));
		next.setPreferredSize(new Dimension(pressIcon5.getIconWidth(), pressIcon5.getIconHeight()));

		// myButton1.setBackground(Color.BLACK);
		back.setBorderPainted(false);
		play.setBorderPainted(false);
		pause.setBorderPainted(false);
		stop.setBorderPainted(false);
		next.setBorderPainted(false);

		back.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				back.setBorderPainted(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				back.setBorderPainted(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (indexCourrant == 0) {
					indexCourrant = musiques.length - 1;
				} else {
					indexCourrant = indexCourrant - 1;
				}
				try {
					
					// Raffraichissemnt du titre
					titre = musiques[indexCourrant].getName();
					panelTitre.setMessage(titre);
					panelTitre.repaint();
					jTitre.setText(titre);

					if (application == null) {
						application = new Sound(musiques[indexCourrant].getPath());
					}

					if (application.isPlaying()) {
						application.stop();
					}
					application = new Sound(musiques[indexCourrant].getPath());
					Thread t = new Thread(new Runnable() {

						@Override
						public void run() {
							try {
								System.out.println("Run t");
								application.play();
								enchaineNext();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					if (!t.isAlive()) {
						t.start();
					}

					// application.stop();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					System.out.println("error");
				}
			}
		});
		play.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				play.setBorderPainted(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				play.setBorderPainted(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					// Raffraichissemnt du titre
					titre = musiques[indexCourrant].getName();
					panelTitre.setMessage(titre);
					panelTitre.repaint();
					jTitre.setText(titre);

					if (application == null) {
						application = new Sound(musiques[indexCourrant].getPath());
					}

					if (application.isPlaying() && !application.isFinished()) {
						// on ne fait rien
					} else {
						application = new Sound(musiques[indexCourrant].getPath());
						Thread t = new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									application.play();
									enchaineNext();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						if (!t.isAlive()) {
							t.start();
						}
					}
					// application.stop();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					System.out.println("error");
				}

			}
		});
		pause.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				pause.setBorderPainted(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pause.setBorderPainted(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (application != null) {
						application.pause();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		stop.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				stop.setBorderPainted(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				stop.setBorderPainted(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (application != null && application.isPlaying() && !application.isFinished()) {
					try {
						application.stop();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		next.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				next.setBorderPainted(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				next.setBorderPainted(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (indexCourrant == musiques.length - 1) {
					indexCourrant = 0;
				} else {
					indexCourrant = indexCourrant + 1;
				}
				try {
					// Raffraichissemnt du titre
					titre = musiques[indexCourrant].getName();
					panelTitre.setMessage(titre);
					panelTitre.repaint();
					jTitre.setText(titre);

					if (application == null) {

						application = new Sound(musiques[indexCourrant].getPath());
					}

					if (application.isPlaying()) {
						application.stop();
					}
					application = new Sound(musiques[indexCourrant].getPath());
					Thread t = new Thread(new Runnable() {

						@Override
						public void run() {
							try {
								application.play();
								// TODO : rafraichissement titre
//								titre = musiques[indexCourrant].getName();
//								panelTitre.setMessage(titre);
//								panelTitre.repaint();
								enchaineNext();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					if (!t.isAlive()) {
						t.start();
					}

					// application.stop();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					System.out.println("error");
				}
			}
		});

		// Add buttons to the frame (and spaces between buttons)
		panelControle.add(back);
		// panel.add(Box.createRigidArea(new Dimension(0, 60)));
		panelControle.add(play);
		// panel.add(Box.createRigidArea(new Dimension(0, 60)));
		panelControle.add(pause);
		panelControle.add(stop);
		panelControle.add(next);

		// Set size for the frame
//		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		titre = musiques[indexCourrant].getName();
		panelTitre = new PanelTitreMP3(titre);
		panelTitre.setBackground(Color.BLACK);
//		ExamplePanel panelExample= new ExamplePanel();
//		panel.add(panelExample);
//		panel.add(panelTitre, BorderLayout.NORTH);
		JPanel panelVide = new JPanel();
		panelVide.setBackground(Color.BLACK);
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.BLACK);
//		frame.add(panelTitre, BorderLayout.NORTH);
		jTitre = new JLabel("Titre");
		jTitre.setFont(Constante.ZELDA_FONT);
//		jTitre.
		panelTitle.add(jTitre);
		panelTitle.setBackground(Color.BLACK);
		frame.add(panelTitle, BorderLayout.NORTH);
		frame.add(panelControle, BorderLayout.CENTER);
//		frame.add(panelVide, BorderLayout.SOUTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	
	public static void enchaineNext() throws InterruptedException {
		if (application.isFinished() && enchaineNext) {
			if (indexCourrant == musiques.length - 1) {
				indexCourrant = 0;
			} else {
				indexCourrant = indexCourrant + 1;
			}
			try {
				// Raffraichissemnt du titre
				titre = musiques[indexCourrant].getName();
				panelTitre.setMessage(titre);
				panelTitre.repaint();
				jTitre.setText(titre);

				if (application == null) {

					application = new Sound(musiques[indexCourrant].getPath());
				}
				if (application.isPlaying()) {
					application.stop();
				}
				application = new Sound(musiques[indexCourrant].getPath());
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							application.play();
							enchaineNext();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				if (!t.isAlive()) {
					t.start();
				}

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				System.out.println("error");
			}
		}
	}
}