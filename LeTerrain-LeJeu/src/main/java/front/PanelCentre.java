package front;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modele.item.personnage.PersoPrenom;

public class PanelCentre extends JPanel {

	private CardLayout cardLayout;
	private JPanel panelJohann = null;
	private JPanel panelNicolas = null;
	private JPanel panelPierre = null;
	private JPanel panelThomas = null;
	private JPanel panelYannick = null;
	private JPanel panelAli = null;
	private JPanel panelGuillaume = null;
	private JPanel panelJonathan = null;
	private JPanel panelGroupe = null;

	public void generePanelCentre() {

		this.cardLayout = new CardLayout();
		
		panelJohann = new JPanel();
		panelJohann.setBackground(Color.BLUE);
		panelJohann.setName(PersoPrenom.JOHANN.name());
		
		panelNicolas = new JPanel();
		panelNicolas.setBackground(Color.YELLOW);
		panelNicolas.setName(PersoPrenom.NICOLAS.name());
		
		panelPierre = new JPanel();
		panelPierre.setBackground(Color.GREEN);
		panelPierre.setName(PersoPrenom.PIERRE.name());
		
		panelThomas = new JPanel();
		panelThomas.setBackground(Color.RED);
		panelThomas.setName(PersoPrenom.THOMAS.name());
		
		panelYannick = new JPanel();
		panelYannick.setBackground(Color.MAGENTA);
		panelYannick.setName(PersoPrenom.YANNICK.name());
		
		panelAli = new JPanel();
		panelAli.setBackground(Color.MAGENTA);
		panelAli.setName(PersoPrenom.ALI.name());
		
		panelGuillaume = new JPanel();
		panelGuillaume.setBackground(Color.MAGENTA);
		panelGuillaume.setName(PersoPrenom.GUILLAUME.name());
		
		panelJonathan = new JPanel();
		panelJonathan.setBackground(Color.MAGENTA);
		panelJonathan.setName(PersoPrenom.JONATHAN.name());
		
		panelGroupe = new JPanel();
		panelGroupe.setBackground(Color.BLACK);
		panelGroupe.setName(PersoPrenom.GROUPE.name());
		
		ImageIcon image = new ImageIcon("src/main/resources/image/carte/montfermeil.png");
		JLabel label = new JLabel(image);
		panelGroupe.add(label);
		
		cardLayout.addLayoutComponent(panelJohann.getName(), panelJohann);
		cardLayout.addLayoutComponent(panelNicolas.getName(), panelNicolas);
		cardLayout.addLayoutComponent(panelPierre.getName(), panelPierre);
		cardLayout.addLayoutComponent(panelThomas.getName(), panelThomas);
		cardLayout.addLayoutComponent(panelYannick.getName(), panelYannick);
		cardLayout.addLayoutComponent(panelGroupe.getName(), panelAli);
		cardLayout.addLayoutComponent(panelGroupe.getName(), panelGuillaume);
		cardLayout.addLayoutComponent(panelGroupe.getName(), panelJonathan);
		cardLayout.addLayoutComponent(panelGroupe.getName(), panelGroupe);
		
		this.setLayout(cardLayout);
		this.add(panelJohann);
		this.add(panelNicolas);
		this.add(panelPierre);
		this.add(panelThomas);
		this.add(panelYannick);
		this.add(panelAli);
		this.add(panelGuillaume);
		this.add(panelJonathan);
		this.add(panelGroupe);
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JPanel getPanelShowing() {
		if (panelJohann.isShowing()) {
			return panelJohann;
		}
		if (panelNicolas.isShowing()) {
			return panelNicolas;
		}
		if (panelPierre.isShowing()) {
			return panelPierre;
		}
		if (panelThomas.isShowing()) {
			return panelThomas;
		}
		if (panelYannick.isShowing()) {
			return panelYannick;
		}
		if (panelAli.isShowing()) {
			return panelAli;
		}
		if (panelGuillaume.isShowing()) {
			return panelGuillaume;
		}
		if (panelJonathan.isShowing()) {
			return panelJonathan;
		}
		if (panelGroupe.isShowing()) {
			return panelGroupe;
		}
		return null;
	}
}
