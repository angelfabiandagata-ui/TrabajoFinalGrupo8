/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Consultorio;
import Modelo.DiaDeSpa;
import Modelo.Masajista;
import Modelo.Tratamiento;
import Persistencia.ConsultorioData;
import Persistencia.DiaDeSpaData;
import Persistencia.MasajistaData;
import Persistencia.TratamientoData;
import Vista.menu;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ema
 */
public class AgregarT extends javax.swing.JPanel {
    
    private TratamientoData tratamientoData = new TratamientoData();
    private MasajistaData masajistaData = new MasajistaData();
    private ConsultorioData consultorioData = new ConsultorioData();
    private DiaDeSpaData diaDeSpaData = new DiaDeSpaData();
    private DefaultTableModel modeloTablaDiaSpa;



private void cargarTratamientosComboBox() {
    
   
    jComboBoxTratamiento.removeAllItems();

 
    List<Tratamiento> tratamientos = tratamientoData.listarTratamientos();

   
    for (Tratamiento t : tratamientos) {
        jComboBoxTratamiento.addItem(t);
    }
}

private void cargarMasajistasComboBox() {
    jComboBoxMasajista.removeAllItems();

    List<Masajista> masajistas = masajistaData.listarMasajista();

    for (Masajista m : masajistas) {
        jComboBoxMasajista.addItem(m);
    }
}

private void cargarConsultoriosComboBox() {
    jComboBoxConsultorio.removeAllItems();

    List<Consultorio> consultorios = consultorioData.Listar();
System.out.println("Consultorios encontrados: " + consultorios.size());

    for (Consultorio c : consultorios) {
        jComboBoxConsultorio.addItem(c);
    }
}


     private void cargarHorarios() {
   
    DefaultComboBoxModel<String> modeloInicio = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> modeloFin = new DefaultComboBoxModel<>();

   
    for (int hora = 12; hora <= 18; hora++) {
        modeloInicio.addElement(String.format("%02d:00", hora));
    }

    
    for (int hora = 13; hora <= 19; hora++) {
        modeloFin.addElement(String.format("%02d:00", hora));
    }

    jComboBoxHoraInicio.setModel(modeloInicio);
    jComboBoxHoraFin.setModel(modeloFin);

 
    System.out.println("Horarios cargados correctamente ✅");
}
     
     private void configurarEventos() {
    jComboBoxTratamiento.addActionListener(e -> calcularTotal());
    jComboBoxHoraInicio.addActionListener(e -> calcularTotal());
    jComboBoxHoraFin.addActionListener(e -> calcularTotal());
}

     
     private void calcularTotal() {
    
    Tratamiento tratamiento = (Tratamiento) jComboBoxTratamiento.getSelectedItem();
    if (tratamiento == null) return;

    double costoBase = tratamiento.getCosto();

    // obtener las horas seleccionadas en los combos
    String horaInicioStr = (String) jComboBoxHoraInicio.getSelectedItem();
    String horaFinStr = (String) jComboBoxHoraFin.getSelectedItem();

    if (horaInicioStr == null || horaFinStr == null) return;

   //convertir los textos a enteros para comparar
    int horaInicio = Integer.parseInt(horaInicioStr.split(":")[0]);
    int horaFin = Integer.parseInt(horaFinStr.split(":")[0]);

 // calcular la diferencia en horas
    int duracion = horaFin - horaInicio;
    if (duracion <= 0) {
        jTextFieldTotal.setText("0.00");
        return;
    }

 //calcular total 
    double total = costoBase * duracion;

    
    jTextFieldTotal.setText(String.format("%.2f", total));
}

     private void configurarTablaDiaSpa() {
    modeloTablaDiaSpa = new DefaultTableModel(
            new Object[]{"Código Día de Spa", "Cliente"}, 0
    );
    jTableDiaDeSpa.setModel(modeloTablaDiaSpa);
}

private void buscarDiaDeSpa() {
    modeloTablaDiaSpa.setRowCount(0);
    String texto = jTextFieldBuscar.getText().trim();

    if (texto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese un código o un nombre para buscar.");
        return;
    }

    try {
        int cod = Integer.parseInt(texto);
        DiaDeSpa dia = diaDeSpaData.buscarPorCodigo(cod);
        if (dia != null) {
            modeloTablaDiaSpa.addRow(new Object[]{dia.getCodPack(), dia.getCliente()});
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un Día de Spa con ese código.");
        }
    } catch (NumberFormatException e) {
        List<DiaDeSpa> lista = diaDeSpaData.buscarPorCliente(texto);
        for (DiaDeSpa d : lista) {
            modeloTablaDiaSpa.addRow(new Object[]{d.getCodPack(), d.getCliente()});
        }
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron clientes con ese nombre.");
        }
    }
}

    menu men;
    
    /**
     * Creates new form NewJPanel
     */
    public AgregarT(menu men) {
        initComponents();
        configurarTablaDiaSpa();
         this.men = men;
        jComboBoxHoraInicio.removeAllItems();
        jComboBoxHoraFin.removeAllItems();
        cargarTratamientosComboBox();
        cargarMasajistasComboBox();
        cargarConsultoriosComboBox();
        cargarHorarios();
        configurarEventos();

estadoInicio();
    }
    
    
    private void estadoInicio(){
        deshabilitarConsu();
        deshabilitarInsta();
        
        botonTratamiento.setEnabled(true);
        botonInstalacion.setEnabled(true);
    }
    

    private void elegirConstultorio(){
        jComboBoxConsultorio.setEnabled(true);
        jComboBoxTratamiento.setEnabled(true);
        jComboBoxMasajista.setEnabled(true);
jComboBox3.setEnabled(false);

    }
    private void elegirInstalacion(){
            jComboBoxConsultorio.setEnabled(false);
        jComboBoxTratamiento.setEnabled(false);
        jComboBoxMasajista.setEnabled(false);
        

jComboBox3.setEnabled(true);
    }
    
    private void deshabilitarConsu(){
    jComboBoxConsultorio.setEnabled(false);
        jComboBoxTratamiento.setEnabled(false);
        jComboBoxMasajista.setEnabled(false);
        botonTratamiento.setEnabled(false);
    
    }
     private void deshabilitarInsta(){
        jComboBox3.setEnabled(false);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxConsultorio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxTratamiento = new javax.swing.JComboBox<>();
        Masajista = new javax.swing.JLabel();
        jComboBoxMasajista = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDiaDeSpa = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        Masajista1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBoxHoraInicio = jComboBoxHoraInicio = new javax.swing.JComboBox<>(new javax.swing.DefaultComboBoxModel<String>());
        ;
        jComboBoxHoraFin = jComboBoxHoraFin = new javax.swing.JComboBox<>(new javax.swing.DefaultComboBoxModel<String>());
        ;
        jTextFieldTotal = new javax.swing.JTextField();
        botonInstalacion = new javax.swing.JButton();
        botonTratamiento = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Turno");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agregar Turno");

        jLabel6.setText("Horario Inicio");

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("X Salir X");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tratamiento"));

        jLabel3.setText("Consultorio");

        jComboBoxConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConsultorioActionPerformed(evt);
            }
        });

        jLabel4.setText("Tratamiento");

        Masajista.setText("Masajista");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Masajista)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxConsultorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxMasajista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTratamiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Masajista)
                    .addComponent(jComboBoxMasajista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jLabel10.setText("Horario Fin");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Instalacion"));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Instalacion");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Cantidad Horas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel11)
                .addGap(41, 41, 41)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        jTableDiaDeSpa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo Dia de Spa", "Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableDiaDeSpa);

        jLabel12.setText("Ingrese el codigo o el apellido:");

        Masajista1.setText("Total $");

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxHoraFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHoraFinActionPerformed(evt);
            }
        });

        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });

        botonInstalacion.setText("Seleccionar Instalacion");
        botonInstalacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInstalacionActionPerformed(evt);
            }
        });

        botonTratamiento.setText("Seleccionar Tratamiento");
        botonTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTratamientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(botonTratamiento)
                                .addGap(38, 38, 38)
                                .addComponent(botonInstalacion))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(Masajista1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jComboBoxHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(botonTratamiento)
                                    .addComponent(botonInstalacion))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Masajista1)
                                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.setVisible(false);
       this.setEnabled(false);
       men.activarTodosLosBotones();
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxHoraFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHoraFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxHoraFinActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jComboBoxConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxConsultorioActionPerformed

    private void botonTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTratamientoActionPerformed
        // TODO add your handling code here:
        elegirConstultorio();
        
        botonTratamiento.setEnabled(false);
        botonInstalacion.setEnabled(true);
    }//GEN-LAST:event_botonTratamientoActionPerformed

    private void botonInstalacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInstalacionActionPerformed
elegirInstalacion();
botonTratamiento.setEnabled(true);
        botonInstalacion.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInstalacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Masajista;
    private javax.swing.JLabel Masajista1;
    private javax.swing.JButton botonInstalacion;
    private javax.swing.JButton botonTratamiento;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<Consultorio> jComboBoxConsultorio;
    private javax.swing.JComboBox<String> jComboBoxHoraFin;
    private javax.swing.JComboBox<String> jComboBoxHoraInicio;
    private javax.swing.JComboBox<Masajista> jComboBoxMasajista;
    private javax.swing.JComboBox<Tratamiento> jComboBoxTratamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableDiaDeSpa;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
