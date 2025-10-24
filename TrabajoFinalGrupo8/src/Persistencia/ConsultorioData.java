/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Conexion;
import Modelo.Consultorio;
import com.sun.jdi.connect.spi.Connection;
import org.mariadb.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAIAN
 */
public class ConsultorioData {
    
     private java.sql.Connection con = null;

    public ConsultorioData(java.sql.Connection conexion) {
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
    
    
    
       public void Guardar(Consultorio consultorio){
        String sql = "INSERT INTO consultorio (usos, equipamiento, apto) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, consultorio.getUsos());
            ps.setString(2, consultorio.getEquipamiento());
            ps.setBoolean(3, consultorio.isApto());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                consultorio.setNroConsultorio(rs.getInt(1)); 
                System.out.println("Consultorio guardado con ID: " + consultorio.getNroConsultorio());
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al guardar consultorio: " + ex.getMessage());
        }
    }
           
    
       
       public void Modificar(Consultorio consultorio){
        
           String sql = "UPDATE consultorio SET usos = ?, equipamiento = ?, apto = ? WHERE nroConsultorio = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, consultorio.getUsos());
            ps.setString(2, consultorio.getEquipamiento());
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
    
       
        public Consultorio Buscar(int nroConsultorio){
          String sql = "SELECT * FROM consultorio WHERE nroConsultorio = ?";
        Consultorio c = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroConsultorio);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new Consultorio(
                    rs.getInt("nroConsultorio"),
                    rs.getString("usos"),
                    rs.getString("equipamiento"),
                    rs.getBoolean("apto")
                );
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar consultorio: " + ex.getMessage());
        }
        
        return c;
    }
      
    
        
        
       public List<Consultorio> Listar() {
        List<Consultorio> lista = new ArrayList<>();
        String sql = "SELECT * FROM consultorio";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Consultorio c = new Consultorio(
                    rs.getInt("nroConsultorio"),
                    rs.getString("usos"),
                    rs.getString("equipamiento"),
                    rs.getBoolean("apto")
                );
                lista.add(c);
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar consultorios: " + ex.getMessage());
        }
        
        return lista;
    }
    
}
