/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Conexion;
import com.sun.jdi.connect.spi.Connection;
import org.mariadb.jdbc.Driver;

/**
 *
 * @author angel
 */
public class entidadData {
    
    //atributos para la conexion
    String url = "localhost/phpmyadmin/index.php?route=database/structure&db=sgulp_equipo_8";
    String usuario ="root";
    String password= "";
    
    //conexion nula
    Connection con = null;
    
    //entidad data crea una conexion cuando se instancia
    public entidadData() {  
        try {
                Conexion conclase = new Conexion(url, usuario, password);
                con = (Connection) conclase.buscarConexion();
        } catch (Exception e) {
            System.err.print("Error");
        }
        
        
    }
    
//final clase    
}
