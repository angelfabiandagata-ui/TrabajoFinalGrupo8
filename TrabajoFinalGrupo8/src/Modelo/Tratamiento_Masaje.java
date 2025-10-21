
package Modelo;

import java.time.LocalTime;
import java.util.List;


public class Tratamiento_Masaje {
    private int codTratam; 
    private String nombre;
    private String detalle;
    private List<String> Productos;
    private LocalTime Duracion; //Minutos
    private double costo;
    private boolean activo;

    public Tratamiento_Masaje() {
    }

    public Tratamiento_Masaje(int codTratam, String nombre, String detalle, List<String> Productos, LocalTime Duracion, double costo, boolean activo) {
        this.codTratam = codTratam;
        this.nombre = nombre;
        this.detalle = detalle;
        this.Productos = Productos;
        this.Duracion = Duracion;
        this.costo = costo;
        this.activo = activo;
    }

    
    public int getCodTratam() {
        return codTratam;
    }

    public void setCodTratam(int codTratam) {
        this.codTratam = codTratam;
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

    public LocalTime getDuracion() {
        return Duracion;
    }

    public void setDuracion(LocalTime Duracion) {
        this.Duracion = Duracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
}
