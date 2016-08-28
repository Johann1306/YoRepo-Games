package tests.front;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.player.advanced.PlaybackListener;
import tests.audio.Sound4;

public class BoxLayoutWindow {

	/*
	 * A swing BoxLayout example with different Boxlayout axis parameters
	 * BoxLayout.X_AXIS, BoxLayout.Y_AXIS respectively. Also add spaces between
	 * components.
	 */

	static Sound4 application = null;
	public static int indexCourrant = 0;

	public static void main(String[] args) {

		File rep = new File("src/main/resources/son");
		File[] musiques = rep.listFiles();

		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("BoxLayout Example X_AXIS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		// Set the Boxayout to be Y_AXIS from top to down
		// BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
		// panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

		ImageIcon pressIcon1 = new ImageIcon("src/main/resources/image/mp3Player/back.png");
		ImageIcon pressIcon2 = new ImageIcon("src/main/resources/image/mp3Player/play.png");
		ImageIcon pressIcon3 = new ImageIcon("src/main/resources/image/mp3Player/pause.png");
		ImageIcon pressIcon4 = new ImageIcon("src/main/resources/image/mp3Player/stop.png");
		ImageIcon pressIcon5 = new ImageIcon("src/main/resources/image/mp3Player/next.png");
		// JButton myButton = new JButton("Hit Me", pressIcon);
		JButton back = new JButton(pressIcon1);
		JButton play = new JButton(pressIcon2);
		JButton pause = new JButton(pressIcon3);
		JButton stop = new JButton(pressIcon4);
		JButton next = new JButton(pressIcon5);

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

					if (application == null) {
						PlaybackListener listener = new PlaybackListener() {

						};
						application = new Sound4(musiques[indexCourrant].getPath(), listener);
					}

					if (application.isPlaying()) {
						application.stop();
					}
					

						PlaybackListener listener = new PlaybackListener() {

						};
						application = new Sound4(musiques[indexCourrant].getPath(), listener);
						Thread t = new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									application.play();
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

					if (application == null) {
						PlaybackListener listener = new PlaybackListener() {

						};
						application = new Sound4(musiques[indexCourrant].getPath(), listener);
					}

					if (application.isPlaying()) {
						// on ne fait rien
					} else {
						PlaybackListener listener = new PlaybackListener() {

						};
						application = new Sound4(musiques[indexCourrant].getPath(), listener);
						Thread t = new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									application.play();
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
				// TODO Auto-generated method stub

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
				if (application.isPlaying()) {
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

					
					if (application == null) {
						PlaybackListener listener = new PlaybackListener() {

						};
						application = new Sound4(musiques[indexCourrant].getPath(), listener);
					}


					if (application.isPlaying()) {
						application.stop();
					}
						PlaybackListener listener = new PlaybackListener() {

						};
						application = new Sound4(musiques[indexCourrant].getPath(), listener);
						Thread t = new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									application.play();
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
		panel.add(back);
		// panel.add(Box.createRigidArea(new Dimension(0, 60)));
		panel.add(play);
		// panel.add(Box.createRigidArea(new Dimension(0, 60)));
		panel.add(pause);
		panel.add(stop);
		panel.add(next);

		// Set size for the frame
		// frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}