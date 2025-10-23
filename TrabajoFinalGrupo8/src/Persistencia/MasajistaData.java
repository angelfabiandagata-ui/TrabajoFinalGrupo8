/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Conexion;
import Modelo.Masajista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DAIAN
 */
public class MasajistaData {
     private java.sql.Connection con = null;

    public MasajistaData(java.sql.Connection conexion) {
        this.con = conexion;
    }

    public MasajistaData() {
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

    
    
    public void agregarMasajista(Masajista masajista){
         String sql = "INSERT INTO `masajista`(`matricula`, nombreyApellido, `telefono`, `especialidad`, `estado`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, masajista.getMatricula());
            ps.setString(2, masajista.getNombreyapellido());
            ps.setLong(3, masajista.getTelefono());
            ps.setString(4, masajista.getEspecialidad());
            ps.setBoolean(5, masajista.getEstado());
            ps.executeUpdate();
            
            
             ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                masajista.setMatricula(rs.getInt(1)); 
            }
            System.out.println("Masajista agregado correctamente.");
            
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar masajista: " + e.getMessage());
        }
    }
       public void modificarMasajista(Masajista masajista){
        String sql = "UPDATE `masajista` SET `nombreyApellido = ?,telefono=?,`especialidad`=?,`estado`=? WHERE matricula = ?";
           try {
               PreparedStatement ps =con.prepareStatement(sql);
               ps.setString(1, masajista.getNombreyapellido());
               ps.setLong(2, masajista.getTelefono());
               ps.setString(3, masajista.getEspecialidad());
               ps.setBoolean(4, masajista.getEstado());
               ps.setLong(5, masajista.getMatricula());
               ps.executeUpdate();
               System.out.println("Masajista correctamente modificado :)");
           } catch (SQLException ex) {
               System.out.println("Error al modificar masajista" + ex.getMessage());
           }
       }
       
       public void bajaMasajista(int matricula){
           String sql = "UPDATE masajista SET estado = 0 WHERE matricula = ?" ;
           try {
               PreparedStatement ps = con.prepareStatement(sql);
              ps.setLong(1, matricula);
              ps.executeUpdate();
              ps.close();
           } catch (SQLException e) {
               System.out.println("Error al dar de baja al masajista" + e.getMessage());
           }
       }
        public void altaMasajista(int matricula){
           String sql = "UPDATE masajista SET estado = 1 WHERE matricula = ?" ;
           try {
               PreparedStatement ps = con.prepareStatement(sql);
              ps.setLong(1, matricula);
              ps.executeUpdate();
              ps.close();
           } catch (SQLException e) {
               System.out.println("Error al dar de alta al masajista" + e.getMessage());
           }
       }
       
       public Masajista buscarMasajistaPorMatricula(int matricula){
           Masajista masajista = null;
           String sql = "SELECT * FROM `masajista` WHERE matricula = ? ";
           try {
               PreparedStatement ps =con.prepareStatement(sql);
               ps.setInt(1, matricula);
               ResultSet rs = ps.executeQuery();
               if (rs.next()) {
                   masajista = new Masajista();
                   masajista.setMatricula(rs.getLong("matricula"));
                   masajista.setNombreyapellido(rs.getString("nombreyApellido"));
                   masajista.setTelefono(rs.getLong("telefono"));
                   masajista.setEspecialidad(rs.getString("especialidad"));
                   masajista.setEstado(rs.getBoolean("estado"));
                   
               }
               ps.close();
           } catch (SQLException e) {
               System.out.println("Error al buscar masajista :(");
           }
           return masajista;
       }
       
          public List<Masajista> listarMasajista(){
              List<Masajista> masajistas = new ArrayList<>();
        String sql = "SELECT * FROM masajista WHERE estado  = true";
              try {
                  PreparedStatement ps = con.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
                  while (rs.next()) {                      
                      Masajista m = new Masajista();
                      m.setMatricula(rs.getLong("Matricula"));
                      m.setNombreyapellido(rs.getString("nombreyApellido"));
                      m.setTelefono(rs.getLong("Telefono"));
                      m.setEspecialidad(rs.getString("Especialidad"));
                      m.setEstado(rs.getBoolean("Estado"));
                   masajistas.add(m);
                  }
              } catch (SQLException e) {
                  System.out.println("Error al listar masajistas" + e.getMessage());
              }
              return masajistas;
          }
          
           public void buscarEspecialidad(Masajista masajista){
        
    }
             
          public void borrar(Masajista masajista){
        
    }
}
