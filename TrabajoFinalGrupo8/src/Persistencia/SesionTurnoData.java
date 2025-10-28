
package Persistencia;

import Modelo.Conexion;
import Modelo.Instalacion;
import Modelo.SesionTurno;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            ps.setTime(2, java.sql.Time.valueOf(sesionturno.getFechaHoraInicio()));
            ps.setTime(3, java.sql.Time.valueOf(sesionturno.getFechaHoraFin()));
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
       String sqlDelete = "DELETE FROM sesion WHERE codSesion = ?";
    String sqlInsert = "INSERT INTO sesion (codSesion, codInstalacion) VALUES (?, ?)";
       
           try {
               
               PreparedStatement ps =con.prepareStatement(sql);
               PreparedStatement psDelete = con.prepareStatement(sqlDelete);
               PreparedStatement psInsert = con.prepareStatement(sqlInsert);
               ps.setTime(1, java.sql.Time.valueOf(sesionturno.getFechaHoraInicio()));
               ps.setTime(2, java.sql.Time.valueOf(sesionturno.getFechaHoraFin()));
               ps.setInt(3, sesionturno.getTratamiento().getCodTratamiento());
               ps.setInt(4, sesionturno.getConsultorio().getNroConsultorio());
               ps.setLong(5, sesionturno.getMasajista().getMatricula());
               ps.setBoolean(6, sesionturno.getEstado());
               ps.setInt(7, sesionturno.getCodSesion());
               
               ps.executeUpdate();
               
               psDelete.setInt(1, sesionturno.getCodSesion());
               psDelete.executeUpdate();
               
               for (Instalacion  inst : sesionturno.getInstalacionesList()) {
                   psInsert.setInt(1, sesionturno.getCodSesion());
                   psInsert.setInt(2, inst.getCodInstal());
                   psInsert.executeUpdate();
                   
               }
               
               System.out.println("Masajista correctamente modificado :)");
           } catch (SQLException ex) {
               System.out.println("Error al crear masajsita" + ex.getMessage());
            
           }
       }
    

   
      public void ListarSesionesXDia(SesionTurno sesionturno){
    
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
