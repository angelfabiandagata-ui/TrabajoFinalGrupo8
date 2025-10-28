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
import java.sql.SQLException;
import java.util.Arrays;
import java.sql.Time;


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
    
    public void AltaTratamiento(Tratamiento tratamiento){

String sql = "INSERT INTO `tratamiento`(`codTratamiento`, `nombre`, `detalle`, `productos`, `duracion`, `costo`, `estado`) VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            List<String> productosList = tratamiento.getProductos();
            String productosDB = String.join(",", productosList);

            ps.setInt(1, tratamiento.getCodTratamiento());
            ps.setString(2, tratamiento.getNombre());
            ps.setString(3, tratamiento.getDetalle());
            ps.setString(4, productosDB);
            ps.setTime(5, tratamiento.getDuracion());
            ps.setDouble(6, tratamiento.getCosto());
            ps.setBoolean(7, tratamiento.getEstado());
            ps.executeUpdate();

        
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                tratamiento.setCodTratamiento(rs.getInt(1));
            }
            System.out.println("Tratamiento agregado correctamente.");

            ps.close();
            rs.close(); 
        } catch (SQLException e) {
            System.out.println("Error al guardar el Tratamiento: " + e.getMessage());
        }
    }

        
    
    public void BajaTratamiento(){
        
    }
    public void ModificarTratamiento(){
        
    }

     List<Tratamiento> tratamientos = new ArrayList<>();
     
       public List<Tratamiento> listarTratamientos() {
 
    String sql = "SELECT * FROM tratamiento WHERE estado = true";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


        while (rs.next()) {


            Tratamiento tratam = new Tratamiento();


            tratam.setCodTratamiento(rs.getInt("codTratamiento"));  
            tratam.setNombre(rs.getString("nombre"));
            tratam.setDetalle(rs.getString("detalle"));
            

            String productosDB = rs.getString("productos");

            if (productosDB != null && !productosDB.isEmpty()) {

                List<String> productosList = Arrays.asList(productosDB.split(","));
                tratam.setProductos(productosList); 
            } else {

                tratam.setProductos(new ArrayList<>());
            }

            Time duracionSql = rs.getTime("duracion");
            tratam.setDuracion(duracionSql); 
            

            tratam.setCosto(rs.getDouble("costo")); 
            

            tratam.setEstado(rs.getBoolean("estado")); 


            tratamientos.add(tratam);
        }

        ps.close();
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error al listar tratamientos: " + ex.getMessage());
    }

    return tratamientos;
    }


}

//     public List<Tratamiento> TratamientosMasSesionados(){
//       
//    }
//}
    