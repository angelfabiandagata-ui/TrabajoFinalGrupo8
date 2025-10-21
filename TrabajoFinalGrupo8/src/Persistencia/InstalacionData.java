package Persistencia;

import Modelo.Conexion;
import Modelo.SesionTurno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import org.mariadb.jdbc.Statement;

public class InstalacionData {

    private Connection con = null;

    public InstalacionData(java.sql.Connection conexion) {
        this.con = conexion;
    }

    public InstalacionData() {
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

//    public void AltaInstalacion(){
//        
//    }
//    public void BajaInstalacion(){
//        
//    }
//    public void ModificarInstalacion(){
//        
//    }
public void CrearSesionIns(SesionTurno ses) {
    String sql = "INSERT INTO sesion (fechaHoraInicio, fechaHoraFin, tratamiento, consultorio, masajista, instalaciones, diaDeSpa, estado) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

       
        ps.setTimestamp(1, Timestamp.valueOf(ses.getFechaHoraInicio())); 
        ps.setTimestamp(2, Timestamp.valueOf(ses.getFechaHoraFin()));
        ps.setString(3, ses.getTratamiento());
        ps.setString(4, ses.getConsultorio());
        ps.setString(5, ses.getMasajista());

      
        if (ses.getInstalacionesList() != null && !ses.getInstalacionesList().isEmpty()) {
            List<String> nombresInst = new ArrayList<>();
            for (Instalacion i : ses.getInstalacionesList()) {
                nombresInst.add(i.getNombre());
            }
            ps.setString(6, String.join(",", nombresInst));
        } else {
            ps.setString(6, "");
        }

        // 3️⃣ Día del spa (LocalDate → SQL DATE)
        ps.setDate(7, Date.valueOf(ses.getDiaDeSpa()));

        // 4️⃣ Estado
        ps.setBoolean(8, ses.isEstado());

        // 5️⃣ Ejecutamos la inserción
        ps.executeUpdate();

        // 6️⃣ Obtenemos la clave generada (si la tabla tiene autoincremento)
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                ses.setCodSesion(rs.getInt(1));
            }
        }

        System.out.println("Sesión registrada correctamente.");

    } catch (SQLException ex) {
        System.out.println("Error al registrar la sesión: " + ex.getMessage());
    }
}

//
//    public List<Instalacion> ListarInstalaciones() {
//
//    }
//
//    public List<Instalacion> ListarInstalacionesMasSolicitadas() {
//
//    }
}
