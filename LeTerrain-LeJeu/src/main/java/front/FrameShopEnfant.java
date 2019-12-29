package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import core.ImageManager;
import core.MusiqueManager;
import core.VideoManager;
import core.configuration.Constante;
import core.utils.JTableUtilities;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.arme.Arme;
import modele.item.arme.ArmeClasse;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;

public class FrameShopEnfant extends FrameJeu {
	
	private static final long serialVersionUID = 1L;
	private JPanel panelNord = new JPanel();
	private JPanel panelOuest = new JPanel();
	private static JPanel panelCentre = null;
	private JPanel panelEst = new JPanel();
	private JPanel panelSud = new JPanel();
	private Mission mission = null;
	
	public FrameShopEnfant(Groupe groupe, Mission mission) {
		
		this.mission = mission;
		
		// Configuration de la fenetre
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		
		// -- Panel Nord - Info
		JPanel panelInfoMission = createPanelInfoMission(mission);
		panelNord.add(panelInfoMission);
		
		// -- Panel Centre
		
		panelCentre = new JPanel();
		refreshPanelAchatVente();
	
		// --
		
		BoxLayout boxlayout = new BoxLayout(panelCentre, BoxLayout.Y_AXIS);
		panelCentre.setLayout(boxlayout);
		
		JScrollPane scrollPaneVente = new JScrollPane();
		// Vitesse de la barre de scroll
		JScrollBar jScrollBarHorizontalVente = new JScrollBar(1, 5, 5, 0, 10);
		jScrollBarHorizontalVente.setUnitIncrement(50);
		jScrollBarHorizontalVente.setVisible(false);
		scrollPaneVente.setHorizontalScrollBar(jScrollBarHorizontalVente);
		
		JScrollBar jScrollBarVerticalVente = new JScrollBar(1, 5, 5, 0, 10);
		jScrollBarVerticalVente.setUnitIncrement(50);
		jScrollBarVerticalVente.setVisible(false);
		scrollPaneVente.setVerticalScrollBar(jScrollBarVerticalVente);

		scrollPaneVente.getViewport().add(panelCentre);
		scrollPaneVente.setBackground(Color.BLACK);
		scrollPaneVente.setFocusable(false);
		scrollPaneVente.setBorder(BorderFactory.createLoweredBevelBorder());
		
		// --
		
		// Panel Sud
		
		// Panel Bourse
		JPanel panelBourse = new JPanel();
		
		// TODO faire mieux qu'un thread toute les seconde => refresh du label seulement quand on gagne de l'argent
		// label Argent du groupe
		int argent = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getBourse();
		JLabel labelArgent = new JLabel("Bourse : " + argent + " Francs");
		Thread t1 = new Thread(new Runnable() {
	
			@Override
			public void run() {
				try {
					while(true) {
						Thread.sleep(1000);
						int argent = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getBourse();
						labelArgent.setText("Bourse : " + argent + " Francs");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		if (!t1.isAlive()) {
			t1.start();
		}
		
		labelArgent.setFont(Constante.MARIO_FONT_LABEL_SHOP);
		labelArgent.setForeground(Color.YELLOW);
		
		panelBourse.add(labelArgent);
		
		// Panel Quitter
		JPanel panelQuitter = new JPanel();
		
		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.setFont(Constante.MARIO_FONT_MENU_3);
		boutonQuitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stop(mission);
			}
		});
		panelQuitter.add(boutonQuitter);
		
		panelSud.add(panelBourse);
		panelBourse.setBackground(Color.BLACK);
		panelSud.add(panelQuitter);
		panelQuitter.setBackground(Color.BLACK);
		
		// --
	
		this.setAlwaysOnTop(true);
		// Full screen
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		centreFenetre();
		
		panelNord.setBackground(Color.BLACK);
		panelOuest.setBackground(Color.BLACK);
		panelCentre.setBackground(Color.BLACK);
		panelEst.setBackground(Color.BLACK);
		panelSud.setBackground(Color.BLACK);
		
		content.add(panelNord, BorderLayout.NORTH);
		content.add(panelOuest, BorderLayout.WEST);
		content.add(scrollPaneVente, BorderLayout.CENTER);
		content.add(panelEst, BorderLayout.EAST);
		content.add(panelSud, BorderLayout.SOUTH);
		
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(content);
		this.setVisible(true);
	}
	
	private void refreshPanelAchatVente() {
		
		panelCentre.removeAll();
		
		// Panel Achat
		
		JPanel panelAchatLabel = new JPanel();
		JLabel labelAchat = new JLabel(" < Objets a acheter > ");
		labelAchat.setFont(Constante.MARIO_FONT_LABEL_SHOP);
		labelAchat.setForeground(Color.YELLOW);
		panelAchatLabel.add(labelAchat);
		
		JPanel panelAchat = new JPanel();
		
		BoxLayout boxlayoutPanelAchat = new BoxLayout(panelAchat, BoxLayout.Y_AXIS);
		panelAchat.setLayout(boxlayoutPanelAchat);
		
		String[] entetesAchat = {"Objet", "Quantite", "Nom", "Info", "Stats", "Proprio", "Prix", "Action"};
		

		List<Item> itemsAAcheter = new ArrayList<>();
		
		// Mission Miranda
		if (mission.getId() == 230) {
			itemsAAcheter = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getItemsAAcheterMiranda();
			
		// Mission Tonelle
		} else if (mission.getId() == 240) {
			itemsAAcheter = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getItemsAAcheterTonelle();
		}

		int nbElementsAchat = itemsAAcheter.size();
		Object[][] donneesAchat = new Object[nbElementsAchat][entetesAchat.length];
		int i = 0;
		
		for (Item item : itemsAAcheter) {
			
			String statsArme = "";
			if (item.getType().name().equals(ItemType.ARME.name())) {
				Arme arme = (Arme)item;
				statsArme = arme.getStats();
			}
			
			int prix = calculePrixItemAAcheter(item);
			
			donneesAchat[i][0] = item;
			donneesAchat[i][1] = "X 1";
			donneesAchat[i][2] = item.getNom();
			donneesAchat[i][3] = item.getInformations();
			donneesAchat[i][4] = statsArme;
			donneesAchat[i][5] = item.getProprietaire().name();
			donneesAchat[i][6] = prix;
			donneesAchat[i][7] = "Acheter";
			i++;
		}
		
		DefaultTableModel modelAchat = new DefaultTableModel(donneesAchat, entetesAchat);
		JTable tableauAchat = new JTable(modelAchat) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				// On desactive toute les cellules sauf les cellules avec bouton
				if (colIndex != 7) {
					return false;   
				} else {
					return true;
				}
			}
		};
		tableauAchat.setFocusable(false);
		tableauAchat.setCellSelectionEnabled(false);
		tableauAchat.setRowSelectionAllowed(false);
		tableauAchat.setColumnSelectionAllowed(false);
		tableauAchat.setFont(Constante.MARIO_FONT_SHOP_TABLEAU);
		tableauAchat.getTableHeader().setReorderingAllowed(false);
		tableauAchat.getTableHeader().setPreferredSize(Constante.SHOP_TAB_ENTETES_DIMENSION);
		tableauAchat.getTableHeader().setFont(Constante.MARIO_FONT_SHOP_ENTETES);
		tableauAchat.setRowHeight(50);;
		tableauAchat.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableauAchat.getColumnModel().getColumn(0).setCellRenderer(new MyImageCellRenderer());
		tableauAchat.getColumnModel().getColumn(0).setMaxWidth(50);
		tableauAchat.getColumnModel().getColumn(1).setMaxWidth(80);
		tableauAchat.getColumnModel().getColumn(2).setMaxWidth(250);
		tableauAchat.getColumnModel().getColumn(3).setMaxWidth(600);
		tableauAchat.getColumnModel().getColumn(4).setMaxWidth(800);
		tableauAchat.getColumnModel().getColumn(5).setMaxWidth(100);
		tableauAchat.getColumnModel().getColumn(6).setMaxWidth(100);
		tableauAchat.getColumnModel().getColumn(7).setMaxWidth(150);
		JTableUtilities.setCellsAlignmentForTableAchat(tableauAchat, SwingConstants.CENTER);
		
		Action deleteAchat = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
				MusiqueManager.playSon("sonParDefaut/bip-caisse.mp3");

		    	JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        Item item = (Item) table.getValueAt(modelRow, 0);
		        
		        // Test si on a suffisament d'argent pour payer
		    	int prixDeVente = (int) donneesAchat[modelRow][6];
		    	Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
				int bourse = leGroupe.getBourse();
		    	if (prixDeVente > bourse) {
		    		JLabel messageLabel = new JLabel("T'as pas assez d'argent mec! Reviens plus tard!");
		    		messageLabel.setFont(Constante.MARIO_FONT_MENU_3);
					JOptionPane.showMessageDialog(panelCentre, messageLabel);
		    		
		    	} else {
		    		
		    		// Popup de confirmation Achat
		    		String message = "T'es sur de vouloir acheter " + item.getNom() + " pour " + prixDeVente + " Francs?";
		    		JLabel messageLabel = new JLabel(message);
		    		messageLabel.setFont(Constante.MARIO_FONT_MENU_2);
					int reponse = JOptionPane.showConfirmDialog(panelCentre, messageLabel);
					if (reponse == 0) {		    	
						
						// Retire les sous de la bourse du groupe
						leGroupe.enleveArgent(prixDeVente);
						
						// Ajout de l'objet dans le sac
						leGroupe.ajouteItem(item);
						
						// Suppression de la liste d'objet a acheter
						if (mission.getId() == 230) {
							// Mission Miranda
							MenuPrincipal.getMainFrame().getCoreManager().getItemManager().removeItemsAAcheterMiranda(item);
							
						} else if (mission.getId() == 240) {
							// Mission Tonelle
							MenuPrincipal.getMainFrame().getCoreManager().getItemManager().removeItemsAAcheterTonelle(item);
						}
						
						// Suppression de la ligne dans la table
				        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
				        ((DefaultTableModel)table.getModel()).fireTableRowsDeleted(modelRow, modelRow);
				        ((DefaultTableModel)table.getModel()).fireTableDataChanged();
				        refreshPanelAchatVente();
					} 
		    	}
		    }
		};
		 
		ButtonColumn buttonColumnAchat = new ButtonColumn(tableauAchat, deleteAchat, 7);
		buttonColumnAchat.setMnemonic(KeyEvent.VK_A);
		
		panelAchat.add(tableauAchat.getTableHeader());
		panelAchat.add(tableauAchat);
		
		// Panel Vide
		
		JPanel panelVideAchat = new JPanel();
		JPanel panelVideVente = new JPanel();
		
		
		// Panel Vente

		JPanel panelVenteLabel = new JPanel();
		JLabel labelVente = new JLabel(" < Objets a vendre > ");
		labelVente.setFont(Constante.MARIO_FONT_LABEL_SHOP);
		labelVente.setForeground(Color.CYAN);
		panelVenteLabel.add(labelVente);
		
		JPanel panelVente = new JPanel();
		
		BoxLayout boxlayoutPanelVente = new BoxLayout(panelVente, BoxLayout.Y_AXIS);
		panelVente.setLayout(boxlayoutPanelVente);
		
		String[] entetesVente = {"Objet", "Quantite", "Nom", "Info", "Stats", "Proprio", "Prix", "Action"};

		// On ajoute tous les objets du sac de groupe (armes + popos)
		Map<Item,Integer> mapItemsAVendre = new HashMap<>();
		mapItemsAVendre.putAll(MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getSac());

		// On propose a la vente les objets du sac groupe plus les objets perso(non equipes)
		List<PersonnagePrincipal> persosDejaPresentes = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoDejaPresentes();
		for (PersonnagePrincipal personnagePrincipal : persosDejaPresentes) {
			
			// On ajoute tous les objets du sac de chaque perso (armes)
			Map<Item, Integer> sacPerso = personnagePrincipal.getSac();
			for (Item item : sacPerso.keySet()) {
				if (item.getType().name().equals(ItemType.ARME.name())) {
					mapItemsAVendre.put(item, sacPerso.get(item));
				}
			}
			
			// On ne propose pas a la vente les objets deja equipes
			Arme armePerso = personnagePrincipal.getArme();
			if (armePerso != null) {
				mapItemsAVendre.remove(armePerso);
			}
		}
		
		int nbElementsVente = mapItemsAVendre.size();
		Object[][] donneesVente = new Object[nbElementsVente][entetesVente.length];
		int j = 0;
		
		for (Item item : mapItemsAVendre.keySet()) {
			
			String statsArme = "";
			if (item.getType().name().equals(ItemType.ARME.name())) {
				Arme arme = (Arme)item;
				statsArme = arme.getStats();
			}
			
			int prix = calculePrixItemAAcheter(item);
			prix = prix / Constante.COEF_PRIX_VENTE;
			
			donneesVente[j][0] = item;
			donneesVente[j][1] = "X " + mapItemsAVendre.get(item);
			donneesVente[j][2] = item.getNom();
			donneesVente[j][3] = item.getInformations();
			donneesVente[j][4] = statsArme;
			donneesVente[j][5] = item.getProprietaire().name();
			donneesVente[j][6] = prix;
			donneesVente[j][7] = "Vendre";
			j++;
		}
		
		DefaultTableModel modelVente = new DefaultTableModel(donneesVente, entetesVente);
		JTable tableauVente = new JTable(modelVente) {
			public boolean isCellEditable(int rowIndex, int colIndex) {     
				// On desactive toute les cellules sauf les cellules avec bouton
				if (colIndex != 7) {
					return false;   
				} else {
					return true;
				}
			}
		};
		tableauVente.setFocusable(false);
		tableauVente.setCellSelectionEnabled(false);
		tableauVente.setRowSelectionAllowed(false);
		tableauVente.setColumnSelectionAllowed(false);
		tableauVente.getColumnModel().setColumnSelectionAllowed(false);
		tableauVente.setFont(Constante.MARIO_FONT_SHOP_TABLEAU);
		tableauVente.getTableHeader().setReorderingAllowed(false);
		tableauVente.getTableHeader().setPreferredSize(Constante.SHOP_TAB_ENTETES_DIMENSION);
		tableauVente.getTableHeader().setFont(Constante.MARIO_FONT_SHOP_ENTETES);
		tableauVente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableauVente.setRowHeight(50);;
		tableauVente.getColumnModel().getColumn(0).setCellRenderer(new MyImageCellRenderer());
		tableauVente.getColumnModel().getColumn(0).setMaxWidth(50);
		tableauVente.getColumnModel().getColumn(1).setMaxWidth(80);
		tableauVente.getColumnModel().getColumn(2).setMaxWidth(250);
		tableauVente.getColumnModel().getColumn(3).setMaxWidth(600);
		tableauVente.getColumnModel().getColumn(4).setMaxWidth(800);
		tableauVente.getColumnModel().getColumn(5).setMaxWidth(100);
		tableauVente.getColumnModel().getColumn(6).setMaxWidth(100);
		tableauVente.getColumnModel().getColumn(7).setMaxWidth(150);
		JTableUtilities.setCellsAlignmentForTableAchat(tableauVente, SwingConstants.CENTER);
		
		Action deleteVente = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
				MusiqueManager.playSon("sonParDefaut/bip-caisse.mp3");
		    	JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        Item item = (Item) table.getValueAt(modelRow, 0);
		        
		    	int prixDeVente = (int) donneesVente[modelRow][6];
		    	Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		    		
	    		// Popup de confirmation Achat
		    	String message = "T'es sur de vouloir vendre " + item.getNom() + " pour " + prixDeVente + " Francs?";
	    		JLabel messageLabel = new JLabel(message);
	    		messageLabel.setFont(Constante.MARIO_FONT_MENU_3);
				int reponse = JOptionPane.showConfirmDialog(panelCentre, messageLabel);
				if (reponse == 0) {		    	
					
					// Ajoute les sous a la bourse du groupe
					leGroupe.ajouteArgent(prixDeVente, true, false);
					
					// Retire l'objet du sac
					leGroupe.enleveItem(item);
					
					// Si il n'y a plus de cet item
					mapItemsAVendre.put(item, mapItemsAVendre.get(item)-1);
					if (mapItemsAVendre.get(item) == 0) { 
						
						// Suppression de la ligne dans la table
				        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
				        ((DefaultTableModel)table.getModel()).fireTableRowsDeleted(modelRow, modelRow);
					} else {
						
						// Met a jour la quantité de donnees dispo quand vente
						((DefaultTableModel)table.getModel()).setValueAt("X " + mapItemsAVendre.get(item), modelRow, 1);;
						((DefaultTableModel)table.getModel()).fireTableCellUpdated(modelRow, 1);
					}
			        ((DefaultTableModel)table.getModel()).fireTableDataChanged();
			        refreshPanelAchatVente();

				} 
		    }
		};
		 
		ButtonColumn buttonColumnVente = new ButtonColumn(tableauVente, deleteVente, 7);
		buttonColumnVente.setMnemonic(KeyEvent.VK_V);
		
		panelVente.add(tableauVente.getTableHeader());
		panelVente.add(tableauVente);
		
		panelCentre.add(panelVideAchat);
		panelVideAchat.setBackground(Color.BLACK);
		panelCentre.add(panelAchatLabel);
		panelAchatLabel.setBackground(Color.BLACK);
		panelCentre.add(panelAchat);
		panelAchat.setBackground(Color.BLACK);
		panelCentre.add(panelVideVente);
		panelVideVente.setBackground(Color.BLACK);
		panelCentre.add(panelVenteLabel);
		panelVenteLabel.setBackground(Color.BLACK);
		panelCentre.add(panelVente);
		panelVente.setBackground(Color.BLACK);
		
	}

	private int calculePrixItemAAcheter(Item item) {
		int prix = 50;
		if (item instanceof Arme) {
			Arme arme = (Arme) item;
			Collection<Integer> values = arme.getBonusParStat().values();
			for (Integer bonusValue : values) {
				prix = prix + (10 * bonusValue);
			}
			prix = prix + 10 * (arme.getDegatsMin() + arme.getDegatsMax()); 
			if (arme.getArmeClasse().name().equals(ArmeClasse.VERT)) {
				prix = prix + 100;	
			} else if (arme.getArmeClasse().name().equals(ArmeClasse.BLEU)) {
				prix = prix + 250;	
			} else if (arme.getArmeClasse().name().equals(ArmeClasse.VIOLET)) {
				prix = prix + 500;	
			}
		} else {
			String type = item.getType().name();
			if (type.equals(ItemType.POTION_MANA_25.name()) || type.equals(ItemType.POTION_VIE_25.name())) {
				prix = 100;
			} else if (type.equals(ItemType.POTION_MANA_50.name()) || type.equals(ItemType.POTION_VIE_50.name())) {
				prix = 250;
			} else if (type.equals(ItemType.POTION_MANA_75.name()) || type.equals(ItemType.POTION_VIE_75.name())) {
				prix = 750;
			} else if (type.equals(ItemType.POTION_MANA_100.name()) || type.equals(ItemType.POTION_VIE_100.name())) {
				prix = 1500;
			} else if (type.equals(ItemType.BONUS_STAT_AGILITE_5.name()) 
					|| type.equals(ItemType.BONUS_STAT_CHANCE_5.name())
					|| type.equals(ItemType.BONUS_STAT_ENDURANCE_5.name())
					|| type.equals(ItemType.BONUS_STAT_INTELLIGENCE_5.name())
					|| type.equals(ItemType.BONUS_STAT_NERVOSITE_5.name())
					|| type.equals(ItemType.BONUS_STAT_RAPIDITE_5.name())
					|| type.equals(ItemType.BONUS_STAT_RESISTANCE_5.name())
					|| type.equals(ItemType.BONUS_STAT_TECHNIQUE_5.name())
					|| type.equals(ItemType.BONUS_STAT_EXPLOIT_5.name())
					) {
				prix = 500;
			} else if (type.equals(ItemType.BONUS_STAT_AGILITE_10.name()) 
					|| type.equals(ItemType.BONUS_STAT_CHANCE_10.name())
					|| type.equals(ItemType.BONUS_STAT_ENDURANCE_10.name())
					|| type.equals(ItemType.BONUS_STAT_INTELLIGENCE_10.name())
					|| type.equals(ItemType.BONUS_STAT_NERVOSITE_10.name())
					|| type.equals(ItemType.BONUS_STAT_RAPIDITE_10.name())
					|| type.equals(ItemType.BONUS_STAT_RESISTANCE_10.name())
					|| type.equals(ItemType.BONUS_STAT_TECHNIQUE_10.name())
					|| type.equals(ItemType.BONUS_STAT_EXPLOIT_10.name())
					) {
				prix = 800;
			} else if (type.equals(ItemType.BONUS_STAT_AGILITE_20.name()) 
					|| type.equals(ItemType.BONUS_STAT_CHANCE_20.name())
					|| type.equals(ItemType.BONUS_STAT_ENDURANCE_20.name())
					|| type.equals(ItemType.BONUS_STAT_INTELLIGENCE_20.name())
					|| type.equals(ItemType.BONUS_STAT_NERVOSITE_20.name())
					|| type.equals(ItemType.BONUS_STAT_RAPIDITE_20.name())
					|| type.equals(ItemType.BONUS_STAT_RESISTANCE_20.name())
					|| type.equals(ItemType.BONUS_STAT_TECHNIQUE_20.name())
					|| type.equals(ItemType.BONUS_STAT_EXPLOIT_20.name())
					) {
				prix = 1500;
			}

		}
		return prix;
	}

	public void start() {
		MenuPrincipal.getMainFrame().setEnabled(false);
		MenuPrincipal.getMainFrame().setVisible(false);
		VideoManager.hideAndStop();
		MusiqueManager.stopAll();
		
		// TODO Musique de boutique / cité
		MusiqueManager.startPlayListEnBoucle(mission);
		
		// TODO Image du proprio de la boutique
		PersonnageSecondaire personnageSecondaire = mission.getPersonnagesSecondaires().get(0);
		ImageIcon photoPrincipal = personnageSecondaire.getPhotoPrincipal();
		ImageIcon resizeImage = ImageManager.resizeImage(photoPrincipal, Constante.EVENEMENT_IMAGE_DIMENSION_300_300);
		String messageAcceuil = personnageSecondaire.getPhrasesPerso().get(0);
		JLabel messageLabel = new JLabel(messageAcceuil);
		messageLabel.setFont(Constante.MARIO_FONT_MENU_3);
		JOptionPane.showMessageDialog(this, messageLabel, "Penetrer le lieu", 0, resizeImage);
	}

	// Fin du jeu
	private void stop(Mission mission) {

		// Message fin du jeu
		PersonnageSecondaire personnageSecondaire = mission.getPersonnagesSecondaires().get(0);
		ImageIcon photoPrincipal = personnageSecondaire.getPhotoPrincipal();
		ImageIcon resizeImage = ImageManager.resizeImage(photoPrincipal, Constante.EVENEMENT_IMAGE_DIMENSION_300_300);
		String messageFin = personnageSecondaire.getPhrasesPerso().get(1);
		JLabel messageLabel = new JLabel(messageFin);
		messageLabel.setFont(Constante.MARIO_FONT_MENU_3);
		JOptionPane.showMessageDialog(this, messageLabel, "Quitter le lieu", 0, resizeImage);
		
		// Fermeture des fenetres
		this.removeAll();
		this.dispose();
		MainFrame.getPanelBas().refreshPanelBas(PersoPrenom.GROUPE);
		MenuPrincipal.getMainFrame().setEnabled(true);
		MenuPrincipal.getMainFrame().setVisible(true);
		VideoManager.show();
		MusiqueManager.stopAll();
		
		// Fin de la mission
		MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().termineMission(mission, true);
	}
	
	private void centreFenetre() {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	}

	public static FrameShopEnfant getFrameShop() {
		return (FrameShopEnfant) panelCentre.getParent().getParent().getParent().getParent().getParent().getParent();
	}
}
