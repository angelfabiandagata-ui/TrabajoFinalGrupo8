
package Modelo;

import java.time.LocalDateTime;
import java.util.List;


public class DiaDeSpa {
    private int codPack;
    private LocalDateTime  fechaHora;
    private String preferencia;
    private String cliente;
    private List<SesionTurno> sesiones;
    private double monto;

    public DiaDeSpa(int codPack, LocalDateTime fechaHora, String preferencia, String cliente, List<SesionTurno> sesiones, double monto) {
        this.codPack = codPack;
        this.fechaHora = fechaHora;
        this.preferencia = preferencia;
        this.cliente = cliente;
        this.sesiones = sesiones;
        this.monto = monto;
    }

    public int getCodPack() {
        return codPack;
    }

    public void setCodPack(int codPack) {
        this.codPack = codPack;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<SesionTurno> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<SesionTurno> sesiones) {
        this.sesiones = sesiones;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Dia-De-Spa " + "codPack=" + codPack + ", fechaHora=" + fechaHora + ", preferencia=" + preferencia + ", cliente=" + cliente + ", sesiones=" + sesiones + ", monto=" + monto + '}';
    } 
        
}
