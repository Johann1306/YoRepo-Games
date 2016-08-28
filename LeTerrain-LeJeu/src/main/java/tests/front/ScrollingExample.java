package tests.front;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollingExample extends JFrame {

	private JScrollPane scrollPane;

	public ScrollingExample() {
		setTitle("Scrolling Pane Application");
		setSize(300, 200);
		setBackground(Color.gray);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		Icon image = new ImageIcon("src/main/resources/image/allStars.jpg");
		JLabel label = new JLabel(image);

		// Create a tabbed pane
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(label);
		topPanel.add(scrollPane, BorderLayout.CENTER);
	}

	public static void main(String args[]) {
		// Create an instance of the test application
		ScrollingExample mainFrame = new ScrollingExample();
		mainFrame.setVisible(true);
	}

}