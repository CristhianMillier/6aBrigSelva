package Reporte;

import Datos.ConexionDaoImp;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class RepFechRanSecc {
    private final String encabezado = "/Imagenes/encabezadoReport.png";
    
    public void verReporte(Object valor, String fecInic, String fecFin, String seccion) throws Exception {
        JasperReport repor;
        JasperPrint re;
        JasperViewer view;
        try {
            String path = "src\\Reporte\\RepFechRanSecc.jasper";
            repor = (JasperReport) JRLoader.loadObjectFromFile(path);

            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("encabezado", this.getClass().getResourceAsStream(encabezado));
            parametros.put("seccion", seccion);
            parametros.put("inicioFecha", fecInic);
            parametros.put("finFecha", fecFin);
            parametros.put("titulo", "Reporte OPB - " + seccion);
            
            re = JasperFillManager.fillReport(repor, parametros, ConexionDaoImp.getConexion("default"));
            view = new JasperViewer(re, false);
            view.setTitle("Reporte de la sección " + seccion + " del " + fecInic + " al " + fecFin);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/sexta.png")));
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException  e) {
            System.out.println(e.getMessage());
        }
    }
}
