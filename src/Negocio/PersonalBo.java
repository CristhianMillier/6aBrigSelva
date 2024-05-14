package Negocio;

import Datos.ConexionDaoImp;
import Datos.Personal;
import Datos.PersonalDao;
import Datos.PersonalDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class PersonalBo {
    public static boolean grabarPersonal(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
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
    public static boolean modificarPersonal(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
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
    public static boolean eliminarPersonal(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
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
    public static ArrayList obtenerListaPersonal(Object valor)throws Exception{
        Connection con = null;
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            ltsPersonal = obj.obtenerListaPersonal();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsPersonal;
    }
    public static void obtenerListaCombPersonal(JComboBox<Personal> jComboBox, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            obj.obtenerListaCombPersonal(jComboBox);
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
    public static Personal buscarIdPersonal(Object id, Object valor)throws Exception{
        Connection con = null;
        Personal objP = new Personal();
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            objP = obj.buscarIdPersonal(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objP;
    }
    public static ArrayList buscarDNIPersonal(Object dni, Object valor)throws Exception{
        Connection con = null;
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            ltsPersonal = obj.buscarDNIPersonal(dni);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsPersonal;
    }
    public static ArrayList buscarApellidoPersonal(Object apellido, Object valor)throws Exception{
        Connection con = null;
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            ltsPersonal = obj.buscarApellidoPersonal(apellido);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsPersonal;
    }
    public static ArrayList buscarNombrePersonal(Object nombre, Object valor)throws Exception{
        Connection con = null;
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            ltsPersonal = obj.buscarNombrePersonal(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsPersonal;
    }
    public static int obtenerUltimoId(Object valor)throws Exception{
        Connection con = null;
        int id = 0;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            id = obj.obtenerUltimoId();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return id;
    }
    public static boolean buscarDNI(Object DNI, Object valor)throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            estado = obj.buscarDNI(DNI);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return estado;
    }
    public static boolean buscarUser(Object user, Object valor)throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            PersonalDao obj = new PersonalDaoImp(con);
            estado = obj.buscarUser(user);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return estado;
    }
}
