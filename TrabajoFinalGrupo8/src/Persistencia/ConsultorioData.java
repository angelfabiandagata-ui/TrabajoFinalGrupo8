package Persistencia;

import Modelo.Conexion;
import Modelo.Consultorio;
import java.sql.Connection; // ✅ CORREGIDO
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement; // ✅ para RETURN_GENERATED_KEYS
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAIAN
 */
public class ConsultorioData {
    
     private Connection con = null; // ✅ tipo correcto

    public ConsultorioData(Connection conexion) {
        this.con = conexion;
    }

    
    public ConsultorioData() {
        String url = "jdbc:mariadb://localhost:3306/spa_grupo_8";
        String usuario = "root";
        String password = "";

        try {
            Conexion conAux = new Conexion(url, usuario, password);
            this.con = conAux.buscarConexion();
        } catch (Exception e) {
            System.err.print("Error");
        }
    }
    
    
    // ================== GUARDAR ==================
    public void Guardar(Consultorio consultorio){
        String sql = "INSERT INTO consultorio (usos, equipamiento, apto) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // ✅ CORREGIDO
            
            
            ps.setString(1, String.join(",", consultorio.getUsos())); 
            ps.setString(2, String.join(",", consultorio.getEquipamiento()));
            ps.setBoolean(3, consultorio.isApto());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                consultorio.setNroConsultorio(rs.getInt(1)); 
                System.out.println("Consultorio guardado con ID: " + consultorio.getNroConsultorio());
            }
            
            rs.close(); // ✅ cerrar resultset
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al guardar consultorio: " + ex.getMessage());
        }
    }
           
    
    // ================== MODIFICAR ==================
    public void Modificar(Consultorio consultorio){
        
        String sql = "UPDATE consultorio SET usos = ?, equipamiento = ?, apto = ? WHERE nroConsultorio = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            //
            ps.setString(1, String.join(",", consultorio.getUsos()));
            ps.setString(2, String.join(",", consultorio.getEquipamiento()));
            ps.setBoolean(3, consultorio.isApto());
            ps.setInt(4, consultorio.getNroConsultorio());
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Consultorio modificado correctamente.");
            } else {
                System.out.println("No se encontró el consultorio con ese número.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al modificar consultorio: " + ex.getMessage());
        }
    }
    
       
    // ================== BUSCAR ==================
    public Consultorio Buscar(int nroConsultorio){
        String sql = "SELECT * FROM consultorio WHERE nroConsultorio = ?";
        Consultorio c = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroConsultorio);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String usos = rs.getString("usos");
                String equipamiento = rs.getString("equipamiento");
                
                c = new Consultorio(
                    rs.getInt("nroConsultorio"),
                    usos.split(","), 
                    equipamiento.split(","),
                    rs.getBoolean("apto")
                );
            }
            
            rs.close(); // ✅ cerrar resultset
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar consultorio: " + ex.getMessage());
        }
        
        return c;
    }
      
    
    // ================== LISTAR ==================
    public List<Consultorio> Listar() {
        List<Consultorio> lista = new ArrayList<>();
        String sql = "SELECT * FROM consultorio";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                // ✅ CORREGIDO igual que arriba
                String usos = rs.getString("usos");
                String equipamiento = rs.getString("equipamiento");
                
                Consultorio c = new Consultorio(
                    rs.getInt("nroConsultorio"),
                    usos.split(","),
                    equipamiento.split(","),
                    rs.getBoolean("apto")
                );
                lista.add(c);
            }
            
            rs.close(); // ✅ cerrar resultset
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar consultorios: " + ex.getMessage());
        }
        
        return lista;
    }

public void Eliminar(int nroConsultorio) {
    String sql = "DELETE FROM consultorio WHERE nroConsultorio = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, nroConsultorio);
        
        int exito = ps.executeUpdate();
        if (exito == 1) {
            System.out.println("Consultorio eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún consultorio con ese número.");
        }
        
        ps.close(); // ✅ cerramos el PreparedStatement
    } catch (SQLException ex) {
        System.out.println("Error al eliminar consultorio: " + ex.getMessage());
    }
}
}