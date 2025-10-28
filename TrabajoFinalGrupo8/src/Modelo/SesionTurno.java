
package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


public class SesionTurno {
    //Atributos
    private int codSesion;
    private LocalTime fechaHoraInicio;
    private LocalTime fechaHoraFin;
    private Tratamiento tratamiento; 
    private Consultorio consultorio;
    private Masajista masajista;
    private List<Instalacion> instalacionesList;
    private LocalDate DiaDeSpa;
    private boolean estado;




//Constructor
    public SesionTurno(int codSesion, LocalTime fechaHoraInicio, LocalTime fechaHoraFin, Tratamiento tratamiento, Consultorio consultorio, Masajista masajista, List<Instalacion> instalacionesList, LocalDate DiaDeSpa, boolean estado) {   
        this.codSesion = codSesion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.tratamiento = tratamiento;
        this.consultorio = consultorio;
        this.masajista = masajista;
        this.instalacionesList = instalacionesList;
        this.DiaDeSpa = DiaDeSpa;
        this.estado = estado;
    }

//Getter and setter
    public int getCodSesion() {
        return codSesion;
    }

    public void setCodSesion(int codSesion) {
        this.codSesion = codSesion;
    }

    public LocalTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public List<Instalacion> getInstalacionesList() {
        return instalacionesList;
    }

    public void setInstalacionesList(List<Instalacion> instalacionesList) {
        this.instalacionesList = instalacionesList;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Masajista getMasajista() {
        return masajista;
    }

    public void setMasajista(Masajista masajista) {
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

