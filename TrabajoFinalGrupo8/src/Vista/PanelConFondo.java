package Vista; // Asegúrate de que este sea el paquete correcto

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension; // Necesario para getPreferredSize
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase para usar una imagen como fondo de un JPanel.
 */
public class PanelConFondo extends JPanel {
    
    private Image imagenDeFondo;
    private final String RUTA_IMAGEN = "/Vista/Disenio/radio.jpg"; 

    public PanelConFondo() {
        try {
            imagenDeFondo = new ImageIcon(getClass().getResource(RUTA_IMAGEN)).getImage();
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen de fondo: " + RUTA_IMAGEN);
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        if (imagenDeFondo != null) {
            g.drawImage(
                imagenDeFondo, 
                0, 
                0, 
                getWidth(), 
                getHeight(), 
                this
            );
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1600, 600); 
    }
}
