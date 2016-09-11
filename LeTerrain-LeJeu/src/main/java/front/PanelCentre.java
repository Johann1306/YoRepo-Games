package front;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.LieuManager;
import modele.item.personnage.PersoPrenom;
import tests.front.Scroller;

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
		panelAli.setBackground(Color.PINK);
		panelAli.setName(PersoPrenom.ALI.name());
		
		panelGuillaume = new JPanel();
		panelGuillaume.setBackground(Color.ORANGE);
		panelGuillaume.setName(PersoPrenom.GUILLAUME.name());
		
		panelJonathan = new JPanel();
		panelJonathan.setBackground(Color.CYAN);
		panelJonathan.setName(PersoPrenom.JONATHAN.name());
		
		panelGroupe = new JPanel();
		panelGroupe.setBackground(Color.BLACK);
		panelGroupe.setName(PersoPrenom.GROUPE.name());
		
		// Image par defaut
		ImageIcon imageGroupe = new ImageIcon("src/main/resources/image/carte/montfermeil.png");
		JLabel labelGroupe = new JLabel(imageGroupe);
		panelGroupe.add(labelGroupe);
		// TODO : gerer la taile des panel plus petit
		//panelGroupe.setMaximumSize(new Dimension(imageGroupe.getIconWidth(), imageGroupe.getIconHeight()));
		
		LieuManager lieuManager = MenuPrincipal.getMainFrame().getCoreManager().getLieuManager();
		lieuManager.getDomicileByNom(PersoPrenom.JOHANN).getBackground();

		// TODO : gerer le scroll click
//		Scroller scrollJohann = new Scroller(lieuManager.getDomicileByNom(PersoPrenom.JOHANN).getBackgroundPath());
//		panelJohann.setLayout(new BorderLayout());
//		panelJohann.add(scrollJohann, BorderLayout.CENTER);
		
		JLabel labelJohann = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.JOHANN).getBackground());
		panelJohann.add(labelJohann);
		
		JLabel labelNicolas = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.NICOLAS).getBackground());
		panelNicolas.add(labelNicolas);
		
		JLabel labelPierre = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.PIERRE).getBackground());
		panelPierre.add(labelPierre);
		
		JLabel labelThomas = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.THOMAS).getBackground());
		panelThomas.add(labelThomas);
		
		JLabel labelYannick = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.YANNICK).getBackground());
		panelYannick.add(labelYannick);
		
		JLabel labelAli = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.ALI).getBackground());
		panelAli.add(labelAli);
		
		JLabel labelGuillaume = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.GUILLAUME).getBackground());
		panelGuillaume.add(labelGuillaume);
		
		JLabel labelJonathan = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.JONATHAN).getBackground());
		panelJonathan.add(labelJonathan);
		
		cardLayout.addLayoutComponent(panelJohann.getName(), panelJohann);
		cardLayout.addLayoutComponent(panelNicolas.getName(), panelNicolas);
		cardLayout.addLayoutComponent(panelPierre.getName(), panelPierre);
		cardLayout.addLayoutComponent(panelThomas.getName(), panelThomas);
		cardLayout.addLayoutComponent(panelYannick.getName(), panelYannick);
		cardLayout.addLayoutComponent(panelAli.getName(), panelAli);
		cardLayout.addLayoutComponent(panelGuillaume.getName(), panelGuillaume);
		cardLayout.addLayoutComponent(panelJonathan.getName(), panelJonathan);
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
