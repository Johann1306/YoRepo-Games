package front;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JViewport;

import core.ImageManager;
import core.MusiqueManager;
import core.PersonnageManager;
import core.configuration.Constante;
import modele.item.carte.Carte;
import modele.item.lieu.Lieu;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.poi.Poi;
import modele.location.Location;

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
	private JLabel labelCarte = null;
	 
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
		
		// On recupere la carte
		Carte carte = MenuPrincipal.getMainFrame().getCoreManager().getCarteManager().getCartes().get(0);
		ImageIcon imageCarte = FenetrePrincipal.getImageIcon(carte.getImagePath().get(0));
		ImageIcon resizedImage = ImageManager.resizeImage(imageCarte, Constante.PANEL_CENTRE_DIMENSION);
		labelCarte = new JLabel(resizedImage);

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
		this.add(panelGroupe);
		this.add(panelJohann);
		this.add(panelNicolas);
		this.add(panelPierre);
		this.add(panelThomas);
		this.add(panelYannick);
		this.add(panelAli);
		this.add(panelGuillaume);
		this.add(panelJonathan);
	}

	// Construit l'enchainement de map/lieu/poi/missions/jeux pour un panel perso
	private void buildPanelPerso(JComponent panel) {
		
		panel.removeAll();

		// On recupere les lieux disponibles pour cette carte
		Carte carte = MenuPrincipal.getMainFrame().getCoreManager().getCarteManager().getCartes().get(0);
		List<Lieu> lieuxPersoGroupe = carte.getLieuxDisponiblesByPersoAndGroupe(panel.getName());
		PersonnageManager personnageManager = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager();
		for (Lieu lieu : lieuxPersoGroupe) {
			// Affiche le nombre de nouvelles missions sur ce lieu
			int nbMissionsLieu = 0;
			for (Poi poi : lieu.getPois()) {
				nbMissionsLieu = nbMissionsLieu + poi.getNouvellesMissionsDisponibles().size();
			}
			JButton bouton = null;
			if (nbMissionsLieu == 0) {
				bouton = new JButton(lieu.getNom()); 
				bouton.setToolTipText(lieu.getInformations());
			} else {
				bouton = new JButton(lieu.getNom() + " (" + nbMissionsLieu + ")");
				if (nbMissionsLieu == 1) {
					bouton.setToolTipText(lieu.getInformations() + " (" + nbMissionsLieu + " mission disponible)");
				} else {
					bouton.setToolTipText(lieu.getInformations() + " (" + nbMissionsLieu + " missions disponibles)");
				}
				bouton.setBackground(Color.YELLOW);
			}
			bouton.setFont(Constante.SIMPSON_FONT);
			
			JPanel panelBouton = new JPanel();
			panelBouton.setLocation(lieu.getPosition());
			panelBouton.add(bouton);
			panelBouton.setOpaque(false);
//			panelBouton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 10, true));
			BoxLayout boxlayoutBouton = new BoxLayout(panelBouton, BoxLayout.Y_AXIS);
			panelBouton.setLayout(boxlayoutBouton);
			
			// Si Clic sur un lieu de la carte
			bouton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO evenement aleatoire quand deplacement lieu
					System.out.println("- evenement aleatoire quand deplacement lieu");
					
					MusiqueManager.playSon("sonParDefaut/bom-ncis.mp3");
					
					// Deplacement du perso ou du groupe
					if (panel.getName() == PersoPrenom.GROUPE.name()) {
						List<PersonnagePrincipal> persos = personnageManager.getPersoVivantsEtDejaPresentes();
						for (PersonnagePrincipal personnagePrincipal : persos) {
							personnagePrincipal.setLocation(new Location(lieu, lieu.getPosition()));
						}
					} else {
						PersonnagePrincipal persoCourant = personnageManager.getPersoByPrenom(panel.getName());
						persoCourant.setLocation(new Location(lieu, lieu.getPosition()));
					}
					
					panel.removeAll();
					for (Poi poi : lieu.getPois()) {
						// Affiche le nombre de nouvelles missions sur ce lieu
						int nbMissionsPoi = poi.getNouvellesMissionsDisponibles().size();
						JButton bouton = null;
						if (nbMissionsPoi == 0) {
							bouton = new JButton(poi.getNom());
						} else {
							bouton = new JButton(poi.getNom() + " (" + nbMissionsPoi + ")");
						}
						bouton.setFont(Constante.SIMPSON_FONT);
						// TODO taille bouton unique (minimum)
//						bouton.setMaximumSize(Constante.BOUTON_LIEU_DIMENSION);
						JPanel panelBouton = new JPanel();
						panelBouton.setLocation(poi.getPoint());
						panelBouton.add(bouton);
						panelBouton.setOpaque(false);
						panelBouton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 10, true));
						
						// Si Clic sur un Poi
						bouton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO evenement aleatoire quand selection Poi
								System.out.println("- evenement aleatoire quand selection Poi");
								MusiqueManager.playSon("sonParDefaut/bom-ncis.mp3");
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
					
					ImageIcon imageIcon = FenetrePrincipal.getImageIcon(lieu.getBackgroundPath());
					ImageIcon resizedImage = ImageManager.resizeImage(imageIcon, Constante.PANEL_CENTRE_DIMENSION);			
					JLabel background = new JLabel(resizedImage);
					panel.add(background, Integer.valueOf(1));
					// Gestion scroll dragged panel centre
					Moustener moustener = new Moustener(background);
					MainFrame.getScrollPaneCentre().getViewport().addMouseMotionListener(moustener);
					MainFrame.getScrollPaneCentre().getViewport().addMouseListener(moustener);
					cardLayout.show(MainFrame.getPanelCentre(), panel.getName());
					revalidate();
				}
			});
			panel.add(panelBouton, Integer.valueOf(10));
		}

		// On ajoute l'image du perso a sa position
		PersonnagePrincipal perso = personnageManager.getPersoByPrenom(panel.getName());
		// TODO si perso null, c'est que c'est le persoGroupe => afficher alors tous les persos sur la map
		if (perso != null) {
			// TODO icone ronde
			JPanel panelPerso = new JPanel();
			BoxLayout boxlayoutPerso = new BoxLayout(panelPerso, BoxLayout.Y_AXIS);
			panelPerso.setLayout(boxlayoutPerso);
//			panelPerso.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
			Point coordonnees = perso.getLocation().getCoordonnees();
			// TODO On deplace l'image au dessus du bouton lieu
			Point decalage = new Point(); 
			decalage.setLocation(coordonnees.getX(), coordonnees.getY() - Constante.PERSO_IMAGE_DIMENSION_50_50.getHeight() -6 );
			panelPerso.setLocation(decalage);
			panelPerso.setOpaque(false);
			
			ImageIcon photo = perso.getPhotoPrincipal();
			ImageIcon resizeImage = ImageManager.resizeImage(photo, Constante.PERSO_IMAGE_DIMENSION_50_50);
			JLabel labelPerso = new JLabel(resizeImage);
			labelPerso.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
			panelPerso.add(labelPerso);
			
			panel.add(panelPerso, Integer.valueOf(5));
		} else {
			// Panel groupe : On affiche tous les persos a leur positions
			List<Point> points = new ArrayList<Point>();
			for (PersonnagePrincipal persoP : personnageManager.getPersoVivantsEtDejaPresentes()) {
				// TODO icone ronde /  duplication de batard
				// TODO quand plusieurs persos au meme endroit
				JPanel panelPerso = new JPanel();
				BoxLayout boxlayoutPerso = new BoxLayout(panelPerso, BoxLayout.Y_AXIS);
				panelPerso.setLayout(boxlayoutPerso);
//				panelPerso.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
				Point coordonnees = persoP.getLocation().getCoordonnees();
				// On deplace l'image au dessus du bouton lieu
				Point decalage = new Point();
				decalage.setLocation(coordonnees.getX(), coordonnees.getY() - Constante.PERSO_IMAGE_DIMENSION_50_50.getHeight() -6 );
				while (points.contains(decalage)) {
					decalage.setLocation(decalage.x + Constante.PERSO_IMAGE_DIMENSION_50_50.getWidth() + 3 , decalage.y);
				}
				points.add(decalage);
				panelPerso.setLocation(decalage);
				panelPerso.setOpaque(false);
				
				ImageIcon photo = persoP.getPhotoPrincipal();
				ImageIcon resizeImage = ImageManager.resizeImage(photo, Constante.PERSO_IMAGE_DIMENSION_50_50);
				JLabel labelPerso = new JLabel(resizeImage);
				labelPerso.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
				panelPerso.add(labelPerso);
				
				panel.add(panelPerso, Integer.valueOf(5));
			}
		}
		
		// On ajoute la carte au panel
		panel.add(labelCarte, Integer.valueOf(1));
		// Gestion scroll dragged panel centre
		if (MainFrame.getScrollPaneCentre() != null) {
			Moustener moustener = new Moustener(labelCarte);
			MainFrame.getScrollPaneCentre().getViewport().addMouseMotionListener(moustener);
			MainFrame.getScrollPaneCentre().getViewport().addMouseListener(moustener);
		}
		revalidate();
	}

	// Duplicate dans PanelFichePerso
	private void addBoutonCarte(JComponent panel, JPanel panelBouton) {
		JButton boutonCarte = new JButton("Retour Carte");
		boutonCarte.setFont(Constante.SIMPSON_FONT);
		boutonCarte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MusiqueManager.playSon("sonParDefaut/bom-ncis.mp3");
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

	public void refreshPanelCourant() {
		// TODO refresh uniquement le nom des boutons du panel courant
		buildPanelPerso(getPanelShowing());
		this.revalidate();
	}

	public void afficheFichePerso(String prenomPerso) {
		buildFichePerso(prenomPerso);
		this.revalidate();
	}

	private void buildFichePerso(String prenomPerso) {
		JLayeredPane panel = getPanelShowing();
		panel.removeAll();
		panel.add(new PanelFichePerso(prenomPerso));		
	}
	
	private class Moustener extends MouseAdapter {
		
	    private final Cursor defCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
	    private final Cursor hndCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	    private final Point pp = new Point();
	    private JLabel image;

	    public Moustener(JLabel image) {
	        this.image = image;
	    }
		
		@Override
		public void mouseDragged(MouseEvent e) {
	        JViewport vport = (JViewport)e.getSource();
	        Point cp = e.getPoint();
	        Point vp = vport.getViewPosition();
	        vp.translate(pp.x-cp.x, pp.y-cp.y);
	        image.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
	        pp.setLocation(cp);
		}
		
		public void mousePressed(MouseEvent e) {
	        image.setCursor(hndCursor);
	        pp.setLocation(e.getPoint());
	    }

	    public void mouseReleased(MouseEvent e) {
	        image.setCursor(defCursor);
	        image.repaint();
	    }
	}
}
