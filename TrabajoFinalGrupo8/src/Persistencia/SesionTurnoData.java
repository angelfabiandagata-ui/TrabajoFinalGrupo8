package Persistencia;

import Modelo.Conexion;
import Modelo.Instalacion;
import Modelo.Masajista;
import Modelo.SesionTurno;
import Modelo.Tratamiento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Modelo.Tratamiento;
import com.sun.net.httpserver.Authenticator;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.naming.spi.DirStateFactory;


public class SesionTurnoData {

    private Connection con = null;

    public SesionTurnoData(java.sql.Connection conexion) {
        this.con = conexion;
    }

    public SesionTurnoData() {
        String url = "jdbc:mysql://localhost:3306/sgulp_equipo_8";
        String usuario = "root";
        String password = "";

        try {
            Conexion conAux = new Conexion(url, usuario, password);
            this.con = conAux.buscarConexion();
        } catch (Exception e) {
            System.err.print("Error al conectar base de datos");
        }

    }

    public void crearSesion(SesionTurno sesionturno) {
        String sql = "INSERT INTO `sesion`(`codSesion`, `fechaHoraInicio`, `fechaHoraFin`, `codTratamiento`, `nroConsultorio`, `matricula`, `codInstalacion`, `codPack`, `estado`) VALUES "
                + "(?,?,?,?,?,?,?,?,?)";
        String sqlInstalacion = "INSERT INTO `sesion_instalacion`(`codSesion`, `codInstalacion`) VALUES (?,?)";
       try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sesionturno.getCodSesion());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraInicio()));
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraFin()));
            ps.setInt(4, sesionturno.getTratamiento().getCodTratamiento());
            ps.setInt(5, sesionturno.getConsultorio().getNroConsultorio());
            ps.setLong(6, sesionturno.getMasajista().getMatricula());
            ps.setArray(7, (Array) sesionturno.getInstalacionesList());
            ps.setDate(8, java.sql.Date.valueOf(sesionturno.getDiaDeSpa()));
            ps.setBoolean(9, sesionturno.getEstado());

            ps.executeUpdate();
            ps.close();
            
            PreparedStatement psInstalacion = con.prepareStatement(sqlInstalacion);
            for (Instalacion inst : sesionturno.getInstalacioneslist()) {
               psInstalacion.setInt(1, sesionturno.getCodSesion());
               psInstalacion.setInt(2, inst.getCodInstal());
               psInstalacion.executeUpdate();
           }
            
            System.out.println("Sesion creada con exito");
           
        } catch (SQLException ex) {
            System.out.println("Error al crear excepcion" + ex.getMessage());
        }
    }

    public void Modificar(SesionTurno sesionturno) {
        String sql = "UPDATE `sesion` SET `fechaHoraInicio`=?,`fechaHoraFin`=?,`codTratamiento`=?,`nroConsultorio`=?,`matricula`=?,estado=? WHERE codSesion = ?";
        String sqlDelete = "DELETE FROM sesion WHERE codSesion = ?";
        String sqlInsert = "INSERT INTO sesion (codSesion, codInstalacion) VALUES (?, ?)";

       try {

            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement psDelete = con.prepareStatement(sqlDelete);
            PreparedStatement psInsert = con.prepareStatement(sqlInsert);
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraInicio()));
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraFin()));
            ps.setInt(3, sesionturno.getTratamiento().getCodTratamiento());
            ps.setInt(4, sesionturno.getConsultorio().getNroConsultorio());
            ps.setLong(5, sesionturno.getMasajista().getMatricula());
            ps.setBoolean(6, sesionturno.getEstado());
            ps.setInt(7, sesionturno.getCodSesion());
            ps.executeUpdate();

            psDelete.setInt(1, sesionturno.getCodSesion());
            psDelete.executeUpdate();

            for (Instalacion inst : sesionturno.getInstalacionesList()) {
                psInsert.setInt(1, sesionturno.getCodSesion());
                psInsert.setInt(2, inst.getCodInstal());
                psInsert.executeUpdate();
            }

            System.out.println("Sesion correctamente modificada :)");
        } catch (SQLException ex) {
            System.out.println("Error al crear masajsita" + ex.getMessage());

        }
    }

    public void ListarSesionesXDia(LocalDate fecha) throws SQLException {
        System.out.println("Sesiones del dia: " + fecha);
        
        String sql = "SELECT codSesion, fechaHoraInicio, fechaHoraFin, codTratamiento, nroConsultorio, matricula, estado \"\n" +
"                   + FROM sesion WHERE DATE(fechaHoraInicio) = ?";
        
        boolean encontrado = false;
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setDate(1, java.sql.Date.valueOf(fecha));
        
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    System.out.println("Codigo de sesion: " + rs.getInt("codSesion"));
                System.out.println("Hora de inicio: " + rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                System.out.println("Hora de finalizacion:" + rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                System.out.println("Tratamiento:" + rs.getInt("codTratamiento"));
                System.out.println("Consultorio:" + rs.getInt("nroConsultorio"));
                System.out.println("Masajista:" + rs.getLong("matricula"));
                System.out.println("Instalaciones: " + rs.getBoolean("estado"));
                encontrado = true;
            }
     
 
            } catch (SQLException ex) {
                System.out.println("Erros al listar sesiones" + ex.getMessage());
        }
            if (!encontrado) {

                System.out.println("No hay sesiones agendadas para la fecha.");
            }

        }

    }

    public void ListarMasajitas(SesionTurno listamasajistas) {
        System.out.println("Lista de masajistas: " + listamasajistas);

        String sql = "SELECT matricula, nombreyapellido, telefono, especialidad, estado FROM masajista";

        boolean encontrado = false;

try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                System.out.println("-----------------------");
                System.out.println(" Matricula: " + rs.getLong("matricula"));
                System.out.println(" Nombre y Apellido: " + rs.getString("nombreyapellido"));
                System.out.println(" Telefono: " + rs.getString("telefono"));
                System.out.println(" Especialidad: " + rs.getString("especialidad"));
                System.out.println(" Estado: " + rs.getBoolean("estado"));
                encontrado = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar masajistas: " + ex.getMessage());
        }
        
        if (!encontrado) {
            System.out.println("No hay masajistas encontrados.");
        }
    }

    public void ListarTratamientos(SesionTurno listadetratamientos) {
        System.out.println("Lista de tratamientos " + listadetratamientos);
String sql = "SELECT codTratamiento, nombre, detalle, duracion, costo, estado FROM tratamiento";

        boolean encontrado = false;
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                System.out.println("-----------------------");
                System.out.println(" Codigo: " + rs.getInt("codTratamiento"));
                System.out.println(" Nombre: " + rs.getString("nombre"));
                System.out.println(" Detalle: " + rs.getString("detalle"));
                System.out.println(" Duracion: " + rs.getString("duracion")); // Asumo String (ej. "30 min")
                System.out.println(" Costo: $" + rs.getDouble("costo"));
                System.out.println(" Estado: " + rs.getBoolean("estado"));
                encontrado = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar tratamientos: " + ex.getMessage());
        }

        if (!encontrado) {
            System.out.println("No hay tratamientos encontrados.");
        }
    }

    public void ListarInstalaciones(SesionTurno sesionturno) {

    }

    public void AsignarMasajistaSegunEspecialidad(SesionTurno sesionturno) {

    }

        /*    
        } catch (SQLException ex) {
            System.out.println("Error al crear excepcion" +ex.getMessage());
        }
}
   public void Modificar (SesionTurno sesionturno){
       String sql = "UPDATE `sesion` SET `fechaHoraInicio`=?,`fechaHoraFin`=?,`codTratamiento`=?,`nroConsultorio`=?,`matricula`=?,estado=? WHERE codSesion = ?";
       String sqlDeleteInstalacion = "DELETE FROM sesion_instalacion WHERE codSesion = ?";
    String sqlInsertInstalacion = "INSERT INTO sesion_instalacion (codSesion, codInstalacion) VALUES (?, ?)";
       
           try {
               
               PreparedStatement ps =con.prepareStatement(sql);
               
               
               ps.setTimestamp(1, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraInicio()));
               ps.setTimestamp(2, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraFin()));
               ps.setInt(3, sesionturno.getTratamiento().getCodTratamiento());
               ps.setInt(4, sesionturno.getConsultorio().getNroConsultorio());
               ps.setLong(5, sesionturno.getMasajista().getMatricula());
               ps.setBoolean(6, sesionturno.getEstado());
               ps.setInt(7, sesionturno.getCodSesion());
               
               ps.executeUpdate();
               ps.close();

               PreparedStatement psDelete = con.prepareStatement(sqlDeleteInstalacion);
               psDelete.setInt(1, sesionturno.getCodSesion());
               psDelete.executeUpdate();
               psDelete.close();
               
             PreparedStatement psInsert = con.prepareStatement(sqlInsertInstalacion);
               for (Instalacion  inst : sesionturno.getInstalacionesList()) {
                   psInsert.setInt(1, sesionturno.getCodSesion());
                   psInsert.setInt(2, inst.getCodInstal());
                   psInsert.executeUpdate();
               }
               psInsert.close();
                
               System.out.println("Sesion correctamente modificado :)");
           } catch (SQLException ex) {
               System.out.println("Error al modificar sesion " + ex.getMessage());
            
           }
       }
    

   
      public Map<String, Integer> ListarSesionesXDia(){
        String sql = "SELECT DATE(fechaHoraInicio) AS dia, COUNT(*) AS total_sesiones " +
                 "FROM sesion " + 
                 "GROUP BY dia " +
                 "ORDER BY dia ASC";
        Map<String, Integer>  reporte = new HashMap<>();
        
          
        
          try {
              PreparedStatement ps = con.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              
              
              while (rs.next()) {                  
                  String dia = rs.getString("Dia");
                  int total = rs.getInt("total-sesiones");
                  
                  reporte.put(dia, total);
              }
              
          } catch (SQLException e) {
              System.out.println("Error al listar por dia" + e.getMessage());
          }
       return reporte;
      }

     public void ListarMasajitas(SesionTurno sesionturno){
    
}
     
     public void ListarTratamientos(SesionTurno sesionturno){
    
}
     
    public void ListarInstalaciones(SesionTurno sesionturno){
    
}
    
     public void AsignarMasajistaSegunEspecialidad(SesionTurno sesionturno){
    
}
>>>>>>> 816970a54fb94f767e84bb56242e04be9a7674f9*/
}
