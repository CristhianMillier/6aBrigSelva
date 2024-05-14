package Datos;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Oficina {
    private int idOficina;
    private String nombre;
    private String estado;

    public Oficina() {
    }

    public Oficina(int idOficina, String nombre, String estado) {
        this.idOficina = idOficina;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
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
