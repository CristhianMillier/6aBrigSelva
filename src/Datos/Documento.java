package Datos;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class Documento {
    private int idDocumento;
    private String nroDoc;
    private String fechaDoc;
    private String asunto;
    private String destinatario;
    private String fechaRecibe;
    private String archivoNro;
    private String observaciones;
    private String categoria;
    private Oficina idSeccion;
    private TipoDocumento idTipDoc;
    private Personal idPerGuarda;
    private Personal idPerRecibe;
    private byte[] archivopdf;

    public Documento() {
    }

    public Documento(int idDocumento, String nroDoc, String fechaDoc, String asunto, String destinatario, String fechaRecibe, String archivoNro, String observaciones, String categoria, Oficina idSeccion, TipoDocumento idTipDoc, Personal idPerGuarda) {
        this.idDocumento = idDocumento;
        this.nroDoc = nroDoc;
        this.fechaDoc = fechaDoc;
        this.asunto = asunto;
        this.destinatario = destinatario;
        this.fechaRecibe = fechaRecibe;
        this.archivoNro = archivoNro;
        this.observaciones = observaciones;
        this.idSeccion = idSeccion;
        this.idTipDoc = idTipDoc;
        this.idPerGuarda = idPerGuarda;
        this.categoria = categoria;
    }

    public Documento(Personal idPerRecibe, byte[] archivopdf) {
        this.idPerRecibe = idPerRecibe;
        this.archivopdf = archivopdf;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNroDoc() {
        return nroDoc.trim();
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getFechaDoc() {
        return fechaDoc.trim();
    }

    public void setFechaDoc(String fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public String getAsunto() {
        return asunto.trim();
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario.trim();
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getFechaRecibe() {
        return fechaRecibe.trim();
    }

    public void setFechaRecibe(String fechaRecibe) {
        this.fechaRecibe = fechaRecibe;
    }

    public String getArchivoNro() {
        return archivoNro.trim();
    }

    public void setArchivoNro(String archivoNro) {
        this.archivoNro = archivoNro;
    }

    public String getObservaciones() {
        return observaciones.trim();
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Oficina getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Oficina idSeccion) {
        this.idSeccion = idSeccion;
    }

    public TipoDocumento getIdTipDoc() {
        return idTipDoc;
    }

    public void setIdTipDoc(TipoDocumento idTipDoc) {
        this.idTipDoc = idTipDoc;
    }

    public Personal getIdPerGuarda() {
        return idPerGuarda;
    }

    public void setIdPerGuarda(Personal idPerGuarda) {
        this.idPerGuarda = idPerGuarda;
    }

    public Personal getIdPerRecibe() {
        return idPerRecibe;
    }

    public void setIdPerRecibe(Personal idPerRecibe) {
        this.idPerRecibe = idPerRecibe;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

    public String getCategoria() {
        return categoria.trim();
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return asunto;
    }
    
}
