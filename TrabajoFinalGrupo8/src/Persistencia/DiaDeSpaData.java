package Persistencia;

import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.DiaDeSpa;
import Modelo.SesionTurno;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DiaDeSpaData {
    private java.sql.Connection con = null;

    public DiaDeSpaData(java.sql.Connection conexion) {
        this.con = conexion;
    }
    public DiaDeSpaData(){
      String url = "jdbc:mariadb://localhost:3306/spa_grupo_8";
        String usuario = "root";
        String password = "";

        try {
            Conexion conAux = new Conexion(url, usuario, password);
            this.con = conAux.buscarConexion();
            
            if (this.con == null) {
            throw new SQLException("La conexión falló. Revise credenciales o estado del servidor de BD.");
        }
        } catch (Exception e) {
            System.err.print("Error al conectar" + e.getMessage());
        }
        if (this.con == null) {
            throw new RuntimeException("Fallo Crítico: La conexión a la base de datos es nula. Revise los parámetros del constructor o la clase Conexion.");
        }
    
}

    private List<DiaDeSpa> listaspa = new ArrayList<>();

    public void Crear(DiaDeSpa diadespa) {
  String sql = "INSERT INTO `dia_de_spa`(`codPack`, `fechaYHora`, `preferencias`, `codCliente`,`estado`,`estadoPago`) VALUES (?,?,?,?,?,?)"; 

    // Usamos try-with-resources, lo que cierra ps y con (si con fuera local)
    try (PreparedStatement ps = con.prepareStatement(sql)){
        
        ps.setInt(1, diadespa.getCodPack());
        ps.setTimestamp(2, java.sql.Timestamp.valueOf(diadespa.getFechaHora()));
        ps.setString(3, diadespa.getPreferencia());
        ps.setInt(4,diadespa.getCodCliente());
        ps.setBoolean(5,diadespa.isEstado());
        ps.setBoolean(6,diadespa.isEstadoPago());
        
        // CORRECCIÓN B: ¡Ejecutar la consulta!
        int filasAfectadas = ps.executeUpdate(); 
        
        if (filasAfectadas > 0) {
            System.out.println("✅ Dia de Spa agregado correctamente.");
        } else {
            System.out.println("⚠️ Advertencia: No se insertaron filas en la BD.");
        }
        
        // El ps.close() dentro del try-with-resources es redundante, lo puedes quitar.
        
    } catch (SQLException e) {
        System.out.println("❌ Error al guardar Dia de Spa: " + e.getMessage());
        throw new RuntimeException("Error al guardar Dia de Spa en la BD: " + e.getMessage());
    }
    }

    
    public void borrarDiadeSpa(int codPack) {
        try {
            String sql = "DELETE FROM `dia_de_spa` WHERE codPack = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codPack);
            ps.executeUpdate();
            ps.close();
            System.out.println("Dia de Spa borrado con exito");
        } catch (SQLException ex) {
            System.out.println("Error al borrar dia de spa" + ex.getMessage());
        }
    }

    public void AsociarSesiones(DiaDeSpa diadespa) {
    /*    System.out.println("Asociar sesiones al Dia de Spa " + diadespa.getCodPack());

        List<SesionTurno> sesioneslist = diadespa.getSesiones();
        if (sesioneslist == null || sesioneslist.isEmpty()) {
            System.out.println("No hay sesiones cargadas para este dia. ");
            return;

        }
        for (SesionTurno sesionTurno : sesioneslist) {
            System.out.println("Sesion " + sesionTurno.getCodSesion());
            System.out.println("Inicio " + sesionTurno.getFechaHoraInicio());
            System.out.println("Instalaciones: " + sesionTurno.getInstalacioneslist());
            
        }*/
    }

    public void CalcularMonto(DiaDeSpa diadespa) {
     /*   double total= 0 ;
        List<SesionTurno> sesionTurnos = diadespa.getSesiones();
        if (sesionTurnos != null) {
            for (SesionTurno sesionconTurno : sesionTurnos) {
                total +=0; //no se que precio poner
                
            }
            
        }
*/
    }

    public void ListarDias(DiaDeSpa diadespa) {

       System.out.println("Dias de spa");
        if (listaspa.isEmpty()) {
            System.out.println("Aun no hay dias de spa registrados. ");
            return;

        }
        for (DiaDeSpa diaDeSpa : listaspa) {
            System.out.println("Codigo: " + diaDeSpa.getCodPack());
            System.out.println("Cliente: " + diaDeSpa.getCodCliente());
            System.out.println("fecha: " + diaDeSpa.getFechaHora());
            System.out.println("Preferencia: " + diaDeSpa.getPreferencia());

        }

    }

    /*public void MostrarDetalle(DiaDeSpa diadespa) {
        System.out.println("Detalle del Dia de Spa " + diadespa.getCodPack());
        System.out.println("Cliente: " + diadespa.getCodCliente() + "Fecha: " + diadespa.getFechaHora() + "Preferencia: " + diadespa.getPreferencia());

        if (diadespa.getCodSesion()== null || diadespa.getCodSesion().isEmpty()) {

        } else {
            for (SesionTurno sesiones : diadespa.getCodSesion()) {
                System.out.println("Sesion " + sesiones.getCodSesion() + " Inicio: " + sesiones.getFechaHoraInicio() + "Instalaciones: " + sesiones.getInstalacioneslist());

            }
        }
    }*/
    

public DiaDeSpa buscarPorCodigo(int codPack) {
    DiaDeSpa dia = null;
    
    String sql = "SELECT * FROM dia_de_spa WHERE codPack = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codPack);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            dia = new DiaDeSpa(
                rs.getInt("codPack"),
                rs.getTimestamp("fechaYHora").toLocalDateTime(),
                rs.getString("preferencias"),
                rs.getInt("codCliente"),
                rs.getBoolean("estado"),
                rs.getBoolean("estadoPago")
            );
        }
        
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al buscar Día de Spa: " + ex.getMessage());
    }
    
    return dia;
}

public List<DiaDeSpa> buscarPorCliente(int codCliente) {
    List<DiaDeSpa> encontrados = new ArrayList<>();
    
    String sql = "SELECT * FROM dia_de_spa WHERE codCliente = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codCliente);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            
            DiaDeSpa d = new DiaDeSpa(
                rs.getInt("codPack"),
                rs.getTimestamp("fechaYHora").toLocalDateTime(),
                rs.getString("preferencias"),
                rs.getInt("codCliente"),
                rs.getBoolean("estado"),
                rs.getBoolean("estadoPago")
            );
            
            // COMPLETAR CLIENTE
            ClienteData cd = new ClienteData();
            Cliente c = cd.buscarClientePorId(codCliente);
            d.setCliente(c);
            encontrados.add(d);
        }
        
        ps.close();
        
    } catch (SQLException ex) {
        System.out.println("Error en buscarPorCliente(): " + ex.getMessage());
    }
    
    return encontrados;
}


}
