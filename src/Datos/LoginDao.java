package Datos;

import java.sql.SQLException;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public interface LoginDao extends General{
    public Login buscarIdLogin(Object id) throws SQLException;
    public int Logeo(Object user, Object password) throws SQLException;
    public Login buscarPersonal(Object id) throws SQLException;
}
