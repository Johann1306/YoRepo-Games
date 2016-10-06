package front;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import core.configuration.Constante;
import modele.item.carte.Carte;
import modele.item.lieu.Lieu;
import modele.item.personnage.PersoPrenom;
import modele.item.poi.Poi;

public class PanelCentre extends JPanel {

	private CardLayout cardLayout;
	private JLayeredPane panelJohann = null;
	private JLayeredPane panelNicolas = null;
	private JLayeredPane panelPierre = null;
	private JLayeredPane panelThomas = null;
	private JLayeredPane panelYannick = null;
	private JLayeredPane panelAli = null;
	private JLayeredPane panelGuillaume = null;
	private JLayeredPane panelJonathan = null;
	private JLayeredPane panelGroupe = null;

	public void generePanelCentre() {

		this.cardLayout = new CardLayout();

		panelJohann = new JLayeredPane();
		panelJohann.setBackground(Color.BLUE);
		panelJohann.setName(PersoPrenom.Johann.name());
		panelJohann.setLayout(new LayeredLayoutManager());

		panelNicolas = new JLayeredPane();
		panelNicolas.setBackground(Color.YELLOW);
		panelNicolas.setName(PersoPrenom.Nicolas.name());
		panelNicolas.setLayout(new LayeredLayoutManager());

		panelPierre = new JLayeredPane();
		panelPierre.setBackground(Color.GREEN);
		panelPierre.setName(PersoPrenom.Pierre.name());
		panelPierre.setLayout(new LayeredLayoutManager());

		panelThomas = new JLayeredPane();
		panelThomas.setBackground(Color.RED);
		panelThomas.setName(PersoPrenom.Thomas.name());
		panelThomas.setLayout(new LayeredLayoutManager());

		panelYannick = new JLayeredPane();
		panelYannick.setBackground(Color.MAGENTA);
		panelYannick.setName(PersoPrenom.Yannick.name());
		panelYannick.setLayout(new LayeredLayoutManager());

		panelAli = new JLayeredPane();
		panelAli.setBackground(Color.PINK);
		panelAli.setName(PersoPrenom.Ali.name());
		panelAli.setLayout(new LayeredLayoutManager());

		panelGuillaume = new JLayeredPane();
		panelGuillaume.setBackground(Color.ORANGE);
		panelGuillaume.setName(PersoPrenom.Guillaume.name());
		panelGuillaume.setLayout(new LayeredLayoutManager());

		panelJonathan = new JLayeredPane();
		panelJonathan.setBackground(Color.CYAN);
		panelJonathan.setName(PersoPrenom.Jonathan.name());
		panelJonathan.setLayout(new LayeredLayoutManager());

		panelGroupe = new JLayeredPane();
		panelGroupe.setBackground(Color.BLACK);
		panelGroupe.setName(PersoPrenom.GROUPE.name());
		panelGroupe.setLayout(new LayeredLayoutManager());

		// Construction de la carte
		buildPanelPerso(panelGroupe);
		buildPanelPerso(panelJohann);
		buildPanelPerso(panelNicolas);
		buildPanelPerso(panelPierre);
		buildPanelPerso(panelThomas);
		buildPanelPerso(panelYannick);
		buildPanelPerso(panelAli);
		buildPanelPerso(panelGuillaume);
		buildPanelPerso(panelJonathan);

		// TODO : gerer la taile des panel plus petit
		// panelGroupe.setMaximumSize(new Dimension(imageGroupe.getIconWidth(),
		// imageGroupe.getIconHeight()));

		// TODO : gerer le scroll click
//		LieuManager lieuManager = MenuPrincipal.getMainFrame().getCoreManager().getLieuManager();
		// Scroller scrollJohann = new
		// Scroller(lieuManager.getDomicileByNom(PersoPrenom.JOHANN).getBackgroundPath());
		// panelJohann.setLayout(new BorderLayout());
		// panelJohann.add(scrollJohann, BorderLayout.CENTER);

		cardLayout.addLayoutComponent(panelJohann, panelJohann.getName());
		cardLayout.addLayoutComponent(panelNicolas, panelNicolas.getName());
		cardLayout.addLayoutComponent(panelPierre, panelPierre.getName());
		cardLayout.addLayoutComponent(panelThomas, panelThomas.getName());
		cardLayout.addLayoutComponent(panelYannick, panelYannick.getName());
		cardLayout.addLayoutComponent(panelAli, panelAli.getName());
		cardLayout.addLayoutComponent(panelGuillaume, panelGuillaume.getName());
		cardLayout.addLayoutComponent(panelJonathan, panelJonathan.getName());
		cardLayout.addLayoutComponent(panelGroupe, panelGroupe.getName());

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

	// Construit l'enchainement de map/lieu/poi/missions/jeux pour un panel perso
	private void buildPanelPerso(JComponent panel) {
		// On recupere la carte
		Carte carte = MenuPrincipal.getMainFrame().getCoreManager().getCarteManager().getCartes().get(0);
		ImageIcon imageCarte = FenetrePrincipal.getImageIcon(carte.getImagePath().get(0));
		JLabel labelCarte = new JLabel(imageCarte);

		// On recupere les lieux disponibles pour cette carte
		// TODO : JLabel nom de lieu 
		List<Lieu> lieuxPersoGroupe = carte.getLieuxDisponiblesByPersoAndGroupe(panel.getName());
		for (Lieu lieu : lieuxPersoGroupe) {
			JButton bouton = new JButton(lieu.getNom());
			bouton.setFont(Constante.PRESS_START_FONT);
			JPanel panelBouton = new JPanel();
			panelBouton.setLocation(lieu.getPosition());
			panelBouton.add(bouton);
			panelBouton.setOpaque(false);
			
			// Si Click sur un lieu de la carte
			bouton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO evenement aleatoire quand deplacement lieu
					System.out.println("- evenement aleatoire quand deplacement lieu");
					panel.removeAll();
					for (Poi poi : lieu.getPois()) {
						JButton bouton = new JButton(poi.getNom());
						bouton.setFont(Constante.PRESS_START_FONT);
						JPanel panelBouton = new JPanel();
						panelBouton.setLocation(poi.getPoint());
						panelBouton.add(bouton);
						panelBouton.setOpaque(false);
						
						// TODO : Click sur un Poi
						bouton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO evenement aleatoire quand selection Poi
								System.out.println("- evenement aleatoire quand selection Poi");
								JPanel panelInfoPoi = new PanelInfoPoi(poi);
								panel.removeAll();
								panel.add(panelInfoPoi);
								JPanel panelBoutons = new JPanel();
								panelBoutons.setOpaque(false);
								addBoutonCarte(panel, panelBoutons);
								revalidate();
							}
						});
						panel.add(panelBouton, Integer.valueOf(2));
					}
					JPanel panelBoutonCarte = new JPanel();
					panelBoutonCarte.setOpaque(false);
					addBoutonCarte(panel, panelBoutonCarte);
					
					JLabel background = new JLabel(FenetrePrincipal.getImageIcon(lieu.getBackgroundPath()));
					// TODO
//					panel.setSize(new Dimension(background.getWidth(), background.getHeight()));
					panel.add(background, Integer.valueOf(1));
					cardLayout.show(MainFrame.getPanelCentre(), panel.getName());
					revalidate();
				}
			});
			panel.add(panelBouton, Integer.valueOf(2));
		}
		panel.add(labelCarte, Integer.valueOf(1));
		// TODO
//		panel.setSize(new Dimension(labelCarte.getWidth(), labelCarte.getHeight()));
		// TODO : contour couleur autour du panel centre
//		panel.setMaximumSize(new Dimension(imageCarte.getIconWidth() + Constante.ESPACE_PANEL_CENTRE , imageCarte.getIconHeight() + Constante.ESPACE_PANEL_CENTRE));
		
	}

	private void addBoutonCarte(JComponent panel, JPanel panelBouton) {
		JButton boutonCarte = new JButton("Retour Carte");
		boutonCarte.setFont(Constante.PRESS_START_FONT);
		boutonCarte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				buildPanelPerso(panel);
				revalidate();
			}
		});
		panelBouton.add(boutonCarte);
		panelBouton.setLocation(-880, 0);
		panel.add(panelBouton, Integer.valueOf(2));
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JLayeredPane getPanelShowing() {
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
