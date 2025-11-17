
package Modelo;

public class Instalacion {
    //Atributos
    private int codInstalacion;
    private String nombre;
    private String detalleUso;
    private double precio30min;
    private boolean estado;
    //Constructores
    public Instalacion() {
    }

    public Instalacion(int codInstal, String nombre, String detalleUso, double precio30min, boolean estado) {
        this.codInstalacion = codInstal;
        this.nombre = nombre;
        this.detalleUso = detalleUso;
        this.precio30min = precio30min;
        this.estado = estado;
    }
    //Getters y Setters
    public int getCodInstal() {
        return codInstalacion;
    }

    public void setCodInstal(int codInstal) {
        this.codInstalacion = codInstal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalleUso() {
        return detalleUso;
    }

    public void setDetalleUso(String detalleUso) {
        this.detalleUso = detalleUso;
    }

    public double getPrecio30min() {
        return precio30min;
    }

    public void setPrecio30min(double precio30min) {
        this.precio30min = precio30min;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
