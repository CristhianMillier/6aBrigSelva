package Datos;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Login {
    private int idLogin;
    private String user;
    private String password;
    private int idPersonal;
    private String estado;

    public Login() {
    }

    public Login(int idLogin, String user, String password, int idPersonal, String estado) {
        this.idLogin = idLogin;
        this.user = user;
        this.password = password;
        this.idPersonal = idPersonal;
        this.estado = estado;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUser() {
        return user.trim();
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getEstado() {
        return estado.trim();
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
