package front;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import core.ImageManager;
import core.configuration.Constante;

public class MyImageCellRenderer extends DefaultTableCellRenderer  {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		setText("");
		ImageIcon resizeImage = ImageManager.resizeImage(FenetrePrincipal.getImageIcon((String) value), Constante.PERSO_IMAGE_DIMENSION_50_50);
		setIcon(resizeImage);
		
		return this;
	}

}
