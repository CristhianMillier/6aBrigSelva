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
public class PersonalDaoImp implements PersonalDao{
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Personal objP;
    
    public PersonalDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objP = (Personal) object;
        try {
            String sql = "insert into Personal values (?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objP.getNombre());
            pst.setString(2, objP.getApellido());
            pst.setString(3, objP.getNacimiento());
            pst.setString(4, objP.getDni());
            pst.setString(5, objP.getTelefono());
            pst.setInt(6, objP.getIdSeccion().getIdOficina());
            pst.setInt(7, objP.getIdGrado().getIdGrado());
            pst.setString(8, objP.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objP = (Personal) object;
        try {
            String sql = "UPDATE Personal SET estado=? where idPersonal = " + objP.getIdPersonal();
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
        objP = (Personal) object;
        try {
            String sql = "UPDATE Personal SET nombre=?, apellido=?, nacimiento=?, DNI=?, "
                    + "telefono=?, idOficina=?, idGrado=?, estado=? where idPersonal = " + objP.getIdPersonal();
            pst = con.prepareStatement(sql);
            pst.setString(1, objP.getNombre());
            pst.setString(2, objP.getApellido());
            pst.setString(3, objP.getNacimiento());
            pst.setString(4, objP.getDni());
            pst.setString(5, objP.getTelefono());
            pst.setInt(6, objP.getIdSeccion().getIdOficina());
            pst.setInt(7, objP.getIdGrado().getIdGrado());
            pst.setString(8, objP.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    @Override
    public ArrayList obtenerListaPersonal() throws SQLException {
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            String sql = "SELECT * FROM Personal order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setIdPersonal(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNacimiento(rs.getString(4));
                objP.setDni(rs.getString(5));
                objP.setTelefono(rs.getString(6));
                OficinaDao objOf = new OficinaDaoImp(con);
                objP.setIdSeccion(objOf.buscarIdOficina(rs.getInt(7)));
                GradoDao objGra = new GradoDaoImp(con);
                objP.setIdGrado(objGra.buscarIdGrado(rs.getInt(8)));
                objP.setEstado(rs.getString(9));
                ltsPersonal.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPersonal;
    }

    @Override
    public void obtenerListaCombPersonal(JComboBox<Personal> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Personal where estado = 'Activo' order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setApellido(rs.getString(3));
                jComboBox.addItem(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Personal buscarIdPersonal(Object id) throws SQLException {
        objP = null;
        try {
            String sql = "SELECT * FROM Personal where idPersonal = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setIdPersonal(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNacimiento(rs.getString(4));
                objP.setDni(rs.getString(5));
                objP.setTelefono(rs.getString(6));
                OficinaDao objOf = new OficinaDaoImp(con);
                objP.setIdSeccion(objOf.buscarIdOficina(rs.getInt(7)));
                GradoDao objGra = new GradoDaoImp(con);
                objP.setIdGrado(objGra.buscarIdGrado(rs.getInt(8)));
                objP.setEstado(rs.getString(9));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objP;
    }

    @Override
    public ArrayList buscarDNIPersonal(Object dni) throws SQLException {
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            String sql = "SELECT * FROM Personal where DNI LIKE '" + (String)dni + "%' order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setIdPersonal(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNacimiento(rs.getString(4));
                objP.setDni(rs.getString(5));
                objP.setTelefono(rs.getString(6));
                OficinaDao objOf = new OficinaDaoImp(con);
                objP.setIdSeccion(objOf.buscarIdOficina(rs.getInt(7)));
                GradoDao objGra = new GradoDaoImp(con);
                objP.setIdGrado(objGra.buscarIdGrado(rs.getInt(8)));
                objP.setEstado(rs.getString(9));
                ltsPersonal.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPersonal;
    }

    @Override
    public ArrayList buscarApellidoPersonal(Object apellido) throws SQLException {
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            String sql = "SELECT * FROM Personal where apellido LIKE '" + (String)apellido + "%' order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setIdPersonal(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNacimiento(rs.getString(4));
                objP.setDni(rs.getString(5));
                objP.setTelefono(rs.getString(6));
                OficinaDao objOf = new OficinaDaoImp(con);
                objP.setIdSeccion(objOf.buscarIdOficina(rs.getInt(7)));
                GradoDao objGra = new GradoDaoImp(con);
                objP.setIdGrado(objGra.buscarIdGrado(rs.getInt(8)));
                objP.setEstado(rs.getString(9));
                ltsPersonal.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPersonal;
    }

    @Override
    public ArrayList buscarNombrePersonal(Object nombre) throws SQLException {
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            String sql = "SELECT * FROM Personal where nombre LIKE '" + (String)nombre + "%' order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setIdPersonal(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNacimiento(rs.getString(4));
                objP.setDni(rs.getString(5));
                objP.setTelefono(rs.getString(6));
                OficinaDao objOf = new OficinaDaoImp(con);
                objP.setIdSeccion(objOf.buscarIdOficina(rs.getInt(7)));
                GradoDao objGra = new GradoDaoImp(con);
                objP.setIdGrado(objGra.buscarIdGrado(rs.getInt(8)));
                objP.setEstado(rs.getString(9));
                ltsPersonal.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPersonal;
    }

    @Override
    public int obtenerUltimoId() throws SQLException {
        int id = 0;
        try {
            String sql = "select max(idPersonal) from Personal";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return id;
    }

    @Override
    public boolean buscarDNI(Object DNI) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Personal where DNI = '" + String.valueOf(DNI) + "'";
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

    @Override
    public boolean buscarUser(Object user) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Personal P inner join Login L on P.idPersonal = L.idPersonal where L.usuario = '" + String.valueOf(user) + "'";
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
