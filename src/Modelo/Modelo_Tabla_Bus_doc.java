package Modelo;

import Datos.Documento;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Modelo_Tabla_Bus_doc extends AbstractTableModel {

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
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Documento objG;
        Object celda = null;
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
                case 4:
                    if (objG.getArchivopdf() != null) {
                        celda = agregarBoton(1);
                    } else {
                        celda = agregarBoton(2);
                    }
                    break;
                case 5:
                    if (objG.getIdPerRecibe() != null) {
                        celda = objG.getIdPerRecibe().getApellido();
                    } else{
                        celda = "No";
                    }
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
            case 4:
                nombreolumn = "DOCUMENTO";
                break;
            case 5:
                nombreolumn = "RECIBIDO";
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

    private Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

    private JButton agregarBoton(int valor) {
        JButton boton;
        ImageIcon icono = null;
        if (get_Image("/Imagenes/pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imagenes/pdf.png"));
        }

        if (valor == 1) {
            boton = new JButton(icono);
            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        } else {
            boton = new JButton("VACÍO");
        }

        return boton;
    }
}
