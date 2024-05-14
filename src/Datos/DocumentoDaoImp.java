package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class DocumentoDaoImp implements DocumentoDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Documento objD;

    public DocumentoDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objD = (Documento) object;
        try {
            String sql = "insert into Documento (nroDoc, fechaDoc, asunto, destinatario, fechaRecibe, "
                    + "archivoNro, observación, categoria, idOficina, idtipoDoc, intPersonalGuarda) values "
                    + "(?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objD.getNroDoc());
            pst.setString(2, objD.getFechaDoc());
            pst.setString(3, objD.getAsunto());
            pst.setString(4, objD.getDestinatario());
            pst.setString(5, objD.getFechaRecibe());
            pst.setString(6, objD.getArchivoNro());
            pst.setString(7, objD.getObservaciones());
            pst.setString(8, objD.getCategoria());
            pst.setInt(9, objD.getIdSeccion().getIdOficina());
            pst.setInt(10, objD.getIdTipDoc().getIdTipDoc());
            pst.setInt(11, objD.getIdPerGuarda().getIdPersonal());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean grabarPerRecib(Object idPerRec, Object idDoc) throws SQLException {
        try {
            String sql = "UPDATE Documento set intPersonalRecibe=? "
                    + "where  idDocumento = " + (Integer) idDoc;
            pst = con.prepareStatement(sql);
            pst.setInt(1, (int) idPerRec);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean grabarDocRecib(byte[] pdf, Object idDoc) throws SQLException {
        try {
            String sql = "UPDATE Documento set documentoPDF=? "
                    + "where  idDocumento = " + (Integer) idDoc;
            pst = con.prepareStatement(sql);
            pst.setBytes(1, pdf);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarDocRecib(byte[] pdf, Object idDoc) throws SQLException {
        try {
            String sql = "UPDATE Documento set documentoPDF=? "
                    + "where  idDocumento = " + (Integer) idDoc;
            pst = con.prepareStatement(sql);
            pst.setBytes(1, pdf);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objD = (Documento) object;
        try {
            String sql = "UPDATE Documento SET nroDoc=?, fechaDoc=?, asunto=?, destinatario=?, "
                    + "archivoNro=?, observación=?, categoria=?, idOficina=?, idtipoDoc=?, intPersonalGuarda=? where idDocumento = " + objD.getIdDocumento();
            pst = con.prepareStatement(sql);
            pst.setString(1, objD.getNroDoc());
            pst.setString(2, objD.getFechaDoc());
            pst.setString(3, objD.getAsunto());
            pst.setString(4, objD.getDestinatario());
            pst.setString(5, objD.getArchivoNro());
            pst.setString(6, objD.getObservaciones());
            pst.setString(7, objD.getCategoria());
            pst.setInt(8, objD.getIdSeccion().getIdOficina());
            pst.setInt(9, objD.getIdTipDoc().getIdTipDoc());
            pst.setInt(10, objD.getIdPerGuarda().getIdPersonal());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Documento buscarIdDocumento(Object id) throws SQLException {
        try {
            String sql = "select * from Documento where idDocumento = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objD;
    }

    @Override
    public ArrayList obtenerListaDocGeneral() throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where intPersonalRecibe is null order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }

    @Override
    public ArrayList obtenerListaDocRecibe(Object seccion) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT D.nroDoc, D.idOficina, D.idtipoDoc, D.categoria, D.destinatario, D.archivoNro, D.asunto, D.intPersonalRecibe, D.idDocumento, D.documentoPDF "
                    + "FROM Documento  D inner join Oficina O on D.idOficina = O.idOficina where O.nombre = '"
                    + (String) seccion + "' and D.intPersonalRecibe is null";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setNroDoc(rs.getString(1));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(2)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(3)));
                objD.setCategoria(rs.getString(4));
                objD.setDestinatario(rs.getString(5));
                objD.setArchivoNro(rs.getString(6));
                objD.setAsunto(rs.getString(7));
                if (rs.getInt(8) != 0) {
                    PersonalDao objP = new PersonalDaoImp(con);
                    objD.setIdPerRecibe(objP.buscarIdPersonal(rs.getInt(8)));
                } else {
                    objD.setIdPerRecibe(new Personal(0));
                }
                objD.setIdDocumento(rs.getInt(9));
                objD.setArchivopdf(rs.getBytes(10));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }

    @Override
    public ArrayList obtenerListaFechaRecpOficina(Object idSeccion, Object fechaRecibe) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where fechaRecibe ='" + (String) fechaRecibe
                    + "' and idOficina = " + (Integer) idSeccion + " order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setArchivopdf(rs.getBytes(4));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                objD.setIdPerRecibe(objPer.buscarIdPersonal(rs.getInt(14)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }
    
    @Override
    public ArrayList obtenerListaFechaRecp(Object fechaRecibe) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where fechaRecibe ='" + (String) fechaRecibe
                    + "' order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setArchivopdf(rs.getBytes(4));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                objD.setIdPerRecibe(objPer.buscarIdPersonal(rs.getInt(14)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }
    
    @Override
    public ArrayList obtenerListaOficina(Object idSeccion) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where idOficina = " + (Integer) idSeccion + " order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setArchivopdf(rs.getBytes(4));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                objD.setIdPerRecibe(objPer.buscarIdPersonal(rs.getInt(14)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }

    @Override
    public int ultimoIdDoc() throws SQLException {
        int id = 0;
        try {
            String sql = "select max(idDocumento) from Documento";
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
    public ArrayList obtenerListaRangFechaRecp(Object fechaInicio, Object fechaFin) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where fechaRecibe >='" + (String) fechaInicio + "' and fechaRecibe <='" + (String) fechaFin
                    + "' order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setArchivopdf(rs.getBytes(4));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                objD.setIdPerRecibe(objPer.buscarIdPersonal(rs.getInt(14)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }

    @Override
    public ArrayList obtenerListaRangFechaRecpOficina(Object idSeccion, Object fechaInicio, Object fechaFin) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where fechaRecibe >='" + (String) fechaInicio + "' and fechaRecibe <='" + (String) fechaFin
                    + "' and idOficina = " + (Integer) idSeccion + " order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setArchivopdf(rs.getBytes(4));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                objD.setIdPerRecibe(objPer.buscarIdPersonal(rs.getInt(14)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }

    @Override
    public ArrayList obtenerListaOficinaRecibe(Object seccion) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where idOficina = " + (Integer) seccion + " and intPersonalRecibe is null order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setArchivopdf(rs.getBytes(4));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                objD.setIdPerRecibe(objPer.buscarIdPersonal(rs.getInt(14)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }

    @Override
    public ArrayList obtenerListaFechaRecpRecibe(Object fechaRecibe) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where fechaRecibe ='" + (String) fechaRecibe
                    + "' and intPersonalRecibe is null order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setArchivopdf(rs.getBytes(4));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                objD.setIdPerRecibe(objPer.buscarIdPersonal(rs.getInt(14)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }

    @Override
    public ArrayList obtenerListaFechaRecpOficinaRecibe(Object seccion, Object fechaRecibe) throws SQLException {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        try {
            String sql = "SELECT * FROM Documento where fechaRecibe ='" + (String) fechaRecibe
                    + "' and idOficina = " + (Integer) seccion + " and intPersonalRecibe is null order by idDocumento DESC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objD = new Documento();
                objD.setIdDocumento(rs.getInt(1));
                objD.setNroDoc(rs.getString(2));
                objD.setFechaDoc(rs.getString(3));
                objD.setArchivopdf(rs.getBytes(4));
                objD.setAsunto(rs.getString(5));
                objD.setDestinatario(rs.getString(6));
                objD.setFechaRecibe(rs.getString(7));
                objD.setArchivoNro(rs.getString(8));
                objD.setObservaciones(rs.getString(9));
                objD.setCategoria(rs.getString(10));
                OficinaDao objOf = new OficinaDaoImp(con);
                objD.setIdSeccion(objOf.buscarIdOficina(rs.getInt(11)));
                TipoDocumentoDao objTP = new TipoDocumentoDaoImp(con);
                objD.setIdTipDoc(objTP.buscarIdTipoDocumento(rs.getInt(12)));
                PersonalDao objPer = new PersonalDaoImp(con);
                objD.setIdPerGuarda(objPer.buscarIdPersonal(rs.getInt(13)));
                objD.setIdPerRecibe(objPer.buscarIdPersonal(rs.getInt(14)));
                ltsDocumento.add(objD);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDocumento;
    }
}
