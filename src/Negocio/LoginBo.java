package Negocio;

import Datos.ConexionDaoImp;
import Datos.Login;
import Datos.LoginDao;
import Datos.LoginDaoImp;
import java.sql.Connection;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class LoginBo {
    public static boolean grabarLogin(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
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
    public static boolean eliminarLogin(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
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
    public static boolean modificarLogin(Object object, Object valor)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
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
    public static int buscarLogin(Object user, Object password, Object valor)throws Exception{
        Connection con = null;
        int idP = 0;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
            idP = obj.Logeo(user, password);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return idP;
    }
    public static Login buscarPersonal(Object id, Object valor)throws Exception{
        Connection con = null;
        Login objL = null;
        try {
            con = ConexionDaoImp.getConexion(valor);
            con.setAutoCommit(false);
            LoginDao obj = new LoginDaoImp(con);
            objL = obj.buscarPersonal(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objL;
    }
}
