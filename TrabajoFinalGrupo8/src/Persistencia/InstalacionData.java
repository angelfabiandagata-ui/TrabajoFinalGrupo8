package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;
import java.util.List;

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
//    public void CrearSesionIns() {
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
