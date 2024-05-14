package Modelo;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class imgTabla extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JLabel) {
            JLabel lbl = (JLabel) value;
            return lbl;
        }

        if (value instanceof JButton) {
            JButton button = (JButton) value;
            button.setBackground(new java.awt.Color(104, 56, 32));
            button.setFont(new java.awt.Font("Tahoma", 0, 13));
            button.setForeground(new java.awt.Color(255, 255, 255));
            
            return button;
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
