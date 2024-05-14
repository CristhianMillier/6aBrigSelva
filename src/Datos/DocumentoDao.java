package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public interface DocumentoDao extends General {
    public boolean grabarPerRecib(Object idPerRec, Object idDoc) throws SQLException;
    public boolean grabarDocRecib(byte[] pdf, Object idDoc) throws SQLException;
    public boolean modificarDocRecib(byte[] pdf, Object idDoc) throws SQLException;
    public Documento buscarIdDocumento(Object id) throws SQLException;
    public int ultimoIdDoc() throws SQLException;
    public ArrayList obtenerListaDocGeneral() throws SQLException;
//    public ArrayList obtenerListaDocRecibe(Object seccion, Object fechaRecibe) throws SQLException;
    public ArrayList obtenerListaDocRecibe(Object seccion) throws SQLException;
    public ArrayList obtenerListaFechaRecpOficina(Object seccion, Object fechaRecibe) throws SQLException;
    public ArrayList obtenerListaFechaRecp(Object fechaRecibe) throws SQLException;
    public ArrayList obtenerListaOficina(Object seccion) throws SQLException;
    public ArrayList obtenerListaRangFechaRecp(Object fechainicio, Object fechaFin) throws SQLException;
    public ArrayList obtenerListaRangFechaRecpOficina(Object seccion, Object fechaInicio, Object fechaFin) throws SQLException;
    
    public ArrayList obtenerListaOficinaRecibe(Object seccion) throws SQLException;
    public ArrayList obtenerListaFechaRecpRecibe(Object fechaRecibe) throws SQLException;
    public ArrayList obtenerListaFechaRecpOficinaRecibe(Object seccion, Object fechaRecibe) throws SQLException;
}
