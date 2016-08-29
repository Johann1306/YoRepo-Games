package tests.front;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javazoom.jl.player.advanced.PlaybackListener;
import tests.audio.Sound4;

public class MusiqueOnOffWindow extends JFrame implements ActionListener {

	ImageIcon pressIcon1 = new ImageIcon("src/main/resources/image/nico petit.png");
	ImageIcon pressIcon2 = new ImageIcon("src/main/resources/image/pierre petit.png");
	ImageIcon pressIcon3 = new ImageIcon("src/main/resources/image/yannick petit.png");
	ImageIcon pressIcon4 = new ImageIcon("src/main/resources/image/thomas petit.png");
	ImageIcon pressIcon5 = new ImageIcon("src/main/resources/image/johann petit.png");
	// JButton myButton = new JButton("Hit Me", pressIcon);
	JButton myButton1 = new JButton(pressIcon1);
	JButton myButton2 = new JButton(pressIcon2);
	JButton myButton3 = new JButton(pressIcon3);
	JButton myButton4 = new JButton(pressIcon4);
	JButton myButton5 = new JButton(pressIcon5);
	Sound4 application = null;
	Sound4 application2 = null;

	public static void main(String[] args) {
		try {
			new MusiqueOnOffWindow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MusiqueOnOffWindow() throws Exception {
		super("Le Groupe");
		JPanel panel = new JPanel();
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		panel.add(myButton1);
		panel.add(myButton2);
		panel.add(myButton3);
		panel.add(myButton4);
		panel.add(myButton5);

		myButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					application.stop();

				} catch (Exception ex) {
					System.out.println("error");
				}

			}
		});

		myButton5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					if (application2 == null) {
						PlaybackListener listener2 = new PlaybackListener() {

						};
						application2 = new Sound4("src/main/resources/son/Amstramgram.mp3", listener2);
					}

					if (application2.isPlaying()) {
						application2.stop();
					} else {
						PlaybackListener listener2 = new PlaybackListener() {

						};
						application2 = new Sound4("src/main/resources/son/Amstramgram.mp3", listener2);
						Thread t = new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									application2.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						if (!t.isAlive()) {
							t.start();
						}
					}
					// application2.stop();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					System.out.println("error");
				}

			}
		});
		myButton1.setRolloverIcon(pressIcon2);
		myButton1.setPreferredSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()));
		PlaybackListener listener = new PlaybackListener() {

		};

		application = new Sound4("src/main/resources/son/Dans la ferme a Mathurin.mp3", listener);
		setVisible(true);
		application.play();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}