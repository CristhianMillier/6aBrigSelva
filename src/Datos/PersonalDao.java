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
public interface PersonalDao extends General{
    public ArrayList obtenerListaPersonal() throws SQLException;
    public int obtenerUltimoId() throws SQLException;
    public void obtenerListaCombPersonal(JComboBox<Personal> jComboBox) throws SQLException;
    public Personal buscarIdPersonal(Object id) throws SQLException;
    public ArrayList buscarDNIPersonal(Object dni) throws SQLException;
    public ArrayList buscarApellidoPersonal(Object apellido) throws SQLException;
    public ArrayList buscarNombrePersonal(Object nombre) throws SQLException;
    public boolean buscarDNI(Object DNI)throws SQLException;
    public boolean buscarUser(Object user)throws SQLException;
}
