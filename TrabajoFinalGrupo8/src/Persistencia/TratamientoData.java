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
        String url = "jdbc:mariadb://localhost:3306/spa_grupo_8";
        String usuario = "root";
        String password = "";

        try {
            Conexion conAux = new Conexion(url, usuario, password);
            this.con = conAux.buscarConexion();
        } catch (Exception e) {
            System.err.print("Conexion Fallida");
        }

    }
    
    public void agregarTratamiento(Tratamiento tratamiento){

String sql = "INSERT INTO `tratamiento`(`codTratamiento`, `nombre`, `detalle`, `productos`, `duracion`, `costo`, `estado`) VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            List<String> productosList = tratamiento.getProductos();
            String productosDB = "";

            ps.setInt(1, tratamiento.getCodTratamiento());
            ps.setString(2, tratamiento.getNombre());
            ps.setString(3, tratamiento.getDetalle());
            ps.setString(4, productosDB);
            ps.setTime(5, tratamiento.getDuracion());
            ps.setDouble(6, tratamiento.getCosto());
            ps.setBoolean(7, tratamiento.getEstado());
            ps.executeUpdate();

            if (productosList != null && !productosList.isEmpty()) {
                productosDB = String.join(",", productosList);
            }
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
 public void borrarTratamiento(int codTratamiento) {
        try {
            String sql = "DELETE FROM `tratamiento` WHERE codTratamiento = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codTratamiento);
            ps.executeUpdate();
            ps.close();
            System.out.println("Tratamiento borrado con exito");
        } catch (SQLException ex) {
            System.out.println("Error al borrar el Tratamiento" + ex.getMessage());
        }

    }
        
     public void altaTratamiento(int codTratamiento){
           String sql = "UPDATE tratamiento SET estado = 1 WHERE codTratamiento = ?" ;
           try {
               PreparedStatement ps = con.prepareStatement(sql);
              ps.setLong(1, codTratamiento);
              ps.executeUpdate();
              ps.close();
           } catch (SQLException e) {
               System.out.println("Error al dar de alta al tratamiento" + e.getMessage());
           }
       }
    
    
    
    
    public void bajaTratamiento(int codTratamiento){
    String sql = "UPDATE tratamiento SET estado = false WHERE codTratamiento = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        

        ps.setInt(1, codTratamiento);
        

        int filasActualizadas = ps.executeUpdate();
        
        if (filasActualizadas > 0) {
            System.out.println("Tratamiento con ID " + codTratamiento + " dado de baja (Estado: Inactivo)");
        } else {
            System.out.println("Error: No se encontro ningun tratamiento con ID " + codTratamiento + " para dar de baja");
        }
        
        ps.close();
        
    } catch (SQLException e) {
        System.out.println("❌ Error al dar de baja el Tratamiento: " + e.getMessage());
    }
    }
    public void ModificarTratamiento(Tratamiento tratamiento){
         String sql = "UPDATE `tratamiento` SET `nombre` = ?,`detalle`=?,`productosDB`=?,`duracion`=?,`costo`=?,`estado`=? WHERE codTratamiento = ?";
           try {
                List<String> productosList = tratamiento.getProductos();
            String productosDB = String.join(",", productosList);
               
              PreparedStatement ps =con.prepareStatement(sql);
               ps.setInt(1, tratamiento.getCodTratamiento());
            ps.setString(2, tratamiento.getNombre());
            ps.setString(3, tratamiento.getDetalle());
            ps.setString(4, productosDB);
            ps.setTime(5, tratamiento.getDuracion());
            ps.setDouble(6, tratamiento.getCosto());
            ps.setBoolean(7, tratamiento.getEstado());
            ps.executeUpdate();
               System.out.println("Tratamiento correctamente modificado :)");
           } catch (SQLException ex) {
               System.out.println("Error al modificar el tratamiento" + ex.getMessage());
           }
       
    }

    public boolean existeTratamiento(int codTratamiento) {
    String sql = "SELECT codTratamiento FROM tratamiento WHERE codTratamiento = ?";
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, codTratamiento);
        rs = ps.executeQuery();

        
        boolean existe = rs.next(); 
        
        ps.close();
        rs.close();
        
        return existe;

    } catch (SQLException ex) {
        
        System.out.println("Error al verificar la existencia del Tratamiento: " + ex.getMessage());
        return true; 
    }
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

  public Tratamiento buscarMasajistaPorCodigo(int codTratamiento) {

        Tratamiento tratamiento = null;

        String sql = "SELECT * FROM `tratamiento` WHERE codTratamiento = ? ";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, codTratamiento);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                tratamiento = new Tratamiento();
                tratamiento.setCodTratamiento(rs.getInt("codTratamiento"));
                tratamiento.setNombre(rs.getString("nombre"));
                tratamiento.setDetalle(rs.getString("detalle"));
               String productosDB = rs.getString("productos"); 
            
            if (productosDB != null && !productosDB.isEmpty()) {
                List<String> productosList = Arrays.asList(productosDB.split(","));
                tratamiento.setProductos(productosList); 
            } else {

                tratamiento.setProductos(new ArrayList<>());
            }
            

            Time duracionSql = rs.getTime("duracion");
            tratamiento.setDuracion(duracionSql); 
            
            tratamiento.setCosto(rs.getDouble("costo")); 
            tratamiento.setEstado(rs.getBoolean("estado"));
               

            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar tratamiento :(");
        }
        return tratamiento;
    }
       



    public List<Tratamiento> TratamientosMasSesionados(){  
        List<Tratamiento> tratamientos = new ArrayList<>();
        
        
        
        
        
        String sql = "SELECT * FROM tratamiento WHERE estado='1'";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tratamiento c = new Tratamiento();
                c.setCodTratamiento(rs.getInt("codTratamiento"));
                c.setNombre(rs.getString("nombre"));
                c.setDetalle(rs.getString("detalle"));
                String productosSeparados = rs.getString("productos");
                List<String> listaDeProductos;
                
                if (productosSeparados != null && !productosSeparados.isEmpty()) {
                    listaDeProductos =  java.util.Arrays.asList(productosSeparados.split(","));
                }
                else{
                    listaDeProductos = new java.util.ArrayList<>();
                }
                c.setProductos(listaDeProductos);
                c.setDuracion(rs.getTime("duracion"));
                c.setCosto(rs.getDouble("costo"));
                c.setEstado(rs.getBoolean("estado"));
                tratamientos.add(c);
                
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return tratamientos;
      
   }
}

    