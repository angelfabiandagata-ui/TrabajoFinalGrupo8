
package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class SesionTurno {
    //Atributos
    private int codSesion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String tratamiento; 
    private String consultorio;
    private String masajista;
    private List<Instalacion> instalacionesList;
    private LocalDate DiaDeSpa;
    private boolean estado;




//Constructor
    public SesionTurno(int codSesion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, String tratamiento, String consultorio, String masajista, List<Instalacion> instalaciones, LocalDate diaDeSpa) {
        this.codSesion = codSesion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.tratamiento = tratamiento;
        this.consultorio = consultorio;
        this.masajista = masajista;
        this.instalacionesList = instalaciones;
        this.DiaDeSpa = diaDeSpa;
    }
//Getter and setter
    public int getCodSesion() {
        return codSesion;
    }

    public void setCodSesion(int codSesion) {
        this.codSesion = codSesion;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getMasajista() {
        return masajista;
    }

    public void setMasajista(String masajista) {
        this.masajista = masajista;
    }

    public List<Instalacion> getInstalacioneslist() {
        return instalacionesList;
    }

    public void setInstalacioneslist(List<Instalacion> instalacioneslist) {
        this.instalacionesList = instalacioneslist;
    }

    public LocalDate getDiaDeSpa() {
        return DiaDeSpa;
    }

    public void setDiaDeSpa(LocalDate diaDeSpa) {
        this.DiaDeSpa = diaDeSpa;
    }
//toString
    @Override
    public String toString() {
        return "Sesion-Turno" + "codSesion=" + codSesion + " fechaHoraInicio=" + fechaHoraInicio + " fechaHoraFin = "  + fechaHoraFin + " tratamiento = " + tratamiento + " consultorio = " + consultorio + " masajista = " + masajista + " instalaciones = " + instalacionesList + "  diaDeSpa = " + DiaDeSpa ;
    }
     
            
    
}

