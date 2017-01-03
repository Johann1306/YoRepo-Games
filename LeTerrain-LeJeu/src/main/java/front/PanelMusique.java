package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.MusiqueManager;
import core.audio.Sound;
import core.configuration.Constante;
import modele.item.media.audio.Musique;

public class PanelMusique extends JPanel {

	public static Sound application = null;
	public static int indexCourrant = 0;
	public static String[] musiques;
	public static boolean enchaineNext = true;
	public static String titre = null;
	public static JLabel jTitre = null;
	
	public static int j = 0;
	public static int k = 0;

	public void generePanelMusique() {

			List<Musique> musiquesDisponible = MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager().getMusiquesDisponibles();
			musiques = new String[musiquesDisponible.size()];
			int i = 0;
			for (Musique musique : musiquesDisponible) {
				musiques[i] = musique.getSonPath().get(0);
				i++;
			}

		try {
			application = new Sound(musiques[indexCourrant]);
		} catch (Exception e) {
			System.out.println("Error with sound : " + musiques[indexCourrant]);
			e.printStackTrace();
		}

		ImageIcon pressIcon1 = FenetrePrincipal.getImageIcon("image/mp3Player/back.png");
		ImageIcon pressIcon2 = FenetrePrincipal.getImageIcon("image/mp3Player/play.png");
		ImageIcon pressIcon3 = FenetrePrincipal.getImageIcon("image/mp3Player/pause.png");
		ImageIcon pressIcon4 = FenetrePrincipal.getImageIcon("image/mp3Player/stop.png");
		ImageIcon pressIcon5 = FenetrePrincipal.getImageIcon("image/mp3Player/next.png");

//		Dimension d = new Dimension(pressIcon1.getIconWidth() + pressIcon2.getIconWidth() + pressIcon3.getIconWidth()
//				+ pressIcon4.getIconWidth() + pressIcon5.getIconWidth(), 100);

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

		back.setBorderPainted(false);
		play.setBorderPainted(false);
		pause.setBorderPainted(false);
		stop.setBorderPainted(false);
		next.setBorderPainted(false);

		back.setToolTipText("Precedant");
		play.setToolTipText("Demarrer");
		pause.setToolTipText("La touche pause ne marche pas putain!!!");
		stop.setToolTipText("Arreter");
		next.setToolTipText("Suivant");

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
				try {
					decrementeIndex();
					rafraichissmentTitre();
					if (application.isPlaying()) {
						application.stop();
					}
					application = new Sound(musiques[indexCourrant]);
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

					if (application.isPlaying() && !application.isFinished()) {
						// on ne fait rien
					} else {
						rafraichissmentTitre();
						application = new Sound(musiques[indexCourrant]);
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
				try {
					incrementeIndex();
					rafraichissmentTitre();
					if (application.isPlaying()) {
						application.stop();
					}
					application = new Sound(musiques[indexCourrant]);
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
		});

		JPanel panelControle = new JPanel();
		panelControle.setBackground(Color.BLACK);
		BoxLayout boxlayout = new BoxLayout(panelControle, BoxLayout.X_AXIS);
		panelControle.setLayout(boxlayout);
		// panel.setOpaque(false);
		// panelControle.setBorder(new EmptyBorder(new Insets(20, 0, 0, 0)));
		// panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

		panelControle.add(back);
		panelControle.add(play);
		panelControle.add(pause);
		panelControle.add(stop);
		panelControle.add(next);

		titre = musiques[indexCourrant];
		JPanel panelVide = new JPanel();
		panelVide.setBackground(Color.BLACK);

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.BLACK);
		jTitre = new JLabel("Titre");
		jTitre.setFont(Constante.ZELDA_FONT);
		jTitre.setForeground(Color.RED);
		panelTitle.add(jTitre);

		JPanel panelVideo = new JPanel();
		panelVideo.setPreferredSize(panelTitle.getPreferredSize());
		panelVideo.setBackground(Color.WHITE);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelTitle);
		this.add(panelControle);
		this.add(panelVideo );
		this.setBackground(Color.BLACK);

	}

	public static void enchaineNext() throws InterruptedException {
		if (application.isFinished() && enchaineNext) {
			try {
				incrementeIndex();
				rafraichissmentTitre();
				if (application.isPlaying()) {
					application.stop();
				}
				application = new Sound(musiques[indexCourrant]);
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

	private static void rafraichissmentTitre() {
		titre = musiques[indexCourrant];
		titre = titre.replace("son/", "");
		int end = titre.length();
		if (end > 20) {
			String titreTemp = titre.substring(0, 20);
			jTitre.setText(titreTemp);

			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					final String titretempo = titre;
					while (titretempo.equals(titre)) {
						int i = 0;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
						}
						if (titretempo.equals(titre)) {
							jTitre.setText(titre.substring(i, i + 20));
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								System.out.println(e.getMessage());
							}
							while (i <= end - 20 && titretempo.equals(titre)) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									System.out.println(e.getMessage());
								}
								if (titretempo.equals(titre)) {
									jTitre.setText(titre.substring(i, i + 20));
									i++;
								}
							}
						}
					}
					System.out.println("Thread-" + j + " termine");
					j++;
				}
			});
			if (!t.isAlive()) {
				System.out.println("Thread-" + k + " demarre");
				k++;
				t.start();
			}
		} else {
			jTitre.setText(titre);
		}
	}

	private static void incrementeIndex() {
		if (indexCourrant == musiques.length - 1) {
			indexCourrant = 0;
		} else {
			indexCourrant = indexCourrant + 1;
		}
	}

	private void decrementeIndex() {
		if (indexCourrant == 0) {
			indexCourrant = musiques.length - 1;
		} else {
			indexCourrant = indexCourrant - 1;
		}
	}

	public void musiqueAleatoire() {

	}

	// TODO (un 2eme player?)
	public void joueUneMusique() {

	}

	public void joueUnSon() {

	}
}
