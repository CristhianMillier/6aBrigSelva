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
public interface OficinaDao extends General{
    public ArrayList obtenerListaOficina() throws SQLException;
    public boolean buscarNomb(Object nombre) throws SQLException;
    public void obtenerListaComboOficina(JComboBox<Oficina> jComboBox) throws SQLException;
    public Oficina buscarIdOficina(Object id) throws SQLException;
    public ArrayList buscarNombreOficina(Object nombre) throws SQLException;
}
