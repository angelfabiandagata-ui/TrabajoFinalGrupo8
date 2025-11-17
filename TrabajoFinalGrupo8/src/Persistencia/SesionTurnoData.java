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
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        String url = "jdbc:mariadb://localhost:3306/spa_grupo_8";
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
     
    String sqlTratamiento = "INSERT INTO `sesion`(`codSesion`, `fechaHoraInicio`, `fechaHoraFin`, `codTratamiento`, `nroConsultorio`, `matricula`, `codPack`, `estado`, `monto`) "
            + "VALUES (?,?,?,?,?,?,?,?,?)"; 
    
    String sqlInstalacion = "INSERT INTO `sesion`(`codSesion`, `fechaHoraInicio`, `fechaHoraFin`, `codInstalacion`, `codPack`, `estado`, `monto`) "
            + "VALUES (?,?,?,?,?,?,?)"; 

    String sql = "";
    boolean esInstalacion = sesionturno.getCodInstalacion() != null;

    // Asignamos el SQL correcto y definimos la lógica de inserción
    if (esInstalacion) {
        sql = sqlInstalacion;
        System.out.println("DEBUG: Creando sesión de Instalación.");
    } else {
        sql = sqlTratamiento;
        System.out.println("DEBUG: Creando sesión de Tratamiento/Turno.");
    }

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        
        // Parámetros comunes (Índices 1, 2 y 3)
        ps.setInt(1, sesionturno.getCodSesion());
        ps.setTimestamp(2, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraInicio()));
        ps.setTimestamp(3, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraFin()));
        
        int offset = 3; 

        if (esInstalacion) {
            // Caso Instalación: Insertamos Instalacion, luego Pack, Estado, Monto
            // 4. codInstalacion
            ps.setInt(++offset, sesionturno.getCodInstalacion().getCodInstal()); 
            
        } else {
            // Caso Tratamiento: Insertamos Tratamiento, Consultorio, Masajista
            // 4. codTratamiento
            ps.setInt(++offset, sesionturno.getCodTratamiento().getCodTratamiento());
            // 5. nroConsultorio
            ps.setInt(++offset, sesionturno.getNroConsultorio().getNroConsultorio());
            // 6. matricula
            ps.setLong(++offset, sesionturno.getMatricula().getMatricula());
        }

        // Parámetros comunes restantes (Pack, Estado, Monto)
        // Siguen al último índice asignado, ya sea 6 (Tratamiento) o 4 (Instalacion)
        ps.setInt(++offset, sesionturno.getCodPack()); 
        ps.setBoolean(++offset, sesionturno.getEstado());
        ps.setDouble(++offset, sesionturno.getMonto());

        ps.executeUpdate();
        
        System.out.println("Sesion creada con exito");

    } catch (SQLException ex) {
        System.out.println("Error al crear la sesión: " + ex.getMessage());
        // Manejar o relanzar la excepción
    }
        
        
        
      
        
        /*  String sql = "INSERT INTO `sesion`(`codSesion`, `fechaHoraInicio`, `fechaHoraFin`, `codTratamiento`, `nroConsultorio`, `matricula`, `codInstalacion`, `codPack`, `estado`,`monto`) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?)";
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
        }*/
    }

    public void Modificar(SesionTurno sesionturno) {
       
      String sql = "UPDATE `sesion` SET "
            + "`fechaHoraInicio`=?, `fechaHoraFin`=?, " 
            + "`codTratamiento`=?, `nroConsultorio`=?, `matricula`=?, " // Campos de Tratamiento
            + "`codInstalacion`=?, `codPack`=?, `estado`=?, `monto`=? " // Campos de Instalación/Comunes
            + "WHERE `codSesion` = ?"; // 10 parámetros
    
    // 2. Determinamos el tipo de sesión
    // Usamos Instalacion para determinar si es sesión de Instalación (TRUE) o Tratamiento (FALSE)
    boolean esInstalacion = sesionturno.getCodInstalacion() != null; 

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        
        // --- 1. CONFIGURACIÓN DEL UPDATE ---
        
        // Parámetros 1 y 2: Comunes
        ps.setTimestamp(1, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraInicio()));
        ps.setTimestamp(2, java.sql.Timestamp.valueOf(sesionturno.getFechaHoraFin()));
        
        int paramIndex = 2; // Inicia después de fechaHoraFin
        
        if (esInstalacion) {
            System.out.println("DEBUG: Modificando sesión como tipo Instalación.");
            
            // Parámetros 3, 4, 5: Campos de Tratamiento (Se establecen a NULL)
            ps.setNull(++paramIndex, java.sql.Types.INTEGER); // codTratamiento
            ps.setNull(++paramIndex, java.sql.Types.INTEGER); // nroConsultorio
            ps.setNull(++paramIndex, java.sql.Types.BIGINT);  // matricula
            
            // Parámetro 6: codInstalacion (Se rellena)
            ps.setInt(++paramIndex, sesionturno.getCodInstalacion().getCodInstal()); 
            
        } else {
            System.out.println("DEBUG: Modificando sesión como tipo Tratamiento/Turno.");

            // Parámetros 3, 4, 5: Campos de Tratamiento (Se rellenan)
            ps.setInt(++paramIndex, sesionturno.getCodTratamiento().getCodTratamiento());
            ps.setInt(++paramIndex, sesionturno.getNroConsultorio().getNroConsultorio());
            ps.setLong(++paramIndex, sesionturno.getMatricula().getMatricula());
            
            // Parámetro 6: codInstalacion (Se establece a NULL)
            ps.setNull(++paramIndex, java.sql.Types.INTEGER);
        }

        // Parámetros 7, 8, 9: Comunes restantes (codPack, estado, monto)
        ps.setInt(++paramIndex, sesionturno.getCodPack());
        ps.setBoolean(++paramIndex, sesionturno.getEstado());
        ps.setDouble(++paramIndex, sesionturno.getMonto());
        
        // Parámetro 10: WHERE Clause
        ps.setInt(++paramIndex, sesionturno.getCodSesion());

        // --- 2. EJECUCIÓN Y CIERRE ---
        ps.executeUpdate();
        
        System.out.println("Sesion correctamente modificada :)");
        
    } catch (SQLException ex) {
        System.out.println("Error al modificar sesión: " + ex.getMessage());
        // En un entorno real, es vital manejar la excepción para hacer rollback si usas transacciones
    }  
        
        
        
        
        
        
        
        
        
        /*String sql = "UPDATE `sesion` SET `fechaHoraInicio`=?,`fechaHoraFin`=?,`codTratamiento`=?,`nroConsultorio`=?,`matricula`=?,estado=? WHERE codSesion = ?";
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

        }*/
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


    public void ListarMasajitas() {
        System.out.println("Lista de masajistas: " );
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

    public void ListarTratamientos() {
        System.out.println("Lista de tratamientos " );
String sql = "SELECT codTratamiento, nombre, detalle, duracion, costo, estado FROM tratamiento";

        boolean encontrado = false;
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                System.out.println("-----------------------");
                System.out.println(" Codigo: " + rs.getInt("codTratamiento"));
                System.out.println(" Nombre: " + rs.getString("nombre"));
                System.out.println(" Detalle: " + rs.getString("detalle"));
                System.out.println(" Duracion: " + rs.getString("duracion"));
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

    public void ListarInstalaciones() {
        System.out.println("Lista instalaciones");
    String sql = "Select codInstalacion, nombre, estado from instalacion";
    boolean encontrado = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Codigo: " + rs.getInt("codInstalacion"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Estafo: " + rs.getBoolean("estado") );
                encontrado=true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar instalaciones");
        }
        if (!encontrado) {
            System.out.println("No hay instalaciones");
        }
    }
    

    public void AsignarMasajistaSegunEspecialidad(SesionTurno sesionturno) {

    }
//     public boolean estaConsultorioOcupado(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, int nroConsultorio) {
//        String sql = "SELECT * FROM sesion WHERE nroConsultorio = ? AND estado = 1 AND "
//                   + "((fechaHoraInicio < ? AND fechaHoraFin > ?) OR "
//                   + "(fechaHoraInicio >= ? AND fechaHoraInicio < ?) OR "
//                   + "(fechaHoraFin > ? AND fechaHoraFin <= ?))";
//        
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, nroConsultorio);
//            ps.setTimestamp(2, java.sql.Timestamp.valueOf(fechaHoraFin));
//            ps.setTimestamp(3, java.sql.Timestamp.valueOf(fechaHoraInicio));
//            ps.setTimestamp(4, java.sql.Timestamp.valueOf(fechaHoraInicio));
//            ps.setTimestamp(5, java.sql.Timestamp.valueOf(fechaHoraFin));
//            ps.setTimestamp(6, java.sql.Timestamp.valueOf(fechaHoraInicio));
//            ps.setTimestamp(7, java.sql.Timestamp.valueOf(fechaHoraFin));
//            
//            ResultSet rs = ps.executeQuery();
//            return rs.next();             
//        } catch (SQLException ex) {
//            System.out.println("Error al validar consultorio: " + ex.getMessage());
//            return true; 
//}
//    }
//     
//       public boolean estaInstalacionOcupada(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, int nroConsultorio) {
//        String sql = "SELECT * FROM sesion s "
//                   + "INNER JOIN sesion_instalacion si ON s.codSesion = si.codSesion "
//                   + "WHERE si.codInstalacion = ? AND s.estado = 1 AND "
//                   + "((s.fechaHoraInicio < ? AND s.fechaHoraFin > ?) OR "
//                   + "(s.fechaHoraInicio >= ? AND s.fechaHoraInicio < ?) OR "
//                   + "(s.fechaHoraFin > ? AND s.fechaHoraFin <= ?))";
//        
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, nroConsultorio);
//            ps.setTimestamp(2, java.sql.Timestamp.valueOf(fechaHoraFin));
//            ps.setTimestamp(3, java.sql.Timestamp.valueOf(fechaHoraInicio));
//            ps.setTimestamp(4, java.sql.Timestamp.valueOf(fechaHoraInicio));
//            ps.setTimestamp(5, java.sql.Timestamp.valueOf(fechaHoraFin));
//            ps.setTimestamp(6, java.sql.Timestamp.valueOf(fechaHoraInicio));
//            ps.setTimestamp(7, java.sql.Timestamp.valueOf(fechaHoraFin));
//            
//            ResultSet rs = ps.executeQuery();
//            return rs.next();             
//        } catch (SQLException ex) {
//            System.out.println("Error al validar isntalacion: " + ex.getMessage());
//            return true; 
//}
//    }
//
//    
//    public List<LocalDateTime> obtenerHoraiosDisponi_Consul(LocalDate fecha, int nroConsultorio, int duracionMinutos){
//        List<LocalDateTime> horariosDisponibles = new ArrayList<>();
//        LocalTime inicioDia = LocalTime.of(9,0); //abre el spa
//        LocalTime finDia = LocalTime.of(22,0); // cierrra el spa
//        
//        LocalDateTime fechayhotaActual = fecha.atTime(inicioDia);
//        
//        while (fechayhotaActual.toLocalTime().isBefore(finDia)) {            
//            LocalDateTime fechaHoraFin = fechayhotaActual.plusMinutes(duracionMinutos);
//            
//            if (!estaConsultorioOcupado(fechaHoraFin, fechaHoraFin, nroConsultorio)) {
//                horariosDisponibles.add(fechayhotaActual);
//            }
//            fechayhotaActual = fechayhotaActual.plusMinutes(30); // media hora por consultorio
//        }
//        return  horariosDisponibles;
//    }
//    
//     public List<LocalDateTime> obtenerHoraiosDisponi_Instalacion(LocalDate fecha, int nroConsultorio, int duracionMinutos){
//        List<LocalDateTime> horariosDisponibles = new ArrayList<>();
//        LocalTime inicioDia = LocalTime.of(9,0); //abre el spa
//        LocalTime finDia = LocalTime.of(22,0); // cierrra el spa
//        
//        LocalDateTime fechayhotaActual = fecha.atTime(inicioDia);
//        
//        while (fechayhotaActual.toLocalTime().isBefore(finDia)) {            
//            LocalDateTime fechaHoraFin = fechayhotaActual.plusMinutes(duracionMinutos);
//            
//            if (!estaConsultorioOcupado(fechaHoraFin, fechaHoraFin, nroConsultorio)) {
//                horariosDisponibles.add(fechayhotaActual);
//            }
//            fechayhotaActual = fechayhotaActual.plusMinutes(60); //Una hora por instalacon
//        }
//        return  horariosDisponibles;
//    }
//     
//     public boolean ValidarDisponivilidad(SesionTurno sesionTurno){
//         if (sesionTurno.getConsultorio() != null) {
//             if (estaConsultorioOcupado(sesionTurno.getFechaHoraInicio(), sesionTurno.getFechaHoraFin(), sesionTurno.getConsultorio().getNroConsultorio())) {
//                 System.out.println("El consultorio esta ocupado en este horario");
//                 return false;
//             }
//         }
//          if (sesionTurno.getMasajista()!= null) {
//             if (estaConsultorioOcupado(sesionTurno.getFechaHoraInicio(), sesionTurno.getFechaHoraFin(), sesionTurno.getMasajista().getMatricula())) {
//                 System.out.println("El masajista no esta disponible en este horario");
//                 return false;
//             }
//         }
//           if (sesionTurno.getInstalacionesList()!= null) {
//               for (Instalacion instalacion : sesionTurno.getInstalacionesList()) {
//                    if (estaInstalacionOcupada(sesionTurno.getFechaHoraInicio(), sesionTurno.getFechaHoraFin(),instalacion.getCodInstal())) {
//                 System.out.println("La instalacion no esta disponible en este horario");
//                 return false;
//             }
//               }
//            
//         }
//           crearSesion(sesionTurno);
//         return true;
//     }
//    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

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
