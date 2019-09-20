package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import core.ImageManager;
import core.ItemManager;
import core.configuration.Constante;
import modele.competence.PersoStat;
import modele.evenement.Evenement;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.arme.Arme;
import modele.item.drogue.Drogue;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

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
//		List<Evenement> evenementsDisponibles = MenuPrincipal.getMainFrame().getCoreManager().getEvenementManager().getEvenementsDisponibles();
//		for (Evenement evenement : evenementsDisponibles) {
//			JLabel labelEvenement = new JLabel(evenement.getTitre() + " : -" + evenement.getInformations());
//			panelEvenement.add(labelEvenement);
//		}

		// Panel Inventaire
		panelInventaire = new JPanel();
		BoxLayout boxLayout2 = new BoxLayout(panelInventaire, BoxLayout.Y_AXIS);
		panelInventaire.setLayout(boxLayout2);
		panelInventaire.setMaximumSize(new Dimension(1000, Constante.PANEL_BAS_HAUTEUR));
		
		// Recuperer la liste d'items
		refreshPanelInventaire(PersoPrenom.GROUPE);
		
		// Ajout au panel principale
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(2000, Constante.PANEL_BAS_HAUTEUR-20));
		this.add(panelEvenement);
		this.add(panelInventaire);
	}

	public void refreshPanelBas(PersoPrenom nom) {

		// TODO : refresh sans removeAll()
		
		// Refresh Evenements
		refreshAffichagePanelEvenements();

		// Refresh Items
		refreshPanelInventaire(nom);
	}

	private void refreshAffichagePanelEvenements() {
		
		List<Evenement> evenementsDisponibles = new LinkedList<Evenement>(MenuPrincipal.getMainFrame().getCoreManager().getEvenementManager().getEvenementsDisponibles());
		panelEvenement.removeAll();
		panelEvenement.repaint();
		
		// Tri les 10 derniers evenements
		// TODO : Attention ! Problemes d'affichage si MAX_EVENEMENTS_AFFICHES != 5
		while (evenementsDisponibles.size() > Constante.MAX_EVENEMENTS_AFFICHES ) {
			evenementsDisponibles.remove(0); 
		}
		
		// Affiche les 10 derniers evenements
		for (Evenement evenement : evenementsDisponibles) {
			JLabel labelEvenement = new JLabel(evenement.getTitre() + " : -" + evenement.getInformations());
			labelEvenement.setForeground(Color.WHITE);
			labelEvenement.setFont(Constante.SIMPSON_FONT);
			panelEvenement.add(labelEvenement);
		}
	}

	private void refreshPanelInventaire(PersoPrenom nom) {
		
		panelInventaire.removeAll();
		JPanel panelVertical = new JPanel();
		panelVertical.setBackground(Color.BLACK);
		BoxLayout boxLayout = new BoxLayout(panelVertical, BoxLayout.Y_AXIS);
		panelVertical.setLayout(boxLayout);
		
		int compteur = 0;
		JPanel panelHorizontal = new JPanel();
		panelVertical.add(panelHorizontal);
		
		// On affiche les objets du groupe + les objets du perso
		PersonnagePrincipal perso = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoByPrenom(nom);
		Map<Item, Integer> sac = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getSac();
		// TODO probleme du Nullpointer a reproduire quand on charge la derniere partie dans le jeu
		Map<Item, Integer> sacTemp = new HashMap<>(sac);
		// Si ce n'est pas le perso groupe on ajoute les objets du perso
		if (perso != null && perso.getPrenomPerso() != PersoPrenom.GROUPE) {
			sacTemp.putAll(perso.getSac());
		}
		for (Item item : sacTemp.keySet()) {
			Integer nbItems = sacTemp.get(item);
			if (nbItems > 0) {
				if (compteur == Constante.MAX_CASE_PAR_LIGNE) {
					compteur = 1;
					panelHorizontal = new JPanel();
					createItemBouton(panelHorizontal, item, nbItems);
					panelVertical.add(panelHorizontal);
				} else {
					createItemBouton(panelHorizontal, item, nbItems);
					compteur++;
				}
			}
		}
		JScrollPane scrollPaneInventaire = new JScrollPane();
		scrollPaneInventaire.setHorizontalScrollBar(null);
		scrollPaneInventaire.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneInventaire.getViewport().add(panelVertical);
		panelInventaire.add(scrollPaneInventaire);
		revalidate();
	}

	private void createItemBouton(JPanel panelHorizontal, Item item, int nbItems) {
		ImageIcon image = FenetrePrincipal.getImageIcon(item.getImagePath().get(0));
		ImageIcon resizeImage = ImageManager.resizeImage(image, Constante.ITEM_TAILLE_DIMENSION);
		JButton boutonItem = new JButton(resizeImage);
		// Si c'est une arme
		if (item.getType() == ItemType.ARME) {
			Arme arme = (Arme)item;
			StringBuilder bonusArme = new StringBuilder();
			bonusArme.append("(");
			for (PersoStat stat : arme.getBonusParStat().keySet()) {
				bonusArme.append(" +" + arme.getBonusParStat().get(stat) + " " + stat.name() + " ");
			}
			bonusArme.append(")");
			boutonItem.setToolTipText(arme.toString());

		// Si c'est une drogue
		} else if (item.getType() == ItemType.DROGUE) {
			Drogue drogue = (Drogue)item;
			boutonItem.setToolTipText(drogue.getNom() + " (x" + nbItems + ")" + " : " + drogue.getStats());
			
		// Si c'est une popo
		} else if (item.isConsommable()) {
			boutonItem.setToolTipText(item.getNom() + " (x" + nbItems + ")" + " : " + item.getInformations());
		
		// Sinon pour tous les autres objets, on affiche le nom + info
		} else {
			boutonItem.setToolTipText(item.getNom()  + " : " + item.getInformations());			
		}
		
		boutonItem.setPreferredSize(Constante.ITEM_TAILLE_DIMENSION);
		boutonItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Item itemSelectionne = ItemManager.getItemSelectionne();
				if (itemSelectionne == null) {
					ItemManager.setItemSelectionne(item);
					MainFrame.getPanelPersonnage().setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
				} else if (itemSelectionne == item) {
					ItemManager.setItemSelectionne(null);
					MainFrame.getPanelPersonnage().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				} else {
					ItemManager.setItemSelectionne(item);
					MainFrame.getPanelPersonnage().setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
				}
				// TODO panelPerso en surbrillance
				// TODO changer l icone de la souris jusqu a ce que l item soit utilise
			}
		});
		
		panelHorizontal.add(boutonItem);
	}

	public void refreshPanelBasByPerso(String persoPrenom) {
		refreshPanelBas(PersoPrenom.valueOf(persoPrenom));
	}

}

