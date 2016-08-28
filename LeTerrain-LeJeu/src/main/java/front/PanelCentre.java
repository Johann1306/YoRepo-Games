package front;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelCentre extends JPanel {

	private CardLayout cardLayout;
	private JPanel panelJohann = null;
	private JPanel panelNicolas = null;
	private JPanel panelPierre = null;
	private JPanel panelThomas = null;
	private JPanel panelYannick = null;
	private JPanel panelGroupe = null;

	public void generePanelCentre() {

		this.cardLayout = new CardLayout();
		
		panelJohann = new JPanel();
		panelJohann.setBackground(Color.BLUE);
		panelJohann.setName("panelJohann");
		
		panelNicolas = new JPanel();
		panelNicolas.setBackground(Color.YELLOW);
		panelNicolas.setName("panelNicolas");
		
		panelPierre = new JPanel();
		panelPierre.setBackground(Color.GREEN);
		panelPierre.setName("panelPierre");
		
		panelThomas = new JPanel();
		panelThomas.setBackground(Color.RED);
		panelThomas.setName("panelThomas");
		
		panelYannick = new JPanel();
		panelYannick.setBackground(Color.MAGENTA);
		panelYannick.setName("panelYannick");
		
		panelGroupe = new JPanel();
		panelGroupe.setBackground(Color.BLACK);
		panelGroupe.setName("panelGroupe");
		ImageIcon image = new ImageIcon("src/main/resources/image/carte/montfermeil.png");
		JLabel label = new JLabel(image);
		panelGroupe.add(label);
		
		cardLayout.addLayoutComponent(panelJohann.getName(), panelJohann);
		cardLayout.addLayoutComponent(panelNicolas.getName(), panelNicolas);
		cardLayout.addLayoutComponent(panelPierre.getName(), panelPierre);
		cardLayout.addLayoutComponent(panelThomas.getName(), panelThomas);
		cardLayout.addLayoutComponent(panelYannick.getName(), panelYannick);
		cardLayout.addLayoutComponent(panelGroupe.getName(), panelGroupe);
		
		this.setLayout(cardLayout);
		this.add(panelJohann);
		this.add(panelNicolas);
		this.add(panelPierre);
		this.add(panelThomas);
		this.add(panelYannick);
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
		if (panelGroupe.isShowing()) {
			return panelGroupe;
		}
		return null;
	}
}
