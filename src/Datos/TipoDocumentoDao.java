package Datos;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public interface TipoDocumentoDao extends General{
    public ArrayList obtenerListaTipDoc() throws SQLException;
    public boolean buscarNomb(Object nombre) throws SQLException;
    public void obtenerListaComboTipDoc(JComboBox<TipoDocumento> jComboBox) throws SQLException;
    public TipoDocumento buscarIdTipoDocumento(Object id) throws SQLException;
    public ArrayList buscarNombreTipoDocumento(Object nombre) throws SQLException;
}
