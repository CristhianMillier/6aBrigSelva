package Vista;

import Datos.Documento;
import Modelo.Modelo_Tabla_Documento;
import Negocio.DocumentoBo;
import java.awt.Desktop;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Cristhian Millier Flores Pasapera
 * @gamail 7050423891@untrm.edu.pe
 * @telefono 934576998
 */
public class frmDocRecibido extends javax.swing.JInternalFrame {

    private String cargo = "default";
    private Modelo_Tabla_Documento MTD = new Modelo_Tabla_Documento();
    private Documento objD = null;
    private String ruta_archivo = null;
    private byte[] doc = null;

    private int id;

    /**
     * Creates new form frmDocRecibido
     */
    public frmDocRecibido() {
        initComponents();
        this.botonos();
        this.definir_tamaño_columna();
        
        this.jPanel3.setVisible(false);
        this.tablaDocumento.setRowHeight(25);
        this.jPanel3.setToolTipText(null);
        this.jPanel2.setToolTipText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocumento = new javax.swing.JTable();
        btnActualizarTabla = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNroDoc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAsunto = new javax.swing.JTextArea();
        btnEstado = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btnSubirArchivo = new javax.swing.JButton();
        btnVerDoc = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTipDoc = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Documento Recibido");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documentos en Espera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setToolTipText("");

        tablaDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaDocumento.setModel(this.MTD);
        tablaDocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaDocumento.getTableHeader().setResizingAllowed(false);
        tablaDocumento.getTableHeader().setReorderingAllowed(false);
        tablaDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDocumentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDocumento);

        btnActualizarTabla.setBackground(new java.awt.Color(0, 153, 0));
        btnActualizarTabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btnActualizarTabla.setText("Actualizar Tabla");
        btnActualizarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarTabla)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizarTabla)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Recibido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setToolTipText("");
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nro Doc :");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 70, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Asunto:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        txtNroDoc.setEditable(false);
        txtNroDoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(txtNroDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 200, -1));

        txtAsunto.setEditable(false);
        txtAsunto.setColumns(20);
        txtAsunto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAsunto.setLineWrap(true);
        txtAsunto.setRows(5);
        txtAsunto.setWrapStyleWord(true);
        txtAsunto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(txtAsunto);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 270, 62));

        btnEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEstado.setForeground(new java.awt.Color(255, 255, 255));
        btnEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/no-seleccion.png"))); // NOI18N
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });
        jPanel3.add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Recibido Conforme");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        btnSubirArchivo.setBackground(new java.awt.Color(51, 153, 0));
        btnSubirArchivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSubirArchivo.setText("Cargar Documento...");
        btnSubirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirArchivoActionPerformed(evt);
            }
        });
        jPanel3.add(btnSubirArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 201, 41));

        btnVerDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver-documento.png"))); // NOI18N
        btnVerDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDocActionPerformed(evt);
            }
        });
        jPanel3.add(btnVerDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 50, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible.png"))); // NOI18N
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 49, -1));

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/letraX.png"))); // NOI18N
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel3.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 45, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo Doc :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 70, -1));

        txtTipDoc.setEditable(false);
        txtTipDoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(txtTipDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 200, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        this.cargarFormulario();
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTablaActionPerformed
        this.limpiar();
        this.jPanel3.setVisible(false);
        this.tablaDocumento.setEnabled(true);
        this.cargarTabla();
    }//GEN-LAST:event_btnActualizarTablaActionPerformed

    private void btnSubirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirArchivoActionPerformed
        this.seleccionar_pdf();
    }//GEN-LAST:event_btnSubirArchivoActionPerformed

    private void btnVerDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDocActionPerformed
        this.AbrirDocumento();
    }//GEN-LAST:event_btnVerDocActionPerformed

    private void tablaDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDocumentoMouseClicked
        if (evt.getClickCount() == 1) {
            int fila = this.tablaDocumento.getSelectedRow();
            this.objD = MTD.getDocumento(fila);
            this.cargarDatos(objD);
            this.tablaDocumento.setEnabled(false);
            this.jPanel3.setVisible(true);
            this.cargarTabla();
        }
    }//GEN-LAST:event_tablaDocumentoMouseClicked

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.limpiar();
        this.jPanel3.setVisible(false);
        this.tablaDocumento.setEnabled(true);
        this.cargarTabla();
    }//GEN-LAST:event_salirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarTabla;
    private javax.swing.JCheckBox btnEstado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JButton btnVerDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton salir;
    private javax.swing.JTable tablaDocumento;
    private javax.swing.JTextArea txtAsunto;
    private javax.swing.JTextField txtNroDoc;
    private javax.swing.JTextField txtTipDoc;
    // End of variables declaration//GEN-END:variables

    public void setCargo(String cargo, int id) {
        this.cargo = cargo;
        this.id = id;
    }

    private void botonos() {
        this.btnVerDoc.setOpaque(false);
        this.btnVerDoc.setContentAreaFilled(false);
        this.btnVerDoc.setBorderPainted(false);
        this.btnVerDoc.setToolTipText("Ver Documento");

        this.btnGuardar.setOpaque(false);
        this.btnGuardar.setContentAreaFilled(false);
        this.btnGuardar.setBorderPainted(false);
        this.btnGuardar.setToolTipText("Guardar Doc.");

        this.salir.setOpaque(false);
        this.salir.setContentAreaFilled(false);
        this.salir.setBorderPainted(false);
        this.salir.setToolTipText("Salir");
    }

    private void cargarTabla() {
        try {
            Calendar cal = Calendar.getInstance();
            Timestamp fecha_hora = new Timestamp(cal.getTimeInMillis());
            String fechaSistema = String.valueOf(fecha_hora);

            ArrayList<Documento> ltsDocumento = DocumentoBo.obtenerListaDocRecibe(cargo, fechaSistema.substring(0, 10));
            MTD.setListado_Documento(ltsDocumento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void definir_tamaño_columna() {
        TableColumnModel columnModel = this.tablaDocumento.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(450);
        columnModel.getColumn(3).setPreferredWidth(150);

        this.tablaDocumento.getTableHeader().setFont(new Font("Tahoma", 1, 12));
        ((DefaultTableCellRenderer) this.tablaDocumento.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void seleccionar_pdf() {
        JFileChooser j = new JFileChooser();
        j.setDialogTitle("Seleccione un Documento");
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.btnSubirArchivo.setText("Documento Cargado");
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
        }
    }

    private void AbrirDocumento() {
        if (this.doc != null) {
            InputStream bos = new ByteArrayInputStream(this.doc);
            this.verDoc(bos);
        } else {
            if (this.ruta_archivo != null) {
                try {
                    File ruta = new File(ruta_archivo);
                    InputStream bos = new FileInputStream(ruta);
                    this.verDoc(bos);
                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usted aún no a seleccionado un archivo PDF.", "MENSAJE --> DOCUMENTO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void verDoc(InputStream bos) {
        try {
            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);
            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);
            //abrir archivo
            out.close();
            bos.close();
            Desktop.getDesktop().open(new File("new.pdf"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al Intentar Abrir el Archivo", "MENSAJE --> DOCUMENTO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarFormulario() {
        int confirm = JOptionPane.showConfirmDialog(this, "¿ Está seguro que el documento con asunto: \n '"
                + this.txtAsunto.getText() + "' \n es el que está Recibiendo ?", "CONFIRMAR DOCUMENTO", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            ImageIcon icono = new ImageIcon("src/Imagenes/seleccion.png");
            this.btnEstado.setIcon(icono);
            this.btnEstado.setSelected(true);
            this.btnEstado.setEnabled(false);
            try {
                if (DocumentoBo.grabarPerRecib(this.id, this.objD.getIdDocumento(), cargo)) {
                    JOptionPane.showMessageDialog(this, "Recepción aceptada con exito.", "MENSAJE --> DOCUMENTO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.", "MENSAJE --> DOCUMENTO", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void cargarDatos(Documento objD) {
        this.txtNroDoc.setText(objD.getNroDoc());
        this.txtAsunto.setText(objD.getAsunto());
        this.txtTipDoc.setText(objD.getIdTipDoc().getNombre());
        if (objD.getIdPerRecibe().getIdPersonal() != 0) {
            this.btnEstado.setEnabled(false);
            this.btnEstado.setSelected(true);
            ImageIcon icono = new ImageIcon("src/Imagenes/seleccion.png");
            this.btnEstado.setIcon(icono);
        }
        if (objD.getArchivopdf() != null) {
            this.btnSubirArchivo.setText("Documento Cargado");
            this.doc = objD.getArchivopdf();
        }
    }

    private void limpiar() {
        this.txtNroDoc.setText("");
        this.txtAsunto.setText("");
        this.txtTipDoc.setText("");

        this.btnEstado.setSelected(false);
        ImageIcon icono = new ImageIcon("src/Imagenes/no-seleccion.png");
        this.btnEstado.setIcon(icono);

        this.objD = null;
        this.ruta_archivo = null;
        this.doc = null;
    }

    private void guardar() {
        if (this.doc != null) {
            //Ya existe Doc. en BBDD
            if (this.ruta_archivo != null) {
                byte[] pdf = this.obtenerRuta();
                try {
                    if (DocumentoBo.modificarDocRecib(pdf, this.objD.getIdDocumento(), cargo)) {
                        JOptionPane.showMessageDialog(this, "Documento modificado exitosamente.", "MENSAJE --> DOCUMENTO", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.", "MENSAJE --> DOCUMENTO", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            if (this.ruta_archivo != null) {
                byte[] pdf = this.obtenerRuta();
                try {
                    if (DocumentoBo.grabarDocRecib(pdf, this.objD.getIdDocumento(), cargo)) {
                        JOptionPane.showMessageDialog(this, "Documento guardado exitosamente.", "MENSAJE --> DOCUMENTO", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.", "MENSAJE --> DOCUMENTO", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usted aún no a seleccionado un archivo PDF.", "MENSAJE --> DOCUMENTO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private byte[] obtenerRuta() {
        File ruta = new File(ruta_archivo);
        byte[] pdf;
        try {
            pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
        } catch (IOException ex) {
            pdf = null;
        }
        return pdf;
    }
}
