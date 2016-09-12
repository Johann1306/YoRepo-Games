package front;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.CoreManager;
import core.LieuManager;
import modele.item.carte.Carte;
import modele.item.lieu.Lieu;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.poi.Poi;

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
	private JPanel panelTemp = null;

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

//		LieuManager lieuManager = MenuPrincipal.getMainFrame().getCoreManager().getLieuManager();

		// TODO : gerer le scroll click
		// Scroller scrollJohann = new
		// Scroller(lieuManager.getDomicileByNom(PersoPrenom.JOHANN).getBackgroundPath());
		// panelJohann.setLayout(new BorderLayout());
		// panelJohann.add(scrollJohann, BorderLayout.CENTER);

//		JLabel labelJohann = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.JOHANN).getBackground());
//		panelJohann.add(labelJohann);
//
//		JLabel labelNicolas = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.NICOLAS).getBackground());
//		panelNicolas.add(labelNicolas);
//
//		JLabel labelPierre = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.PIERRE).getBackground());
//		panelPierre.add(labelPierre);
//
//		JLabel labelThomas = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.THOMAS).getBackground());
//		panelThomas.add(labelThomas);
//
//		JLabel labelYannick = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.YANNICK).getBackground());
//		panelYannick.add(labelYannick);
//
//		JLabel labelAli = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.ALI).getBackground());
//		panelAli.add(labelAli);
//
//		JLabel labelGuillaume = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.GUILLAUME).getBackground());
//		panelGuillaume.add(labelGuillaume);
//
//		JLabel labelJonathan = new JLabel(lieuManager.getDomicileByNom(PersoPrenom.JONATHAN).getBackground());
//		panelJonathan.add(labelJonathan);

		cardLayout.addLayoutComponent(panelJohann.getName(), panelJohann);
		cardLayout.addLayoutComponent(panelNicolas.getName(), panelNicolas);
		cardLayout.addLayoutComponent(panelPierre.getName(), panelPierre);
		cardLayout.addLayoutComponent(panelThomas.getName(), panelThomas);
		cardLayout.addLayoutComponent(panelYannick.getName(), panelYannick);
		cardLayout.addLayoutComponent(panelAli.getName(), panelAli);
		cardLayout.addLayoutComponent(panelGuillaume.getName(), panelGuillaume);
		cardLayout.addLayoutComponent(panelJonathan.getName(), panelJonathan);
		cardLayout.addLayoutComponent(panelGroupe.getName(), panelGroupe);

		addBoutonCarte(panelJohann);
		addBoutonCarte(panelNicolas);
		addBoutonCarte(panelPierre);
		addBoutonCarte(panelThomas);
		addBoutonCarte(panelYannick);
		addBoutonCarte(panelAli);
		addBoutonCarte(panelGuillaume);
		addBoutonCarte(panelJonathan);
		addBoutonCarte(panelGroupe);

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

	private void buildPanelPerso(JPanel panel) {
		// On recupere la carte
		Carte carte = MenuPrincipal.getMainFrame().getCoreManager().getCarteManager().getCartes().get(0);
		String backgroungPath = carte.getImagePath().get(0);
		ImageIcon imageCarte = new ImageIcon(backgroungPath);
		JLabel labelCarte = new JLabel(imageCarte);

		// On recupere les lieux disponibles pour cette carte
		List<Lieu> lieux = carte.getLieux();
		List<Lieu> lieuxDisponible = new ArrayList<Lieu>();
		for (Lieu lieu : lieux) {
			if (lieu.isDisponible()) {
				lieuxDisponible.add(lieu);
			}
		}
		for (Lieu lieu : lieuxDisponible) {
			JButton bouton = new JButton(lieu.getNom());
			bouton.setLocation(lieu.getPosition());
			
			// Si Click sur un lieu de la carte
			bouton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Chargement du Panel demande
					panel.removeAll();
					for (Poi poi : lieu.getPois()) {
						JButton bouton = new JButton(poi.getNom());
						bouton.setLocation(poi.getPoint());
						
						// Click sur un Poi
						bouton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								panel.removeAll();
								String poiName = poi.getNom();
								System.out.println("Nome de Poi : " + poiName);
								panel.add(new JLabel(new ImageIcon(poi.getImagePath().get(0))));
								addBoutonCarte(panel);
								cardLayout.show(MainFrame.getPanelCentre(), panel.getName());
							}
						});
						panel.add(bouton);
						
					}
					panel.add(new JLabel(new ImageIcon(lieu.getBackgroundPath())));
					addBoutonCarte(panel);
					cardLayout.show(MainFrame.getPanelCentre(), panel.getName());
				}
			});
			panel.add(bouton);
		}
		panel.add(labelCarte);
	}

	private void addBoutonCarte(JPanel panel) {
		JButton boutonCarte = new JButton("Retour Carte");
		boutonCarte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				buildPanelPerso(panel);
			}
		});
		panel.add(boutonCarte);
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
