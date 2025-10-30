package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    // Atributos
    private String url;
    private String usuario;
    private String password;
    private static Connection conexion = null;

    //sin parametros
    public Conexion() {
        this.url = "jdbc:mariadb://localhost:3306/spa_entre_dedos";
        this.usuario = "root";
        this.password = "";
    }

    //para introducir parametros
    public Conexion(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    public Connection buscarConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println(" Conectado correctamente a la base de datos");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, " No se pudo cargar el driver: " + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " No se puede conectar: " + ex.getMessage());
            }
        }
        return conexion;
    }
}


