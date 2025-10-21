package Persistencia;

import Modelo.Conexion;
import Modelo.Tratamiento;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;


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

     List<Tratamiento> tratamientos = new ArrayList<>();
     
       public List<Tratamiento> listarTratamientos() {
   

    String sql = "SELECT * FROM tratamiento WHERE estado = true";

    	//codTratamiento	nombre	detalle	productos	duracion	costo	estado
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            
            Tratamiento tratam = new Tratamiento();
            
            tratam.setCodTratam(rs.getInt(1));
            tratam.setNombre(rs.getString(2));
            tratam.setDetalle(rs.getString(3));
            List<Producto> array : new Arraylist<> (rs.getArray(4));
            tratam.setProductos(array));
            tratam.setDuracion(LocalTime.MIN);
            tratam.setCosto(rs.getInt(6));
            tratam.setActivo(rs.getBoolean(7));


            tratamientos.add(tratam);
        }

        ps.close();
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error al listar tratamientos: " + ex.getMessage());
    }

    return tratamientos;
}

//     public List<Tratamiento> TratamientosMasSesionados(){
//        
//    }
    