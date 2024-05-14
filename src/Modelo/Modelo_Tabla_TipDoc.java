package Modelo;

import Datos.TipoDocumento;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Modelo_Tabla_TipDoc extends AbstractTableModel{
    private List<TipoDocumento> listado_TipDoc;

    public void setListado_TipDoc(List<TipoDocumento> listado_TipDoc) {
        this.listado_TipDoc = listado_TipDoc;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0; 
        if (this.listado_TipDoc != null) {
            cantFilas = this.listado_TipDoc.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoDocumento objTP;
        Object celda = "";
        if (this.listado_TipDoc != null) {
            objTP = this.listado_TipDoc.get(rowIndex);
            switch(columnIndex){
                case 0: celda = objTP.getNombre(); break;
                case 1: celda = objTP.getEstado(); break;
            }
        }
        return celda;
    }
    
    @Override
    public String getColumnName(int column) {
        String nombreolumn = "";
        switch(column){
            case 0: nombreolumn = "NOMBRE"; break;
            case 1: nombreolumn = "ESTADO"; break;
        }
        return nombreolumn;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public TipoDocumento getTipDoc(int fila){
        TipoDocumento objTP = null;
        if (this.listado_TipDoc != null) {
            objTP = this.listado_TipDoc.get(fila);
        }
        return objTP;
    }
}
