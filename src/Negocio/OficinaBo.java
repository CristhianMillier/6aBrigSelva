package Negocio;

import Datos.ConexionDaoImp;
import Datos.Oficina;
import Datos.OficinaDao;
import Datos.OficinaDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class OficinaBo {
    public static boolean grabarOficina(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            OficinaDao obj = new OficinaDaoImp(con);
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
    public static boolean eliminarOficina(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            OficinaDao obj = new OficinaDaoImp(con);
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
    public static boolean modificarOficina(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            OficinaDao obj = new OficinaDaoImp(con);
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
    public static ArrayList obtenerListaOficina(Object valor) throws Exception{
        ArrayList<Oficina> ltsOficina = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            OficinaDao obj = new OficinaDaoImp(con);
            ltsOficina = obj.obtenerListaOficina();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsOficina;
    }
    public static void obtenerListaComboOficina(JComboBox<Oficina> jComboBox, Object valor) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            OficinaDao obj = new OficinaDaoImp(con);
            obj.obtenerListaComboOficina(jComboBox);
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
    public static ArrayList buscarNombreOficina(Object nombre, Object valor) throws Exception{
        ArrayList<Oficina> ltsOficina = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            OficinaDao obj = new OficinaDaoImp(con);
            ltsOficina = obj.buscarNombreOficina(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsOficina;
    }
    public static boolean buscarNomb(Object nombre, Object valor) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            OficinaDao obj = new OficinaDaoImp(con);
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
