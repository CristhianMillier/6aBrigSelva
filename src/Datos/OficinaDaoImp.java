package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class OficinaDaoImp implements OficinaDao{
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Oficina objO;
    
    public OficinaDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objO = (Oficina) object;
        try {
            String sql = "insert into Oficina values (?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objO.getNombre());
            pst.setString(2, objO.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objO = (Oficina) object;
        try {
            String sql = "UPDATE Oficina SET estado=? where idOficina = " + objO.getIdOficina();
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
        objO = (Oficina) object;
        try {
            String sql = "UPDATE Oficina SET nombre=?, estado=? where idOficina = " +objO.getIdOficina();
            pst = con.prepareStatement(sql);
            pst.setString(1, objO.getNombre());
            pst.setString(2, objO.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaOficina() throws SQLException {
        ArrayList<Oficina> ltsOficina = new ArrayList();
        try {
            String sql = "SELECT * FROM Oficina order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objO = new Oficina();
                objO.setIdOficina(rs.getInt(1));
                objO.setNombre(rs.getString(2));
                objO.setEstado(rs.getString(3));
                ltsOficina.add(objO);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsOficina;
    }

    @Override
    public void obtenerListaComboOficina(JComboBox<Oficina> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Oficina where estado = 'Activo' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objO = new Oficina();
                objO.setIdOficina(rs.getInt(1));
                objO.setNombre(rs.getString(2));
                jComboBox.addItem(objO);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Oficina buscarIdOficina(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Oficina where idOficina = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objO = new Oficina();
                objO.setIdOficina(rs.getInt(1));
                objO.setNombre(rs.getString(2));
                objO.setEstado(rs.getString(3));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objO;
    }

    @Override
    public ArrayList buscarNombreOficina(Object nombre) throws SQLException {
        ArrayList<Oficina> ltsOficina = new ArrayList();
        try {
            String sql = "SELECT * FROM Oficina where nombre LIKE '" + (String)nombre + "%' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objO = new Oficina();
                objO.setIdOficina(rs.getInt(1));
                objO.setNombre(rs.getString(2));
                objO.setEstado(rs.getString(3));
                ltsOficina.add(objO);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsOficina;
    }

    @Override
    public boolean buscarNomb(Object nombre) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Oficina where nombre LIKE '" + (String)nombre + "%' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                estado = false;
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return estado;
    }
}
