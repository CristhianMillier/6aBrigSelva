package Negocio;

import Datos.ConexionDaoImp;
import Datos.Documento;
import Datos.DocumentoDao;
import Datos.DocumentoDaoImp;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class DocumentoBo {

    public static boolean grabarDocumento(Object object, Object valor) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            obj.grabar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean grabarPerRecib(Object idPerRec, Object idDoc, Object valor) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            obj.grabarPerRecib(idPerRec, idDoc);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean grabarDocRecib(byte[] pdf, Object idDoc, Object valor) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            obj.grabarDocRecib(pdf, idDoc);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean eliminarDocumento(Object object, Object valor) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            obj.eliminar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean modificarDocRecib(byte[] pdf, Object idDoc, Object valor) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            obj.modificarDocRecib(pdf, idDoc);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean modificarDocumento(Object object, Object valor) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            obj.modificar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static ArrayList obtenerListaDocGeneral(Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaDocGeneral();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }

    public static ArrayList obtenerListaDocRecibe(Object valor, Object fechaRecibe) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
//            ltsDocumento = obj.obtenerListaDocRecibe(valor, fechaRecibe);
            ltsDocumento = obj.obtenerListaDocRecibe(valor);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }

    public static ArrayList obtenerListaFechaRecpOficina(Object seccion, Object fechaRecibe, Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaFechaRecpOficina(seccion, fechaRecibe);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }
    
    public static ArrayList obtenerListaFechaRecp(Object fechaRecibe, Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaFechaRecp(fechaRecibe);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }
    
    public static ArrayList obtenerListaOficina(Object seccion, Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaOficina(seccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }
    
    public static int ultimoIdDoc(Object valor) throws Exception {
        int id = 0;
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            id = obj.ultimoIdDoc();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return id;
    }
    
    public static ArrayList obtenerListaRangFechaRecp(Object fechaInicio, Object fechaFin, Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaRangFechaRecp(fechaInicio, fechaFin);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }
    
    public static ArrayList obtenerListaRangFechaRecpOficina(Object idSeccion, Object fechaInicio, Object fechaFin, Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaRangFechaRecpOficina(idSeccion, fechaInicio, fechaFin);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }
    
    public static ArrayList obtenerListaOficinaRecibe(Object seccion, Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaOficinaRecibe(seccion);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }
    
    public static ArrayList obtenerListaFechaRecpRecibe(Object fechaRecibe, Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaFechaRecpRecibe(fechaRecibe);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }
    
    public static ArrayList obtenerListaFechaRecpOficinaRecibe(Object seccion, Object fechaRecibe, Object valor) throws Exception {
        ArrayList<Documento> ltsDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            ltsDocumento = obj.obtenerListaFechaRecpOficinaRecibe(seccion, fechaRecibe);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return ltsDocumento;
    }
}
