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
public interface GradoDao extends General{
    public ArrayList obtenerListaGrado() throws SQLException;
    public boolean buscarNomb(Object nombre) throws SQLException;
    public void obtenerListaComboGrado(JComboBox<Grado> jComboBox) throws SQLException;
    public Grado buscarIdGrado(Object id) throws SQLException;
    public ArrayList buscarNombreGrado(Object nombre) throws SQLException;
}
