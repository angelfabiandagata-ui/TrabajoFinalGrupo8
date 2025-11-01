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
        
        if(url == "/Vista/Disenio/Turno.png"){
            this.setSize(200, 200);
            this.setBounds(825, 100, 225, 220);
        }
    }

    @Override
    // graficos sirve para pintar este panel con fondo de esa imagen
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
