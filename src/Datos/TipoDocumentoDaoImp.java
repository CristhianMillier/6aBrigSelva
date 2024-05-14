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
public class TipoDocumentoDaoImp implements TipoDocumentoDao{
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private TipoDocumento objTP;
    
    public TipoDocumentoDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objTP = (TipoDocumento) object;
        try {
            String sql = "insert into TipoDocumento values (?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objTP.getNombre());
            pst.setString(2, objTP.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objTP = (TipoDocumento) object;
        try {
            String sql = "UPDATE TipoDocumento SET estado=? where idTipDoc = " + objTP.getIdTipDoc();
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
        objTP = (TipoDocumento) object;
        try {
            String sql = "UPDATE TipoDocumento SET nombre=?, estado=? where idTipDoc = " + objTP.getIdTipDoc();
            pst = con.prepareStatement(sql);
            pst.setString(1, objTP.getNombre());
            pst.setString(2, objTP.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
    
        @Override
    public ArrayList obtenerListaTipDoc() throws SQLException {
        ArrayList<TipoDocumento> ltsTipoDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM TipoDocumento order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTP = new TipoDocumento();
                objTP.setIdTipDoc(rs.getInt(1));
                objTP.setNombre(rs.getString(2));
                objTP.setEstado(rs.getString(3));
                ltsTipoDocumento.add(objTP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsTipoDocumento;
    }

    @Override
    public void obtenerListaComboTipDoc(JComboBox<TipoDocumento> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM TipoDocumento where estado = 'Activo' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTP = new TipoDocumento();
                objTP.setIdTipDoc(rs.getInt(1));
                objTP.setNombre(rs.getString(2));
                jComboBox.addItem(objTP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public TipoDocumento buscarIdTipoDocumento(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM TipoDocumento where idTipDoc = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTP = new TipoDocumento();
                objTP.setIdTipDoc(rs.getInt(1));
                objTP.setNombre(rs.getString(2));
                objTP.setEstado(rs.getString(3));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objTP;
    }

    @Override
    public ArrayList buscarNombreTipoDocumento(Object nombre) throws SQLException {
        ArrayList<TipoDocumento> ltsTipoDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM TipoDocumento where nombre LIKE '" + (String)nombre + "%' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objTP = new TipoDocumento();
                objTP.setIdTipDoc(rs.getInt(1));
                objTP.setNombre(rs.getString(2));
                objTP.setEstado(rs.getString(3));
                ltsTipoDocumento.add(objTP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsTipoDocumento;
    }

    @Override
    public boolean buscarNomb(Object nombre) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM TipoDocumento where nombre LIKE '" + (String)nombre + "%' order by nombre";
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
