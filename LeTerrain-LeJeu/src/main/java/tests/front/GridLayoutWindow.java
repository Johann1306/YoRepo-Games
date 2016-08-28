package tests.front;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutWindow extends JFrame implements ActionListener {

	public static void main(String[] args) {
		try {
			new GridLayoutWindow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public GridLayoutWindow() throws Exception {
		super("Le Groupe");
//		JPanel panel = new JPanel();
//		Container pane = getContentPane();
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		add(panel);
		Container pane = this.getContentPane();
		JButton button = new JButton("Button 1 (PAGE_START)");	
		pane.add(button, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.
		button = new JButton("Button 2 (CENTER)");
		button.setPreferredSize(new Dimension(200, 100));
		pane.add(button, BorderLayout.CENTER);

		button = new JButton("Button 3 (LINE_START)");
		pane.add(button, BorderLayout.LINE_START);

		button = new JButton("Long-Named Button 4 (PAGE_END)");
		pane.add(button, BorderLayout.PAGE_END);

		button = new JButton("5 (LINE_END)");
		pane.add(button, BorderLayout.LINE_END);
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
