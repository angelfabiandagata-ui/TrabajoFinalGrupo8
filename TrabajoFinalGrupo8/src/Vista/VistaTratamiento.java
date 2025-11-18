/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Tratamiento;
import Persistencia.TratamientoData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.List;
//cambios
/**
 *
 * @author angel
 */
public class VistaTratamiento extends javax.swing.JInternalFrame {

    private TratamientoData tratamientoData = new TratamientoData();
    private DefaultTableModel modeloTabla;
    menu menu;
    
    public VistaTratamiento(menu pmenu) {
        initComponents();
        configurarTabla();
        actulizarTabla();
        javax.swing.JDesktopPane desktopPane = this.getDesktopPane();
        cargarProductosComboBox();
         this.menu = pmenu;
        
         if (desktopPane != null) {
        int x = (desktopPane.getWidth() - this.getWidth()) / 2;
        int y = (desktopPane.getHeight() - this.getHeight()) / 2;
        
        this.setLocation(x, y);
       
    }
    }
    
    
     private Tratamiento obtenerTratamiento(){
 
    int codTratamiento = 0;
    double costo = 0;
    Time duracion = null;
    
    
    Number duracionNumber = (Number) spinnerDuracion.getValue();


    try {
        if (txtCodTrat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El Codigo es obligatorio", "Faltan Datos", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
 
        codTratamiento = Integer.parseInt(txtCodTrat.getText().trim());


        if (!txtCostoTrat.getText().trim().isEmpty()) {
            costo = Double.parseDouble(txtCostoTrat.getText().trim());
        }

        if (duracionNumber == null || duracionNumber.intValue() <= 0) {
            JOptionPane.showMessageDialog(this, "La Duracion es obligatoria y debe ser mayor a cero", "Faltan Datos", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        int minutos = duracionNumber.intValue();
        
        int horas = minutos / 60;
        int minutosRestantes = minutos % 60;
        
        Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        
        cal.set(Calendar.HOUR_OF_DAY, horas);
        cal.set(Calendar.MINUTE, minutosRestantes);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        duracion = new Time(cal.getTimeInMillis());
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El codigo y el costo deben ser números validos", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    
    String productoSeleccionado = (String) boxProductos.getSelectedItem();
    List<String> productosParaTratamiento= new ArrayList<>();
    if (productoSeleccionado != null) {
        productosParaTratamiento.add(productoSeleccionado);
    }
    
    Tratamiento nuevoTratamiento = new Tratamiento();

    nuevoTratamiento.setCodTratamiento(codTratamiento);
    nuevoTratamiento.setNombre(txtNombreTrat.getText().trim());
    nuevoTratamiento.setDetalle(txtDetalleTrat.getText().trim());
    nuevoTratamiento.setProductos(productosParaTratamiento);
    nuevoTratamiento.setDuracion(duracion); 
    nuevoTratamiento.setCosto(costo);
    boolean estadoActivo = chkEstado.isSelected();
    nuevoTratamiento.setEstado(estadoActivo);

    return nuevoTratamiento; 
}
    private void configurarTabla(){
        String[] Titulos = {"codigoTratamiento", "Nombre", "detalle", "producto","duracion","costo","estado"};
        modeloTabla = new DefaultTableModel(Titulos, 0);
        
        jTable1.setModel(modeloTabla);
    }
    
    
    private void Limpiar(){
        txtCodTrat.setText("");
        txtNombreTrat.setText("");
        txtDetalleTrat.setText("");
        txtCostoTrat.setText("");
        chkEstado.setSelected(false);
    }
    
    private void cargarProductosComboBox() {
    // 1. Limpiar el ComboBox por si acaso
    boxProductos.removeAllItems();
    
    // 2. Obtener la lista de productos
    // Si los productos son fijos (hardcodeados):
    List<String> productosDisponibles = new ArrayList<>();
    productosDisponibles.add("Aceite de Lavanda");
    productosDisponibles.add("Piedras Calientes");
    productosDisponibles.add("Exfoliante de Sal");
    productosDisponibles.add("Crema Hidratante");
    
    // 3. Llenar el ComboBox
    for (String producto : productosDisponibles) {
        boxProductos.addItem(producto);
    }
    
    // Opcional: Seleccionar el primer elemento
    if (!productosDisponibles.isEmpty()) {
        boxProductos.setSelectedIndex(0);
    }
}      
    
    
    private void actulizarTabla(){
       
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel(); 
    modelo.setRowCount(0); 
    List<Tratamiento> tratamientos = tratamientoData.listarTratamientos();
    System.out.println("Tratamientos cargados de DB: " + tratamientos.size());
  
    for (Tratamiento t : tratamientos) {

        modelo.addRow(new Object[]{
            t.getCodTratamiento(),
            t.getNombre(),
            t.getDetalle(),
            t.getProductos(),
            t.getDuracion(), 
            t.getCosto(),
            t.getEstado()
        });
    }
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelTrat1 = new javax.swing.JLabel();
        labelTrat2 = new javax.swing.JLabel();
        labelTrat3 = new javax.swing.JLabel();
        labelTrat5 = new javax.swing.JLabel();
        chkEstado = new javax.swing.JCheckBox();
        labelTrat7 = new javax.swing.JLabel();
        txtCodTrat = new javax.swing.JTextField();
        txtNombreTrat = new javax.swing.JTextField();
        txtDetalleTrat = new javax.swing.JTextField();
        txtCostoTrat = new javax.swing.JTextField();
        ButtonAltaTrat = new javax.swing.JRadioButton();
        buttomBajaTrat = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        labelTrat10 = new javax.swing.JLabel();
        spinnerDuracion = new com.toedter.components.JSpinField();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        boxProductos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labelTrat4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelTrat1.setText("Cod. Tratamiento");

        labelTrat2.setText("Nombre:");

        labelTrat3.setText("Detalle");

        labelTrat5.setText("Costo");

        chkEstado.setMaximumSize(new java.awt.Dimension(30, 30));
        chkEstado.setMinimumSize(new java.awt.Dimension(30, 30));
        chkEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstadoActionPerformed(evt);
            }
        });

        labelTrat7.setText("Estado");

        txtCodTrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodTratActionPerformed(evt);
            }
        });

        ButtonAltaTrat.setText("Alta Logica");

        buttomBajaTrat.setText("Baja Logica");
        buttomBajaTrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomBajaTratActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        labelTrat10.setText("Producto");

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 153, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Detalle", "Producto", "Duracion", "Costo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        boxProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Vista Tratamiento");

        labelTrat4.setText("Duracion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelTrat3)
                                .addComponent(labelTrat2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTrat5)
                                    .addComponent(labelTrat7))))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTrat10)
                            .addComponent(labelTrat1)
                            .addComponent(labelTrat4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodTrat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreTrat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCostoTrat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(boxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ButtonAltaTrat))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtDetalleTrat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(buttomBajaTrat)))
                                    .addComponent(spinnerDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelTrat1)
                                    .addComponent(txtCodTrat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelTrat2)
                                    .addComponent(txtNombreTrat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTrat3)
                            .addComponent(txtDetalleTrat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttomBajaTrat))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(ButtonAltaTrat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTrat10))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTrat4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCostoTrat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTrat5))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelTrat7))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(288, 288, 288))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(58, 58, 58))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Tratamiento nuevoTratamiento = obtenerTratamiento();

        if (nuevoTratamiento == null) {
            return;
        }
        
        int codigoIngresado = nuevoTratamiento.getCodTratamiento();
        
        try {
            
    if (tratamientoData.existeTratamiento(codigoIngresado)) {
        
       
        JOptionPane.showMessageDialog(this, 
            "️ El codigo de tratamiento " + codigoIngresado + " ya existe. No se puede guardar", 
            "Código Duplicado", 
            JOptionPane.WARNING_MESSAGE);
        
    } else {
        
        
        tratamientoData.agregarTratamiento(nuevoTratamiento);

        JOptionPane.showMessageDialog(this, 
            "Tratamiento: " + nuevoTratamiento.getNombre() + " guardado correctamente", 
            "Guardado Exitoso", 
            JOptionPane.INFORMATION_MESSAGE);

        Limpiar();
        actulizarTabla();
    }

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, 
        " Error al intentar guardar el tratamiento: " + e.getMessage(), 
        "Error al Guardar", 
        JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int filaSElec = jTable1.getSelectedRow();

        if (filaSElec == -1) {
            JOptionPane.showMessageDialog(this, "Se tiene q elegir un tratamiento de la tabla para eliminarlo", "Requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Object valorCLiCod = modeloTabla.getValueAt(filaSElec, 0);

        if (valorCLiCod == null) {
            JOptionPane.showMessageDialog(this, "No tiene codigo de tratamiento valido esta fila", "Eror de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {

            int codTrat = (int) valorCLiCod;

            int confrimacion = JOptionPane.showConfirmDialog(this,
                "Seguro de eliminar el Tratamiento?", "Confirmar elimanar", JOptionPane.YES_NO_OPTION);

            if (confrimacion == JOptionPane.YES_OPTION) {

                tratamientoData.borrarTratamiento(codTrat);
                JOptionPane.showMessageDialog(this,"Tratamiento dado de baja","Dada de baja existosa", JOptionPane.INFORMATION_MESSAGE);

                Limpiar();
                actulizarTabla();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de baja Detalle:" + e.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttomBajaTratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomBajaTratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttomBajaTratActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCodTratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodTratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodTratActionPerformed

    private void chkEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEstadoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        this.setEnabled(false);
        this.setVisible(false);
        menu.activarTodosLosBotones();
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ButtonAltaTrat;
    private javax.swing.JComboBox<String> boxProductos;
    private javax.swing.JRadioButton buttomBajaTrat;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelTrat1;
    private javax.swing.JLabel labelTrat10;
    private javax.swing.JLabel labelTrat2;
    private javax.swing.JLabel labelTrat3;
    private javax.swing.JLabel labelTrat4;
    private javax.swing.JLabel labelTrat5;
    private javax.swing.JLabel labelTrat7;
    private com.toedter.components.JSpinField spinnerDuracion;
    private javax.swing.JTextField txtCodTrat;
    private javax.swing.JTextField txtCostoTrat;
    private javax.swing.JTextField txtDetalleTrat;
    private javax.swing.JTextField txtNombreTrat;
    // End of variables declaration//GEN-END:variables
}
