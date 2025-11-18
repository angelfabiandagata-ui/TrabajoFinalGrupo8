/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.Conexion;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DAIAN
 */
public class ClienteData {
 private java.sql.Connection con = null;

    public ClienteData(java.sql.Connection conexion) {
        this.con = conexion;
    }

    public ClienteData() {
        String url = "jdbc:mariadb://localhost:3306/spa_grupo_8";
        String usuario = "root";
        String password = "";

        try {
            Conexion conAux = new Conexion(url, usuario, password);
            this.con = conAux.buscarConexion();
        } catch (Exception e) {
            System.err.print("Error al conectar" + e.getMessage());
        }

    }
    public void guardarCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (codCliente, dni, nombre, apellido, telefono, edad, afecciones, estado) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cliente.getCodCli());
            ps.setLong(2, cliente.getDni());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellido());
            ps.setLong(5, cliente.getTelefono());
            ps.setInt(6, cliente.getEdad());
            ps.setString(7, cliente.getAfeciones());
            ps.setBoolean(8, cliente.isEstado());
            ps.executeUpdate();
            
        
             try(ResultSet rs = ps.getGeneratedKeys()){
            if (rs.next()) {
                cliente.setCodCli(rs.getInt(1)); 
            }
             }
            System.out.println("Cliente guardado correctamente. CodCliente asignado: " + cliente.getCodCli());
            
        
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }
        
        
    }
    
    public void modificarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET dni=?, nombre=?,apellido=? ,telefono=?, edad=?, afecciones=?, estado=? WHERE codCliente=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setLong(4, cliente.getTelefono());
            ps.setInt(5, cliente.getEdad());
            ps.setString(6, cliente.getAfeciones());
            ps.setInt(7, cliente.isEstado()? 1 : 0);
            ps.setInt(8, cliente.getCodCli());
            ps.executeUpdate();
            System.out.println("Cliente modificado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }
    }
    
     public void eliminarCliente(int codCliente) {
        String sql = "DELETE FROM  cliente WHERE codCliente=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codCliente);
            ps.executeUpdate();
            System.out.println("Cliente eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
    }
     
     public Cliente buscarClientePorId(int codCli) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE codCliente=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codCli);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setCodCli(rs.getInt("codCliente"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setAfeciones(rs.getString("afecciones"));
                cliente.setEstado(rs.getBoolean("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por ID: " + e.getMessage());
        }
        return cliente;
    }

    
    public Cliente buscarClientePorDni(Long dni) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE dni=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setCodCli(rs.getInt("codCliente"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setAfeciones(rs.getString("afecciones"));
                cliente.setEstado(rs.getBoolean("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por DNI: " + e.getMessage());
        }
        return cliente;
    }

   
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente ";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodCli(rs.getInt("codCliente"));
                c.setDni(rs.getLong("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setTelefono(rs.getLong("telefono"));
                c.setEdad(rs.getInt("edad"));
                c.setAfeciones(rs.getString("afecciones"));
                c.setEstado(rs.getBoolean("estado"));
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }
 
public void bajaCliente(int codCliente){
           String sql = "UPDATE cliente SET estado = 0 WHERE codCliente = ?" ;
           try {
               PreparedStatement ps = con.prepareStatement(sql);
              ps.setLong(1, codCliente);
              ps.executeUpdate();
              ps.close();
           } catch (SQLException e) {
               System.out.println("Error al dar de baja al cliente" + e.getMessage());
           }
       }
        public void altaCliente(int codCliente){
           String sql = "UPDATE cliente SET estado = 1 WHERE codCliente = ?" ;
           try {
               PreparedStatement ps = con.prepareStatement(sql);
              ps.setLong(1, codCliente);
              ps.executeUpdate();
              ps.close();
           } catch (SQLException e) {
               System.out.println("Error al dar de alta al cliente" + e.getMessage());
           }
       }    
        
        public List<Cliente> buscarPorCodigoOApellido(String texto) {
    List<Cliente> clientes = new ArrayList<>();
    String sql = "SELECT * FROM cliente WHERE codCliente = ? OR apellido LIKE ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);

        try {
            ps.setInt(1, Integer.parseInt(texto));
        } catch (NumberFormatException e) {
            ps.setInt(1, -1); // si no es número, no matchea por ID
        }

        ps.setString(2, "%" + texto + "%");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setCodCli(rs.getInt("codCliente"));
            c.setDni(rs.getLong("dni"));
            c.setNombre(rs.getString("nombre"));
            c.setApellido(rs.getString("apellido"));
            c.setTelefono(rs.getLong("telefono"));
            c.setEdad(rs.getInt("edad"));
            c.setAfeciones(rs.getString("afecciones"));
            c.setEstado(rs.getBoolean("estado"));
            clientes.add(c);
        }

        rs.close();
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al buscar cliente: " + ex.getMessage());
    }

    return clientes;
}
        
public List<Cliente> buscarPorApellido(String apellido) {
    List<Cliente> clientes = new ArrayList<>();

    String sql = "SELECT * FROM cliente WHERE apellido LIKE ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, apellido + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Cliente c = new Cliente();

            c.setCodCli(rs.getInt("codCliente"));
            c.setDni(rs.getLong("dni"));
            c.setNombre(rs.getString("nombre"));
            c.setApellido(rs.getString("apellido"));
            c.setTelefono(rs.getLong("telefono"));
            c.setEdad(rs.getInt("edad"));
            c.setAfeciones(rs.getString("afecciones"));
            c.setEstado(rs.getBoolean("estado"));

            clientes.add(c);
        }

        rs.close();
        ps.close();

    } catch (SQLException ex) {
        System.out.println("Error al buscar clientes por apellido: " + ex.getMessage());
    }

    return clientes;
}
}

