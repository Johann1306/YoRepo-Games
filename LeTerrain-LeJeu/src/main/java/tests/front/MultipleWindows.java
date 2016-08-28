package tests.front;

import javax.swing.*;

import front.NicoWindow;

import java.awt.Dimension;
import java.awt.event.*;

public class MultipleWindows extends JFrame implements ActionListener {

	ImageIcon pressIcon1 = new ImageIcon("src/main/resources/image/nico petit.png");
	ImageIcon pressIcon2 = new ImageIcon("src/main/resources/image/pierre petit.png");
	ImageIcon pressIcon3 = new ImageIcon("src/main/resources/image/yannick petit.png");
	ImageIcon pressIcon4 = new ImageIcon("src/main/resources/image/thomas petit.png");
	ImageIcon pressIcon5 = new ImageIcon("src/main/resources/image/johann petit.png");

	JButton myButton1 = new JButton(pressIcon1);
	JButton myButton2 = new JButton(pressIcon2);
	JButton myButton3 = new JButton(pressIcon3);
	JButton myButton4 = new JButton(pressIcon4);
	JButton myButton5 = new JButton(pressIcon5);
	
	public static void main(String[] args) {
		new MultipleWindows();	
	}
	
	public MultipleWindows() {
		super("Le Groupe");
		JPanel panel = new JPanel();
		setSize( 1000,1000 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		add(panel);
		panel.add(myButton1);
		panel.add(myButton2);
		panel.add(myButton3);
		panel.add(myButton4);
		panel.add(myButton5);
		
		myButton1.addActionListener(this);
		myButton1.setRolloverIcon(pressIcon2);
		myButton1.setPreferredSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()));
		
		setVisible( true );
	}
	
	public void actionPerformed(ActionEvent event) {
		new NicoWindow();	
	}
}