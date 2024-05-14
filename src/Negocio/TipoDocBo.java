package Negocio;

import Datos.ConexionDaoImp;
import Datos.TipoDocumento;
import Datos.TipoDocumentoDao;
import Datos.TipoDocumentoDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class TipoDocBo {
    public static boolean grabarTipDoc(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            TipoDocumentoDao obj = new TipoDocumentoDaoImp(con);
            obj.grabar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    public static boolean modificarTipDoc(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            TipoDocumentoDao obj = new TipoDocumentoDaoImp(con);
            obj.modificar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    public static boolean eliminarTipDoc(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            TipoDocumentoDao obj = new TipoDocumentoDaoImp(con);
            obj.eliminar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    public static ArrayList obtenerListaTipDoc(Object valor) throws Exception{
        ArrayList<TipoDocumento> ltsTipoDoc = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            TipoDocumentoDao obj = new TipoDocumentoDaoImp(con);
            ltsTipoDoc = obj.obtenerListaTipDoc();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsTipoDoc;
    }
    public static void obtenerListaComboTipDoc(JComboBox<TipoDocumento> jComboBox, Object valor) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            TipoDocumentoDao obj = new TipoDocumentoDaoImp(con);
            obj.obtenerListaComboTipDoc(jComboBox);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    public static ArrayList buscarNombreTipoDocumento(Object nombre, Object valor) throws Exception{
        ArrayList<TipoDocumento> ltsTipoDocumento = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            TipoDocumentoDao obj = new TipoDocumentoDaoImp(con);
            ltsTipoDocumento = obj.buscarNombreTipoDocumento(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsTipoDocumento;
    }
    public static boolean buscarNomb(Object nombre, Object valor) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            TipoDocumentoDao obj = new TipoDocumentoDaoImp(con);
            obj.buscarNomb(nombre);
            con.commit();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
}
