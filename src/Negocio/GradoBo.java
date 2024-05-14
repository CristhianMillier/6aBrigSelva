package Negocio;

import Datos.Grado;
import Datos.GradoDao;
import Datos.GradoDaoImp;
import Datos.ConexionDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class GradoBo {
    public static boolean grabarGrado(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            GradoDao obj = new GradoDaoImp(con);
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
    public static boolean eliminarGrado(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            GradoDao obj = new GradoDaoImp(con);
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
    public static boolean modificarGrado(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            GradoDao obj = new GradoDaoImp(con);
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
    public static ArrayList obtenerListaGrado(Object valor) throws Exception{
        ArrayList<Grado> ltsGrado = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            GradoDao obj = new GradoDaoImp(con);
            ltsGrado = obj.obtenerListaGrado();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsGrado;
    }
    public static void obtenerListaComboGrado(JComboBox<Grado> jComboBox, Object valor) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            GradoDao obj = new GradoDaoImp(con);
            obj.obtenerListaComboGrado(jComboBox);
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
    public static ArrayList buscarNombreGrado(Object nombre, Object valor) throws Exception{
        ArrayList<Grado> ltsGrado = new ArrayList();
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            GradoDao obj = new GradoDaoImp(con);
            ltsGrado = obj.buscarNombreGrado(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsGrado;
    }
    public static boolean buscarNomb(Object nombre, Object valor) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            GradoDao obj = new GradoDaoImp(con);
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
