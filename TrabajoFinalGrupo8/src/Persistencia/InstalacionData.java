package Persistencia;

import Modelo.Conexion;
import Modelo.Instalacion;
import Modelo.SesionTurno;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InstalacionData {

    private  Connection con = null;

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
//    public List<Instalacion> ListarInstalacionesMasSolicitadas() {
//    }
    
public void guardarInstalacion(Instalacion inst) { 
    // ERROR: Tienes 4 columnas pero 5 parámetros (?)
    String sql = "INSERT INTO `instalacion`(`codInstalacion`, `nombre`, `detalle_uso`, `precio30m`, `estado`) VALUES (?,?,?,?,?)";
    
    try{
        
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1, inst.getCodInstal());
        ps.setString(2, inst.getNombre());
        ps.setString(3, inst.getDetalleUso());
        ps.setDouble(4, inst.getPrecio30min());
        ps.setBoolean(5, inst.isEstado());
        
        int filas = ps.executeUpdate();
        
        if (filas > 0) {
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    // ERROR: Los índices en ResultSet empiezan en 1, no en 0
                    inst.setCodInstal(rs.getInt(1));
                }
            }
            JOptionPane.showMessageDialog(null, " Instalación guardada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, " No se insertó ninguna Instalación");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, " Error al guardar: " + ex.getMessage());
    }
}

    public Instalacion buscarInstalacion(int id) {
       
        String sql = "SELECT * FROM `instalacion` WHERE codInstalacion = ?";
        Instalacion inst = null; 
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) { 
            inst = new Instalacion(); 
            
            inst.setCodInstal(rs.getInt(1));
            inst.setNombre(rs.getString(2));
            inst.setDetalleUso(rs.getString(3));
            inst.setPrecio30min(rs.getDouble(4));
            inst.setEstado(rs.getBoolean(5));                  
            rs.close();
            ps.close();
        }           
    } catch (SQLException e) {
        System.err.println("Error al buscar el alumno: " + e.getMessage());
    }
    return inst; 
    }
    
     public  boolean existeInstalacion(int codInstalacion) {
    String sql = "SELECT codInstalacion FROM instalacion WHERE codInstalacion = ?";
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, codInstalacion);
        rs = ps.executeQuery();

        
        boolean existe = rs.next(); 
        
        ps.close();
        rs.close();
        
        return existe;

    } catch (SQLException ex) {
        
        System.out.println("Error al verificar la existencia de la Instalacion: " + ex.getMessage());
        return true; 
    }
}
    
     public void modificarInstalacion(Instalacion inst){
     try {
        // Consulta: Quitamos codInstalacion del SET (solo lo dejamos en el WHERE)
        String sql = "UPDATE `instalacion` SET `nombre`=?, `detalle_uso`=?, `precio30m`=?, `estado`=? WHERE `codInstalacion`=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        // 1. Asignación de valores (los nuevos datos)
        ps.setString(1, inst.getNombre());        // 1. nombre
        ps.setString(2, inst.getDetalleUso());     // 2. detalle_uso
        ps.setDouble(3, inst.getPrecio30min());    // 3. precio30m
        ps.setBoolean(4, inst.isEstado());         // 4. estado
        
        // 2. Condición WHERE (identificador)
        ps.setInt(5, inst.getCodInstal());         // 5. codInstalacion (Identifica la fila)
        
        ps.executeUpdate();
        ps.close();
        System.out.println("Instalacion actualizada correctamente!!");
    } catch (SQLException ex) {
        System.out.println("Error al actualizar la Instalacion: " + ex.getMessage());
    }
     }
     
     
     
    
    public void actualizarInstalacion(Instalacion inst) {
        try {
            String sql = "UPDATE `instalacion` SET `codInstalacion`=?,`nombre`=?,`detalle_uso`=?,`precio30m`=?,`estado`=? WHERE `codInstalacion`=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, inst.getCodInstal());
            ps.setString(2, inst.getNombre());
            ps.setString(3, inst.getDetalleUso());
            ps.setDouble(4, inst.getPrecio30min());
            ps.setBoolean(5, inst.isEstado());
            
            ps.executeUpdate();
            ps.close();
            System.out.println("Instalacion actualizado correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la Instalacion" + ex.getMessage()
            );
        }

    }
    
    public void borrarInstalacion(int cod) {
        try {
            String sql = "DELETE FROM `instalacion` WHERE codInstalacion = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, cod);
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno borrado con exito");
        } catch (SQLException ex) {
            System.out.println("Error al borrar el alumno" + ex.getMessage());
        }

    }

     public List<Instalacion> listarInstalaciones() {
       List<Instalacion> instalaciones = new ArrayList<>();

    String sql = "SELECT codInstalacion, nombre, detalle_uso, precio30m, estado FROM instalacion";
    
    try (PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) { 


        while (rs.next()) {
            Instalacion inst = new Instalacion();  
            
            // Verificación del mapeo
            inst.setCodInstal(rs.getInt("codInstalacion"));
            inst.setNombre(rs.getString("nombre"));

            inst.setDetalleUso(rs.getString("detalle_uso")); 
            inst.setPrecio30min(rs.getDouble("precio30m"));
            inst.setEstado(rs.getBoolean("estado")); 
                        
            instalaciones.add(inst);
        }
        
        System.out.println("Instalaciones cargadas: " + instalaciones.size()); // Muestra cuántas se cargaron
        
    } catch (SQLException ex) {
        // 🛑 PUNTO CRÍTICO 🛑
        System.err.println("❌ ERROR SQL al listar Instalaciones: " + ex.getMessage());
        ex.printStackTrace(); // Imprime la traza completa para ver dónde falló el SQL.
    }
    return instalaciones;
    }
     
     public void altaLogica(int cod) {
        try {
            String sql = "UPDATE `instalacion` SET `estado`='1' WHERE `codInstalacion` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.executeUpdate();
            ps.close();
            System.out.println("Instalacion dado de alta correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al dar de alta el alumno" + ex.getMessage()
            );
        }
    }
    public void bajaLogica(int cod) {
        try {
            String sql = "UPDATE `instalacion` SET `estado`='0' WHERE `codInstalacion` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.executeUpdate();
            ps.close();
            System.out.println("Instalacion dado de baja correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al dar de alta el alumno" + ex.getMessage()
            );
        }
        
    }
        
//final    
}
