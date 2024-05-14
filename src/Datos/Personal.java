package Datos;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Personal {

    private int idPersonal;
    private String nombre;
    private String apellido;
    private String nacimiento;
    private String dni;
    private String telefono;
    private Oficina idSeccion;
    private Grado idGrado;
    private String estado;

    public Personal() {
    }

    public Personal(int idPersonal, String nombre, String apellido, String nacimiento, String dni, String telefono, Oficina idSeccion, Grado idGrado, String estado) {
        this.idPersonal = idPersonal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.dni = dni;
        this.telefono = telefono;
        this.idSeccion = idSeccion;
        this.idGrado = idGrado;
        this.estado = estado;
    }

    public Personal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre.trim();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido.trim();
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacimiento() {
        return nacimiento.trim();
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDni() {
        return dni.trim();
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono.trim();
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Oficina getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Oficina idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    public String getEstado() {
        return estado.trim();
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return apellido.trim() + " " + nombre.trim();
    }
}
