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

    
    
    public void agregarMasajista(Masajista masajista){
         String sql = "INSERT INTO `masajista`(`matricula`, `nombre`, `apellido`, `telefono`, `especialidad`, `estado`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, masajista.getMatricula());
            ps.setString(2, masajista.getNombreyapellido());
            ps.setLong(3, masajista.getTelefono());
            ps.setString(5, masajista.getEspecialidad());
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
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }
    }    
       public void modificar(Masajista masajista){
        
    }
       
          public void listarMasajista(Masajista masajista){
        
    }
          
           public void buscarEspecialidad(Masajista masajista){
        
    }
             
          public void borrar(Masajista masajista){
        
    }
}
