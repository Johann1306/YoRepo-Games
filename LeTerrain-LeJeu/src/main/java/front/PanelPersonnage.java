package front;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import core.MenuManager;
import modele.item.personnage.PersoNom;

public class PanelPersonnage extends JPanel {

	ImageIcon pressIcon1 = new ImageIcon("src/main/resources/image/nico petit.png");
	ImageIcon pressIcon2 = new ImageIcon("src/main/resources/image/pierre petit.png");
	ImageIcon pressIcon3 = new ImageIcon("src/main/resources/image/yannick petit.png");
	ImageIcon pressIcon4 = new ImageIcon("src/main/resources/image/thomas petit.png");
	ImageIcon pressIcon5 = new ImageIcon("src/main/resources/image/johann petit.png");

	private JButton boutonNico = new JButton(pressIcon1);
	private JButton boutonPip = new JButton(pressIcon2);
	private JButton boutonYa = new JButton(pressIcon3);
	private JButton boutonTom = new JButton(pressIcon4);
	private JButton boutonYo = new JButton(pressIcon5);
	private JButton boutonGroupe = new JButton("GROUPE");
	
	public PanelPersonnage() {
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxlayout);
		
		boutonNico.setPreferredSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()));
		boutonPip.setPreferredSize(new Dimension(pressIcon2.getIconWidth(), pressIcon2.getIconHeight()));
		boutonYa.setPreferredSize(new Dimension(pressIcon3.getIconWidth(), pressIcon3.getIconHeight()));
		boutonTom.setPreferredSize(new Dimension(pressIcon4.getIconWidth(), pressIcon4.getIconHeight()));
		boutonYo.setPreferredSize(new Dimension(pressIcon5.getIconWidth(), pressIcon5.getIconHeight()));
//		boutonGroupe.setMinimumSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()/2));
		boutonGroupe.setMaximumSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()/2));
	
		boutonNico.setToolTipText("Nicolas LOPEZ");
		boutonPip.setToolTipText("Pierre SERMAIN");
		boutonYa.setToolTipText("Yannick BERCOT");
		boutonTom.setToolTipText("Thomas DARMOUNI");
		boutonYo.setToolTipText("Johann AVELINE");
		boutonGroupe.setToolTipText("Le groupe");
		
		PanelCentre panelCentre = MainFrame.getPanelCentre();
		CardLayout cardLayout = panelCentre.getCardLayout();
		PanelBas panelBas = MainFrame.getPanelBas();
		
		// Gestion lien entre boutons Persos et la fenetre centrales
		boutonNico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, "panelNicolas");
				// TODO : essayer de ne pas rafraichir
				panelBas.refreshPanelBas(PersoNom.NICOLAS);
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonPip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, "panelPierre");
				panelBas.refreshPanelBas(PersoNom.PIERRE);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonYa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, "panelYannick");
				panelBas.refreshPanelBas(PersoNom.YANNICK);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonTom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, "panelThomas");
				panelBas.refreshPanelBas(PersoNom.THOMAS);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonYo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, "panelJohann");
				panelBas.refreshPanelBas(PersoNom.JOHANN);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, "panelGroupe");
				panelBas.refreshPanelBas(PersoNom.GROUPE);			
				MenuManager.lanceRefreshMenu();
		}
		});
		
//		JPanel panelVide = new JPanel();
//		panelVide.setBackground(Color.RED);
//		Dimension d = new Dimension(0, 5);
//		panelVide.setSize(d);
		
		this.add(boutonGroupe);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonNico);
		//		this.add(panelVide);
		this.add(boutonPip);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonYa);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonTom);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonYo);
	}
}
