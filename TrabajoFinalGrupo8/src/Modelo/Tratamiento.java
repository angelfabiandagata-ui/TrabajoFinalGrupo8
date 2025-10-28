package Modelo;

import java.time.LocalTime;
import java.util.List;
import java.sql.Time;

public class Tratamiento {

    private int codTratamiento;
    private String nombre;
//    private String tipo;
    private String detalle;
    private List<String> Productos;
    private Time Duracion; 
    private double costo;
    private boolean estado;

    public Tratamiento() {
    }

    public Tratamiento(int codTratam, String nombre, String tipo, String detalle, List<String> Productos, Time Duracion, double costo, boolean activo) {
        this.codTratamiento = codTratamiento;
        this.nombre = nombre;
//        this.tipo = tipo;
        this.detalle = detalle;
        this.Productos = Productos;
        this.Duracion = Duracion;
        this.costo = costo;
        this.estado = estado;
    }

    public int getCodTratamiento() {
        return codTratamiento;
    }

    public void setCodTratamiento(int codTratamiento) {
        this.codTratamiento = codTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public List<String> getProductos() {
        return Productos;
    }

    public void setProductos(List<String> Productos) {
        this.Productos = Productos;
    }

    public Time getDuracion() {
        return Duracion;
    }

    public void setDuracion(Time Duracion) {
        this.Duracion = Duracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }

}
