package Datos;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class TipoDocumento {
    private int idTipDoc;
    private String nombre;
    private String estado;

    public TipoDocumento() {
    }

    public TipoDocumento(int idTipDoc, String nombre, String estado) {
        this.idTipDoc = idTipDoc;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdTipDoc() {
        return idTipDoc;
    }

    public void setIdTipDoc(int idTipDoc) {
        this.idTipDoc = idTipDoc;
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
