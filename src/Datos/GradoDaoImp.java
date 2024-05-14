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
public class GradoDaoImp implements GradoDao{
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Grado objG;
    
    public GradoDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objG = (Grado) object;
        try {
            String sql = "insert into Grado values (?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objG.getNombre());
            pst.setString(2, objG.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objG = (Grado) object;
        try {
            String sql = "UPDATE Grado SET estado=? where idGrado = " + objG.getIdGrado();
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
        objG = (Grado) object;
        try {
            String sql = "UPDATE Grado SET nombre=?, estado=? where idGrado = " +objG.getIdGrado();
            pst = con.prepareStatement(sql);
            pst.setString(1, objG.getNombre());
            pst.setString(2, objG.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    @Override
    public ArrayList obtenerListaGrado() throws SQLException {
        ArrayList<Grado> ltsGrado = new ArrayList();
        try {
            String sql = "SELECT * FROM Grado order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objG = new Grado();
                objG.setIdGrado(rs.getInt(1));
                objG.setNombre(rs.getString(2));
                objG.setEstado(rs.getString(3));
                ltsGrado.add(objG);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsGrado;
    }

    @Override
    public void obtenerListaComboGrado(JComboBox<Grado> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Grado where estado = 'Activo' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objG = new Grado();
                objG.setIdGrado(rs.getInt(1));
                objG.setNombre(rs.getString(2));
                jComboBox.addItem(objG);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Grado buscarIdGrado(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Grado where idGrado = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objG = new Grado();
                objG.setIdGrado(rs.getInt(1));
                objG.setNombre(rs.getString(2));
                objG.setEstado(rs.getString(3));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objG;
    }

    @Override
    public ArrayList buscarNombreGrado(Object nombre) throws SQLException {
        ArrayList<Grado> ltsGrado = new ArrayList();
        try {
            String sql = "SELECT * FROM Grado where nombre LIKE '" + (String)nombre + "%' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objG = new Grado();
                objG.setIdGrado(rs.getInt(1));
                objG.setNombre(rs.getString(2));
                objG.setEstado(rs.getString(3));
                ltsGrado.add(objG);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsGrado;
    }

    @Override
    public boolean buscarNomb(Object nombre) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Grado where nombre LIKE '" + (String)nombre + "%' order by nombre";
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
