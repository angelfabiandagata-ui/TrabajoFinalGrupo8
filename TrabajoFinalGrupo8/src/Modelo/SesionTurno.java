
package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


public class SesionTurno {
    //Atributos
    private int codSesion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Tratamiento codTratamiento; 
    private Consultorio nroConsultorio;
    private Masajista matricula;
    private Instalacion codInstalacion;
    private int codPack;
    private boolean estado;
    private double monto;




//Constructor
    public SesionTurno(int codSesion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Tratamiento codTratamiento, Consultorio nroConsultorio, Masajista matricula, Instalacion codInstalacion, int codPack, boolean estado, double monto) {   
        this.codSesion = codSesion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.codTratamiento = codTratamiento;
        this.nroConsultorio = nroConsultorio;
        this.matricula = matricula;
        this.codInstalacion = codInstalacion;
        this.codPack = codPack;
        this.estado = estado;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "SesionTurno{" + "codSesion=" + codSesion + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", codTratamiento=" + codTratamiento + ", nroConsultorio=" + nroConsultorio + ", matricula=" + matricula + ", codInstalacion=" + codInstalacion + ", codPack=" + codPack + ", estado=" + estado + ", monto=" + monto + '}';
    }

    public Tratamiento getCodTratamiento() {
        return codTratamiento;
    }

    public void setCodTratamiento(Tratamiento codTratamiento) {
        this.codTratamiento = codTratamiento;
    }

    public Consultorio getNroConsultorio() {
        return nroConsultorio;
    }

    public void setNroConsultorio(Consultorio nroConsultorio) {
        this.nroConsultorio = nroConsultorio;
    }

    public Masajista getMatricula() {
        return matricula;
    }

    public void setMatricula(Masajista matricula) {
        this.matricula = matricula;
    }

    public Instalacion getCodInstalacion() {
        return codInstalacion;
    }

    public void setCodInstalacion(Instalacion codInstalacion) {
        this.codInstalacion = codInstalacion;
    }

    public int getCodPack() {
        return codPack;
    }

    public void setCodPack(int codPack) {
        this.codPack = codPack;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public SesionTurno() {
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



    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

 
}

