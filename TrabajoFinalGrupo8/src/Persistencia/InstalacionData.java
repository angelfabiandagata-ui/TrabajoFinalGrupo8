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
//    public List<Instalacion> ListarInstalacionesMasSolicitadas() {
//    }
    
public void guardarInstalacion(Instalacion inst) { 
    // ERROR: Tienes 4 columnas pero 5 parámetros (?)
    String sql = "INSERT INTO `instalacion`(`nombre`, `detalle_uso`, `precio30m`, `estado`) VALUES (?,?,?,?)";
    
    try{
        
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, inst.getNombre());
        ps.setString(2, inst.getDetalleUso());
        ps.setDouble(3, inst.getPrecio30min());
        ps.setBoolean(4, inst.isEstado());
        
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
       
        String sql = "SELECT * FROM `instalacion` WHERE id = ?";
        Instalacion inst = null; 
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) { 
            inst = new Instalacion(); 
            
            inst.setCodInstal(rs.getInt(0));
            inst.setNombre(rs.getString(1));
            inst.setDetalleUso(rs.getString(2));
            inst.setPrecio30min(rs.getDouble(3));
            inst.setEstado(rs.getBoolean(4));                  
            rs.close();
            ps.close();
        }           
    } catch (SQLException e) {
        System.err.println("Error al buscar el alumno: " + e.getMessage());
    }
    return inst; 
    }
    
    public void actualizarInstalacion(Instalacion inst) {
        try {
            String sql = "UPDATE `instalacion` SET `codInstalacion`=?,`nombre`=?,`detalle_uso`=?,`precio30m`=?,`estado`=? WHERE 1";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, inst.getCodInstal());
            ps.setString(2, inst.getNombre());
            ps.setString(3, inst.getDetalleUso());
            ps.setDouble(4, inst.getPrecio30min());
            ps.setBoolean(5, inst.isEstado());
            
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno actualizado correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el alumno" + ex.getMessage()
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

     public List<Instalacion> listarInstalasciones() {
        List<Instalacion> instalaciones = new ArrayList<>();
        String sql = "SELECT * FROM `alumno` WHERE `estado` = true";
        
          try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Instalacion inst = new Instalacion();    
            
            inst.setCodInstal(rs.getInt(0));
            inst.setNombre(rs.getString(1));
            inst.setDetalleUso(rs.getString(2));
            inst.setPrecio30min(rs.getDouble(3));
            inst.setEstado(rs.getBoolean(4)); 
                       
            inst.setEstado(true);
            instalaciones.add(inst);
        }
          ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al listar alumnos: " + ex.getMessage());
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
            System.out.println("Alumno dado de alta correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al dar de alta el alumno" + ex.getMessage()
            );
        }
    }
    public void bahaLogica(int cod) {
        try {
            String sql = "UPDATE `instalacion` SET `estado`='0' WHERE `codInstalacion` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno dado de alta correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al dar de alta el alumno" + ex.getMessage()
            );
        }
    }
        
//final    
}
