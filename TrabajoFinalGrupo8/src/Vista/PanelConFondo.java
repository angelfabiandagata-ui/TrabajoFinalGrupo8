package Vista;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {
    private Image imagenFondo;

    public PanelConFondo(String url) {
        try {
            imagenFondo = new ImageIcon(getClass().getResource(url)).getImage();
        } catch (Exception e) {
            System.err.println("Error al cargar imagen de fondo: " + e.getMessage());
        }
        
        // 🔹 Acomodo corregido (Turnos a la izquierda, Configuración a la derecha)
        if (url.equals("/Vista/Disenio/Turnos.png")) {
            this.setSize(180, 180);
            this.setBounds(531, 100, 225, 220); // izquierda
        }
        if (url.equals("/Vista/Disenio/Configuracion.png")) {
            this.setSize(200, 200);
            this.setBounds(826, 100, 225, 220); // derecha
        }

        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
