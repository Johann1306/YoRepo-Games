package tests.front;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre2 extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Sauvegarder");
	private JMenu menu3 = new JMenu("Charger");
	private JMenu menu4 = new JMenu("Quitter");
	JMenuItem menuItem = new JMenuItem("Panneau Suivant");
	
	public Fenetre2() {
		final CardLayout cardLayout = new CardLayout();
		final JPanel content = new JPanel();
		setTitle("Fentere 2");
		setSize(400, 300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		
		menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(content);
			}
		});
		
		menu1.add(menuItem);
		
		setJMenuBar(menuBar);
		
		JPanel pan1 = new JPanel();
		pan1.add(new JTextField("Je suis dans le panneau 1"));
		pan1.setBackground(Color.RED);

		JPanel pan2 = new JPanel();
		pan2.add(new JTextField("Je suis dans le panneau 2"));
		pan2.setBackground(Color.BLUE);
		
		content.setLayout(cardLayout);
		
		content.add(pan1);
		content.add(pan2);
		
		getContentPane().add(content, BorderLayout.CENTER);

	}
	
	public static void main(String[] args) {
		Fenetre2 fenetre = new Fenetre2();
		fenetre.setVisible(true);
	}
	
}
