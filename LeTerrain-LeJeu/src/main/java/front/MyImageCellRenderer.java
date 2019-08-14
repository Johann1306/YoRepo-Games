package front;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import core.ImageManager;
import core.configuration.Constante;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.arme.Arme;
import modele.item.arme.ArmeClasse;

public class MyImageCellRenderer extends DefaultTableCellRenderer  {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if (value instanceof Item) {
			Item item = (Item) value;
			String type = item.getType().name();
			
			setText("");
			ImageIcon resizeImage = ImageManager.resizeImage(FenetrePrincipal.getImageIcon(item.getImagePath().get(0)), Constante.PERSO_IMAGE_DIMENSION_50_50);
			setIcon(resizeImage);
			// TODO Couleur en fonction du type pour les armures aussi
			
			// Couleur en fonction du type d'arme
			if (type.equals(ItemType.ARME.name())) {
				Arme arme = (Arme) item;
				String armeClasse = arme.getArmeClasse().name();
				if (armeClasse.equals(ArmeClasse.GRIS.name())) {
					this.setBorder(BorderFactory.createLineBorder(Color.GRAY));				
				} else if (armeClasse.equals(ArmeClasse.VERT.name())) {
					this.setBorder(BorderFactory.createLineBorder(Color.GREEN));				
				} else if (armeClasse.equals(ArmeClasse.BLEU.name())) {
					this.setBorder(BorderFactory.createLineBorder(Color.BLUE));				
				} else if (armeClasse.equals(ArmeClasse.VIOLET.name())) {
					this.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));				
				} 
				
			// Couleur en fonction du type de popo
			} else if (type.equals(ItemType.POTION_MANA_25.name()) 
					|| type.equals(ItemType.POTION_VIE_25.name())) {
				
				this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				
			} else if (type.equals(ItemType.POTION_MANA_50.name()) 
					|| type.equals(ItemType.POTION_VIE_50.name())
					|| type.equals(ItemType.BONUS_STAT_AGILITE_5.name()) 
					|| type.equals(ItemType.BONUS_STAT_CHANCE_5.name())
					|| type.equals(ItemType.BONUS_STAT_ENDURANCE_5.name())
					|| type.equals(ItemType.BONUS_STAT_INTELLIGENCE_5.name())
					|| type.equals(ItemType.BONUS_STAT_NERVOSITE_5.name())
					|| type.equals(ItemType.BONUS_STAT_RAPIDITE_5.name())
					|| type.equals(ItemType.BONUS_STAT_RESISTANCE_5.name())
					|| type.equals(ItemType.BONUS_STAT_TECHNIQUE_5.name())
					|| type.equals(ItemType.BONUS_STAT_EXPLOIT_5.name())) {
				
				this.setBorder(BorderFactory.createLineBorder(Color.GREEN));
				
			} else if (type.equals(ItemType.POTION_MANA_75.name()) 
					|| type.equals(ItemType.POTION_VIE_75.name())
					|| type.equals(ItemType.BONUS_STAT_AGILITE_10.name()) 
					|| type.equals(ItemType.BONUS_STAT_CHANCE_10.name())
					|| type.equals(ItemType.BONUS_STAT_ENDURANCE_10.name())
					|| type.equals(ItemType.BONUS_STAT_INTELLIGENCE_10.name())
					|| type.equals(ItemType.BONUS_STAT_NERVOSITE_10.name())
					|| type.equals(ItemType.BONUS_STAT_RAPIDITE_10.name())
					|| type.equals(ItemType.BONUS_STAT_RESISTANCE_10.name())
					|| type.equals(ItemType.BONUS_STAT_TECHNIQUE_10.name())
					|| type.equals(ItemType.BONUS_STAT_EXPLOIT_10.name())) {
				
				this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			
			} else if (type.equals(ItemType.POTION_MANA_100.name()) 
					|| type.equals(ItemType.POTION_VIE_100.name())
					|| type.equals(ItemType.BONUS_STAT_AGILITE_20.name()) 
					|| type.equals(ItemType.BONUS_STAT_CHANCE_20.name())
					|| type.equals(ItemType.BONUS_STAT_ENDURANCE_20.name())
					|| type.equals(ItemType.BONUS_STAT_INTELLIGENCE_20.name())
					|| type.equals(ItemType.BONUS_STAT_NERVOSITE_20.name())
					|| type.equals(ItemType.BONUS_STAT_RAPIDITE_20.name())
					|| type.equals(ItemType.BONUS_STAT_RESISTANCE_20.name())
					|| type.equals(ItemType.BONUS_STAT_TECHNIQUE_20.name())
					|| type.equals(ItemType.BONUS_STAT_EXPLOIT_20.name())) {
				
				this.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
			}
		}
		
		return this;
	}

}
