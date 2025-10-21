package Persistencia;

import Modelo.Conexion;
import Modelo.Tratamiento;
import java.sql.Connection;
import java.util.List;

public class TratamientoData {

    private Connection con = null;

    public TratamientoData(java.sql.Connection conexion) {
        this.con = conexion;
    }

    public TratamientoData() {
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
    
//    public void AltaTratamiento(){
//        
//    }
//    public void BajaTratamiento(){
//        
//    }
//    public void ModificarTratamiento(){
//        
//    }
//    public List<Tratamiento> ListarTratamiento(){
//        
//    }
//     public List<Tratamiento> TratamientosMasSesionados(){
//        
//    }
    
}
