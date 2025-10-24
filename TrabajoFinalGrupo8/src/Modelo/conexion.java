package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    public static com.sun.jdi.connect.spi.Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //ATRIBUTOS
    private String url;
    private String usuario;
    private String password;

    //CONEXION NULA
    private static Connection conexion = null;

    //PARA INSTANCIAR UNA CONEXION SE NESESITAN URL,USU,PASW
    public Conexion(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    public Connection buscarConexion() {
        if (conexion == null) {
            try {
                //CARGA EL MARIADB DRIVER
                Class.forName("org.mariadb.jdbc.Driver");
                //CREA UNA CONEXION CON LOS ARGUMENTOS PASADOS
                conexion = DriverManager.getConnection(url, usuario, password);

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo cargar el driver" + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se puede conectar" + ex.getMessage());

            }

        }
        return conexion;
    }

}
