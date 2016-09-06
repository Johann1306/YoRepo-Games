package front;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NicoWindow extends JFrame implements ActionListener {

	ImageIcon pressIcon1 = new ImageIcon("src/main/resources/image/nico petit.png");
	JButton myButton1 = new JButton(pressIcon1);

	public void actionPerformed(ActionEvent e) {

		// default title and icon
		JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.");

		// custom title, warning icon
		JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.", "Inane warning",
				JOptionPane.WARNING_MESSAGE);

		// custom title, error icon
		JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.", "Inane error",
				JOptionPane.ERROR_MESSAGE);

		// custom title, no icon
		JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.", "A plain message",
				JOptionPane.PLAIN_MESSAGE);

		// custom title, custom icon
		JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.", "Inane custom dialog",
				JOptionPane.INFORMATION_MESSAGE, pressIcon1);

	}

//	public static void main(String[] args) {
//		new NicoWindow();
//	}

	public NicoWindow() {
		super("Fiche Perso : Nico");
		JPanel panel = new JPanel();
		setSize(500, 500);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		panel.add(myButton1);
//		panel.setFont(new Font("Press Start", 0, 0));
		panel.setFont(new Font("Arial Bold", Font.ITALIC, 20));
		myButton1.setFont(new Font("Arial Bold", Font.ITALIC, 20));
		myButton1.addActionListener(this);
		myButton1.setPreferredSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()));

		setVisible(true);
	}
}
