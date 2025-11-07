/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.security.PrivateKey;

/**
 *
 * @author Ema
 */
class Producto {
    private String nombre;
    private double precio;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto" + "  nombre: " + nombre + "\n precio:" + precio + " \ndescripcion:" + descripcion;
    }   
}
