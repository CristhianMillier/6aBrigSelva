package Datos;

import java.io.FileInputStream;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class ConexionDao {

    private String host = "";
    private String db_name = "";
    private String user = "";
    private String password = "";
    private String key = "";
    private String vector = "";

    private final static String seccion = "AES";
    private final static String cifrar = "AES/CBC/PKCS5Padding";
    private Properties props = new Properties();

    public ConexionDao(Object valor) {
        this.cargarDatos(valor);
    }

    private void cargarDatos(Object valor) {
        String dato = (String) valor;
        try {
            props.load(new FileInputStream("appconfig.properties"));
            key = props.getProperty("servidor.key");
            vector = props.getProperty("servidor.vector");
            host = props.getProperty("servidor");
            host += decrypt(key, vector, props.getProperty("servidor.enlace"));
            db_name = decrypt(key, vector, props.getProperty("servidor.BBDD"));
            password = decrypt(key, vector, props.getProperty("servidor.password"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (dato) {
            case "SETEL":
                this.general();
                break;
            case "Login":
                this.leerLog();
                break;
            case "OPB":
                this.opb();
                break;
            case "default":
                this.leer();
                break;
            default:
                this.oficinas();
                break;
        }
    }

    private void general() {
        try {
            user = decrypt(key, vector, props.getProperty("servidor.general"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void leer() {
        try {
            user = decrypt(key, vector, props.getProperty("servidor.leer"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void leerLog() {
        try {
            user = decrypt(key, vector, props.getProperty("servidor.login"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void opb() {
        try {
            user = decrypt(key, vector, props.getProperty("servidor.seccopb"));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
    }

    private void oficinas() {
        try {
            user = decrypt(key, vector, props.getProperty("servidor.secciones"));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
    }

    private static String decrypt(String llave, String vector, String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(cifrar);
        SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getBytes(), seccion);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(vector.getBytes());
        byte[] enc = Base64.getDecoder().decode(encrypted);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decrypted = cipher.doFinal(enc);
        return new String(decrypted);
    }

    public String getHost() {
        return host;
    }

    public String getDb_name() {
        return db_name;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
