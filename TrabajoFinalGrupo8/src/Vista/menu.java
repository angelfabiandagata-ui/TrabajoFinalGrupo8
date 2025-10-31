
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class menu extends javax.swing.JFrame {

   /*
public menu() {
    initComponents();
        crearyordenarcomponentes();
        setLocationRelativeTo(null);
        setSize(1600, 600);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jMenu1.setText("Clientes");

        jMenuItem2.setText("Gestionar Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Masajistas");

        jMenuItem3.setText("Gestionar Masajistas");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Sesiones");

        jMenuItem4.setText("Gestionar Sesiones / Turnos");
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Tratamientos");

        jMenuItem5.setText("Gestionar Tratamientos");
        jMenu6.add(jMenuItem5);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Dia de Spa");

        jMenuItem6.setText("Gestionar dias de espa");
        jMenu7.add(jMenuItem6);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Instalacion");

        jMenuItem7.setText("Gestionar Instalaciones");
        jMenu8.add(jMenuItem7);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Consultorio");

        jMenuItem8.setText("Gestionar Consultorios");
        jMenu9.add(jMenuItem8);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    public static void main(String args[]) {
      
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

public void crearyordenarcomponentes() {
    setLocationRelativeTo(null);
    setSize(1600, 600);

    PanelConFondo panelFondo = new PanelConFondo();
    panelFondo.setLayout(null);
    setContentPane(panelFondo);

    // Crear y agregar botones con debugging
    panelFondo.add(crearBoton(825, 100, 225, 220, this::abrirConfiguracion, "Configuración"));
    panelFondo.add(crearBoton(530, 100, 225, 220, this::abrirTurnos, "Turnos"));
    panelFondo.add(crearBoton(515, 384, 210, 38, this::abrirClientes, "Clientes"));
    panelFondo.add(crearBoton(740, 384, 269, 38, this::abrirMasajistas, "Masajistas"));
    panelFondo.add(crearBoton(955, 430, 170, 40, this::mostrarAyuda, "Ayuda"));

    revalidate();
    repaint();
}

private JButton crearBoton(int x, int y, int w, int h, Runnable accion, String nombre) {
    JButton boton = new JButton(nombre); // Texto temporal para debugging
    boton.setBounds(x, y, w, h);
    
    // TEMPORAL: Hacer botones visibles para debugging
    boton.setOpaque(true);
    boton.setBackground(new Color(255, 0, 0, 100)); // Rojo semitransparente
    boton.setContentAreaFilled(true);
    boton.setBorderPainted(true);
    
    boton.addActionListener(e -> {
        System.out.println("DEBUG: Botón " + nombre + " clickeado");
        accion.run();
    });
    
    return boton;
}

// Métodos corregidos para Internal Frames
private void abrirClientes() {
    System.out.println("DEBUG: Ejecutando abrirClientes()");
    try {
        VistaClientes clientes = new VistaClientes();
        clientes.setSize(800, 600);
        // Para Internal Frames, usar setLocation en lugar de setLocationRelativeTo
        clientes.setLocation(100, 100); // Posición dentro del contenedor padre
        clientes.setVisible(true);
        System.out.println("DEBUG: VistaClientes abierta");
    } catch (Exception e) {
        System.err.println("ERROR al abrir Clientes: " + e.getMessage());
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al abrir Clientes: " + e.getMessage());
    }
}

private void abrirMasajistas() {
    System.out.println("DEBUG: Ejecutando abrirMasajistas()");
    try {
        VistaMasajistas masajistas = new VistaMasajistas();
        masajistas.setSize(800, 600);
        masajistas.setLocation(100, 100);
        masajistas.setVisible(true);
        System.out.println("DEBUG: VistaMasajistas abierta");
    } catch (Exception e) {
        System.err.println("ERROR al abrir Masajistas: " + e.getMessage());
        e.printStackTrace();
    }
}

private void abrirTurnos() {
    System.out.println("DEBUG: Ejecutando abrirTurnos()");
    try {
        VistaTurnos turnos = new VistaTurnos();
        turnos.setSize(800, 600);
        turnos.setLocation(100, 100);
        turnos.setVisible(true);
        System.out.println("DEBUG: VistaTurnos abierta");
    } catch (Exception e) {
        System.err.println("ERROR al abrir Turnos: " + e.getMessage());
        e.printStackTrace();
    }
}

private void abrirConfiguracion() {
    System.out.println("DEBUG: Ejecutando abrirConfiguracion()");
    try {
        VistaConfiguracion configuracion = new VistaConfiguracion();
        configuracion.setSize(800, 600);
        configuracion.setLocation(100, 100);
        configuracion.setVisible(true);
        System.out.println("DEBUG: VistaConfiguracion abierta");
    } catch (Exception e) {
        System.err.println("ERROR al abrir Configuración: " + e.getMessage());
        e.printStackTrace();
    }
}

private void mostrarAyuda() {
    System.out.println("DEBUG: Ejecutando mostrarAyuda()");
    JOptionPane.showMessageDialog(this, "Para Contactar Con el Soporte page 100 dolares");
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
*/

//aca esta todo ya corregido pero falta ver si esta todo bien . public class menu extends javax.swing.JFrame {

    public menu() {
        initComponents();
        crearyordenarcomponentes();
        setLocationRelativeTo(null);
        setSize(1600, 600);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Clientes");
        jMenuItem2.setText("Gestionar Clientes");
        jMenuItem2.addActionListener(evt -> abrirClientes());
        jMenu1.add(jMenuItem2);
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Masajistas");
        jMenuItem3.setText("Gestionar Masajistas");
        jMenuItem3.addActionListener(evt -> abrirMasajistas());
        jMenu2.add(jMenuItem3);
        jMenuBar1.add(jMenu2);

        jMenu5.setText("Sesiones");
        jMenuItem4.setText("Gestionar Sesiones / Turnos");
        jMenuItem4.addActionListener(evt -> abrirTurnos());
        jMenu5.add(jMenuItem4);
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Tratamientos");
        jMenuItem5.setText("Gestionar Tratamientos");
        jMenu6.add(jMenuItem5);
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Dia de Spa");
        jMenuItem6.setText("Gestionar días de spa");
        jMenu7.add(jMenuItem6);
        jMenuBar1.add(jMenu7);

        jMenu8.setText("Instalación");
        jMenuItem7.setText("Gestionar Instalaciones");
        jMenu8.add(jMenuItem7);
        jMenuBar1.add(jMenu8);

        jMenu9.setText("Consultorio");
        jMenuItem8.setText("Gestionar Consultorios");
        jMenu9.add(jMenuItem8);
        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        getContentPane().add(jDesktopPane1, BorderLayout.CENTER);
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new menu().setVisible(true);
        });
    }

    public void crearyordenarcomponentes() {
        PanelConFondo panelFondo = new PanelConFondo();
        panelFondo.setLayout(null);

        jDesktopPane1.removeAll();
        jDesktopPane1.add(panelFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.repaint();
        jDesktopPane1.revalidate();

        panelFondo.add(crearBoton(825, 100, 225, 220, this::abrirConfiguracion, "Configuración"));
        panelFondo.add(crearBoton(530, 100, 225, 220, this::abrirTurnos, "Turnos"));
        panelFondo.add(crearBoton(515, 384, 210, 38, this::abrirClientes, "Clientes"));
        panelFondo.add(crearBoton(740, 384, 269, 38, this::abrirMasajistas, "Masajistas"));
        panelFondo.add(crearBoton(955, 430, 170, 40, this::mostrarAyuda, "Ayuda"));

        revalidate();
        repaint();
    }

    private JButton crearBoton(int x, int y, int w, int h, Runnable accion, String nombre) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, w, h);
        boton.setOpaque(true);
        boton.setBackground(new Color(255, 0, 0, 80));
        boton.setBorderPainted(true);

        boton.addActionListener(e -> accion.run());

        return boton;
    }

    // ==========================
    // Métodos para abrir ventanas
    // ==========================

    private void abrirClientes() {
        VistaClientes clientes = new VistaClientes();
        prepararInternalFrame(clientes);
    }

    private void abrirMasajistas() {
        VistaMasajistas masajistas = new VistaMasajistas();
        prepararInternalFrame(masajistas);
    }

    private void abrirTurnos() {
        VistaTurnos turnos = new VistaTurnos();
        prepararInternalFrame(turnos);
    }

    private void abrirConfiguracion() {
        VistaConfiguracion configuracion = new VistaConfiguracion();
        prepararInternalFrame(configuracion);
    }

    private void mostrarAyuda() {
        JOptionPane.showMessageDialog(this, "Para contactar con soporte pague 100 dólares");
    }

    private void prepararInternalFrame(JInternalFrame frame) {
        frame.setSize(800, 600);
        frame.setClosable(true);
        frame.setMaximizable(true);
        frame.setIconifiable(true);
        frame.setResizable(true);
        jDesktopPane1.add(frame);
        frame.setVisible(true);
        frame.toFront();
    }

    // Variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
}

/*Con esto ya andaria bien los:
Ahora los JInternalFrame se agregan como corresponde.
DesktopPane sigue existiendo y sirve.
Panel con fondo está correctamente "dentro" del DesktopPane.
Menú real abre ventanas.
Botones también.
}*/
