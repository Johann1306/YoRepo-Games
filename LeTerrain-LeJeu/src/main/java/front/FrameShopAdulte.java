package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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
import core.ItemManager;
import core.MusiqueManager;
import core.VideoManager;
import core.configuration.Constante;
import core.utils.JTableUtilities;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.drogue.Drogue;
import modele.item.drogue.DrogueClasse;
import modele.item.drogue.DrogueType;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnageSecondaire;

public class FrameShopAdulte extends FrameJeu {
	
	private static final long serialVersionUID = 1L;
	private JPanel panelNord = new JPanel();
	private JPanel panelOuest = new JPanel();
	private static JPanel panelCentre = null;
	private JPanel panelEst = new JPanel();
	private JPanel panelSud = new JPanel();
	private Mission mission = null;
	
	public FrameShopAdulte(Groupe groupe, Mission mission) {
		
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
		
		// Vitesse de la barre de scroll horizontal
		JScrollBar jScrollBarHorizontalVente = new JScrollBar(1, 5, 5, 0, 10);
		jScrollBarHorizontalVente.setUnitIncrement(50);
		jScrollBarHorizontalVente.setVisible(false);
		scrollPaneVente.setHorizontalScrollBar(jScrollBarHorizontalVente);
		
		// Vitesse de la barre de scroll vertical
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
		panelOuest.setBackground(Color.RED);
		panelCentre.setBackground(Color.WHITE);
		panelEst.setBackground(Color.GREEN);
		panelSud.setBackground(Color.BLUE);
		
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
		
		// Panel Acahat
		
		JPanel panelAchatLabel = new JPanel();
		JLabel labelAchat = new JLabel(" - Drogues a acheter - ");
		labelAchat.setFont(Constante.MARIO_FONT_LABEL_SHOP);
		labelAchat.setForeground(Color.CYAN);
		panelAchatLabel.add(labelAchat);
		
		JPanel panelAchat = new JPanel();
		
		BoxLayout boxlayoutPanelAchat = new BoxLayout(panelAchat, BoxLayout.Y_AXIS);
		panelAchat.setLayout(boxlayoutPanelAchat);
		
		String[] entetesAchat = {"Drogue", "Quantite", "Nom", "Info", "Stats", "Proprio", "Prix", "Action"};

		Map<Item, Integer> itemsAAcheter = new HashMap<>();
		
		// Mission Dahlias
		if (mission.getId() == 250) {
			itemsAAcheter = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getDroguesAAcheterDahlias();
			
		// Mission Bosquets
		} else if (mission.getId() == 260) {
			itemsAAcheter = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getDroguesAAcheterBosquets();
		}
		
		int nbElementsAchat = itemsAAcheter.size();
		Object[][] donneesAchat = new Object[nbElementsAchat][entetesAchat.length];
		int i = 0;
		
		for (Item item : itemsAAcheter.keySet()) {
			
			String statsDrogue = "";
			if (item.getType().name().equals(ItemType.DROGUE.name())) {
				Drogue drogue = (Drogue)item;
				statsDrogue = drogue.getStats();
			}
			
			int quantite = itemsAAcheter.get(item);
			int prix = calculePrixDrogueAAcheter(item, quantite);
			
			donneesAchat[i][0] = item;
			donneesAchat[i][1] = "X " + quantite;
			donneesAchat[i][2] = item.getNom();
			donneesAchat[i][3] = item.getInformations();
			donneesAchat[i][4] = statsDrogue;
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
						
						// Si l'item est une Drogue, on demarre la date de peremption
						if (item instanceof Drogue) {
							Date dateCourante = MenuPrincipal.getMainFrame().getCoreManager().getDateManager().getDateCourante();
							int vitessePeremption = ((Drogue) item).getVitessePeremption();
							Date delai = new Date(0);
							delai.setMonth((2 * vitessePeremption));
							long date = dateCourante.getTime() + delai.getTime(); 
							((Drogue) item).setDatePeremption(new Date(date));
						}
						
						// Ajout de l'objet dans le sac
						leGroupe.ajouteItem(item);
						
						// Suppression de la liste d'objet a acheter
						Map<Item, Integer> droguesAAcheter = new HashMap<>();
						if (mission.getId() == 250) {
							// Mission Dahlias
							droguesAAcheter = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getDroguesAAcheterDahlias();
//							MenuPrincipal.getMainFrame().getCoreManager().getItemManager().removeDroguesAAcheterDahlias(item);
							
						} else if (mission.getId() == 260) {
							// Mission Bosquets
							droguesAAcheter = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getDroguesAAcheterBosquets();
//							MenuPrincipal.getMainFrame().getCoreManager().getItemManager().removeDroguesAAcheterBosquets(item);
						}
						
						droguesAAcheter.put(item, droguesAAcheter.get(item)-1);
						if (droguesAAcheter.get(item) == 0) { 
							
							// Suppression de la ligne dans la table
					        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
					        ((DefaultTableModel)table.getModel()).fireTableRowsDeleted(modelRow, modelRow);
					        
					        // Suppression de l'item du magazin
					        MenuPrincipal.getMainFrame().getCoreManager().getItemManager().removeDroguesAAcheterBosquets(item);
					        MenuPrincipal.getMainFrame().getCoreManager().getItemManager().removeDroguesAAcheterDahlias(item);

						} else {
							
							// Met a jour la quantité de donnees dispo quand vente
							((DefaultTableModel)table.getModel()).setValueAt("X " + droguesAAcheter.get(item), modelRow, 1);;
							((DefaultTableModel)table.getModel()).fireTableCellUpdated(modelRow, 1);
						}
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
		JLabel labelVente = new JLabel(" - Drogues a vendre - ");
		labelVente.setFont(Constante.MARIO_FONT_LABEL_SHOP);
		labelVente.setForeground(Color.YELLOW);
		panelVenteLabel.add(labelVente);
		
		JPanel panelVente = new JPanel();
		
		BoxLayout boxlayoutPanelVente = new BoxLayout(panelVente, BoxLayout.Y_AXIS);
		panelVente.setLayout(boxlayoutPanelVente);
		
		String[] entetesVente = {"Drogue", "Quantite", "Nom", "Info", "Stats", "Proprio", "Prix", "Action"};

		// On ajoute toutes les drogues du sac de groupe
		Map<Item,Integer> mapItemsAVendre = new HashMap<>();
		mapItemsAVendre.putAll(MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getDrogues());
		
		int nbElementsVente = mapItemsAVendre.size();
		Object[][] donneesVente = new Object[nbElementsVente][entetesVente.length];
		int j = 0;
		
		for (Item item : mapItemsAVendre.keySet()) {
			
			String statsDrogue = "";
			if (item.getType().name().equals(ItemType.DROGUE.name())) {
				Drogue drogue = (Drogue)item;
				statsDrogue = drogue.getStats();
			}
			
			int prix = calculePrixDrogueAAcheter(item, 10);
			
			donneesVente[j][0] = item;
			donneesVente[j][1] = "X " + mapItemsAVendre.get(item);
			donneesVente[j][2] = item.getNom();
			donneesVente[j][3] = item.getInformations();
			donneesVente[j][4] = statsDrogue;
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
					leGroupe.ajouteArgent(prixDeVente, false, true);
					
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

	private int calculePrixDrogueAAcheter(Item item, int quantite) {
		int prix = 0;
		if (item instanceof Drogue) {
			Drogue drogue = (Drogue) item;
			
			// Prix augmente en fonction des bonus
			Collection<Integer> values = drogue.getBonusParStat().values();
			for (Integer bonusValue : values) {
				prix = prix + (10 * bonusValue);
			}

			// Prix change en fonction du type de drogue
			if (drogue.getDrogueType().name().equals(DrogueType.CANABIS.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.CANABIS.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.HERBE.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.HERBE.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.COCAINE.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.COCAINE.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.ECSTASY.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.ECSTASY.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.MDMA.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.MDMA.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.SPEED.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.SPEED.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.HEROINE.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.HEROINE.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.LSD.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.LSD.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.GHB.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.GHB.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.POPPERS.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.POPPERS.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.CHAMPIGNON.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.CHAMPIGNON.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.AMPHETAMINE.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.AMPHETAMINE.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.CRISTAL.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.CRISTAL.name());
			} else if (drogue.getDrogueType().name().equals(DrogueType.PAVOT.name())) {
				prix = prix + ItemManager.getPrixDuMoisDesDrogues().get(DrogueType.PAVOT.name());
			}
			
			// Prix augmente en fonction de la qualite
			if (drogue.getDrogueClasse().name().equals(DrogueClasse.VERT.name())) {
				prix = prix * 2;	
			} else if (drogue.getDrogueClasse().name().equals(DrogueClasse.BLEU.name())) {
				prix = prix * 3;	
			} else if (drogue.getDrogueClasse().name().equals(DrogueClasse.VIOLET.name())) {
				prix = prix * 5;	
			}
			
			// Prix varie en fonction de l'offre et la demande 50% du prix en moins quand 10 elements
			int variation = (prix * (quantite -1)) / 20;
			prix = prix - variation;
			
			// Arrondi au superieur dizaine
			prix = (prix / 10) + 1;
			prix = prix * 10;

			// Arrondi au superieur centaine
			if (prix > 999) {
				prix = (prix / 100);
				prix = prix * 100;				
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

	public static FrameShopAdulte getFrameShop() {
		return (FrameShopAdulte) panelCentre.getParent().getParent().getParent().getParent().getParent().getParent();
	}
}
