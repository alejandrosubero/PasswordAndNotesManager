package view;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CenterColumns extends DefaultTableCellRenderer {
	
	@Override 
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasfocus, int row,int column) {
		
		super.getTableCellRendererComponent(table, value, isSelected, hasfocus, row, column);
		setHorizontalAlignment(SwingConstants.CENTER);
		return this;
	}
	
}
