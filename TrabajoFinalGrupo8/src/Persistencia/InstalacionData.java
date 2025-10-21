package Persistencia;

import Modelo.Conexion;
import Modelo.SesionTurno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import org.mariadb.jdbc.Statement;

public class InstalacionData {

    private Connection con = null;

    public InstalacionData(java.sql.Connection conexion) {
        this.con = conexion;
    }

    public InstalacionData() {
        String url = "localhost/phpmyadmin/index.php?route=database/structure&db=sgulp_equipo_8";
        String usuario = "root";
        String password = "1234";

        try {
            Conexion conAux = new Conexion(url, usuario, password);
            this.con = conAux.buscarConexion();
        } catch (Exception e) {
            System.err.print("Error");
        }

    }

//    public void AltaInstalacion(){
//        
//    }
//    public void BajaInstalacion(){
//        
//    }
//    public void ModificarInstalacion(){
//        
//    }
//
//    public List<Instalacion> ListarInstalaciones() {
//
//    }
//
//    public List<Instalacion> ListarInstalacionesMasSolicitadas() {
//
//    }
}
