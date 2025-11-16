
package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DiaDeSpa {
    private int codPack;
    private LocalDateTime  fechaHora;
    private String preferencia;
    private int codCliente;
    private boolean estado;
    private boolean estadoPago;

    public DiaDeSpa(int codPack, LocalDateTime fechaHora, String preferencia, int codCliente,boolean estado, boolean estadoPago) {
        this.codPack = codPack;
        this.fechaHora = fechaHora;
        this.preferencia = preferencia;
        this.codCliente = codCliente;
        this.estado = estado;
        this.estadoPago = estadoPago;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public boolean isEstado() {
        return estado;
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public int getCodCliente() {
        return codCliente;
    }

    public void setCliente(int codCliente) {
        this.codCliente = codCliente;
    }


    @Override
    public String toString() {
        return "Dia-De-Spa " + "codPack=" + codPack + ", fechaHora=" + fechaHora + ", preferencia=" + preferencia + ", cliente=" + codCliente + ", estado=" + estado + ", estadoPago=" + estadoPago + '}';
    } 
        
}
