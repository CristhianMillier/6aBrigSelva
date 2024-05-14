package Modelo;

import Datos.Personal;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Modelo_Tabla_Personal extends AbstractTableModel{
    private List<Personal> listado_Personal;

    public void setListado_Personal(List<Personal> listado_Personal) {
        this.listado_Personal = listado_Personal;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0; 
        if (this.listado_Personal != null) {
            cantFilas = this.listado_Personal.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Personal objP;
        Object celda = "";
        if (this.listado_Personal != null) {
            objP = this.listado_Personal.get(rowIndex);
            switch(columnIndex){
                case 0: celda = objP.getApellido(); break;
                case 1: celda = objP.getNombre(); break;
                case 2: celda = objP.getDni(); break;
                case 3: celda = objP.getIdSeccion().getNombre(); break;
                case 4: celda = objP.getIdGrado().getNombre(); break;
                case 5: celda = objP.getEstado(); break;
            }
        }
        return celda;
    }
    
    @Override
    public String getColumnName(int column) {
        String nombreolumn = "";
        switch(column){
            case 0: nombreolumn = "APELLIDO"; break;
            case 1: nombreolumn = "NOMBRE"; break;
            case 2: nombreolumn = "DNI"; break;
            case 3: nombreolumn = "SECCIÓN"; break;
            case 4: nombreolumn = "GRADO"; break;
            case 5: nombreolumn = "ESTADO"; break;
        }
        return nombreolumn;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Personal getPersonal(int fila){
        Personal objP = null;
        if (this.listado_Personal != null) {
            objP = this.listado_Personal.get(fila);
        }
        return objP;
    }
}
