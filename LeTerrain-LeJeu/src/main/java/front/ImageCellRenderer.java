package front;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageCellRenderer extends DefaultTableCellRenderer  {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		setText("");
		setIcon(FenetrePrincipal.getImageIcon((String)value));
		
		return this;
	}

}
