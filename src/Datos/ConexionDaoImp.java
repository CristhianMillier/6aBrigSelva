package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class ConexionDaoImp {
    public static Connection getConexion(Object valor) throws Exception {
        Connection Con = null;
        ConexionDao conectar = new ConexionDao(valor);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      
        Con = DriverManager.getConnection("jdbc:sqlserver://" + conectar.getHost() + ";" 
                + "databaseName=" + conectar.getDb_name() + ";" + "user=" + conectar.getUser() + ";" 
                        + "password=" + conectar.getPassword() + ";");
        return Con;
    }
}
