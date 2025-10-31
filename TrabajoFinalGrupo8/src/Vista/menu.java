
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

    }//GEN-LAST:event_jMenuItem2ActionPerformed


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
} codigo viejo
*/



    public menu() {
    initComponents();

    // tamaño antes de crear componentes
    this.setSize(1600, 600);
    this.setLocationRelativeTo(null);

    crearyordenarcomponentes();
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
    // Creamos panel con fondo
    PanelConFondo panelFondo = new PanelConFondo();
    panelFondo.setLayout(null);

    // Limpiamos desktop y agregamos panel de fondo en la capa más baja
    jDesktopPane1.removeAll();

    // Necesitamos que el panelFondo ocupe todo el desktop; seteamos bounds ahora
    panelFondo.setBounds(0, 0, jDesktopPane1.getWidth(), jDesktopPane1.getHeight());
    jDesktopPane1.add(panelFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

    // Si al momento de crear aún width/height son 0 (puede pasar), aseguramos un listener
    jDesktopPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentResized(java.awt.event.ComponentEvent e) {
            panelFondo.setBounds(0, 0, jDesktopPane1.getWidth(), jDesktopPane1.getHeight());
        }
    });

    // Agregar botones (zonas clicables) — invisibles sobre la imagen
    panelFondo.add(crearBotonInvisible(825, 100, 225, 220, this::abrirConfiguracion, "Configuración"));
    panelFondo.add(crearBotonInvisible(530, 100, 225, 220, this::abrirTurnos, "Turnos"));
    panelFondo.add(crearBotonInvisible(515, 384, 210, 38, this::abrirClientes, "Clientes"));
    panelFondo.add(crearBotonInvisible(740, 384, 269, 38, this::abrirMasajistas, "Masajistas"));
    panelFondo.add(crearBotonInvisible(955, 430, 170, 40, this::mostrarAyuda, "Ayuda"));

    // refrescar
    jDesktopPane1.revalidate();
    jDesktopPane1.repaint();
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

    private JButton crearBotonInvisible(int x, int y, int w, int h, Runnable accion, String tooltip) {
    JButton boton = new JButton();
    boton.setBounds(x, y, w, h);
    boton.setOpaque(false);
    boton.setContentAreaFilled(false);
    boton.setBorderPainted(false);
    boton.setFocusPainted(false);
    boton.setToolTipText(tooltip);

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
    }

    private void abrirConfiguracion() {
        VistaConfiguracion configuracion = new VistaConfiguracion();
    }

    private void mostrarAyuda() {
        JOptionPane.showMessageDialog(this, "Para contactar con soporte pague 100 dólares");
    }

    private void prepararInternalFrame(JInternalFrame frame) {
        frame.setSize(800, 400);
        frame.setClosable(true);
        frame.setMaximizable(true);
        frame.setIconifiable(true);
        frame.setResizable(true);
        jDesktopPane1.add(frame);
        frame.setVisible(true);
        frame.toFront();
        int x = (jDesktopPane1.getWidth() - frame.getWidth()) / 2;
    int y = (jDesktopPane1.getHeight() - frame.getHeight()) / 2;
    frame.setLocation(x, y);

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
