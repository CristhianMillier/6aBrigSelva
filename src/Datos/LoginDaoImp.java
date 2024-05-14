package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class LoginDaoImp implements LoginDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Login objL;

    public LoginDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objL = (Login) object;
        try {
            String sql = "insert into Login values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objL.getUser());
            pst.setString(2, objL.getPassword());
            pst.setInt(3, objL.getIdPersonal());
            pst.setString(4, objL.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objL = (Login) object;
        try {
            String sql = "UPDATE Login SET estado=? where idPersonal = " + objL.getIdPersonal();
            pst = con.prepareStatement(sql);
            pst.setString(1, "Inactivo");
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objL = (Login) object;
        try {
            String sql = "UPDATE Login SET usuario=?, password=?, estado=? where idPersonal = " + objL.getIdPersonal();
            pst = con.prepareStatement(sql);
            pst.setString(1, objL.getUser());
            pst.setString(2, objL.getPassword());
            pst.setString(3, objL.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Login buscarIdLogin(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Login where idLogin = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objL = new Login();
                objL.setIdLogin(rs.getInt(1));
                objL.setUser(rs.getString(2));
                objL.setPassword(rs.getString(3));
                objL.setIdPersonal(rs.getInt(4));
                objL.setEstado(rs.getString(5));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objL;
    }

    @Override
    public int Logeo(Object user, Object password) throws SQLException {
        int idP = 0;
        try {
            String sql = "SELECT idPersonal FROM Login "
                    + "where usuario = '" + (String) user + "' and password = '" + (String) password + "' and estado = 'Activo'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idP = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return idP;
    }
    
    @Override
    public Login buscarPersonal(Object id) throws SQLException {
        try {
            String sql = "SELECT usuario, password FROM Login where idPersonal = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objL = new Login();
                objL.setUser(rs.getString(1));
                objL.setPassword(rs.getString(2));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objL;
    }
}
