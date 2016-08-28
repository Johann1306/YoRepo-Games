package front;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import core.MenuManager;
import core.PersonnageManager;
import core.configuration.Constante;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class PanelPersonnage extends JPanel {
	
	// Recuperation des  personnages principaux

//	private ImageIcon iconNicolas = null;
//	private ImageIcon iconPierre = null;
//	private ImageIcon iconYannick = null;
//	private ImageIcon iconThomas = null;
//	private ImageIcon iconJohann = null;
//	private ImageIcon iconAli = null;
//	private ImageIcon iconGuillaume = null;
//	private ImageIcon iconJonathan = null;
//
//	private JButton boutonNicolas = null;
//	private JButton boutonPierre = null;
//	private JButton boutonYannick = null;
//	private JButton boutonThomas = null;
//	private JButton boutonJohann = null;
//	private JButton boutonAli = null;
//	private JButton boutonGuillaume = null;
//	private JButton boutonJonathan = null;
//	private JButton boutonGroupe = null;
	
	public PanelPersonnage() {
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxlayout);
		
		Groupe leGroupe = PersonnageManager.getLeGroupe();
		PersonnagePrincipal nicolas = leGroupe.getPersoByNom(PersoPrenom.NICOLAS);
		PersonnagePrincipal pierre = leGroupe.getPersoByNom(PersoPrenom.PIERRE);
		PersonnagePrincipal yannick = leGroupe.getPersoByNom(PersoPrenom.YANNICK);
		PersonnagePrincipal thomas = leGroupe.getPersoByNom(PersoPrenom.THOMAS);
		PersonnagePrincipal johann = leGroupe.getPersoByNom(PersoPrenom.JOHANN);
		PersonnagePrincipal ali = leGroupe.getPersoByNom(PersoPrenom.ALI);
		PersonnagePrincipal guillaume = leGroupe.getPersoByNom(PersoPrenom.GUILLAUME);
		PersonnagePrincipal jonathan = leGroupe.getPersoByNom(PersoPrenom.JONATHAN);
		
		JButton boutonNicolas = new JButton(nicolas.getPhotoPrincipal());
		JButton boutonPierre = new JButton(pierre.getPhotoPrincipal());
		JButton boutonYannick = new JButton(yannick.getPhotoPrincipal());
		JButton boutonThomas = new JButton(thomas.getPhotoPrincipal());
		JButton boutonJohann = new JButton(johann.getPhotoPrincipal());
		JButton boutonAli = new JButton(ali.getPhotoPrincipal());
		JButton boutonGuillaume = new JButton(guillaume.getPhotoPrincipal());
		JButton boutonJonathan = new JButton(jonathan.getPhotoPrincipal());
		JButton boutonGroupe = new JButton("GROUPE");
		
		boutonNicolas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonPierre.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonYannick.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonThomas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonJohann.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonAli.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonGuillaume.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		boutonJonathan.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION);
		// TODO
		//		boutonGroupe.setMinimumSize(new Dimension(pressIcon1.getIconWidth(), pressIcon1.getIconHeight()/2));
		boutonGroupe.setMaximumSize(Constante.PERSO_IMAGE_DIMENSION);
	
		boutonNicolas.setToolTipText(PersoPrenom.NICOLAS + " " + PersoNom.LOPEZ);
		boutonPierre.setToolTipText(PersoPrenom.PIERRE + " " + PersoNom.SERMAIN);
		boutonYannick.setToolTipText(PersoPrenom.YANNICK + " " + PersoNom.BERCOT);
		boutonThomas.setToolTipText(PersoPrenom.THOMAS + " " + PersoNom.DARMOUNI);
		boutonJohann.setToolTipText(PersoPrenom.JOHANN + " " + PersoNom.AVELINE);
		boutonAli.setToolTipText(PersoPrenom.ALI + " " + PersoNom.CHAUDHRY);
		boutonGuillaume.setToolTipText(PersoPrenom.GUILLAUME + " " + PersoNom.BURGUET);
		boutonJonathan.setToolTipText(PersoPrenom.JONATHAN + " " + PersoNom.RUSCITO);
		boutonGroupe.setToolTipText("Le groupe");
		
		PanelCentre panelCentre = MainFrame.getPanelCentre();
		CardLayout cardLayout = panelCentre.getCardLayout();
		PanelBas panelBas = MainFrame.getPanelBas();
		
		// Gestion lien entre boutons Persos et la fenetre centrales
		boutonNicolas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.NICOLAS.name());
				// TODO : essayer de ne pas rafraichir
				panelBas.refreshPanelBas(PersoPrenom.NICOLAS);
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonPierre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.PIERRE.name());
				panelBas.refreshPanelBas(PersoPrenom.PIERRE);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonYannick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.YANNICK.name());
				panelBas.refreshPanelBas(PersoPrenom.YANNICK);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonThomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.THOMAS.name());
				panelBas.refreshPanelBas(PersoPrenom.THOMAS);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonJohann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.JOHANN.name());
				panelBas.refreshPanelBas(PersoPrenom.JOHANN);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonAli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.ALI.name());
				panelBas.refreshPanelBas(PersoPrenom.ALI);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonGuillaume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.GUILLAUME.name());
				panelBas.refreshPanelBas(PersoPrenom.GUILLAUME);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonJonathan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.JONATHAN.name());
				panelBas.refreshPanelBas(PersoPrenom.JONATHAN);			
				MenuManager.lanceRefreshMenu();
			}
		});
		boutonGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCentre, PersoPrenom.GROUPE.name());
				panelBas.refreshPanelBas(PersoPrenom.GROUPE);			
				MenuManager.lanceRefreshMenu();
		}
		});
		
//		JPanel panelVide = new JPanel();
//		panelVide.setBackground(Color.RED);
//		Dimension d = new Dimension(0, 5);
//		panelVide.setSize(d);
		
		this.add(boutonGroupe);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonNicolas);
		//		this.add(panelVide);
		this.add(boutonPierre);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonYannick);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonThomas);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonJohann);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonAli);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonGuillaume);
		//		this.add(Box.createRigidArea(new Dimension(0, 5)));
		this.add(boutonJonathan);
	}
}
