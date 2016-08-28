package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import core.EvenementManager;
import core.ItemManager;
import core.configuration.Constante;
import modele.evenement.Evenement;
import modele.item.Item;
import modele.item.personnage.PersoNom;

public class PanelBas extends JPanel {
	
	private JPanel panelEvenement = null;
	private JPanel panelInventaire = null;
	
	public void generePanelBas() {
		
		// Panel Evenement
		panelEvenement = new JPanel();
		panelEvenement.setBackground(Color.BLACK);
		BoxLayout boxLayout = new BoxLayout(panelEvenement, BoxLayout.Y_AXIS);
		panelEvenement.setLayout(boxLayout);
		panelEvenement.setMaximumSize(new Dimension(500, Constante.PANEL_BAS_HAUTEUR));
		
		// Generations des evenements
		List<Evenement> evenementsDisponibles = EvenementManager.getEvenementsDisponibles();
		for (Evenement evenement : evenementsDisponibles) {
			JLabel labelEvenement = new JLabel(evenement.getTitre() + " : -" + evenement.getInformations());
			panelEvenement.add(labelEvenement);
		}

		// Panel Inventaire
		panelInventaire = new JPanel();
		BoxLayout boxLayout2 = new BoxLayout(panelInventaire, BoxLayout.Y_AXIS);
		panelInventaire.setLayout(boxLayout2);
		panelInventaire.setMaximumSize(new Dimension(1000, Constante.PANEL_BAS_HAUTEUR));
		
		// Recuperer la liste d'items
		refreshPanelInventaire(PersoNom.GROUPE);
		
		// Ajout au panel principale
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(2000, Constante.PANEL_BAS_HAUTEUR-20));
		this.add(panelEvenement);
		this.add(panelInventaire);
	}

	public void refreshPanelBas(PersoNom nom) {

		// Refresh Evenements
		refreshEvenements();

		// Refresh Items
		refreshPanelInventaire(nom);
	}

	private void refreshEvenements() {
		
		List<Evenement> evenementsDisponibles = new LinkedList<>(EvenementManager.getEvenementsDisponibles());
		panelEvenement.removeAll();
		
		// Tri les 10 derniers evenements
		while (evenementsDisponibles.size() > Constante.MAX_EVENEMENTS_AFFICHES ) {
			evenementsDisponibles.remove(0); 
		}
		
		// Affiche les 10 derniers evenements
		for (Evenement evenement : evenementsDisponibles) {
			JLabel labelEvenement = new JLabel(evenement.getTitre() + " : -" + evenement.getInformations());
			labelEvenement.setForeground(Color.WHITE);
			labelEvenement.setFont(Constante.PRESS_START_FONT);
			panelEvenement.add(labelEvenement);
		}
	}

	private void refreshPanelInventaire(PersoNom nom) {
		
		panelInventaire.removeAll();
		JPanel panelVertical = new JPanel();
		panelVertical.setBackground(Color.BLACK);
		BoxLayout boxLayout = new BoxLayout(panelVertical, BoxLayout.Y_AXIS);
		panelVertical.setLayout(boxLayout);
		
		List<Item> items = ItemManager.getItemsByPerso(nom);
		int compteur = 0;
		JPanel panelHorizontal = new JPanel();
		panelVertical.add(panelHorizontal);
		for (Item item : items) {
			if (compteur == Constante.MAX_CASE_PAR_LIGNE) {
				compteur = 1;
				panelHorizontal = new JPanel();
				createItemBouton(panelHorizontal, item);
				panelVertical.add(panelHorizontal);
			} else {
				createItemBouton(panelHorizontal, item);
				compteur++;
			}
		}
		JScrollPane scrollPaneInventaire = new JScrollPane();
		scrollPaneInventaire.setHorizontalScrollBar(null);
		scrollPaneInventaire.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneInventaire.getViewport().add(panelVertical);
		panelInventaire.add(scrollPaneInventaire);
	}

	private void createItemBouton(JPanel panelHorizontal, Item item) {
		ImageIcon image = new ImageIcon(item.getImagePath().get(0));
		JButton boutonItem = new JButton(image);
		boutonItem.setPreferredSize(Constante.ITEM_TAILLE);
		panelHorizontal.add(boutonItem);
	}

	public void refreshPanelBasByPerso(String panelCourant) {
		String nom = panelCourant.substring(5).toUpperCase();
		PersoNom persoNom = PersoNom.valueOf(nom);
		refreshPanelBas(persoNom);
	}
}

