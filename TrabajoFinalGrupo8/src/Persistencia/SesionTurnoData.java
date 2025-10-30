
package Persistencia;

import Modelo.Conexion;
import Modelo.Instalacion;
import Modelo.SesionTurno;
import com.sun.net.httpserver.Authenticator;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.spi.DirStateFactory;
import org.mariadb.jdbc.client.result.ResultSetMetaData;

public class SesionTurnoData {
    
      private Connection con = null;

    public SesionTurnoData(java.sql.Connection conexion) {
        this.con = conexion;
    }

    public SesionTurnoData() {
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
    
    public void crearSesion(SesionTurno sesionturno){
    String sql = "INSERT INTO `sesion`(`codSesion`, `fechaHoraInicio`, `fechaHoraFin`, `codTratamiento`, `nroConsultorio`, `matricula`, `codInstalacion`, `codPack`, `estado`) VALUES "
            + "(?,?,?,?,?,?,?,?,?)";
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
            System.out.println("Sesion creada correctamente");
            
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
}
