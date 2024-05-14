package Modelo;

import Datos.Grado;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Modelo_Tabla_Grado extends AbstractTableModel{
    private List<Grado> listado_Grado;

    public void setListado_Grado(List<Grado> listado_Grado) {
        this.listado_Grado = listado_Grado;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0; 
        if (this.listado_Grado != null) {
            cantFilas = this.listado_Grado.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grado objG;
        Object celda = "";
        if (this.listado_Grado != null) {
            objG = this.listado_Grado.get(rowIndex);
            switch(columnIndex){
                case 0: celda = objG.getNombre(); break;
                case 1: celda = objG.getEstado(); break;
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
    
    public Grado getGrado(int fila){
        Grado objG = null;
        if (this.listado_Grado != null) {
            objG = this.listado_Grado.get(fila);
        }
        return objG;
    }
}
