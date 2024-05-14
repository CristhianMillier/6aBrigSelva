package Datos;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Grado {
    private int idGrado;
    private String nombre;
    private String estado;

    public Grado() {
    }

    public Grado(int idGrado, String nombre, String estado) {
        this.idGrado = idGrado;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombre() {
        return nombre.trim();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado.trim();
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre.trim();
    } 
}
