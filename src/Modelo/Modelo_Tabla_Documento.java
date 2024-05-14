package Modelo;

import Datos.Documento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Modelo_Tabla_Documento extends AbstractTableModel {

    private List<Documento> listado_Documento;

    public void setListado_Documento(List<Documento> listado_Documento) {
        this.listado_Documento = listado_Documento;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Documento != null) {
            cantFilas = this.listado_Documento.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Documento objG;
        Object celda = "";
        if (this.listado_Documento != null) {
            objG = this.listado_Documento.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objG.getNroDoc().trim();
                    break;
                case 1:
                    celda = objG.getIdSeccion().getNombre();
                    break;
                case 2:
                    celda = objG.getAsunto();
                    break;
                case 3:
                    celda = objG.getDestinatario();
                    break;
            }
        }
        return celda;
    }

    @Override
    public String getColumnName(int column) {
        String nombreolumn = "";
        switch (column) {
            case 0:
                nombreolumn = "NRO. DOC";
                break;
            case 1:
                nombreolumn = "SECCIÓN";
                break;
            case 2:
                nombreolumn = "ASUNTO";
                break;
            case 3:
                nombreolumn = "DESTINATARIO";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Documento getDocumento(int fila) {
        Documento objD = null;
        if (this.listado_Documento != null) {
            objD = this.listado_Documento.get(fila);
        }
        return objD;
    }
}
