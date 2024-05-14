package Modelo;

import Datos.Oficina;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Modelo_Tabla_Oficina extends AbstractTableModel{
    private List<Oficina> listado_Oficina;

    public void setListado_Oficina(List<Oficina> listado_Oficina) {
        this.listado_Oficina = listado_Oficina;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        int cantFilas = 0; 
        if (this.listado_Oficina != null) {
            cantFilas = this.listado_Oficina.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Oficina objO;
        Object celda = "";
        if (this.listado_Oficina != null) {
            objO = this.listado_Oficina.get(rowIndex);
            switch(columnIndex){
                case 0: celda = objO.getNombre(); break;
                case 1: celda = objO.getEstado(); break;
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
    
    public Oficina getOficina(int fila){
        Oficina objO = null;
        if (this.listado_Oficina != null) {
            objO = this.listado_Oficina.get(fila);
        }
        return objO;
    }
}
